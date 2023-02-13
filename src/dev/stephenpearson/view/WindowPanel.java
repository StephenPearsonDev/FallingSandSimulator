package dev.stephenpearson.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import dev.stephenpearson.controllers.GrainController;

public class WindowPanel extends JPanel implements MouseListener, MouseMotionListener{
	
	private Dimension d = new Dimension(600,800);
	private GrainController grainController;
	
	public WindowPanel(GrainController grainController) {
		this.grainController = grainController;
		
		setPreferredSize(d);
		addMouseMotionListener(this);
	}
	
	public void render() {
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		paintGrid(g);
		
	}
	
	public void paintGrid(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, d.width, d.height);
		
		
		g.setColor(Color.WHITE);
		//draw horizontal grid lines
		for(int i = 0; i < d.height/10; i++) {
			g.drawLine(0, i * 10, d.width, i * 10);
		}
		
		//draw vertical grid lines
		for(int i = 0; i < d.width/10; i++) {
			g.drawLine(i*10, 0, i*10, d.height);
		}
		
		
		grainController.renderGrains(g);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("pressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		grainController.updateMousePoint(e.getPoint());
		
	}

}
