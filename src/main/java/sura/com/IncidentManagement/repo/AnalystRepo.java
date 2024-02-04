package sura.com.IncidentManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sura.com.IncidentManagement.entity.Analyst;

@Repository
public interface AnalystRepo extends JpaRepository<Analyst, Long> {
    
}
