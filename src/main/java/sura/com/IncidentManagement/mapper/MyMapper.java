package sura.com.IncidentManagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import sura.com.IncidentManagement.dto.ActionExecutedDTO;
import sura.com.IncidentManagement.dto.AnalystDTO;
import sura.com.IncidentManagement.dto.ApplicationDTO;
import sura.com.IncidentManagement.dto.CauseErrorDTO;
import sura.com.IncidentManagement.dto.ClusteredErrorDTO;
import sura.com.IncidentManagement.dto.GroupSolutionDTO;
import sura.com.IncidentManagement.dto.IncidentDTO;
import sura.com.IncidentManagement.dto.SolutionManagerDTO;
import sura.com.IncidentManagement.dto.StateRaizalDTO;
import sura.com.IncidentManagement.entity.ActionExecuted;
import sura.com.IncidentManagement.entity.Analyst;
import sura.com.IncidentManagement.entity.Application;
import sura.com.IncidentManagement.entity.CauseError;
import sura.com.IncidentManagement.entity.ClusteredError;
import sura.com.IncidentManagement.entity.GroupSolution;
import sura.com.IncidentManagement.entity.Incident;
import sura.com.IncidentManagement.entity.SolutionManager;
import sura.com.IncidentManagement.entity.StateRaizal;

@Mapper
public interface MyMapper {
        public static final MyMapper INSTANCE = Mappers.getMapper(MyMapper.class);

        @Mapping(target = "incidents", ignore = true)
        ActionExecuted mapActionExecutedDTOToActionExecuted(ActionExecutedDTO actionExecutedDTO);

        ActionExecutedDTO mapActionExecutedToActionExecutedDTO(ActionExecuted actionExecuted);

        default GroupSolution mapGroupSolution(Long groupId) {
                if (groupId == null) {
                    return null;
                }
        
                GroupSolution groupSolution = new GroupSolution();
                groupSolution.setId(groupId);
                // Puedes cargar más detalles del GroupSolution si es necesario
        
                return groupSolution;
        }
        
        @Mappings({
            @Mapping(target = "incidents", ignore = true),
            @Mapping(target = "group", source = "group_id")
        })
        Analyst mapAnalystDTOToAnalyst(AnalystDTO analystDTO);

        @Mapping(target = "group_id", source = "group.id")
        AnalystDTO mapAnalystToAnalystDTO(Analyst analyst);

        Application mapApplicationDTOToApplication(ApplicationDTO applicationDTO);

        ApplicationDTO mapApplicationToApplicationDTO(Application application);

        @Mapping(target = "incidents", ignore = true)
        CauseError mapCauseErrorDTOToCauseError(CauseErrorDTO causeErrorDTO);

        CauseErrorDTO mapCauseErrorToCauseErrorDTO(CauseError causeError);

        default Application mapApplication(Long applicationId) {
                if (applicationId == null) {
                    return null;
                }
        
                Application application = new Application();
                application.setId(applicationId);
                // Puedes cargar más detalles del GroupSolution si es necesario
        
                return application;
        }

        @Mappings({
                @Mapping(target = "incidents", ignore = true),
                @Mapping(target = "application", source = "application_id")
        })
        ClusteredError mapClusteredErrorDTOToCaClusteredError(ClusteredErrorDTO clusteredErrorDTO);

        @Mapping(target = "application_id", source = "application.id")
        ClusteredErrorDTO mapClusteredErrorToClusteredErrorDTO(ClusteredError clusteredError);

        Incident mapIncidentDTOToIncident(IncidentDTO incidentDTO);

        IncidentDTO mapIncidentToIncidentDTO(Incident incident);

        SolutionManager mapSolutionManagerDTOToSolutionManager(SolutionManagerDTO solutionManagerDTO);

        SolutionManagerDTO mapSolutionManagerToSolutionManagerDTO(SolutionManager solutionManager);

        @Mapping(target = "incidents", ignore = true)
        StateRaizal mapStateRaizalDTOToStateRaizal(StateRaizalDTO stateRaizalDTO);

        StateRaizalDTO mapStateRaizalToStateRaizalDTO(StateRaizal stateRaizal);
        
        default SolutionManager mapSolutionManager(Long solutionManagerId) {
                if (solutionManagerId == null) {
                    return null;
                }
        
                SolutionManager solutionManager = new SolutionManager();
                solutionManager.setId(solutionManagerId);
                // Puedes cargar más detalles del GroupSolution si es necesario
        
                return solutionManager;
        }

        @Mapping(target = "solutionManager", source = "solutionManagerId")
        GroupSolution mapGroupDTOToGroup(GroupSolutionDTO groupDTO);

        @Mapping(target = "solutionManagerId", source = "solutionManager.id")
        GroupSolutionDTO mapGroupToGroupDTO(GroupSolution group);
}
