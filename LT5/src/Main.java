import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class Main extends Compute{

    public static void main(String[] args) {

        JFrame frame = new JFrame("Portuguez_LT5_Abstraction");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelTitle = new JPanel(new FlowLayout());
        JPanel panelOne = new JPanel(new GridLayout(2, 2, 1, 1));
        JPanel panelTwo = new JPanel(new FlowLayout());
        JButton button = new JButton("Compute!");

        panelTitle.setBounds(10, 10, 380, 40);
        panelOne.setBounds(10, 60, 380, 80);
        panelTwo.setBounds(10, 200, 380, 40);

        frame.getContentPane().setBackground(Color.WHITE);
        panelTitle.setBackground(Color.WHITE);
        panelOne.setBackground(Color.WHITE);
        panelTwo.setBackground(Color.WHITE);

        JLabel labelOne, labelTwo, labelTitle;

        final JTextField tFieldOne, tFieldTwo;
        tFieldOne = new JTextField(20);
        tFieldOne.setPreferredSize(new Dimension(80,20));
        tFieldTwo = new JTextField(20);
        tFieldTwo.setPreferredSize(new Dimension(80,20));

        labelTitle = new JLabel("Discount Percentage Checker:", JLabel.CENTER);
        labelOne = new JLabel(" Original Price:");
        labelTwo = new JLabel(" Discounted from original price:");

        labelTitle.setForeground(Color.BLACK);
        tFieldOne.setBackground(Color.LIGHT_GRAY);
        tFieldTwo.setBackground(Color.LIGHT_GRAY);
        tFieldOne.setForeground(Color.BLACK);
        tFieldTwo.setForeground(Color.BLACK);

        labelTitle.setBounds(10,10,90,20);
        labelOne.setBounds(10,10,90,20);
        tFieldOne.setBounds(5, 5, 100, 100);
        labelTwo.setBounds(10,10,90,20);
        tFieldTwo.setBounds(5, 5, 100, 100);

        panelTitle.add(labelTitle);

        panelOne.add(labelOne);
        panelOne.add(tFieldOne);
        panelOne.add(labelTwo);
        panelOne.add(tFieldTwo);

        button.setBounds(10,10,90,20);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double result = computeDiscount(tFieldOne.getText(),tFieldTwo.getText());
                displayMessage(String.valueOf(result));
            }
        });

        panelTwo.add(button);

        frame.add(panelTitle);
        frame.add(panelOne);
        frame.add(panelTwo);

        frame.setSize(420,300);
        frame.setResizable(false);
        frame.setLayout(null);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}

abstract class Methods {
    public void displayMessage(){
        System.out.println("Your discount percentage");
    }
}
abstract class Compute extends Methods{
    public static double computeDiscount(String value1, String value2){
        double discount = Double.parseDouble(value2);
        double price = Double.parseDouble(value1);
        double dPercent = (discount/price)*100;
        return dPercent;
    }
    public static void displayMessage(String dPercent){
        JOptionPane.showMessageDialog( null, "Discount Percentage is: " + dPercent + "%", "Result" , JOptionPane.INFORMATION_MESSAGE );
    }
}