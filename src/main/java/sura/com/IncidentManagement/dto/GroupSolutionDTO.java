package sura.com.IncidentManagement.dto;

import java.util.List;

public class GroupSolutionDTO {
    private Long id;

    private String name;

    private Long solutionManagerId;

    private List<AnalystDTO> analysts;

    public GroupSolutionDTO(Long id, String name, Long solutionManagerId, List<AnalystDTO> analysts) {
        this.id = id;
        this.name = name;
        this.solutionManagerId = solutionManagerId;
        this.analysts = analysts;
    }

    public GroupSolutionDTO() {
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

    public Long getSolutionManagerId() {
        return solutionManagerId;
    }

    public void setSolutionManagerId(Long solutionManagerId) {
        this.solutionManagerId = solutionManagerId;
    }

    public List<AnalystDTO> getAnalysts() {
        return analysts;
    }

    public void setAnalysts(List<AnalystDTO> analysts) {
        this.analysts = analysts;
    }

    
}
