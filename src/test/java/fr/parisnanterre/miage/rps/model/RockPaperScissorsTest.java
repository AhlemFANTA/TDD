package fr.parisnanterre.miage.rps.model;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import java.util.LinkedList;

public class RockPaperScissorsTest {
    RockPaperScissors rps;

    @BeforeClass
    public void setupClass() {
        rps = new RockPaperScissors();
    }


    @AfterClass
    public void tearDownClass() {
        rps = null;
    }

    @DataProvider
    public Object[][] getWinData() {
        return new Object[][]{
                {Play.PAPER, Play.ROCK},
                {Play.ROCK, Play.SCISSORS},
                {Play.SCISSORS, Play.PAPER}
        };
    }

    @DataProvider
    public Object[][] getTieData() {
        return new Object[][]{
                {Play.PAPER, Play.PAPER},
                {Play.ROCK, Play.ROCK},
                {Play.SCISSORS, Play.SCISSORS}
        };
    }

    @DataProvider
    public Object[][] getLostData() {
        return new Object[][]{
                {Play.PAPER, Play.SCISSORS},
                {Play.ROCK, Play.PAPER},
                {Play.SCISSORS, Play.ROCK}
        };
    }

    @Test(dataProvider = "getWinData")
    public void testWinPlay(Play play1, Play play2) {
        assertEquals(rps.play(play1, play2), Result.WIN);
    }

    @Test(dataProvider = "getTieData")
    public void testTiePlay(Play play1, Play play2) {
        assertEquals(rps.play(play1, play2), Result.TIE);
    }

    @Test(dataProvider = "getLostData")
    public void testLostPlay(Play play1, Play play2) {
        assertEquals(rps.play(play1, play2), Result.LOST);
    }

    @Test
    public void shouldBeWinWhenNoLoss() {
        LinkedList<Play> passP1 = new LinkedList<>();
        passP1.add(Play.ROCK);
        passP1.add(Play.ROCK);
        passP1.add(Play.PAPER);
        passP1.add(Play.SCISSORS);


        LinkedList<Play> passP2 = new LinkedList<>();
        passP2.add(Play.SCISSORS);
        passP2.add(Play.SCISSORS);
        passP2.add(Play.ROCK);
        passP2.add(Play.PAPER);

        Player p1 = new Player("player1", passP1);
        Player p2 = new Player("player2", passP2);

        assertEquals(rps.round(p1, p2), Result.WIN);
    }

    @Test
    public void shouldBeWinWhenWeMoreThanHalfWin() {
        LinkedList<Play> passP3 = new LinkedList<>();
        passP3.add(Play.SCISSORS);
        passP3.add(Play.PAPER);
        passP3.add(Play.ROCK);
        passP3.add(Play.SCISSORS);

        LinkedList<Play> passP4 = new LinkedList<>();
        passP4.add(Play.PAPER);
        passP4.add(Play.ROCK);
        passP4.add(Play.PAPER);
        passP4.add(Play.PAPER);

        Player p1 = new Player("player1", passP3);
        Player p2 = new Player("player2", passP4);

        assertEquals(rps.round(p1, p2), Result.WIN);
    }

    @Test
    public void shouldBeWinWhenWeHaveTieAndOneWin() {
        LinkedList<Play> passP3 = new LinkedList<>();
        passP3.add(Play.SCISSORS);
        passP3.add(Play.PAPER);
        passP3.add(Play.ROCK);
        passP3.add(Play.SCISSORS);

        LinkedList<Play> passP4 = new LinkedList<>();
        passP4.add(Play.SCISSORS);
        passP4.add(Play.ROCK);
        passP4.add(Play.ROCK);
        passP4.add(Play.SCISSORS);

        Player p1 = new Player("player1", passP3);
        Player p2 = new Player("player2", passP4);

        assertEquals(rps.round(p1, p2), Result.WIN);
    }
    @Test
    public void shouldBeWinWhenWeLooseOnlyOneTime() {
        LinkedList<Play> passP3 = new LinkedList<>();
        passP3.add(Play.SCISSORS);
        passP3.add(Play.PAPER);
        passP3.add(Play.ROCK);

        LinkedList<Play> passP4 = new LinkedList<>();
        passP4.add(Play.PAPER);
        passP4.add(Play.ROCK);
        passP4.add(Play.PAPER);

        Player p1 = new Player("player1", passP3);
        Player p2 = new Player("player2", passP4);

        assertEquals(rps.round(p1, p2), Result.WIN);
    }

    @Test
    public void shouldBeTieWhenScoreIsEqual() {
        LinkedList<Play> passP1 = new LinkedList<>();
        passP1.add(Play.ROCK);
        passP1.add(Play.SCISSORS);

        LinkedList<Play> passP2 = new LinkedList<>();
        passP2.add(Play.SCISSORS);
        passP2.add(Play.ROCK);

        Player p1 = new Player("player1", passP1);
        Player p2 = new Player("player2", passP2);

        assertEquals(rps.round(p1, p2), Result.TIE);
    }

    @Test
    public void shouldBeTieWhenScoreAreEqualAndHaveOneTie() {
        LinkedList<Play> passP1 = new LinkedList<>();
        passP1.add(Play.ROCK);
        passP1.add(Play.SCISSORS);
        passP1.add(Play.PAPER);

        LinkedList<Play> passP2 = new LinkedList<>();
        passP2.add(Play.SCISSORS);
        passP2.add(Play.ROCK);
        passP2.add(Play.PAPER);

        Player p1 = new Player("player1", passP1);
        Player p2 = new Player("player2", passP2);

        assertEquals(rps.round(p1, p2), Result.TIE);
    }

    @Test
    public void shouldBeTieWhenAllPassAreTie() {
        LinkedList<Play> passP1 = new LinkedList<>();
        passP1.add(Play.ROCK);
        passP1.add(Play.SCISSORS);
        passP1.add(Play.PAPER);

        LinkedList<Play> passP2 = new LinkedList<>();
        passP2.add(Play.ROCK);
        passP2.add(Play.SCISSORS);
        passP2.add(Play.PAPER);

        Player p1 = new Player("player1", passP1);
        Player p2 = new Player("player2", passP2);

        assertEquals(rps.round(p1, p2), Result.TIE);
    }

    @Test
    public void souldBeLossWhenNoWin() {
        LinkedList<Play> passP1 = new LinkedList<>();
        passP1.add(Play.PAPER);
        passP1.add(Play.SCISSORS);
        passP1.add(Play.ROCK);
        passP1.add(Play.SCISSORS);

        LinkedList<Play> passP2 = new LinkedList<>();
        passP2.add(Play.SCISSORS);
        passP2.add(Play.ROCK);
        passP2.add(Play.PAPER);
        passP2.add(Play.ROCK);
        Player p1 = new Player("player1", passP1);
        Player p2 = new Player("player2", passP2);
        assertEquals(rps.round(p1, p2), Result.LOST);
    }
    @Test
    public void shouldBeLossWhenWinScoreIsSmallerThanLossAndTieScore() {
        LinkedList<Play> passP1 = new LinkedList<>();
        passP1.add(Play.SCISSORS);
        passP1.add(Play.SCISSORS);
        passP1.add(Play.ROCK);
        passP1.add(Play.SCISSORS);

        LinkedList<Play> passP2 = new LinkedList<>();
        passP2.add(Play.PAPER);
        passP2.add(Play.SCISSORS);
        passP2.add(Play.PAPER);
        passP2.add(Play.ROCK);
        Player p1 = new Player("player1", passP1);
        Player p2 = new Player("player2", passP2);
        assertEquals(rps.round(p1, p2), Result.LOST);
    }

}