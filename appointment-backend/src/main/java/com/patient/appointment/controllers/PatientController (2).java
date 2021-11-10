package com.patient.appointment.controllers;

import com.patient.appointment.models.Patient;
import com.patient.appointment.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
public class PatientController {

	@Autowired
    PatientRepository patientRepository;

    @RequestMapping(method=RequestMethod.GET, value="/contacts")
    public Iterable<Patient> patient() {
        return patientRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/contacts")
    public Patient save(@RequestBody Patient patient) {
    	patientRepository.save(patient);

        return patient;
    }

    @RequestMapping(method=RequestMethod.GET, value="/patients/{id}")
    public Optional<Patient> show(@PathVariable String id) {
        return patientRepository.findById(id);
    }
        
    @RequestMapping(method=RequestMethod.PUT, value="/patients/{id}")
    public Patient.PatientBuilder update(@PathVariable long id, @RequestBody Patient patient) {
        Optional<Patient.PatientBuilder> optpatient = patientRepository.findById(id);
        Patient.PatientBuilder _patient = optpatient.get();
        
        String name = patient.getName();
        if(name != null && !name.isEmpty())
            _patient.name(name);
        Date dob = patient.getDob();
        if(dob != null)
            _patient.dob(dob);
        String gender = patient.getGender();
        if(gender != null && !gender.isEmpty())
            _patient.gender(gender);
        String guardian = patient.getGuardian();
        if(guardian != null && !guardian.isEmpty())
            _patient.guardian(guardian);
        String address = patient.getAddress();
        if(address != null && !address.isEmpty())
            _patient.address(address);
        String city = patient.getCity();
        if(city != null && !city.isEmpty())
            _patient.city(city);
        String state = patient.getState();
        if(state != null && !state.isEmpty())
            _patient.name(state);
        String country = patient.getCountry();
        if(country != null && !country.isEmpty())
            _patient.country(country);
        int zip = patient.getZip();
        if(zip != 0)
            _patient.zip(zip);
        long phone = patient.getPhone();
        if(phone != 0)
            _patient.phone(phone);
        String insuranceNo = patient.getInsuranceNo();
        if(insuranceNo != null && !insuranceNo.isEmpty())
            _patient.insuranceNo(insuranceNo);
        String insuranceName = patient.getInsuranceName();
        if(insuranceName != null && !insuranceName.isEmpty())
            _patient.insuranceName(insuranceName);
        
       patientRepository.save(_patient.build());
        
        return _patient;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/patients/{id}")
    public String delete(@PathVariable String id) {
        Optional<Patient> optcontact = patientRepository.findById(id);
        Patient patient = optcontact.get();
        patientRepository.delete(patient);

        return "";
    }
}
