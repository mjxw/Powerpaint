/*
 * TCSS 305 - Winter 2016
 * Assignment 5 - PowerPaint
 */

package model;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * This class is for drawing a line shape.
 * 
 * @author Matthew Wu
 * @version 1.3
 *
 */
public class LineShape extends AbstractShape {
    
    /**
     * Reference to the line.
     */
    private Line2D myLine;
    
    /**
     * Constructs a line with its name.
     * 
     * @param theName is the shape's name.
     */
    public LineShape(final String theName) {
        super(theName);
    }
    
    /**
     * Sets the starting point for a line.
     * 
     * @param theEvent is the mouse event.
     */
    public void setStartingPoint(final MouseEvent theEvent) {
        super.setStartingPoint(theEvent);
        myLine = new Line2D.Double(super.getStartPoint(), super.getStartPoint());
        super.setShape(myLine);
    }
    
    /**
     * Sets the ending point for a line.
     * 
     * @param theEvent is the mouse event.
     */
    public void setEndingPoint(final MouseEvent theEvent) {
        super.setEndingPoint(theEvent);
        myLine.setLine(super.getStartPoint(), super.getEndPoint());
        super.setShape(myLine);
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
