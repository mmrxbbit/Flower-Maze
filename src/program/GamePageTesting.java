package Program;
import javax.swing.JFrame;
	
	public class GamePageTesting {
		public static void main(String[] args) {
			JFrame frame = new JFrame("FLOWER MAZE MENU"); //create JFrame
			frame.add(new GamePage()); //add add GamePage into the frame
			frame.setSize(500,250); //set a frame's resolution
			frame.setLocationRelativeTo(null); //set a location at center the frame
			frame.setVisible(true); //set visible
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set default Close Operation
		}
	}