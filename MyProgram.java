import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;

public class MyProgram extends JFrame {

    private MyProgramUtility utility;
    private JTextArea displayArea;
    private JTextField searchField;

    public MyProgram() {
        utility = new MyProgramUtility();
        createMainGUI();
    }

    private void createMainGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Citizen Data Processing Program");
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem loadDataItem = new JMenuItem("Load Data");
        JMenuItem showCitizensPerDistrictItem = new JMenuItem("Show Citizens per District");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Add action listeners to menu items
        loadDataItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadData();
            }
        });

        showCitizensPerDistrictItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCitizensPerDistrict();
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add menu items to menu
        menu.add(loadDataItem);
        menu.add(showCitizensPerDistrictItem);
        menu.add(exitItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Create search panel
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchField = new JTextField();
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchName = searchField.getText();
                if (!searchName.isEmpty()) {
                    displaySearchResults(searchName);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a name to search.");
                }
            }
        });
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);

        // Create display area
        displayArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Add components to the frame
        add(searchPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void displaySearchResults(String searchName) {
        boolean found = false;
        StringBuilder searchResult = new StringBuilder();
        for (Citizen citizen : utility.getCitizens()) {
            if (citizen.getLastName().equalsIgnoreCase(searchName) || citizen.getFirstName().equalsIgnoreCase(searchName)) {
                found = true;
                searchResult.append(citizen).append("\n");
            }
        }
        if (found) {
            new SearchResultsFrame(searchName, new StringBuilder(searchResult.toString()));
        } else {
            JOptionPane.showMessageDialog(null, "Citizen with name '" + searchName + "' not found.");
        }
    }

    private void loadData() {
        try {
            utility.loadDataFromFile("Sambot/data.csv");
            JOptionPane.showMessageDialog(null, "Data loaded successfully!");
            displayCitizensInfo(); // Display loaded data in the JTextArea
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading data: " + ex.getMessage());
        }
    }

    private void showCitizensPerDistrict() {
        Map<Integer, Integer> citizensPerDistrict = utility.getCitizensPerDistrict();
        StringBuilder message = new StringBuilder("Citizens per District:\n");
        for (Map.Entry<Integer, Integer> entry : citizensPerDistrict.entrySet()) {
            message.append("District ").append(entry.getKey()).append(": ").append(entry.getValue()).append(" citizens\n");
        }
        JOptionPane.showMessageDialog(null, message.toString());
    }

    private void displayCitizensInfo() {
        StringBuilder info = new StringBuilder();
        for (Citizen citizen : utility.getCitizens()) {
            info.append(citizen).append("\n");
        }
        displayArea.setText(info.toString());
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
