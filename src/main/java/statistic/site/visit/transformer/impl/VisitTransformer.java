package statistic.site.visit.transformer.impl;

import org.springframework.stereotype.Component;
import statistic.site.visit.dto.VisitDto;
import statistic.site.visit.model.Visit;
import statistic.site.visit.transformer.Transformer;

@Component
public class VisitTransformer implements Transformer<Visit, VisitDto> {
    @Override
    public Visit toEntity(VisitDto dto) {
        Visit entity = new Visit();
        entity.setId(dto.getId());
        entity.setUserId(dto.getUserId());
        entity.setPageId(dto.getPageId());
        entity.setDate(dto.getDate());
        return entity;
    }

    @Override
    public VisitDto toDto(Visit entity) {
        VisitDto dto = new VisitDto();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setPageId(entity.getPageId());
        dto.setDate(entity.getDate());
        return dto;
    }
}
