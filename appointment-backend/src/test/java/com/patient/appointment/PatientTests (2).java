package com.patient.appointment;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import com.patient.appointment.models.Patient;

public class PatientTests {
	
	@Test
	public void setNameTest() {
		Patient patient = new Patient.PatientBuilder().name("Alan Smith").build();
		assertEquals("Alan Smith", patient.getName());
		
	}
	
	@Test
	public void setDobTest() {
		Date dob = new Date(1997-10-06);
		Patient patient = new Patient.PatientBuilder().dob(dob).build();
		assertEquals(dob, patient.getDob());
		
	}
	
	@Test
	public void setNameGender() {
		Patient patient = new Patient.PatientBuilder().gender("Male").build();
		assertEquals("Male", patient.getGender());
		
	}
	
	@Test
	public void setAddressTest() {
		String address = "#222, 5th Block";
		Patient patient = new Patient.PatientBuilder().address(address).build();
		assertEquals(address, patient.getAddress());
		
	}
	
	@Test
	public void setCityTest() {
		Patient patient = new Patient.PatientBuilder().city("Bangalore").build();
	assertEquals("Bangalore", patient.getCity());
		
	}
	
	@Test
	public void setStateTest() {
		Patient patient = new Patient.PatientBuilder().state("Karnataka").build();
		assertEquals("Karnataka", patient.getState());
	}
	
	@Test
	public void setCountryTest() {
		Patient patient = new Patient.PatientBuilder().country("India").build();
		assertEquals("India", patient.getCountry());
		
	}
	
	@Test
	public void setZipTest() {
		Patient patient = new Patient.PatientBuilder().zip(603203).build();
		assertEquals(603203, patient.getZip());
	}

	@Test
	public void setPhoneTest() {
		Patient patient = new Patient.PatientBuilder().phone(9999999999L).build();
		assertEquals(9999999999L, patient.getPhone());
	}
	
	@Test
	public void setInsuranceNoTest() {
		Patient patient = new Patient.PatientBuilder().insuranceNo("123abc").build();
		assertEquals("123abc", patient.getInsuranceNo());
	}
	
	@Test
	public void setInsuranceNameTest() {
		Patient patient = new Patient.PatientBuilder().insuranceName("ICICI Lombard").build();
		assertEquals("ICICI Lombard", patient.getInsuranceName());
		
	}
}
