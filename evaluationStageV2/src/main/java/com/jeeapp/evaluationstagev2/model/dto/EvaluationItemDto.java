package com.jeeapp.evaluationstagev2.model.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationItemDto {
    private String categorie;
    private String valeur;
}

