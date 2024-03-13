package sura.com.IncidentManagement.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Application {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL)
    private List<ClusteredError> clusteredErrors;

    public Application() {
    }

    public Application(Long id, String name, List<ClusteredError> clusteredErrors) {
        this.id = id;
        this.name = name;
        this.clusteredErrors = clusteredErrors;
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

    public List<ClusteredError> getClusteredErrors() {
        return clusteredErrors;
    }

    public void setClusteredErrors(List<ClusteredError> clusteredErrors) {
        this.clusteredErrors = clusteredErrors;
    }

    
}
