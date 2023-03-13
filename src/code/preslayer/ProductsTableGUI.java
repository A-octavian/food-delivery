package code.preslayer;

import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import java.awt.*;

public class ProductsTableGUI extends Component {

    public String[] columns = {"Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
    private JTable jTable;

    public ProductsTableGUI(String[][] table){

        JFrame frameForProducts = new JFrame("Products imported");
        jTable = new JTable(table, columns);
        jTable.setRowSelectionAllowed(true);
        jTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(jTable);
        frameForProducts.add(scrollPane);
        frameForProducts.setBounds(700, 100, 1000, 500);
        TableColumn column = jTable.getColumnModel().getColumn(0);
        jTable.setColumnSelectionAllowed(false);
        jTable.setRowSelectionAllowed(true);
        frameForProducts.setVisible(true);
    }

    public JTable getjTable(){
        return jTable;
    }
}
