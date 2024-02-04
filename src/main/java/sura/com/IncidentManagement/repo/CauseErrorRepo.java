package sura.com.IncidentManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sura.com.IncidentManagement.entity.CauseError;

@Repository
public interface CauseErrorRepo extends JpaRepository<CauseError, Long> {
    
}
