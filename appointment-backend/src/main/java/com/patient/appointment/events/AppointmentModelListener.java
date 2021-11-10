package com.patient.appointment.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.patient.appointment.models.Appointment;
import com.patient.appointment.services.SequenceGeneratorService;

/**
 * Listener class for Appointment Model
 * @author Nishtha Goswami
 *
 */
@Component
public class AppointmentModelListener extends AbstractMongoEventListener<Appointment> {

    private SequenceGeneratorService sequenceGenerator;

    /**
     * Constructor for AppointmentModelListener 
     * @param sequenceGenerator
     */
    @Autowired
    public AppointmentModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    /**
     * Method to set id sequence for appointments
     */
    @Override
    public void onBeforeConvert(BeforeConvertEvent<Appointment> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Appointment.SEQUENCE_NAME));
        }
    }
   


}
