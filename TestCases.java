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
	
	@Test
	public void testFrameScore() {
		Frame frame = new Frame(1,2);
		
		int expectedValue = 3;
		assertEquals(expectedValue, frame.computeScore());

	}
	
	@Test
	public void testGame() {
		Game game = new Game();
		game.addFrame(1,5);
		game.addFrame(3,6);
		game.addFrame(7,2);
		game.addFrame(3,6);
		game.addFrame(4,4);
		game.addFrame(5,3);
		game.addFrame(3,3);
		game.addFrame(4,5);
		game.addFrame(8,1);
		game.addFrame(2,6);
		int actual = game.getNrOfFrames();
		int expected = 10;
		assertEquals(expected, actual);
	}

}
