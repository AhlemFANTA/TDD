package fr.parisnanterre.miage.rps.model;

import java.util.LinkedList;
import java.util.List;

public class Player {
    private final String name;
    private int score;
    private List<Play> pass = new LinkedList<>();
    private int passPointer = 0;
    private static final int NB_PASS = 7;

    public Player(String name, List<Play> pass) {
        this.name = name;
        this.score = 0;
        this.pass = pass;
    }

    public Player(String name) {
        this.name = name;
        this.score = 0;
        for (int i = 0; i < NB_PASS; i++)
            this.pass.add(Play.randomPlay());
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Play getNextPass() {
        try {
            return this.pass.get(++this.passPointer);
        } catch (Exception e) {
            return null;
        }
    }


}
