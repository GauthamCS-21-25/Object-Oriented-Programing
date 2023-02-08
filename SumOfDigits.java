import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SumOfDigits {

    private JFrame frame;
    private JTextField inputField;
    private JTextField outputField;
 
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SumOfDigits window = new SumOfDigits();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public SumOfDigits() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(0, 2, 0, 0));

        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(150, 40));
        panel.add(inputField);
        inputField.setColumns(10);

        outputField = new JTextField();
        outputField.setPreferredSize(new Dimension(150, 40));
        outputField.setEditable(false);
        panel.add(outputField);
        outputField.setColumns(10);

        JPanel panel_1 = new JPanel();
        frame.getContentPane().add(panel_1, BorderLayout.SOUTH);

        JButton btnCompute = new JButton("Compute");
        btnCompute.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int input = Integer.parseInt(inputField.getText());
                int sum = 0;
                while (input > 0) {
                    sum += input % 10;
                    input /= 10;
                }
                outputField.setText(String.valueOf(sum));
            }
        });
        panel_1.add(btnCompute);
    }

}
