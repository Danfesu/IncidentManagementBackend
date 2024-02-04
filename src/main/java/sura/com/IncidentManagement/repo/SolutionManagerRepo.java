package sura.com.IncidentManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sura.com.IncidentManagement.entity.SolutionManager;

@Repository
public interface SolutionManagerRepo extends JpaRepository<SolutionManager, Long> {
    
}
