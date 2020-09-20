package fr.parisnanterre.miage.rps.model;

import java.util.List;

public class Player {
    private final String name;
    private final List<Play> pass ;
    private int score;
    private int passPointer = 0;

    public Player(String name, List<Play> pass) {
        this.name = name;
        this.pass = pass;
        this.score = 0;
    }
/*
    public Player(String name) {
        this(name, List.of(Play.randomPlay()));
    }*/

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Play getNextMove() {

        if (passPointer< pass.size()){
            Play nextPass = this.pass.get(passPointer);
            ++passPointer;
            return nextPass;
        } else return null;
    }

}
