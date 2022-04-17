package windows;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import server.Database;

import java.util.List;
import java.util.Vector;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

public class Inventory extends JFrame {

    private JTable table = null;
    private List<String> colNames = null;
    private List<String> data = null;
    DefaultTableModel model = null;
    JScrollPane pane = null;

    public Inventory() {

        colNames = new ArrayList<>();
        data = new ArrayList<>();
        loadColumnData();
        loadInventory();
        setModel();
        setTable();
        setFrame();

    }

    private void loadColumnData() {
        colNames.addAll(Database.getColumnNames("Inventory"));
       // System.out.println("colNames : " + colNames.size());
       
    }

    private void loadInventory() {
        data.addAll(Database.getInventoryData());
    }

    private void addColumnNames() {
        for (int i = 1; i < colNames.size(); i++) {
            model.addColumn((colNames.get(i)));
        }
    }

    private void setModelData(){
 
        for(int i =0 ; i < data.size()-10;i=i+4){
            Object[] tableData = new Object[4];

            tableData[0] = data.get(i);
            tableData[1] = data.get(i+1);
            tableData[2] = data.get(i+2);
            tableData[3] = data.get(i+3);

            model.addRow(tableData);
        }
    }

    private void setModel(){
        model = new DefaultTableModel(colNames.toArray(),1);
        setModelData();
    }

    private void setTable(){
        table = new JTable(model);
        table.setGridColor(Color.BLACK);
        table.doLayout();
        pane = new JScrollPane(table);
    }


    private void setFrame() {

        add(pane);
        setTitle("Login Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMinimumSize(new Dimension(350, 450));
        // setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
