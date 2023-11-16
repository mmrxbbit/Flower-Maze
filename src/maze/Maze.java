package Maze;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class Maze extends JPanel implements ActionListener , ItemListener,MouseMotionListener,MouseListener{
	
	//JChexBox to selected if player want to change ball color
	JCheckBox cb_change = new JCheckBox("Change Ball Color");
	
	//timer flower property
	int startAngle = 0;
	int arcLength = 30;
	int shift = 5;
	int d_flower = 25;
	Timer timer = new Timer(50, this); 
	
	//ball property
	int x_ball = 19;
	int y_ball = 232;
	int d_ball;
	private boolean getball = false;
	Color Color_ball = Color.PINK;
	
	//hit property
	static int hit=0;
	
	//coin property
	Color Color_coin1 = Color.YELLOW;
	Color Color_coin2 = Color.YELLOW;
	Color Color_coin3 = Color.YELLOW;
	Color Color_coin4 = Color.YELLOW;
	Color Color_coin5 = Color.YELLOW;
	static int coin=0;
	boolean bl_coin1 = true;
	boolean bl_coin2 = true;
	boolean bl_coin3 = true;
	boolean bl_coin4 = true;
	boolean bl_coin5 = true;
	
	//number of game property
	static int game =0;
	
	//property to check if game finish
	private boolean reset = false;
	
	Maze() {
		//use level from Program.GamePage to set ball Diameter (EASY=22,HARD=24)
		if(Program.GamePage.level=="EASY") {
			d_ball = 22;
		}
		else{
			d_ball = 24;	
		}
		//set Maze panel to FlowLayout and adding cb_change
		setLayout(new FlowLayout());
		add(cb_change);
		
		timer.start();
		
		//add Listener to sources fire event
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		cb_change.addItemListener(this);
		}
	
	protected void paintComponent(Graphics g) {
		
		//created Maze's background (
		g.setColor(new Color(100,150,100));
		g.fillRect(0, 0, 600, 500);
		
		//created Maze's grass wall area 
		g.setColor(new Color(135,206,250));
		g.fillRect(0, 0,75,500);
		g.fillRect(525,0,75,500);
		int [] xaxis = {75,225,225,375,375,525,525,405,405,195,195,75,75};
	    int [] yaxis = {50,50,200,200,50,50,80,80,230,230,80,80,50};
	    g.fillPolygon(xaxis, yaxis, 13);
	    g.fillRect(75,350,450,30);
	    
	    //created finish line
	    g.setColor(Color.WHITE);
	    g.fillRect(540, 0, 2, 500);
	    
	    //created "start" at starting point
	    g.setColor(Color.GRAY);
	    g.drawString("start",23, 274);
	    
	    //created flag 
	    g.fillRect(550,225,3,50);
	    g.setColor(Color.RED);
	    int [] xflag = {553,578,553};
	    int [] yflag = {225,235,250};
	    g.fillPolygon(xflag, yflag, 3);
	    
	    //created flower
		for (int i = 0;i<360;i=i+60) {
			//Create flower petals
			g.setColor(Color.PINK);
			g.fillArc(320,60,d_flower,d_flower,startAngle+i,arcLength);
			//Create flower pollen
			g.setColor(Color.WHITE);
			g.fillOval(320+(d_flower/2)-5,60+(d_flower/2)-5,10,10);
		}
		for (int i = 0;i<360;i=i+60) {
			//Create flower petals
			g.setColor(Color.PINK);
			g.fillArc(280,150,d_flower,d_flower,startAngle+i,arcLength);
			//Create flower pollen
			g.setColor(Color.WHITE);
			g.fillOval(280+(d_flower/2)-5,150+(d_flower/2)-5,10,10);
		}
		for (int i = 0;i<360;i=i+60) {
			//Create flower petals
			g.setColor(Color.PINK);
			g.fillArc(150,275,d_flower,d_flower,startAngle+i,arcLength);
			//Create flower pollen
			g.setColor(Color.WHITE);
			g.fillOval(150+(d_flower/2)-5,275+(d_flower/2)-5,10,10);
		}
		for (int i = 0;i<360;i=i+60) {
			//Create flower petals
			g.setColor(Color.PINK);
			g.fillArc(310,290,d_flower,d_flower,startAngle+i,arcLength);
			//Create flower pollen
			g.setColor(Color.WHITE);
			g.fillOval(310+(d_flower/2)-5,290+(d_flower/2)-5,10,10);
		}
		for (int i = 0;i<360;i=i+60) {
			//Create flower petals
			g.setColor(Color.PINK);
			g.fillArc(440,130,d_flower,d_flower,startAngle+i,arcLength);
			//Create flower pollen
			g.setColor(Color.WHITE);
			g.fillOval(440+(d_flower/2)-5,130+(d_flower/2)-5,10,10);
		}
		for (int i = 0;i<360;i=i+60) {
			//Create flower petals
			g.setColor(Color.PINK);
			g.fillArc(175,400,d_flower,d_flower,startAngle+i,arcLength);
			//Create flower pollen
			g.setColor(Color.WHITE);
			g.fillOval(175+(d_flower/2)-5,400+(d_flower/2)-5,10,10);
		}
		for (int i = 0;i<360;i=i+60) {
			//Create flower petals
			g.setColor(Color.PINK);
			g.fillArc(440,415,d_flower,d_flower,startAngle+i,arcLength);
			//Create flower pollen
			g.setColor(Color.WHITE);
			g.fillOval(440+(d_flower/2)-5,415+(d_flower/2)-5,10,10);
		}
		
		//created coins
		g.setColor(Color_coin1);
		g.fillOval(200,55,20,20);
		g.setColor(Color_coin2);
		g.fillOval(200,205,20,20);
		g.setColor(Color_coin3);
		g.fillOval(380,205,20,20);
		g.setColor(Color_coin4);
		g.fillOval(380,55,20,20);
		g.setColor(Color_coin5);
		g.fillOval(290,355,20,20);
	
		//created ball (controller)
		g.setColor(Color_ball);
		g.fillOval(x_ball,y_ball,d_ball,d_ball);
	    }
	
	@Override
	//Change startAngle to make flower petals move
	public void actionPerformed(ActionEvent e) {
		repaint();
		startAngle = startAngle + shift;
	}
	
	@Override
	//use itemStateChanged to change ball color (white or pink) when click cb_change
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==cb_change) {
			if(cb_change.isSelected()) {
				Color_ball=Color.WHITE;
				repaint();
			}
			else {
				Color_ball=Color.PINK;
				repaint();
			}
		}
	}
	
	@Override
	//use mouseClicked to check if we click on ball surface area then getball is true
	public void mouseClicked(MouseEvent e) {
		if(Math.sqrt(Math.pow(e.getX()-x_ball,2)+Math.pow(e.getY()-y_ball,2))>(d_ball/2)) {
			getball = true;
		}
		else {
			getball = false;
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	//use mouseReleased to make the ball return to starting point when we released mouse
	public void mouseReleased(MouseEvent e) {
		getball = false;
		x_ball = 19;
		y_ball = 232;
		repaint();
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	//use mouseRDragged to make the ball follow mouse when player dragged it (click in ball area)
	public void mouseDragged(MouseEvent e) {
		if(getball) {
			x_ball = e.getX()-(int)(d_ball)/2;
			y_ball = e.getY()-(int)(d_ball/2);
			repaint();
			reset = true;
		}
		
		//Calculate if the ball hit wall (every time the ball hit, hit value will increased one point in every moving unit) 
		if(reset) {
		if( ((e.getY()+(int)(d_ball)/2)<500) && ((e.getY()-(int)(d_ball)/2)>0)&&((e.getX()+(int)(d_ball)/2)<75) && ((e.getX()-(int)(d_ball)/2)>0) || ((e.getY()+(int)(d_ball)/2)<500) && ((e.getY()-(int)(d_ball)/2)>0)&&((e.getX()+(int)(d_ball)/2)<600) && ((e.getX()-(int)(d_ball)/2)>525) ){
	}
		else {
			if(( ((e.getY()+(int)(d_ball)/2)<380) && ((e.getY()-(int)(d_ball)/2)>350) && ((e.getX()+(int)(d_ball)/2)<600) && ((e.getX()-(int)(d_ball)/2)>0) ) ) {
			}
			else {
				if(((e.getY()+(int)(d_ball)/2)<80) && ((e.getY()-(int)(d_ball)/2)>50) && ((((e.getX()+(int)(d_ball)/2)<225) && ((e.getX()-(int)(d_ball)/2)>0) ) || (((e.getX()+(int)(d_ball)/2)<375) && ((e.getX()-(int)(d_ball)/2)>600) )) ){
				}
				else {
					if(((e.getY()+(int)(d_ball)/2)<230) && ((e.getY()-(int)(d_ball)/2)>50) && ((((e.getX()+(int)(d_ball)/2)<225) && ((e.getX()-(int)(d_ball)/2)>195) ) || (((e.getX()+(int)(d_ball)/2)<405) && ((e.getX()-(int)(d_ball)/2)>375) ))  ) {
					}
					else {
						if(((e.getY()+(int)(d_ball)/2)<230) && ((e.getY()-(int)(d_ball)/2)>200) && ((e.getX()+(int)(d_ball)/2)<405) && ((e.getX()-(int)(d_ball)/2)>195) ) {
						}
						else {
							hit = hit+1;
							//System.out.println(hit); //used this when you want to check how hit value increased
						}
					}
				}
			}
		}
		}
		//use this condition to make coin disappear and count number of coins when player dragged the ball to hit coins 
		//ball hit coins when e.getX() and e.getY() is in the area of coin
		//when the ball hit coin : color of coin will changed to background color and it will disappear
		//set boolean to false to prevent over counting coins
		if (bl_coin1) {
			if(e.getX()>200 && e.getX()<220 && e.getY()>55 && e.getY()<75) {
				Color_coin1 = new Color(135,206,250);
				repaint();
				coin=coin+1;
				bl_coin1 = false;
			}
		}
		if (bl_coin2) {
			if(e.getX()>200 && e.getX()<220 && e.getY()>205 && e.getY()<225) {
				Color_coin2 = new Color(135,206,250);
				repaint();
				coin=coin+1;
				bl_coin2 = false;
			}
		}
		if (bl_coin3) {
			if(e.getX()>380 && e.getX()<400 && e.getY()>205 && e.getY()<225) {
				Color_coin3 = new Color(135,206,250);
				repaint();
				coin=coin+1;
				bl_coin3 = false;
			}
		}
		if (bl_coin4) {
			if(e.getX()>380 && e.getX()<400 && e.getY()>55 && e.getY()<75) {
				Color_coin4 = new Color(135,206,250);
				repaint();
				coin=coin+1;
				bl_coin4 = false;
			}
		}
		if (bl_coin5) {
			if(e.getX()>290 && e.getX()<310 && e.getY()>355 && e.getY()<375) {
				Color_coin5 = new Color(135,206,250);
				repaint();
				coin=coin+1;
				bl_coin5 = false;
				}
			}
		
		//check if ball reach goal and start new game
		if (e.getX()>=540){
			
		//stop the ball to follow mouse dragged and changed position of the ball to starting point
		getball = false;
		x_ball = 19;
		y_ball = 232;
		
		//set color of coins to make it appear on screen
		Color_coin1 = Color.YELLOW;
		Color_coin2 = Color.YELLOW;
		Color_coin3 = Color.YELLOW;
		Color_coin4 = Color.YELLOW;
		Color_coin5 = Color.YELLOW;
		//can increased coin count again
		bl_coin1 = true;
		bl_coin2 = true;
		bl_coin3 = true;
		bl_coin4 = true;
		bl_coin5 = true;
		
		//update JLabel in MazePanel panel based on coins count,hits count and number of game
		MazePanel.lb_coin.setText("COIN : collect "+coin+" coins");
		MazePanel.lb_hittime.setText("HIT : "+hit+" hits");
		MazePanel.lb_numgame.setText("GAME "+game);	
		
		//repaint and start new game
		repaint();
		
		//use reset boolean to prevent over counting hit when the ball reach the goal
		//when ball reach goal game value will increased one 
		if(reset) {
		reset=false;
		game=game+1;
		}
		}
	
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

	
	
