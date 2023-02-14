package dev.stephenpearson.model;
import java.awt.Rectangle;

public class CollisionArray {
	private int ySize = 400;
	private int xSize = 300;
	private RectangleBox[][] collisionArray = new RectangleBox[ySize+1][xSize];
	private int grainSize = 2;
	
	
	
	public CollisionArray() {
		for(int y = 0; y < ySize; y++) {
			for(int x = 0; x < xSize; x++) {
				collisionArray[y][x] = new RectangleBox(x*grainSize,y*grainSize,grainSize,grainSize);
			}
		}
		
		//init hidden bottom row collision
		for(int x = 0; x < xSize; x++) {
			collisionArray[ySize][x] = new RectangleBox(x*grainSize, ySize*grainSize,grainSize,grainSize);
			collisionArray[ySize][x].setContainsGrain(true);
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
		
		if(x+1 <= xSize-1) {
			if(collisionArray[y+1][x+1].containsGrain()) {
				return false;
			} else {
				return true;
			}
		} else {
			
			if(collisionArray[y+1][xSize-1].containsGrain()) {
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
