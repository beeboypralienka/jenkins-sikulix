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
import jenkins.sikulix.Dao.SpecialistDao;
import jenkins.sikulix.DatabaseConnection.DatabaseConnection;
import jenkins.sikulix.Entity.Specialist;
import jenkins.sikulix.Interface.SpecialistInterface;

/**
 *
 * @author fachrulpbm
 */
public class SpecialistService {
    private Connection connection;
    private SpecialistInterface si;

    public SpecialistService() {
        this.connection = DatabaseConnection.getConnection();
        this.si = new SpecialistDao(connection);
    }

    public void serviceInsertSpecialist(Specialist sp){
        try{
            connection.setAutoCommit(false);
            si.insertSpecialist(sp);
            connection.setAutoCommit(true);
        }catch(SQLException se){
            try{
                connection.rollback();
                connection.setAutoCommit(true);
            }catch(SQLException see){
                Logger.getLogger(SpecialistService.class.getName()).log(Level.SEVERE, null, see);
            }
            Logger.getLogger(SpecialistService.class.getName()).log(Level.SEVERE, null, se);
        }
    }

    public void serviceUpdateSpecialist(Specialist sp, String idSpecialist){
        try{
            connection.setAutoCommit(false);
            si.updateSpecialist(sp, idSpecialist);
            connection.setAutoCommit(true);
        }catch(SQLException se){
            try{
                connection.rollback();
                connection.setAutoCommit(true);
            }catch(SQLException see){
                Logger.getLogger(SpecialistService.class.getName()).log(Level.SEVERE, null, see);
            }
            Logger.getLogger(SpecialistService.class.getName()).log(Level.SEVERE, null, se);
        }
    }

    public void serviceDeleteSpecialist(String idSpecialist){
        try{
            connection.setAutoCommit(false);
            si.deleteSpecialist(idSpecialist);
            connection.setAutoCommit(true);
        }catch(SQLException se){
            try{
                connection.rollback();
                connection.setAutoCommit(true);
            }catch(SQLException see){
                Logger.getLogger(SpecialistService.class.getName()).log(Level.SEVERE, null, see);
            }
            Logger.getLogger(SpecialistService.class.getName()).log(Level.SEVERE, null, se);
        }
    }

    public List serviceGetAllSpecialist(){
        try{
            return si.getAllSpecialist();
        }catch(SQLException se){
            Logger.getLogger(SpecialistService.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
    }

    public String[] serviceGetAllNamaSpecialist(int b){
        try{
            return si.getAllNmSpecialist(b);
        }catch(SQLException t){
            Logger.getLogger(SpecialistService.class.getName()).log(Level.SEVERE, null, t);
            return null;
        }
    }

    public String serviceGetIDSpecialist(String b){
        try{
            return si.getIDSpecialist(b);
        }catch(SQLException t){
            Logger.getLogger(SpecialistService.class.getName()).log(Level.SEVERE, null, t);
            return null;
        }
    }

    public String serviceGetNmSpecialist(String id){
        try{
            return si.getNmSpecialist(id);
        }catch(SQLException t){
            Logger.getLogger(SpecialistService.class.getName()).log(Level.SEVERE, null, t);
            return null;
        }
    }

    public List serviceGetAllSpecialistById(String idSpecialist){
        try{
            return si.getAllSpecialistById(idSpecialist);
        }catch(SQLException se){
            Logger.getLogger(SpecialistService.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
    }

    public List serviceGetAllSpecialistByNm(String nmSpecialist){
        try{
            return si.getAllSpecialistByNm(nmSpecialist);
        }catch(SQLException se){
            Logger.getLogger(SpecialistService.class.getName()).log(Level.SEVERE, null, se);
            return null;
        }
    }
}
