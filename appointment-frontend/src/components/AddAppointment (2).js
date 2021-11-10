import React, { useState, useEffect } from "react";
import AppointmentForm from "./AppointmentForm";
import * as appointmentApi from "../api/appointmentApi";
import { toast } from "react-toastify";

const AddAppointmentPage = props => {
  const [errors, setErrors] = useState({});

  const [appointment, setAppointment] = useState({
    id: null,
    slug: "",
    name: "",
    dob: null,
    gender: null,
    guardian: "",
    disease: "",
    address: "",
    city: "",
    state: null,
    country: null,
    zip: "",
    phone: "",
    insuranceName: "",
    insuranceNo: "",
    time: null,
    doctor: null,
    nurse: null,
    room: null
  });

  useEffect(() => {
    const slug = props.match.params.slug;
    if (slug) {
      appointmentApi
        .getAppointmentBySlug(slug)
        .then(_appointment => setAppointment(_appointment));
    }
  }, [props.match.params.slug]);

  function handleChange({ target }) {
    setAppointment({ ...appointment, [target.name]: target.value });
  }

  function formIsValid() {
    const _errors = {};
    if (!appointment.name) _errors.name = "Patient's name is required.";
    if (!appointment.dob) _errors.dob = "Date of Birth is required.";
    if (!appointment.gender) _errors.gender = "Gender is required.";
    if (!appointment.disease) _errors.disease = "Disease is required.";
    if (!appointment.address) _errors.address = "Address is required.";
    if (!appointment.city) _errors.city = "City is required.";
    if (!appointment.state) _errors.state = "State is required.";
    if (!appointment.country) _errors.country = "Country is required.";
    if (!appointment.zip) _errors.zip = "Zip is required.";
    if (!appointment.phone) _errors.phone = "Phone is required.";
    if (!appointment.time) _errors.time = "Appointment time is required.";
    if (!appointment.doctor) _errors.doctor = "Doctor is required.";
    if (!appointment.room) _errors.room = "Room number is required.";

    setErrors(_errors);
    //Form is valid if the error object has no properties.

    return Object.keys(_errors).length === 0;
  }

  function handleSubmit(event) {
    debugger;
    event.preventDefault();
    if (!formIsValid()) return;
    appointmentApi.saveAppointment(appointment).then(() => {
      props.history.push("/appointments");
      toast.success("Appointment saved.");
    });
  }

  const headingStyle = {
    backgroundColor: "#1e90ff",
    color: "white",
    margin: "auto",
    display: "flex",
    justifyContent: "center",
    padding: 10,
    borderRadius: 10
  };

  return (
    <>
      <br />
      <h1 style={headingStyle}>Add Appointment</h1>
      <br />
      <AppointmentForm
        errors={errors}
        appointment={appointment}
        onChange={handleChange}
        onSubmit={handleSubmit}
      />
    </>
  );
};

export default AddAppointmentPage;
