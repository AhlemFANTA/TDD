package fr.parisnanterre.miage.rps.model;

import org.testng.annotations.*;

import static org.testng.Assert.*;

public class RockPaperScissorsTest {
    RockPaperScissors rps;

    @BeforeClass
    public void setUp() {
        rps = new RockPaperScissors();
    }

    @AfterClass
    public void tearDown() {
        rps = null;
    }
    @Parameters({"papier", "pierre"}) //parametre de test sois dans un fichier xml ou dans la config
    @Test() //
    public void testWinPlay(String p1, String p2){
        assertEquals(rps.play(Play.valueOf(p1), Play.valueOf(p2)), Result.WIN);
    }

}