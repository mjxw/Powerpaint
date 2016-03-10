/*
 * TCSS 305 - Winter 2016
 * Assignment 5 - PowerPaint
 */
package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import model.AbstractShape;
import model.PencilShape;
import model.ShapeCollection;

/**
 * This class creates the drawing panel area to draw shapes and lines.
 * 
 * @author Matthew Wu
 * @version 3.0
 */
public class DrawingPanel extends JPanel {

    /**
     * A generated serial version UID for object Serialization.
     */
    private static final long serialVersionUID = 8444575580975344636L;
    
    /**
     * A number value for RGB.
     */
    private static final int FIFTY_ONE = 51; 
    
    /**
     * A number value for ticks.
     */
    private static final int FIVE = 5; 
    
    /**
     * A number value for RGB.
     */
    private static final int ONE_HUNDRED_ELEVEN = 111;
        
    /** The width of the panel. */
    private static final int WIDTH = 500;

    /** The height of the panel. */
    private static final int HEIGHT = 400;
    
    /**
     * A tool's color.
     */
    private Color myColor;
    
    /**
     * The reference to the current shape type.
     */
    private AbstractShape myCurrentShape;
    
    /**
     * The collection of drawn shapes.
     */
    private List<ShapeCollection> myDrawnShapes;
    
    /**
     * A line width. 
     */
    private int myLineWidth;
    
    /**
     * A boolean flag that indicates whether or not the undo action was performed.
     */
    private boolean myUndoFlag;
   
    /**
     * Creates a drawing panel and adds listeners for events. 
     */
    public DrawingPanel() {
        super();
        myColor = new Color(FIFTY_ONE, 0, ONE_HUNDRED_ELEVEN);
        myCurrentShape = new PencilShape("Pencil");
        myDrawnShapes = new ArrayList<ShapeCollection>();
        myLineWidth = FIVE;
        myUndoFlag = false;  
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseMotionListener());
    }
    
    /**
     * This method sets myCurrentShape to the proper shape that client wants to draw.
     * 
     * @param theShape is the shape to set the tool to.
     */
    public void setTool(final AbstractShape theShape) {
        myCurrentShape = theShape;
    }
    
    /**
     * This method sets the width drawn to the width the client wants from slider.
     * 
     * @param theStrokeWidth is the stroke width to draw with.
     */
    public void setWidth(final int theStrokeWidth) {
        myLineWidth = theStrokeWidth;
    }
    
    /**
     * This method sets the color that the client wants to draw with.
     * 
     * @param theColor is the color to be drawn with.
     */
    public void setColor(final Color theColor) {
        myColor = theColor;
    }
     
    /**
     * This method checks if the arraylist storing the drawn shapes is empty.
     * 
     * @return returns true if the arraylist is empty and false otherwise.
     */
    public boolean listIsEmpty() {
        return myDrawnShapes.isEmpty();
    }
    
    /**
     * This method erases everything on the drawing board.
     */
    public void undo() {
        myDrawnShapes.clear();
        myDrawnShapes = new ArrayList<ShapeCollection>();
        myUndoFlag = true;
        repaint();
    }
    

    
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);

        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);      

        //for each shape collection, get what the color, 
        //thickness, and shape it was and then draw it
        for (final ShapeCollection a : myDrawnShapes) {
            g2d.setPaint(a.getColor());
            g2d.setStroke(new BasicStroke(a.getWidth()));
            if (a.getWidth() != 0) {
                a.getShape().draw(g2d);
            } 
        }
        if (!myUndoFlag) { // only add shape to collection if you didn't undo 
            final ShapeCollection currentDrawn  = new ShapeCollection(myCurrentShape,
                                                                      myColor, myLineWidth);
            myDrawnShapes.add(currentDrawn);     
        }
        myUndoFlag = false;
    } 
    
    /**
     * This class is responsible for mouse click events. 
     * Sets the starting point of the shape. 
     *
     */
    private class MyMouseListener extends MouseAdapter {
        /**
         * Handles a click event.
         * 
         * @param theEvent The event.
         */
        @Override
        public void mousePressed(final MouseEvent theEvent) {
            myCurrentShape.setStartingPoint(theEvent);
        }        
    }
    
    /**
     * This class is responsible for mouse drag events. 
     * Sets the ending point of the shape.
     *
     */
    private class MyMouseMotionListener extends MouseAdapter {
        
        @Override
        public void  mouseDragged(final MouseEvent theEvent) {
            myCurrentShape.setEndingPoint(theEvent);
            repaint();
        }
    }   
}

