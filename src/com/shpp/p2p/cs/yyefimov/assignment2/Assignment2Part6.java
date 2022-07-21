package com.shpp.p2p.cs.yyefimov.assignment2;

import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;


public class Assignment2Part6 extends WindowProgram {
    /*
    * Here we can define some colors for our program.
    * */
    private static final Color CARDINAL_RED = new Color(196, 30, 58);

    /*
    * Windows size.
    * */
    public static final int APPLICATION_WIDTH   = 600;
    public static final int APPLICATION_HEIGHT  = 350;

    /*
    * Defining a numbers of worm section (WORM_SECTIONS), filling color (FILLING_COLOR), border color (BORDER_COLOR),
    * border thickness (BORDER_THICKNESS), radius of worm section (SECTION_RADIUS).
    * X_OFFSET and Y_OFFSET meaning how we're moving coordinates for next section.
    * */
    public static final int WORM_SECTIONS = 6;
    public static final Color FILLING_COLOR = Color.GREEN;
    public static final Color BORDER_COLOR = Color.RED;
    public static final double X_OFFSET = 75;
    public static final double Y_OFFSET = 40;
    public static final double SECTION_RADIUS = 150;
    public static final int BORDER_THICKNESS = 3;
    /*
    * First offset of our worm (FIRST_OFFSET).
    * */
    public static final int FIRST_OFFSET = 1;

    public void run() {
        buildWorm();
    }

    private void buildWorm() {
        // Start to build each section.
        for (int i = FIRST_OFFSET; i <= WORM_SECTIONS; i++) {
            createSection(i);
        }
    }

    private void createSection(int i) {
        /*
        *   We are moving our section in x-coordinate constantly. But y-coordinate moving by depending on odd even
        * worm circle. i % 2 give us odd or even.
        * */
        GOval section = new GOval(
                                X_OFFSET * (i - 1),
                                (i % 2) * Y_OFFSET,
                                    SECTION_RADIUS,
                                    SECTION_RADIUS
                                );

        section.setFilled(true);
        section.setFillColor(FILLING_COLOR);
        section.setColor(BORDER_COLOR);
        add(section);
        drawBorder(section);
    }

    private void drawBorder(GOval section) {
        /*
        * In this method we are drawing border for each section of our worm. BORDER_THICKNESS shows how many smallest
        * circles will add for out. Each new circle will have the smallest radius, and we need to make some offset
        * for each new circle.
        * */
        double section_x = section.getX();
        double section_y = section.getY();

        for (int i = 1; i < BORDER_THICKNESS; i++) {
            GOval border = new GOval(
                                        section_x +((double)i) / 2,
                                        section_y+((double)i) / 2,
                                        SECTION_RADIUS - i,
                                        SECTION_RADIUS - i
                                    );
            border.setColor(BORDER_COLOR);
            add (border);
        }
    }

}