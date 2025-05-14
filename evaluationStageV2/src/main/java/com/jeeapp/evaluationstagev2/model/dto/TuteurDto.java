package com.jeeapp.evaluationstagev2.model.dto;

import com.jeeapp.evaluationstagev2.model.entities.Tuteur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TuteurDto extends PersonneDto {
    private Long tuteurId;
    private String nom;
    private String prenom;
    private String email;
    private String entreprise;
    public static TuteurDto toDto(Tuteur tuteur) {
        if (tuteur == null) return null;
        return TuteurDto.builder()
                .tuteurId(tuteur.getId())
                .nom(tuteur.getNom())
                .prenom(tuteur.getPrenom())
                .email(tuteur.getEmail())
                .entreprise(tuteur.getEntreprise())
                .build();
    }

}

