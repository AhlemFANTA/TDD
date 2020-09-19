package fr.parisnanterre.miage.rps.model;

public class RockPaperScissors {

    // méthode play à tester
    Result play(Play play1, Play play2) {
        return play1 == play2 ? Result.TIE
                : (play1 == Play.PAPER) && (play2 == Play.ROCK)
                || (play1 == Play.ROCK) && (play2 == Play.SCISSORS)
                || (play1 == Play.SCISSORS) && (play2 == Play.PAPER) ? Result.WIN
                : Result.LOST;
    }

    Result round(Player player1, Player player2) {
        Play moveP1 = player1.getNextMove();
        Play moveP2 = player2.getNextMove();
        while ((moveP1 != null) && (moveP2 != null)) {
            Result res = play(moveP1, moveP2);
            switch (res) {
                case WIN -> player1.setScore(player1.getScore() + 1);
                case LOST -> player2.setScore(player2.getScore() + 1);
                default -> {
                    player1.setScore(player1.getScore() + 1);
                    player2.setScore(player2.getScore() + 1);
                }
            }
            moveP1 = player1.getNextMove();
            moveP2 = player2.getNextMove();
        }
        return player1.getScore() == player2.getScore() ? Result.TIE : player1.getScore() < player2.getScore() ? Result.LOST : Result.WIN;
    }

}

