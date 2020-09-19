package fr.parisnanterre.miage.rps.model;

import java.util.ArrayList;
import java.util.List;

public class PlayGenerator {
    private static Play generateFor(int nb) {
        return switch (nb) {
            case 0 -> Play.ROCK;
            case 1 -> Play.PAPER;
            default -> Play.SCISSORS;
        };
    }

    private static Play generatePlay() {
        int x = (int) (Math.random() * 3);
        return generateFor(x);
    }

    public static List<Play> generatePlays(int taille) {
        List<Play> rtr = new ArrayList<>(taille);
        for (int i = 0; i < taille; i++) {
            rtr.add(generatePlay());
        }
        return rtr;
    }
}