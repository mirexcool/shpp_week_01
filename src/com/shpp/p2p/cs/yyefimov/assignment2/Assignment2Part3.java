package com.shpp.p2p.cs.yyefimov.assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*  Class Assignment2Part3 will draw pawprints on display. */

public class Assignment2Part3 extends WindowProgram {
    /** Constants controlling the relative positions of the
     * three toes to the upper-left corner of the pawprint.
     *
     * (Yes, I know that actual pawprints have four toes.
     * Just pretend it's a cartoon animal. ^_^)
     */
    private static final double     FIRST_TOE_OFFSET_X      = 0;
    private static final double     FIRST_TOE_OFFSET_Y      = 20;
    private static final double     SECOND_TOE_OFFSET_X     = 30;
    private static final double     SECOND_TOE_OFFSET_Y     = 0;
    private static final double     THIRD_TOE_OFFSET_X      = 60;
    private static final double     THIRD_TOE_OFFSET_Y      = 20;

    //  Number of toes. Here is strictly value of 3.
    public static final int         NUMBERS_OF_TOES         = 3;

    //  We better code we will put offsets into [][] array.
    public static final double[][]  TOES_OFFSETS            = { { FIRST_TOE_OFFSET_X,   FIRST_TOE_OFFSET_Y  },
                                                                { SECOND_TOE_OFFSET_X,  SECOND_TOE_OFFSET_Y },
                                                                { THIRD_TOE_OFFSET_X,   THIRD_TOE_OFFSET_Y  } };

    /** The position of the heel relative to the upper-left
     * corner of the pawprint.
     */
    private static final double     HEEL_OFFSET_X           = 20;
    private static final double     HEEL_OFFSET_Y           = 40;

    /** Each toe is an oval with this width and height. */
    private static final double     TOE_WIDTH               = 20;
    private static final double     TOE_HEIGHT              = 30;

    /** The heel is an oval with this width and height. */
    private static final double     HEEL_WIDTH              = 40;
    private static final double     HEEL_HEIGHT             = 60;

    /** The default width and height of the window. These constants will tell Java to
     * create a window whose size is *approximately* given by these dimensions. You should
     * not directly use these constants in your program; instead, use getWidth() and
     * getHeight(), which return the *exact* width and height of the window.
     */
    public static final int APPLICATION_WIDTH = 270;
    public static final int APPLICATION_HEIGHT = 220;

    /*
     * Method will create pawprints.
     */
    public void run() {
        drawPawprint(20, 20);
        drawPawprint(180, 70);
    }

    /**
     * Draws a pawprint. The parameters should specify the upper-left corner of the
     * bounding box containing that pawprint.
     *
     * @param x The x coordinate of the upper-left corner of the bounding box for the pawprint.
     * @param y The y coordinate of the upper-left corner of the bounding box for the pawprint.
     */
    private void drawPawprint(double x, double y) {
        // We split our work for two parts.
        drawTheHeel(x,y);
        drawEachToe(x,y);
    }

    /*
     * Method creating each GOval Object (toe) with correct offset.
     * We have defined offset for each toe above our Class.
     * */
    private void drawEachToe(double x, double y) {
        GOval[] toes = new GOval[NUMBERS_OF_TOES];
        // We have all constants for each toe, so we can just put it to right place.
        for (int i = 0; i < NUMBERS_OF_TOES; i++) {
            toes[i] = new GOval(x + TOES_OFFSETS[i][0], y + TOES_OFFSETS[i][1], TOE_WIDTH, TOE_HEIGHT);
        }
        addToes(toes);
    }

    /*
    * Method adds each toe on our window. Before adding fill it with color.
    * */
    private void addToes(GOval[] toes) {
        // We have three toes, so we will create each separately.
        for (int i = 0; i < NUMBERS_OF_TOES; i++) {
            toes[i].setFilled(true);
            toes[i].setFillColor(Color.BLACK);
            add(toes[i]);
        }
    }

    /*
     * Method will create a GOval Object with correct position which we're receiving like parameters x,y and apply
     * offset from constants.
     * */
    private void drawTheHeel(double x, double y) {
        // Method what will receive GOval Object with right position and after that will fill it and make right colors.
        addHell(new GOval(x + HEEL_OFFSET_X,y + HEEL_OFFSET_Y,HEEL_WIDTH, HEEL_HEIGHT));
    }

    /*
     * Method making filling and color, then adds Object on the Window.
     * */
    private void addHell(GOval heel) {
        heel.setFilled(true);
        heel.setFillColor(Color.BLACK);
        add(heel);
    }
}