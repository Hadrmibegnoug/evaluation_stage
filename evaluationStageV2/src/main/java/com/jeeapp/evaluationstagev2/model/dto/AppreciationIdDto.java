package com.jeeapp.evaluationstagev2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppreciationIdDto {
    private Long tuteurId;
    private PeriodeIdDto periodeId;
}
