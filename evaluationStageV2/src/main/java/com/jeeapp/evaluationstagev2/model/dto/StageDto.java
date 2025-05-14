package com.jeeapp.evaluationstagev2.model.dto;

import com.jeeapp.evaluationstagev2.model.entities.Stage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StageDto {
    private Long stageId;
    private String description;
    private String objective;
    private String entreprise;

    public static StageDto toDto(Stage stage) {
        if (stage == null) return null;
        return StageDto.builder()
                .stageId(stage.getstage_id())
                .description(stage.getDescription())
                .objective(stage.getObjective())
                .entreprise(stage.getEntreprise())
                .build();
    }

}
