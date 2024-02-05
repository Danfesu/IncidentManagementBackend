package sura.com.IncidentManagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sura.com.IncidentManagement.dto.GroupSolutionDTO;
import sura.com.IncidentManagement.entity.GroupSolution;
import sura.com.IncidentManagement.mapper.MyMapper;
import sura.com.IncidentManagement.repo.GroupSolutionRepo;

@Service
public class GroupSolutionService {
    
    @Autowired
    GroupSolutionRepo groupRepo;

    public List<GroupSolutionDTO> findAll() {
        List<GroupSolution> groups = groupRepo.findAll();
        return groups.stream().map(MyMapper.INSTANCE::mapGroupToGroupDTO)
                .collect(Collectors.toList());
    }
}
