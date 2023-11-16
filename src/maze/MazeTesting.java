package Maze;
import java.awt.BorderLayout;
import javax.swing.*;

public class MazeTesting {
	public MazeTesting(){
		JFrame frame = new JFrame("FLOWER MAZE"); //create JFrame
		frame.add(new Maze(),BorderLayout.CENTER); //add Maze panel into the frame 
		frame.add(new MazePanel(),BorderLayout.SOUTH);//add MazePanel panel into the frame 
		frame.setSize(600,550); //set a frame's resolution
		frame.setLocationRelativeTo(null); //set a location at center the frame
		frame.setVisible(true); //set visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set default Close Operation
	}
}