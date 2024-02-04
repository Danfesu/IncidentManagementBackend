package sura.com.IncidentManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sura.com.IncidentManagement.entity.ActionExecuted;

@Repository
public interface ActionExecutedRepo extends JpaRepository<ActionExecuted, Long> {
    
}
