package sura.com.IncidentManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import sura.com.IncidentManagement.dto.AnalystDTO;
import sura.com.IncidentManagement.dto.GroupSolutionDTO;
import sura.com.IncidentManagement.dto.SolutionManagerDTO;
import sura.com.IncidentManagement.entity.Analyst;
import sura.com.IncidentManagement.entity.GroupSolution;
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

        List<SolutionManagerDTO> dtos = solutionManagers.stream()
        .map(solutionManager -> myMapper.mapSolutionManagerToSolutionManagerDTO(solutionManager))
        .collect(Collectors.toList());

        for(int i = 0; i < dtos.size(); i++){
            SolutionManager solutionManager = solutionManagers.get(i);
            dtos.get(i).setId(solutionManager.getId());
            List<GroupSolutionDTO> groups = new ArrayList<GroupSolutionDTO>();
            for(int j = 0; j < solutionManager.getGroups().size(); j++){
                GroupSolution groupSolution = solutionManager.getGroups().get(j);
                List<AnalystDTO> analysts = new ArrayList<>();
                for(int k = 0; k < groupSolution.getAnalysts().size(); k++){
                    Analyst analyst =  solutionManager.getGroups().get(j).getAnalysts().get(k);
                    analysts.add(new AnalystDTO(analyst.getId(), analyst.getName(), analyst.getEmail(), analyst.getGroup().getId()));
                }
                groups.add(new GroupSolutionDTO(groupSolution.getId(), groupSolution.getName(), groupSolution.getSolutionManager().getId(), analysts));
            }
            dtos.get(i).setGroups(groups);
        }

        return dtos;
    }

    public String findById(@NonNull Long id) {
        Optional<SolutionManager> solution = solutionManagerRepo.findById(id);
        return solution.get().getName();
    }
}
