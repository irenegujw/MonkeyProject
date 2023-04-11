package Sanctuary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SanctuaryView extends JFrame {
    private SanctuaryModel model;
    private JPanel controlPanel;
    private JPanel isolationPanel;
//    private JPanel enclosure1Panel;
//    private JPanel enclosure2Panel;
//    private JPanel enclosure3Panel;
//    private JList isolationList;
//    private JList enclosure1List;
//    private JList enclosure2List;
//    private JList enclosure3List;

    public SanctuaryView(SanctuaryModel model) {
        super("Primate Sanctuary");
        this.model = model;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));

        // Initialize the panels and lists
        controlPanel = new JPanel();
        isolationPanel = new JPanel();
//        enclosure1Panel = new JPanel();
//        enclosure2Panel = new JPanel();
//        enclosure3Panel = new JPanel();

//        isolationList = new JList(model.getIsolationListModel());
//        enclosure1List = new JList(model.getEnclosure1ListModel());
//        enclosure2List = new JList(model.getEnclosure2ListModel());
//        enclosure3List = new JList(model.getEnclosure3ListModel());
//
//        JScrollPane isolationScrollPane = new JScrollPane(model.moveMonkeyToEnclosure);
//        JScrollPane enclosure1ScrollPane = new JScrollPane(enclosure1List);
//        JScrollPane enclosure2ScrollPane = new JScrollPane(enclosure2List);
//        JScrollPane enclosure3ScrollPane = new JScrollPane(enclosure3List);

        // Add the panels and lists to the frame
        add(controlPanel, BorderLayout.NORTH);
        add(isolationPanel, BorderLayout.WEST);
//        add(enclosure1Panel, BorderLayout.CENTER);
//        add(enclosure2Panel, BorderLayout.EAST);
//        add(enclosure3Panel, BorderLayout.SOUTH);

        isolationPanel.add(new JLabel("Isolation"));
//        isolationPanel.add(isolationScrollPane);
//        enclosure1Panel.add(new JLabel("Enclosure 1"));
//        enclosure1Panel.add(enclosure1ScrollPane);
//        enclosure2Panel.add(new JLabel("Enclosure 2"));
//        enclosure2Panel.add(enclosure2ScrollPane);
//        enclosure3Panel.add(new JLabel("Enclosure 3"));
//        enclosure3Panel.add(enclosure3ScrollPane);

        // Initialize the control panel buttons and text fields
        JButton addMonkeyButton = new JButton("Add Monkey");
        JTextField nameTextField = new JTextField(10);
        JComboBox speciesComboBox = new JComboBox(Species.values());
        JComboBox sexComboBox = new JComboBox(Sex.values());
        JTextField sizeTextField = new JTextField(3);
        JTextField ageTextField = new JTextField(3);
        JTextField weightTextField = new JTextField(3);
        JComboBox favFoodComboBox = new JComboBox(Food.values());

        controlPanel.add(new JLabel("Name:"));
        controlPanel.add(nameTextField);
        controlPanel.add(new JLabel("Species:"));
        controlPanel.add(speciesComboBox);
        controlPanel.add(new JLabel("Sex:"));
        controlPanel.add(sexComboBox);
        controlPanel.add(new JLabel("Size:"));
        controlPanel.add(sizeTextField);
        controlPanel.add(new JLabel("Weight:"));
        controlPanel.add(weightTextField);
        controlPanel.add(new JLabel("Age:"));
        controlPanel.add(ageTextField);
        controlPanel.add(new JLabel("Favourite Food:"));
        controlPanel.add(favFoodComboBox);
        controlPanel.add(addMonkeyButton);

        // Set the size of the frame and display it
        pack();
        setVisible(true);

        // Add an ActionListener to the "Add Monkey" button
        addMonkeyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the values from the text fields and combo boxes
                String name = nameTextField.getText();
                Species species = (Species) speciesComboBox.getSelectedItem();
                Sex sex = (Sex) sexComboBox.getSelectedItem();
                int age =Integer.parseInt(ageTextField.getText());
                double size = Double.parseDouble(sizeTextField.getText());
                double weight = Double.parseDouble(weightTextField.getText());
                Food favFood = (Food) favFoodComboBox.getSelectedItem();

                // Attempt to add the monkey to the model
                model.receiveMonkey(new Monkey(name, species, sex, size, weight, age, favFood));

                // If the monkey was successfully added, clear the text fields
                if (true) {
                    nameTextField.setText("");
                    ageTextField.setText("");
                    weightTextField.setText("");
                    sizeTextField.setText("");
                }
            }
        });
    }
}