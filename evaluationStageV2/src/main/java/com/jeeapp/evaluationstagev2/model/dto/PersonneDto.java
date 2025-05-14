package com.jeeapp.evaluationstagev2.model.dto;
import com.jeeapp.evaluationstagev2.model.entities.Personne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonneDto {
    private Long personneId;
    private String nom;
    private String prenom;
    private String email;
    public static PersonneDto toDto(Personne personne) {
        if (personne == null) return null;
        return PersonneDto.builder()
                .personneId(personne.getId())
                .nom(personne.getNom())
                .prenom(personne.getPrenom())
                .email(personne.getEmail())
                .build();
    }

}

