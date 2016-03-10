/*
 * TCSS 305 - Winter 2016
 * Assignment 5 - PowerPaint
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.ColorActionIcon;
import model.EllipseShape;
import model.LineShape;
import model.PencilShape;
import model.RectangleShape;
import model.ToolButtonGenerator;

/**
 * This class sets up the GUI for power paint. A client can paint 
 * different shapes and lines in different colors. 
 * 
 * @author Matthew Wu
 * @version 1.8
 */
public class PowerPaintGUI extends JFrame { 
   
    /**
     * A generated serial version UID for object Serialization.
     */
    private static final long serialVersionUID = -7341585039602629055L;
   
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
    
    /**
     * A number value for max ticks.
     */
    private static final int TWENTY = 20; 
    /**
     * A JFrame.
     */
    private JFrame myFrame;
    
    /**
     * A JMenuBar.
     */
    private JMenuBar myMenuBar;
    
    /**
     * The file menu object.
     */
    private JMenu myFile;
    
    /**
     * The options menu object.
     */
    private JMenu myOptions; 
    
    /**
     * The tool menu object.
     */
    private JMenu myTool;
    
    /**
     * The help menu object.
     */
    private JMenu myHelp;
    
    /**
     * Storing an image used for icon. 
     */
    private Image myImage;
    
    /**
     * A reference to the drawing panel.
     */
    private DrawingPanel myDrawingPanel;
    
    /**
     * The thickness slider.
     */
    private JSlider myThicknessSlider;
    
    /**
     * The undo button.
     */
    private JMenuItem myUndoButton;

    /**
     * A boolean for if the square/circle button has been pressed.
     */
    private boolean mySquareCircle; 

        
    /**
     * A collection of tool buttons.
     */
    private List<ToolButtonGenerator> myButtonsCollection;  
    
    /**
     * This method starts everything up.
     */
    public void start() {   
        myFrame = new JFrame("PowerPaint");
        myMenuBar = new JMenuBar();
        mySquareCircle = false;
        setupPanels();
        setupToolBar();
        setupIcon();
        menuGenerator();
        addToToolMenu();
        addToFileMenu();
        addToOptionsMenu();
        addToHelpMenu();
        setupFrame();
        setupLookAndFeel();

    }
    
    /**
     * This method sets up the JFrame with the proper behavior.
     */
    private void setupFrame() {
        myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
  
    /**
     * This method creates all the panels and adds them to the frame.
     */
    private void setupPanels() {
        final JPanel overallPanel = new JPanel();
        overallPanel.setLayout(new BorderLayout());
        myFrame.add(overallPanel, BorderLayout.CENTER);
       
        myDrawingPanel = new DrawingPanel();
        myDrawingPanel.setLayout(new BorderLayout());
        myFrame.add(myDrawingPanel, BorderLayout.CENTER);
        
        myFrame.setJMenuBar(myMenuBar);
        myFrame.add(setupToolBar(), BorderLayout.SOUTH);
    }
    

    
    /**
     * This method sets up the look and feel to metal.
     */
    private void setupLookAndFeel() {
        final String className = "javax.swing.plaf.metal.MetalLookAndFeel";
        try {
            UIManager.setLookAndFeel(className);
            SwingUtilities.updateComponentTreeUI(myFrame);
            pack();
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } catch (final InstantiationException e) {
            e.printStackTrace();
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
        } catch (final UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This method sets up the icon. 
     */
    private void setupIcon() {
        try {
            myImage = ImageIO.read(new File("./images/pencil.gif"));
            myFrame.setIconImage(myImage);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }   
    
    /**
     * This method generates menu objects.
     * 
     */
    private void menuGenerator() {
        myFile = new JMenu("File");  
        myFile.setMnemonic(KeyEvent.VK_F);
        myOptions = new JMenu("Options");   
        myOptions.setMnemonic(KeyEvent.VK_O);
        myTool = new JMenu("Tool");  
        myTool.setMnemonic(KeyEvent.VK_T);
        myHelp = new JMenu("Help");  
        myHelp.setMnemonic(KeyEvent.VK_H);
         
        myMenuBar.add(myFile);
        myMenuBar.add(myOptions);
        myMenuBar.add(myTool);
        myMenuBar.add(myHelp); 
    } 
    
    /**
     * This adds menu items to "file".
     */
    private void addToFileMenu() {
        myUndoButton = new JMenuItem("Undo all changes");
        myUndoButton.setEnabled(false);
        myUndoButton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(final ActionEvent theEvent) {
                myDrawingPanel.undo();
            }
        }); 
        myUndoButton.addPropertyChangeListener(new PropertyChangeListener() {
            
            @Override
            public void propertyChange(final PropertyChangeEvent theEvent) {
                if (!myDrawingPanel.listIsEmpty()) {
                    myUndoButton.setEnabled(true);
                } else {
                    myUndoButton.setEnabled(false);
                }
            }
        });

        final JMenuItem exitButton = new JMenuItem("Exit"); 
        exitButton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(final ActionEvent theEvent) {
                myFrame.dispatchEvent(new WindowEvent(myFrame, WindowEvent.WINDOW_CLOSING));
            }
        });
        myFile.add(myUndoButton);
        myFile.addSeparator();
        myFile.add(exitButton); 
    }
    
    
    /**
     * This adds menu items to "options".
     */
    private void addToOptionsMenu() {
        final JCheckBoxMenuItem squareCircleButton = 
                        new JCheckBoxMenuItem("Square/Circle only");
        myOptions.add(squareCircleButton);
        squareCircleButton.addActionListener(new ActionListener() {
           
            @Override 
            public void actionPerformed(final ActionEvent theEvent) {
                mySquareCircle = true;
            }
        });
        myOptions.addSeparator();
        final JMenu thicknessButton = new JMenu("Thickness");
        myThicknessSlider = new JSlider(0, TWENTY, FIVE);
        myThicknessSlider.setMajorTickSpacing(FIVE);
        myThicknessSlider.setMinorTickSpacing(1);
        myThicknessSlider.setPaintTicks(true);
        myThicknessSlider.setPaintLabels(true);
        thicknessButton.add(myThicknessSlider);
        myOptions.add(thicknessButton);
        myOptions.addSeparator();
        
        
        final ColorActionIcon icon = new ColorActionIcon(new Color(FIFTY_ONE,
                                                                   0, ONE_HUNDRED_ELEVEN));
        final JMenuItem colorChooserButton = new JMenuItem("Color...", icon);
  
        myOptions.add(colorChooserButton); 
        
        myThicknessSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(final ChangeEvent theEvent) {
                final int value = myThicknessSlider.getValue();
                if (value >= 0) {
                    myDrawingPanel.setWidth(value);
                }
            }
        });
        
        colorChooserButton.addActionListener(new ActionListener() {
        
            @Override 
            public void actionPerformed(final ActionEvent theEvent) {
                final Color colorDialogue = JColorChooser.showDialog
                                (colorChooserButton, null, new Color(51, 0, 111));
                myDrawingPanel.setColor(colorDialogue);
                icon.setColor(colorDialogue);
            }
        });
    }
    
    /**
     * Testing this 
     */
    
    /**
     * This adds menu items to "tool".
     */
    private void addToToolMenu() {
        final ButtonGroup group = new ButtonGroup();
        for (final ToolButtonGenerator button : myButtonsCollection) {  
            final JRadioButtonMenuItem radioToolButton = new JRadioButtonMenuItem(button);
            group.add(radioToolButton);
            myTool.add(radioToolButton);
        }
    }
    
    
    /**
     * This adds menu items to "help".
     */
    private void addToHelpMenu() {
        final JMenuItem aboutButton = new JMenuItem("About...");
        myHelp.add(aboutButton);
        
        aboutButton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(final ActionEvent theEvent) {
                final ImageIcon icon = new ImageIcon(myImage);
                JOptionPane.showMessageDialog(myFrame, "TCSS 305 PowerPaint\n" 
                                + "Winter 2016\n" 
                                + "Matthew Wu", "About", JOptionPane.PLAIN_MESSAGE, icon);
            }
        });
    }
    
    
    /**
     * This method uses the collection of tool buttons to create a tool bar.   
     * @return Returns a JToolBar.
     */
    private JToolBar setupToolBar() {
        
        myButtonsCollection = new ArrayList<ToolButtonGenerator>();

        myButtonsCollection.add(new ToolButtonGenerator(new PencilShape("Pencil"), 
                                                    new ImageIcon("./images/pencil_bw.gif"), 
                                                    myDrawingPanel));
        myButtonsCollection.add(new ToolButtonGenerator(new LineShape("Line"), 
                                                    new ImageIcon("./images/line_bw.gif"),
                                                    myDrawingPanel));
        myButtonsCollection.add(new ToolButtonGenerator(new RectangleShape("Rectangle"),
                                                    new ImageIcon("./images/rectangle_bw.gif"),
                                                    myDrawingPanel
                                                    ));
        myButtonsCollection.add(new ToolButtonGenerator(new EllipseShape("Ellipse"),
                                                    new ImageIcon("./images/ellipse_bw.gif"), 
                                                    
                                                    myDrawingPanel));
        final JToolBar toolBar = new JToolBar();
        final ButtonGroup group = new ButtonGroup();
        for (final ToolButtonGenerator button : myButtonsCollection) {
            final JToggleButton toggleTool = new JToggleButton(button);
            group.add(toggleTool);
            toolBar.add(toggleTool); 
        }
        return toolBar;
    }    
    
    
}