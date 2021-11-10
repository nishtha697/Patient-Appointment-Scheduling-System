package com.patient.appointment.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.patient.appointment.models.Appointment;
import com.patient.appointment.services.SequenceGeneratorService;


@Component
public class AppointmentModelListener extends AbstractMongoEventListener<Appointment> {

    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public AppointmentModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Appointment> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Appointment.SEQUENCE_NAME));
        }
    }


}
