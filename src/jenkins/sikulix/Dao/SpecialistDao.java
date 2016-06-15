/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenkins.sikulix.Dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jenkins.sikulix.Entity.Specialist;
import jenkins.sikulix.Interface.SpecialistInterface;

/**
 *
 * @author fachrulpbm
 */
public class SpecialistDao implements SpecialistInterface {

    private Connection connection;
    // Query standar untuk CRUD
    private final String insertSpecialist = "INSERT INTO spesialis VALUES(?,?,?)";
    private final String updateSpecialist = "UPDATE spesialis SET nm_spesialis=?, tarif_konsul=? WHERE id_spesialis=?";
    private final String deleteSpecialist = "DELETE FROM spesialis WHERE id_spesialis=?";
    private final String getAllSpecialist = "SELECT * FROM spesialis";
    // Query untuk mengambil nilai ID dari JComboBox by nama
    private final String getIDSpecialist = "SELECT * FROM spesialis WHERE nm_spesialis=?";
    // Query untuk mengambil nama spesialis dari tabel by id
    private final String getNmSpecialist = "SELECT * FROM spesialis WHERE id_spesialis=?";
    // Query untuk mencari spesialis via JTExtField
    private final String getAllByIdSpecialist = "SELECT * FROM spesialis WHERE id_spesialis LIKE ?";
    private final String getAllByNmSpecialist = "SELECT * FROM spesialis WHERE nm_spesialis LIKE ?";

    /* Variabel untuk mengirim data hasil */
    public static String hasilInsert;
    public static String hasilUpdate;
    public static String hasilDelete;
    public static String hasilGetAll;
    public static String hasilGetAllNmSpecialist;
    public static String hasilGetIDSpecialist;
    public static String hasilGetNmSpecialist;
    public static String hasilGetAllSpecialistById;
    public static String hasilGetAllSpecialistByNm;

    public SpecialistDao(Connection connection) {
        this.connection = connection;
    }

    public void insertSpecialist(Specialist s) throws SQLException {
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(insertSpecialist);
            ps.setString(1, s.getIdSpecialist());
            ps.setString(2, s.getNmSpecialist());
            ps.setInt(3, s.getPrice());
            ps.executeUpdate();
            ps.close();           
            hasilInsert = "ok";
        } catch (SQLException se) {
            //System.out.println("Insert Specialist Gagal - "+se.getMessage());
            hasilInsert = se.getMessage();
        }
    }

    public void updateSpecialist(Specialist s, String idSpecialist) throws SQLException {
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(updateSpecialist);
            ps.setString(1, s.getNmSpecialist());
            ps.setInt(2, s.getPrice());
            ps.setString(3, idSpecialist);
            ps.executeUpdate();
            ps.close();
            //System.out.println("Update Specialist - Data spesialis berhasil diubah!");
            hasilUpdate = "ok";
        } catch (SQLException se) {
            //System.out.println("Update Specialist Gagal - "+se.getMessage());
            hasilUpdate = se.getMessage();
        }
    }

    public void deleteSpecialist(String idSpecialist) throws SQLException {
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(deleteSpecialist);
            ps.setString(1, idSpecialist);
            ps.executeUpdate();
            ps.close();
            //System.out.println("Delete Specialist - Data spesialis berhasil dihapus!");
            hasilDelete = "ok";
        } catch (SQLException se) {
            //System.out.println("Delete Specialist Gagal - "+se.getMessage());
            hasilDelete = se.getMessage();
        }
    }

    public List getAllSpecialist() throws SQLException {
        try {
            List list = new ArrayList();
            Statement s = (Statement) connection.createStatement();
            ResultSet rs = s.executeQuery(getAllSpecialist);
            while (rs.next()) {
                Specialist sp = new Specialist();
                sp.setIdSpecialist(rs.getString("id_spesialis"));
                sp.setNmSpecialist(rs.getString("nm_spesialis"));
                sp.setPrice(rs.getInt("tarif_konsul"));
                list.add(sp);
            }
            rs.close();
            s.close();
            //System.out.println("Get All Specialist - Berhasil dipanggil!");
            hasilGetAll = "ok";
            return list;
        } catch (SQLException se) {
            //System.out.println("Get All Specialist Gagal - "+se.getMessage());
            hasilGetAll = se.getMessage();
            return null;
        }
    }

    public String[] getAllNmSpecialist(int row) throws SQLException {
        try {
            //String[] data = new String[row];
            String[] data = new String[row + 1];
            Statement st = (Statement) connection.createStatement();
            ResultSet rs = st.executeQuery(getAllSpecialist);
            Specialist sp = new Specialist();
            while (rs.next()) {
                sp.setNmSpecialist(rs.getString("nm_spesialis"));
                String nmSpecialist = sp.getNmSpecialist();
                //data[rs.getRow()-1] = nmSpecialist;
                data[rs.getRow()] = nmSpecialist;
            }
            st.close();
            rs.close();
            hasilGetAllNmSpecialist = "ok";
            return data;
        } catch (Throwable t) {
            //JOptionPane.showMessageDialog(null, t.getMessage(), "Error - Get Nama Specialist", JOptionPane.ERROR_MESSAGE);
            hasilGetAllNmSpecialist = t.getMessage();
            return null;
        }
    }

    public String getIDSpecialist(String nama) throws SQLException {
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(getIDSpecialist);
            ps.setString(1, nama);
            ResultSet rs = ps.executeQuery();
            Specialist sp = new Specialist();
            String pop = null;
            while (rs.next()) {
                sp.setIdSpecialist(rs.getString("id_spesialis"));
                pop = sp.getIdSpecialist();
            }
            ps.close();
            rs.close();
            hasilGetIDSpecialist = "ok";
            return pop;
        } catch (Throwable t) {
            hasilGetIDSpecialist = t.getMessage();
            return null;
        }
    }

    public String getNmSpecialist(String id) throws SQLException {
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(getNmSpecialist);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            Specialist sp = new Specialist();
            String pop = null;
            while (rs.next()) {
                sp.setIdSpecialist(rs.getString("nm_spesialis"));
                pop = sp.getIdSpecialist();
            }
            ps.close();
            rs.close();
            hasilGetNmSpecialist = "ok";
            return pop;
        } catch (Throwable t) {
            //JOptionPane.showMessageDialog(null, t.getMessage(), "Error - Get ID Specialist", JOptionPane.ERROR_MESSAGE);
            hasilGetNmSpecialist = t.getMessage();
            return null;
        }
    }

    public List getAllSpecialistById(String idSpecialist) throws SQLException {
        try {
            PreparedStatement ps = null;
            List list = new ArrayList();
            ps = (PreparedStatement) connection.prepareStatement(getAllByIdSpecialist);
            ps.setString(1, "%" + idSpecialist + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Specialist s = new Specialist();
                s.setIdSpecialist(rs.getString("id_spesialis"));
                s.setNmSpecialist(rs.getString("nm_spesialis"));
                s.setPrice(rs.getInt("tarif_konsul"));
                list.add(s);
            }
            ps.close();
            rs.close();
            hasilGetAllSpecialistById = "ok";
            return list;
        } catch (Throwable t) {
            //JOptionPane.showMessageDialog(null, t.getMessage(),"Get All Specialist By Nomor Gagal!", JOptionPane.ERROR_MESSAGE);
            hasilGetAllSpecialistById = t.getMessage();
            return null;
        }
    }

    public List getAllSpecialistByNm(String nmSpecialist) throws SQLException {
        try {
            PreparedStatement ps = null;
            List list = new ArrayList();
            ps = (PreparedStatement) connection.prepareStatement(getAllByNmSpecialist);
            ps.setString(1, "%" + nmSpecialist + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Specialist s = new Specialist();
                s.setIdSpecialist(rs.getString("id_spesialis"));
                s.setNmSpecialist(rs.getString("nm_spesialis"));
                s.setPrice(rs.getInt("tarif_konsul"));
                list.add(s);
            }
            ps.close();
            rs.close();
            hasilGetAllSpecialistByNm = "ok";
            return list;
        } catch (Throwable t) {
            //JOptionPane.showMessageDialog(null, t.getMessage(),"Get All Specialist By Nama Gagal!", JOptionPane.ERROR_MESSAGE);
            hasilGetAllSpecialistByNm = t.getMessage();
            return null;
        }
    }
}
