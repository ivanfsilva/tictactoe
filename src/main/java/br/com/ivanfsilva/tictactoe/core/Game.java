package br.com.ivanfsilva.tictactoe.core;

import br.com.ivanfsilva.tictactoe.Constants;
import br.com.ivanfsilva.tictactoe.ui.Ui;

public class Game {

    private Board board = new Board();
    private Player[] players = new Player[Constants.SYMBOL_PLAYERS.length];

    public void play() {

        Ui.printGameTitle();


        board.print();

    }


}
