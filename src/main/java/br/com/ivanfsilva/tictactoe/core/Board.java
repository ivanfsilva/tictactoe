package br.com.ivanfsilva.tictactoe.core;

import br.com.ivanfsilva.tictactoe.Constants;
import br.com.ivanfsilva.tictactoe.ui.Ui;

public class Board {

    private char[][] matrix;

    public Board() {
        matrix = new char[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
        clear();
    }

    public void clear() {
        for (int i = 0; i < matrix.length; i++) {         // linhas
            for (int j = 0; j < matrix[i].length; j++) {  // colunas
                matrix[i][j] = ' ';
            }
        }
    }

    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                Ui.printTextWithNoNewLine(String.valueOf(matrix[i][j]));
                if (j < matrix[i].length -1) {
                    Ui.printTextWithNoNewLine(" | ");
                }
            }
            Ui.printNewLine();
            if (i < matrix.length - 1) {
                Ui.printText("---------------");
            }
        }
    }

    public boolean isFull() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean play(Player player, Move move) {
        int i = move.getI();
        int j = move.getJ();

        matrix[i][j] = player.getSymbol();

        // TODO Checar se o jogador ganhou
        return false;
    }
}
