package com.patient.appointment.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class to auto increment ids. 
 * 
 * @author Nishtha Goswami
 */
@Document(collection = "database_sequences")
public class DatabaseSequence {

    @Id
    private String id;

    private long seq;

    public DatabaseSequence() {}

    /**
     * Getter for appointment Id.
     * @return id - appointment Id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter for appointment id.
     * @param id - appointment id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for sequence.
     * @return seq - sequence.
     */
    public long getSeq() {
        return seq;
    }

    /**
     * Setter for sequence.
     * @param seq - sequence.
     */
    public void setSeq(long seq) {
        this.seq = seq;
    }
}