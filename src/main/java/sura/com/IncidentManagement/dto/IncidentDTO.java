package sura.com.IncidentManagement.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class IncidentDTO {
    private Long id;

    private String diagnosis;

    private LocalDate date;

    private String solution;

    private boolean confirmed_operability;

    private String access_oc;

    private String application;

    private String hu_raizal;

    private ClusteredErrorDTO clusteredError;

    private CauseErrorDTO causeError;

    private ActionExecutedDTO actionExecuted;

    private AnalystDTO analyst;

    private StateRaizalDTO stateRaizal;


    public void setApplication(String application){
        this.application = application;
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


    public boolean isConfirmed_operability() {
        return confirmed_operability;
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


    public String getApplication() {
        return application;
    }


    public String getHu_raizal() {
        return hu_raizal;
    }


    public void setHu_raizal(String hu_raizal) {
        this.hu_raizal = hu_raizal;
    }


    public ClusteredErrorDTO getClusteredError() {
        return clusteredError;
    }


    public void setClusteredError(ClusteredErrorDTO clusteredError) {
        this.clusteredError = clusteredError;
    }


    public CauseErrorDTO getCauseError() {
        return causeError;
    }


    public void setCauseError(CauseErrorDTO causeError) {
        this.causeError = causeError;
    }


    public ActionExecutedDTO getActionExecuted() {
        return actionExecuted;
    }


    public void setActionExecuted(ActionExecutedDTO actionExecuted) {
        this.actionExecuted = actionExecuted;
    }


    public AnalystDTO getAnalyst() {
        return analyst;
    }


    public void setAnalyst(AnalystDTO analyst) {
        this.analyst = analyst;
    }


    public StateRaizalDTO getStateRaizal() {
        return stateRaizal;
    }


    public void setStateRaizal(StateRaizalDTO stateRaizal) {
        this.stateRaizal = stateRaizal;
    }

    
}
