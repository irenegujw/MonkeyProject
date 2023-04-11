import javax.swing.*;
import java.awt.*;

public class JFrameView extends JFrame implements View {


    private JLabel display; // display some text
    private JTextField input; // take user input as text
    private JButton echoButton, exitButton; // button


    public JFrameView(String title) {
        super(title);
        setSize(500,300);
        setLocation(200,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        this.display = new JLabel("to be display");
        this.add(display);

        this.input = new JTextField(10);
        this.add(input);

        this.echoButton = new JButton("Echo");
        this.echoButton.setActionCommand("Echo Button");
        this.add(echoButton);

        this.exitButton = new JButton("Exit");
        this.exitButton.setActionCommand("Exit Button");
        this.add(exitButton);

        this.pack();
        this.setVisible(true);
    }

    public void addFeatures(EchoController features){
        this.echoButton.addActionListener(evt->features.echoOutput(input.getText()));
        this.exitButton.addActionListener(evt->features.exitProgram());
    }


    public void clearInputString() {
        this.input.setText("");
    }

    public void setEchoOutput(String text) {
        this.display.setText(text);
    }

    public void resetFocus() {
        this.setFocusable(true);
        this.requestFocus();
    }




}
