package sura.com.IncidentManagement.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClusteredErrorDTO {
    private Long id;

    private String description;

    private Long application_id;

}
