package com.shpp.p2p.cs.yyefimov.assignment2;

import com.shpp.cs.a.console.TextProgram;

/*
* Class Assignment2Part1 reading arguments a,b,c from console for square equation (a*x^2 + b*x + c = 0), than
* solving the equation and write answer to console.
* */

public class Assignment2Part1 extends TextProgram {
    // We will solve equation in method run() .
    public void run() {
        // This method receiving another method like argument. So we are resolving and reading data in one line.
    // This method receiving another method like argument. So we are resolving and reading data in one line.
        solveEquation(readDataFromConsole());
    }

    // Method will get determinant and send it for further solving.
    private void solveEquation(double[] args) {
        double determinant;
        /*
            We received an array to our method.
        *   a = args[0], b = args[1], c = args[2]
            determinant = b^2 - 4ac
        * */
        determinant = args[1] * args[1] - 4 * args[0] * args[2];
        /*
        *   Printing our roots. Third argument is array what was returned from getRoots() method
        *   which consist of our roots.
        * */
        printRoots(args[0], determinant, getRoots(determinant, args));
    }

    // Method will get roots and return them like an array.
    private float[] getRoots(double determinant, double[] args) {
        /*  Array what consist of our roots.
        *   x1 = roots[0], x2 = root[1]
        *   Then we can find a roots.
        **/
        float[] roots = new float[2];
        // Our equation square or linear? So we're will find roots in different ways.
        if (args[0] != 0) {
            roots[0] = (float) ((args[1] * (-1) + Math.sqrt(determinant)) / (2 * args[0]));
            roots[1] = (float) ((args[1] * (-1) - Math.sqrt(determinant)) / (2 * args[0]));
        }
        else roots[0] = (float) ((-args[2])/args[1]);
        return roots;
    }

    // Method for printing roots to console.
    private void printRoots(double a, double determinant, float[] roots) {
        /*
        * There is some amount of cases, such as
        * a ==0 or a != 0
        * determinant > 0 or determinant < 0
        * Also we need to handle Infinity and NaN in these roots cases.
        * */
        if (a != 0 && determinant > 0) {
            println("There are two roots: " + roots[0] +" and " + roots[1]);
        }
        else if (determinant < 0) {
            println("There are no real roots");
        }
        else printAnswersForSpecialCases(roots);
    }

    // Method for printing special cases of our equation.
    private void printAnswersForSpecialCases( float[] roots) {
        // Fixing -0.0 to 0.0.
        if(roots[0] == 0)
            println("There is one root: " + 0);
        else {
            if (Double.isNaN(roots[0]) ) {
                // We will not go in to math analyse so any roots will cover all cases.
                println("Root is any number.");
            }
            else if (Double.isInfinite(roots[0])) {
                // we can't make division on zero, so no roots.
                println("There is no roots.");
            }
            else println("There is one root: " + roots[0]);
        }
    }

    // Method will read a,b,c from console.
    private double[] readDataFromConsole() {
        /*
        * We're reading a,b,c from console and return an array[3] = {a,b,c}.
        * */
        double[] args = new double[3];
        /*
            Reading data from console.
        *   97 == 'a', 98 == 'b', 99 == 'c'
        * */
        for (int i = 0; i < 3; i++) {
            char c = (char) (97 + i);
            args[i] = readDouble("Please enter " + c +": ");
        }
        return args;
    }
}