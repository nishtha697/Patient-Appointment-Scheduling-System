package com.patient.appointment.controllers;

import com.patient.appointment.models.Patient;
import com.patient.appointment.repositories.AppointmentRepository;
import com.patient.appointment.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Patient controller class
 * @author Nishtha Goswami
 *
 */
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class PatientController {

	@Autowired
    PatientRepository patientRepository;
	
	@Autowired
    AppointmentRepository appointmentRepository;

	/**
	 * Method to find all the patients.
	 * @return patients
	 */
    @RequestMapping(method=RequestMethod.GET, value="/patient-appointments")
    public Iterable<Patient> patient() {
        return patientRepository.findAll();
    }

    /**
     * Method to save patient to database.
     * @param patient
     * @return patient
     */
    @RequestMapping(method=RequestMethod.POST, value="/patient-appointments")
    public Patient save(@RequestBody Patient patient) {
    	appointmentRepository.save(patient.getAppointment());
    	patientRepository.save(patient);
    	return patient;
    }

    /**
     * Method to show a particular patient
     * @param id - patient's Id
     * @return patient
     */
    @RequestMapping(method=RequestMethod.GET, value="/show-patient/{id}")
    public Optional<Patient> show(@PathVariable long id) {
        return patientRepository.findById(id);
    }
        
}
