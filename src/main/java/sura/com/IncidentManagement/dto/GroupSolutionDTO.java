package sura.com.IncidentManagement.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class GroupSolutionDTO {
    private Long id;

    private String name;

    private Long solutionManagerId;

    private List<AnalystDTO> analysts;

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
