package sura.com.IncidentManagement.dto;

public class ActionExecutedDTO {
    private Long id;
    private String description;

    public ActionExecutedDTO(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public ActionExecutedDTO() {
    }

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
