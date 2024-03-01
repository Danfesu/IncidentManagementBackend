package sura.com.IncidentManagement;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sura.com.IncidentManagement.dto.StateRaizalDTO;
import sura.com.IncidentManagement.service.StateRaizalService;

@SpringBootTest
public class StateRaizalServiceTest {
    
    @Autowired
    StateRaizalService service;

    @Test
    public void testFindAllStateRaizal(){
        List<StateRaizalDTO> expectedResult = new ArrayList<StateRaizalDTO>();

        expectedResult.add(createItem(1l, "Identificada"));
        expectedResult.add(createItem(2l, "En curso"));
        expectedResult.add(createItem(3l, "Por identificar"));
        expectedResult.add(createItem(4l, "Aislado"));
        expectedResult.add(createItem(5l, "Finalizada"));
        expectedResult.add(createItem(6l, "N/A"));

		List<StateRaizalDTO> result = service.findAll();

		Assertions.assertEquals(expectedResult.get(0).getId(), result.get(0).getId());
		Assertions.assertEquals(expectedResult.get(1).getId(), result.get(1).getId());
		Assertions.assertEquals(expectedResult.get(2).getId(), result.get(2).getId());
		Assertions.assertEquals(expectedResult.get(3).getId(), result.get(3).getId());
		Assertions.assertEquals(expectedResult.get(4).getId(), result.get(4).getId());
		Assertions.assertEquals(expectedResult.get(5).getId(), result.get(5).getId());

    }

    public StateRaizalDTO createItem(Long id, String type){
        StateRaizalDTO stateRaizalDTO = new StateRaizalDTO();
        stateRaizalDTO.setId(id);
        stateRaizalDTO.setType(type);
        return stateRaizalDTO;
    }

}
