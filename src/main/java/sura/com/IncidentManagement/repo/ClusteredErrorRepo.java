package sura.com.IncidentManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sura.com.IncidentManagement.entity.ClusteredError;

@Repository
public interface ClusteredErrorRepo extends JpaRepository<ClusteredError, Long> {
    
}
