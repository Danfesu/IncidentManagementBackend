package sura.com.IncidentManagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Incident {
    @Id
    private Long id;

    private String diagnosis;

    private LocalDate date;

    private String solution;

    private String hu_raizal;

    private boolean confirmed_operability;

    private String access_oc;

    @ManyToOne
    @JoinColumn(name = "clustered_error_id", nullable = false)
    private ClusteredError clusteredError;

    @ManyToOne
    @JoinColumn(name = "cause_error_id", nullable = false)
    private CauseError causeError;

    @ManyToOne
    @JoinColumn(name = "action_executed_id", nullable = false)
    private ActionExecuted actionExecuted;

    @ManyToOne
    @JoinColumn(name = "analyst_id", nullable = false)
    private Analyst analyst;

    @ManyToOne
    @JoinColumn(name = "state_raizal_id", nullable = false)
    private StateRaizal stateRaizal;

    public String getComfirmedOperability(){
        return confirmed_operability?"SI":"NO";
    }
}
