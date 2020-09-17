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

    //Instructions 2.1, 2.2
    @Parameters({"papier", "pierre"}) //parametres de test sois dans un fichier xml ou par config
    @Test() //
    public void testWinPlay(String p1, String p2){
        assertEquals(rps.play(Play.valueOf(p1), Play.valueOf(p2)), Result.WIN);
    }
    //Instructions 2.3, 2.4, 2.5
    @Parameters({"papier","papier"})
    @Test
    public void testTiePlay(String p1,String p2) {
        assertEquals(rps.play(Play.valueOf(p1),Play.valueOf(p2)),Result.TIE);
    }
    //Instruction 2.6
    @Parameters({"papier","ciseaux"})
    @Test
    public void testLostPlay(String p1, String p2){
        assertEquals(rps.play(Play.valueOf(p1),Play.valueOf(p2)),Result.LOST);
    }

}


