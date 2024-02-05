package sura.com.IncidentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sura.com.IncidentManagement.dto.SolutionManagerDTO;
import sura.com.IncidentManagement.service.SolutionManagerService;

@RestController
@RequestMapping("/IncidentManagement")
@CrossOrigin
public class MainController {
    
    @Autowired
    SolutionManagerService solutionManagerService;

    @GetMapping("/fetchAllSolutionManager")
    public ResponseEntity<List<SolutionManagerDTO>> fetchAllSolutionManager(){
        return new ResponseEntity<List<SolutionManagerDTO>>(solutionManagerService.findAll(), HttpStatus.OK);
    }
}
