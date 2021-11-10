package com.patient.appointment.controllers;

import com.patient.appointment.models.Appointment;
import com.patient.appointment.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Appointment controller class
 * 
 * @author Nishtha Goswami
 *
 */
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" }, allowedHeaders = "*")
@RestController
public class AppointmentController {

	@Autowired
	AppointmentRepository appointmentRepository;

	/**
	 * Method to find all the appointments.
	 * 
	 * @return appointments
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/appointments")
	public Iterable<Appointment> appointment() {
		return appointmentRepository.findAll();
	}

	/**
	 * Method to save appointment to database.
	 * 
	 * @param appointment
	 * @return appointment
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/appointments")
	public Appointment save(@RequestBody Appointment appointment) {
		appointmentRepository.save(appointment);
		return appointment;
	}

	/**
	 * Method to show a particular appointment
	 * 
	 * @param slug
	 *            - unique identifier combining patient'name and appointment id
	 * @return appointment
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/show-appointment/{slug}")
	public Optional<Appointment> show(@PathVariable String slug) {
		return appointmentRepository.findBySlug(slug);
	}

	/**
	 * Method to update or edit an existing appointment
	 * 
	 * @param id
	 *            - appointment Id
	 * @param appointment
	 * @return appointment
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/appointments/{id}")
	public Appointment.AppointmentBuilder update(@PathVariable int id,
			@RequestBody Appointment appointment) {
		Optional<Appointment.AppointmentBuilder> optappointment = appointmentRepository
				.findById(id);
		Appointment.AppointmentBuilder _appointment = optappointment.get();

		String disease = appointment.getDisease();
		if (disease != null && !disease.isEmpty())
			_appointment.disease(appointment.getDisease());

		if (appointment.getTime() != null)
			_appointment.time(appointment.getTime());

		String doctor = appointment.getDoctor();
		if (doctor != null && !doctor.isEmpty())
			_appointment.doctor(appointment.getDoctor());

		String nurse = appointment.getNurse();
		if (nurse != null && !nurse.isEmpty())
			_appointment.nurse(appointment.getNurse());

		String room = appointment.getRoom();
		if (room != null && !room.isEmpty())
			_appointment.room(appointment.getRoom());

		appointmentRepository.save(_appointment.build());

		return _appointment;
	}

}
