import java.util.ArrayList;

public class Game {
	private ArrayList<Frame> gameFrames;
	private Frame bonusFrame;
	
	public Game(){
		gameFrames = new ArrayList<>();
		bonusFrame = null;
	}
	public void addFrame(int firstValue, int secondValue){
		Frame frame = new Frame(firstValue, secondValue);
		gameFrames.add(frame);
	}
	public void addBonusFrame(int firstBonusValue, int secondBonusValue){
		 bonusFrame = new Frame(firstBonusValue, secondBonusValue);
	}
	public int getNrOfFrames(){
		return gameFrames.size();
	}
	public int computeGameScore(){
		int gameScore = 0;
		for(int i = 0; i < gameFrames.size();i++){
			// Check if it is a strike
			if(gameFrames.get(i).isStrike()){
				// Check if the strike is the last frame
				gameScore += computeStrike(i);
			}
			
			// Check if it is a spare
			else if(gameFrames.get(i).computeScore()==10){
				gameScore += computeSpare(i);
			}
			
			else{
				gameScore += gameFrames.get(i).computeScore();
			}
		}
		return gameScore;
	}
	private int computeStrike(int pos){
		int frameScore = 0;
		// Check if last frame is available
		if(pos == gameFrames.size()-1){
			frameScore += gameFrames.get(pos).computeScore() + bonusFrame.computeScore();
		}
		else{
		// Check if there is more strikes
			if(gameFrames.get(pos+1).isStrike()){
				// Check if next frames followup is strike
				if(pos+2 > gameFrames.size()-1){
					frameScore += gameFrames.get(pos).computeScore() + gameFrames.get(pos+1).computeScore() + bonusFrame.getFirstTurn();
				}
				else{
				frameScore += gameFrames.get(pos).computeScore() + gameFrames.get(pos+1).computeScore() + gameFrames.get(pos+2).getFirstTurn();
				}
			}
			else{
				frameScore += gameFrames.get(pos).computeScore() + gameFrames.get(pos+1).computeScore();
			}
		}
		return frameScore;
	}
	
	private int computeSpare(int pos){
		int frameScore = 0;
		// Check if it is the last frame
		if(pos==gameFrames.size()-1){
			frameScore += gameFrames.get(pos).computeScore() + bonusFrame.getFirstTurn();
		}
		else{
		frameScore += gameFrames.get(pos).computeScore() + gameFrames.get(pos+1).getFirstTurn();
		}
		return frameScore;
	}
	public void changeFrame(int pos, int firstValue, int secondValue){
		gameFrames.remove(pos);
		Frame newFrame = new Frame(firstValue, secondValue);
		gameFrames.add(pos, newFrame);
	}
}
