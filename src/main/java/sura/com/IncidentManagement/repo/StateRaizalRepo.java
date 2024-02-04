package sura.com.IncidentManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sura.com.IncidentManagement.entity.StateRaizal;

@Repository
public interface StateRaizalRepo extends JpaRepository<StateRaizal, Long> {
    
}
