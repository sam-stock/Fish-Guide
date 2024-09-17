package edu.psu.ist.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class FishTableModel extends AbstractTableModel {
    private String[] columnNames = {"Name", "Color" ,"Type"};
    private List<Fish> fishList;

    public FishTableModel(List<Fish> fishList) {
        this.fishList = fishList;
    }

    @Override
    public int getRowCount() {
        return fishList.size();
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
            case 0: return (Object) fishList.get(rowIndex).getName();
            case 1: return (Object) fishList.get(rowIndex).getColor();
            case 2: return (Object) fishList.get(rowIndex).getType();
            default: return null;
        }
    }
}
