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
public class Specialist {
    
    private String idSpecialist;
    private String nmSpecialist;
    private int price;

    public String getIdSpecialist() {
        return idSpecialist;
    }

    public void setIdSpecialist(String idSpecialist) {
        this.idSpecialist = idSpecialist;
    }

    public String getNmSpecialist() {
        return nmSpecialist;
    }

    public void setNmSpecialist(String nmSpecialist) {
        this.nmSpecialist = nmSpecialist;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
