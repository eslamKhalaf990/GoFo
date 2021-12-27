import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class createProcessGUI extends JFrame{
    public createProcessGUI(int n){
        this.setBounds(100, 100, 1200, 700);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.darkGray);

        this.setVisible(true);
        JLabel label = new JLabel("Process Name       Process Color     " +
                "  Arrival Time           Burst Time          Priority Number");
        label.setForeground(Color.white);
        label.setBounds(75, 1, 500, 20);
        label.setVisible(true);
        this.getContentPane().add(label);
        ArrayList<JTextField> processName = new ArrayList<>();
        ArrayList<JTextField> processColor = new ArrayList<>();
        ArrayList<JTextField> arrivalTime = new ArrayList<>();
        ArrayList<JTextField> burstTime = new ArrayList<>();
        ArrayList<JTextField> priorityNumber = new ArrayList<>();
        for(int i=0; i<n;i++){
            JTextField txt1 = new JTextField();
            processName.add(txt1);
            processName.get(i).setForeground(Color.black);
            processName.get(i).setBounds(72, 40*(i+1), 90, 26);
            this.getContentPane().add(processName.get(i));
            processName.get(i).setVisible(true);

            JTextField txt2 = new JTextField();
            processColor.add(txt2);
            processColor.get(i).setForeground(Color.black);
            processColor.get(i).setBounds(180, 40*(i+1), 90, 26);
            this.getContentPane().add(processColor.get(i));
            processColor.get(i).setVisible(true);

            JTextField txt3 = new JTextField();
            arrivalTime.add(txt3);
            arrivalTime.get(i).setForeground(Color.black);
            arrivalTime.get(i).setBounds(280, 40*(i+1), 90, 26);
            this.getContentPane().add(arrivalTime.get(i));
            arrivalTime.get(i).setVisible(true);

            JTextField txt4 = new JTextField();
            burstTime.add(txt4);
            burstTime.get(i).setForeground(Color.black);
            burstTime.get(i).setBounds(380, 40*(i+1), 90, 26);
            this.getContentPane().add(burstTime.get(i));
            burstTime.get(i).setVisible(true);

            JTextField txt5 = new JTextField();
            priorityNumber.add(txt5);
            priorityNumber.get(i).setForeground(Color.black);
            priorityNumber.get(i).setBounds(480, 40*(i+1), 90, 26);
            this.getContentPane().add(priorityNumber.get(i));
            priorityNumber.get(i).setVisible(true);
        }
        JButton createProcess = new JButton("Create Processes");
        createProcess.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 24));
        createProcess.setBackground(Color.LIGHT_GRAY);
        createProcess.setForeground(Color.BLACK);
        createProcess.setBounds(400, 440, 360, 65);
        this.getContentPane().add(createProcess);
        createProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0; i<n; i++){
                    GFG.mat[i][0] = Integer.parseInt(processName.get(i).getText());
                    GFG.mat[i][1] = Integer.parseInt(arrivalTime.get(i).getText());
                    GFG.mat[i][2] = Integer.parseInt(burstTime.get(i).getText());

                }
                GFG.arrangeArrival(n, GFG.mat);
                GFG.completionTime(n, GFG.mat);
                System.out.println("Final Result...");
                System.out.println(
                        "Process ID\tArrival Time\tBurst"
                                + " Time\tWaiting Time\tTurnaround Time");
                for (int i = 0; i < n; i++) {
                    System.out.printf(
                            "%d\t\t%d\t\t%d\t\t%d\t\t%d\n", GFG.mat[i][0],
                            GFG.mat[i][1], GFG.mat[i][2], GFG.mat[i][4], GFG.mat[i][5]);
                }
                StatisticsGUI statisticsGUI = new StatisticsGUI(GFG.mat, n);

            }
        });

    }
}
