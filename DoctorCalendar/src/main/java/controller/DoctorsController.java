package controller;

import dao.AppointmentsDao;
import dao.DoctorsDao;
import model.Appointments;
import model.Doctors;
import model.exceptions.AppointmentNotFoundException;
import model.exceptions.DoctorNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class DoctorsController {

    private DoctorsDao dao;
    public DoctorsController(DoctorsDao dao) { this.dao = dao; }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/doctors/{doctors_id}", method = RequestMethod.GET)
    public Doctors getDoctor(@PathVariable Long appointment_id) throws DoctorNotFoundException {
        return dao.getDoctor(appointment_id);
    }
}
