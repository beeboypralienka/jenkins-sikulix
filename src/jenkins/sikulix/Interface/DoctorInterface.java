/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenkins.sikulix.Interface;

import java.sql.SQLException;
import java.util.List;
import jenkins.sikulix.Entity.Doctor;

/**
 *
 * @author fachrulpbm
 */
public interface DoctorInterface {
    
    // Standard CRUD for doctor
    public void insertDoctor(Doctor d)throws SQLException;
    public void updateDoctor(Doctor d, String noDoctor)throws SQLException;
    public void deleteDoctor(String noDoctor)throws SQLException;
    public List getAllDoctor()throws SQLException;

    // Method for searching doctor datas
    public List getAllDoctorByNo(String idDoctor)throws SQLException;
    public List getAllDoctorByNm(String nmDoctor)throws SQLException;

    // Method for giving the maximum score in doctor numbers
    public String getMaxIdDoctor()throws SQLException;

    // Method for filling the choice in doctor name comboBox based ID specialist
    public List getAllDoctorByIdSpecialist(String idSpecialist)throws SQLException;
    public String[] getAllNameDoctor(String Doctor, int total)throws SQLException;

    // Method for getting doctor number from doctors name choice in comboBox
    public String getNoDoctorByName(String name)throws SQLException;
    
}
