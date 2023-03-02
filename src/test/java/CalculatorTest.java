import calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CalculatorTest {

    @Test
    void testAddTwoNumbers_ShouldReturnCorrectSum() {
    //given   //Arange
    Calculator calculator = new Calculator();
    //when   //Act
    int result = calculator.add(2,3);
    //then   //Assert
     assertEquals(5, result);
    }

    @Test
    void testDivideTwoNumbers_ShouldReturnCorrectDivision() {
        Calculator calculator = new Calculator();
        int result = calculator.divide(8,2);
        assertEquals(4, result);
    }

    @Test
    void testDivideByZero_ShouldThrowException() {
        Calculator calculator = new Calculator();

        try {
            int result = calculator.divide(8,0);
            fail("Exception not throw");
        }
        catch(IllegalArgumentException e) {
            assertEquals("You can not divide by 0!", e.getMessage());
        }
    }
}
