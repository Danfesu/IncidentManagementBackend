package sura.com.IncidentManagement.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Analyst {
    @Id
    private Long id;

    private String name;

    private String email;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private GroupSolution group;

    @OneToMany(mappedBy = "analyst", cascade = CascadeType.ALL)
    private List<Incident> incidents;

    public Analyst() {
    }

    public Analyst(Long id, String name, String email, GroupSolution group, List<Incident> incidents) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.group = group;
        this.incidents = incidents;
    }

    public GroupSolution getGroup(){
        return group;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGroup(GroupSolution group) {
        this.group = group;
    }

    public List<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<Incident> incidents) {
        this.incidents = incidents;
    }

    
}
