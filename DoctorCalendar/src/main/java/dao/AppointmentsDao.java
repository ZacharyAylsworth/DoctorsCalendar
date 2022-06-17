package dao;

import model.Appointments;

import java.util.List;


public interface AppointmentsDao {

    List<Appointments> listAppointments();

    Appointments getAppointment(Long appointments_id);

    boolean saveAppointment(Appointments appointmentsToSave);

    boolean deleteAppointment(Long appointments_id);
}
