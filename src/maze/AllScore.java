package Maze;
//subclass
public class AllScore extends CoinScore{
	int hit;
	AllScore(){
		super();
		this.hit=Maze.hit;		
	}
	
	//calculated game score
	double calculateAllScore() {
			return (coin*100)-(hit);	
	}
	
	//calculated game hit score
	double calculateHitScore() {
			return -(hit);
		}
	}
	


