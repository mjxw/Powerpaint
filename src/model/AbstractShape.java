/*
 * TCSS 305 - Winter 2016
 * Assignment 5 - PowerPaint
 */

package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;

/**
 * This abstract class implements Shape and Cloneable.
 * This class defines methods useful to the more specific 
 * shape classes. 
 * 
 * @author Matthew Wu
 * @version 1.3
 *
 */
public abstract class AbstractShape implements Shape, Cloneable {
    
    /**
     * The name of the shape.
     */
    private final String myName;
    
    /**
     * The starting point.
     */
    private Point myStartingPoint;
    
    /**
     * The ending point.
     */
    private Point myEndingPoint;
    
    /**
     * The starting x coordinate.
     */
    private double myStartingX; 
    
    /**
     * The starting y coordinate.
     */
    private double myStartingY;
    
    /**
     * The ending x coordinate.
     */
    private double myEndingX;
    
    /**
     * The ending y coordinate.
     */
    private double myEndingY;
    
    /**
     * A reference to the shape to be drawn.
     */
    private Shape myShape;
    
    /**
     * Constructs an abstract shape with the name of the shape. 
     * 
     * @param theName is the name of the shape.
     */
    public AbstractShape(final String theName) {
        myName = theName;
    }
    
    /**
     * Sets the starting coordinates.
     * 
     * @param theEvent is the mouse event.
     */
    public void setStartingPoint(final MouseEvent theEvent) {
        myStartingX = theEvent.getX();
        myStartingY = theEvent.getY();
        myStartingPoint = theEvent.getPoint();
    }
    
    /**
     * Sets the ending coordinates.
     * 
     * @param theEvent is the mouse event.
     */
    public void setEndingPoint(final MouseEvent theEvent) {
        myEndingX = theEvent.getX();
        myEndingY = theEvent.getY();
        myEndingPoint = theEvent.getPoint();
    }
    
    /**
     * Gets the name of the shape.
     * 
     * @return Return a string that represents the name of the shape.
     */
    public String getName() {
        return myName;
    }
    
    /**
     * This method gets the starting point.
     * 
     * @return returns a point representing the start.
     */
    public Point getStartPoint() {
        return myStartingPoint;
    }
    
    /**
     * This method gets the ending point.
     * 
     * @return Returns a point representing the end.
     */
    public Point getEndPoint() {
        return myEndingPoint;
    }
    
    /**
     * This method gets the starting x coordinate.
     * 
     * @return Returns a starting x coordinate.
     */
    public double getStartX() {
        return myStartingX;
    }
    
    /**
     * This method gets the starting y coordinate.
     * 
     * @return Returns a starting y coordinate.
     */
    public double getStartY() {
        return myStartingY;
    }
    
    /**
     * This method gets the ending x coordinate.
     * 
     * @return Returns an ending x coordinate.
     */
    public double getEndX() {
        return myEndingX;
    }
    
    /**
     * This method gets the ending y coordinate.
     * 
     * @return Returns an ending y coordinate.
     */
    public double getEndY() {
        return myEndingY;
    }
    
    /**
     * This method sets the shape to the right shape to be drawn.
     * 
     * @param theShape is the shape to be drawn.
     */
    public void setShape(final Shape theShape) {
        myShape = theShape;
    }
    
    /**
     * This method draws the graphic 2d.
     * 
     * @param theGraphics is the graphics object.
     */
    public void draw(final Graphics theGraphics) {
        if (myShape != null) {
            ((Graphics2D) theGraphics).draw(myShape);
        }
    }
    
    /**
     * This method is for cloning.
     * 
     * @return Returns a cloned AbstractShape.
     */
    public AbstractShape clone() {
        AbstractShape clonedShape = null;
        
        try {
            clonedShape = (AbstractShape) super.clone();
        } catch (final CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clonedShape;
    }
}
