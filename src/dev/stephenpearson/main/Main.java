package dev.stephenpearson.main;
import javax.swing.SwingUtilities;

public class Main {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(Falling::new);
	}

}
