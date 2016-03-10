/*
 * TCSS 305 - Winter 2016
 * Assignment 5 - PowerPaint
 */

package model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;

/**
 * This class creates an icon that has an image that matches the selected color.
 * 
 * @author Matthew Wu
 * @version 1.1
 *
 */
public class ColorActionIcon implements Icon {

    /**
     * This is the width of the icon.
     */
    private static final int WIDTH = 15;
    
    /**
     * This is the height of the icon.
     */
    private static final int HEIGHT = 15;
    
    /**
     * This is the color that the icon needs to change to.
     */
    private Color myTargetColor;
    
    /**
     * Constructs the color action icon.
     * 
     * @param theColor is the color to be set.
     */
    public ColorActionIcon(final Color theColor) {
        setColor(theColor);
    }
   
    /**
     * This sets target color.
     * 
     * @param theColor is the target color.
     */
    public void setColor(final Color theColor) {
        myTargetColor = theColor;
    }
    
    @Override
    public void paintIcon(final Component theC, 
                          final Graphics theG, 
                          final int theX, 
                          final int theY) {
        final Graphics2D g2d = (Graphics2D) theG.create();
        g2d.setColor(myTargetColor);
        g2d.fillRect(theX + 1, theY + 1, WIDTH - 2, HEIGHT - 2);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(theX + 1, theY + 1, WIDTH - 2, HEIGHT - 2);
        g2d.dispose();        
    }

    @Override
    public int getIconWidth() {
        return WIDTH;
    }

    @Override
    public int getIconHeight() {
        return HEIGHT;
    }    
}
