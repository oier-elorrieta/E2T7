package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import modeloa.Agentzia;
import modeloa.Bidaia;

public class AgentziaTest {

    ArrayList<Bidaia> bidaiak = new ArrayList<>();
    Agentzia agentzia = new Agentzia(1, "TestAgentzia", "logo.png", "#FFFFFF", "50", "Turismo", "pass123", "erabiltzaile1", bidaiak);
    
    
    @Test
    public void testGetIdentifikatzailea() {
        assertEquals(1, agentzia.getIdentifikatzailea());
    }

    @Test
    public void testSetIdentifikatzailea() {
        agentzia.setIdentifikatzailea(2);
        assertEquals(2, agentzia.getIdentifikatzailea());
    }

    @Test
    public void testGetIzena() {
        assertEquals("TestAgentzia", agentzia.getIzena());
    }

    @Test
    public void testSetIzena() {
        agentzia.setIzena("NewAgentzia");
        assertEquals("NewAgentzia", agentzia.getIzena());
    }

    @Test
    public void testGetLogoa() {
        assertEquals("logo.png", agentzia.getLogoa());
    }

    @Test
    public void testSetLogoa() {
        agentzia.setLogoa("newlogo.png");
        assertEquals("newlogo.png", agentzia.getLogoa());
    }

    @Test
    public void testGetMarkaKolorea() {
        assertEquals("#FFFFFF", agentzia.getMarkaKolorea());
    }

    @Test
    public void testSetMarkaKolorea() {
        agentzia.setMarkaKolorea("#000000");
        assertEquals("#000000", agentzia.getMarkaKolorea());
    }

    @Test
    public void testGetLangileKopurua() {
        assertEquals("50", agentzia.getLangileKopurua());
    }

    @Test
    public void testSetLangileKopurua() {
        agentzia.setLangileKopurua("100");
        assertEquals("100", agentzia.getLangileKopurua());
    }

    @Test
    public void testGetAgentziaMota() {
        assertEquals("Turismo", agentzia.getAgentziaMota());
    }

    @Test
    public void testSetAgentziaMota() {
        agentzia.setAgentziaMota("Negocios");
        assertEquals("Negocios", agentzia.getAgentziaMota());
    }

    @Test
    public void testGetPasahitza() {
        assertEquals("pass123", agentzia.getPasahitza());
    }

    @Test
    public void testSetPasahitza() {
        agentzia.setPasahitza("newpass");
        assertEquals("newpass", agentzia.getPasahitza());
    }

    @Test
    public void testGetErabiltzaile() {
        assertEquals("erabiltzaile1", agentzia.getErabiltzaile());
    }

    @Test
    public void testSetErabiltzaile() {
        agentzia.setErabiltzaile("newuser");
        assertEquals("newuser", agentzia.getErabiltzaile());
    }

    @Test
    public void testToString() {
        String expected = "Agentzia [identifikatzailea=1, izena=TestAgentzia, logoa=logo.png, markaKolorea=#FFFFFF, "
                + "langileKopurua=50, agentziaMota=Turismo, pasahitza=pass123, erabiltzaile=erabiltzaile1]";
        assertEquals(expected, agentzia.toString());
    }

}
