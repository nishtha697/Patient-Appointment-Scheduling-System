package com.patient.appointment.repositories;

import com.patient.appointment.models.Patient;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

/**
 * Patient repository interface
 * @author Nishtha Goswami
 *
 */
public interface PatientRepository extends CrudRepository<Patient, String> {
	
	/**
	 * Method to find patient by patient Id.
	 * @param id - patient's id
	 * @return patient
	 */
	Optional<Patient> findById(long id);
	

	
	
}

