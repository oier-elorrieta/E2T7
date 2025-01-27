package modeloa;

public class Hegaldia {

	private boolean joanEtorri;
	private String jatorrizkoAireportua;
	private String helmugakoAireportua;
	private String hegaldiKodea;
	private String aeroLinea;
	private double prezioa;
	private String irteeraData;
	private String irteeraOrdutegia;
	private String bidaiarenIraupena;
	private String itzuleraData;
	private String itzuleraOrdua;
	private String bidaiarenIraupenaBuelta;
	private String hegaldiKodeaBuelta;
	private String aeroLineaBuelta;

	// Joateko Konstruktorea
	public Hegaldia(boolean joanEtorri, String jatorrizkoAireportua, String helmugakoAireportua, String hegaldiKodea,
			String aeroLinea, double prezioa, String irteeraData, String irteeraOrdutegia, String bidaiarenIraupena) {
		this.joanEtorri = joanEtorri;
		this.jatorrizkoAireportua = jatorrizkoAireportua;
		this.helmugakoAireportua = helmugakoAireportua;
		this.hegaldiKodea = hegaldiKodea;
		this.aeroLinea = aeroLinea;
		this.prezioa = prezioa;
		this.irteeraData = irteeraData;
		this.irteeraOrdutegia = irteeraOrdutegia;
		this.bidaiarenIraupena = bidaiarenIraupena;
	}

	// JoanEtorri Konstruktorea
	public Hegaldia(boolean joanEtorri, String jatorrizkoAireportua, String helmugakoAireportua, String hegaldiKodea,
			String aeroLinea, double prezioa, String irteeraData, String irteeraOrdutegia, String bidaiarenIraupena,
			String itzuleraData, String itzuleraOrdua, String bidaiarenIraupenaBuelta, String hegaldiKodeaBuelta,
			String aeroLineaBuelta) {
		this.joanEtorri = joanEtorri;
		this.jatorrizkoAireportua = jatorrizkoAireportua;
		this.helmugakoAireportua = helmugakoAireportua;
		this.hegaldiKodea = hegaldiKodea;
		this.aeroLinea = aeroLinea;
		this.prezioa = prezioa;
		this.irteeraData = irteeraData;
		this.irteeraOrdutegia = irteeraOrdutegia;
		this.bidaiarenIraupena = bidaiarenIraupena;
		this.itzuleraData = itzuleraData;
		this.itzuleraOrdua = itzuleraOrdua;
		this.bidaiarenIraupenaBuelta = bidaiarenIraupenaBuelta;
		this.hegaldiKodeaBuelta = hegaldiKodeaBuelta;
		this.aeroLineaBuelta = aeroLineaBuelta;
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

	public double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
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

	// Metodoa Joan
	public String toStringJoateko() {
		return "Hegaldia [joanEtorri=" + joanEtorri + ", jatorrizkoAireportua=" + jatorrizkoAireportua
				+ ", helmugakoAireportua=" + helmugakoAireportua + ", hegaldiKodea=" + hegaldiKodea + ", aeroLinea="
				+ aeroLinea + ", prezioa=" + prezioa + ", irteeraData=" + irteeraData + ", irteeraOrdutegia="
				+ irteeraOrdutegia + ", bidaiarenIraupena=" + bidaiarenIraupena + "]";
	}

	// Metodoa JoanEtorri
	public String toStringJoanEtorri() {
		return "Hegaldia [joanEtorri=" + joanEtorri + ", jatorrizkoAireportua=" + jatorrizkoAireportua
				+ ", helmugakoAireportua=" + helmugakoAireportua + ", hegaldiKodea=" + hegaldiKodea + ", aeroLinea="
				+ aeroLinea + ", prezioa=" + prezioa + ", irteeraData=" + irteeraData + ", irteeraOrdutegia="
				+ irteeraOrdutegia + ", bidaiarenIraupena=" + bidaiarenIraupena + ", itzuleraData=" + itzuleraData
				+ ", itzuleraOrdua=" + itzuleraOrdua + ", bidaiarenIraupenaBuelta=" + bidaiarenIraupenaBuelta
				+ ", hegaldiKodeaBuelta=" + hegaldiKodeaBuelta + ", aeroLineaBuelta=" + aeroLineaBuelta + "]";
	}

	@Override
	public String toString() {
		// Metodo bat eto bestea erabiltzen du joanEtorri kontuan hartuta
		return joanEtorri ? toStringJoanEtorri() : toStringJoateko();
	}

}
