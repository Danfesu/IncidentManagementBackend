package sura.com.IncidentManagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sura.com.IncidentManagement.service.IncidentService;

@SpringBootTest
class IncidentServiceTest {

	@Autowired
	IncidentService incidentService;

	@Test
	public void testReportPerDay1(){

		List<Object[]> expectedResult = new ArrayList<Object[]>();

		final List<Object[]> result = 
			incidentService.getAmountIncidentsPerDay(LocalDate.of(2024, 02, 01), LocalDate.of(2024, 02, 02));

		Assertions.assertEquals(expectedResult.size(), result.size());

	}

	@Test
	public void testReportPerDay2(){

		List<Object[]> expectedResult = new ArrayList<Object[]>();

		expectedResult.add(new Object[]{"2024-02-11", 9});
		expectedResult.add(new Object[]{"2024-02-13", 2});
		expectedResult.add(new Object[]{"2024-02-05", 3});

		final List<Object[]> result = 
			incidentService.getAmountIncidentsPerDay(LocalDate.of(2024, 02, 01), LocalDate.of(2024, 02, 15));

		Assertions.assertEquals(expectedResult.size(), result.size());

	}

	@Test
	public void testReportPerApp1(){

		List<Object[]> expectedResult = new ArrayList<Object[]>();

		final List<Object[]> result = 
			incidentService.getAmountIncidentsPerApp(LocalDate.of(2024, 02, 01), LocalDate.of(2024, 02, 02));

		Assertions.assertEquals(expectedResult.size(), result.size());

	}

	@Test
	public void testReportPerApp2(){

		List<Object[]> expectedResult = new ArrayList<Object[]>();

		expectedResult.add(new Object[]{"Sarlaft", 2});
		expectedResult.add(new Object[]{"Asistah", 5});
		expectedResult.add(new Object[]{"P8", 2});
		expectedResult.add(new Object[]{"Casetracking", 2});
		expectedResult.add(new Object[]{"Somossura", 1});
		expectedResult.add(new Object[]{"Viafirma", 2});

		final List<Object[]> result = 
			incidentService.getAmountIncidentsPerApp(LocalDate.of(2024, 02, 01), LocalDate.of(2024, 02, 15));

		Assertions.assertEquals(expectedResult.size(), result.size());

	}


}
