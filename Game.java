import java.util.ArrayList;

public class Game {
	private ArrayList<Frame> gameFrames;
	private ArrayList<Frame> bonusFrames;
	
	public Game(){
		gameFrames = new ArrayList<>();
		bonusFrames = new ArrayList<>();
	}
	public void addFrame(int firstValue, int secondValue){
		Frame frame = new Frame(firstValue, secondValue);
		gameFrames.add(frame);
	}
	public void addBonusFrame(int bonusValue){
		Frame frame = new Frame(bonusValue,0);
		bonusFrames.add(frame);
	}
	public int getNrOfFrames(){
		return gameFrames.size();
	}
	public int computeGameScore(){
		int gameScore = 0;
		for(int i = 0; i < gameFrames.size();i++){
			// Check if it is a strike
			if(gameFrames.get(i).isStrike()){
				// Check if there is more strikes
				if(gameFrames.get(i+1).isStrike()){
					gameScore += gameFrames.get(i).computeScore() + gameFrames.get(i+1).computeScore() + gameFrames.get(i+2).getFirstTurn();
				}
				else{
					gameScore += gameFrames.get(i).computeScore() + gameFrames.get(i+1).computeScore();
				}
			}
			// Check if it is a spare
			else if(gameFrames.get(i).computeScore()==10){
				// Check if it is the last frame
				if(i==gameFrames.size()-1){
					gameScore += gameFrames.get(i).computeScore() + bonusFrames.get(0).getFirstTurn();
				}
				else{
				gameScore += gameFrames.get(i).computeScore() + gameFrames.get(i+1).getFirstTurn();
				}
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
