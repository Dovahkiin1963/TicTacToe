package com.tictactoe.tictactoe;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.app.AlertDialog;

public class PlayGameActivity extends AppCompatActivity {
    private ImageButton iButton;
    private int currentColor = R.drawable.circle_blue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /*** Called when the user wants to resign */
    public void resign(View view) {
        /* Pour tous les bouttons de jeu */

        iButton = (ImageButton) findViewById(R.id.imageButton1);
        iButton.setImageResource(R.drawable.circle_blank);
        iButton.setTag(R.drawable.circle_blank);
        iButton.setClickable(true);

        iButton = (ImageButton) findViewById(R.id.imageButton2);
        iButton.setImageResource(R.drawable.circle_blank);
        iButton.setTag(R.drawable.circle_blank);
        iButton.setClickable(true);

        iButton = (ImageButton) findViewById(R.id.imageButton3);
        iButton.setImageResource(R.drawable.circle_blank);
        iButton.setTag(R.drawable.circle_blank);
        iButton.setClickable(true);

        iButton = (ImageButton) findViewById(R.id.imageButton4);
        iButton.setImageResource(R.drawable.circle_blank);
        iButton.setTag(R.drawable.circle_blank);
        iButton.setClickable(true);

        iButton = (ImageButton) findViewById(R.id.imageButton5);
        iButton.setImageResource(R.drawable.circle_blank);
        iButton.setTag(R.drawable.circle_blank);
        iButton.setClickable(true);

        iButton = (ImageButton) findViewById(R.id.imageButton6);
        iButton.setImageResource(R.drawable.circle_blank);
        iButton.setTag(R.drawable.circle_blank);
        iButton.setClickable(true);

        iButton = (ImageButton) findViewById(R.id.imageButton7);
        iButton.setImageResource(R.drawable.circle_blank);
        iButton.setTag(R.drawable.circle_blank);
        iButton.setClickable(true);

        iButton = (ImageButton) findViewById(R.id.imageButton8);
        iButton.setImageResource(R.drawable.circle_blank);
        iButton.setTag(R.drawable.circle_blank);
        iButton.setClickable(true);

        iButton = (ImageButton) findViewById(R.id.imageButton9);
        iButton.setImageResource(R.drawable.circle_blank);
        iButton.setTag(R.drawable.circle_blank);
        iButton.setClickable(true);
    }

    /** Called when the user clicks the image button */
    public void play(View view) {
        /* Trouver le boutton sur le quel on a cliqué */
        iButton = (ImageButton) findViewById(view.getId());

        /* Mettre la couleur courante et désactiver le boutton */
        iButton.setImageResource(currentColor);
        iButton.setTag(currentColor);
        iButton.setClickable(false);

        /* Changer la couleur courante pour le prochain click */
        if (currentColor == R.drawable.circle_blue) {
            currentColor = R.drawable.circle_red;
        } else {
            currentColor = R.drawable.circle_blue;
        }

        if (checkPlayer1Wins(view)) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle(getString(R.string.win_title));
            alertDialog.setMessage(getString(R.string.win_player1));
            alertDialog.setIcon(R.drawable.circle_blue);
            alertDialog.show();

            resign(view);
        }

        if (checkPlayer2Wins(view)) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle(getString(R.string.win_title));
            alertDialog.setMessage(getString(R.string.win_player2));
            alertDialog.setIcon(R.drawable.circle_red);
            alertDialog.show();

            resign(view);
        }
    }

    /** Check if the player one is winning */
    public boolean checkPlayer1Wins(View view) {
        // TODO Les tests

        /* Il n'a pas gagné */
        return(false);
    }
    /** Check if the player one is winning */
    public boolean checkPlayer2Wins(View view) {
        // TODO Les tests

        /* Il n'a pas gagné */
        return(false);
    }
}
