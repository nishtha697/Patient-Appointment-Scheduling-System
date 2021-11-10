import axios from "axios";
const APPOINTMENT_API_URL = "http://localhost:8080";

class AppointmentDataService {
  retrieveAllAppointments() {
    return axios.get(`${APPOINTMENT_API_URL}/patient-appointments`);
  }

  retrieveAppointment(id) {
    return axios.get(`${APPOINTMENT_API_URL}/show-patient/${id}`);
  }

  updateAppointment(slug, appointment) {
    return axios.put(
      `${APPOINTMENT_API_URL}/add-appointment/${slug}`,
      appointment
    );
  }

  addAppointment(appointment) {
    return axios.post(
      `${APPOINTMENT_API_URL}/patient-appointments`,
      appointment
    );
  }
}

export default new AppointmentDataService();
