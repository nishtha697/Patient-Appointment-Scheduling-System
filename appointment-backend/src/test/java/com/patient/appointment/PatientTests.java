package com.patient.appointment;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import com.patient.appointment.models.Patient;

public class PatientTests {
	
	@Test
	public void setNameTest() {
		final String name = "Alan Smith";
		Patient patient = new Patient.PatientBuilder().name(name).build();
		assertEquals(name, patient.getName());
		
	}
	
	@Test
	public void setDobTest() {
		Date dob = new Date(1997-10-06);
		Patient patient = new Patient.PatientBuilder().dob(dob).build();
		assertEquals(dob, patient.getDob());
		
	}
	
	@Test
	public void setNameGender() {
		final String gender = "Male";
		Patient patient = new Patient.PatientBuilder().gender(gender).build();
		assertEquals(gender, patient.getGender());
		
	}
	
	@Test
	public void setAddressTest() {
		String address = "#222, 5th Block";
		Patient patient = new Patient.PatientBuilder().address(address).build();
		assertEquals(address, patient.getAddress());
		
	}
	
	@Test
	public void setCityTest() {
		final String city = "Bangalore";
		Patient patient = new Patient.PatientBuilder().city(city).build();
	assertEquals(city, patient.getCity());
		
	}
	
	@Test
	public void setStateTest() {
		final String state = "Karnataka";
		Patient patient = new Patient.PatientBuilder().state(state).build();
		assertEquals(state, patient.getState());
	}
	
	@Test
	public void setCountryTest() {
		final String country = "India";
		Patient patient = new Patient.PatientBuilder().country(country).build();
		assertEquals(country, patient.getCountry());
		
	}
	
	@Test
	public void setZipTest() {
		final int zip = 603203;
		Patient patient = new Patient.PatientBuilder().zip(zip).build();
		assertEquals(zip, patient.getZip());
	}

	@Test
	public void setPhoneTest() {
		final long phone = 9878675645L;
		Patient patient = new Patient.PatientBuilder().phone(phone).build();
		assertEquals(phone, patient.getPhone());
	}
	
	@Test
	public void setInsuranceNoTest() {
		final String insuranceNo = "123abc";
		Patient patient = new Patient.PatientBuilder().insuranceNo(insuranceNo).build();
		assertEquals(insuranceNo, patient.getInsuranceNo());
	}
	
	@Test
	public void setInsuranceNameTest() {
		final String insuranceName = "ICICI Lombard";
		Patient patient = new Patient.PatientBuilder().insuranceName(insuranceName).build();
		assertEquals(insuranceName, patient.getInsuranceName());
		
	}
}
