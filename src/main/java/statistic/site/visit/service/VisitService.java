package statistic.site.visit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import statistic.site.visit.dto.VisitDto;
import statistic.site.visit.model.Visit;
import statistic.site.visit.repository.VisitRepository;
import statistic.site.visit.transformer.impl.VisitTransformer;

import java.util.Date;

@Service
public class VisitService {

    private final VisitRepository visitRepository;
    private final VisitTransformer visitTransformer;

    @Autowired
    public VisitService(VisitRepository visitRepository, VisitTransformer visitTransformer) {
        this.visitRepository = visitRepository;
        this.visitTransformer = visitTransformer;
    }


    public VisitDto registerVisit(VisitDto visitDto) {
        visitDto.setDate(new Date());
        Visit savedVisit = visitRepository.save(visitTransformer.toEntity(visitDto));
        return visitTransformer.toDto(savedVisit);
    }
}
