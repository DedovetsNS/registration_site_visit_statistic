package statistic.site.visit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitorsPerDayDto {
    Long countAllVisit;
    Long countUniqueVisit;
}
