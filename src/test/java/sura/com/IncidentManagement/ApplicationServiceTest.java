package sura.com.IncidentManagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sura.com.IncidentManagement.service.ApplicationService;

@SpringBootTest
public class ApplicationServiceTest {
    
    @Autowired
    ApplicationService applicationService;

    @Test
	public void testApplication(){

        String expectedResult = "P8";
		String result = applicationService.findById(1l);
		Assertions.assertEquals(expectedResult, result);

        expectedResult = "Asistah";
		result = applicationService.findById(2l);
		Assertions.assertEquals(expectedResult, result);

        expectedResult = "Casetracking";
		result = applicationService.findById(3l);
		Assertions.assertEquals(expectedResult, result);

        expectedResult = "Sarlaft";
		result = applicationService.findById(4l);
		Assertions.assertEquals(expectedResult, result);

        expectedResult = "Somossura";
		result = applicationService.findById(5l);
		Assertions.assertEquals(expectedResult, result);

        expectedResult = "Viafirma";
		result = applicationService.findById(6l);
		Assertions.assertEquals(expectedResult, result);

	}

}
