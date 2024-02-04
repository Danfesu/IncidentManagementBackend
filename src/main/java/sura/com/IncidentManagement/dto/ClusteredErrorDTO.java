package sura.com.IncidentManagement.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClusteredErrorDTO {
    private Long id;

    private String description;

    private ApplicationDTO application;

    private List<IncidentDTO> incidents;
}
