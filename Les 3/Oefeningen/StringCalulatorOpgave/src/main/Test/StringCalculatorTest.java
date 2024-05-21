import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    public void testEmptyString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.calculate(""));
    }

    @Test
    public void testSingleNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.calculate("1"));
        assertEquals(2, calculator.calculate("2"));
    }

    @Test
    public void testTwoNumbersCommaSeparated() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.calculate("1,2"));
        assertEquals(30, calculator.calculate("10,20"));
    }

    @Test
    public void testTwoNumbersNewlineSeparated() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.calculate("1\n2"));
    }

    @Test
    public void testMultipleNumbersCommaAndNewlineSeparated() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(10, calculator.calculate("1\n2,3\n4"));
    }

    @Test()
    public void testNegativeNumbers() {
        StringCalculator calculator = new StringCalculator();
        calculator.calculate("-1,2,-3");
    }

    @Test
    public void testNumbersGreaterThan1000() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(2, calculator.calculate("1001,2")); // 1001 is ignored
        assertEquals(1002, calculator.calculate("1000,1002")); // 1002 is not ignored
    }

}