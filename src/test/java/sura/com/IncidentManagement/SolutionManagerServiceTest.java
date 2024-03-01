package sura.com.IncidentManagement;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sura.com.IncidentManagement.service.SolutionManagerService;

@SpringBootTest
public class SolutionManagerServiceTest {
    
    @Autowired
    SolutionManagerService service;

    @Test
    public void testFindAllSolutionManager(){
        List<String> expectedResult = new ArrayList<String>();

        expectedResult.add("TI");
        expectedResult.add("Negocio");

		List<String> result = new ArrayList<String>();

        result.add(service.findById(1l));
        result.add(service.findById(2l));

		Assertions.assertEquals(expectedResult.get(0), result.get(0));
		Assertions.assertEquals(expectedResult.get(1), result.get(1));
    }   

}
