package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import modeloa.Bidaia;
import modeloa.Zerbitzua;

public class BidaiaTest {

	private Bidaia bidaia;
    @Before
    public void setUp() {
        new ArrayList<>();
        bidaia = new Bidaia("123", "TestBidaia", "Deskribapena", "Mota", "2024-01-01", "2024-01-10", "9 egun", "Paris", null, "Loreak");
    }

    @Test
    public void testGetIdentifikatzailea() {
        assertEquals("123", bidaia.getIdentifikatzailea());
    }

    @Test
    public void testSetIdentifikatzailea() {
        bidaia.setIdentifikatzailea("456");
        assertEquals("456", bidaia.getIdentifikatzailea());
    }

    @Test
    public void testGetIzena() {
        assertEquals("TestBidaia", bidaia.getIzena());
    }

    @Test
    public void testSetIzena() {
        bidaia.setIzena("NewBidaia");
        assertEquals("NewBidaia", bidaia.getIzena());
    }

    @Test
    public void testGetDeskribapena() {
        assertEquals("Deskribapena", bidaia.getDeskribapena());
    }

    @Test
    public void testSetDeskribapena() {
        bidaia.setDeskribapena("NewDeskribapena");
        assertEquals("NewDeskribapena", bidaia.getDeskribapena());
    }

    @Test
    public void testGetBidaiaMota() {
        assertEquals("Mota", bidaia.getBidaiaMota());
    }

    @Test
    public void testSetBidaiaMota() {
        bidaia.setBidaiaMota("NewMota");
        assertEquals("NewMota", bidaia.getBidaiaMota());
    }

    @Test
    public void testGetDataIrteera() {
        assertEquals("2024-01-01", bidaia.getDataIrteera());
    }

    @Test
    public void testSetDataIrteera() {
        bidaia.setDataIrteera("2024-02-01");
        assertEquals("2024-02-01", bidaia.getDataIrteera());
    }

    @Test
    public void testGetDataAmaiera() {
        assertEquals("2024-01-10", bidaia.getDataAmaiera());
    }

    @Test
    public void testSetDataAmaiera() {
        bidaia.setDataAmaiera("2024-02-10");
        assertEquals("2024-02-10", bidaia.getDataAmaiera());
    }

    @Test
    public void testGetHelmuga() {
        assertEquals("Paris", bidaia.getHelmuga());
    }

    @Test
    public void testSetHelmuga() {
        bidaia.setHelmuga("Londres");
        assertEquals("Londres", bidaia.getHelmuga());
    }

    @Test
    public void testGetAgentzia() {
        assertEquals("Loreak", bidaia.getAgentzia());
    }

    @Test
    public void testSetAgentzia() {
        bidaia.setAgentzia("NewAgentzia");
        assertEquals("NewAgentzia", bidaia.getAgentzia());
    }

    @Test
    public void testGetZerbitzuak() {
        assertNotNull(bidaia.getZerbitzuak());
    }
    
    @Test
    public void testGetIraupena() {
    	assertEquals("9 egun", bidaia.getIraupena());
    }
    
    @Test
    public void testSetIraupena() {
    	bidaia.setIraupena("11 egun");
    	assertEquals("11 egun", bidaia.getIraupena());
    }

    @Test
    public void testSetZerbitzuak() {
        ArrayList<Zerbitzua> newZerbitzuak = new ArrayList<>();
        bidaia.setZerbitzuak(newZerbitzuak);
        assertEquals(newZerbitzuak, bidaia.getZerbitzuak());
    }

    @Test
    public void testToString() {
        String expectedToString = "Bidaia [identifikatzailea=123, izena=TestBidaia, deskribapena=Deskribapena, bidaiaMota=Mota, dataIrteera=2024-01-01, dataAmaiera=2024-01-10, iraupena=9 egun, helmuga=Paris, agentzia=Loreak, Zerbitzuak=[]]";
        
        assertEquals(expectedToString, bidaia.toString());
    }
}
