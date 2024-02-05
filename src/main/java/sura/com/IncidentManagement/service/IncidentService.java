package sura.com.IncidentManagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import sura.com.IncidentManagement.dto.IncidentDTO;
import sura.com.IncidentManagement.entity.Incident;
import sura.com.IncidentManagement.mapper.MyMapper;
import sura.com.IncidentManagement.repo.IncidentRepo;

@Service
public class IncidentService {
    
    @Autowired
    IncidentRepo incidentRepo;

    public List<IncidentDTO> findAll() {
        List<Incident> incidents = incidentRepo.findAll();
        return incidents.stream().map(MyMapper.INSTANCE::mapIncidentToIncidentDTO)
                .collect(Collectors.toList());
    }

    public IncidentDTO save(@NonNull Incident incident) {
        return MyMapper.INSTANCE.mapIncidentToIncidentDTO(incidentRepo.save(incident));
    }
}
