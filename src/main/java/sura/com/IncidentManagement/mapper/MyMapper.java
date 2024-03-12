package sura.com.IncidentManagement.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import sura.com.IncidentManagement.dto.*;
import sura.com.IncidentManagement.entity.*;

@Component
public class MyMapper {

    private final ModelMapper modelMapper;

    public MyMapper() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public ActionExecuted mapActionExecutedDTOToActionExecuted(ActionExecutedDTO actionExecutedDTO) {
        return modelMapper.map(actionExecutedDTO, ActionExecuted.class);
    }

    public ActionExecutedDTO mapActionExecutedToActionExecutedDTO(ActionExecuted actionExecuted) {
        return modelMapper.map(actionExecuted, ActionExecutedDTO.class);
    }

    public Analyst mapAnalystDTOToAnalyst(AnalystDTO analystDTO) {
        return modelMapper.map(analystDTO, Analyst.class);
    }

    public AnalystDTO mapAnalystToAnalystDTO(Analyst analyst) {
        return modelMapper.map(analyst, AnalystDTO.class);
    }

    public Application mapApplicationDTOToApplication(ApplicationDTO applicationDTO) {
        return modelMapper.map(applicationDTO, Application.class);
    }

    public ApplicationDTO mapApplicationToApplicationDTO(Application application) {
        return modelMapper.map(application, ApplicationDTO.class);
    }

    public CauseError mapCauseErrorDTOToCauseError(CauseErrorDTO causeErrorDTO) {
        return modelMapper.map(causeErrorDTO, CauseError.class);
    }

    public CauseErrorDTO mapCauseErrorToCauseErrorDTO(CauseError causeError) {
        return modelMapper.map(causeError, CauseErrorDTO.class);
    }

    public ClusteredError mapClusteredErrorDTOToClusteredError(ClusteredErrorDTO clusteredErrorDTO) {
        return modelMapper.map(clusteredErrorDTO, ClusteredError.class);
    }

    public ClusteredErrorDTO mapClusteredErrorToClusteredErrorDTO(ClusteredError clusteredError) {
        return modelMapper.map(clusteredError, ClusteredErrorDTO.class);
    }

    public Incident mapIncidentDTOToIncident(IncidentDTO incidentDTO) {
        return modelMapper.map(incidentDTO, Incident.class);
    }

    public IncidentDTO mapIncidentToIncidentDTO(Incident incident) {
        return modelMapper.map(incident, IncidentDTO.class);
    }

    public SolutionManager mapSolutionManagerDTOToSolutionManager(SolutionManagerDTO solutionManagerDTO) {
        return modelMapper.map(solutionManagerDTO, SolutionManager.class);
    }

    public SolutionManagerDTO mapSolutionManagerToSolutionManagerDTO(SolutionManager solutionManager) {
        return modelMapper.map(solutionManager, SolutionManagerDTO.class);
    }

    public StateRaizal mapStateRaizalDTOToStateRaizal(StateRaizalDTO stateRaizalDTO) {
        return modelMapper.map(stateRaizalDTO, StateRaizal.class);
    }

    public StateRaizalDTO mapStateRaizalToStateRaizalDTO(StateRaizal stateRaizal) {
        return modelMapper.map(stateRaizal, StateRaizalDTO.class);
    }

    public GroupSolution mapGroupDTOToGroup(GroupSolutionDTO groupDTO) {
        return modelMapper.map(groupDTO, GroupSolution.class);
    }

    public GroupSolutionDTO mapGroupToGroupDTO(GroupSolution group) {
        return modelMapper.map(group, GroupSolutionDTO.class);
    }
}
