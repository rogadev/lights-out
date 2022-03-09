package com.example.lightson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    private LightsOutGame mGame;
    private Button[][] mButtons;
    private int mOnColor;
    private int mOffColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOnColor = ContextCompat.getColor(this, R.color.yellow);
        mOffColor = ContextCompat.getColor(this, R.color.dark);

        mButtons = new Button[LightsOutGame.NUM_ROW][LightsOutGame.NUM_COL];

        GridLayout gridLayout = findViewById(R.id.lightGrid);
        int childIndex = 0;
        for (int row = 0; row < LightsOutGame.NUM_ROW; row++) {
            for (int col = 0; col < LightsOutGame.NUM_COL; col++) {
                mButtons[row][col] = (Button) gridLayout.getChildAt(childIndex);
                childIndex++;
            }
        }

        mGame = new LightsOutGame();
        startGame();
    }

    private void startGame() {
        mGame.newGame();
        setButtonColors();
    }

    public void onLightButtonClick (View view) {
        // find the row and column of the selected button
        boolean buttonFound = false;
        for (int row = 0; row < LightsOutGame.NUM_ROW && !buttonFound; row++){
            for (int col = 0; col < LightsOutGame.NUM_COL && !buttonFound; col++){
                if (view == mButtons[row][col]){
                    mGame.selectLight(row, col);
                    buttonFound=true;
                }
            }
        }
        setButtonColors();
    }

    public void startNewGame(View view) {
        startGame();
    }

    public void setButtonColors() {
        for (int row = 0; row < LightsOutGame.NUM_ROW; row++){
            for (int col = 0; col < LightsOutGame.NUM_COL; col++){
                if(mGame.isLightOn(row, col)){
                    mButtons[row][col].setBackgroundColor(mOnColor);
                } else {
                    mButtons[row][col].setBackgroundColor(mOffColor);
                }
            }
        }
    }

}