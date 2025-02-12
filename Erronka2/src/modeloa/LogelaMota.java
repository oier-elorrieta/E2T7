package modeloa;

public class LogelaMota {

	private String kodLogelaMota;
	private String deskribapenaLogelaMota;

	public LogelaMota(String kodLogelaMota, String deskribapenaLogelaMota) {
		this.kodLogelaMota = kodLogelaMota;
		this.deskribapenaLogelaMota = deskribapenaLogelaMota;
	}

	public String getKodLogelaMota() {
		return kodLogelaMota;
	}

	public void setKodLogelaMota(String kodLogelaMota) {
		this.kodLogelaMota = kodLogelaMota;
	}

	public String getDeskribapenaLogelaMota() {
		return deskribapenaLogelaMota;
	}

	public void setDeskribapenaLogelaMota(String deskribapenaLogelaMota) {
		this.deskribapenaLogelaMota = deskribapenaLogelaMota;
	}

}
