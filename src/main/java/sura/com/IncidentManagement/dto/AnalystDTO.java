package sura.com.IncidentManagement.dto;

public class AnalystDTO {

    public AnalystDTO(Long id, String name, String email, Long group_id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.group_id = group_id;
    }

    public AnalystDTO(){
    }

    private Long id;

    private String name;

    private String email;

    private Long group_id;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }

    
}
