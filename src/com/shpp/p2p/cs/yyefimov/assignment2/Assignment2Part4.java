package com.shpp.p2p.cs.yyefimov.assignment2;

import acm.graphics.*;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
* This Class is drawing the flag(2-3 color). You can choose the flag what you want to draw by parameters below (
* FLAG_IS_VERTICAL, FLAG_SECTIONS, FIRST_COLOR etc.).
* */
public class Assignment2Part4 extends WindowProgram {
    /*
    * Here we can define some colors for our program.
    * */
    private static final Color          CARDINAL_RED            = new Color(196, 30, 58);

    /*
    * Windows size can be set here by these parameters.
    * */
    public static final int             APPLICATION_WIDTH       = 700;
    public static final int             APPLICATION_HEIGHT      = 550;

    /*
     *  Define the type of our flag. It can consist of vertical section (FLAG_IS_VERTICAL = true) or
     *  horizontal section (FLAG_IS_VERTICAL = false).
     * */
    public static final boolean         FLAG_IS_VERTICAL        = false;

    /*
    * For each section of our flag we need to define it color. We can choose 1,2,3 for FLAG_SECTIONS.
    * */
    public static final int             FLAG_SECTIONS           = 3;
    public static final Color           FIRST_COLOR             = new Color(0, 0, 255);
    public static final Color           SECOND_COLOR            = new Color(255, 0, 255);
    public static final Color           THIRD_COLOR             = new Color(0, 255, 0);

    /*
    * The size of our flag.
    * */
    public static final double          FLAG_WIDTH              = 300;
    public static final double          FLAG_HEIGHT             = 200;

    /*
    * Label what can consist of country name(COUNTRY_LABEL), font size(FONT_SIZE), font type(FONT_FOR_FLAG_LABEL).
    * */
    public static final String          COUNTRY_LABEL           = "Random";
    public static final int             FONT_SIZE               = 40;
    public static final Font            FONT_FOR_FLAG_LABEL     = GLabel.DEFAULT_FONT;

    /*
    * Method run() will create flag and label.
    * */
    public void run() {
        createFlag();
        createLabel();
    }

    // Method will create adn draw label on the screen.
    private void createLabel() {
        /* The main problem of label is how to place it on the window. After creating the label we will know it size
         * and descent of label. So now we can easy to place our label.
        **/
        GLabel label = new GLabel("Flag of " + COUNTRY_LABEL);
        label.setFont(FONT_FOR_FLAG_LABEL + "-" + FONT_SIZE);
        label.setLocation(getWidth() - label.getWidth(), getHeight() - label.getDescent());
        add(label);
    }

    // Method will create and draw flag.
    private void createFlag() {
        // We know how many parts in our flag and can create each of it.
        for (int i = 0; i < FLAG_SECTIONS; i++) {
            // We have 2 variants of flag. Vertical like Belgium or horizontal like Austria.
            if (FLAG_IS_VERTICAL)
                add(createVerticalFlagSection(i));
            else add(createHorizontalFlagSection(i));
        }
    }

    // Method will draw vertical flags.
    private GRect createVerticalFlagSection(int i) {
        /*
        * We are creating a rectangular GRect. The first coordinates is the center of our map minus hals size of
        * the flag. The size of each section we can find when delete flag_size(width or height) on flag_sections.
        * For next section we need to make offset for amount what occur every flag section (flag_size/flag_sections).
        * */
        GRect sectionOfFlag = new GRect(
                (double) getWidth() / 2 - FLAG_WIDTH / 2 + i * FLAG_WIDTH / FLAG_SECTIONS,
                (double) getHeight() / 2 - FLAG_HEIGHT / 2,
                FLAG_WIDTH / FLAG_SECTIONS,
                FLAG_HEIGHT
        );
        setColors(sectionOfFlag, i);
        return sectionOfFlag;
    }

    // Method will draw horizontal flags.
    private GObject createHorizontalFlagSection(int i) {
        /*
         * We are creating a rectangular GRect. The first coordinates is the center of our map minus hals size of
         * the flag. The size of each section we can find when delete flag_size(width or height) on flag_sections.
         * For next section we need to make offset for amount what occur every flag section (flag_size/flag_sections).
         * */
        GRect sectionOfFlag = new GRect(
                                        (double) getWidth() / 2 - FLAG_WIDTH / 2,
                                        (double) getHeight() / 2 - FLAG_HEIGHT / 2 + i * FLAG_HEIGHT / FLAG_SECTIONS,
                                            FLAG_WIDTH,
                                        FLAG_HEIGHT / FLAG_SECTIONS
                                        );
        setColors(sectionOfFlag, i);
        return sectionOfFlag;
    }

    // Here we will set colors for each section of flag.
    private void setColors(GRect flag, int i) {
        flag.setFilled(true);
        if (i == 0) {
            flag.setFillColor(FIRST_COLOR);
            flag.setColor(FIRST_COLOR);
        }
        else if (i == 1) {
            flag.setFillColor(SECOND_COLOR);
            flag.setColor(SECOND_COLOR);
        }
        else {
            flag.setFillColor(THIRD_COLOR);
            flag.setColor(THIRD_COLOR);
        }
    }

}