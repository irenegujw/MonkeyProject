import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //scanner --> copy to CalcController.go(?
//        Scanner sc = new Scanner(System.in);
//        int num1 = sc.nextInt();
//        int num2 = sc.nextInt();
//        System.out.println(num1+num2);


//        CalculatorModel model = new CalculatorModelImpl();
//        // Sys-out is a field of type PrintStream
//        // Sys-in is a field of type InputStream
//        CalcController controller = new CalcController(model,System.in,System.out);
//        controller.go();

        JFrameView view = new JFrameView("Echo a string");
        EchoControllerInterface controller = (EchoControllerInterface) new EchoController(view,new CalculatorModelImpl());

    }
}