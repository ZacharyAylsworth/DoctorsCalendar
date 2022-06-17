package model;

import java.util.Date;

public class Appointments {
    private Long appointment_ID;
    private String patient_first_name;
    private String patient_last_name;
    private Date date_time;
    private String kind;


    public Appointments(Long appointment_ID, String patient_first_name, String patient_last_name, Date date_time, String kind) {
        this.appointment_ID = appointment_ID;
        this.patient_first_name = patient_first_name;
        this.patient_last_name = patient_last_name;
        this.date_time = date_time;
        this.kind = kind;
    }

    public Appointments(){}

    public Long getAppointment_ID() {
        return appointment_ID;
    }

    public void setAppointment_ID(Long appointment_ID) {
        this.appointment_ID = appointment_ID;
    }

    public void setPatient_first_name(String patient_first_name) {
        this.patient_first_name = patient_first_name;
    }

    public void setPatient_last_name(String patient_last_name) {
        this.patient_last_name = patient_last_name;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
