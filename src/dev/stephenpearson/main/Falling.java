package dev.stephenpearson.main;
import javax.swing.JFrame;

import dev.stephenpearson.controllers.GrainController;
import dev.stephenpearson.view.WindowPanel;

public class Falling  implements Runnable {
	
	private Thread thread;
	private static JFrame frame;
	private static WindowPanel windowPanel;
	private static GrainController grainController;
	
	public Falling() {
		
		
		frame = new JFrame();
		grainController = new GrainController();
		windowPanel = new WindowPanel(grainController);
		grainController.passMouseMotionListener(windowPanel);
		frame.add(windowPanel);
		
		grainController.takeWindowPanel(windowPanel);
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		
		thread = new Thread(this);
		thread.start();
	}
	
	public void update() {
		
	}
	
	public void render() {
		windowPanel.render();
	}

	@Override
	public void run() {
	
		for(;;) {
			update();
			render();
		}
		
	}

}
