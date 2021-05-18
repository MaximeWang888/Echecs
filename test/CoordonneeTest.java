import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import echiquier.Coordonnee;

/**
 * Tests unitaires sur la classe Coordonnee dans le jeu de l'échiquier.
 * @author  Fabien Rondan, Maxime Wang, Sebastien Ramirez
 * @version 1.0
 */
public class CoordonneeTest {

    @Test
    public void testGetY() {
        // GIVEN
        Coordonnee c = new Coordonnee(2,3);

        // THEN
        assertEquals(c.getY(),3);
        assertNotEquals(c.getY(),2);
    }

    @Test
    public void testGetX() {
        // GIVEN
        Coordonnee c = new Coordonnee(2,3);

        // THEN
        assertEquals(c.getX(),2);
        assertNotEquals(c.getX(),3);
    }

    @Test
    public void testCoordValide() {
        // GIVEN
        Coordonnee c = new Coordonnee(2,3);
//        Coordonnee d = new Coordonnee(-1,-1);

        // THEN
        assertTrue(c.coordValide());
//        assertFalse(d.coordValide());
    }

    @Test
    public void testConversionEnCoord() {
        // GIVEN
        Coordonnee c = new Coordonnee();
        String mot = "a8" ;
        c = c.conversionEnCoord(mot);
        Coordonnee c1 = new Coordonnee();
        String mot1 = "h1" ;
        c1 = c1.conversionEnCoord(mot1);

        // THEN
        assertEquals(c.getY(),0);
        assertEquals(c.getX(),0);
        assertEquals(c1.getY(),7);
        assertEquals(c1.getX(),7);
    }
}