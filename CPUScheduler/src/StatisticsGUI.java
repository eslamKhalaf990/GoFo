import javax.swing.*;
import java.awt.*;

public class StatisticsGUI extends JFrame{
    StatisticsGUI(int [][]mat,int n) {

        this.setBounds(100, 100, 1200, 700);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.darkGray);
        this.setVisible(true);
        int val = 120;

        for(int i=0; i<n; i++){
            JLabel label = new JLabel("process "+ (i+1));
            this.getContentPane().add(label);
            label.setForeground(Color.white);
            label.setFont(new Font("Corbel", Font.PLAIN, 20));
            label.setBounds(10, 40*(i+1), 100, 20);
            label.setVisible(true);
            JButton btnNewButton = new JButton();
            btnNewButton.setBackground(Color.orange);
            this.getContentPane().add(btnNewButton);
            btnNewButton.setBounds(val, 40*(i+1), mat[i][2], 20);
            val += mat[i][2];
            System.out.println(val);
            btnNewButton.setVisible(true);
        }
    }

}
