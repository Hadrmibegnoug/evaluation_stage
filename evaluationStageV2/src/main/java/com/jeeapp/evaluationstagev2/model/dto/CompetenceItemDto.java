package com.jeeapp.evaluationstagev2.model.dto;

import com.jeeapp.evaluationstagev2.model.entities.Competence;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetenceItemDto {
    private String intitule;
    private String note;
    private List<CategorieItemDto> categories;
}

