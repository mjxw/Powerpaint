/*
 * TCSS 305 - Winter 2016
 * Assignment 5 - PowerPaint
 */

package model;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * This class is for drawing a pencil.
 * 
 * @author Matthew Wu
 * @version 1.3
 *
 */
public class PencilShape extends AbstractShape {

    /**
     * Reference to the path.
     */
    private Path2D myPath;
    
    /**
     * Constructs a pencil shape with its name.
     * 
     * @param theName is the shape's name.
     */
    public PencilShape(final String theName) {
        super(theName);
    }
    
    /**
     * Sets the starting point for a pencil shape.
     * 
     * @param theEvent is the mouse event.
     */
    public void setStartingPoint(final MouseEvent theEvent) {
        myPath = new GeneralPath();
        super.setShape(myPath);
        myPath.setWindingRule(GeneralPath.WIND_EVEN_ODD);
        myPath.moveTo(theEvent.getX(), theEvent.getY());
    }
    
    /**
     * Sets the ending point for a pencil shape.
     * 
     * @param theEvent is the mouse event.
     */
    public void setEndingPoint(final MouseEvent theEvent) {
        myPath.lineTo(theEvent.getX(), theEvent.getY());
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
