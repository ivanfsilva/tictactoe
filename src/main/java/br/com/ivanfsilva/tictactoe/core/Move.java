package br.com.ivanfsilva.tictactoe.core;

public class Move {

    private int i;
    private int j;

    public Move(String moveStr) {

        // "1 , 2"
        // [ "1" , "2" ]
        String[] tokens = moveStr.split(",");

        this.i = Integer.parseInt(tokens[0]);
        this.j = Integer.parseInt(tokens[1]);

        // TODO Validar se a estrutura do moveStr está correta
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
