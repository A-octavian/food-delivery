package code.preslayer;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ClientGUI extends JFrame {

    private JPanel contentPane;
    private ProductsTableGUI table;
    private JTextField clientIDField;
    private JTextField titleField;
    private JTextField ratingField;
    private JTextField caloriesField;
    private JTextField fatsField;
    private JTextField sodiumField;
    private JTextField proteinsField;
    private JTextField priceField;
    private JButton viewAllBtn;
    private JButton orderBtn;
    private JButton searchBtn;

    public ClientGUI() {
        setTitle("Client Panel");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 450, 700, 570);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        viewAllBtn = new JButton("View Products");
        viewAllBtn.setBounds(10, 25, 130, 30);
        contentPane.add(viewAllBtn);

        orderBtn = new JButton("Place Order");
        orderBtn.setBounds(10, 66, 130, 30);
        contentPane.add(orderBtn);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(10, 475, 100, 30);
        contentPane.add(searchBtn);

        clientIDField = new JTextField();
        clientIDField.setToolTipText("Client ID");
        clientIDField.setBounds( 150, 75, 50, 20);
        contentPane.add(clientIDField);
        clientIDField.setColumns(10);

        titleField = new JTextField();
        titleField.setToolTipText("Product Name");
        titleField.setBounds(145, 480, 86, 20);
        contentPane.add(titleField);
        titleField.setColumns(10);

        ratingField = new JTextField();
        ratingField.setToolTipText("Rating");
        ratingField.setColumns(10);
        ratingField.setBounds(254, 480, 60, 20);
        contentPane.add(ratingField);

        caloriesField = new JTextField();
        caloriesField.setToolTipText("Calories");
        caloriesField.setColumns(10);
        caloriesField.setBounds(329, 480, 60, 20);
        contentPane.add(caloriesField);

        fatsField = new JTextField();
        fatsField.setToolTipText("Fats");
        fatsField.setColumns(10);
        fatsField.setBounds(469, 480, 60, 20);
        contentPane.add(fatsField);

        sodiumField = new JTextField();
        sodiumField.setToolTipText("Sodium");
        sodiumField.setColumns(10);
        sodiumField.setBounds(539, 480, 60, 20);
        contentPane.add(sodiumField);

        proteinsField = new JTextField();
        proteinsField.setToolTipText("Proteins");
        proteinsField.setColumns(10);
        proteinsField.setBounds(399, 480, 60, 20);
        contentPane.add(proteinsField);

        priceField = new JTextField();
        priceField.setToolTipText("Price");
        priceField.setColumns(10);
        priceField.setBounds(609, 480, 60, 20);
        contentPane.add(priceField);
    }

    public void getViewAllBtn(ActionListener actionListener){
        this.viewAllBtn.addActionListener(actionListener);
    }

    public void getOrderBtn(ActionListener actionListener){
        this.orderBtn.addActionListener(actionListener);
    }

    public void getSearchBtn(ActionListener actionListener){
        this.searchBtn.addActionListener(actionListener);
    }

    public String getTitleToSearch(){
        return titleField.getText();
    }

    public String getRatingToSearch(){
        return ratingField.getText();
    }

    public String getCaloriesToSearch(){
        return caloriesField.getText();
    }

    public String getProteinsToSearch(){
        return proteinsField.getText();
    }

    public String getFatsToSearch(){
        return proteinsField.getText();
    }

    public String getSodiumToSearch(){
        return sodiumField.getText();
    }

    public String getPriceToSearch(){
        return priceField.getText();
    }

    public String getClientIDField(){
        return clientIDField.getText();
    }

    public ProductsTableGUI getTable(){
        return table;
    }

    public void setTable(ProductsTableGUI table){
        this.table = table;
    }

}

