package sura.com.IncidentManagement.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sura.com.IncidentManagement.entity.Incident;

@Repository
public interface IncidentRepo extends JpaRepository<Incident, Long> {
    
    @Query("SELECT i.date, COUNT(i) FROM Incident i where i.date between :startDate AND :endDate GROUP BY i.date")
    List<Object[]> countByDate(@Param("startDate") LocalDate starDate, @Param("endDate") LocalDate endDate);


    @Query("SELECT a.name, COUNT(*) FROM Incident i \n" + //
            "inner join ClusteredError c on c.id = i.clusteredError.id\n" + //
            "inner join Application a on a.id = c.application.id\n" + //
            "where i.date between :startDate AND :endDate GROUP BY a.name")
    List<Object[]> countByApp(@Param("startDate") LocalDate starDate, @Param("endDate") LocalDate endDate);

}
