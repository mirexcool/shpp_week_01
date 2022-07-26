package com.shpp.p2p.cs.yyefimov.assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
* Class Assignment2Part6 will draw a worm in our window.
* */
public class Assignment2Part6 extends WindowProgram {
    /*
    * Windows size.
    * */
    public static final int APPLICATION_WIDTH   = 1100;
    public static final int APPLICATION_HEIGHT  = 300;

    /*
    * Defining a numbers of worm section (WORM_SECTIONS), filling color (FILLING_COLOR), border color (BORDER_COLOR),
    * border thickness (BORDER_THICKNESS), radius of worm section (SECTION_RADIUS).
    * X_OFFSET and Y_OFFSET meaning how we're moving coordinates for next section (depends on section_radius).
    * */
    public static final int         WORM_SECTIONS       = 14;
    public static final Color       FILLING_COLOR       = Color.GREEN;
    public static final Color       BORDER_COLOR        = Color.RED;
    public static final double      X_OFFSET            = 2;
    public static final double      Y_OFFSET            = 5;
    public static final double      SECTION_RADIUS      = 146;
    public static final int         BORDER_THICKNESS    = 3;
    /*
    * First offset of our worm (START_OFFSET). You can move first section of worm by this parameter.
    * */
    public static final int         START_OFFSET        = 1;


    // We are building worm here.
    public void run() {
        buildWorm();
    }

    // Build each section of worm.
    private void buildWorm() {
        // Start to build each section.
        for (int i = START_OFFSET; i <= WORM_SECTIONS; i++) {
            createSection(i);
        }
    }

    // Creating of each section of worm. Here we are setting coordinates, colors, border.
    private void createSection(int i) {
        /*
        *   We are moving our section in x-coordinate constantly. But y-coordinate moving by depending on odd even
        *   worm circle. i % 2 give us odd or even.
        * */
        GOval section = new GOval   ((SECTION_RADIUS / X_OFFSET) * (i - 1),
                                    (SECTION_RADIUS / Y_OFFSET) * (i % 2),
                                        SECTION_RADIUS,
                                        SECTION_RADIUS  );
        //  Color settings.
        section.setFilled(true);
        section.setFillColor(FILLING_COLOR);
        section.setColor(BORDER_COLOR);
        add(section);
        drawBorder(section);
    }

    // Here we're drawing border for each section of worm.
    private void drawBorder(GOval section) {
        /*
        * In this method we are drawing border for each section of our worm. BORDER_THICKNESS shows how many smallest
        * circles will add for out. Each new circle will have the smallest radius, and we need to make some offset
        * for each new circle.
        * */
        double section_x = section.getX();
        double section_y = section.getY();

        for (int i = 1; i < BORDER_THICKNESS; i++) {
            GOval border = new GOval    (section_x +((double)i) / 2,
                                        section_y+((double)i) / 2,
                                        SECTION_RADIUS - i,
                                        SECTION_RADIUS - i  );
            border.setColor(BORDER_COLOR);
            add (border);
        }
    }
}