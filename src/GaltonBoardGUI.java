/*  SOFE2715U | 2020
    Final Project: Galton Board
    GaltonBoardGUI.java
    Massimo Albanese
    © 2020 ALL RIGHTS RESERVED  */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.Random;
import java.awt.Color;


public class GaltonBoardGUI extends JFrame {
    private static paintArea pad = new paintArea();                                                                     // declares the paintArea class, where the graphical representation will be outputted

    public static void main(String[] args) {                                                                            // initiates the frame
        GaltonBoardGUI frame = new GaltonBoardGUI();
        frame.setVisible(true);
        frame.getContentPane().add(pad, BorderLayout.CENTER);
    }

    private GaltonBoardGUI(){
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100, 1000, 820);

        JPanel contentPane = new JPanel();                                                                              // declaration of UI elements: labels, textFields, and buttons
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        final JPanel UIPanel = new JPanel();                                                                                  // JPanel where all the inputs and labels are kept
        UIPanel.setBounds(0,0, getWidth(),40);
        UIPanel.setBorder(new EmptyBorder(5,5,5,5));
        UIPanel.setLayout(new BoxLayout(UIPanel, BoxLayout.X_AXIS));                                                    // uses a boxLayout on the x axis to organize all the UI components

        contentPane.add(UIPanel, BorderLayout.PAGE_START);

        JLabel ballsLabel = new JLabel(" # of balls:");
        UIPanel.add(ballsLabel);

        final JTextField ballsTextField = new JTextField("1000");
        UIPanel.add(ballsTextField);

        JLabel slotsLabel = new JLabel(" # of slots:");
        UIPanel.add(slotsLabel);

        final JTextField slotsTextField = new JTextField("11");
        UIPanel.add(slotsTextField);

        final JLabel timeLabel = new JLabel(" Time elapsed:           ");
        UIPanel.add(timeLabel);

        final JButton startSimulation = new JButton("Start");                                                            // button that starts the simulation
        UIPanel.add(startSimulation);

        startSimulation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                                                                // actionListener for when the button is pressed
                int balls = Integer.parseInt(ballsTextField.getText());                                                 // grabs values from the balls and slots textFields
                int size = Integer.parseInt(slotsTextField.getText());
                PinGraph pins = new PinGraph(size);                                                                     // initiates a new pinGraph class, same as the non GUI version
                long start = System.currentTimeMillis();
                int[] bins = compute(pins, size, balls);
                long finish = System.currentTimeMillis();
                timeLabel.setText(" Time Elapsed: " + (finish - start)/1000.0 + "s");
                draw(bins, balls);                                                                                      // this function draws the output
            }});
    }

    private static void draw(int[] bins, int balls){
        pad.clear();
        pad.graphic.setPaint(Color.white);
        int xDimension = pad.getWidth();                                                                                // gets dimensions of the painting area
        int yDimension = pad.getHeight();
        double width = (double)xDimension/bins.length;                                                                  // computes width of rectangles to fit in area
        width = Math.round(width);
        int x = 0;
        Font font = new Font("Arial Black", Font.PLAIN, 15);                                                // creates a new font to be used
        pad.graphic.setFont(font);
        for (int bin : bins) {                                                                                          // iterates through each bin
            double height = (((double)bin/balls));                                                                      // computes the relative height of the bar through a percentage
            height = yDimension * (1 - height);
            pad.graphic.setPaint(Color.red);
            pad.graphic.fillRect(x, (int)(height), (int)width, yDimension-(int)height);                          // paints a red rectangle
            pad.graphic.setPaint(Color.black);
            pad.graphic.drawRect(x, (int)height, (int)width, yDimension-(int)height);                           // paints black outline of the rectangle
            AffineTransform oldXForm = pad.graphic.getTransform();                                                      // rotates graphic pad 90 degrees counterclockwise to draw the vertical text
            pad.graphic.rotate(-Math.PI/2.0);
            if (bin == 0)
                pad.graphic.drawString("-",   5 - (int)height, (int)(x + width/2) + 5);                      // draws the amount of balls in the bin if not 0, if it is 0 it puts '-'
            else
                pad.graphic.drawString(String.valueOf(bin),   5 - (int)height, (int)(x + width/2) + 5);
            pad.graphic.setTransform(oldXForm);                                                                         // reverts graphics pad to normal angle
            x += width;
        }
    }

    private static int[] compute(PinGraph pins, int size, int balls) {                                                  // compute and findBin are the same functions found in the non GUI version of the program
        int[] bins = new int[size];
        for (int i = 1; i <= balls; i++)
            bins[findBin(0, pins) - 1]++;
        return bins;
    }

    private static int findBin(int index, PinGraph pins) {
        Random random = new Random();
        if (pins.getBin(index) != 0)
            return pins.getBin(index);
        else if (random.nextInt(2) == 1)
            return findBin(pins.getLeft(index), pins);
        else
            return findBin(pins.getRight(index), pins);
    }
}

class paintArea extends JComponent {                                                                                    // class that allows us to paint
    private Image image;
    Graphics2D graphic;

    paintArea() {                                                                                                       // constructs the painting area
        setBounds(0, 37, 1000, 750);
        setDoubleBuffered(false);
    }

    public void paintComponent(Graphics drawer) {                                                                       // does the initialization on the graphics2D object
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            graphic = (Graphics2D) image.getGraphics();
            graphic.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        drawer.drawImage(image, 0, 0, null);
    }

    void clear() {                                                                                                      // resets the canvas to white
        graphic.setPaint(Color.white);
        graphic.fillRect(0, 0, getSize().width, getSize().height);
        repaint();
    }
}