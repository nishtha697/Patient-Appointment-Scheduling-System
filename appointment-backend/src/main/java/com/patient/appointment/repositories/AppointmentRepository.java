package com.patient.appointment.repositories;

import com.patient.appointment.models.Appointment;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

/**
 * Class for appointment repository
 * @author Nishtha Goswami
 *
 */
public interface AppointmentRepository extends CrudRepository<Appointment, String>{

	@Override
    void delete(Appointment deleted);
	
	/**
	 * Method to save appointment.
	 * @param appointment
	 */
	void save(Appointment.AppointmentBuilder appointment);
	
	/**
	 * Method to find appointment by unique slug.
	 * @param slug - unique identifier combining patient's name and appointment id.
	 * @return slug
	 */
	Optional<Appointment> findBySlug(String slug);
	
	/**
	 * Method to find appointment by id.
	 * @param id - appointment's id
	 * @return appointment
	 */
	Optional<Appointment.AppointmentBuilder> findById(int id);

	
	
	
}
