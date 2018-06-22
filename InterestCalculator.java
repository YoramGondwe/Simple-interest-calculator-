/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interestcalculator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Joshua silwembe
 */

class interestGui extends JFrame {
    //Labels
    JLabel first_name_label;
    JLabel surname_label;
    JLabel principal_label ;
    JLabel rate_label ;
    JLabel period_label ;
    JLabel interest_label;
   JLabel total_repayment_label;
   
   //Text Fields
   JTextField first_name_textfield;
    JTextField surname_textfield;
    JTextField principal_textfield ;
    JTextField rate_textfield ;
    JTextField period_textfield ;
    JTextField interest_textfield;
   JTextField total_repayment_textfield;
   
   //Button
   JButton calculate;
   
   public interestGui() {
       super("Interest Calculator");
       setLayout(new FlowLayout());
       
       //first name
       first_name_label = new JLabel("First name: ");
       add(first_name_label);
       first_name_textfield = new JTextField(10);
       add(first_name_textfield);
       
       //surname
        surname_label = new JLabel("Surname: ");
       add(surname_label);
       surname_textfield = new JTextField(10);
       add(surname_textfield);
      
       //pricipal
        principal_label = new JLabel("Principal Amt: ");
       add(principal_label);
       principal_textfield = new JTextField(10);
       add(principal_textfield);
       
//rate
        rate_label = new JLabel("Rate: ");
       add(rate_label);
       rate_textfield = new JTextField(10);
       add(rate_textfield);
       
//period
        period_label = new JLabel("Period(days): ");
       add(period_label);
       period_textfield = new JTextField(10);
       add(period_textfield);
      
       //interest
        interest_label = new JLabel("Interest: ");
       add(interest_label);
       interest_textfield = new JTextField(10);
       interest_textfield.setEditable(false);
       add(interest_textfield);
      
       //Total repayment
        total_repayment_label = new JLabel("Total Repayment: ");
       add(total_repayment_label);
       total_repayment_textfield = new JTextField(10);
       total_repayment_textfield.setEditable(false);
       add(total_repayment_textfield);
       
       //calculate button
       calculate = new JButton("Calculate");
       add(calculate);
       
       //Handler
       TextFieldHandler t_handler = new TextFieldHandler();
       ButtonHandler b_handler = new ButtonHandler();
       calculate.addActionListener(b_handler);
   }
   
   private class TextFieldHandler implements ActionListener {

     public void actionPerformed(ActionEvent event) {
         
     }   
   }
   
   private class ButtonHandler implements ActionListener {
       public void actionPerformed(ActionEvent event) {
         if (first_name_textfield.getText().isEmpty() || surname_textfield.getText().isEmpty() || principal_textfield.getText().isEmpty() || rate_textfield.getText().isEmpty() || period_textfield.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill up all fields");
         }
         
         else{
         double interest = ((Double.parseDouble(principal_textfield.getText()) * Double.parseDouble(rate_textfield.getText()) * Double.parseDouble(period_textfield.getText())) / 365);
         double principal = Double.parseDouble(principal_textfield.getText());
         double total_repayment = interest + Double.parseDouble(principal_textfield.getText());
         
         interest_textfield.setText(Double.toString(interest));
         
         
         total_repayment_textfield.setText(Double.toString(total_repayment));
         }
       }
   }
    
    
}
public class InterestCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        interestGui interestFrame = new interestGui();
interestFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
interestFrame.setSize(300, 500);
interestFrame.setVisible(true);
    }
    
}
