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
	private int grainSize = 2;
	
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
		grainController.renderGrains(g);
		
		
	}
	
	public void paintGrid(Graphics g) {
		g.setColor(new Color(26,26,26));
		g.fillRect(0, 0, d.width, d.height);
		
		
		
//		g.setColor(new Color(204,207,171));
//		//draw horizontal grid lines
//		for(int i = 0; i < d.height/grainSize; i++) {
//			g.drawLine(0, i * grainSize, d.width, i * grainSize);
//		}
//		
//		//draw vertical grid lines
//		for(int i = 0; i < d.width/grainSize; i++) {
//			g.drawLine(i*grainSize, 0, i*grainSize, d.height);
//		}
//		
		


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
