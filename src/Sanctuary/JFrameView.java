package Sanctuary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameView {
    private SanctuaryModel model;
    private JFrame frame;
    private JPanel controlPanel;
    private JPanel isolationPanel;
    private JPanel enclosurePanel;
    private JLabel label;
    private JTextField nameTextField;
    private JComboBox speciesComboBox;
    private JComboBox sexComboBox;
    private JTextField sizeTextField;
    private JTextField ageTextField;
    private JTextField weightTextField;
    private JComboBox favFoodComboBox;

    private JList isolationList;
    private JLabel monkeyTextArea;


    public JFrameView(SanctuaryModel model){
        this.model = model;
        initialize();
    }

    public void initialize(){

        frame = new JFrame();
        // basic setting of frame
        frame.setTitle("Sanctuary");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000,800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setLayout(new BorderLayout());

        monkeyTextArea = new JLabel("");


        controlPanel = createControlPanel();
        isolationPanel = createIsolationPanel();

        controlPanel.add(monkeyTextArea);
        frame.add(controlPanel,BorderLayout.NORTH);
        frame.add(isolationPanel,BorderLayout.WEST);

        frame.setVisible(true);
    }

    private JPanel createControlPanel(){
        JPanel controlPanel =  new JPanel();

        controlPanel.setPreferredSize(new Dimension(1000,200));
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,5)); // alignment of buttons
        controlPanel.setBackground(Color.PINK);
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));


        JButton addMonkeyButton = createAddMonkeyButton();
//        JButton moveMonkeyButton = new JButton("Move monkey");
//        controlPanel.add(moveMonkeyButton);


        nameTextField = new JTextField(10);
        speciesComboBox = new JComboBox(Species.values());
        sexComboBox = new JComboBox(Sex.values());
        sizeTextField = new JTextField(3);
        ageTextField = new JTextField(3);
        weightTextField = new JTextField(3);
        favFoodComboBox = new JComboBox(Food.values());

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

        return controlPanel;
    }


    /**
     * create the button to receive monkey after input all the info
     * @return the button
     */
    private JButton createAddMonkeyButton(){
        JButton addMonkeyButton = new JButton("Receive monkey");
        addMonkeyButton.setFocusable(true);
        addMonkeyButton.setToolTipText("create profile for this monkey and receive it into Isolation");
        addMonkeyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                Species species = (Species) speciesComboBox.getSelectedItem();
                Sex sex = (Sex) sexComboBox.getSelectedItem();
                int age =Integer.parseInt(ageTextField.getText());
                double size = Double.parseDouble(sizeTextField.getText());
                double weight = Double.parseDouble(weightTextField.getText());
                Food favFood = (Food) favFoodComboBox.getSelectedItem();

                Monkey newMky = new Monkey(name, species, sex, size, weight, age, favFood);
                if(newMky.isInIsolation(model)){
                    JOptionPane.showMessageDialog(null,"Duplicate info","Error",JOptionPane.PLAIN_MESSAGE);
                    return;
                }
                model.receiveMonkey(newMky);
                System.out.println(model.nameListOfAllMonkeys());
                updateMonkeyList();
//                isolationList=new JList(model.listOfMonkeyInIsolation().toArray());
//                isolationPanel.add(isolationList);

//                nameTextField.setText("");
//                ageTextField.setText("");
//                weightTextField.setText("");
//                sizeTextField.setText("");
            }
        });
        return addMonkeyButton;
    }

    private void updateMonkeyList() {
        String monkeyList = model.nameListOfAllMonkeys();
        monkeyTextArea.setText(monkeyList);
        isolationList=new JList(model.listOfMonkeyInIsolation().toArray());
    }

    private JPanel createIsolationPanel(){

        JPanel isolationPanel = new JPanel();

        isolationPanel.setPreferredSize(new Dimension(1000,200));
        isolationPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,5)); // alignment of buttons
        isolationPanel.setBackground(Color.gray);
        isolationPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        isolationPanel.add(new JLabel("Isolation"));
        isolationList = new JList(model.listOfMonkeyInIsolation().toArray());
        isolationPanel.add(isolationList);

        isolationList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Monkey) {
                    Monkey monkey = (Monkey) value;
                    value = monkey.getName(); // or however you want to render the monkey object as a string
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });

        JScrollPane isolationScrollPane = new JScrollPane(isolationList );
        isolationPanel.add(isolationScrollPane);

//        model.addActionListener(new IsolationListChangeListener() {
//            @Override
//            public void isolationListChanged() {
//                isolationList.setModel(model.getIsolationListModel());
//            }
//        });

        return isolationPanel;
    }



}
