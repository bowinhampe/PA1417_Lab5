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
	
	@Test
	public void testSpareAsLastFrame(){
		Game game = initiateGameObject();
		game.changeFrame(9, 2, 8);
		game.addBonusFrame(7,0);
		int actual = game.computeGameScore();
		int expected = 90;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testStrikeAsLastFrame(){
		Game game = initiateGameObject();
		game.changeFrame(9, 10, 0);
		game.addBonusFrame(7, 2);
		int actual = game.computeGameScore();
		int expected = 92;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBonusIsAStrike(){
		Game game = initiateGameObject();
		game.changeFrame(9, 2, 8);
		game.addBonusFrame(10, 0);
		int actual = game.computeGameScore();
		int expected = 93;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBestScore(){
		Game game = new Game();
		game.addFrame(10, 0);
		game.addFrame(10, 0);
		game.addFrame(10, 0);
		game.addFrame(10, 0);
		game.addFrame(10, 0);
		game.addFrame(10, 0);
		game.addFrame(10, 0);
		game.addFrame(10, 0);
		game.addFrame(10, 0);
		game.addFrame(10, 0);
		game.addBonusFrame(10, 10);
		int actual = game.computeGameScore();
		int expected = 300;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRealGame(){
		Game game = new Game();
		game.addFrame(6, 3);
		game.addFrame(7, 1);
		game.addFrame(8, 2);
		game.addFrame(7, 2);
		game.addFrame(10, 0);
		game.addFrame(6, 2);
		game.addFrame(7, 3);
		game.addFrame(10, 0);
		game.addFrame(8, 0);
		game.addFrame(7, 3);
		game.addBonusFrame(10, 0);
		int actual = game.computeGameScore();
		int expected = 135;
		assertEquals(expected, actual);
	}
	
	
	
	
	

}
