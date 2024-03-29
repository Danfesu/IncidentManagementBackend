package sura.com.IncidentManagement.dto;

import java.util.List;

public class SolutionManagerDTO {
    private Long id;

    private String name;

    private List<GroupSolutionDTO> groups;

    public SolutionManagerDTO(Long id, String name, List<GroupSolutionDTO> groups) {
        this.id = id;
        this.name = name;
        this.groups = groups;
    }

    public SolutionManagerDTO() {
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

    public List<GroupSolutionDTO> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupSolutionDTO> groups) {
        this.groups = groups;
    }

    
}
