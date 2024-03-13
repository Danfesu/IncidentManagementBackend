package sura.com.IncidentManagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
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

    public Incident(Long id, String diagnosis, LocalDate date, String solution, String hu_raizal,
            boolean confirmed_operability, String access_oc, ClusteredError clusteredError, CauseError causeError,
            ActionExecuted actionExecuted, Analyst analyst, StateRaizal stateRaizal) {
        this.id = id;
        this.diagnosis = diagnosis;
        this.date = date;
        this.solution = solution;
        this.hu_raizal = hu_raizal;
        this.confirmed_operability = confirmed_operability;
        this.access_oc = access_oc;
        this.clusteredError = clusteredError;
        this.causeError = causeError;
        this.actionExecuted = actionExecuted;
        this.analyst = analyst;
        this.stateRaizal = stateRaizal;
    }

    public Incident() {
    }

    public String getComfirmedOperability(){
        return confirmed_operability?"SI":"NO";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getHu_raizal() {
        return hu_raizal;
    }

    public void setHu_raizal(String hu_raizal) {
        this.hu_raizal = hu_raizal;
    }

    public void setConfirmed_operability(boolean confirmed_operability) {
        this.confirmed_operability = confirmed_operability;
    }

    public String getAccess_oc() {
        return access_oc;
    }

    public void setAccess_oc(String access_oc) {
        this.access_oc = access_oc;
    }

    public ClusteredError getClusteredError() {
        return clusteredError;
    }

    public void setClusteredError(ClusteredError clusteredError) {
        this.clusteredError = clusteredError;
    }

    public CauseError getCauseError() {
        return causeError;
    }

    public void setCauseError(CauseError causeError) {
        this.causeError = causeError;
    }

    public ActionExecuted getActionExecuted() {
        return actionExecuted;
    }

    public void setActionExecuted(ActionExecuted actionExecuted) {
        this.actionExecuted = actionExecuted;
    }

    public Analyst getAnalyst() {
        return analyst;
    }

    public void setAnalyst(Analyst analyst) {
        this.analyst = analyst;
    }

    public StateRaizal getStateRaizal() {
        return stateRaizal;
    }

    public void setStateRaizal(StateRaizal stateRaizal) {
        this.stateRaizal = stateRaizal;
    }

    

}
