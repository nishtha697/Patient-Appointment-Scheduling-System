package com.patient.appointment.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.patient.appointment.models.Patient;
import com.patient.appointment.services.SequenceGeneratorService;


/**
 * Listener class for Patient Model
 * @author Nishtha Goswami
 *
 */
@Component
public class PatientModelListener extends AbstractMongoEventListener<Patient> {

    private SequenceGeneratorService sequenceGenerator;


    /**
     * Constructor for PatientModelListener 
     * @param sequenceGenerator
     */
    @Autowired
    public PatientModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    /**
     * Method to set id sequence for patients
     */
    @Override
    public void onBeforeConvert(BeforeConvertEvent<Patient> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Patient.SEQUENCE_NAME));
        }
    }
}
