import javax.swing.*;
import java.awt.*;

public class SearchResultsFrame extends JFrame {

    private JTextArea displayArea;

    public SearchResultsFrame(String searchName, StringBuilder searchResult) {
        setTitle("Search Results for '" + searchName + "'");
        setSize(400, 300);
        setLayout(new BorderLayout());

        displayArea = new JTextArea();
        displayArea.setText(searchResult.toString());

        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
