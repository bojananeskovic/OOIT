package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	
	private int innerRadius;
	
	public Donut() {
		
	}
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, String color) {
		this(center, radius, innerRadius);
		setColor(color);
	}
	
	public Donut(Point center, int radius, int innerRadius, Color colorEdges) {
		this(center, radius, innerRadius);
		setColorEdges(colorEdges);
		setFilled(false);
	}
	
	public Donut(Point center, int radius, int innerRadius, Color colorEdges, Color colorInside) {
		this(center, radius, innerRadius);
		setColorEdges(colorEdges);
		setColorInside(colorInside);
		setFilled(true);
	}
	
	
	public void selected(Graphics g) {
		
		new Line(new Point(getCenter().getX(), getCenter().getY()-innerRadius), new Point(getCenter().getX(), getCenter().getY() + innerRadius)).selected(g);
		new Line(new Point(getCenter().getX()-innerRadius, getCenter().getY()), new Point(getCenter().getX()+innerRadius, getCenter().getY())).selected(g);
	}
	
	public void draw(Graphics g) {
		g.setColor(getColorEdges());
		super.draw(g);
		g.drawOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius()*2, this.getInnerRadius()*2);
		if(isFilled())
			fill(g);
		if(isSelected())
			selected(g);
	}
	
public void fill(Graphics g) {
		
		g.setColor(getInsideColor());
		g.fillOval(getCenter().getX()-innerRadius+1, getCenter().getY()-innerRadius+1, 2*innerRadius-2, innerRadius+innerRadius-2);
		
		
	}
	
	public int compareTo(Object o) {
		if (o instanceof Donut) {
			return (int) (this.area() - ((Donut) o).area());
		}
		return 0;
	}
	
	
	public boolean contains(Point p) {
		double dFromCenter = this.getCenter().distance(p);
		return super.contains(p.getX(), p.getY()) && dFromCenter > innerRadius;
	}
	
	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut d = (Donut) obj;
			if (this.getCenter().equals(d.getCenter()) &&
					this.getRadius() == d.getRadius()
					&& this.innerRadius == d.getInnerRadius()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public int getInnerRadius() {
		return innerRadius;
	}
	public void setInnerRadius(int innerRadius) throws Exception{
		if(innerRadius>0) {
		this.innerRadius = innerRadius;
		} else {
			throw new NumberFormatException("Inner radius has to be a value greater then 0!");
		}
	}
	
	public String toString() {
		return super.toString() + ", inner radius=" + innerRadius;
	}
	
	
}

