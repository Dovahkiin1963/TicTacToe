package com.tictactoe.tictactoe;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.app.AlertDialog;

public class PlayGameActivity extends AppCompatActivity {
    private ImageButton iButton;
    private int [] idButtons = new int[] {R.id.imageButton1, R.id.imageButton2, R.id.imageButton3,
            R.id.imageButton4, R.id.imageButton5, R.id.imageButton6,
            R.id.imageButton7, R.id.imageButton8, R.id.imageButton9};
    private int currentColor = R.drawable.circle_blue;
    private int [] leJeu = new int[9];
    private int idAtrouver, positionDansLeJeu;
    private Button resign;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /* Préparer le jeu */
        createGame();
    }

    /*** Called to prepare the game */
    public void createGame() {
        // Mettre tous les bouttons sur blanc
        for (int i : idButtons) {
            iButton = (ImageButton) findViewById(i);
            iButton.setImageResource(R.drawable.circle_blank);
            iButton.setTag(R.drawable.circle_blank);
            iButton.setClickable(true);
        }

        // Mettre le tableau de jeu sur valeur initiale
        for (int i=0 ; i<leJeu.length ; i++) {
            leJeu[i] = R.drawable.circle_blank;
        }

        resign = (Button) findViewById(R.id.resign);
        resign.setVisibility(View.GONE);
    }

    /*** Called when the user wants to resign */
    public void resign(View view) {
        createGame();

        // TODO: le reste du resign
    }

    /** Called when the user clicks the image button */
    public void play(View view) {
        /* Trouver le boutton sur le quel on a cliqué */
        iButton = (ImageButton) findViewById(view.getId());

        /* Mettre la couleur courante et désactiver le boutton */
        iButton.setImageResource(currentColor);
        iButton.setTag(currentColor);
        iButton.setClickable(false);

        /* Trouver la position du boutton dans le tableau */
        idAtrouver = view.getId();
        positionDansLeJeu = -1;
        for (int i=0 ; i<idButtons.length ; i++) {
            /* Est-ce le boutton courant ? */
            if (idButtons[i] == idAtrouver) {
                positionDansLeJeu = i;
                break;
            }
        }
        /* Position trouvée, alors la marquer avec le joueur courant */
        if (positionDansLeJeu != -1)
            leJeu[positionDansLeJeu] = currentColor;

        if (checkPlayerWins(R.drawable.circle_blue)) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle(getString(R.string.win_title));
            alertDialog.setMessage(getString(R.string.win_player1));
            alertDialog.setPositiveButton(R.string.return_game, null);
            alertDialog.setIcon(R.drawable.win);
            alertDialog.show();

            resign = (Button) findViewById(R.id.resign);
            resign.setVisibility(View.VISIBLE);
        }

        if (checkPlayerWins(R.drawable.circle_red)) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle(getString(R.string.win_title));
            alertDialog.setMessage(getString(R.string.win_player2));
            alertDialog.setPositiveButton(R.string.return_game, null);
            alertDialog.setIcon(R.drawable.win);
            alertDialog.show();

            resign = (Button) findViewById(R.id.resign);
            resign.setVisibility(View.VISIBLE);
        }
        // TODO: Check si plus possible de jouer

        /* Changer la couleur courante pour le prochain click */
        if (currentColor == R.drawable.circle_blue) {
            currentColor = R.drawable.circle_red;
        } else {
            currentColor = R.drawable.circle_blue;
        }

    }

    /** Check if the player passed as parameter is winning */
    public boolean checkPlayerWins(int quelJoueur) {
        // TODO Les tests
        /* Comparer leJeu avec le joueur passé en quelJoueur */
        if (leJeu[0] == quelJoueur && leJeu[1] == quelJoueur && leJeu[2] == quelJoueur) return(true);
        if (leJeu[0] == quelJoueur && leJeu[4] == quelJoueur && leJeu[8] == quelJoueur) return(true);
        if (leJeu[0] == quelJoueur && leJeu[3] == quelJoueur && leJeu[6] == quelJoueur) return(true);
        if (leJeu[1] == quelJoueur && leJeu[4] == quelJoueur && leJeu[7] == quelJoueur) return(true);
        if (leJeu[2] == quelJoueur && leJeu[5] == quelJoueur && leJeu[8] == quelJoueur) return(true);
        if (leJeu[2] == quelJoueur && leJeu[4] == quelJoueur && leJeu[6] == quelJoueur) return(true);
        if (leJeu[3] == quelJoueur && leJeu[4] == quelJoueur && leJeu[5] == quelJoueur) return(true);
        if (leJeu[6] == quelJoueur && leJeu[7] == quelJoueur && leJeu[8] == quelJoueur) return(true);

        /* Il n'a pas gagné */
        return(false);
    }

}
