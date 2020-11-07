package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends SurfaceShape{
	
	private Point center;
	private int radius;
	
	
	public Circle(){
		
	}
	public Circle(Point center, int radius){
		this.center = center;
		this.radius = radius;
	}
	public Circle(Point center, int radius, String color){
		this(center, radius);
		setColor(color);
	}
	
	public Circle(Point center, int radius, Color colorEdges){
		this(center, radius);
		setColorEdges(colorEdges);
		setFilled(false);
	}
	
	public Circle(Point center, int radius, Color colorEdges, Color colorInside){
		this(center, radius);
		setColorEdges(colorEdges);
		setColorInside(colorInside);
		setFilled(true);
	}
	
	public void moveTo(int x, int y){
		center.moveTo(x, y);
	}
	public void moveBy(int x, int y){
		center.moveBy(x, y);
	}
	public double area() {
		return radius*radius*Math.PI;
	}
	public double volume(){
		return 2 * radius * Math.PI;
	}
	
	public String toString(){
		return "Centar="+center+", poluprecnik="+radius;
	}
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle c = (Circle) obj;
			if (this.center.equals(c.getCenter()) && this.radius == c.getRadius()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	public boolean contains(int x, int y){
		Point p = new Point(x, y);
		if(p.distance(center)<=radius)
			return true;
		else
			return false;
		
	}
	public void selected(Graphics g) {
	
		new Line(new Point(center.getX(), center.getY()-radius), new Point(center.getX(), center.getY() + radius)).selected(g);
		new Line(new Point(center.getX()-radius, center.getY()), new Point(center.getX()+radius, center.getY())).selected(g);
	}
	public void draw(Graphics g){
		g.setColor(getColorEdges());
		g.drawOval(center.getX()-radius, center.getY()-radius, 2*radius, radius+radius);
		//popuni(g);
		if(isFilled())
			fill(g);
		if(isSelected())
			selected(g);
	}
	public void fill(Graphics g) {
		
		g.setColor(getInsideColor());
		g.fillOval(center.getX()-radius+1, center.getY()-radius+1, 2*radius-2, radius+radius-2);
		
		
	}
	public int compareTo(Object o) {
		if(o instanceof Circle){
			Circle c = (Circle) o;
			return (int) (this.radius - c.radius);
		}
		else
			return 0;
	}
	
	
	public Point getCenter() {
		return center;
	}
	public int getRadius() {
		return radius;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public void setRadius(int radius) throws Exception{
		if(radius>0) {
			this.radius = radius;
		}  else {
			throw new NumberFormatException("Radius has to be a value greater then 0!");
		}
		
	}
	
	
	
	
}