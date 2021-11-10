package com.patient.appointment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.patient.appointment.models.DatabaseSequence;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * 
 * Sequence generator service class 
 * @author NG073320
 *
 */
@Service
public class SequenceGeneratorService {
	private MongoOperations mongoOperations;

	/**
	 * Constructor for SequenceGeneratorService
	 * @param mongoOperations
	 */
    @Autowired
    public SequenceGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    /**
     * Method to generate sequence for ids.
     * @param seqName - Appointment sequence or Patient sequence
     * @return sequence
     */
    public long generateSequence(String seqName) {

        DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;

    }

}
