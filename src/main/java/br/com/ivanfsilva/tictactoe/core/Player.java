package br.com.ivanfsilva.tictactoe.core;

import br.com.ivanfsilva.tictactoe.ui.Ui;

public class Player {

    private String name;
    private Board board;
    private char symbol;

    public Player(String name, Board board, char symbol) {
        this.name = name;
        this.board = board;
        this.symbol = symbol;
    }

    private Move inputMove() {
        String moveStr = Ui.readInput("Jogador '" + name + "' =>");
        return new Move(moveStr);
    }

    public boolean play() {
        Move move = inputMove();
        return board.play(this, move);
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

    public char getSymbol() {
        return symbol;
    }
}
