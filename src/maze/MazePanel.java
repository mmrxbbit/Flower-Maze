package Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazePanel extends JPanel implements ActionListener{
	//MazePanel property 
	static JLabel lb_numgame = new JLabel("LET'S PLAY");
	static JLabel lb_hittime = new JLabel("try not to hit the wall!");
	static JLabel lb_coin = new JLabel("try to collect coins!");
	JPanel leftpanel = new JPanel();
	JPanel rightpanel_1 = new JPanel();
	JPanel rightpanel_2 = new JPanel();
	JButton bt_finish = new JButton("FINISH");
	
	MazePanel() {
		//add label into panel
		leftpanel.add(lb_numgame);
		rightpanel_1.add(lb_hittime);
		rightpanel_2.add(lb_coin);
		
		//add every panels and button to the GridLayout of this MazePanel Panel
		setLayout(new GridLayout(1,4));
		add(leftpanel);
		add(bt_finish);
		add(rightpanel_1);
		add(rightpanel_2);
		
		
		//add ActionListener to sources fire event
		bt_finish.addActionListener(this);
		
	}
	@Override
	//use actionPerformed to created ResultFrame frame 
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt_finish) {
			new ResultFrame();
		}
		
	}

}
