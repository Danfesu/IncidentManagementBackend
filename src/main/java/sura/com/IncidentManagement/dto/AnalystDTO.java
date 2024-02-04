package sura.com.IncidentManagement.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalystDTO {
    private Long id;

    private String name;

    private String email;

    private GroupDTO group;

    private List<IncidentDTO> incidents;
}