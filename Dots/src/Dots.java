import javax.swing.*;
public class Dots {
	//@QuiescentRabbitt
	//DotsProject 4/19/18
	
	public static void main (String[] args) {
		
		JFrame dotsFrame = new JFrame ("Dots");
		dotsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		dotsFrame.getContentPane().add(new DotsPanel());		
		
		dotsFrame.pack();
		dotsFrame.setVisible(true);
		
		
	}
	
	
	
	
	
	
	
}


