package sura.com.IncidentManagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sura.com.IncidentManagement.dto.ApplicationDTO;
import sura.com.IncidentManagement.entity.Application;
import sura.com.IncidentManagement.mapper.MyMapper;
import sura.com.IncidentManagement.repo.ApplicationRepo;

@Service
public class ApplicationService {
    
    @Autowired
    ApplicationRepo applicationRepo;

    public List<ApplicationDTO> findAll() {
        List<Application> applications = applicationRepo.findAll();
        return applications.stream().map(MyMapper.INSTANCE::mapApplicationToApplicationDTO)
                .collect(Collectors.toList());
    }
}
