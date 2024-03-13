package sura.com.IncidentManagement.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import sura.com.IncidentManagement.dto.CauseErrorDTO;
import sura.com.IncidentManagement.dto.StateRaizalDTO;
import sura.com.IncidentManagement.entity.Application;
import sura.com.IncidentManagement.entity.CauseError;
import sura.com.IncidentManagement.mapper.MyMapper;
import sura.com.IncidentManagement.repo.CauseErrorRepo;

@Service
public class CauseErrorService {
    
    @Autowired
    CauseErrorRepo causeErrorRepo;

    @Autowired
    MyMapper myMapper;

    public List<CauseErrorDTO> findAll() {
        List<CauseError> causeErrors = causeErrorRepo.findAll();

        List<CauseErrorDTO> dtos = causeErrors.stream()
        .map(causeError -> myMapper.mapCauseErrorToCauseErrorDTO(causeError))
        .collect(Collectors.toList());

        for(int i = 0; i < causeErrors.size(); i++){
            dtos.get(i).setId(causeErrors.get(i).getId());
        }

        return dtos;
    }

    public CauseError findById(@NonNull Long id) {
        Optional<CauseError> causeError = causeErrorRepo.findById(id);
        return causeError.get();
    }
}
