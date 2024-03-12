package sura.com.IncidentManagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sura.com.IncidentManagement.dto.CauseErrorDTO;
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
        return causeErrors.stream()
                .map(causeError -> myMapper.mapCauseErrorToCauseErrorDTO(causeError))
                .collect(Collectors.toList());
    }
}
