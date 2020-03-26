package statistic.site.visit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import statistic.site.visit.dto.VisitorsPerDayDto;
import statistic.site.visit.repository.VisitRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class StatisticService {

    private final VisitRepository visitRepository;

    @Autowired
    public StatisticService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public VisitorsPerDayDto getVisitorsPerDay(Date date) {
        VisitorsPerDayDto visitorsPerDayDto = new VisitorsPerDayDto();
        Date dateTo = getEndOfDay(date);
        Date dateFrom = getStartOfDay(date);
        visitorsPerDayDto.setCountAllVisit(
                visitRepository.findCountVisitsBetweenDates(dateFrom, dateTo));
        visitorsPerDayDto.setCountUniqueVisit(
                visitRepository.findCountUniqueVisitsBetweenDates(dateFrom, dateTo));
        return visitorsPerDayDto;
    }

    private Date getStartOfDay(Date date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setGregorianChange(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private Date getEndOfDay(Date date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setGregorianChange(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

}
