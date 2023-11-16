package Maze;
import javax.swing.*;

public class ResultFrame{
	public ResultFrame(){
		JFrame frame = new JFrame("SCORE RESULT"); //create JFrame
		frame.add(new ResultPanel()); //add ResultPanel panel into the frame
		frame.setSize(500,350); //set a frame's resolution
		frame.setLocationRelativeTo(null); //set a location at center the frame
		frame.setVisible(true); //set visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set default Close Operation
		}
}
