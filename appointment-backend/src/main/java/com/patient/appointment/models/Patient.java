package com.patient.appointment.models;

import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Patient class using Patient collection
 * @author Nishtha Goswami
 *
 */
@Document(collection = "Patient_Appointments")
public class Patient {
		
		@Transient
		public static final String SEQUENCE_NAME = "patients_sequence";

	    @Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	    private long id;
	    private String name;
	    private Date dob;
	    private String gender;
	    private String guardian;
	    private String address;
	    private String city;
	    private String state;
	    private String country;
	    private int zip;
	    private long phone;
	    private String insuranceNo;
	    private String insuranceName;
	    private List<Appointment> appointments;

	    /**
	     * Constructor for Patient class 
	     * @param id - patient id
	     * @param name - patient's full name
	     * @param dob - patient's date of birth
	     * @param gender - patient's gender
	     * @param guardian - patient's guardian name
	     * @param address - patient's current mailing address 
	     * @param city - patient's city
	     * @param state - patient's state
	     * @param country - patient's country
	     * @param zip - patient's zip
	     * @param phone - patient's phone
	     * @param insuranceNo - patient's insuranceNo
	     * @param insuranceName - patient's insuranceName
	     */
	    public Patient(long id, String name, Date dob, String gender, 
	    		String guardian, String address, String city, String state, 
	    		String country, int zip, long phone, String insuranceNo, String insuranceName, 
	    		List<Appointment> appointments) {
	    	this.id = id;
	        this.name = name;
	        this.dob = dob;
	        this.gender = gender;
	        this.guardian = guardian;
	        this.address = address;
	        this.city = city;
	        this.state = state;
	        this.country = country;
	        this.zip = zip;
	        this.phone = phone;
	        this.insuranceNo = insuranceNo;
	        this.insuranceName = insuranceName;
	        this.appointments = appointments;
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
	     * Getter for patient's id
	     * @return id - patient's id
	     */
	    public long getId() {
	        return id;
	    }

	    /**
	     * Getter for patient's full name
	     * @return name - patient's name
	     */
	    public String getName() {
	        return name;
	    }
	    
	    /**
	     * Getter for patient's date of birth
	     * @return dob - patient's dob
	     */
	    public Date getDob() {
	        return dob;
	    }

	    /**
	     * Getter for patient's gender
	     * @return gender - patient's gender
	     */
	    public String getGender() {
	        return gender;
	    }
	    
	    /**
	     * Getter for patient's guardian's name
	     * @return guardian - patient's guardian's name
	     */
	    public String getGuardian() {
	        return guardian;
	    }

	    /**
	     * Getter for patient's address
	     * @return address - patient's address
	     */
	    public String getAddress() {
	        return address;
	    }

	    /**
	     * Getter for patient's city
	     * @return city - patient's city
	     */
	    public String getCity() {
	        return city;
	    }
	    
	    /**
	     * Getter for patient's state
	     * @return state - patient's state
	     */
	    public String getState() {
	        return state;
	    }

	    /**
	     * Getter for patient's country
	     * @return country - patient's country
	     */
	    public String getCountry() {
	        return country;
	    }
	    
	    /**
	     * Getter for patient's zip
	     * @return zip - patient's zip
	     */
	    public int getZip() {
	        return zip;
	    }
	    
	    /**
	     * Getter for patient's phone number
	     * @return phone - patient's phone number
	     */
	    public long getPhone() {
	        return phone;
	    }
	    
	    /**
	     * Getter for patient's insurance Number
	     * @return insuranceNo - patient's insurance Number
	     */
	    public String getInsuranceNo() {
	        return insuranceNo;
	    }
	    
	    /**
	     * Getter for patient's insurance name
	     * @return insuranceName - patient's insuranceName
	     */
	    public String getInsuranceName() {
	        return insuranceName;
	    }
	    
	    /**
	     * Getter for patient's appointments list
	     * @return appointments - patient's appointments list
	     */
	    public List<Appointment> getAppointments() {
	        return appointments;
	    }
	    
	    /**
	     * Getter for patient's appointments list
	     * @return appointments - patient's appointments list
	     */
	    public Appointment getAppointment() {
	        return appointments.get(appointments.size() - 1);
	    }
	    
	    /**
	     * Static method for builder class
	     * @return PatientBuilder -  PatientBuilder object 
	     */
	    public static PatientBuilder builder() {
	        return new PatientBuilder();
	    }
	    
	    /**
		 * Builder class used for constructing Patient objects.
		 * 
		 * @author Nishtha Goswami
		 */
		public static class PatientBuilder {
			@Id
			private long id;
			private String name;
			private Date dob;
			private String gender;
			private String guardian;
			private String address;
			private String city;
			private String state;
			private String country;
			private int zip;
			private long phone;
			private String insuranceNo;
		    private String insuranceName;
		    private List<Appointment> appointments;


			/**
			 * Default constructor for builder
			 */
			public PatientBuilder() {
				
			}
			/**
			 * Constructor sets the values to builder.
			 * 
			 * @param id
			 *            - appointment id
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
			 * @param appointments
			 * 			  - appointment's list
			 */
			public PatientBuilder(int id, String name, Date dob,
					String gender, String address, String city, String state,
					String country, int zip, long phone, List<Appointment> appointments) {

				this.name = name;
				this.dob = dob;
				this.gender = gender;
				this.address = address;
				this.city = city;
				this.state = state;
				this.country = country;
				this.zip = zip;
				this.phone = phone;
				this.appointments = appointments;
			}
			
			/**
			 * Method to update the patient Id.
			 * @param id - patient id
			 * @return this - current PatientBuilder object
			 */
			public PatientBuilder id(long id) {
				this.id = id;
				return this;
			}
			
			/**
			 * Method to update the patient's full name.
			 * @param name - patient's full name
			 * @return this - current PatientBuilder object
			 */
			public PatientBuilder name(String name) {
				this.name = name;
				return this;
			}
			
			/**
			 * Method to update the patient's date of birth.
			 * @param dob - patient's date of birth
			 * @return this - current PatientBuilder object
			 */
			public PatientBuilder dob(Date dob) {
				this.dob = dob;
				return this;
			}
			
			/**
			 * Method to update the patient's gender.
			 * @param gender - patient's gender
			 * @return this - current PatientBuilder object
			 */
			public PatientBuilder gender(String gender) {
				this.gender = gender;
				return this;
			}
			
			/**
			 * Method to update the patient's guardian's name.
			 * @param guardian - patient's guardian's name
			 * @return this - current PatientBuilder object
			 */
			public PatientBuilder guardian(String guardian) {
				this.guardian = guardian;
				return this;
			}
			
			/**
			 * Method to update the patient's current mailing address.
			 * @param address - patient's current mailing address
			 * @return this - current PatientBuilder object
			 */
			public PatientBuilder address(String address) {
				this.address = address;
				return this;
			}
			
			/**
			 * Method to update the patient's city.
			 * @param city - patient's city
			 * @return this - current PatientBuilder object
			 */
			public PatientBuilder city(String city) {
				this.city = city;
				return this;
			}
			
			/**
			 * Method to update the patient's state.
			 * @param state - patient's state
			 * @return this - current PatientBuilder object
			 */
			public PatientBuilder state(String state) {
				this.state = state;
				return this;
			}
			
			/**
			 * Method to update the patient's country.
			 * @param country - patient's country
			 * @return this - current PatientBuilder object
			 */
			public PatientBuilder country(String country) {
				this.country = country;
				return this;
			}
			
			/**
			 * Method to update the patient's zip code.
			 * @param zip - patient's zip code
			 * @return this - current PatientBuilder object
			 */
			public PatientBuilder zip(int zip) {
				this.zip = zip;
				return this;
			}
			
			/**
			 * Method to update the patient's phone number.
			 * @param phone - patient's phone number
			 * @return this - current PatientBuilder object
			 */
			public PatientBuilder phone(long phone) {
				this.phone = phone;
				return this;
			}
			
			/**
			 * Method to update the patient's insurance number.
			 * @param insuranceNo - patient's insurance number
			 * @return this - current PatientBuilder object
			 */
			public PatientBuilder insuranceNo(String insuranceNo) {
				this.insuranceNo = insuranceNo;
				return this;
			}
			
			/**
			 * Method to update the patient's insurance name.
			 * @param insuranceName - patient's insurance name
			 * @return this - current PatientBuilder object
			 */
			public PatientBuilder insuranceName(String insuranceName) {
				this.insuranceName = insuranceName;
				return this;
			}
			
			/**
			 * Method to update the patient's appointments list.
			 * @param appointments - patient's appointments list
			 * @return this - current PatientBuilder object
			 */
			public PatientBuilder appointments(List<Appointment> appointments) {
				this.appointments = appointments;
				return this;
			}
			
			/**
			 * Method to build the PatientBuilder class.
			 * @return Patient - current Patient object.
			 */
			public Patient build() {
				return new Patient(id, name, dob, gender, guardian, address, city, 
						state, country, zip, phone, insuranceNo, insuranceName, appointments);
			}
			
		}

}

