package dao;

import model.Doctors;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcDoctorsDao implements DoctorsDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcDoctorsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Doctors> listDoctors() {
        List<Doctors> doctors = new ArrayList<>();
        String sql = "SELECT doctor_id, doctor_first_name, doctor_last_name  " +
                "FROM doctors";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Doctors doctor = mapRowToDoctors(results);
            doctors.add(doctor);
        }
        return doctors;
    }

    @Override
    public Doctors getDoctor(Long doctors_id) {
        return null;
    }

    private Doctors mapRowToDoctors(SqlRowSet rowSet) {
        Doctors d = new Doctors();
        d.setDoctor_ID(rowSet.getLong("doctor_id"));
        d.setDoctor_first_name(rowSet.getString("doctor_first_name"));
        d.setDoctor_last_name(rowSet.getString("doctor_last_name"));
        return d;
    }
}
