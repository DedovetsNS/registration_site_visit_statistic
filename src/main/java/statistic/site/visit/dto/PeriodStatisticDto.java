package statistic.site.visit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeriodStatisticDto {

    Long countAllVisit;
    Long countUniqueVisit;
    Long countRegularUser;
}
