package dev.stephenpearson.model;
import java.awt.Rectangle;

public class CollisionArray {
	
	private RectangleBox[][] collisionArray = new RectangleBox[81][60];
	
	
	public CollisionArray() {
		for(int y = 0; y < 80; y++) {
			for(int x = 0; x < 60; x++) {
				collisionArray[y][x] = new RectangleBox(x*10,y*10,10,10);
			}
		}
		
		//init hidden bottom row collision
		for(int x = 0; x < 60; x++) {
			collisionArray[80][x] = new RectangleBox(x*10, 80*10,10,10);
			collisionArray[80][x].setContainsGrain(true);
		}
	}
	
	public void setRectangle(Grain gr) {
		
		collisionArray[gr.getY()][gr.getX()].addGrain(gr);
	}
	
	public boolean blockBelowIsEmpty(int y, int x) {
		if(collisionArray[y+1][x].containsGrain()) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean blockToRightBelowIsEmpty(int y, int x) {
		
		if(x+1 < 59) {
			if(collisionArray[y+1][x+1].containsGrain()) {
				return false;
			} else {
				return true;
			}
		} else {
			
			if(collisionArray[y+1][59].containsGrain()) {
				return false;
			} else {
				return true;
			}
			
		}
		
	}
	
	public boolean blockToLeftBelowIsEmpty(int y, int x) {
		
		if(x-1 > 0) {
			if(collisionArray[y+1][x-1].containsGrain()) {
				return false;
			} else {
				return true;
			}
		} else {
			if(collisionArray[y+1][0].containsGrain()) {
				return false;
			} else {
				return true;
			}
		}
		
	}

}
