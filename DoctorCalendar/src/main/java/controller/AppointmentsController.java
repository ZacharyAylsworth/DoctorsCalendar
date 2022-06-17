package controller;

import dao.AppointmentsDao;
import model.Appointments;
import model.exceptions.AppointmentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

public class AppointmentsController {

    private AppointmentsDao dao;
    public AppointmentsController(AppointmentsDao dao) { this.dao = dao; }

    //CREATE Appointments
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/appointments", method = RequestMethod.POST)
    public Appointments addAppointments(@RequestBody Appointments appointment){
        if(appointment !=null){
            dao.saveAppointment(appointment);
            return appointment;
        } return null;
    }
    //REQUEST Appointments
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/appointments/{appointment_id}", method = RequestMethod.GET)
    public Appointments getAppointment(@PathVariable Long appointment_id) throws AppointmentNotFoundException {
        return dao.getAppointment(appointment_id);
    }

    //DELETE Appointments
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/appointments/{appointment_id}", method = RequestMethod.DELETE)
    public void deleteAppointment(@PathVariable Long appointment_id) throws AppointmentNotFoundException{
        dao.deleteAppointment(appointment_id);
    }
}
