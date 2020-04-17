package br.com.ivanfsilva.tictactoe.core;

import br.com.ivanfsilva.tictactoe.Constants;
import br.com.ivanfsilva.tictactoe.ui.Ui;

public class Game {

    private Board board = new Board();
    private Player[] players = new Player[Constants.SYMBOL_PLAYERS.length];

    public void play() {

        Ui.printGameTitle();

        for (int i = 0; i < players.length; i++) {
            players[i] = createPlayer(i);
        }

    }

    private Player createPlayer(int index) {
        char symbol = Constants.SYMBOL_PLAYERS[index];
        String name = Ui.readInput("Jogador " + (index +1) + " => ");
        Player player = new Player(name, board, symbol);
        Ui.printText("O jogador '" + name + "' vai usar o símbolo '" + symbol + "'");

        return player;
    }
}
