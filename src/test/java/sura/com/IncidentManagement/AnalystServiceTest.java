package sura.com.IncidentManagement;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sura.com.IncidentManagement.dto.ActionExecutedDTO;
import sura.com.IncidentManagement.dto.AnalystDTO;
import sura.com.IncidentManagement.service.AnalystService;

@SpringBootTest
public class AnalystServiceTest {
    
    @Autowired
    AnalystService analystService;

    @Test
	public void testFindAllActionExecuted(){

		List<AnalystDTO> expectedResult = new ArrayList<AnalystDTO>();

        expectedResult.add(createItem(1l, "Daniel Felipe Suarez Bohorquez", "dfsuarez@sura.com.co", 1l));
        expectedResult.add(createItem(2l, "Juan Pablo Alvarez Quintero", "jpalvarez@sura.com.co", 1l));
        expectedResult.add(createItem(3l, "Arley Giovany Berrio Gonzales", "agberrio@sura.com.co", 1l));
        expectedResult.add(createItem(4l, "Francisco Javier Melo Rodriguez", "fjmelo@sura.com.co", 2l));

		final List<AnalystDTO> result = analystService.findAll();

		Assertions.assertEquals(expectedResult.get(0).getId(), result.get(0).getId());
		Assertions.assertEquals(expectedResult.get(1).getId(), result.get(1).getId());
		Assertions.assertEquals(expectedResult.get(2).getId(), result.get(2).getId());
		Assertions.assertEquals(expectedResult.get(3).getId(), result.get(3).getId());


	}

    private AnalystDTO createItem(Long id, String name, String email, Long group_id){
        AnalystDTO analystDTO = new AnalystDTO();
        analystDTO.setId(id);
        analystDTO.setName(name);
        analystDTO.setEmail(email);
        analystDTO.setGroup_id(group_id);
        return analystDTO;
    }

}
