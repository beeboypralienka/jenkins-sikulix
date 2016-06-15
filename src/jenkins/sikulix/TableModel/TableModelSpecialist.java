/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenkins.sikulix.TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import jenkins.sikulix.Entity.Specialist;

/**
 *
 * @author fachrulpbm
 */
public class TableModelSpecialist extends AbstractTableModel{
    
    public List<Specialist> list = new ArrayList<Specialist>();

    public void setData(List<Specialist>listSpecialist){
        this.list = listSpecialist;
        fireTableDataChanged();
    }

    public Specialist getSpecialist(int i){
        return list.get(i);
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Specialist ID";
            case 1:
                return "Specialist Name";
            case 2:
                return "Price";
        }
        return null;
    }

    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return 3;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getIdSpecialist();
            case 1:
                return list.get(rowIndex).getNmSpecialist();
            case 2:
                return list.get(rowIndex).getPrice();
            default:
                return null;
        }
    }
}
