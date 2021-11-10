import axios from "axios";

const APPOINTMENT_API_URL = "http://localhost:8080";

const INSTRUCTOR_API_URL = `${APPOINTMENT_API_URL}`;

class AppointmentDataService {
  retrieveAllAppointments() {
    return axios.get(`${INSTRUCTOR_API_URL}/appointments`);
  }

  retrieveAppointment(slug) {
    return axios.get(`${INSTRUCTOR_API_URL}/appointments/${slug}`);
  }

  updateAppointment(slug, appointment) {
    return axios.put(
      `${INSTRUCTOR_API_URL}/add-appointment/${slug}`,
      appointment
    );
  }

  addAppointment(appointment) {
    return axios.post(`${INSTRUCTOR_API_URL}/appointments/`, appointment);
  }
}

export default new AppointmentDataService();
