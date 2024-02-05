package sura.com.IncidentManagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import sura.com.IncidentManagement.dto.ClusteredErrorDTO;
import sura.com.IncidentManagement.entity.ClusteredError;
import sura.com.IncidentManagement.mapper.MyMapper;
import sura.com.IncidentManagement.repo.ClusteredErrorRepo;

@Service
public class ClusteredErrorService {
    
    @Autowired
    ClusteredErrorRepo clusteredErrorRepo;

    public List<ClusteredErrorDTO> findAll() {
        List<ClusteredError> clusteredErrors = clusteredErrorRepo.findAll();
        return clusteredErrors.stream().map(MyMapper.INSTANCE::mapClusteredErrorToClusteredErrorDTO)
                .collect(Collectors.toList());
    }

    public ClusteredErrorDTO save(@NonNull ClusteredError clusteredError) {
        return MyMapper.INSTANCE.mapClusteredErrorToClusteredErrorDTO(clusteredErrorRepo.save(clusteredError));
    }
}