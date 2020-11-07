package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class SurfaceShape extends Shape {
	
	private String colorInside = "bela";
	private Color insideColor;
	private boolean filled;
	
	public abstract void fill(Graphics g);

	public String getColorInside() {
		return colorInside;
	}

	public void setColorInside(String colorInside) {
		this.colorInside = colorInside;
	}
	public void setColorInside(Color color)
	{
		insideColor = color;
	}

	public Color getInsideColor() {
		return insideColor;
	}

	public void setInsideColor(Color insideColor) {
		this.insideColor = insideColor;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	
	
	
	

}