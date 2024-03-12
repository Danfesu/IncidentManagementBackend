package sura.com.IncidentManagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sura.com.IncidentManagement.dto.ActionExecutedDTO;
import sura.com.IncidentManagement.entity.ActionExecuted;
import sura.com.IncidentManagement.mapper.MyMapper;
import sura.com.IncidentManagement.repo.ActionExecutedRepo;

@Service
public class ActionExecutedService {
    
    @Autowired
    ActionExecutedRepo actionExecutedRepo;

    @Autowired
    MyMapper myMapper;

    public List<ActionExecutedDTO> findAll() {
        List<ActionExecuted> actionExecuteds = actionExecutedRepo.findAll();
        return actionExecuteds.stream()
                .map(actionExecuted -> myMapper.mapActionExecutedToActionExecutedDTO(actionExecuted))
                .collect(Collectors.toList());
    }
}
