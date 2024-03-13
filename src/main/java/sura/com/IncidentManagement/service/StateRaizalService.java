package sura.com.IncidentManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
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

        List<StateRaizalDTO> dtos = stateRaizals.stream()
        .map(stateRaizal -> myMapper.mapStateRaizalToStateRaizalDTO(stateRaizal))
        .collect(Collectors.toList());

        for(int i = 0; i < stateRaizals.size(); i++){
            dtos.get(i).setId(stateRaizals.get(i).getId());
        }

        return dtos;
    }

    public StateRaizal findById(@NonNull Long id) {
        Optional<StateRaizal> stateRaizal = stateRaizalRepo.findById(id);
        return stateRaizal.get();
    }
}
