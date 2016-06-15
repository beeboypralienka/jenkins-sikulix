/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenkins.sikulix.Entity;

/**
 *
 * @author fachrulpbm
 */
public class Doctor {

    private String noDoctor;
    private String nmDoctor;
    private String idSpecialist;
    private String dateEmployDoctor;
    private String addressDoctor;

    public String getAddressDoctor() {
        return addressDoctor;
    }

    public void setAddressDoctor(String addressDoctor) {
        this.addressDoctor = addressDoctor;
    }

    public String getIdSpecialist() {
        return idSpecialist;
    }

    public void setIdSpecialist(String idSpecialist) {
        this.idSpecialist = idSpecialist;
    }

    public String getNmDoctor() {
        return nmDoctor;
    }

    public void setNmDoctor(String nmDoctor) {
        this.nmDoctor = nmDoctor;
    }

    public String getNoDoctor() {
        return noDoctor;
    }

    public void setNoDoctor(String noDoctor) {
        this.noDoctor = noDoctor;
    }

    public String getDateEmployDoctor() {
        return dateEmployDoctor;
    }

    public void setDateEmployDoctor(String dateEmployDoctor) {
        this.dateEmployDoctor = dateEmployDoctor;
    }
}
