package sura.com.IncidentManagement.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncidentDTO {
    private Long id;

    private String diagnosis;

    private LocalDate date;

    private String solution;

    private boolean confirmed_operability;

    private String access_oc;

    private ClusteredErrorDTO clusteredError;

    private CauseErrorDTO causeError;

    private ActionExecutedDTO actionExecuted;

    private AnalystDTO analyst;

    private StateRaizalDTO stateRaizal;
}
