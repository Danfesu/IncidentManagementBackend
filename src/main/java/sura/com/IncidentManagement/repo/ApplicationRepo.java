package sura.com.IncidentManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sura.com.IncidentManagement.entity.Application;

@Repository
public interface ApplicationRepo extends JpaRepository<Application, Long> {
    
}
