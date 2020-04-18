package br.com.ivanfsilva.tictactoe.core;

import br.com.ivanfsilva.tictactoe.Constants;
import br.com.ivanfsilva.tictactoe.score.ScoreManager;
import br.com.ivanfsilva.tictactoe.ui.Ui;

public class Game {

    private Board board = new Board();
    private Player[] players = new Player[Constants.SYMBOL_PLAYERS.length];
    private int currentPlayerIndex = -1;
    private ScoreManager scoreManager;

    public void play() {
        scoreManager = createScoreManager();

        Ui.printGameTitle();

        for (int i = 0; i < players.length; i++) {
            players[i] = createPlayer(i);
        }

        boolean gameEnded = false;
        Player currentPlayer = nextPlayer();
        Player winner = null;

        while (!gameEnded) {
            board.print();
            boolean sequenceFound = false;

            try {
                sequenceFound = currentPlayer.play();
            } catch (InvalidMoveException e) {
                Ui.printText("ERRO: " + e.getMessage());
                continue;
            }

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
            scoreManager.saveScore(winner);
        }

        board.print();
        Ui.printText("Fim do Jogo!");
    }

    private Player createPlayer(int index) {
        char symbol = Constants.SYMBOL_PLAYERS[index];
        String name = Ui.readInput("Jogador " + (index +1) + " => ");
        Player player = new Player(name, board, symbol);
        Integer score = scoreManager.getScore(player);

        if (score != null) {
            Ui.printText("O jogador '" + player.getName() + "' já possui " + score + " vitória(s)!");
        }

        Ui.printText("O jogador '" + name + "' vai usar o símbolo '" + symbol + "'");

        return player;
    }

    private Player nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        return players[currentPlayerIndex];
    }

    private ScoreManager createScoreManager() {
        // TODO retornar tipo correto

        return null;
    }


}
