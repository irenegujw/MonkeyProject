import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class TestCalcController {

    @Test
    public void testGo(){
        CalculatorModel model = new MockCalcModelImpl();
        String input ="4 56";
        String expectedOut = "60" +System.lineSeparator();

        // inputScream that read from a string
        InputStream in = new ByteArrayInputStream(input.getBytes());
        // printScream that prints to a string
        ByteArrayOutputStream outScream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outScream);

        CalcController controller = new CalcController(model,in,out);
        controller.go();

        String numberPassed = ((MockCalcModelImpl)model).getLog();
        assertEquals(input,numberPassed);
//        String actualOut =  outScream.toString();
//        assertEquals(actualOut,expectedOut);

        String expectedOutput = "-12345"+System.lineSeparator();
        String actualOutput =  outScream.toString();
        assertEquals(actualOutput,expectedOutput);

    }
}
