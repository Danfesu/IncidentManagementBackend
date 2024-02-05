package sura.com.IncidentManagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sura.com.IncidentManagement.dto.GroupDTO;
import sura.com.IncidentManagement.entity.Group;
import sura.com.IncidentManagement.mapper.MyMapper;
import sura.com.IncidentManagement.repo.GroupRepo;

@Service
public class GroupService {
    
    @Autowired
    GroupRepo groupRepo;

    public List<GroupDTO> findAll() {
        List<Group> groups = groupRepo.findAll();
        return groups.stream().map(MyMapper.INSTANCE::mapGroupToGroupDTO)
                .collect(Collectors.toList());
    }
}
