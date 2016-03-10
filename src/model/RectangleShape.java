/*
 * TCSS 305 - Winter 2016
 * Assignment 5 - PowerPaint
 */

package model;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * This class is for drawing a rectangle.
 * 
 * @author Matthew Wu
 * @version 1.3
 *
 */
public class RectangleShape extends AbstractShape {
    
    /**
     * A reference to the rectangle.
     */
    private Rectangle2D myRectangle;

    /**
     * Constructs a rectangle with its name.
     * 
     * @param theName is the shape's name.
     */
    public RectangleShape(final String theName) {
        super(theName);
    }
    
    /**
     * Sets the starting point for a rectangle. 
     * 
     * @param theEvent is the mouse event.
     */
    public void setStartingPoint(final MouseEvent theEvent) {        
        super.setStartingPoint(theEvent);
        myRectangle = new Rectangle2D.Double(super.getStartX(), super.getStartY(),
                                             super.getStartX() - super.getStartX(), 
                                             super.getStartY() - super.getStartY());
        super.setShape(myRectangle);
    }
    
    /**
     * Sets the ending point for a rectangle. 
     * 
     * @param theEvent is the mouse event.
     */
    public void setEndingPoint(final MouseEvent theEvent) {
        super.setEndingPoint(theEvent);
        if (quadOne(super.getStartX(), super.getStartY(), super.getEndX(), super.getEndY())) {
            myRectangle.setRect(super.getEndX(), super.getEndY(), 
                super.getStartX() - super.getEndX(), super.getStartY() - super.getEndY());
        } else if (quadTwo(super.getStartX(), super.getStartY(),
                           super.getEndX(), super.getEndY()))  {
            myRectangle.setRect(super.getStartX(), super.getEndY(), 
                                super.getEndX() - super.getStartX(), 
                                super.getStartY() - super.getEndY());
        } else if (quadFour(super.getStartX(), super.getStartY(),
                            super.getEndX(), super.getEndY())) {
            myRectangle.setRect(super.getEndX(), super.getStartY(), 
                                super.getStartX() - super.getEndX(),
                                super.getEndY() - super.getStartY());
        } else {
            myRectangle.setRect(super.getStartX(), super.getStartY(), 
                                super.getEndX() - super.getStartX(), 
                                super.getEndY() - super.getStartY());
        }
        super.setShape(myRectangle); 
    }
    
    /**
     * Checks to see if the rectangle is being drawn in quadrant one. 
     * 
     * @param theStartingX is the starting x coordinate.
     * @param theStartingY is the starting y coordinate. 
     * @param theEndingX is the ending x coordinate. 
     * @param theEndingY is the ending y coordinate.
     * 
     * @return a boolean value representing whether or not the rectangle
     * has been drawn in quadrant one.
     */
    public boolean quadOne(final double theStartingX, 
                           final double theStartingY, 
                           final double theEndingX, final double theEndingY) {
        return theStartingX >= theEndingX && theStartingY >= theEndingY;
    }
    
    /**
     * Checks to see if the rectangle is being drawn in quadrant two. 
     * 
     * @param theStartingX is the starting x coordinate.
     * @param theStartingY is the starting y coordinate. 
     * @param theEndingX is the ending x coordinate. 
     * @param theEndingY is the ending y coordinate.
     * 
     * @return a boolean value representing whether or not the rectangle
     * has been drawn in quadrant two.
     */
    public boolean quadTwo(final double theStartingX,
                           final double theStartingY, 
                           final double theEndingX, final double theEndingY) {
        return theEndingX >= theStartingX && theStartingY >= theEndingY;
    }
    
    /**
     * Checks to see if the rectangle is being drawn in quadrant four. 
     * 
     * @param theStartingX is the starting x coordinate.
     * @param theStartingY is the starting y coordinate. 
     * @param theEndingX is the ending x coordinate. 
     * @param theEndingY is the ending y coordinate.
     * 
     * @return a boolean value representing whether or not the rectangle
     * has been drawn in quadrant four.
     */
    public boolean quadFour(final double theStartingX, 
                            final double theStartingY, 
                            final double theEndingX, final double theEndingY) {
        return theStartingX >= theEndingX && theEndingY >= theStartingY;
    }
    
    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }

    @Override
    public boolean contains(final double theX, final double theY) {
        return false;
    }

    @Override
    public boolean contains(final Point2D theP) {
        return false;
    }

    @Override
    public boolean intersects(final double theX, 
                              final double theY, 
                              final double theW, final double theH) {
        return false;
    }

    @Override
    public boolean intersects(final Rectangle2D theR) {
        return false;
    }

    @Override
    public boolean contains(final double theX, 
                            final double theY, 
                            final double theW, final double theH) {
        return false;
    }

    @Override
    public boolean contains(final Rectangle2D theR) {
        return false;
    } 

    @Override
    public PathIterator getPathIterator(final AffineTransform theAt) {
        return null;
    }

    @Override
    public PathIterator getPathIterator(final AffineTransform theAt, 
                                        final double theFlatness) {
        return null;
    }
}
