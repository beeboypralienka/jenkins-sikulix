/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenkins.sikulix.Service;

import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jenkins.sikulix.Dao.DoctorDao;
import jenkins.sikulix.DatabaseConnection.DatabaseConnection;
import jenkins.sikulix.Entity.Doctor;
import jenkins.sikulix.Interface.DoctorInterface;

/**
 *
 * @author fachrulpbm
 */
public class DoctorService {
    
    private Connection connection;
    private DoctorInterface di;

    public DoctorService() {
        this.connection = DatabaseConnection.getConnection();
        this.di = new DoctorDao(connection);
    }

    public void serviceInsertDoctor(Doctor d){
        try{
            connection.setAutoCommit(false);
            di.insertDoctor(d);
            connection.setAutoCommit(true);
        }catch(SQLException se){
            try{
                connection.rollback();
                connection.setAutoCommit(true);
            }catch(SQLException see){
                Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, see);
            }
            Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, se);
        }
    }

    public void serviceUpdateDoctor(Doctor d, String noDoctor){
        try{
            connection.setAutoCommit(false);
            di.updateDoctor(d, noDoctor);
            connection.setAutoCommit(true);
        }catch(SQLException se){
            try{
                connection.rollback();
                connection.setAutoCommit(true);
            }catch(SQLException see){
                Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, see);
            }
            Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, se);
        }
    }

    public void serviceDeleteDoctor(String noDoctor){
        try{
            connection.setAutoCommit(false);
            di.deleteDoctor(noDoctor);
            connection.setAutoCommit(true);
        }catch(SQLException se){
            try{
                connection.rollback();
                connection.setAutoCommit(true);
            }catch(SQLException see){
                Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, see);
            }
            Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, se);
        }
    }

    public List serviceGetAllDoctor(){
        try{
            return di.getAllDoctor();
        }catch(SQLException se){
            Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
    }

    public List serviceGetAllDoctorByNo(String noDoctor){
        try{
            return di.getAllDoctorByNo(noDoctor);
        }catch(SQLException se){
            Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
    }

    public List serviceGetAllDoctorByNm(String nmDoctor){
        try{
            return di.getAllDoctorByNm(nmDoctor);
        }catch(SQLException se){
            Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
    }

    public String serviceGetMaxNoDoctor(){
        try{
            return di.getMaxIdDoctor();
        }catch(SQLException se){
            Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
    }

    public List serviceGetAllDoctorByIdSpecialist(String idSpecialist){
        try{
            return di.getAllDoctorByIdSpecialist(idSpecialist);
        }catch(SQLException se){
            Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
    }

    public String[] serviceDisplayDoctorName(String spesialis, int total){
        try{
            return di.getAllNameDoctor(spesialis, total);
        }catch(SQLException se){
            Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
    }

    public String serviceGetNoDoctorByName(String name){
        try {
            return di.getNoDoctorByName(name);
        } catch (SQLException ex) {
            Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
