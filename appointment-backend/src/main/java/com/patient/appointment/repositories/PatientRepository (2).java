package com.patient.appointment.repositories;

import com.patient.appointment.models.Patient;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, String> {
	@Override
    void delete(Patient deleted);
	
	Optional<Patient.PatientBuilder> findById(long id);
	
	
}

