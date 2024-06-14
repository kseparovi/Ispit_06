package GUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private DataPanel dataPanel;
    private FormPanel formPanel;

    public MainFrame() {
        super("Hello World");
        initComps();
        layoutComps();

        // Ensure the frame is visible after components are added

    }

    private void initComps() {
        // Initialize the components
        dataPanel = new DataPanel();
        formPanel = new FormPanel();

        // Set layout manager for the frame
        setLayout(new BorderLayout());

        // Add components to the frame
        add(dataPanel, BorderLayout.CENTER);
        add(formPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void layoutComps() {
        // Set frame properties
        setSize(400, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Method to update the data panel
    public void updateDataPanel(String data) {
        dataPanel.updateContent(data);
    }


}
