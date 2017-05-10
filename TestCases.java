import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {
	private Game initiateGameObject(){
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
		return game;
	}
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
		Game game = initiateGameObject();
		int actual = game.getNrOfFrames();
		int expected = 10;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGameScore() {
		Game game = initiateGameObject();
		int actual = game.computeGameScore();
		int expected = 81;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testStrike(){
		Game game = initiateGameObject();
		game.changeFrame(0, 10, 0);
		int actual = game.computeGameScore();
		int expected = 94;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSpare(){
		Game game = initiateGameObject();
		game.changeFrame(0, 1, 9);
		int actual = game.computeGameScore();
		int expected = 88;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testStrikeAndSpare(){
		Game game = initiateGameObject();
		game.changeFrame(0, 10, 0);
		game.changeFrame(1, 9, 1);
		int actual = game.computeGameScore();
		int expected = 103;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMultipleStrikes(){
		Game game = initiateGameObject();
		game.changeFrame(0, 10, 0);
		game.changeFrame(1, 10, 0);
		int actual = game.computeGameScore();
		int expected = 112;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMultipleSpares(){
		Game game = initiateGameObject();
		game.changeFrame(0, 8, 2);
		game.changeFrame(1, 5, 5);
		int actual = game.computeGameScore();
		int expected = 98;
		assertEquals(expected, actual);
	}
	
	

}
