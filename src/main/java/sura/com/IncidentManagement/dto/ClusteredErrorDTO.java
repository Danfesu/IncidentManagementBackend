package sura.com.IncidentManagement.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ClusteredErrorDTO {
    private Long id;

    private String description;

    private Long application_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getApplication_id() {
        return application_id;
    }

    public void setApplication_id(Long application_id) {
        this.application_id = application_id;
    }

    
}
