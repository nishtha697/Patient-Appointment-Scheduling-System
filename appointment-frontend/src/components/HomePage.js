import React from "react";
import { Link } from "react-router-dom";

function HomePage() {
  return (
    <div className="jumbotron">
      <h1>Patient Appointment Scheduling System</h1>
      <p>Schedule patient appointments to doctors, assign nurses and rooms.</p>
      <Link to="add-appointment" className="btn btn-primary">
        Add appointments
      </Link>
    </div>
  );
}

export default HomePage;
