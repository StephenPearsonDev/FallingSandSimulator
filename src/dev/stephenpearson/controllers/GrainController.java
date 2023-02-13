package dev.stephenpearson.controllers;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Timer;

import dev.stephenpearson.model.CollisionArray;
import dev.stephenpearson.model.Grain;
import dev.stephenpearson.view.WindowPanel;

public class GrainController implements ActionListener {
	
	private static List<Grain> grainList = new ArrayList<>();
	private boolean simulatorRunning = false;
	private Timer timer;
	private WindowPanel windowPanel;
	private int grainCounter = 0;
	private CollisionArray collisionArray;
	private Point mousePoint;
	private MouseMotionListener mouseMotionListener;
	private Rectangle screenRect;
	
	public GrainController() {
		screenRect = new Rectangle(0,0,600,800);
		collisionArray = new CollisionArray();
		timer= new Timer(1, this);
		initSimulator();
	
	}
	
	public void passMouseMotionListener(MouseMotionListener mouseMotionListener) {
		this.mouseMotionListener = mouseMotionListener;
	}
	
	public void initSimulator() {
		if(!simulatorRunning) {
			simulatorRunning = true;
			timer.start();
			
		}
	}
	
	public void takeWindowPanel(WindowPanel windowPanel) {
	this.windowPanel = windowPanel;	
	}
	
	public void updateMousePoint(Point p) {
	
		if(screenRect.contains(p)) {
			if(p.x > 0 && p.x < 590) {
				mousePoint = p;
			}
		} else {
			p.x = 300;
		}
		
	}
	
	public void runSimulator() {
		
	}
	
	public void dropGrain() {
		for(Grain gr : grainList) {
			if(!gr.isLocked()) {
				if(collisionArray.blockBelowIsEmpty(gr.getY(),gr.getX())) {
					gr.moveDown();
				} else if(collisionArray.blockToRightBelowIsEmpty(gr.getY(), gr.getX()) || collisionArray.blockToLeftBelowIsEmpty(gr.getY(), gr.getX())) {
					Random r = new Random();
					int i = r.nextInt(2);
					
					switch(i) {
					case 0: {
						if(collisionArray.blockToRightBelowIsEmpty(gr.getY(), gr.getX())) {
							gr.moveRight();
						} else if(collisionArray.blockToLeftBelowIsEmpty(gr.getY(), gr.getX())) {
							gr.moveLeft();
						} else {
							gr.setLocked(true);
							collisionArray.setRectangle(gr);
						}
					}
					case 1: {
						if(collisionArray.blockToLeftBelowIsEmpty(gr.getY(), gr.getX())) {
							gr.moveLeft();
						} else if(collisionArray.blockToRightBelowIsEmpty(gr.getY(), gr.getX())) {
							gr.moveRight();
						} else {
							gr.setLocked(true);
							collisionArray.setRectangle(gr);
						}
					}
				}
			}else {
				gr.setLocked(true);
				collisionArray.setRectangle(gr);
				}
			}
		}
	}
	
	public void makeGrain() {
		
		if(mousePoint == null) {
			grainList.add(new Grain(grainCounter++, 300));
		} else {
			if(mousePoint.x < 600 && mousePoint.x > 0) {
				grainList.add(new Grain(grainCounter++, mousePoint.x));
			} else {
				grainList.add(new Grain(grainCounter++, 300));
			}
			
		}
		
	}
	
	
	public void renderGrains(Graphics g) {
		//g.setColor(Color.ORANGE);
		for(Grain gr : grainList) {
			g.setColor(gr.getColor());
			
			g.fillRect(gr.getRectangle().x, gr.getRectangle().y, gr.getRectangle().width, gr.getRectangle().height);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(grainList.isEmpty()) {
			makeGrain();
		}else if(grainList.get(grainCounter-1).getY() >= 0) {
			
			makeGrain();
		}

		dropGrain();
	}

}
