package com.patient.appointment;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Date;
import java.util.stream.StreamSupport;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.patient.appointment.models.Appointment;
import com.patient.appointment.repositories.AppointmentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentControllerTests {

	 	final String disease = "Dengue";
	 	final Date time = new Date(2019-9-02);
        final String doctor = "Dr. Mahima Batra";
        final String room = "Consultation Room 1";

	    @Autowired
	    private AppointmentRepository appointmentRepository;

	    @Test
	    public void saveAndGetTestWithBuilder() {
	        final Date time = new Date(2019-9-02);
	        final String doctor = "Dr. Mahima Batra";
	        final String room = "Consultation Room 1";

	        Appointment appointment = Appointment.builder().disease(disease)
	                .time(time).doctor(doctor).room(room).build();

	        appointment = appointmentRepository.save(appointment);
	        assertThat("Appointment disease did not match!", appointment.getDisease(), is(disease));
	        assertThat("Appointment time did not match!", appointment.getTime(), is(time));
	        assertThat("Appointment doctor did not match!", appointment.getDoctor(), is(doctor));
	        assertThat("Appointment room did not match!", appointment.getRoom(), is(room));
	    }

	    @Test
	    public void saveAndFindAllTest() {
	        appointmentRepository.save(Appointment.builder().disease(disease).time(time).doctor(doctor).room(room).build());
	        appointmentRepository
	                .save(Appointment.builder().disease("Tonsils").time(time).doctor("Dr. Karan Johar").room("Consultation Room 2").build());
	        appointmentRepository
            .save(Appointment.builder().disease("Fever").time(time).doctor("Dr. Shipra").room("Consultation Room 3").build());
	        final Iterable<Appointment> findAll = appointmentRepository.findAll();
	        assertThat("Objects are not added to the repository", findAll, notNullValue());

	        final Appointment appointment = StreamSupport.stream(findAll.spliterator(), false).findFirst().get();
	        assertThat("Did not get any appointments", appointment, notNullValue());
	    }

}


