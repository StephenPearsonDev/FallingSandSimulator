package dev.stephenpearson.model;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Random;

public class Grain {
	
	private int grainSize = 2;
	private Rectangle grainBounds;
	private Dimension grainDimension = new Dimension(grainSize,grainSize);
	private boolean locked = false;
	private int x;
	private int y;
	private int id;
	private Color grainColor;
	private Color[] grainColorArray = new Color[] {
			new Color(246,215,176),
			new Color(242,210,169),
			new Color(236,204,162),
			new Color(231,196,150),
			new Color(225,191,146),		
	};
	
	private Random rand;
	
	
	
	public Grain(int id, int x) {
		this.id = id;
		x = ((x + (grainSize/2)) / grainSize) * grainSize;
		grainBounds = new Rectangle(x,0,grainSize,grainSize);
		this.x = x / grainSize;
		y = 0;
		
		rand = new Random();
//		int r = rand.nextInt(0,255);
//		int g = rand.nextInt(0,255);
//		int b = rand.nextInt(0,255);
//		grainColor = new Color(r, g, b);
		
		grainColor = grainColorArray[rand.nextInt(5)];
			
	}
	
	public Rectangle getRectangle() {
		return grainBounds;
	}
	
	public Color getColor() {
		return grainColor;
	}
	
	public void moveDown() {
		if(!locked) {
			grainBounds.y += grainDimension.height;
			y += 1;
		}
	}
	
	public void moveRight() {
		if(!locked) {
			grainBounds.x += grainDimension.width;
			grainBounds.y += grainDimension.height;
			x += 1;
			y += 1;
		}
	}
	
	public void moveLeft() {
		if(!locked) {
			grainBounds.x -= grainDimension.width;
			grainBounds.y += grainDimension.height;
			x -= 1;
			y += 1;
		}
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public boolean isLocked() {
		return locked;
	}
	
	public void setLocked(boolean b) {
		locked = b;
	}
	
	
	
	

}
