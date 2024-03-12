package sura.com.IncidentManagement.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import sura.com.IncidentManagement.dto.SolutionManagerDTO;
import sura.com.IncidentManagement.entity.SolutionManager;
import sura.com.IncidentManagement.mapper.MyMapper;
import sura.com.IncidentManagement.repo.SolutionManagerRepo;

@Service
public class SolutionManagerService {
    
    @Autowired
    SolutionManagerRepo solutionManagerRepo;

    @Autowired
    MyMapper myMapper;

    public List<SolutionManagerDTO> findAll() {
        List<SolutionManager> solutionManagers = solutionManagerRepo.findAll();
        return solutionManagers.stream()
            .map(solutionManager -> myMapper.mapSolutionManagerToSolutionManagerDTO(solutionManager))
            .collect(Collectors.toList());
    }

    public String findById(@NonNull Long id) {
        Optional<SolutionManager> solution = solutionManagerRepo.findById(id);
        return solution.get().getName();
    }
}
