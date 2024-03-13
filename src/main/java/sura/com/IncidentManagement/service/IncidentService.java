package sura.com.IncidentManagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import sura.com.IncidentManagement.dto.AnalystDTO;
import sura.com.IncidentManagement.dto.IncidentDTO;
import sura.com.IncidentManagement.entity.ActionExecuted;
import sura.com.IncidentManagement.entity.Analyst;
import sura.com.IncidentManagement.entity.Application;
import sura.com.IncidentManagement.entity.CauseError;
import sura.com.IncidentManagement.entity.ClusteredError;
import sura.com.IncidentManagement.entity.GroupSolution;
import sura.com.IncidentManagement.entity.Incident;
import sura.com.IncidentManagement.entity.StateRaizal;
import sura.com.IncidentManagement.mapper.MyMapper;
import sura.com.IncidentManagement.repo.ClusteredErrorRepo;
import sura.com.IncidentManagement.repo.IncidentRepo;

@Service
public class IncidentService {
    
    @Autowired
    IncidentRepo incidentRepo;

    @Autowired
    ClusteredErrorRepo clusteredErrorRepo;

    @Autowired
    ClusteredErrorService clusteredErrorService;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    CauseErrorService causeErrorService;

    @Autowired
    ActionExecutedService actionExecutedService;

    @Autowired
    AnalystService analystService;

    @Autowired
    StateRaizalService stateRaizalService;

    @Autowired
    MyMapper myMapper;

    public List<IncidentDTO> findAll() {
        List<Incident> incidents = incidentRepo.findAll();
        List<IncidentDTO> incidentDTOs = incidents.stream()
                .map(incident -> myMapper.mapIncidentToIncidentDTO(incident))
                .collect(Collectors.toList());
        
        for(int i = 0; i < incidents.size(); i++){
            incidentDTOs.get(i).setApplication(incidents.get(i).getClusteredError().getApplication().getName());
            incidentDTOs.get(i).setId(incidents.get(i).getId());
            incidentDTOs.get(i).setDate(incidents.get(i).getDate());
            incidentDTOs.get(i).setAnalyst(new AnalystDTO(incidents.get(i).getAnalyst().getId(), incidents.get(i).getAnalyst().getName(), incidents.get(i).getAnalyst().getEmail(), incidents.get(i).getAnalyst().getGroup().getId()));
        }
        
        return incidentDTOs;
    }

    public IncidentDTO save(IncidentDTO incidentDTO) {
        Incident incident = mapIncidentDTOToIncident(incidentDTO);

        Long clusteredErrorId = incident.getClusteredError().getId();

        
        if(clusteredErrorId == 0){
            ClusteredError cError = incident.getClusteredError();
            clusteredErrorRepo.save(cError);
        }
        
        return myMapper.mapIncidentToIncidentDTO(incidentRepo.save(incident));
    }

    private Incident mapIncidentDTOToIncident(IncidentDTO incidentDTO){
        Incident incident = new Incident();

        incident.setId(incidentDTO.getId());
        incident.setDiagnosis(incidentDTO.getDiagnosis());
        incident.setDate(LocalDate.now().minusDays(1));
        incident.setSolution(incidentDTO.getSolution());
        incident.setHu_raizal(incidentDTO.getHu_raizal());
        incident.setConfirmed_operability(incidentDTO.isConfirmed_operability());
        incident.setAccess_oc(incidentDTO.getAccess_oc());
        if(incidentDTO.getClusteredError().getId() == 0){
            ClusteredError clusteredError = new ClusteredError();
            clusteredError.setId(incidentDTO.getClusteredError().getId());
            clusteredError.setDescription(incidentDTO.getClusteredError().getDescription());
            clusteredError.setApplication(applicationService.findAppById(incidentDTO.getClusteredError().getApplication_id()));
            incident.setClusteredError(clusteredError);
        }else{
            incident.setClusteredError(clusteredErrorService.findById(incidentDTO.getClusteredError().getId()));
        }
        incident.setCauseError(causeErrorService.findById(incidentDTO.getCauseError().getId()));
        incident.setActionExecuted(actionExecutedService.findById(incidentDTO.getActionExecuted().getId()));
        incident.setAnalyst(analystService.findById(incidentDTO.getAnalyst().getId()));
        incident.setStateRaizal(stateRaizalService.findById(incidentDTO.getStateRaizal().getId()));

        return incident;
    }


    public String getSolutionTemplate(@NonNull Long id){
        Optional<Incident> incident = incidentRepo.findById(id);

        String solutionTemplate = "* Agrupador del Error: " + incident.get().getClusteredError().getDescription() + " | \n" +
                                  "* Causa del Error: " + incident.get().getCauseError().getDescription() + " | \n" +
                                  "* Proceso del Error: " + incident.get().getClusteredError().getApplication().getName() + " | \n" +
                                  "* HU Raizal / Mejora: " + incident.get().getHu_raizal() + " | \n" +
                                  "* Estado Raizal: " + incident.get().getStateRaizal().getType() + " | \n" +
                                  "* Responsable Solucion: " + incident.get().getAnalyst().getGroup().getSolutionManager().getName() + " | \n" +
                                  "* Diagnostico: " + incident.get().getDiagnosis() + " | \n" +
                                  "* Accion Ejecutada: " + incident.get().getActionExecuted().getDescription() + " | \n" +
                                  "* Descripcion de Solucion: " + incident.get().getSolution() + " | \n" +
                                  "* Confirmar operatividad del usuario afectado: " + incident.get().getComfirmedOperability() + " | \n" +
                                  "* OC Acceso a PDN - (PAM): " + incident.get().getAccess_oc() + " |";

        return solutionTemplate;
    }


    public List<Object[]> getAmountIncidentsPerDay(LocalDate startDate, LocalDate endDate){
        return incidentRepo.countByDate(startDate, endDate);
    }

    public List<Object[]> getAmountIncidentsPerApp(LocalDate startDate, LocalDate endDate){
        return incidentRepo.countByApp(startDate, endDate);
    }
}
