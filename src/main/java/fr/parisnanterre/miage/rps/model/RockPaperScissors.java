package fr.parisnanterre.miage.rps.model;

public class RockPaperScissors {


    Result play(Player player1, Player player2) {
        return Result.LOST;
    }

    // méthode 1 à tester
    Result play(Play play1, Play play2) {
        if (play1 == play2) {
            return Result.TIE;
        }
        if ((play1 == Play.PAPER) && (play2 == Play.ROCK)) {
            return Result.WIN;
        }
        if ((play1 == Play.ROCK) && (play2 == Play.SCISSORS)) {
            return Result.WIN;
        }
        if ((play1 == Play.SCISSORS) && (play2 == Play.PAPER)) {
            return Result.WIN;
        }
        return Result.LOST;
    }

}

