package sura.com.IncidentManagement.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateRaizalDTO {
    private Long id;

    private String type;

    private List<IncidentDTO> incidents;
}
