package geometry;

import java.awt.Color;
import java.awt.Graphics;

import geometry.Line;
import geometry.Point;


public class Rectangle extends SurfaceShape{
	
	private Point upperLeftPoint;
	private int width;
	private int height;
	

	public Rectangle(){

	}
	public Rectangle(Point upperLeftPoint, int width, int height){
		this.upperLeftPoint = upperLeftPoint;
		this.height=height;
		this.width=width;
	}
	public Rectangle(Point upperLeftPoint, int width, int height, String color){
		this(upperLeftPoint, width, height);
		setColor(color);
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, Color colorEdges){
		this(upperLeftPoint, width, height);
		setColorEdges(colorEdges);
		setFilled(false);
	}

	public Rectangle(Point upperLeftPoint, int width, int height, Color colorEdges, Color colorInside){
		this(upperLeftPoint, width, height);
		setColorEdges(colorEdges);
		setColorInside(colorInside);
		setFilled(true);
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, String colorEdges, String colorInside) {
		this(upperLeftPoint, width, height);
		setColor(colorEdges);
		setColorInside(colorInside);
	}
	
	public void moveTo(int x, int y){
		upperLeftPoint.setX(x);
		upperLeftPoint.setY(y);
	}

	public void moveBy(int x, int y){
		upperLeftPoint.setX(upperLeftPoint.getX()+x);
		upperLeftPoint.setY(upperLeftPoint.getY()+y);
	}
	public int compareTo(Object o) {
		if(o instanceof Rectangle){
			Rectangle r = (Rectangle) o;
			return (int) (this.area() - r.area());
		}
		else
			return 0;
	}
	
	public int area() {
		return width * height;
	}
	public int volume(){
		return  2 * height + 2 * width;
	}

	public String toString() {
		return "Tacka gore levo= " + upperLeftPoint + ", visina= " + height + ", sirina= " + width + " , boja ivice= " + getColor() + ", boja unutrasnjosti= " + getColorInside();
	}

	public boolean equals(Object obj){
		if(obj instanceof Rectangle){
			Rectangle r = (Rectangle) obj;
			if(upperLeftPoint.equals(r.upperLeftPoint) && width == r.width && height == r.height)
				return true;
			else
				return false;

		}
		else
			return false;
	}
	public Line diagonal(){
		return new Line(upperLeftPoint, new Point(upperLeftPoint.getX() + width,upperLeftPoint.getY() + height));
	}
	
	
	public void selected(Graphics g) {
		
		g.setColor(findColor("plava"));
		new Line(getUpperLeftPoint(), new Point(getUpperLeftPoint().getX()+width, getUpperLeftPoint().getY())).selected(g);
		new Line(getUpperLeftPoint(), new Point(getUpperLeftPoint().getX(), getUpperLeftPoint().getY()+height)).selected(g);
		new Line(new Point(getUpperLeftPoint().getX()+width, getUpperLeftPoint().getY()), diagonal().getEndPoint()).selected(g);
		new Line(new Point(getUpperLeftPoint().getX(), getUpperLeftPoint().getY()+height), diagonal().getEndPoint()).selected(g);
	}
	public boolean contains(int x, int y) {
		if(this.getUpperLeftPoint().getX()<=x 
				&& x<=(this.getUpperLeftPoint().getX() + width)
				&& this.getUpperLeftPoint().getY()<=y 
				&& y<=(this.getUpperLeftPoint().getY() + height))
			return true;
		else 
			return false;

	}
	public void draw(Graphics g){
		g.setColor(getColorEdges());
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
		if(isFilled())
			fill(g);
		if(isSelected())
			selected(g);
	}
	public void fill(Graphics g) {
		g.setColor(getInsideColor());
		g.fillRect(upperLeftPoint.getX()+1, upperLeftPoint.getY()+1, width-1, height-1);
		
	}
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}
	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) throws Exception{
		if(width>0) {
		this.width = width;
		} else {
			throw new NumberFormatException("Width has to be a value greater then 0!");
		} 
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) throws Exception{
		if(height>0) {
		this.height = height;
		} else {
			throw new NumberFormatException("Height has to be a value greater then 0!");
		} 
	}

	
	
}
