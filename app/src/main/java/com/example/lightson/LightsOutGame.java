package com.example.lightson;

import java.util.Random;

public class LightsOutGame {


    public static final int NUM_COL = 3, NUM_ROW = 3;

    // the lights that make up the grid
    private boolean[][] lights;

    public LightsOutGame () {lights = new boolean[NUM_ROW][NUM_COL];}

    // Start each new game by randomizing a grid to display
    public void newGame() {
        Random randomGenerator = new Random();
        for (int row = 0; row < NUM_ROW; row++){
            for (int col = 0; col < NUM_COL; col++){
                lights[row][col] = randomGenerator.nextBoolean();
            }
        }
    }

    // returns true if the light is on or false if light is off
    public boolean isLightOn(int row, int col) {
        return lights[row][col];
    }

    // inverts lights based on the selected light/button
    public void selectLight(int row, int col) {
        lights[row][col] = !lights[row][col];

        if (row > 0) {
            lights[row-1][col] = !lights[row-1][col];
        }
        if (row < NUM_ROW - 1) {
            lights[row+1][col] = !lights[row+1][col];
        }
        if (col > 0) {
            lights[row][col-1] = !lights[row][col-1];
        }
        if (col < NUM_COL - 1){
            lights[row][col+1] = !lights[row][col+1];
        }
    }

    // returns true if the game is over, false if game is not over
    public boolean isGameOver() {
        for (int row = 0; row < NUM_ROW; row++){
            for (int col = 0; col < NUM_COL; col++){
                if(lights[row][col]){
                    return false;
                }
            }
        }
        return true;
    }

}
