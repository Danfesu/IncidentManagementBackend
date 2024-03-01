package sura.com.IncidentManagement;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sura.com.IncidentManagement.service.GroupSolutionService;

@SpringBootTest
public class GroupSolutionServiceTest {
    
    @Autowired
    GroupSolutionService groupSolutionService;

    @Test
    public void testFindAllGroupSolution(){
        List<String> expectedResult = new ArrayList<String>();

        expectedResult.add("Operacion Post Venta y Transversales - Soluciones Administrativas TID");
        expectedResult.add("Soluciones Administrativas de TI - Dominio");

		List<String> result = new ArrayList<String>();

        result.add(groupSolutionService.findById(1l));
        result.add(groupSolutionService.findById(2l));

		Assertions.assertEquals(expectedResult.get(0), result.get(0));
		Assertions.assertEquals(expectedResult.get(1), result.get(1));
    }

}
