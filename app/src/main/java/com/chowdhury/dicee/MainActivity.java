package com.chowdhury.dicee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton;

        //Links the button in the layout xml to the java code
        rollButton= (Button) findViewById(R.id.rollButton);

        //Links the image views in the layout xml to the java code

        final ImageView leftDice=(ImageView) findViewById(R.id.image_leftDice);

        final ImageView rightDice=(ImageView) findViewById(R.id.image_rightDice);

        //Store the drawable image in an array(collection)
        final int[] diceArray= {
                R.drawable.dice1, R.drawable.dice2,
                R.drawable.dice3, R.drawable.dice4,
                R.drawable.dice5, R.drawable.dice6

        };
        //Tells the button to listen for clicks
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Dicee","Ze button has been pressed");

                //Creates a random number generator
                Random randomNumberGenerator=new Random();

                //Make the random number generator spit out a new random number with upper bound 6
                int number=randomNumberGenerator.nextInt(6);

                //Prints this random number in the logcat to see it in the Android monitor
                Log.d("Dicee","Random number generated "+number);

                //grabs a random dice image from the dice array. Then tell the imageview
                //to view this image
                leftDice.setImageResource(diceArray[number]);

                //creates a new random number
                number=randomNumberGenerator.nextInt(6);

                //Set the right dice image using an image from the diceArray
                rightDice.setImageResource(diceArray[number]);
            }
        });
    }
}
