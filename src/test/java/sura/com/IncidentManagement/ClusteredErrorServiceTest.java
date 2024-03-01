package sura.com.IncidentManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sura.com.IncidentManagement.dto.ClusteredErrorDTO;
import sura.com.IncidentManagement.service.ClusteredErrorService;

@SpringBootTest
public class ClusteredErrorServiceTest {
    
    @Autowired
    ClusteredErrorService cService;

    @Test
    public void testFindClusteredErrorSarlaft(){
        List<ClusteredErrorDTO> expectedResult = new ArrayList<ClusteredErrorDTO>();

        expectedResult.add(createItem(23l, "Error JOB_EJECUTA_SARLAFT", 4l));
        expectedResult.add(createItem(24l, "Desmarcacion pregunta PEP", 4l));
        expectedResult.add(createItem(25l, "Error al consultar el asesor", 4l));

		List<ClusteredErrorDTO> clusteredErrorDTOs = cService.findAll();

        List<ClusteredErrorDTO> result = clusteredErrorDTOs.stream()
            .filter(dto -> dto.getApplication_id().equals(4l))
            .collect(Collectors.toList());

		Assertions.assertEquals(expectedResult.get(0).getId(), result.get(0).getId());
		Assertions.assertEquals(expectedResult.get(1).getId(), result.get(1).getId());
		Assertions.assertEquals(expectedResult.get(2).getId(), result.get(2).getId());

        Assertions.assertEquals(expectedResult.get(0).getDescription(), result.get(0).getDescription());
		Assertions.assertEquals(expectedResult.get(1).getDescription(), result.get(1).getDescription());
		Assertions.assertEquals(expectedResult.get(2).getDescription(), result.get(2).getDescription());

        Assertions.assertEquals(expectedResult.get(0).getApplication_id(), result.get(0).getApplication_id());
		Assertions.assertEquals(expectedResult.get(1).getApplication_id(), result.get(1).getApplication_id());
		Assertions.assertEquals(expectedResult.get(2).getApplication_id(), result.get(2).getApplication_id());
    }


    private ClusteredErrorDTO createItem(Long id, String description, Long application_id){
        ClusteredErrorDTO clusteredErrorDTO = new ClusteredErrorDTO();
        clusteredErrorDTO.setId(id);
        clusteredErrorDTO.setDescription(description);
        clusteredErrorDTO.setApplication_id(application_id);
        return clusteredErrorDTO;
    }



}
