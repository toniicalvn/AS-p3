package junit.com;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLinearRate  {

    RateStrategy rs;

    @Before
    public void setUp() {
        rs = new LinearRateStrategy();

    }

    @Test
    public void testDisplay1Hour() throws IllegalCoinException {
        assertEquals( "Should display 60 min for 150 cents",
                (6 * 25) / 5 * 2, rs.calculaTime(150));
    }

    @Test
    public void testDisplay2Hour() throws IllegalCoinException {
        assertEquals( "Should display 120 min for 3 dollars",
                120, rs.calculaTime(300) );
    }

    @Test
    public void testDisplay3Hour() throws IllegalCoinException {
        assertEquals( "Should display 180 min for 4.5 dollars",
                180, rs.calculaTime(450));
    }

}
