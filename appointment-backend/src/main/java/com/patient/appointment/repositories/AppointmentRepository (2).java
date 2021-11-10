package com.patient.appointment.repositories;

import com.patient.appointment.models.Appointment;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, String>{

	@Override
    void delete(Appointment deleted);
	
	void save(Appointment.AppointmentBuilder appointment);
	
	Optional<Appointment> findBySlug(String slug);
	
	Optional<Appointment.AppointmentBuilder> findById(int id);
	
	
	
}
