package com.jeeapp.evaluationstagev2.model.dto;

import com.jeeapp.evaluationstagev2.model.entities.Periode;
import com.jeeapp.evaluationstagev2.model.entities.PeriodeId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeriodeDto {
    private PeriodeId periodeId;
    private String dateDebut;
    private String dateFin;

    public static PeriodeDto toDto(Periode periode) {
        if (periode == null) return null;
        return PeriodeDto.builder()
                .periodeId(periode.getId())
                .dateDebut(periode.getDateDebut())
                .dateFin(periode.getDateFin())
                .build();
    }

}

