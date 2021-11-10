import React, { useState, useEffect } from "react";
import { getAppointments } from "../api/appointmentApi";
import AppointmentList from "./AppointmentList";
import { Link } from "react-router-dom";

function AppointmentsPage() {
  const [appointment, setAppointments] = useState([]);

  useEffect(() => {
    getAppointments().then(_appointment => setAppointments(_appointment));
  }, []);

  return (
    <>
      <h1>Patient Appointment</h1>
      <Link className="btn btn-primary" to="/add-appointment">
        Add Appointment
      </Link>
      <AppointmentList appointment={appointment} />
    </>
  );
}

export default AppointmentsPage;
