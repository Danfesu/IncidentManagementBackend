package sura.com.IncidentManagement.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import sura.com.IncidentManagement.dto.ApplicationDTO;
import sura.com.IncidentManagement.entity.Application;
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
        return applications.stream()
                .map(application -> myMapper.mapApplicationToApplicationDTO(application))
                .collect(Collectors.toList());
    }

    public String findById(@NonNull Long id) {
        Optional<Application> application = applicationRepo.findById(id);
        return application.get().getName();
    }
}
