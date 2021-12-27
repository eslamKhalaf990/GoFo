import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class getProcessesGUI extends JFrame {

    private JTextField DevicestextField;

    public getProcessesGUI() throws InterruptedException {

        this.setBounds(100, 100, 1200, 700);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.darkGray);


        this.setTitle("SCHEDULER");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("SCHEDULER");
        label.setForeground(Color.white);
        label.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 29));
        label.setBounds(480, 1, 767, 80);


        this.getContentPane().add(label);
        this.setResizable(false);
        this.setVisible(true);

        JLabel lblWhatIsThe = new JLabel("Number Of Processes?");
        lblWhatIsThe.setForeground(Color.white);
        lblWhatIsThe.setFont(new Font("Corbel", Font.PLAIN, 20));
        lblWhatIsThe.setBounds(70, 112, 568, 20);
        this.getContentPane().add(lblWhatIsThe);

        JLabel lb2 = new JLabel("Round Robin Time Quantum?");
        lb2.setForeground(Color.white);
        lb2.setFont(new Font("Corbel", Font.PLAIN, 20));
        lb2.setBounds(70, 188, 568, 20);
        this.getContentPane().add(lb2);

        JLabel lb3 = new JLabel("context switching?");
        lb3.setForeground(Color.white);
        lb3.setFont(new Font("Corbel", Font.PLAIN, 20));
        lb3.setBounds(70, 260, 384, 20);
        this.getContentPane().add(lb3);

        JTextField numberOfProcesses = new JTextField();
        numberOfProcesses.setBounds(72, 137, 344, 26);
        this.getContentPane().add(numberOfProcesses);
        numberOfProcesses.setColumns(10);
        numberOfProcesses.setVisible(true);
        numberOfProcesses.requestFocus();

        JTextField roundRobin = new JTextField();
        roundRobin.setColumns(10);
        roundRobin.setBounds(70, 218, 344, 26);
        this.getContentPane().add(roundRobin);
        roundRobin.requestFocus();


        JTextField contextSwitching = new JTextField();
        contextSwitching.setColumns(10);
        contextSwitching.setBounds(70, 290, 344, 26);
        this.getContentPane().add(contextSwitching);
        contextSwitching.requestFocus();

        JButton btnNewButton = new JButton("Start Simulation");
        btnNewButton.addActionListener(arg0 -> {
            int num;
           num = Integer.parseInt(numberOfProcesses.getText().strip());
            createProcessGUI c = new createProcessGUI(num);
        });

        btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 24));
        btnNewButton.setBackground(Color.LIGHT_GRAY);
        btnNewButton.setForeground(Color.BLACK);
        this.getContentPane().add(btnNewButton);
        btnNewButton.setBounds(400, 440, 360, 65);
        btnNewButton.setVisible(true);


    }
    public static void main(String[]args){
        try {
            getProcessesGUI getProcessesGUI = new getProcessesGUI();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}