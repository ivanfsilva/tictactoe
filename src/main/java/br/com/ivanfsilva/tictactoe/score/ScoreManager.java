package br.com.ivanfsilva.tictactoe.score;

import br.com.ivanfsilva.tictactoe.core.Player;

public interface ScoreManager {
    public Integer getScore(Player player);

    public void saveScore(Player player);
}
