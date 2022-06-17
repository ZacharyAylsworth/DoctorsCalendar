package dao;

import model.Appointments;
import model.exceptions.AppointmentNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcAppointmentsDao implements AppointmentsDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAppointmentsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Appointments> listAppointments() {
        List<Appointments> appointments = new ArrayList<>();
        String sql = "SELECT appointment_id, patient_first_name, patient_last_name, date_time, kind  " +
                "FROM appointments";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Appointments appointment = mapRowToAppointments(results);
            appointments.add(appointment);
        }
        return appointments;
    }

    @Override
    public Appointments getAppointment (Long appointment_id) {
        Appointments appointment = null;
        String sql = "SELECT * " +
                "FROM appointments WHERE appointment_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, appointment_id);
        if (results.next()) {
            appointment = mapRowToAppointments(results);
        } else {
            throw new AppointmentNotFoundException();
        }
        return appointment;
    }

    @Override
    public boolean saveAppointment(Appointments appointmentToSave) {
        String sql = "INSERT INTO appointments (appointment_id) " +
                "VALUES (DEFAULT)";
        return jdbcTemplate.update(sql, appointmentToSave.getAppointment_ID()) == 1;
    }



    @Override
    public boolean deleteAppointment(Long appointment_id) {
        String sql = "DELETE FROM appointments WHERE appointment_id = ?";
        return jdbcTemplate.update(sql, appointment_id) == 1;
    }

    private Appointments mapRowToAppointments(SqlRowSet rowSet) {
        Appointments a = new Appointments();
        a.setAppointment_ID(rowSet.getLong("appointment_id"));
        a.setPatient_first_name(rowSet.getString("patient_first_name"));
        a.setPatient_last_name(rowSet.getString("patient_last_name"));
        a.setDate_time(rowSet.getTimestamp("date_time"));
        a.setKind(rowSet.getString("kind"));
        return a;
    }

}


