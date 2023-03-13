package code.preslayer;

import code.bussinesslayer.*;
import code.bussinesslayer.MenuItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class Controller {

    private MainGUI gui;

    public Controller(MainGUI gui){

        this.gui = gui;

        Registration logs = new Registration();
        AdminGUI adminGUI = new AdminGUI();
        ClientGUI clientGUI = new ClientGUI();
        EmployeeGUI employeeGUI = new EmployeeGUI();
        DeliveryService ds = new DeliveryService();

        ds.addObserver(employeeGUI);

        gui.registerBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gui.getComboBox().getSelectedItem().toString().equals("Client")){
                    gui.setPanelForLoginFalse();
                    gui.setPanelForRegistrationTrue();

                }else{
                    JOptionPane.showMessageDialog(gui, "Administrator and employees can not be updated");
                }
            }
        });
        gui.realRegisterBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = gui.getRegisterUsernameField();
                String password = gui.getRegisterPasswordField();
//                if(logs.registerMethod(username, password)){
//                    logs.confirmRegistration(username, password);
                if(logs.register(username, password)){
                    JOptionPane.showMessageDialog(gui, "Account successfully created");
                } else{
                    JOptionPane.showMessageDialog(gui, "Username already taken");
                }
            }
        });

        gui.loginBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setPanelForRegistrationFalse();
                gui.setPanelForLoginTrue();

            }
        });
        gui.realLoginBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = gui.getLoginUsernameField();
                String password = gui.getLoginPasswordField();
                if (gui.getComboBox().getSelectedItem().toString().equals("Administrator")) {
                    if (logs.adminLogin(username, password)) {
                        clientGUI.setVisible(false);
                        adminGUI.setVisible(true);


                    } else {
                        JOptionPane.showMessageDialog(gui, "Bad input");
                    }
                }
                if (gui.getComboBox().getSelectedItem().toString().equals("Employee")) {
                    if (logs.employeeLogin(username, password)) {
                        adminGUI.setVisible(false);
                        employeeGUI.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(gui, "Bad input");
                    }
                }
                if (gui.getComboBox().getSelectedItem().toString().equals("Client")) {
                    if (logs.login(username, password)) {
                        adminGUI.setVisible(false);
                        clientGUI.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(gui, "Bad input");
                    }
                }
            }
        });
        adminGUI.getImportBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ds.csvProducts();
            }
        });

        adminGUI.getViewBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductsTableGUI jTable = new ProductsTableGUI(ds.populateTable());

                adminGUI.getImportCompositeBtn(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        List<BaseProduct> menuItems = new ArrayList<>();
                        int[] selected = jTable.getjTable().getSelectedRows();
                        for(int i = 0; i < selected.length; i++){
                            menuItems.add(new BaseProduct("",
                                    Double.parseDouble(String.valueOf(jTable.getjTable().getModel().getValueAt(selected[i], 1))),
                                    Integer.parseInt(String.valueOf(jTable.getjTable().getModel().getValueAt(selected[i], 2))),
                                    Integer.parseInt(String.valueOf(jTable.getjTable().getModel().getValueAt(selected[i], 3))),
                                    Integer.parseInt(String.valueOf(jTable.getjTable().getModel().getValueAt(selected[i], 4))),
                                    Integer.parseInt(String.valueOf(jTable.getjTable().getModel().getValueAt(selected[i], 5))),
                                    Integer.parseInt(String.valueOf(jTable.getjTable().getModel().getValueAt(selected[i], 6)))));
                        }
                        CompositeProduct cp = new CompositeProduct(adminGUI.getCompositeFiled(), menuItems);
                        ds.insertMenuItem(cp);
                    }
                });

            }
        });

        adminGUI.getInsertBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title;
                double rating;
                int calories, proteins, fats, sodium, price;
                try{
                    title = adminGUI.getNewTitle();
                    rating = Double.parseDouble(adminGUI.getNewRating());
                    calories = Integer.parseInt(adminGUI.getNewCalories());
                    proteins = Integer.parseInt(adminGUI.getNewProteins());
                    fats = Integer.parseInt(adminGUI.getNewFats());
                    sodium = Integer.parseInt(adminGUI.getNewSodium());
                    price = Integer.parseInt(adminGUI.getNewPrice());
                    MenuItem menuItem = new BaseProduct(title, rating, calories, proteins, fats, sodium, price);
                    ds.insertMenuItem(menuItem);
                }catch(NumberFormatException nfex){
                    JOptionPane.showMessageDialog(adminGUI, "Bad Input");
                }
            }
        });

        adminGUI.getDeleteBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ds.deleteMenuItem(adminGUI.getDeleteProduct());
            }
        });

        adminGUI.getModifyBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldTitle, newTitle;
                double rating;
                int calories, proteins, fats, sodium, price;
                try{
                    oldTitle = adminGUI.getTitleToBeModified();
                    newTitle = adminGUI.getTitleForModified();
                    rating = Double.parseDouble(adminGUI.getRatingForModified());
                    calories = Integer.parseInt(adminGUI.getCaloriesForModified());
                    proteins = Integer.parseInt(adminGUI.getPriceForModified());
                    fats = Integer.parseInt(adminGUI.getFatsForModified());
                    sodium = Integer.parseInt(adminGUI.getSodiumForModified());
                    price = Integer.parseInt(adminGUI.getPriceForModified());
                    ds.modifyMenuItem(oldTitle, newTitle, rating, calories, proteins, fats, sodium, price);
                }catch (NumberFormatException nfex){
                    JOptionPane.showMessageDialog(adminGUI, "Bad Input");
                }
            }
        });

        adminGUI.getFirstReportBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int startingHour, endingHour;
                try{
                    startingHour = Integer.parseInt(adminGUI.getStartingHour());
                    endingHour = Integer.parseInt(adminGUI.getEndingHour());
                    ds.report1(startingHour, endingHour);
                }catch(NumberFormatException nfex){
                    JOptionPane.showMessageDialog(adminGUI, "Bad Input");
                }
            }
        });

        adminGUI.getSecondReportBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int specifiedNumber;
                try{
                    specifiedNumber = Integer.parseInt(adminGUI.getFieldForSecondReport());
                   //ds.reportMoreThanSpecifiedNumber2(specifiedNumber);
                    ds.report2(specifiedNumber);
                }catch(NumberFormatException nfex){
                    JOptionPane.showMessageDialog(adminGUI, "Bad Input");
                }
            }
        });

        adminGUI.getThirdReportBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int specifiedNumber, amount;
                try{
                    specifiedNumber = Integer.parseInt(adminGUI.getFirstFieldForThirdReport());
                    amount = Integer.parseInt(adminGUI.getSecondFieldForThirdReport());
                    //ds.reportMoreThanSpecifiedNumberOfTimes3(specifiedNumber, amount);
                    ds.report3(specifiedNumber, amount);
                }catch(NumberFormatException nfex){
                    JOptionPane.showMessageDialog(adminGUI, "Bad Input");
                }
            }
        });

        adminGUI.getFourthReportBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int day;
                try{
                    day = Integer.parseInt(adminGUI.getFieldForFourthReport());
                    //ds.reportTheSpecifiedDay4(day);
                    ds.report4(day);
                }catch(NumberFormatException nfex){
                    JOptionPane.showMessageDialog(adminGUI, "Bad Input");
                }
            }
        });

        clientGUI.getViewAllBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductsTableGUI jTable = new ProductsTableGUI(ds.populateTable());
                clientGUI.setTable(jTable);
                clientGUI.getOrderBtn(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Set<MenuItem> menuItems = new HashSet<>();
                        int[] selected = jTable.getjTable().getSelectedRows();
                        for(int i = 0; i < selected.length; i++){
                            menuItems.add(new BaseProduct(String.valueOf(jTable.getjTable().getModel().getValueAt(selected[i], 0)),
                                    Double.parseDouble(String.valueOf(jTable.getjTable().getModel().getValueAt(selected[i], 1))),
                                    Integer.parseInt(String.valueOf(jTable.getjTable().getModel().getValueAt(selected[i], 2))),
                                    Integer.parseInt(String.valueOf(jTable.getjTable().getModel().getValueAt(selected[i], 3))),
                                    Integer.parseInt(String.valueOf(jTable.getjTable().getModel().getValueAt(selected[i], 4))),
                                    Integer.parseInt(String.valueOf(jTable.getjTable().getModel().getValueAt(selected[i], 5))),
                                    Integer.parseInt(String.valueOf(jTable.getjTable().getModel().getValueAt(selected[i], 6)))));
                        }
                        ds.createOrder(menuItems, Integer.parseInt(clientGUI.getClientIDField()));
                    }
                });
            }
        });

        clientGUI.getSearchBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title;
                double rating;
                int calories, proteins, fats, sodium, price;
                title = clientGUI.getTitleToSearch();
                if(clientGUI.getRatingToSearch().equals("")) {
                    rating = Integer.MIN_VALUE;
                }else {
                    rating = Double.parseDouble(clientGUI.getRatingToSearch());
                }
                if(clientGUI.getCaloriesToSearch().equals("")){
                    calories = Integer.MAX_VALUE;
                }else {
                    calories = Integer.parseInt(clientGUI.getCaloriesToSearch());
                }
                if(clientGUI.getProteinsToSearch().equals("")){
                    proteins = Integer.MAX_VALUE;
                }else {
                    proteins = Integer.parseInt(clientGUI.getProteinsToSearch());
                }
                if(clientGUI.getFatsToSearch().equals("")){
                    fats =Integer.MAX_VALUE;
                }else {
                    fats = Integer.parseInt(clientGUI.getFatsToSearch());
                }
                if(clientGUI.getSodiumToSearch().equals("")){
                    sodium = Integer.MAX_VALUE;
                }else {
                    sodium = Integer.parseInt(clientGUI.getSodiumToSearch());
                }
                if(clientGUI.getPriceToSearch().equals("")){
                    price = Integer.MAX_VALUE;
                }else {
                    price = Integer.parseInt(clientGUI.getPriceToSearch());
                }
                ProductsTableGUI jTable = new ProductsTableGUI(ds.populateTableAfterSearch(title, rating, calories, proteins, fats, sodium, price));
                clientGUI.setTable(jTable);

            }
        });
    }

}
