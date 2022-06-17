package dao;

import model.Appointments;
import model.Doctors;

import java.util.List;

public interface DoctorsDao {

    List<Doctors> listDoctors();

    Doctors getDoctor(Long doctors_id);
}
