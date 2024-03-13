package sura.com.IncidentManagement.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import sura.com.IncidentManagement.dto.AnalystDTO;
import sura.com.IncidentManagement.entity.Analyst;
import sura.com.IncidentManagement.mapper.MyMapper;
import sura.com.IncidentManagement.repo.AnalystRepo;

@Service
public class AnalystService {
    
    @Autowired
    AnalystRepo analystRepo;

    @Autowired
    MyMapper myMapper;

    public List<AnalystDTO> findAll() {
        List<Analyst> analysts = analystRepo.findAll();
        return analysts.stream()
                .map(analyst -> myMapper.mapAnalystToAnalystDTO(analyst))
                .collect(Collectors.toList());
    }

    public Analyst findById(@NonNull Long id) {
        Optional<Analyst> analyst = analystRepo.findById(id);
        return analyst.get();
    }
}
