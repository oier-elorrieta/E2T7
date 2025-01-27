package modeloa;

public class Zerbitzuak {

	private String prezioa;
	private String sarreraEguna;
	private String irteeraEguna;
	private String logelaMota;
	private String ostatua;
	private String hegaldia;

	public Zerbitzuak(String hotela, String prezioa, String sarreraEguna, String irteeraEguna, String logelaMota,
			String ostatua, String hegaldia) {
		super();
		this.hotela = hotela;
		this.prezioa = prezioa;
		this.sarreraEguna = sarreraEguna;
		this.irteeraEguna = irteeraEguna;
		this.logelaMota = logelaMota;
		this.ostatua = ostatua;
		this.hegaldia = hegaldia;
	}

	public String getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(String prezioa) {
		this.prezioa = prezioa;
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

	@Override
	public String toString() {
		return "Zerbitzuak [hotela=" + hotela + ", prezioa=" + prezioa + ", sarreraEguna=" + sarreraEguna
				+ ", irteeraEguna=" + irteeraEguna + ", logelaMota=" + logelaMota + ", ostatua=" + ostatua
				+ ", hegaldia=" + hegaldia + "]";
	}
	
	
}
