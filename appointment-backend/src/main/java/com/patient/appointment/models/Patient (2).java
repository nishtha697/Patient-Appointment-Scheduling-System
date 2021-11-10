package com.patient.appointment.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Patient")
public class Patient {
		
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

	    public Patient() {
	    }

	    public Patient(PatientBuilder builder) {
	        this.name = builder.name;
	        this.dob = builder.dob;
	        this.gender = builder.gender;
	        this.guardian = builder.guardian;
	        this.address = builder.address;
	        this.city = builder.city;
	        this.state = builder.state;
	        this.country = builder.country;
	        this.zip = builder.zip;
	        this.phone = builder.phone;
	        this.insuranceNo = builder.insuranceNo;
	        this.insuranceName = builder.insuranceName;
	    }

	    public long getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }
	    
	    public Date getDob() {
	        return dob;
	    }

	    public String getGender() {
	        return gender;
	    }
	    
	    public String getGuardian() {
	        return guardian;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public String getCity() {
	        return city;
	    }
	    
	    public String getState() {
	        return state;
	    }

	    public String getCountry() {
	        return country;
	    }
	    
	    public int getZip() {
	        return zip;
	    }
	    
	    public long getPhone() {
	        return phone;
	    }
	    
	    public String getInsuranceNo() {
	        return insuranceNo;
	    }
	    
	    public String getInsuranceName() {
	        return insuranceName;
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
			 */
			public PatientBuilder(int id, String name, Date dob,
					String gender, String address, String city, String state,
					String country, int zip, long phone) {

				this.id = id;
				this.name = name;
				this.dob = dob;
				this.gender = gender;
				this.address = address;
				this.city = city;
				this.state = state;
				this.country = country;
				this.zip = zip;
				this.phone = phone;
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
			 * Method to build the PatientBuilder class.
			 * @return Patient - current Patient object.
			 */
			public Patient build() {
				return new Patient(this);
			}
		}

}

