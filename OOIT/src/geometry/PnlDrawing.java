package geometry;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PnlDrawing extends JPanel{
	
	int x;
	int y;
	
	private ArrayList<Shape> shapes;
	
	public PnlDrawing() {
		super();
		shapes = new ArrayList<Shape>();	
	}
	
	public void addShape(Shape o)
	{
		shapes.add(o);
		o.draw(this.getGraphics());
		
	}
	
	public void deleteShape(Shape o)
	{
		shapes.remove(o);
		repaint();
	}
	
	public Shape Select(int x, int y)
	{
		for (int i = shapes.size()-1; i >= 0; i--){
			
			if(shapes.get(i).contains(x, y)){
				shapes.get(i).setSelected(true);
				for (Shape o : shapes){
					if (shapes.get(i) != o)
						o.setSelected(false);
				}
				repaint();
				return shapes.get(i);
			}
		}
		for (Shape o: shapes)
			o.setSelected(false);
		repaint();
		return null;
	}
	
	public void paint(Graphics g){
		
		super.paint(g);
		
		for (Shape o : shapes){
			o.draw(g);
		}
	}
}