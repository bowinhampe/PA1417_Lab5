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
	public int computeGameScore(){
		int gameScore = 0;
		for(int i = 0; i < gameFrames.size();i++){
			// Check if it is a strike
			if(gameFrames.get(i).getFirstTurn()==10){
				gameScore += gameFrames.get(i).computeScore() + gameFrames.get(i+1).computeScore(); 
			}
			// Check if it is a spare
			else if(gameFrames.get(i).computeScore()==10){
				gameScore += gameFrames.get(i).computeScore() + gameFrames.get(i+1).getFirstTurn();
			}
			else{
			gameScore += gameFrames.get(i).computeScore();
			}
		}
		return gameScore;
	}
	public void changeFrame(int pos, int firstValue, int secondValue){
		gameFrames.remove(pos);
		Frame newFrame = new Frame(firstValue, secondValue);
		gameFrames.add(pos, newFrame);
	}
}
