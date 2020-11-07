package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Moveable,Comparable{
	private String color = "crna";
	private boolean selected;
	private Color colorEdges = Color.BLACK;
	
	
	public Shape(){
		
	}
	public Shape(String color){
		this.color = color;
	}
	
	public abstract void draw(Graphics g);
	public abstract void selected(Graphics g);
	public abstract boolean contains(int x, int y);
	
	public static Color findColor(String color){
		if(color.equalsIgnoreCase("crna"))
			return Color.BLACK;
		else if(color.equalsIgnoreCase("bela"))
			return Color.WHITE;
		else if(color.equalsIgnoreCase("plava"))
			return Color.BLUE;
		else if(color.equalsIgnoreCase("crvena"))
			return Color.RED;
		else if(color.equalsIgnoreCase("zelena"))
			return Color.GREEN;
		else if(color.equalsIgnoreCase("zuta"))
			return Color.YELLOW;
		else if(color.equalsIgnoreCase("pink"))
			return Color.PINK;
		else
			return Color.BLACK;
		
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setColorEdges(Color color)
	{
		this.colorEdges = color;
	}
	public Color getColorEdges()
	{
		return this.colorEdges;
	}
	
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
}