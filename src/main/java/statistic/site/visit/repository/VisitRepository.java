package statistic.site.visit.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import statistic.site.visit.model.Visit;

import java.util.Date;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {

    Long countVisitByDateBetween(Date dateFrom, Date dateTo);

    @Query(nativeQuery = true, value = "select count(visit.id) from visit where visit.date between :dateFrom and :dateTo")
    Long findCountVisitsBetweenDates(@Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo);

    @Query(nativeQuery = true, value = "select count(count) from (select count(visit.user_id)from visit where visit.date between :dateFrom and :dateTo group by visit.user_id) as count")
    Long findCountUniqueVisitsBetweenDates(@Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo);


}
