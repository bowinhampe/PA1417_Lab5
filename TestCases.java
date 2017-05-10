import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {

	@Test
	public void testFrame() {
		Frame frame = new Frame(1,2);
		int actual = frame.getFirstTurn();
		int expected = 1;
		assertEquals(expected, actual);
		
		actual = frame.getSecondTurn();
		expected = 2;
		assertEquals(expected, actual);
	}

}
