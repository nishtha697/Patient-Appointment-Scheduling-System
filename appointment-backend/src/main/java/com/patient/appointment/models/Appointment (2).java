package com.patient.appointment.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Appointment class using Appointment collection.
 * 
 * @author - Nishtha Goswami
 */
@Entity
@Document(collection = "Appointment")
public class Appointment {
	
	@Transient
	    public static final String SEQUENCE_NAME = "appointments_sequence";

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private long patientId;
	private String slug;
	private String disease;
	private Date time;
	private String doctor;
	private String nurse;
	private String room;
	/**
	 * Constructor for Appointment class.
	 * 
	 * @param builder
	 *            - builder object.
	 */
	private Appointment(AppointmentBuilder builder) {
		this.patientId = builder.patientId;
		this.slug = builder.slug;
		this.disease = builder.disease;
		this.time = builder.time;
		this.doctor = builder.doctor;
		this.nurse = builder.nurse;
		this.room = builder.room;
		//this.patient = builder.

	}
	
	/**
	 * Setter for appointment id.
	 * 
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Getter for appointment id
	 * 
	 * @return appointment id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Getter for patient id
	 * 
	 * @return patient id
	 */
	public long getPatientId() {
		return patientId;
	}

	/**
	 * Getter for slug 
	 * 
	 * @return slug
	 */
	public String getSlug() {
		return slug;
	}

	/**
	 * Getter for disease 
	 * 
	 * @return disease 
	 */
	public String getDisease() {
		return disease;
	}

	/**
	 * Getter for appointment time and date 
	 * 
	 * @return time - appointment time and date
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * Getter for doctor 
	 * 
	 * @return doctor - name of the consulting doctor
	 */
	public String getDoctor() {
		return doctor;
	}

	/**
	 * Getter for nurse 
	 * 
	 * @return nurse -  name of the nurse assisting 
	 */
	public String getNurse() {
		return nurse;
	}

	/**
	 * Getter for room number and type
	 * 
	 * @return room - room number and type
	 */
	public String getRoom() {
		return room;
	}

	/**
	 * Builder class used for constructing Appointment objects.
	 * 
	 * @author Nishtha Goswami
	 */
	public static class AppointmentBuilder {
		@Id
		private long id;
		private long patientId;
		private String slug;
		private String disease;
		private Date time;
		private String doctor;
		private String nurse;
		private String room;

		/**
		 * Default constructor for builder
		 */
		public AppointmentBuilder() {
			
		}
		/**
		 * Constructor sets the values to builder.
		 * 
		 * @param id
		 *            - appointment id
		 * @param patientId
		 *            - patient id
		 * @param disease
		 *            - disease
		 * @param time
		 *            - appointment date and time
		 * @param doctor
		 *            - name of the doctor
		 * @param room
		 *            - room number and type alloted
		 * @param name
		 *            - patient name
		 * @param dob
		 *            - patient's date of birth
		 * @param gender
		 *            - gender (Female/ Male/ Other)
		 * @param address
		 *            - current address
		 * @param city
		 *            - city
		 * @param state
		 *            - state
		 * @param country
		 *            - country
		 * @param zip
		 *            - zip code
		 * @param phone
		 *            - phone number
		 */
		public AppointmentBuilder(int id, int patientId, String disease,
				Date time, String doctor, String room, String name, Date dob,
				String gender, String address, String city, String state,
				String country, int zip, long phone) {

			this.patientId = patientId;
			this.disease = disease;
			this.time = time;
			this.doctor = doctor;
			this.room = room;
			
		}
		
		/**
		 * Method to update the patient Id.
		 * @param id - id
		 * @return this - current AppointmentBuilder object
		 */
		public AppointmentBuilder id(long id) {
			this.id = id;
			return this;
		}
		
		/**
		 * Method to update the patient Id.
		 * @param patientId - patient Id
		 * @return this - current AppointmentBuilder object
		 */
		public AppointmentBuilder patientId(long patientId) {
			this.patientId = patientId;
			return this;
		}

		/**
		 * Setting the slug by adding full name and appointment id.
		 * 
		 * @param name - Patient's name
		 * @param id - Appointment id
		 * @return this - current AppointmentBuilder object
		 */
		public AppointmentBuilder setSlug(String name, int id) {
			String[] splitName = name.trim().split("\\s+");
			int nameLength = splitName.length;
			this.slug = "";
			for (int counter = 0; counter < nameLength; counter++) {
				this.slug += splitName[counter] + "-";
			}
			this.slug += id;
			return this;
		}
	
		/**
		 * Method to update the patient's disease.
		 * @param disease - disease name
		 * @return this - current AppointmentBuilder object
		 */
		public AppointmentBuilder disease(String disease) {
			this.disease = disease;
			return this;
		}

		/**
		 * Method to update the appointment's time and date.
		 * @param time - appointment's time and date
		 * @return this - current AppointmentBuilder object
		 */
		public AppointmentBuilder time(Date time) {
			this.time = time;
			return this;
		}

		/**
		 * Method to update the consulting doctor's name.
		 * @param doctor - consulting doctor's name
		 * @return this - current AppointmentBuilder object
		 */
		public AppointmentBuilder doctor(String doctor) {
			this.doctor = doctor;
			return this;
		}

		/**
		 * Method to update the assisting nurse's name.
		 * @param nurse - assisting nurse's name
		 * @return this - current AppointmentBuilder object
		 */
		public AppointmentBuilder nurse(String nurse) {
			this.nurse = nurse;
			return this;
		}

		/**
		 * Method to update the room number and type for consultation.
		 * @param room - room number and type
		 * @return this - current AppointmentBuilder object
		 */
		public AppointmentBuilder room(String room) {
			this.room = room;
			return this;
		}
		
		/**
		 * Method to build the AppointmentBBuilder.
		 * @return Appointment - current Appointment object.
		 */
		public Appointment build() {
			return new Appointment(this);
		}
	}
}
