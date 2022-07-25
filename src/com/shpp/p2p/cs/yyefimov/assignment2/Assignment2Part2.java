package com.shpp.p2p.cs.yyefimov.assignment2;

import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
* Class Assignment2Part2 will draw 4 circles and one rectangular which will put on these circles.
* */

public class Assignment2Part2 extends WindowProgram {
    //  Java will use APPLICATION_WIDTH and APPLICATION_HEIGHT to create window with this size.
    public static final int     APPLICATION_WIDTH   = 500;
    public static final int     APPLICATION_HEIGHT  = 500;

    //  We can set radius of circle here.
    public static final double  CIRCLE_RADIUS       = 102;
    // We will define a numbers of circles what we need for our work. It's number integer with value 4.
    public static final int     NUMBERS_OF_CIRCLES  = 4;
    /*
    * This offset we need cause of nature of our screen. We need to make offset from down and right side of window.
    * Counting pixels starts from 0.
    * */
    public static final double  OFFSET_X            = 1;
    public static final double  OFFSET_Y            = 1;

    // Method will solve our problem.
    public void run() {
        // Split our work for 2 parts. First we will draw circles and after that rectangle.
        drawCircles(getWidth(), getHeight());
        drawRectangular(getWidth(), getHeight());
    }

    //  Method draws rectangle.
    private void drawRectangular(int width, int height) {
        // We are adding to argument the function which return an Object type GRect.
        add(createRectangular(width, height));
    }

    //  Method creates rectangle with right parameters.
    private GRect createRectangular(int width, int height) {
        /*
        * Each corner of the rectangle need to be in the center of each circle. Then fill it and change border color
        * and add it after adding of circles.
        * */
        GRect rectangular = new GRect   (CIRCLE_RADIUS / 2,
                                        CIRCLE_RADIUS / 2,
                                        width - CIRCLE_RADIUS,
                                        height - CIRCLE_RADIUS);
        rectangular.setFilled(true);
        rectangular.setFillColor(Color.WHITE);
        rectangular.setColor(Color.WHITE);
        return rectangular;
    }

    // Method draws circles.
    private void drawCircles(int width, int height) {
        /*
        * We have an array of the same Objects what was returned from createCircles() method. Then we need to create the
        * method what will add each circle to window (addCircles()) what accepts an array of GOval Objects.
        * So we create an array in method what we send like argument to addCircles().
        * */
        addCircles(createCircles(width, height));
    }

    //  Method sets parameters and adds circles on the window.
    private void addCircles(GOval[] circles) {
        // We have 4 circles in our case, so we are creating each circle, fill it and add to window.
        for (int i = 0; i < NUMBERS_OF_CIRCLES; i++) {
            circles[i].setFilled(true);
            circles[i].setFillColor(Color.BLACK);
            add(circles[i]);
        }
    }

    //  Method creates circles with parameters what we need.
    private GOval[] createCircles(int width, int height) {
        // Initialising an array of GOval Objects.
        GOval[] circles = new GOval[4];
        // Every circle should be aligned to each corner of the window.
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                circles[2 * i + j] = new GOval  ((width - CIRCLE_RADIUS - OFFSET_X) * i,
                                                (height - CIRCLE_RADIUS - OFFSET_Y) * j,
                                                    CIRCLE_RADIUS,
                                                    CIRCLE_RADIUS);

            }
        }
        // Return an array of circles.
        return circles;
    }
}