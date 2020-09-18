package fr.parisnanterre.miage.rps.model;
import java.util.List;
import java.util.Random;

// les 3 possibilités
public enum Play {
    ROCK,PAPER,SCISSORS;

    private static final List<Play> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Play randomPlay() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
