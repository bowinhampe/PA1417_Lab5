
public class Frame {
	private int firstTurn;
	private int secondTurn;
	
	public Frame(int first, int second){
		firstTurn = first;
		secondTurn = second;
	}
	
	public int getFirstTurn(){
		return firstTurn;
	}
	public int getSecondTurn(){
		return secondTurn;
	}
	public int computeScore(){
		return firstTurn+secondTurn;
	}
	public boolean isStrike(){
		if(firstTurn == 10){
			return true;
		}
		return false;
	}
}
