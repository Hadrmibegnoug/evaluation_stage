package com.jeeapp.evaluationstagev2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PeriodeIdDto {
    private Long stage_id;
    private Long stagiaire_id;
}
