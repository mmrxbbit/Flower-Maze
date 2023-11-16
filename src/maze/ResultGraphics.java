package Maze;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ResultGraphics extends JPanel implements ActionListener {
	//flower property
	int startAngle = 0;
	int arcLength = 30;
	int shift = 5;
	int x = 15;
	int y = 15;
	int d = 25;
	Timer timer = new Timer(50, this); 
	ResultGraphics() { 
		super();
		timer.start();
		}
	protected void paintComponent(Graphics g) {
		//Create grass
		g.setColor(new Color(100,150,100));
		for (int i = -2;i<100;i++) {
			g.fillOval(i*25,0,50,100);
		}
		g.fillRect(0,50,2000,800);
		for (int j = 0;j<3000;j=j+100) {
		for (int i = 0;i<360;i=i+60) {
			//Create flower petals
			g.setColor(Color.PINK);
			g.fillArc(x+j,y,d,d,startAngle+i,arcLength);
			//Create flower pollen
			g.setColor(Color.YELLOW);
			g.fillOval(x+j+(d/2)-5,y+(d/2)-5,10,10);
		}
		}
	}
	//Change startAngle to make flower petals move
	public void actionPerformed(ActionEvent e) {
		repaint();
		startAngle = startAngle + shift;
	}
}


