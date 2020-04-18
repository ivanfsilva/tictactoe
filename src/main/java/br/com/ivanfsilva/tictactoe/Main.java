package br.com.ivanfsilva.tictactoe;

import br.com.ivanfsilva.tictactoe.core.Game;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Game game = new Game();
        game.play();
    }
}
