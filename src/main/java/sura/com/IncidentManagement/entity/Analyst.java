package sura.com.IncidentManagement.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
