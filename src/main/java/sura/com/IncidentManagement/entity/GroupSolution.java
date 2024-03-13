package sura.com.IncidentManagement.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class GroupSolution {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "solution_manager_id", nullable = false)
    private SolutionManager solutionManager;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Analyst> analysts;
    
    public GroupSolution() {
    }

    public GroupSolution(Long id, String name, SolutionManager solutionManager, List<Analyst> analysts) {
        this.id = id;
        this.name = name;
        this.solutionManager = solutionManager;
        this.analysts = analysts;
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

    public SolutionManager getSolutionManager() {
        return solutionManager;
    }

    public void setSolutionManager(SolutionManager solutionManager) {
        this.solutionManager = solutionManager;
    }

    public List<Analyst> getAnalysts() {
        return analysts;
    }

    public void setAnalysts(List<Analyst> analysts) {
        this.analysts = analysts;
    }

    
}
