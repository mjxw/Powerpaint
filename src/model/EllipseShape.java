/*
 * TCSS 305 - Winter 2016
 * Assignment 5 - PowerPaint
 */

package model;

import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

/**
 * This class is for drawing an ellipse. 
 * It extends the rectangle shape.
 * 
 * @author Matthew Wu
 * @version 1.3
 *
 */     
public class EllipseShape extends RectangleShape {

    /**
     * A reference to the ellipse.
     */
    private Ellipse2D myEllipse;

    /**
     * Constructs an ellipse with its name.
     * 
     * @param theName is the shape's name.
     */
    public EllipseShape(final String theName) {
        super(theName);
    }
    
    /**
     * Sets the starting point for an ellipse.
     * 
     *  @param theEvent is the mouseEvent.
     */
    public void setStartingPoint(final MouseEvent theEvent) {        
        super.setStartingPoint(theEvent);
        myEllipse = new Ellipse2D.Double(super.getStartX(), 
                                         super.getStartY(), 
                                         super.getStartX() - super.getStartX(),
                                         super.getStartY() - super.getStartY());
        super.setShape(myEllipse);
    }
    
    /**
     * Sets the ending point for an ellipse.
     * 
     *  @param theEvent is the mouseEvent.
     */
    public void setEndingPoint(final MouseEvent theEvent) {
        super.setEndingPoint(theEvent);
        if (quadOne(super.getStartX(), super.getStartY(), super.getEndX(), super.getEndY())) {
            myEllipse.setFrame(super.getEndX(), super.getEndY(), 
                super.getStartX() - super.getEndX(), super.getStartY() - super.getEndY());
        } else if (quadTwo(super.getStartX(), super.getStartY(),
                           super.getEndX(), super.getEndY()))  {
            myEllipse.setFrame(super.getStartX(), super.getEndY(), 
                                super.getEndX() - super.getStartX(), 
                                super.getStartY() - super.getEndY());
        } else if (quadFour(super.getStartX(), super.getStartY(),
                            super.getEndX(), super.getEndY())) {
            myEllipse.setFrame(super.getEndX(), super.getStartY(), 
                                super.getStartX() - super.getEndX(),
                                super.getEndY() - super.getStartY());
        } else {
            myEllipse.setFrame(super.getStartX(), super.getStartY(), 
                                super.getEndX() - super.getStartX(), 
                                super.getEndY() - super.getStartY());
        }
        super.setShape(myEllipse);       
    }
}
