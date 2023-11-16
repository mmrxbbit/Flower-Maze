package Maze;
import java.awt.*;
import javax.swing.*;

import Program.GamePage;

//static method
public class ResultPanel extends JPanel {
		AllScore All = new AllScore();
		CoinScore Coin = All; //implicit casting
		
		//Calculate : all score,hit score and coin score
		int all_Score = (int) (All.calculateAllScore()); //explicit casting
		int hit_Score = (int) (All.calculateHitScore()); //explicit casting
		int coin_Score = (int) (Coin.calculateCoinScore()); //explicit casting
		
		JLabel lb_topic = new JLabel("SCORE : "+all_Score+" points");
		JLabel lb_level = new JLabel("LEVEL : "+GamePage.level);
		JLabel lb_times = new JLabel("NUMBER OF GAMES : "+Maze.game+" games");
		JLabel lb_hit = new JLabel("HIT ("+Maze.hit+" hits) : "+hit_Score+" points (every hit equals minus one point)");
		JLabel lb_coin = new JLabel("COIN ("+Maze.coin+" coins) : "+coin_Score+" points (collecting one coin equals one hundred points)");
		JLabel lb_thank = new JLabel("THANKS FOR PLAYING!");
		JPanel panel1 =new JPanel();
		JPanel panel2 =new JPanel();
		JPanel panel3 =new JPanel();
		JPanel panel4 =new JPanel();
		JPanel panel5 =new JPanel();
		JPanel panel6 =new JPanel();
		ResultGraphics panel7 = new ResultGraphics();
				
	ResultPanel(){
		//set panel background color
		panel1.setBackground(new Color(135,206,250));
		panel2.setBackground(new Color(135,206,250));
		panel3.setBackground(new Color(135,206,250));
		panel4.setBackground(new Color(135,206,250));
		panel5.setBackground(new Color(135,206,250));
		panel6.setBackground(new Color(135,206,250));
		panel7.setBackground(new Color(135,206,250));
		
		//add every panels to the GridLayout of this ResultPanel Panel
		setLayout(new GridLayout(7,1));
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		add(panel6);
		add(panel7);
		
		//add label into panel
		panel1.add(lb_topic);
		panel2.add(lb_level);
		panel3.add(lb_times);
		panel4.add(lb_hit);
		panel5.add(lb_coin);
		panel6.add(lb_thank);
		
	
	}
	protected void paintComponent(Graphics g) {
		panel7.repaint();
	}
}
