package com.jeeapp.evaluationstagev2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategorieItemDto {
    private String intitule;
    private String valeur;
}
