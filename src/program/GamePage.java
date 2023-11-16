package Program;
import java.awt.*;
import javax.swing.*;
import Maze.MazeTesting;
import java.awt.event.*;

public class GamePage extends JPanel implements ItemListener,ActionListener{
	
	//game property : game name,level,start button,graphics
	JLabel lb_GameName = new JLabel("Flower Maze");
	JRadioButton rb_1 = new JRadioButton("EASY");
	JRadioButton rb_2 = new JRadioButton("HARD");
	JLabel lb_level = new JLabel("SELECT LEVEL (ball size) ");
	JLabel lb_error = new JLabel("PLEASE SELECT MODE!!");
	JButton bt_start = new JButton("START");
	JPanel panel1 =new JPanel();
	JPanel panel2 =new JPanel();
	JPanel panel3 =new JPanel();
	GamePageGraphics panel4 = new GamePageGraphics();
	public static String level;
	
GamePage(){
	//set panel background color
	panel1.setBackground(new Color(135,206,250));
	panel2.setBackground(new Color(135,206,250));
	panel3.setBackground(new Color(135,206,250));
	panel4.setBackground(new Color(135,206,250));
	
	//set panel1 to BorderLayout and adding Game Name 
	panel1.setLayout(new FlowLayout());
	panel1.add(lb_GameName);

	//set panel2 to FlowLayout and adding Game level 
	panel2.setLayout(new FlowLayout());
	panel2.add(lb_level);
	panel2.add(rb_1);
	panel2.add(rb_2);

	//set panel3 to BorderLayout and adding Start button
	panel3.add(bt_start,BorderLayout.NORTH);
	
	//add every panels to the GridLayout of this GamePage Panel
	setLayout(new GridLayout(4,1));
	add(panel1);
	add(panel2);
	add(panel3);
	add(panel4);
	
	//add Listener to sources fire event
	rb_1.addItemListener(this);
	rb_2.addItemListener(this);
	rb_1.addActionListener(this);
	rb_2.addActionListener(this);
	bt_start.addActionListener(this);
	//set rb_1 is selected 
	rb_1.setSelected(true);
}

//use paintComponent to repaint graphics in panel4
protected void paintComponent(Graphics g) {
	panel4.repaint();
}

@Override
//use itemStateChanged to make player can selected only one game level
public void itemStateChanged(ItemEvent e) {
	if(e.getSource()==rb_1 && e.getStateChange()==1) {
		rb_1.setSelected(true);
		rb_2.setSelected(false);
		level = "EASY";
	}
	else if(e.getSource()==rb_2 && e.getStateChange()==1) {
		rb_1.setSelected(false);
		rb_2.setSelected(true);
		level = "HARD";

}
}
@Override
//use actionPerformed to created MazeTesting frame if player selected game level and created error frame if player does not selected game level
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==bt_start) {
		if (rb_1.isSelected()||rb_2.isSelected()) {
			new MazeTesting();
			}
		else {
			JFrame frame = new JFrame("ERROR"); //create JFrame
			frame.setLayout(new FlowLayout());
			frame.add(lb_error); //add label error the object into the frame
			frame.setSize(350,50); //set a frame's resolution
			frame.setLocationRelativeTo(null); //set a location at center the frame
			frame.setVisible(true); //set visible
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	}
	}
	
}





