package code.preslayer;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
@SuppressWarnings( "deprecation" )
public class EmployeeGUI extends JFrame implements Observer {

    private JPanel contentPane;
    private JLabel newLabel1;
    private JLabel newLabel2;
    private JTextArea textArea;
    private JScrollPane jScrollPane = new JScrollPane();

    public EmployeeGUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 550, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(contentPane);
        contentPane.setLayout(null);

        newLabel1 = new JLabel("No orders placed yet.");
        newLabel1.setBounds(10, 11, 183, 31);
        contentPane.add(newLabel1);

        newLabel2 = new JLabel("");
        newLabel2.setBounds(10, 50, 300, 31);
        contentPane.add(newLabel2);

        textArea = new JTextArea();
        textArea.setBounds(10, 92, 490, 258);
        textArea.add(jScrollPane);
        contentPane.add(textArea);
    }

    @Override
    public void update(Observable o, Object arg){
        newLabel1.setText("");
        newLabel2.setText("The following orders have been placed:");
        jScrollPane.setVisible(true);
        if(!textArea.getText().isEmpty()){
            textArea.setText(textArea.getText() + arg.toString() + "\n");
        }else{
            textArea.setText(arg.toString() + "\n");
        }
    }

}
