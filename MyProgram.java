import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyProgram extends JFrame {

    private MyProgramUtility utility;

    public MyProgram() {
        utility = new MyProgramUtility();
        createGUI();
    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Citizen Data Processing Program");
        setSize(400, 200);
        setLayout(new FlowLayout());

        JButton loadDataButton = new JButton("Load Data");
        JButton processButton = new JButton("Process Data");

        loadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    utility.loadDataFromFile("data.csv");
                    JOptionPane.showMessageDialog(null, "Data loaded successfully!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error loading data: " + ex.getMessage());
                }
            }
        });

        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement processing of data and display results here
                JOptionPane.showMessageDialog(null, "Processing data...");
            }
        });

        add(loadDataButton);
        add(processButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyProgram();
            }
        });
    }
}
