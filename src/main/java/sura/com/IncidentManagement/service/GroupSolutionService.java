package sura.com.IncidentManagement.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import sura.com.IncidentManagement.dto.GroupSolutionDTO;
import sura.com.IncidentManagement.entity.GroupSolution;
import sura.com.IncidentManagement.mapper.MyMapper;
import sura.com.IncidentManagement.repo.GroupSolutionRepo;

@Service
public class GroupSolutionService {
    
    @Autowired
    GroupSolutionRepo groupRepo;

    @Autowired
    MyMapper myMapper;

    public List<GroupSolutionDTO> findAll() {
        List<GroupSolution> groups = groupRepo.findAll();
        return groups.stream()
                .map(group -> myMapper.mapGroupToGroupDTO(group))
                .collect(Collectors.toList());
    }

    public String findById(@NonNull Long id) {
        Optional<GroupSolution> group = groupRepo.findById(id);
        return group.get().getName();
    }
    
}
