package sura.com.IncidentManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sura.com.IncidentManagement.entity.Group;

@Repository
public interface GroupRepor extends JpaRepository<Group, Long> {
    
}
