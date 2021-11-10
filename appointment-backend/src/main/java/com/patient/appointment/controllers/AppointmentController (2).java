package com.patient.appointment.controllers;

import com.patient.appointment.models.Appointment;
import com.patient.appointment.repositories.PatientRepository;
import com.patient.appointment.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AppointmentController {
	@Autowired
    PatientRepository patientRepository;
	
	@Autowired
    AppointmentRepository appointmentRepository;
	
    @RequestMapping(method=RequestMethod.GET, value="/appointments")
    public Iterable<Appointment> appointment() {
        return appointmentRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/appointments")
    public Appointment save(@RequestBody Appointment appointment) {
    	appointmentRepository.save(appointment);
        return appointment;
    }

    @RequestMapping(method=RequestMethod.GET, value="/show-appointment/{slug}")
    public Optional<Appointment> show(@PathVariable String slug) {
        return appointmentRepository.findBySlug(slug);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/appointments/{id}")
    public Appointment.AppointmentBuilder update(@PathVariable int id, @RequestBody Appointment appointment) {
        Optional<Appointment.AppointmentBuilder> optappointment = appointmentRepository.findById(id);
        Appointment.AppointmentBuilder _appointment = optappointment.get();
        
        String disease = appointment.getDisease();
        if(disease != null && !disease.isEmpty())
            _appointment.disease(appointment.getDisease());
        
        if(appointment.getTime() != null )
        	_appointment.time(appointment.getTime());
        
        String doctor = appointment.getDoctor();
        if(doctor != null && !doctor.isEmpty())
        	_appointment.doctor(appointment.getDoctor());
        
        String nurse = appointment.getNurse();
        if(nurse != null && !nurse.isEmpty())
        	_appointment.nurse(appointment.getNurse());
        
        String room = appointment.getRoom();
        if(room != null && !room.isEmpty())
        	_appointment.room(appointment.getRoom());
        
        appointmentRepository.save(_appointment.build());
        
        return _appointment;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/appointments/{slug}")
    public String delete(@PathVariable String id) {
        Optional<Appointment> optappointment = appointmentRepository.findById(id);
        Appointment appointment = optappointment.get();
        appointmentRepository.delete(appointment);

        return "";
    }

	
}
