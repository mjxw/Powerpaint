/*
 * TCSS 305 - Winter 2016
 * Assignment 5 - PowerPaint
 */

package model;

import java.awt.Color;

/**
 * This is the shape interface. A shape has a 
 * name, stroke width, starting x and y coordinates, 
 * and ending x and y coordinates as well as a color.
 * 
 * @author Matthew Wu
 * @version 1.0
 *
 */
public interface Shape {
    
    /**
     * The name of the shape.
     * 
     * @return String representing the name.
     */
    String getName();
    
    /**
     * The stroke width of the shape. 
     * 
     * @return int representing the stroke width.
     */
    int getStrokeWidth();
    
    /**
     * The starting x coordinate.
     * 
     * @return int representing the starting x coordinate.
     */
    int getStartX();
    
    /**
     * The starting y coordinate. 
     * 
     * @return int representing the starting y coordinate.
     */
    int getStartY();
    
    /**
     * The ending x coordinate. 
     * 
     * @return int representing the ending x coordinate. 
     */
    int getEndX();
    
    /**
     * The ending y coordinate. 
     * 
     * @return int representing the ending y coordinate.
     */
    int getEndY();
    
    /**
     * The shape's color.
     * 
     * @return a color representing the shape's color.
     */
    Color getColor();

}
