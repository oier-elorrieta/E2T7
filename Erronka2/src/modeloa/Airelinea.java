package modeloa;

public class Airelinea {
	
	private String kodAirelinea;
	private String izenaAirelinea;
	private String herrialdea;
	
	public Airelinea(String kodAirelinea, String izenaAirelinea, String herrialdea) {
		this.kodAirelinea = kodAirelinea;
		this.izenaAirelinea = izenaAirelinea;
		this.herrialdea = herrialdea;
	}



	public String getKodAirelinea() {
		return kodAirelinea;
	}

	public void setKodAirelinea(String kodAirelinea) {
		this.kodAirelinea = kodAirelinea;
	}

	public String getIzenaAirelinea() {
		return izenaAirelinea;
	}

	public void setIzenaAirelinea(String izenaAirelinea) {
		this.izenaAirelinea = izenaAirelinea;
	}

	public String getHerrialdea() {
		return herrialdea;
	}

	public void setHerrialdea(String herrialdea) {
		this.herrialdea = herrialdea;
	}
	
	

}
