package statistic.site.visit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import statistic.site.visit.dto.groups.Add;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitDto {

    @Null(groups = {Add.class})
    private Long id;

    @NotNull(groups = {Add.class})
    private String userId;

    @NotNull(groups = {Add.class})
    private String pageId;

    @Null(groups = {Add.class})
    private Date date;

}
