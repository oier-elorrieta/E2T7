package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modeloa.Zerbitzua;

public class ZerbitzuaTest {

	private Zerbitzua zerbitzuaOstatua;
	private Zerbitzua zerbitzuaBesteZerbitzuak;
	private Zerbitzua zerbitzuaHegaldiJoan;
	private Zerbitzua zerbitzuaHegaldiBuelta;
	private Zerbitzua zerbitzuaOstatuaKodea;
	private Zerbitzua zerbitzuaBesteZerbitzuakKodea;
	private Zerbitzua zerbitzuaHegaldiJoan2;
	private Zerbitzua zerbitzua;

	// Test-ingurunea prestatzen du, zerbitzuak objektuak hasieratzen dituelarik.
	// Hainbat Zerbitzua objektu sortzen dira, bakoitza atributu desberdinekin.
	@Before
	public void setUp() {
		zerbitzuaOstatua = new Zerbitzua(100.0, "Barcelona", "2025-06-01", "2025-06-10", "Suite", "Hotel ABC", 1, 2);
		zerbitzuaBesteZerbitzuak = new Zerbitzua("Spa", 50.0, "2025-06-01", "Relajante", 1, 3);
		zerbitzuaHegaldiJoan = new Zerbitzua(1, "MAD", "BCN", "IB123", "Iberia", 150.0, "2025-06-02", "09:00", 7, 0);
		zerbitzuaHegaldiBuelta = new Zerbitzua(1, "BCN", "MAD", "2025-06-11", "18:00",7 , "IB124", "Iberia", 1);
		zerbitzua = new Zerbitzua(2, 7, 1, 50, "2025-06-01", "2025-06-01", "DB", "Ostatua", 1, "Spa", 150, "BCN", "MAD", "Z23", "Iberia", 25, "2025-06-01", "18:00", 7, "2025-06-01", "18:00", 7, "A45", "Iberia", "2025-06-01");
		zerbitzuaOstatuaKodea = new Zerbitzua(4, 100.0, "2025-06-01", "2025-06-10", "DB", "Hotel ABC", 2);
		zerbitzuaBesteZerbitzuakKodea = new Zerbitzua(1, "Spa", 50.0, "2025-06-01", "Relajante", 3);
		zerbitzuaHegaldiJoan2 = new Zerbitzua("MAD", "BCN", "IB123",  "Iberia", 150.0, "2025-06-02", "09:00", 7, 1, 0);

	}

	// Ostatua zerbitzuaren konstruktorea probatzen du, eta egiaztatzen du sartutako
	// datuak
	// behar bezala esleitzen direla getter bidez lortutako balioekin.
	@Test
	public void testConstructorOstatua() {
		assertEquals(100.0, zerbitzuaOstatua.getPrezioaOstatua(), 0.01);
		assertEquals("2025-06-01", zerbitzuaOstatua.getSarreraEguna());
		assertEquals("2025-06-10", zerbitzuaOstatua.getIrteeraEguna());
		assertEquals("Suite", zerbitzuaOstatua.getLogelaMota());
		assertEquals("Hotel ABC", zerbitzuaOstatua.getIzenaOstatua());
	}

	// Beste zerbitzuaren konstruktorea probatzen du, eta egiaztatzen du sartutako
	// datuak
	// behar bezala esleitzen direla getter bidez lortutako balioekin.
	@Test
	public void testConstructorBesteZerbitzuak() {
		assertEquals("Spa", zerbitzuaBesteZerbitzuak.getBesteZerbitzuak());
		assertEquals(50.0, zerbitzuaBesteZerbitzuak.getPrezioaBesteZerbitzuak(), 0.01);
	}

	/**
	 * PrezioaOstatua atributua ondo ezarri eta berreskuratzen dela ziurtatzen du.
	 */
	@Test
	public void testSetGetPrezioaOstatua() {
		zerbitzua.setPrezioaOstatua(120.5);
		assertEquals(120.5, zerbitzua.getPrezioaOstatua(), 0.01);
	}
	
	@Test
	public void testSetMota() {
		zerbitzuaBesteZerbitzuak.setMota(2);
		assertEquals(2, zerbitzuaBesteZerbitzuak.getMota());
	}

	/**
	 * SarreraEguna atributua ondo ezarri eta berreskuratzen dela ziurtatzen du.
	 */
	@Test
	public void testSetGetSarreraEguna() {
		zerbitzua.setSarreraEguna("2025-07-01");
		assertEquals("2025-07-01", zerbitzua.getSarreraEguna());
	}

	/**
	 * IrteeraEguna atributua ondo ezarri eta berreskuratzen dela ziurtatzen du.
	 */
	@Test
	public void testSetGetIrteeraEguna() {
		zerbitzua.setIrteeraEguna("2025-07-10");
		assertEquals("2025-07-10", zerbitzua.getIrteeraEguna());
	}

	/**
	 * LogelaMota atributua ondo ezarri eta berreskuratzen dela ziurtatzen du.
	 */
	@Test
	public void testSetGetLogelaMota() {
		zerbitzua.setLogelaMota("Doble");
		assertEquals("Doble", zerbitzua.getLogelaMota());
	}

	/**
	 * Ostatua atributua ondo ezarri eta berreskuratzen dela ziurtatzen du.
	 */
	@Test
	public void testSetGetOstatua() {
		zerbitzuaOstatua.setIzenaOstatua("Hotel Efe");
		assertEquals("Hotel Efe", zerbitzuaOstatua.getIzenaOstatua());
	}

	/**
	 * BesteZerbitzuak atributua ondo ezarri eta berreskuratzen dela ziurtatzen du.
	 */
	@Test
	public void testSetGetBesteZerbitzuak() {
		zerbitzuaBesteZerbitzuak.setBesteZerbitzuak("Spa");
		assertEquals("Spa", zerbitzua.getBesteZerbitzuak());
	}

	/**
	 * PrezioaBesteZerbitzuak atributua ondo ezarri eta berreskuratzen dela
	 * ziurtatzen du.
	 */
	@Test
	public void testSetGetPrezioaBesteZerbitzuak() {
		zerbitzua.setPrezioaBesteZerbitzuak(80.0);
		assertEquals(80.0, zerbitzua.getPrezioaBesteZerbitzuak(), 0.01);
	}

	/**
	 * Hegaldia atributua ondo ezarri eta berreskuratzen dela ziurtatzen du.
	 */
	@Test
	public void testSetGetHegaldia() {
		zerbitzua.setAeroLinea("Ryanair");
		assertEquals("Ryanair", zerbitzua.getAeroLinea());
	}



	/**
	 * JatorrizkoAireportua atributua ondo ezarri eta berreskuratzen dela ziurtatzen
	 * du.
	 */
	@Test
	public void testSetGetJatorrizkoAireportua() {
		zerbitzua.setJatorrizkoAireportua("MAD");
		assertEquals("MAD", zerbitzua.getJatorrizkoAireportua());
	}

	/**
	 * HelmugakoAireportua atributua ondo ezarri eta berreskuratzen dela ziurtatzen
	 * du.
	 */
	@Test
	public void testSetGetHelmugakoAireportua() {
		zerbitzua.setHelmugakoAireportua("BCN");
		assertEquals("BCN", zerbitzua.getHelmugakoAireportua());
	}

	/**
	 * HegaldiKodea atributua ondo ezarri eta berreskuratzen dela ziurtatzen du.
	 */
	@Test
	public void testSetGetHegaldiKodea() {
		zerbitzua.setHegaldiKodea("FR1234");
		assertEquals("FR1234", zerbitzua.getHegaldiKodea());
	}

	/**
	 * AeroLinea atributua ondo ezarri eta berreskuratzen dela ziurtatzen du.
	 */
	@Test
	public void testSetGetAeroLinea() {
		zerbitzua.setAeroLinea("Iberia");
		assertEquals("Iberia", zerbitzua.getAeroLinea());
	}

	/**
	 * PrezioaHegaldia atributua ondo ezarri eta berreskuratzen dela ziurtatzen du.
	 */
	@Test
	public void testSetGetPrezioaHegaldia() {
		zerbitzua.setPrezioaHegaldia(150.75);
		assertEquals(150.75, zerbitzua.getPrezioaHegaldia(), 0.01);
	}

	/**
	 * IrteeraData atributua ondo ezarri eta berreskuratzen dela ziurtatzen du.
	 */
	@Test
	public void testSetGetIrteeraData() {
		zerbitzua.setIrteeraData("2025-08-15");
		assertEquals("2025-08-15", zerbitzua.getIrteeraData());
	}

	/**
	 * IrteeraOrdutegia atributua ondo ezarri eta berreskuratzen dela ziurtatzen du.
	 */
	@Test
	public void testSetGetIrteeraOrdutegia() {
		zerbitzua.setIrteeraOrdutegia("10:30");
		assertEquals("10:30", zerbitzua.getIrteeraOrdutegia());
	}

	/**
	 * BidaiarenIraupena atributua ondo ezarri eta berreskuratzen dela ziurtatzen
	 * du.
	 */
	@Test
	public void testSetGetBidaiarenIraupena() {
		zerbitzua.setBidaiarenIraupena(3);
		assertEquals(3, zerbitzua.getBidaiarenIraupena());
	}

	/**
	 * ItzuleraData atributua ondo ezarri eta berreskuratzen dela ziurtatzen du.
	 */
	@Test
	public void testSetGetItzuleraData() {
		zerbitzua.setItzuleraData("2025-08-25");
		assertEquals("2025-08-25", zerbitzua.getItzuleraData());
	}

	/**
	 * ItzuleraOrdua atributua ondo ezarri eta berreskuratzen dela ziurtatzen du.
	 */
	@Test
	public void testSetGetItzuleraOrdua() {
		zerbitzua.setItzuleraOrdua("16:45");
		assertEquals("16:45", zerbitzua.getItzuleraOrdua());
	}

	/**
	 * BidaiarenIraupenaBuelta atributua ondo ezarri eta berreskuratzen dela
	 * ziurtatzen du.
	 */
	@Test
	public void testSetGetBidaiarenIraupenaBuelta() {
		zerbitzua.setBidaiarenIraupenaBuelta(5);
		assertEquals(5, zerbitzua.getBidaiarenIraupenaBuelta());
	}

	/**
	 * HegaldiKodeaBuelta atributua ondo ezarri eta berreskuratzen dela ziurtatzen
	 * du.
	 */
	@Test
	public void testSetGetHegaldiKodeaBuelta() {
		zerbitzua.setHegaldiKodeaBuelta("FR5678");
		assertEquals("FR5678", zerbitzua.getHegaldiKodeaBuelta());
	}

	/**
	 * AeroLineaBuelta atributua ondo ezarri eta berreskuratzen dela ziurtatzen du.
	 */
	@Test
	public void testSetGetAeroLineaBuelta() {
		zerbitzua.setAeroLineaBuelta("Vueling");
		assertEquals("Vueling", zerbitzua.getAeroLineaBuelta());
	}

	/**
	 * Objektuaren toString metodoa ondo funtzionatzen duela ziurtatzen du.
	 */
	@Test
	public void testToString() {
		zerbitzua.setPrezioaOstatua(200.0);
		zerbitzua.setIzenaOstatua("Hotel Premium");
		zerbitzua.setAeroLinea("Iberia");


		String result = zerbitzua.toString();

		assertTrue(result.contains("prezioaOstatua=200.0"));
		assertTrue(result.contains("ostatua=Hotel Premium"));
		assertTrue(result.contains("Aerolinea=Iberia"));

		}
	
	// Hegaldiko joaneko zerbitzuaren konstruktorea probatzen du, eta egiaztatzen du
	// sartutako datuak
	// behar bezala esleitzen direla getter bidez lortutako balioekin.
	@Test
	public void testConstructorHegaldiJoan() {
		assertEquals(1, zerbitzuaHegaldiJoan.getHegaldia());
		assertEquals("MAD", zerbitzuaHegaldiJoan.getJatorrizkoAireportua());
		assertEquals("BCN", zerbitzuaHegaldiJoan.getHelmugakoAireportua());
		assertEquals("IB123", zerbitzuaHegaldiJoan.getHegaldiKodea());
		assertEquals("Iberia", zerbitzuaHegaldiJoan.getAeroLinea());
		assertEquals(150.0, zerbitzuaHegaldiJoan.getPrezioaHegaldia(), 0.01);
		assertEquals("2025-06-02", zerbitzuaHegaldiJoan.getIrteeraData());
		assertEquals("09:00", zerbitzuaHegaldiJoan.getIrteeraOrdutegia());
		assertEquals(7, zerbitzuaHegaldiJoan.getBidaiarenIraupena());
	}

	// Hegaldiko bueltako zerbitzuaren konstruktorea probatzen du, eta egiaztatzen
	// du sartutako datuak
	// behar bezala esleitzen direla getter bidez lortutako balioekin.
	@Test
	public void testConstructorHegaldiBuelta() {
		assertEquals(1, zerbitzuaHegaldiBuelta.getIDJoanEtorri());
		assertEquals("BCN", zerbitzuaHegaldiBuelta.getJatorrizkoAireportua());
		assertEquals("MAD", zerbitzuaHegaldiBuelta.getHelmugakoAireportua());
		assertEquals("2025-06-11", zerbitzuaHegaldiBuelta.getBueltaData());
		assertEquals("18:00", zerbitzuaHegaldiBuelta.getBueltaOrdutegia());
		assertEquals(7, zerbitzuaHegaldiBuelta.getBidaiarenIraupenaBuelta());
		assertEquals("IB124", zerbitzuaHegaldiBuelta.getHegaldiKodeaBuelta());
		assertEquals("Iberia", zerbitzuaHegaldiBuelta.getAeroLineaBuelta());
	}

	// Zerbitzuko setter eta getter metodoen funtzionamendua probatzen du, eta
	// egiaztatzen du balioak
	// behar bezala aldatu eta esleitzen direla.
	@Test
	public void testSettersAndGetters() {
		zerbitzuaOstatua.setPrezioaOstatua(120.0);
		assertEquals(120.0, zerbitzuaOstatua.getPrezioaOstatua(), 0.01);

		zerbitzuaBesteZerbitzuak.setBesteZerbitzuak("Gimnasio");
		assertEquals("Gimnasio", zerbitzuaBesteZerbitzuak.getBesteZerbitzuak());

	}

	// Zerbitzuko objektuaren toString metodoaren funtzionamendua probatzen du,
	// eta egiaztatzen du emaitzak zuzenean itzultzen direla.
	@Test
	public void testToString1() {
		String result = zerbitzuaOstatua.toString();
		assertTrue(result.contains("prezioaOstatua=100.0"));
		assertTrue(result.contains("sarreraEguna=2025-06-01"));
	}



}
