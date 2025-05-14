package com.jeeapp.evaluationstagev2.model.dto;

import com.jeeapp.evaluationstagev2.model.entities.Stagiaire;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StagiaireDto extends PersonneDto {
    private Long stagiaireId;
    private String nom;
    private String prenom;
    private String email;
    private String institution;
    public static StagiaireDto toDto(Stagiaire stagiaire) {
        if (stagiaire == null) return null;
        return StagiaireDto.builder()
                .stagiaireId(stagiaire.getId())
                .nom(stagiaire.getNom())
                .prenom(stagiaire.getPrenom())
                .email(stagiaire.getEmail())
                .institution(stagiaire.getInstitution())
                .build();
    }

}
