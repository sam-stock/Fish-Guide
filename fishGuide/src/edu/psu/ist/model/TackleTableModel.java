package edu.psu.ist.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TackleTableModel extends AbstractTableModel {
    String[] columnNames = {"Name", "Type of Tackle", "Use"};
    private List<Tackle> tackles;
    public TackleTableModel(List<Tackle> tackles){
        this.tackles = tackles;
    }
    @Override
    public int getRowCount() {
        return tackles.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return (Object) tackles.get(rowIndex).getName();
            case 1: return (Object) tackles.get(rowIndex).getTypeOfTackle();
            case 2: return (Object) tackles.get(rowIndex).getUse();
            default: return null;
        }
    }
}
