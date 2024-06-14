package GUI;

import javax.swing.*;
import java.awt.*;

public class DataPanel extends JPanel {

    private JTextArea textArea;

    public DataPanel() {
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void updateContent(String content) {
        textArea.setText(content);
    }
}
