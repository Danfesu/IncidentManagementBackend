package sura.com.IncidentManagement.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDTO {
    private Long id;

    private String name;

    private List<ClusteredErrorDTO> clusteredErrors;
}
