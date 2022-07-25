package com.shpp.p2p.cs.yyefimov.assignment2;

import acm.graphics.GObject;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
* Class Assignment2Part5 will create illusion.
* */
public class Assignment2Part5 extends WindowProgram {
    /*
    * Windows size. Java will use this for creating window.
    * */
    public static final int     APPLICATION_WIDTH       = 600;
    public static final int     APPLICATION_HEIGHT      = 600;

    /* The number of rows and columns in the grid, respectively. */
    private static final int    NUM_ROWS                = 5;
    private static final int    NUM_COLS                = 6;

    /* The width and height of each box. */
    private static final double BOX_SIZE                = 30;
    private static final Color  BOX_COLOR               = Color.BLACK;


    /* The horizontal and vertical spacing between the boxes. */
    private static final double BOX_SPACING             = 15;

    /*
    * Align. ALIGN = 2 mean center.
    * */
    private static final double ALIGN                   = 2;

    /*
     * This offset we need cause of nature of our screen. We need to make offset from down and right side of window.
     * */
    public static final double  OFFSET_X                = 1;
    public static final double  OFFSET_Y                = 1;

    // Method will create our illusion.
    public void run() {
        createRowsAndColumns();
    }

    // We are building Columns here.
    private void createRowsAndColumns() {
        for (int i = 0; i < NUM_COLS; i++ ) {
            createColumns(i);
        }
    }

    // Here we build single box what will make up a Row.
    private void createColumns(int i) {
        for (int j = 0; j < NUM_ROWS; j++){
            createBox(i, j);
        }
    }

    // Here we're calculating starting position of our structure.
    private void createBox(int i, int j) {
        /* We need to get the position when we will start draw our illusion. Half size of window minus half size
         * of all illusion (All boxes with box_spacing). If we have 2 boxes, we will get only 1 box_spacing, so we need
         * to know that.
        **/
        double start_x =
                (double) getWidth() / ALIGN - (NUM_COLS * BOX_SIZE + (NUM_COLS - 1) * BOX_SPACING) / ALIGN - OFFSET_X;
        double start_y =
                (double) getHeight() / ALIGN - (NUM_ROWS * BOX_SIZE + (NUM_ROWS - 1) * BOX_SPACING) / ALIGN - OFFSET_Y;
        add(createBoxAtPosition(start_x, start_y, i, j));
    }

    /* Using starting coordinates and number of each box (i, j) we can calculate position for each box in our
    * illusion, fill it with color, set colors and return GObject with correct position and colors.
    * */
    private GObject createBoxAtPosition(double start_x, double start_y, int i, int j) {
        /* Every box we need move on box_size + box_spacing on each way. Here we received i, j, what will show
        * how we need to move each box.
        * */
        GRect box = new GRect   (start_x + i * BOX_SIZE + i * BOX_SPACING,
                                start_y + j * BOX_SIZE + j * BOX_SPACING,
                                    BOX_SIZE,
                                    BOX_SIZE );
        // Set color and fill each box.
        box.setFilled(true);
        box.setFillColor(BOX_COLOR);
        box.setColor(BOX_COLOR);
        return box;
    }

}