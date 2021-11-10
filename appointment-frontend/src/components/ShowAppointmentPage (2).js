import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import * as appointmentApi from "../api/appointmentApi";

function ShowAppointmentPage(props) {
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

  const slug = props.match.params.slug;

  const style = {
    backgroundColor: "#D2FED2",
    padding: 10,
    borderRadius: 5,
    margin: 10
  };

  useEffect(() => {
    const slug = props.match.params.slug;
    if (slug) {
      appointmentApi
        .getAppointmentBySlug(slug)
        .then(_appointment => setAppointment(_appointment));
    }
  }, [props.match.params.slug]);

  return (
    <>
      <h1 className="jumbotron">Show Appointment Details</h1>
      <Link className="btn btn-primary" to={"/add-appointment/" + slug}>
        Edit Appointment
      </Link>{" "}
      <br />
      <br />
      <table className="table">
        <tbody>
          <tr>
            <th>Patient Full Name : </th>
            <td>{appointment.name}</td>
          </tr>
        </tbody>
      </table>
      <h4 style={style}>Appointment Details</h4>
      <table className="table">
        <tbody>
          <tr>
            <th>Name of the Doctor :</th>
            <td>{appointment.doctor}</td>
          </tr>
          <tr>
            <th>Name of the Nurse :</th>
            <td>{appointment.nurse}</td>
          </tr>
          <tr>
            <th>Appointment time :</th>
            <td>{appointment.time}</td>
          </tr>
          <tr>
            <th>Room number alloted :</th>
            <td>{appointment.room}</td>
          </tr>
        </tbody>
      </table>
      <h4 style={style}>Personal Details</h4>
      <table className="table">
        <tbody>
          <tr>
            <th>Age :</th>
            <td>{appointment.dob}</td>
          </tr>
          <tr>
            <th>Gender :</th>
            <td>{appointment.gender}</td>
          </tr>
          <tr>
            <th>Guardian's Name :</th>
            <td>{appointment.guardian}</td>
          </tr>
        </tbody>
      </table>
      <h4 style={style}>Mailing Details</h4>
      <table className="table">
        <tbody>
          <tr>
            <th>Current Address :</th>
            <td>{appointment.address}</td>
          </tr>
          <tr>
            <th>City :</th>
            <td>{appointment.city}</td>
          </tr>
          <tr>
            <th>State :</th>
            <td>{appointment.state}</td>
          </tr>
          <tr>
            <th>Country :</th>
            <td>{appointment.country}</td>
          </tr>
          <tr>
            <th>Zip Code:</th>
            <td>{appointment.zip}</td>
          </tr>
        </tbody>
      </table>
      <h4 style={style}>Insurance Details</h4>
      <table className="table">
        <tbody>
          <tr>
            <th>Insurance Name :</th>
            <td>{appointment.insuranceName}</td>
          </tr>
          <tr>
            <th>Insurance Number :</th>
            <td>{appointment.insuranceNo}</td>
          </tr>
        </tbody>
      </table>
    </>
  );
}

export default ShowAppointmentPage;
