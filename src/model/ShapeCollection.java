/*
 * TCSS 305 - Winter 2016
 * Assignment 5 - PowerPaint
 */

package model;

import java.awt.Color;

/**
 * This class stores the three essential things needed to draw a shape.
 * It stores what shape it is, the color, and the width.
 * 
 * @author Matthew Wu
 * @version 1.2
 *
 */
public class ShapeCollection {
    
    /**
     * This is the shape to be drawn.
     */
    private final AbstractShape myShape; 
    
    /**
     * This is the color to be drawn with.
     */
    private final Color myColor;
    
    /**
     * This is the stroke width to be drawn with.
     */
    private final int myStrokeWidth;
    
    /**
     * Construct the shape, the color, and the width.
     * 
     * @param theShape is the shape to be drawn.
     * @param theColor is the color to draw with.
     * @param theStrokeWidth is the width to draw with. 
     */
    public ShapeCollection(final AbstractShape theShape,
                           final Color theColor, final int theStrokeWidth) {
        myShape = theShape.clone(); 
        myColor = theColor; 
        myStrokeWidth = theStrokeWidth;
    }
    
    /**
     * This method gets the shape.
     * 
     * @return Returns an abstract shape.
     */
    public AbstractShape getShape() {
        return myShape;
    }
    
    /**
     * This method gets the color.
     * 
     * @return Returns a color.
     */
    public Color getColor() {
        return myColor;
    }
    
    /**
     * This method gets the stroke width.
     * 
     * @return Returns an integer representing the stroke width value.
     */
    public int getWidth() {
        return myStrokeWidth;
    }
}
