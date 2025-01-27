package modeloa;

public class Agentzia {

	private String identifikatzailea;
	private String izena;
	private String logoa;
	private String markaKolorea;
	private String langileKopurua;
	private String agentziaMota;
	private String pasahitza;
	private String erabiltzaile;

	public Agentzia(String identifikatzailea, String izena, String logoa, String markaKolorea, String langileKopurua,
			String agentziaMota, String pasahitza, String erabiltzaile) {
		this.identifikatzailea = identifikatzailea;
		this.izena = izena;
		this.logoa = logoa;
		this.markaKolorea = markaKolorea;
		this.langileKopurua = langileKopurua;
		this.agentziaMota = agentziaMota;
		this.pasahitza = pasahitza;
		this.erabiltzaile = erabiltzaile;
	}

	public String getIdentifikatzailea() {
		return identifikatzailea;
	}

	public void setIdentifikatzailea(String identifikatzailea) {
		this.identifikatzailea = identifikatzailea;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getLogoa() {
		return logoa;
	}

	public void setLogoa(String logoa) {
		this.logoa = logoa;
	}

	public String getMarkaKolorea() {
		return markaKolorea;
	}

	public void setMarkaKolorea(String markaKolorea) {
		this.markaKolorea = markaKolorea;
	}

	public String getLangileKopurua() {
		return langileKopurua;
	}

	public void setLangileKopurua(String langileKopurua) {
		this.langileKopurua = langileKopurua;
	}

	public String getAgentziaMota() {
		return agentziaMota;
	}

	public void setAgentziaMota(String agentziaMota) {
		this.agentziaMota = agentziaMota;
	}
	
	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public String getErabiltzaile() {
		return erabiltzaile;
	}

	public void setErabiltzaile(String erabiltzaile) {
		this.erabiltzaile = erabiltzaile;
	}

	@Override
	public String toString() {
		return "Agentzia [identifikatzailea=" + identifikatzailea + ", izena=" + izena + ", logoa=" + logoa
				+ ", markaKolorea=" + markaKolorea + ", langileKopurua=" + langileKopurua + ", agentziaMota="
				+ agentziaMota + ", pasahitza=" + pasahitza + ", erabiltzaile=" + erabiltzaile + "]";
	}


}
