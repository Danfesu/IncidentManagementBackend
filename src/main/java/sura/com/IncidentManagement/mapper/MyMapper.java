package sura.com.IncidentManagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import sura.com.IncidentManagement.dto.ActionExecutedDTO;
import sura.com.IncidentManagement.dto.AnalystDTO;
import sura.com.IncidentManagement.dto.ApplicationDTO;
import sura.com.IncidentManagement.dto.CauseErrorDTO;
import sura.com.IncidentManagement.dto.ClusteredErrorDTO;
import sura.com.IncidentManagement.dto.GroupDTO;
import sura.com.IncidentManagement.dto.IncidentDTO;
import sura.com.IncidentManagement.dto.SolutionManagerDTO;
import sura.com.IncidentManagement.dto.StateRaizalDTO;
import sura.com.IncidentManagement.entity.ActionExecuted;
import sura.com.IncidentManagement.entity.Analyst;
import sura.com.IncidentManagement.entity.Application;
import sura.com.IncidentManagement.entity.CauseError;
import sura.com.IncidentManagement.entity.ClusteredError;
import sura.com.IncidentManagement.entity.Group;
import sura.com.IncidentManagement.entity.Incident;
import sura.com.IncidentManagement.entity.SolutionManager;
import sura.com.IncidentManagement.entity.StateRaizal;

@Mapper
public interface MyMapper {
        public static final MyMapper INSTANCE = Mappers.getMapper(MyMapper.class);

        ActionExecuted mapActionExecutedDTOToActionExecuted(ActionExecutedDTO actionExecutedDTO);

        ActionExecutedDTO mapActionExecutedToActionExecutedDTO(ActionExecuted actionExecuted);

        Analyst mapAnalystDTOToAnalyst(AnalystDTO analystDTO);

        AnalystDTO mapAnalystToAnalystDTO(Analyst analyst);

        Application mapApplicationDTOToApplication(ApplicationDTO applicationDTO);

        ApplicationDTO mapApplicationToApplicationDTO(Application application);

        CauseError mapCauseErrorDTOToCauseError(CauseErrorDTO causeErrorDTO);

        CauseErrorDTO mapCauseErrorToCauseErrorDTO(CauseError causeError);

        ClusteredError mapClusteredErrorDTOToCaClusteredError(ClusteredErrorDTO clusteredErrorDTO);

        ClusteredErrorDTO mapClusteredErrorToClusteredErrorDTO(ClusteredError clusteredError);

        Incident mapIncidentDTOToIncident(IncidentDTO incidentDTO);

        IncidentDTO mapIncidentToIncidentDTO(Incident incident);

        SolutionManager mapSolutionManagerDTOToSolutionManager(SolutionManagerDTO solutionManagerDTO);

        SolutionManagerDTO mapSolutionManagerToSolutionManagerDTO(SolutionManager solutionManager);

        StateRaizal mapStateRaizalDTOToStateRaizal(StateRaizalDTO stateRaizalDTO);

        StateRaizalDTO mapStateRaizalToStateRaizalDTO(StateRaizal stateRaizal);

        Group maGroupDTOToGroup(GroupDTO groupDTO);

        GroupDTO mapGroupToGroupDTO(Group group);
}
