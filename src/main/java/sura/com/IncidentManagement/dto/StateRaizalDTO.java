package sura.com.IncidentManagement.dto;

public class StateRaizalDTO {
    private Long id;

    private String type;

    public StateRaizalDTO() {
    }

    public StateRaizalDTO(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
