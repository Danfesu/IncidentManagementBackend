package sura.com.IncidentManagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sura.com.IncidentManagement.dto.AnalystDTO;
import sura.com.IncidentManagement.entity.Analyst;
import sura.com.IncidentManagement.mapper.MyMapper;
import sura.com.IncidentManagement.repo.AnalystRepo;

@Service
public class AnalystService {
    
    @Autowired
    AnalystRepo analystRepo;

    public List<AnalystDTO> findAll() {
        List<Analyst> analysts = analystRepo.findAll();
        return analysts.stream().map(MyMapper.INSTANCE::mapAnalystToAnalystDTO)
                .collect(Collectors.toList());
    }
}
