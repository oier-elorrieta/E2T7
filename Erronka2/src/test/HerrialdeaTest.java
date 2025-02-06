package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modeloa.Herrialdea;

public class HerrialdeaTest {

	private Herrialdea herrialdea;

    @Before
    public void setUp() {
        herrialdea = new Herrialdea("ES", "Espainia");
    }

    @Test
    public void testGetKodea() {
        assertEquals("ES", herrialdea.getKodea());
    }

    @Test
    public void testSetKodea() {
        herrialdea.setKodea("FR");
        assertEquals("FR", herrialdea.getKodea());
    }

    @Test
    public void testGetHerrialdea() {
        assertEquals("Espainia", herrialdea.getHerrialdea());
    }

    @Test
    public void testSetHerrialdea() {
        herrialdea.setHerrialdea("Frantzia");
        assertEquals("Frantzia", herrialdea.getHerrialdea());
    }

    @Test
    public void testToString() {
        String expected = "Herrialdea [kodea=ES, herrialdea=Espainia]";
        assertEquals(expected, herrialdea.toString());
    }

}
