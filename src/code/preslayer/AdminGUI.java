package code.preslayer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

public class AdminGUI extends JFrame{

    private JPanel contentPane;
    private JButton insertItemBtn;
    private JButton deleteItemBtn;
    private JButton modifyItemBtn;
    private JButton insertCompositeBtn;
    JButton firstReportBtn;
    JButton secondReportBtn;
    JButton thirdReportBtn;
    JButton fourthReportBtn;
    JButton viewProductsBtn;
    JButton importProductsBtn;
    private JTextField deleteField;
    private JTextField oldTitleField;
    private JTextField newTitleField;
    private JTextField ratingFied;
    private JTextField caloriesField;
    private JTextField proteinsField;
    private JTextField fatsField;
    private JTextField sodiumField;
    private JTextField priceField;
    private JTextField startingHourField;
    private JTextField endingHourField;
    private JLabel newTimeLabel;
    private JLabel newEndLabel;
    private JLabel newNrOfTimesLabel;
    private JTextField report2Field;
    private JLabel newNrOfTimesOrderedLabel;
    private JTextField report3TimesField;
    private JLabel newTimesLabel;
    private JTextField report3AmountFiled;
    private JLabel newDayLabel;
    private JTextField report4DayField;
    private JTextField newProductNameField;
    private JTextField newProductRatingField;
    private JTextField newProductCaloriesField;
    private JTextField newProductProteinsField;
    private JTextField newProductFatsField;
    private JTextField newProductSodiumField;
    private JTextField newProductPriceField;
    private JLabel newProductTitle;
    private JLabel newProductRating;
    private JLabel newProductCalories;
    private JLabel newProductProteins;
    private JLabel newProductFats;
    private JLabel newProductSodium;
    private JLabel newProductPrice;
    private JTextField compositeTitleField;

    public AdminGUI() {
        setTitle("Adiministrator Panel");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 450, 900, 625);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        insertItemBtn = new JButton("Insert Item");
        insertItemBtn.setBounds(10, 30, 130, 30);
        contentPane.add(insertItemBtn);

        deleteItemBtn = new JButton("Delete Item");
        deleteItemBtn.setBounds(10, 92, 130, 30);
        contentPane.add(deleteItemBtn);

        modifyItemBtn = new JButton("Modify Item");
        modifyItemBtn.setBounds(10, 150, 130, 30);
        contentPane.add(modifyItemBtn);

        firstReportBtn = new JButton("First Report");
        firstReportBtn.setBounds(10, 208, 130, 30);
        contentPane.add(firstReportBtn);

        secondReportBtn = new JButton("Second report");
        secondReportBtn.setBounds(10, 268, 130, 30);
        contentPane.add(secondReportBtn);

        thirdReportBtn = new JButton("Third Report");
        thirdReportBtn.setBounds(10, 323, 130, 30);
        contentPane.add(thirdReportBtn);

        fourthReportBtn = new JButton("Fourth Report");
        fourthReportBtn.setBounds(10, 382, 130, 30);
        contentPane.add(fourthReportBtn);

        insertCompositeBtn = new JButton("Insert Composite");
        insertCompositeBtn.setBounds(10, 530, 130, 30);
        contentPane.add(insertCompositeBtn);

        deleteField = new JTextField();
        deleteField.setBounds(203, 102, 104, 20);
        contentPane.add(deleteField);
        deleteField.setColumns(10);

        JLabel deleteLabel = new JLabel("Select to delete:");
        deleteLabel.setBounds(203, 80, 104, 14);
        contentPane.add(deleteLabel);

        oldTitleField = new JTextField();
        oldTitleField.setBounds(203, 155, 104, 20);
        contentPane.add(oldTitleField);
        oldTitleField.setColumns(10);

        newTitleField = new JTextField();
        newTitleField.setColumns(10);
        newTitleField.setBounds(325, 155, 104, 20);
        contentPane.add(newTitleField);

        ratingFied = new JTextField();
        ratingFied.setColumns(10);
        ratingFied.setBounds(446, 155, 54, 20);
        contentPane.add(ratingFied);

        caloriesField = new JTextField();
        caloriesField.setColumns(10);
        caloriesField.setBounds(520, 155, 54, 20);
        contentPane.add(caloriesField);

        proteinsField = new JTextField();
        proteinsField.setColumns(10);
        proteinsField.setBounds(586, 155, 54, 20);
        contentPane.add(proteinsField);

        fatsField = new JTextField();
        fatsField.setColumns(10);
        fatsField.setBounds(650, 155, 54, 20);
        contentPane.add(fatsField);

        sodiumField = new JTextField();
        sodiumField.setColumns(10);
        sodiumField.setBounds(718, 155, 54, 20);
        contentPane.add(sodiumField);

        priceField = new JTextField();
        priceField.setColumns(10);
        priceField.setBounds(782, 155, 54, 20);
        contentPane.add(priceField);

        JLabel newLabel1 = new JLabel("Old title:");
        newLabel1.setBounds(203, 133, 79, 14);
        contentPane.add(newLabel1);

        JLabel newLabel2 = new JLabel("New title:");
        newLabel2.setBounds(325, 130, 79, 14);
        contentPane.add(newLabel2);

        JLabel newLabel3 = new JLabel("Rating:");
        newLabel3.setBounds(446, 133, 54, 14);
        contentPane.add(newLabel3);

        JLabel newLabel4 = new JLabel("Calories:");
        newLabel4.setBounds(520, 130, 54, 14);
        contentPane.add(newLabel4);

        JLabel newLabel5 = new JLabel("Proteins:");
        newLabel5.setBounds(586, 130, 54, 14);
        contentPane.add(newLabel5);

        JLabel newLabel6 = new JLabel("Fats:");
        newLabel6.setBounds(650, 130, 54, 14);
        contentPane.add(newLabel6);

        JLabel newLabel7 = new JLabel("Sodium:");
        newLabel7.setBounds(714, 130, 54, 14);
        contentPane.add(newLabel7);

        JLabel newLabel8 = new JLabel("Price:");
        newLabel8.setBounds(782, 130, 54, 14);
        contentPane.add(newLabel8);

        startingHourField = new JTextField();
        startingHourField.setBounds(304, 213, 45, 20);
        contentPane.add(startingHourField);
        startingHourField.setColumns(10);

        endingHourField = new JTextField();
        endingHourField.setColumns(10);
        endingHourField.setBounds(561, 213, 45, 20);
        contentPane.add(endingHourField);

        newTimeLabel = new JLabel("Starting hour:");
        newTimeLabel.setBounds(203, 216, 79, 14);
        contentPane.add(newTimeLabel);

        newEndLabel = new JLabel("Ending hour:");
        newEndLabel.setBounds(472, 216, 79, 14);
        contentPane.add(newEndLabel);

        newNrOfTimesLabel = new JLabel("Products ordered more than:");
        newNrOfTimesLabel.setBounds(203, 276, 200, 22);
        contentPane.add(newNrOfTimesLabel);

        report2Field = new JTextField();
        report2Field.setBounds(375, 278, 54, 20);
        contentPane.add(report2Field);
        report2Field.setColumns(10);

        newNrOfTimesOrderedLabel = new JLabel("Clients ordered");
        newNrOfTimesOrderedLabel.setBounds(203, 333, 89, 20);
        contentPane.add(newNrOfTimesOrderedLabel);

        report3TimesField = new JTextField();
        report3TimesField.setBounds(304, 333, 45, 20);
        contentPane.add(report3TimesField);
        report3TimesField.setColumns(10);

        newTimesLabel = new JLabel("times.  Amount:");
        newTimesLabel.setBounds(369, 333, 105, 14);
        contentPane.add(newTimesLabel);

        report3AmountFiled = new JTextField();
        report3AmountFiled.setColumns(10);
        report3AmountFiled.setBounds(483, 333, 45, 20);
        contentPane.add(report3AmountFiled);

        newDayLabel = new JLabel("Day");
        newDayLabel.setBounds(203, 390, 46, 14);
        contentPane.add(newDayLabel);

        report4DayField = new JTextField();
        report4DayField.setColumns(10);
        report4DayField.setBounds(244, 387, 45, 20);
        contentPane.add(report4DayField);

        newProductNameField = new JTextField();
        newProductNameField.setColumns(10);
        newProductNameField.setBounds(203, 35, 104, 20);
        contentPane.add(newProductNameField);

        newProductRatingField = new JTextField();
        newProductRatingField.setColumns(10);
        newProductRatingField.setBounds(325, 35, 54, 20);
        contentPane.add(newProductRatingField);

        newProductCaloriesField = new JTextField();
        newProductCaloriesField.setColumns(10);
        newProductCaloriesField.setBounds(389, 35, 54, 20);
        contentPane.add(newProductCaloriesField);

        newProductProteinsField = new JTextField();
        newProductProteinsField.setColumns(10);
        newProductProteinsField.setBounds(453, 35, 54, 20);
        contentPane.add(newProductProteinsField);

        newProductFatsField = new JTextField();
        newProductFatsField.setColumns(10);
        newProductFatsField.setBounds(520, 35, 54, 20);
        contentPane.add(newProductFatsField);

        newProductSodiumField = new JTextField();
        newProductSodiumField.setColumns(10);
        newProductSodiumField.setBounds(586, 35, 54, 20);
        contentPane.add(newProductSodiumField);

        newProductPriceField = new JTextField();
        newProductPriceField.setColumns(10);
        newProductPriceField.setBounds(650, 35, 54, 20);
        contentPane.add(newProductPriceField);

        newProductTitle = new JLabel("Title:");
        newProductTitle.setBounds(203, 10, 65, 14);
        contentPane.add(newProductTitle);

        newProductRating = new JLabel("Rating:");
        newProductRating.setBounds(325, 10, 54, 14);
        contentPane.add(newProductRating);

        newProductCalories = new JLabel("Calories:");
        newProductCalories.setBounds(389, 10, 54, 14);
        contentPane.add(newProductCalories);

        newProductProteins = new JLabel("Proteins:");
        newProductProteins.setBounds(453, 10, 54, 14);
        contentPane.add(newProductProteins);

        newProductFats = new JLabel("Fats:");
        newProductFats.setBounds(520, 10, 54, 14);
        contentPane.add(newProductFats);

        newProductSodium = new JLabel("Sodium:");
        newProductSodium.setBounds(586, 10, 54, 14);
        contentPane.add(newProductSodium);

        newProductPrice = new JLabel("Price:");
        newProductPrice.setBounds(650, 10, 54, 14);
        contentPane.add(newProductPrice);

        viewProductsBtn = new JButton("View Products");
        viewProductsBtn.setBounds(10, 431, 130, 30);
        contentPane.add(viewProductsBtn);

        importProductsBtn = new JButton("Import Products");
        importProductsBtn.setBounds(10, 482, 130, 30);
        contentPane.add(importProductsBtn);

        compositeTitleField = new JTextField();
        compositeTitleField.setBounds(203, 530, 150, 20);
        compositeTitleField.setToolTipText("Composite product title");
        contentPane.add(compositeTitleField);
        compositeTitleField.setColumns(10);

    }

    public String getNewTitle(){
        return newProductNameField.getText();
    }

    public String getNewRating(){
        return newProductRatingField.getText();
    }

    public String getNewCalories(){
        return newProductCaloriesField.getText();
    }

    public String getNewProteins(){
        return newProductProteinsField.getText();
    }

    public String getNewFats(){
        return  newProductFatsField.getText();
    }

    public String getNewSodium(){
        return newProductSodiumField.getText();
    }

    public String getNewPrice(){
        return newProductPriceField.getText();
    }

    public String getDeleteProduct(){
        return deleteField.getText();
    }

    public void setNewTitle(String title){
        this.newProductNameField.setText(title);
    }

    public String getTitleToBeModified(){
        return oldTitleField.getText();
    }

    public String getTitleForModified(){
        return newTitleField.getText();
    }

    public String getRatingForModified(){
        return ratingFied.getText();
    }

    public String getCaloriesForModified(){
        return caloriesField.getText();
    }

    public String getProteinsForModified() {
        return proteinsField.getText();
    }

    public String getFatsForModified(){
        return fatsField.getText();
    }

    public String getSodiumForModified(){
        return sodiumField.getText();
    }

    public String getPriceForModified(){
        return priceField.getText();
    }

    public String getStartingHour(){
        return startingHourField.getText();
    }

    public String getEndingHour(){
        return endingHourField.getText();
    }

    public String getFieldForSecondReport(){
        return report2Field.getText();
    }

    public String getFirstFieldForThirdReport(){
        return report3TimesField.getText();
    }

    public String getSecondFieldForThirdReport(){
        return report3AmountFiled.getText();
    }

    public String getFieldForFourthReport(){
        return report4DayField.getText();
    }

    public String getCompositeFiled(){
        return compositeTitleField.getText();
    }

    public void getInsertBtn(ActionListener actionListener){
        this.insertItemBtn.addActionListener(actionListener);
    }

    public void getDeleteBtn(ActionListener actionListener){
        this.deleteItemBtn.addActionListener(actionListener);
    }

    public void getModifyBtn(ActionListener actionListener){
        this.modifyItemBtn.addActionListener(actionListener);
    }

    public void getFirstReportBtn(ActionListener actionListener){
        this.firstReportBtn.addActionListener(actionListener);
    }

    public void getSecondReportBtn(ActionListener actionListener){
        this.secondReportBtn.addActionListener(actionListener);
    }

    public void getThirdReportBtn(ActionListener actionListener){
        this.thirdReportBtn.addActionListener(actionListener);
    }

    public void getFourthReportBtn(ActionListener actionListener){
        this.fourthReportBtn.addActionListener(actionListener);
    }

    public void getViewBtn(ActionListener actionListener){
        this.viewProductsBtn.addActionListener(actionListener);
    }

    public void getImportBtn(ActionListener actionListener){
        this.importProductsBtn.addActionListener(actionListener);
    }

    public void getImportCompositeBtn(ActionListener actionListener){
        this.insertCompositeBtn.addActionListener(actionListener);
    }

}
