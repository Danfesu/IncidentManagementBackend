package sura.com.IncidentManagement.dto;

import java.util.List;


public class ApplicationDTO {
    private Long id;

    private String name;

    private List<ClusteredErrorDTO> clusteredErrors;
    
    public ApplicationDTO(Long id, String name, List<ClusteredErrorDTO> clusteredErrors) {
        this.id = id;
        this.name = name;
        this.clusteredErrors = clusteredErrors;
    }

    public ApplicationDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClusteredErrorDTO> getClusteredErrors() {
        return clusteredErrors;
    }

    public void setClusteredErrors(List<ClusteredErrorDTO> clusteredErrors) {
        this.clusteredErrors = clusteredErrors;
    }

    
}
