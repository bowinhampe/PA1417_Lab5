import java.util.ArrayList;

public class Game {
	private ArrayList<Frame> gameFrames;
	
	public Game(){
		gameFrames = new ArrayList<>();
	}
	public void addFrame(int firstValue, int secondValue){
		Frame frame = new Frame(firstValue, secondValue);
		gameFrames.add(frame);
	}
	public int getNrOfFrames(){
		return gameFrames.size();
	}
}
