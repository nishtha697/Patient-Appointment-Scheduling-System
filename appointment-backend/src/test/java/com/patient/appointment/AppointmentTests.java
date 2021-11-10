package com.patient.appointment;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import com.patient.appointment.models.Appointment;

public class AppointmentTests {
	
	
	@Test
	public void setDiseaseTest() {
		final String disease = "Dengue";
		Appointment appointment = new Appointment.AppointmentBuilder().disease(disease).build();
		assertEquals(disease, appointment.getDisease());
	}
	
	@Test
	public void setDoctorTest() {
		final String doctor = "Dr. Mahima Batra";
		Appointment appointment = new Appointment.AppointmentBuilder().doctor(doctor).build();
		assertEquals(doctor, appointment.getDoctor());
	}
	
	@Test
	public void setNurseTest() {
		final String nurse = "Miss Meera";
		Appointment appointment = new Appointment.AppointmentBuilder().nurse(nurse).build();
		assertEquals(nurse, appointment.getNurse());
	}
	
	@Test
	public void setTime() {
		Date time = new Date(2019-9-02);
		Appointment appointment = new Appointment.AppointmentBuilder().time(time).build();
		assertEquals(time, appointment.getTime());
	}
	
	@Test
	public void setRoom() {
		final String room = "Consultation Room 1";
		Appointment appointment = new Appointment.AppointmentBuilder().room(room).build();
		assertEquals(room, appointment.getRoom());
	}

}
