package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FormPanel extends JPanel {

    private JTextField nameField;
    private JTextField lastNameField;
    private JComboBox<String> heightComboBox;
    private JRadioButton usaRadioButton;
    private JRadioButton europeRadioButton;
    private JButton saveButton;
    private JButton showButton;
    private List<Person> peopleList;
    private final String filename = "people.bin";

    public FormPanel() {
        // Initialize the peopleList in the constructor
        peopleList = new ArrayList<>();

        // Setup GUI components using GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        nameField = new JTextField(15);
        lastNameField = new JTextField(15);
        heightComboBox = new JComboBox<>(new String[]{"< 160", "160 - 170", "170 - 180", "180 - 190", "> 190"});
        usaRadioButton = new JRadioButton("USA");
        europeRadioButton = new JRadioButton("Europe");
        ButtonGroup locationGroup = new ButtonGroup();
        locationGroup.add(usaRadioButton);
        locationGroup.add(europeRadioButton);
        saveButton = new JButton("Save");
        showButton = new JButton("Show");
        showButton.setEnabled(false); // Initially disable the Show button

        gc.insets = new Insets(5, 5, 5, 5);
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Name: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);

        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Last Name: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(lastNameField, gc);

        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Height: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(heightComboBox, gc);

        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Location: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(usaRadioButton, gc);

        gc.gridy++;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(europeRadioButton, gc);

        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(saveButton, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(showButton, gc);

        // Event listener for the Save button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });

        // Event listener for the Show button
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showData();
            }
        });
    }

    private void saveData() {
        String name = nameField.getText();
        String lastName = lastNameField.getText();
        String height = (String) heightComboBox.getSelectedItem();
        String location = usaRadioButton.isSelected() ? "USA" : "Europe";

        // Create a new Person object
        Person person = new Person(name, lastName, height, location);




        // Save the updated list to a binary file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(peopleList);
            showButton.setEnabled(true); // Enable the Show button after saving
            JOptionPane.showMessageDialog(this, "Data saved successfully!");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving data!");
        }
    }

    private void showData() {
        // Read the list from the binary file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Person> people = (List<Person>) ois.readObject();
            StringBuilder data = new StringBuilder();
            for (Person person : people) {
                data.append(person).append("\n");
            }
            // Assuming the DataPanel has a method to update its content
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
            mainFrame.updateDataPanel(data.toString());
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading data!");
        }
    }
}
