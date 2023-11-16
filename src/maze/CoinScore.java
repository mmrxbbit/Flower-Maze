package Maze;

//superclass
public class CoinScore {
protected int coin;
protected int score;
	CoinScore(){
		this.coin = Maze.coin;
	}
	//calculated game coins score
	double calculateCoinScore() {
			return coin*100;
				
		}
		
	}


