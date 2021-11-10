import React from "react";
import PropTypes from "prop-types";
import { Link } from "react-router-dom";

function AppointmentList(props) {
  return (
    <table className="table">
      <thead>
        <tr>
          <th>Patient Full Name</th>
          <th>Doctor Full Name</th>
          <th>Nurse Full Name</th>
          <th>Room</th>
          <th>Time</th>
        </tr>
      </thead>
      <tbody>
        {props.appointment.map(appointment => {
          return (
            <tr key={appointment.id}>
              <td>
                <Link
                  to={"/show-appointment/" + appointment.slug}
                  query={{ appointment: appointment }}
                >
                  {appointment.name}
                </Link>
              </td>
              <td>{appointment.doctor}</td>
              <td>{appointment.nurse}</td>
              <td>{appointment.room}</td>
              <td>{appointment.time}</td>
            </tr>
          );
        })}
      </tbody>
    </table>
  );
}

AppointmentList.prototype = {
  appointment: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.number.isRequired,
      name: PropTypes.string.isRequired,
      dob: PropTypes.number.isRequired,
      gender: PropTypes.string.isRequired,
      guardian: PropTypes.string,
      disease: PropTypes.string.isRequired,
      address: PropTypes.string.isRequired,
      city: PropTypes.string.isRequired,
      state: PropTypes.string.isRequired,
      country: PropTypes.string.isRequired,
      zip: PropTypes.string.isRequired,
      phone: PropTypes.string.isRequired,
      insuranceName: PropTypes.string,
      insuranceNo: PropTypes.string,
      doctor: PropTypes.string.isRequired,
      nurse: PropTypes.string.isRequired,
      time: PropTypes.string.isRequired,
      room: PropTypes.string.isRequired
    })
  ).isRequired
};

AppointmentList.defaultProps = {
  appointment: []
};
export default AppointmentList;
