package sura.com.IncidentManagement.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupSolutionDTO {
    private Long id;

    private String name;

    private Long solutionManagerId;

    private List<AnalystDTO> analysts;
}
