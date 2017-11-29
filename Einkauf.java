
public class Einkauf {
	private Artikel artikel;
	private int menge;
	
	public Einkauf(Artikel artikel, int menge) {
		super();
		this.artikel = artikel;
		this.menge = menge;
	}
	public Artikel getArtikel() {
		return artikel;
	}
	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}
	public int getMenge() {
		return menge;
	}
	public void setMenge(int menge) {
		this.menge = menge;
	}
	
	

}
