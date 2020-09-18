package fr.parisnanterre.miage.rps.model;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import java.util.LinkedList;

public class RockPaperScissorsTest {
    RockPaperScissors rps;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;

    @BeforeClass
    public void setupClass() {
        rps = new RockPaperScissors();

        LinkedList<Play> passP1 = new LinkedList<>();
        passP1.add(Play.ROCK);
        passP1.add(Play.ROCK);
        passP1.add(Play.PAPER);
        passP1.add(Play.SCISSORS);

        LinkedList<Play> passP2 = new LinkedList<>();
        passP2.add(Play.SCISSORS);
        passP2.add(Play.SCISSORS);
        passP2.add(Play.PAPER);
        passP2.add(Play.ROCK);

        LinkedList<Play> passP3 = new LinkedList<>();
        passP3.add(Play.ROCK);
        passP3.add(Play.ROCK);
        passP3.add(Play.PAPER);
        passP3.add(Play.ROCK);

        LinkedList<Play> passP4 = new LinkedList<>();
        passP4.add(Play.PAPER);
        passP4.add(Play.PAPER);
        passP4.add(Play.PAPER);
        passP4.add(Play.ROCK);

        player1 = new Player("Player 1", passP1);
        player2 = new Player("Player 2", passP2);
        player3 = new Player("Player 3", passP3);
        player4 = new Player("Player 4", passP4);
    }


    @AfterClass
    public void tearDownClass() {
        rps = null;
        player1 = player2 = player3 = player4 = null;
    }

    @Test
    public void testPlayerWin() {
        assertEquals(rps.play(player1, player2), Result.WIN);
    }

    @Test
    public void testPlayerTie() {
        assertEquals(rps.play(player1, player3), Result.TIE);
    }

    @Test
    public void testPlayerLoose() {
        assertEquals(rps.play(player1, player4), Result.LOST);
    }

    @Test(dataProvider = "getDataPlayWin")
    public void testWinPlay(Play pe1, Play pe2) {
        assertEquals(rps.play(pe1, pe2), Result.WIN);
        assertNotEquals(rps.play(pe1, pe2), Result.TIE);
        assertNotEquals(rps.play(pe1, pe2), Result.LOST);
    }

    @Test(dataProvider = "getDataPlayTie")
    public void testTiePlay(Play pe1, Play pe2) {
        assertEquals(rps.play(pe1, pe2), Result.TIE);
        assertNotEquals(rps.play(pe1, pe2), Result.WIN);
        assertNotEquals(rps.play(pe1, pe2), Result.LOST);
    }

    @Test(dataProvider = "getDataPlayLoose")
    public void testLoosePlay(Play pe1, Play pe2) {
        assertEquals(rps.play(pe1, pe2), Result.LOST);
        assertNotEquals(rps.play(pe1, pe2), Result.TIE);
        assertNotEquals(rps.play(pe1, pe2), Result.WIN);
    }

    @DataProvider
    public Object[][] getDataPlayWin() {
        return new Object[][]{
                {Play.PAPER, Play.ROCK},
                {Play.ROCK, Play.SCISSORS},
                {Play.SCISSORS, Play.PAPER}
        };
    }

    @DataProvider
    public Object[][] getDataPlayTie() {
        return new Object[][]{
                {Play.PAPER, Play.PAPER},
                {Play.ROCK, Play.ROCK},
                {Play.SCISSORS, Play.SCISSORS}
        };
    }

    @DataProvider
    public Object[][] getDataPlayLoose() {
        return new Object[][]{
                {Play.PAPER, Play.SCISSORS},
                {Play.ROCK, Play.PAPER},
                {Play.SCISSORS, Play.ROCK}
        };
    }
}
