/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenkins.sikulix.TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import jenkins.sikulix.Entity.Doctor;

/**
 *
 * @author fachrulpbm
 */
public class TableModelDoctor extends AbstractTableModel{
    
    public List<Doctor> list = new ArrayList<Doctor>();

    public void setData(List<Doctor>listDoctor){
        this.list = listDoctor;
        fireTableDataChanged();
    }

    public Doctor getDoctor(int i){
        return list.get(i);
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Doctor ID";
            case 1:
                return "Doctor Name";
            case 2:
                return "Specialist";
            case 3:
                return "Employement Date";
            case 4:
                return "Adddress";
        }
        return null;
    }

    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return 5;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getNoDoctor();
            case 1:
                return list.get(rowIndex).getNmDoctor();
            case 2:
                return list.get(rowIndex).getIdSpecialist();
            case 3:
                return list.get(rowIndex).getDateEmployDoctor();
            case 4:
                return list.get(rowIndex).getAddressDoctor();
            default:
                return null;
        }
    }
}
