package sura.com.IncidentManagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import sura.com.IncidentManagement.dto.IncidentDTO;
import sura.com.IncidentManagement.entity.ClusteredError;
import sura.com.IncidentManagement.entity.Incident;
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
    ApplicationService applicationService;

    @Autowired
    MyMapper myMapper;

    public List<IncidentDTO> findAll() {
        List<Incident> incidents = incidentRepo.findAll();
        List<IncidentDTO> incidentDTOs = incidents.stream()
                .map(incident -> myMapper.mapIncidentToIncidentDTO(incident))
                .collect(Collectors.toList());
        
        for(int i = 0; i < incidents.size(); i++){
            incidentDTOs.get(i).setApplication(incidents.get(i).getClusteredError().getApplication().getName());
        }
        
        return incidentDTOs;
    }

    public IncidentDTO save(IncidentDTO incidentDTO) {
        Incident incident = myMapper.mapIncidentDTOToIncident(incidentDTO);

        Long clusteredErrorId = incident.getClusteredError().getId();

        if(clusteredErrorId == 0){
            ClusteredError clusteredError = incident.getClusteredError();
            clusteredErrorRepo.save(clusteredError);
        }

        return myMapper.mapIncidentToIncidentDTO(incidentRepo.save(incident));
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
