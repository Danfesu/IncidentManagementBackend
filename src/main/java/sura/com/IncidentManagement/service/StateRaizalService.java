package sura.com.IncidentManagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sura.com.IncidentManagement.dto.StateRaizalDTO;
import sura.com.IncidentManagement.entity.StateRaizal;
import sura.com.IncidentManagement.mapper.MyMapper;
import sura.com.IncidentManagement.repo.StateRaizalRepo;

@Service
public class StateRaizalService {
    
    @Autowired
    StateRaizalRepo stateRaizalRepo;

    @Autowired
    MyMapper myMapper;

    public List<StateRaizalDTO> findAll() {
        List<StateRaizal> stateRaizals = stateRaizalRepo.findAll();
        return stateRaizals.stream()
            .map(stateRaizal -> myMapper.mapStateRaizalToStateRaizalDTO(stateRaizal))
            .collect(Collectors.toList());
    }
}
