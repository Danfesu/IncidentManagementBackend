package sura.com.IncidentManagement.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sura.com.IncidentManagement.dto.ActionExecutedDTO;
import sura.com.IncidentManagement.dto.ApplicationDTO;
import sura.com.IncidentManagement.dto.CauseErrorDTO;
import sura.com.IncidentManagement.dto.IncidentDTO;
import sura.com.IncidentManagement.dto.SolutionManagerDTO;
import sura.com.IncidentManagement.dto.StateRaizalDTO;
import sura.com.IncidentManagement.service.ActionExecutedService;
import sura.com.IncidentManagement.service.ApplicationService;
import sura.com.IncidentManagement.service.CauseErrorService;
import sura.com.IncidentManagement.service.IncidentService;
import sura.com.IncidentManagement.service.SolutionManagerService;
import sura.com.IncidentManagement.service.StateRaizalService;

@RestController
@RequestMapping("/IncidentManagement")
@CrossOrigin
public class MainController {
    
    @Autowired
    SolutionManagerService solutionManagerService;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    StateRaizalService stateRaizalService;

    @Autowired
    CauseErrorService causeErrorService;

    @Autowired
    ActionExecutedService actionExecutedService;

    @Autowired
    IncidentService incidentService;

    @GetMapping("/fetchAllSolutionManager")
    public ResponseEntity<List<SolutionManagerDTO>> fetchAllSolutionManager(){
        return new ResponseEntity<List<SolutionManagerDTO>>(solutionManagerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/fetchAllApplication")
    public ResponseEntity<List<ApplicationDTO>> fetchAllApplication(){
        return new ResponseEntity<List<ApplicationDTO>>(applicationService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/fetchAllStateRaizal")
    public ResponseEntity<List<StateRaizalDTO>> fetchAllStateRaizal(){
        return new ResponseEntity<List<StateRaizalDTO>>(stateRaizalService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/fetchAllCauseError")
    public ResponseEntity<List<CauseErrorDTO>> fetchAllCauseError(){
        return new ResponseEntity<List<CauseErrorDTO>>(causeErrorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/fetchAllActionExecuted")
    public ResponseEntity<List<ActionExecutedDTO>> fetchAllActionExecuted(){
        return new ResponseEntity<List<ActionExecutedDTO>>(actionExecutedService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/fetchAllIncidents")
    public ResponseEntity<List<IncidentDTO>> fetchAllIncidents(){
        return new ResponseEntity<List<IncidentDTO>>(incidentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/fetchAmountIncidentsPerDay")
    public ResponseEntity<List<Object[]>> fetchIncidentsPerDay(@RequestParam String startDate, @RequestParam String endDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return new ResponseEntity<List<Object[]>>(incidentService.getAmountIncidentsPerDay(LocalDate.parse(startDate, formatter), LocalDate.parse(endDate, formatter)), HttpStatus.OK);
    }

    @GetMapping("/fetchAmountIncidentsPerApp")
    public ResponseEntity<List<Object[]>> fetchIncidentsPerApp(@RequestParam String startDate, @RequestParam String endDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return new ResponseEntity<List<Object[]>>(incidentService.getAmountIncidentsPerApp(LocalDate.parse(startDate, formatter), LocalDate.parse(endDate, formatter)), HttpStatus.OK);
    }

    @PostMapping("/saveIncident")
    public ResponseEntity<IncidentDTO> saveIncident(@RequestBody IncidentDTO incidentDTO){
        try {
            IncidentDTO savedIncident = incidentService.save(incidentDTO);
            return new ResponseEntity<>(savedIncident, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fetchSolutionTemplate/{id}")
    public ResponseEntity<String> fetchSolutionTemplate(@PathVariable Long id){
        return new ResponseEntity<String>(incidentService.getSolutionTemplate(id), HttpStatus.OK);
    }
}
