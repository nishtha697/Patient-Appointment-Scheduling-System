package com.patient.appointment;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import com.patient.appointment.models.Appointment;

public class AppointmentTests {

	@Test
	public void setPatientIdTest() {
		Appointment appointment = new Appointment.AppointmentBuilder().patientId(1).build();
		assertEquals(1, appointment.getPatientId());
	}
	
	@Test
	public void setDiseaseTest() {
		Appointment appointment = new Appointment.AppointmentBuilder().disease("Dengue").build();
		assertEquals("Dengue", appointment.getDisease());
	}
	
	@Test
	public void setDoctorTest() {
		Appointment appointment = new Appointment.AppointmentBuilder().doctor("Dr. Mahima Batra").build();
		assertEquals("Dr. Mahima Batra", appointment.getDoctor());
	}
	
	@Test
	public void setNurseTest() {
		Appointment appointment = new Appointment.AppointmentBuilder().nurse("Miss Meera").build();
		assertEquals("Miss Meera", appointment.getNurse());
	}
	
	@Test
	public void setTime() {
		Date time = new Date(2019-9-02);
		Appointment appointment = new Appointment.AppointmentBuilder().time(time).build();
		assertEquals(time, appointment.getTime());
	}
	
	@Test
	public void setRoom() {
		Appointment appointment = new Appointment.AppointmentBuilder().room("Consultation Room 1").build();
		assertEquals("Consultation Room 1", appointment.getRoom());
	}

}
