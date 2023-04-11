import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CalcController {
    CalculatorModel model;
    InputStream inp;
    PrintStream out;

    public CalcController(CalculatorModel model, InputStream inp, PrintStream out) {
        this.model = model;
        this.inp = inp;
        this.out = out;
    }


    public void go(){
        Scanner sc = new Scanner(inp);
        int num1 = sc.nextInt();//+1;
        int num2 = sc.nextInt();//-1;
        out.println(model.add(num1,num2));
    }


}
