package statistic.site.visit.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import statistic.site.visit.dto.DayStatisticDto;
import statistic.site.visit.dto.PeriodDto;
import statistic.site.visit.dto.PeriodStatisticDto;
import statistic.site.visit.dto.VisitDto;
import statistic.site.visit.dto.groups.Add;
import statistic.site.visit.service.StatisticService;
import statistic.site.visit.service.VisitService;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/statistic")
public class StatisticRegistrationController {

    private final VisitService visitService;
    private final StatisticService statisticService;

    @Autowired
    public StatisticRegistrationController(VisitService visitService,
                                           StatisticService statisticService) {
        this.visitService = visitService;
        this.statisticService = statisticService;
    }

    @PostMapping
    public DayStatisticDto addVisit(@RequestBody @Validated({Add.class}) VisitDto visitDto) {
        visitService.registerVisit(visitDto);
        return statisticService.getStatisticPerDay(new Date());
    }

    @GetMapping
    public PeriodStatisticDto getPeriodStatistic(@RequestBody @Validated({Add.class}) PeriodDto periodDto) {
        return statisticService.getStatisticPerPeriod(periodDto);
    }
}
