package modeloa;

import java.sql.Date;

public class Zerbitzuak {

	private double prezioaOstatua;
	private Date sarreraEguna;
	private Date irteeraEguna;
	private String logelaMota;
	private String ostatua;
	private String hegaldia;
	private String besteZerbitzuak;
	private double prezioaBesteZerbitzuak;
	private boolean joanEtorri;
	private String jatorrizkoAireportua;
	private String helmugakoAireportua;
	private String hegaldiKodea;
	private String aeroLinea;
	private double prezioaHegaldia;
	private Date irteeraData;
	private String irteeraOrdutegia;
	private String bidaiarenIraupena;
	private Date itzuleraData;
	private Date itzuleraOrdua;
	private String bidaiarenIraupenaBuelta;
	private String hegaldiKodeaBuelta;
	private String aeroLineaBuelta;
	
	public Zerbitzuak(double prezioaOstatua, Date sarreraEguna, Date irteeraEguna, String logelaMota, String ostatua, String hegaldia, String besteZerbitzuak, double prezioaBesteZerbitzuak, boolean joanEtorri, String jatorrizkoAireportua, String helmugakoAireportua, String hegaldiKodea, String aeroLinea, double prezioaHegaldia, Date irteeraData, String irteeraOrdutegia, String bidaiarenIraupena, Date itzuleraData, Date itzuleraOrdua, String bidaiarenIraupenaBuelta, String hegaldiKodeaBuelta, String aeroLineaBuelta) {
		
		this.prezioaOstatua = prezioaOstatua;
		this.sarreraEguna = sarreraEguna;
		this.irteeraEguna = irteeraEguna;
		this.logelaMota = logelaMota;
		this.ostatua = ostatua;
		this.hegaldia = hegaldia;
		this.besteZerbitzuak = besteZerbitzuak;
		this.prezioaBesteZerbitzuak = prezioaBesteZerbitzuak;
		this.joanEtorri = joanEtorri;
		this.jatorrizkoAireportua = jatorrizkoAireportua;
		this.helmugakoAireportua = helmugakoAireportua;
		this.hegaldiKodea = hegaldiKodea;
		this.aeroLinea = aeroLinea;
		this.prezioaHegaldia = prezioaHegaldia;
		this.irteeraData = irteeraData;
		this.irteeraOrdutegia = irteeraOrdutegia;
		this.bidaiarenIraupena = bidaiarenIraupena;
		this.itzuleraData = itzuleraData;
		this.itzuleraOrdua = itzuleraOrdua;
		this.bidaiarenIraupenaBuelta = bidaiarenIraupenaBuelta;
		this.hegaldiKodeaBuelta = hegaldiKodeaBuelta;
		this.aeroLineaBuelta = aeroLineaBuelta;
	}

	public double getPrezioaOstatua() {
		return prezioaOstatua;
	}

	public void setPrezioaOstatua(double prezioaOstatua) {
		this.prezioaOstatua = prezioaOstatua;
	}

	public String getSarreraEguna() {
		return sarreraEguna;
	}

	public void setSarreraEguna(String sarreraEguna) {
		this.sarreraEguna = sarreraEguna;
	}

	public String getIrteeraEguna() {
		return irteeraEguna;
	}

	public void setIrteeraEguna(String irteeraEguna) {
		this.irteeraEguna = irteeraEguna;
	}

	public String getLogelaMota() {
		return logelaMota;
	}

	public void setLogelaMota(String logelaMota) {
		this.logelaMota = logelaMota;
	}

	public String getOstatua() {
		return ostatua;
	}

	public void setOstatua(String ostatua) {
		this.ostatua = ostatua;
	}

	public String getHegaldia() {
		return hegaldia;
	}

	public void setHegaldia(String hegaldia) {
		this.hegaldia = hegaldia;
	}

	public String getBesteZerbitzuak() {
		return besteZerbitzuak;
	}

	public void setBesteZerbitzuak(String besteZerbitzuak) {
		this.besteZerbitzuak = besteZerbitzuak;
	}

	public String getPrezioaBesteZerbitzuak() {
		return prezioaBesteZerbitzuak;
	}

	public void setPrezioaBesteZerbitzuak(String prezioaBesteZerbitzuak) {
		this.prezioaBesteZerbitzuak = prezioaBesteZerbitzuak;
	}

	public boolean isJoanEtorri() {
		return joanEtorri;
	}

	public void setJoanEtorri(boolean joanEtorri) {
		this.joanEtorri = joanEtorri;
	}

	public String getJatorrizkoAireportua() {
		return jatorrizkoAireportua;
	}

	public void setJatorrizkoAireportua(String jatorrizkoAireportua) {
		this.jatorrizkoAireportua = jatorrizkoAireportua;
	}

	public String getHelmugakoAireportua() {
		return helmugakoAireportua;
	}

	public void setHelmugakoAireportua(String helmugakoAireportua) {
		this.helmugakoAireportua = helmugakoAireportua;
	}

	public String getHegaldiKodea() {
		return hegaldiKodea;
	}

	public void setHegaldiKodea(String hegaldiKodea) {
		this.hegaldiKodea = hegaldiKodea;
	}

	public String getAeroLinea() {
		return aeroLinea;
	}

	public void setAeroLinea(String aeroLinea) {
		this.aeroLinea = aeroLinea;
	}

	public double getPrezioaHegaldia() {
		return prezioaHegaldia;
	}

	public void setPrezioaHegaldia(double prezioaHegaldia) {
		this.prezioaHegaldia = prezioaHegaldia;
	}

	public String getIrteeraData() {
		return irteeraData;
	}

	public void setIrteeraData(String irteeraData) {
		this.irteeraData = irteeraData;
	}

	public String getIrteeraOrdutegia() {
		return irteeraOrdutegia;
	}

	public void setIrteeraOrdutegia(String irteeraOrdutegia) {
		this.irteeraOrdutegia = irteeraOrdutegia;
	}

	public String getBidaiarenIraupena() {
		return bidaiarenIraupena;
	}

	public void setBidaiarenIraupena(String bidaiarenIraupena) {
		this.bidaiarenIraupena = bidaiarenIraupena;
	}

	public String getItzuleraData() {
		return itzuleraData;
	}

	public void setItzuleraData(String itzuleraData) {
		this.itzuleraData = itzuleraData;
	}

	public String getItzuleraOrdua() {
		return itzuleraOrdua;
	}

	public void setItzuleraOrdua(String itzuleraOrdua) {
		this.itzuleraOrdua = itzuleraOrdua;
	}

	public String getBidaiarenIraupenaBuelta() {
		return bidaiarenIraupenaBuelta;
	}

	public void setBidaiarenIraupenaBuelta(String bidaiarenIraupenaBuelta) {
		this.bidaiarenIraupenaBuelta = bidaiarenIraupenaBuelta;
	}

	public String getHegaldiKodeaBuelta() {
		return hegaldiKodeaBuelta;
	}

	public void setHegaldiKodeaBuelta(String hegaldiKodeaBuelta) {
		this.hegaldiKodeaBuelta = hegaldiKodeaBuelta;
	}

	public String getAeroLineaBuelta() {
		return aeroLineaBuelta;
	}

	public void setAeroLineaBuelta(String aeroLineaBuelta) {
		this.aeroLineaBuelta = aeroLineaBuelta;
	}

	@Override
	public String toString() {
		return "Zerbitzuak [prezioaOstatua=" + prezioaOstatua + ", sarreraEguna=" + sarreraEguna + ", irteeraEguna="
				+ irteeraEguna + ", logelaMota=" + logelaMota + ", ostatua=" + ostatua + ", hegaldia=" + hegaldia
				+ ", besteZerbitzuak=" + besteZerbitzuak + ", prezioaBesteZerbitzuak=" + prezioaBesteZerbitzuak
				+ ", joanEtorri=" + joanEtorri + ", jatorrizkoAireportua=" + jatorrizkoAireportua
				+ ", helmugakoAireportua=" + helmugakoAireportua + ", hegaldiKodea=" + hegaldiKodea + ", aeroLinea="
				+ aeroLinea + ", prezioaHegaldia=" + prezioaHegaldia + ", irteeraData=" + irteeraData
				+ ", irteeraOrdutegia=" + irteeraOrdutegia + ", bidaiarenIraupena=" + bidaiarenIraupena
				+ ", itzuleraData=" + itzuleraData + ", itzuleraOrdua=" + itzuleraOrdua + ", bidaiarenIraupenaBuelta="
				+ bidaiarenIraupenaBuelta + ", hegaldiKodeaBuelta=" + hegaldiKodeaBuelta + ", aeroLineaBuelta="
				+ aeroLineaBuelta + "]";
	}

	
	
}
