package sura.com.IncidentManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import sura.com.IncidentManagement.dto.AnalystDTO;
import sura.com.IncidentManagement.dto.ApplicationDTO;
import sura.com.IncidentManagement.dto.ClusteredErrorDTO;
import sura.com.IncidentManagement.entity.Analyst;
import sura.com.IncidentManagement.entity.Application;
import sura.com.IncidentManagement.entity.ClusteredError;
import sura.com.IncidentManagement.mapper.MyMapper;
import sura.com.IncidentManagement.repo.ApplicationRepo;

@Service
public class ApplicationService {
    
    @Autowired
    ApplicationRepo applicationRepo;

    @Autowired
    MyMapper myMapper;

    public List<ApplicationDTO> findAll() {
        List<Application> applications = applicationRepo.findAll();

        List<ApplicationDTO> dtos = applications.stream()
        .map(application -> myMapper.mapApplicationToApplicationDTO(application))
        .collect(Collectors.toList());

        for(int i = 0; i < applications.size(); i++){
            dtos.get(i).setId(applications.get(i).getId());
            List<ClusteredError> clusteredErrors = applications.get(i).getClusteredErrors();
            List<ClusteredErrorDTO> clusteredErrorDTOs = new ArrayList<>();
            for(int j = 0; j < clusteredErrors.size(); j++){
                ClusteredError clusteredError = clusteredErrors.get(j);
                clusteredErrorDTOs.add(new ClusteredErrorDTO(clusteredError.getId(), clusteredError.getDescription(), clusteredError.getApplication().getId()));
            }
            dtos.get(i).setClusteredErrors(clusteredErrorDTOs);
        }
        return dtos; 
    }

    public String findById(@NonNull Long id) {
        Optional<Application> application = applicationRepo.findById(id);
        return application.get().getName();
    }

    public Application findAppById(@NonNull Long id) {
        Optional<Application> application = applicationRepo.findById(id);
        return application.get();
    }
}
