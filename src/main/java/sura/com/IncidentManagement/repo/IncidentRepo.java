package sura.com.IncidentManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sura.com.IncidentManagement.entity.Incident;

@Repository
public interface IncidentRepo extends JpaRepository<Incident, Long> {
    
}
