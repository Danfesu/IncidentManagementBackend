package sura.com.IncidentManagement.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ActionExecutedDTO {
    private Long id;
    private String description;

    public Long getId(){
        return id;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setId(Long id){
        this.id = id;
    }
}
