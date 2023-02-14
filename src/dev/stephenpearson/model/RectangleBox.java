package dev.stephenpearson.model;
import java.awt.Rectangle;

public class RectangleBox {

	private Rectangle rectangle;
	private Grain grain;
	private boolean containsGrain = false;


	public RectangleBox(int x, int y, int width, int height) {
		rectangle = new Rectangle(x,y,width,height);
	}


	public void addGrain(Grain g) {
		grain = g;
		containsGrain = true;
	}

	public boolean containsGrain() {
		return containsGrain;
	}

	public void setContainsGrain(boolean b) {
		containsGrain = b;
	}

}