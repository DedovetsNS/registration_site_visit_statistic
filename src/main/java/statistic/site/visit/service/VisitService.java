package statistic.site.visit.service;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import statistic.site.visit.dto.VisitDto;
import statistic.site.visit.repository.VisitRepository;
import statistic.site.visit.transformer.impl.VisitTransformer;

import java.util.Date;

@EnableRabbit
@Service
public class VisitService {

    private final VisitRepository visitRepository;
    private final VisitTransformer visitTransformer;
    private final AmqpTemplate template;
    private final AmqpAdmin admin;

    @Autowired
    public VisitService(VisitRepository visitRepository, VisitTransformer visitTransformer, AmqpTemplate template, AmqpAdmin admin) {
        this.visitRepository = visitRepository;
        this.visitTransformer = visitTransformer;
        this.template = template;
        this.admin = admin;
    }


    public void registerVisitInQueue(VisitDto visitDto) {
        visitDto.setDate(new Date());
        admin.declareQueue(new Queue("queue-new-visits"));
        template.convertAndSend("queue-new-visits", visitDto);
    }

    @RabbitListener(queues = "queue-new-visits")
    public void registerVisitInDB(VisitDto visitDto) {
        visitRepository.save(visitTransformer.toEntity(visitDto));
    }
}
