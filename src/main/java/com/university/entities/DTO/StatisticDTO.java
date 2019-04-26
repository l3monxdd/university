package com.university.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatisticDTO {
    private String departmentName;
    private int assistantCount;
    private int associateProfessorCount;
    private int professorCount;

}
