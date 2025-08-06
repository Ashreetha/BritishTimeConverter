import com.example.service.TimeConverterService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeConverterTest {

    private final TimeConverterService converter = new TimeConverterService();

    @Test
    public void testMidnight() {
        assertEquals("midnight", converter.convert("00:00"));
    }

    @Test
    public void testNoon() {
        assertEquals("noon", converter.convert("12:00"));
    }

    @Test
    public void testExactHour() {
        assertEquals("one o'clock", converter.convert("1:00"));
    }

    @Test
    public void testQuarterPast() {
        assertEquals("quarter past four", converter.convert("4:15"));
    }

    @Test
    public void testHalfPast() {
        assertEquals("half past seven", converter.convert("7:30"));
    }

    @Test
    public void testTwentyTo() {
        assertEquals("twenty to nine", converter.convert("8:40"));
    }

    @Test
    public void testQuarterTo() {
        assertEquals("quarter to ten", converter.convert("9:45"));
    }

    @Test
    public void testTwentyFivePast() {
        assertEquals("twenty-five past six", converter.convert("6:25"));
    }

    @Test
    public void testFiveTo() {
        assertEquals("five to twelve", converter.convert("11:55"));
    }

    @Test
    public void testSingleDigitMinute() {
        assertEquals("five past two", converter.convert("2:05"));
    }
}

