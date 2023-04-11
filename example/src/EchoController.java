import javax.swing.*;

public class EchoController implements EchoControllerInterface{

    JFrameView view;
    CalculatorModel model;

    public EchoController(JFrameView view,CalculatorModel model){
        this.view = view;
        this.model = model;
        view.addFeatures(this);
    }

    public void echoOutput(String text){
        this.view.clearInputString();
        this.view.setEchoOutput(text + this.model.add(3, 4));
        this.view.resetFocus();

    }

    public void exitProgram(){
        System.exit(0);
    }
}
