package calculator;

public class Calculator {

    public int add(int a, int b) {
        Math.random();
        return a + b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("You can not divide by 0!");
        }
        return a / b;
    }

    @Override
    public String toString() {
        return "Calculator{}";
    }
}
