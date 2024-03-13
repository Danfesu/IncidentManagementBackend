package sura.com.IncidentManagement.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class SolutionManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "solutionManager", cascade = CascadeType.ALL)
    private List<GroupSolution> groups;
    
    public SolutionManager() {
    }

    public SolutionManager(Long id, String name, List<GroupSolution> groups) {
        this.id = id;
        this.name = name;
        this.groups = groups;
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

    public List<GroupSolution> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupSolution> groups) {
        this.groups = groups;
    }

   
}
