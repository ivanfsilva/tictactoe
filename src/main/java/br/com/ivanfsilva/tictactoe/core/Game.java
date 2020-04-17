package br.com.ivanfsilva.tictactoe.core;

import br.com.ivanfsilva.tictactoe.Constants;
import br.com.ivanfsilva.tictactoe.ui.Ui;

public class Game {

    private Board board = new Board();
    private Player[] players = new Player[Constants.SYMBOL_PLAYERS.length];
    private int currentPlayerIndex = -1;

    public void play() {

        Ui.printGameTitle();

        for (int i = 0; i < players.length; i++) {
            players[i] = createPlayer(i);
        }

        boolean gameEnded = false;
        Player currentPlayer = nextPlayer();
        Player winner = null;

        while (!gameEnded) {
            board.print();
            boolean sequenceFound = currentPlayer.play();

            if (sequenceFound) {
                gameEnded = true;
                winner = currentPlayer;
            } else if (board.isFull()) {
                gameEnded = true;
            }
            currentPlayer = nextPlayer();
        }
        if (winner == null) {
            Ui.printText("O jogo terminou empatado!");
        } else {
            Ui.printText("O ganhador '" + winner.getName() + "' venceu o jogo!");
        }

        board.print();
        Ui.printText("Fim do Jogo!");
    }

    private Player createPlayer(int index) {
        char symbol = Constants.SYMBOL_PLAYERS[index];
        String name = Ui.readInput("Jogador " + (index +1) + " => ");
        Player player = new Player(name, board, symbol);
        Ui.printText("O jogador '" + name + "' vai usar o símbolo '" + symbol + "'");

        return player;
    }
}
