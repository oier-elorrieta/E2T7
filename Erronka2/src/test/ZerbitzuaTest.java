package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modeloa.Zerbitzua;

public class ZerbitzuaTest {

	private Zerbitzua zerbitzuaOstatua;
    private Zerbitzua zerbitzuaBesteZerbitzuak;
    private Zerbitzua zerbitzuaHegaldiJoanEtorri;
    private Zerbitzua zerbitzuaHegaldiJoan;
    private Zerbitzua zerbitzuaHegaldiBuelta;
    private Zerbitzua zerbitzua;

    @Before
    public void setUp() {
        zerbitzuaOstatua = new Zerbitzua(100.0, "2025-06-01", "2025-06-10", "Suite", "Hotel ABC");
        zerbitzuaBesteZerbitzuak = new Zerbitzua("Spa", 50.0);
        zerbitzuaHegaldiJoanEtorri = new Zerbitzua("Vueling", true, "MAD", "BCN", "VLG123", "Vueling", 200.0,
                "2025-06-01", "08:00", "1h", "2025-06-10", "10:00", "1h", "VLG124", "Vueling");
        zerbitzuaHegaldiJoan = new Zerbitzua("Iberia", "MAD", "BCN", "IB123", "Iberia", 150.0, "2025-06-02", "09:00", "1h 30m");
        zerbitzuaHegaldiBuelta = new Zerbitzua("Iberia", true, "BCN", "MAD", 160.0, "2025-06-11", "18:00", "1h 30m", "IB124", "Iberia");
        zerbitzua = new Zerbitzua (null, 7, "2025-06-10", "2025-06-10", "Logela", "Ostatua", "A234", "Spa", 15, false, "BIO", "BCN", "A111", "Aja", 20, "2025-06-02", "09:00", "1h 30m", "2025-06-02", "09:00", "1h 30m", "B123", "OJO");
    }

    @Test
    public void testConstructorOstatua() {
        assertEquals(100.0, zerbitzuaOstatua.getPrezioaOstatua(), 0.01);
        assertEquals("2025-06-01", zerbitzuaOstatua.getSarreraEguna());
        assertEquals("2025-06-10", zerbitzuaOstatua.getIrteeraEguna());
        assertEquals("Suite", zerbitzuaOstatua.getLogelaMota());
        assertEquals("Hotel ABC", zerbitzuaOstatua.getOstatua());
    }

    @Test
    public void testConstructorBesteZerbitzuak() {
        assertEquals("Spa", zerbitzuaBesteZerbitzuak.getBesteZerbitzuak());
        assertEquals(50.0, zerbitzuaBesteZerbitzuak.getPrezioaBesteZerbitzuak(), 0.01);
    }

    @Test
    public void testConstructorHegaldiJoanEtorri() {
        assertEquals("Vueling", zerbitzuaHegaldiJoanEtorri.getHegaldia());
        assertTrue(zerbitzuaHegaldiJoanEtorri.isJoanEtorri());
        assertEquals("MAD", zerbitzuaHegaldiJoanEtorri.getJatorrizkoAireportua());
        assertEquals("BCN", zerbitzuaHegaldiJoanEtorri.getHelmugakoAireportua());
        assertEquals("VLG123", zerbitzuaHegaldiJoanEtorri.getHegaldiKodea());
        assertEquals("Vueling", zerbitzuaHegaldiJoanEtorri.getAeroLinea());
        assertEquals(200.0, zerbitzuaHegaldiJoanEtorri.getPrezioaHegaldia(), 0.01);
        assertEquals("2025-06-01", zerbitzuaHegaldiJoanEtorri.getIrteeraData());
        assertEquals("08:00", zerbitzuaHegaldiJoanEtorri.getIrteeraOrdutegia());
        assertEquals("1h", zerbitzuaHegaldiJoanEtorri.getBidaiarenIraupena());
        assertEquals("2025-06-10", zerbitzuaHegaldiJoanEtorri.getItzuleraData());
        assertEquals("10:00", zerbitzuaHegaldiJoanEtorri.getItzuleraOrdua());
        assertEquals("1h", zerbitzuaHegaldiJoanEtorri.getBidaiarenIraupenaBuelta());
        assertEquals("VLG124", zerbitzuaHegaldiJoanEtorri.getHegaldiKodeaBuelta());
        assertEquals("Vueling", zerbitzuaHegaldiJoanEtorri.getAeroLineaBuelta());
    }

    @Test
    public void testConstructorHegaldiJoan() {
        assertEquals("Iberia", zerbitzuaHegaldiJoan.getHegaldia());
        assertEquals("MAD", zerbitzuaHegaldiJoan.getJatorrizkoAireportua());
        assertEquals("BCN", zerbitzuaHegaldiJoan.getHelmugakoAireportua());
        assertEquals("IB123", zerbitzuaHegaldiJoan.getHegaldiKodea());
        assertEquals("Iberia", zerbitzuaHegaldiJoan.getAeroLinea());
        assertEquals(150.0, zerbitzuaHegaldiJoan.getPrezioaHegaldia(), 0.01);
        assertEquals("2025-06-02", zerbitzuaHegaldiJoan.getIrteeraData());
        assertEquals("09:00", zerbitzuaHegaldiJoan.getIrteeraOrdutegia());
        assertEquals("1h 30m", zerbitzuaHegaldiJoan.getBidaiarenIraupena());
    }

    @Test
    public void testConstructorHegaldiBuelta() {
        assertTrue(zerbitzuaHegaldiBuelta.isJoanEtorri());
        assertEquals("BCN", zerbitzuaHegaldiBuelta.getJatorrizkoAireportua());
        assertEquals("MAD", zerbitzuaHegaldiBuelta.getHelmugakoAireportua());
        assertEquals(160.0, zerbitzuaHegaldiBuelta.getPrezioaHegaldia(), 0.01);
        assertEquals("2025-06-11", zerbitzuaHegaldiBuelta.getItzuleraData());
        assertEquals("18:00", zerbitzuaHegaldiBuelta.getItzuleraOrdua());
        assertEquals("1h 30m", zerbitzuaHegaldiBuelta.getBidaiarenIraupenaBuelta());
        assertEquals("IB124", zerbitzuaHegaldiBuelta.getHegaldiKodeaBuelta());
        assertEquals("Iberia", zerbitzuaHegaldiBuelta.getAeroLineaBuelta());
    }

    @Test
    public void testSettersAndGetters() {
        zerbitzuaOstatua.setPrezioaOstatua(120.0);
        assertEquals(120.0, zerbitzuaOstatua.getPrezioaOstatua(), 0.01);

        zerbitzuaBesteZerbitzuak.setBesteZerbitzuak("Gimnasio");
        assertEquals("Gimnasio", zerbitzuaBesteZerbitzuak.getBesteZerbitzuak());

        zerbitzuaHegaldiJoanEtorri.setAeroLinea("Ryanair");
        assertEquals("Ryanair", zerbitzuaHegaldiJoanEtorri.getAeroLinea());
    }

    @Test
    public void testToString1() {
        String result = zerbitzuaOstatua.toString();
        assertTrue(result.contains("prezioaOstatua=100.0"));
        assertTrue(result.contains("sarreraEguna=2025-06-01"));
    }
    
    @Test
    public void testSetGetPrezioaOstatua() {
        zerbitzua.setPrezioaOstatua(120.5);
        assertEquals(120.5, zerbitzua.getPrezioaOstatua(), 0.01);
    }

    @Test
    public void testSetGetSarreraEguna() {
        zerbitzua.setSarreraEguna("2025-07-01");
        assertEquals("2025-07-01", zerbitzua.getSarreraEguna());
    }

    @Test
    public void testSetGetIrteeraEguna() {
        zerbitzua.setIrteeraEguna("2025-07-10");
        assertEquals("2025-07-10", zerbitzua.getIrteeraEguna());
    }

    @Test
    public void testSetGetLogelaMota() {
        zerbitzua.setLogelaMota("Doble");
        assertEquals("Doble", zerbitzua.getLogelaMota());
    }

    @Test
    public void testSetGetOstatua() {
    	zerbitzuaOstatua.setOstatua("Hotel Efe");
        assertEquals("Hotel Efe", zerbitzuaOstatua.getOstatua());
    }

    @Test
    public void testSetGetBesteZerbitzuak() {
    	zerbitzuaBesteZerbitzuak.setBesteZerbitzuak("Spa");
        assertEquals("Spa", zerbitzua.getBesteZerbitzuak());
    }

    @Test
    public void testSetGetPrezioaBesteZerbitzuak() {
        zerbitzua.setPrezioaBesteZerbitzuak(80.0);
        assertEquals(80.0, zerbitzua.getPrezioaBesteZerbitzuak(), 0.01);
    }

    @Test
    public void testSetGetHegaldia() {
        zerbitzua.setHegaldia("Ryanair");
        assertEquals("Ryanair", zerbitzua.getHegaldia());
    }

    @Test
    public void testSetGetJoanEtorri() {
        zerbitzua.setJoanEtorri(true);
        assertTrue(zerbitzua.isJoanEtorri());
        zerbitzua.setJoanEtorri(false);
        assertFalse(zerbitzua.isJoanEtorri());
    }

    @Test
    public void testSetGetJatorrizkoAireportua() {
        zerbitzua.setJatorrizkoAireportua("MAD");
        assertEquals("MAD", zerbitzua.getJatorrizkoAireportua());
    }

    @Test
    public void testSetGetHelmugakoAireportua() {
        zerbitzua.setHelmugakoAireportua("BCN");
        assertEquals("BCN", zerbitzua.getHelmugakoAireportua());
    }

    @Test
    public void testSetGetHegaldiKodea() {
        zerbitzua.setHegaldiKodea("FR1234");
        assertEquals("FR1234", zerbitzua.getHegaldiKodea());
    }

    @Test
    public void testSetGetAeroLinea() {
        zerbitzua.setAeroLinea("Iberia");
        assertEquals("Iberia", zerbitzua.getAeroLinea());
    }

    @Test
    public void testSetGetPrezioaHegaldia() {
        zerbitzua.setPrezioaHegaldia(150.75);
        assertEquals(150.75, zerbitzua.getPrezioaHegaldia(), 0.01);
    }

    @Test
    public void testSetGetIrteeraData() {
        zerbitzua.setIrteeraData("2025-08-15");
        assertEquals("2025-08-15", zerbitzua.getIrteeraData());
    }

    @Test
    public void testSetGetIrteeraOrdutegia() {
        zerbitzua.setIrteeraOrdutegia("10:30");
        assertEquals("10:30", zerbitzua.getIrteeraOrdutegia());
    }

    @Test
    public void testSetGetBidaiarenIraupena() {
        zerbitzua.setBidaiarenIraupena("2h 15m");
        assertEquals("2h 15m", zerbitzua.getBidaiarenIraupena());
    }

    @Test
    public void testSetGetItzuleraData() {
        zerbitzua.setItzuleraData("2025-08-25");
        assertEquals("2025-08-25", zerbitzua.getItzuleraData());
    }

    @Test
    public void testSetGetItzuleraOrdua() {
        zerbitzua.setItzuleraOrdua("16:45");
        assertEquals("16:45", zerbitzua.getItzuleraOrdua());
    }

    @Test
    public void testSetGetBidaiarenIraupenaBuelta() {
        zerbitzua.setBidaiarenIraupenaBuelta("2h 30m");
        assertEquals("2h 30m", zerbitzua.getBidaiarenIraupenaBuelta());
    }

    @Test
    public void testSetGetHegaldiKodeaBuelta() {
        zerbitzua.setHegaldiKodeaBuelta("FR5678");
        assertEquals("FR5678", zerbitzua.getHegaldiKodeaBuelta());
    }

    @Test
    public void testSetGetAeroLineaBuelta() {
        zerbitzua.setAeroLineaBuelta("Vueling");
        assertEquals("Vueling", zerbitzua.getAeroLineaBuelta());
    }

    @Test
    public void testToString() {
        zerbitzua.setPrezioaOstatua(200.0);
        zerbitzua.setOstatua("Hotel Premium");
        zerbitzua.setHegaldia("Iberia");
        zerbitzua.setJoanEtorri(true);
        
        String result = zerbitzua.toString();
        
        assertTrue(result.contains("prezioaOstatua=200.0"));
        assertTrue(result.contains("ostatua=Hotel Premium"));
        assertTrue(result.contains("hegaldia=Iberia"));
        assertTrue(result.contains("joanEtorri=true"));
    }

}
