package code.preslayer;

import code.datalayer.Users;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame{

    private JPanel contentPane;
    private JComboBox comboBox;
    private JPanel panelForLogin;
    private JPanel panelForRegistration;
    private JButton loginBtn;
    private JButton registerBtn;
    private JLabel registerLabel;
    private JTextField registerUsernameField;
    private JPasswordField registerPasswordField;
    private JButton realRegisterBtn;
    private JTextField loginUsernameField;
    private JPasswordField loginPasswordField;
    private JButton realLoginBtn;
    private JLabel loginLabel;

    public MainGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(100, 100, 700, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        comboBox = new JComboBox(Users.values());
        comboBox.setBackground(new Color(192, 192, 192));
        comboBox.setToolTipText("Select user");
        comboBox.setBounds(30, 50, 120, 22);
        contentPane.add(comboBox);

        registerBtn = new JButton("Register");
        registerBtn.setForeground(Color.BLACK);
        registerBtn.setFont(new Font("Arial", Font.BOLD, 11));
        registerBtn.setToolTipText("Register");
        registerBtn.setBounds(30, 150, 120, 28);
        contentPane.add(registerBtn);

        loginBtn = new JButton("Login");
        loginBtn.setFont(new Font("Arial", Font.BOLD, 11));
        loginBtn.setToolTipText("Login");
        loginBtn.setBounds(30, 190, 120, 28);
        contentPane.add(loginBtn);

        panelForRegistration = new JPanel();
        panelForRegistration.setBounds(235, 50, 175, 250);
        contentPane.add(panelForRegistration);
        panelForRegistration.setVisible(false);
        panelForRegistration.setLayout(null);

        registerLabel = new JLabel("     Register");
        registerLabel.setFont(new Font("Arial", Font.BOLD, 11));
        registerLabel.setBounds(41, 11, 83, 25);
        panelForRegistration.add(registerLabel);

        registerUsernameField = new JTextField();
        registerUsernameField.setBounds(10, 69, 130, 25);
        panelForRegistration.add(registerUsernameField);
        registerUsernameField.setColumns(10);

        registerPasswordField = new JPasswordField();
        registerPasswordField.setColumns(10);
        registerPasswordField.setBounds(10, 119, 130, 25);
        panelForRegistration.add(registerPasswordField);

        realRegisterBtn = new JButton("Register");
        realRegisterBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
        realRegisterBtn.setForeground(Color.BLACK);
        realRegisterBtn.setToolTipText("Register");
        realRegisterBtn.setBounds(35, 185, 89, 23);
        panelForRegistration.add(realRegisterBtn);

        panelForLogin = new JPanel();
        panelForLogin.setBounds(434, 50, 175, 250);
        contentPane.add(panelForLogin);
        panelForLogin.setVisible(false);
        panelForLogin.setLayout(null);

        loginLabel = new JLabel("     Login");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 11));
        loginLabel.setBounds(50, 11, 83, 25);
        panelForLogin.add(loginLabel);

        loginUsernameField = new JTextField();
        loginUsernameField.setColumns(10);
        loginUsernameField.setBounds(20, 70, 130, 25);
        panelForLogin.add(loginUsernameField);

        loginPasswordField = new JPasswordField();
        loginPasswordField.setColumns(10);
        loginPasswordField.setBounds(20, 118, 130, 25);
        panelForLogin.add(loginPasswordField);

        realLoginBtn = new JButton("Login");
        realLoginBtn.setToolTipText("Login");
        realLoginBtn.setForeground(Color.BLACK);
        realLoginBtn.setFont(new Font("Dialog", Font.BOLD, 12));
        realLoginBtn.setBounds(44, 186, 89, 23);
        panelForLogin.add(realLoginBtn);
    }

    public void registerBtnListener(ActionListener aL){
        this.registerBtn.addActionListener(aL);
    }

    public void loginBtnListener(ActionListener aL){
        this.loginBtn.addActionListener(aL);
    }

    public void realRegisterBtnListener(ActionListener aL){
        this.realRegisterBtn.addActionListener(aL);
    }

    public void realLoginBtnListener(ActionListener aL){
        this.realLoginBtn.addActionListener(aL);
    }

    public String getRegisterUsernameField(){
        return registerUsernameField.getText();
    }

    public String getRegisterPasswordField(){
        return registerPasswordField.getText();
    }

    public String getLoginUsernameField(){
        return loginUsernameField.getText();
    }

    public String getLoginPasswordField(){
        return loginPasswordField.getText();
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setPanelForRegistrationTrue() {
        panelForRegistration.setVisible(true);
    }

    public void setPanelForRegistrationFalse(){
        panelForRegistration.setVisible(false);
    }

    public void setPanelForLoginTrue(){
        panelForLogin.setVisible(true);
    }

    public void setPanelForLoginFalse(){
        panelForLogin.setVisible(false);
    }
}
