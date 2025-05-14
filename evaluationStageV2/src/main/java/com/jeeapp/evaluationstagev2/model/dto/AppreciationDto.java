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
public class AppreciationDto {
    private AppreciationIdDto appreciationId;
    private String appreciationName;
}

