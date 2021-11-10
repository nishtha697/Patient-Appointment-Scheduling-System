import React from "react";
import TextInput from "./common/TextInput";
import PropTypes from "prop-types";

function AppointmentForm(props) {
  const style = {
    marginLeft: 100,
    marginRight: 100
  };

  const styleRed = {
    color: "red"
  };

  function dateToString(date) {
    var _date = new Date(date);
    var days = _date.getDate();
    if (days < 10) days = "0" + days;
    var month = _date.getMonth() + 1; //Current Month
    if (month < 10) month = "0" + month;
    var year = _date.getFullYear(); //Current Year
    var hours = _date.getHours(); //Current Hours
    if (hours < 10) hours = "0" + hours;
    var min = _date.getMinutes(); //Current Minutes
    if (min < 10) min = "0" + min;
    const dateString =
      year + "-" + month + "-" + days + "T" + hours + ":" + min;
    return dateString;
  }

  function addDays() {
    var date = new Date();
    date.setDate(date.getDate() + 7);
    return date;
  }

  var date = new Date(); //Current Date
  var minDate = dateToString(date);
  var nextDate = addDays();
  var maxDate = dateToString(nextDate);

  return (
    <form onSubmit={props.onSubmit}>
      <p style={styleRed}>* required fields</p>
      <h4 className="jumbotron">Personal Details</h4>
      <div style={style}>
        <TextInput
          id="name"
          label="Patient Full Name*"
          onChange={props.onChange}
          name="name"
          value={props.appointment.name}
          error={props.errors.name}
        />

        <div className="form-group">
          <label htmlFor="dob">Date of Birth*</label>
          <div className="field">
            <input
              id="dob"
              type="date"
              onChange={props.onChange}
              name="dob"
              className="form-control"
              value={props.appointment.dob || ""}
            />
          </div>
          {props.errors.dob && (
            <div className="alert alert-danger">{props.errors.dob}</div>
          )}
        </div>

        <div className="form-group">
          <label htmlFor="gender">Gender*</label>
          <div className="field">
            <select
              id="gender"
              onChange={props.onChange}
              name="gender"
              value={props.appointment.gender || ""}
              className="form-control"
            >
              <option value="" />
              <option value="Male">Male</option>
              <option value="Female">Female</option>
              <option value="Other">Other</option>
            </select>
          </div>
          {props.errors.dob && (
            <div className="alert alert-danger">{props.errors.gender}</div>
          )}
        </div>

        <TextInput
          id="guardian"
          label="Guardian Name (if patient less than 18)"
          onChange={props.onChange}
          name="guardian"
          value={props.appointment.guardian}
        />

        <TextInput
          id="disease"
          label="Disease*"
          onChange={props.onChange}
          name="disease"
          value={props.appointment.disease}
          error={props.errors.disease}
        />
      </div>
      <h4 className="jumbotron">Mailing Details</h4>
      <div style={style}>
        <TextInput
          id="address"
          label="Address*"
          onChange={props.onChange}
          name="address"
          value={props.appointment.address}
          error={props.errors.address}
        />

        <TextInput
          id="city"
          label="City*"
          onChange={props.onChange}
          name="city"
          value={props.appointment.city}
          error={props.errors.city}
        />
        <TextInput
          id="state"
          label="State*"
          onChange={props.onChange}
          name="state"
          value={props.appointment.state}
          error={props.errors.state}
        />

        <TextInput
          id="country"
          label="Country*"
          onChange={props.onChange}
          name="country"
          value={props.appointment.country}
          error={props.errors.country}
        />
        <TextInput
          id="zip"
          label="Zip Code*"
          onChange={props.onChange}
          name="zip"
          value={props.appointment.zip}
          error={props.errors.zip}
        />

        <TextInput
          id="phone"
          label="Phone Number*"
          onChange={props.onChange}
          name="phone"
          value={props.appointment.phone}
          error={props.errors.phone}
        />
      </div>
      <h4 className="jumbotron">Insurance Details</h4>
      <div style={style}>
        <TextInput
          id="insuranceName"
          label="Insurance Name"
          onChange={props.onChange}
          name="insuranceName"
          value={props.appointment.insuranceName}
        />
        <TextInput
          id="insuranceNo"
          label="Insurance Number"
          onChange={props.onChange}
          name="insuranceNo"
          value={props.appointment.insuranceNo}
        />
      </div>
      <h4 className="jumbotron">Appointment Details</h4>
      <div style={style}>
        <div className="form-group">
          <label htmlFor="time">Time*</label>
          <div className="field">
            <input
              id="time"
              type="datetime-local"
              onChange={props.onChange}
              name="time"
              value={props.appointment.time || ""}
              className="form-control"
              min={minDate}
              max={maxDate}
            />
          </div>
          {props.errors.dob && (
            <div className="alert alert-danger">{props.errors.time}</div>
          )}
        </div>

        <div className="form-group">
          <label htmlFor="doctor">Name of the Doctor Assisting*</label>
          <div className="field">
            <select
              id="doctor"
              onChange={props.onChange}
              name="doctor"
              value={props.appointment.doctor || ""}
              className="form-control"
            >
              <option value="" />
              <option value="Dr. Sajeev Mathur">Dr. Sajeev Mathur</option>
              <option value="Dr. Mahima Batra">Dr. Mahima Batra</option>
              <option value="Dr. Karan Johar">Dr. Karan Johar</option>
            </select>
          </div>
          {props.errors.dob && (
            <div className="alert alert-danger">{props.errors.doctor}</div>
          )}
        </div>

        <div className="form-group">
          <label htmlFor="nurse">Name of the Nurse Assisting</label>
          <div className="field">
            <select
              id="nurse"
              onChange={props.onChange}
              name="nurse"
              value={props.appointment.nurse || ""}
              className="form-control"
            >
              <option value="" />
              <option value="Miss Shelly Gupta">Miss Shelly Gupta</option>
              <option value="Mr. Raj Kapoor">Mr. Raj Kapoor</option>
              <option value="Mrs. Meera">Mrs. Meera</option>
            </select>
          </div>
        </div>

        <div className="form-group">
          <label htmlFor="room">Room Number Alloted*</label>
          <div className="field">
            <select
              id="room"
              onChange={props.onChange}
              name="room"
              value={props.appointment.room || ""}
              className="form-control"
            >
              <option value="" />
              <option value="22">22</option>
              <option value="34">34</option>
              <option value="23">23</option>
            </select>
          </div>
        </div>
        {props.errors.dob && (
          <div className="alert alert-danger">{props.errors.room}</div>
        )}
      </div>
      <input type="submit" value="Save" className="btn btn-primary" />
    </form>
  );
}

AppointmentForm.propTypes = {
  appointment: PropTypes.object.isRequired,
  onSubmit: PropTypes.func.isRequired,
  onChange: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired
};

export default AppointmentForm;
