package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{
	
	private Point startPoint;
	private Point endPoint;

	public Line(){

	}
	public Line(Point startPoint, Point endPoint){
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	public Line(Point startPoint, Point endPoint, String color){
		this(startPoint,endPoint);
		setColor(color);
	}

	public Line(Point startPoint, Point endPoint, Color color){
		this(startPoint,endPoint);
		setColorEdges(color);
	}
	
	public void moveBy(int x, int y){
		startPoint.moveBy(x, y);
		endPoint.moveBy(x, y);
	}
	
	public void moveTo(int x, int y) {
		startPoint.moveTo(x, y);
		endPoint.moveTo(x, y);
	}

	public double length(){
		return startPoint.distance(endPoint);
	}
	// (xPocetne,yPocetne)-->(xKrajnje,yKrajnje)
	public String toString(){
		return startPoint+"-->"+endPoint;
	}
	public boolean equals(Object obj){
		if(obj instanceof Line){
			Line p = (Line) obj;
			if(startPoint.equals(p.getStartPoint()) && endPoint.equals(p.getEndPoint()))
				return true;
			else
				return false;

		}
		else
			return false;
	}
	public Point middleOfLine() {
		int middleByX = (this.getStartPoint().getX() + this.getEndPoint().getX()) / 2;
		int middleByY = (this.getStartPoint().getY() + this.getEndPoint().getY()) / 2;
		Point p = new Point(middleByX, middleByY);
		return p;
	}

	public boolean contains(int x, int y){
		Point p = new Point(x, y);
		if(p.distance(startPoint)+p.distance(endPoint)-this.length()<0.5)
			return true;
		else 
			return false;
	}
	public void selected(Graphics g){
		g.setColor(Color.BLUE);
		startPoint.selected(g);
		endPoint.selected(g);
		middleOfLine().selected(g);
	}
	public void draw(Graphics g){
		g.setColor(getColorEdges());
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		if(isSelected())
			selected(g);
	}


	public int compareTo(Object o) {
		if(o instanceof Line){
			Line l = (Line) o;
			return (int) (this.length() - l.length());
		}
		else
			return 0;
	}
	public Point getStartPoint(){
		return startPoint;
	}
	public Point getEndPoint(){
		return endPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	



}