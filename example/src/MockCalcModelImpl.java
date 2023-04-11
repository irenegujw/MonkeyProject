public class MockCalcModelImpl implements CalculatorModel{

    StringBuilder log;

    public MockCalcModelImpl() {
        this.log = new StringBuilder();
    }

    @Override
    public int add(int num1, int num2) {
        log.append(num1).append(" ").append(num2);
        return -12345;
    }

    public String getLog(){
        return this.log.toString();
    }
}
