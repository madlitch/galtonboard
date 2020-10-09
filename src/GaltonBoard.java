/*  SOFE2715U | 2020
    Final Project: Galton Board
    GaltonBoard.java
    Massimo Albanese - 100616057
    © 2020 ALL RIGHTS RESERVED  */

import java.util.Random;

public class GaltonBoard {

    public static void main(String[] args) {
        int balls = 1000;                                                                                               // inputs
        int size = 20;
        PinGraph pins = new PinGraph(size);
        int[] bins = compute(pins, size, balls);                                                                        // calls compute function, returns array of 'bins'
        for (int bin : bins)                                                                                            // iterates through each bin and prints amount of balls in each one
            System.out.println(bin);
    }

    private static int[] compute(PinGraph pins, int size, int balls) {                                                  // iteratively goes through each ball dropped and calls the 'findBin' function
        int[] bins = new int[size];
        for (int i = 1; i <= balls; i++)
            bins[findBin(0, pins) - 1]++;
        return bins;
    }

    private static int findBin(int index, PinGraph pins) {                                                              // recursive method that chooses a random direction, left or right, when a ball falls on a pin
        Random random = new Random();
        if (pins.getBin(index) != 0)                                                                                    // base case for when it reaches final layer
            return pins.getBin(index);
        else if (random.nextInt(2) == 1)                                                                        // gets a random number between 1 and 2
            return findBin(pins.getLeft(index), pins);
        else
            return findBin(pins.getRight(index), pins);
    }
}







