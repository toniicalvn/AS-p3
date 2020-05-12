package junit.interval;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class IntervalTest {



	@Test
	void test() {
		fail("Not yet implemented");
	}


	@Test (expected = HoraInicialMesGranException.class)
	void testHoraIniciMesGranHoraFinal() {
		inter = new Interval(20, 3);

	}

}
