package com.jeeapp.evaluationstagev2.model.dto;

import com.jeeapp.evaluationstagev2.model.entities.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategorieDto {
    private Long id;
    private String intitule;
    private String valeur;

    public static CategorieDto toDto(Categorie categorie) {
        if (categorie == null) return null;
        return CategorieDto.builder()
                .id(categorie.getId())
                .intitule(categorie.getIntitule())
                .valeur(categorie.getValeur())
                .build();
    }

}

