/*
 * TCSS 305 - Winter 2016
 * Assignment 5 - PowerPaint
 */
package model;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import view.DrawingPanel;

/**
 * This class generates tool buttons.
 * 
 * @author Matthew Wu
 * @version 1.1
 *
 */
public class ToolButtonGenerator extends AbstractAction {
    
    /** A generated serialization ID. */
    private static final long serialVersionUID = 5378597116905801274L;
    
    /**
     * A reference to the drawing panel.
     */
    private final DrawingPanel myDrawingPanel;
    
    /**
     * Reference to the shape.
     */
    private final AbstractShape myShape;

    /**
     * Constructs an action with the specified name and icon to set the
     * panel to the specified color.
     * 
     * @param theShape is the shape.
     * @param theIcon is the icon 
     * @param theDrawingPanel is the drawing panel.
     */
    public ToolButtonGenerator(final AbstractShape theShape,
                               final Icon theIcon, final DrawingPanel theDrawingPanel) {
        super();
        myDrawingPanel = theDrawingPanel;
        myShape = theShape;
        putValue(Action.NAME, theShape.getName()); 
        final ImageIcon icon = (ImageIcon) theIcon;
        final Image largeImage =
            icon.getImage().getScaledInstance(15, -1, java.awt.Image.SCALE_SMOOTH);
        final ImageIcon largeIcon = new ImageIcon(largeImage);
        putValue(Action.LARGE_ICON_KEY, largeIcon);
        
        // set a mnemonic on the first character of the name
        putValue(Action.MNEMONIC_KEY,
                 KeyEvent.getExtendedKeyCodeForChar(theShape.getName().charAt(0)));
                
        // coordinate button selection
        putValue(Action.SELECTED_KEY, true);   
    }

    /**
     * Responsible for any action performed.
     * Sets the tool to the correct shape.
     * 
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myDrawingPanel.setTool(myShape);
    }
}
