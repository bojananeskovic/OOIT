package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {
	
	private int x;
	private int y;

	public Point(){

	}
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, String color){
		this(x, y);
		setColor(color);

	}

	public Point(int x, int y, Color color)
	{
		this(x, y);
		setColorEdges(color);
	}
	
	public void moveTo(int newX, int newY){
		x = newX;
		setY(newY);
	}
	public void moveBy(int newX, int newY){
		x = x + newX;
		setY(getY()+newY);
	}

	public double distance(Point p){
		double dx = x - p.getX();
		double dy = y - p.getY();
		double result = Math.sqrt(dx*dx + dy*dy);

		return result;
	}
	
	public String toString(){
		return "("+x+","+y+")";
	}
	public boolean equals(Object obj){
		if(obj instanceof Point){
			Point p = (Point) obj;
			if(x == p.x && y == p.y)
				return true;
			else
				return false;

		}
		else
			return false;
	}
	
	public boolean contains(int x, int y){
		Point p = new Point(x, y);
		if(p.distance(this)<=2)
			return true;
		else
			return false;
	}
	
	public void selected(Graphics g){
		g.setColor(findColor("plava"));
		g.drawRect(x-3, y-3, 6, 6);
	}
	
	public void draw(Graphics g) {
		g.setColor(getColorEdges());
		g.drawLine(x+2, y, x-2, y);
		g.drawLine(x, y-2, x, y+2);
		if(isSelected())
			selected(g);

	}

	public int compareTo(Object o) {
		if(o instanceof Point){
			Point p = (Point) o;
			return (int) this.distance(new Point(0, 0)) - (int)p.distance(new Point(0, 0));
			
		}
		else
			return 0;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int newX){
		x = newX;
	}
	public void setY(int newY){
		y = newY;
	}




}
