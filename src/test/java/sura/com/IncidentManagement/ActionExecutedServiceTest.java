package sura.com.IncidentManagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sura.com.IncidentManagement.dto.ActionExecutedDTO;
import sura.com.IncidentManagement.service.ActionExecutedService;

@SpringBootTest
public class ActionExecutedServiceTest {
    
    @Autowired
    ActionExecutedService actionExecutedService;

    @Test
	public void testFindAllActionExecuted(){

		List<ActionExecutedDTO> expectedResult = new ArrayList<ActionExecutedDTO>();

        expectedResult.add(createItem(1l, "Modificacion Dato"));
        expectedResult.add(createItem(2l, "Modificacion Codigo"));
        expectedResult.add(createItem(3l, "Afectacion Temporal por Aplicativo Dependiente"));
        expectedResult.add(createItem(4l, "Despliegue de EAR"));
        expectedResult.add(createItem(5l, "Compilaciones"));
        expectedResult.add(createItem(6l, "Capacitacion - Tiene la opcion pero no sabe como hacerlo"));
        expectedResult.add(createItem(7l, "Capacitacion por proceso de negocio"));
        expectedResult.add(createItem(8l, "Capacitacion en el uso del aplicativo"));
        expectedResult.add(createItem(9l, "Perfilacion / Accesos - El usuario no cuenta con los permisos"));
        expectedResult.add(createItem(10l, "Usuario Inactivo"));
        expectedResult.add(createItem(11l, "Reinicio de servicios"));
        expectedResult.add(createItem(12l, "Cache de navegador"));
        expectedResult.add(createItem(13l, "Proceso de cuadres corrientes nomina"));
        expectedResult.add(createItem(14l, "Requiere implementacion en el aplicativo"));
        expectedResult.add(createItem(15l, "Analizar log"));
        expectedResult.add(createItem(16l, "Ingreso de informacion errada por parte de usuario"));
        expectedResult.add(createItem(17l, "Redespliegue"));
        expectedResult.add(createItem(18l, "Desbloquear Sesion/Operacion"));
        expectedResult.add(createItem(19l, "Carga de documentos despues de reportado el caso"));

		final List<ActionExecutedDTO> result = actionExecutedService.findAll();

		Assertions.assertEquals(expectedResult.get(0).getId(), result.get(0).getId());
		Assertions.assertEquals(expectedResult.get(1).getId(), result.get(1).getId());
		Assertions.assertEquals(expectedResult.get(2).getId(), result.get(2).getId());
		Assertions.assertEquals(expectedResult.get(3).getId(), result.get(3).getId());
		Assertions.assertEquals(expectedResult.get(4).getId(), result.get(4).getId());
		Assertions.assertEquals(expectedResult.get(5).getId(), result.get(5).getId());
		Assertions.assertEquals(expectedResult.get(6).getId(), result.get(6).getId());
		Assertions.assertEquals(expectedResult.get(7).getId(), result.get(7).getId());
		Assertions.assertEquals(expectedResult.get(8).getId(), result.get(8).getId());
		Assertions.assertEquals(expectedResult.get(9).getId(), result.get(9).getId());
		Assertions.assertEquals(expectedResult.get(10).getId(), result.get(10).getId());
		Assertions.assertEquals(expectedResult.get(11).getId(), result.get(11).getId());
		Assertions.assertEquals(expectedResult.get(12).getId(), result.get(12).getId());
		Assertions.assertEquals(expectedResult.get(13).getId(), result.get(13).getId());
		Assertions.assertEquals(expectedResult.get(14).getId(), result.get(14).getId());
		Assertions.assertEquals(expectedResult.get(15).getId(), result.get(15).getId());
		Assertions.assertEquals(expectedResult.get(16).getId(), result.get(16).getId());
		Assertions.assertEquals(expectedResult.get(17).getId(), result.get(17).getId());
		Assertions.assertEquals(expectedResult.get(18).getId(), result.get(18).getId());


	}


    private ActionExecutedDTO createItem(Long id, String description){
        ActionExecutedDTO actionExecutedDTO = new ActionExecutedDTO();
        actionExecutedDTO.setId(id);
        actionExecutedDTO.setDescription(description);
        return actionExecutedDTO;
    }

}
