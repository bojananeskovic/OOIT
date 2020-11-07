package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;

public class ColorChooserButton extends JButton{

	private Color currentColor;
	
    public ColorChooserButton(Color c) {
        setCurrentColor(c); 
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Color newColor = JColorChooser.showDialog(null, "Choose a color", currentColor);
                setCurrentColor(newColor);
            }
        });
    }

    public ColorChooserButton(Color c, String title) {
    	setCurrentColor(c); 
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Color newColor = JColorChooser.showDialog(null, title, currentColor);
                setCurrentColor(newColor);
                
            }
        });
    }
    
    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color newColor) {
    	setCurrentColor(newColor, true);
    }

    public void setCurrentColor(Color newColor, boolean notify) {

        if (newColor == null) return;
        
        currentColor = newColor;
        setIcon(createIcon(currentColor, 30, 16));
        repaint();

        if (notify) {
           
            for (ColorChangedListener l : listeners) {
                l.colorChanged(newColor);
            }
        }
    }

    public static interface ColorChangedListener {
        public void colorChanged(Color newColor);
    }

    private List<ColorChangedListener> listeners = new ArrayList<ColorChangedListener>();

    public void addColorChangedListener(ColorChangedListener toAdd) {
        listeners.add(toAdd);
    }

    public static  ImageIcon createIcon(Color main, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, java.awt.image.BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(main);
        graphics.fillRect(0, 0, width, height);
        graphics.setXORMode(Color.DARK_GRAY);
        graphics.drawRect(0, 0, width-1, height-1);
        image.flush();
        ImageIcon icon = new ImageIcon(image);
        return icon;
    }
}