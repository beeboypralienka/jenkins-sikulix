/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenkins.sikulix.Interface;

import java.sql.SQLException;
import java.util.List;
import jenkins.sikulix.Entity.Specialist;

/**
 *
 * @author fachrulpbm
 */
public interface SpecialistInterface {
    
    // Standard of CRUD
    public void insertSpecialist(Specialist s)throws SQLException;
    public void updateSpecialist(Specialist s, String idSpecialist)throws SQLException;
    public void deleteSpecialist(String idSpecialist)throws SQLException;
    public List getAllSpecialist()throws SQLException;

    // Method for filling and getting data in JComboBox
    public String[] getAllNmSpecialist(int row)throws SQLException;
    public String getIDSpecialist(String name)throws SQLException;

    // Method for choosing JComboBox data from table
    public String getNmSpecialist(String id)throws SQLException;

    // Method for searching specialist through the JTextFiled
    public List getAllSpecialistById(String idSpecialist)throws SQLException;
    public List getAllSpecialistByNm(String nmSpecialist)throws SQLException;
    
}
