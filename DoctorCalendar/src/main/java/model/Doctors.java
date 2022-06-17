package model;

public class Doctors {
    private Long doctor_id;
    private String doctor_first_name;
    private String doctor_last_name;

    public Doctors (Long doctor_id, String doctor_first_name, String doctor_last_name){
        this.doctor_id = doctor_id;
        this.doctor_first_name = doctor_first_name;
        this.doctor_last_name = doctor_last_name;
    }

    public Doctors(){}

    public Long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_ID(Long doctor_id) {
        this.doctor_id = doctor_id;
    }

    public void setDoctor_first_name(String doctor_first_name) {
        this.doctor_first_name = doctor_first_name;
    }

    public void setDoctor_last_name(String doctor_last_name) {
        this.doctor_last_name = doctor_last_name;
    }
}
