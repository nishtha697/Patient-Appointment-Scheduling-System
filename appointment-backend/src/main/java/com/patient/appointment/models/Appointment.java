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
	private Appointment(String slug, String disease, Date time, String doctor, String nurse, String room) {
		this.slug = slug;
		this.disease = disease;
		this.time = time;
		this.doctor = doctor;
		this.nurse = nurse;
		this.room = room;

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
	 * Static method for builder class.
	 * @return AppointmentBuilder - AppointmentBuilder object
	 */
	public static AppointmentBuilder builder() {
	        return new AppointmentBuilder();
	}

	/**
	 * Builder class used for constructing Appointment objects.
	 * 
	 * @author Nishtha Goswami
	 */
	public static class AppointmentBuilder {
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
		 * Constructor for AppointmentBuilder.
		 * @param appointment - appointment object 
		 */
		public AppointmentBuilder(Appointment appointment) {
			this.slug = appointment.getSlug();
			this.disease = appointment.getDisease();
			this.time = appointment.getTime();
			this.doctor = appointment.getDoctor();
			this.nurse = appointment.getNurse();
			this.room = appointment.getRoom();			
		}
		
		/**
		 * Constructor sets the values to builder.
		 *
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
		public AppointmentBuilder(String disease,
				Date time, String doctor, String room) {

			this.disease = disease;
			this.time = time;
			this.doctor = doctor;
			this.room = room;
			
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
			return new Appointment(slug, disease, time, doctor, nurse, room);
		}
	}
}
