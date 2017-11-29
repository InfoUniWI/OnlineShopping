
public class Artikel {
	private String name;
	private double einkaufsPreis;
	private double verkaufsPreis;
	private int bestandsMenge;
	private String kategorie;
	
	public Artikel(String name, double einkaufsPreis, double verkaufsPreis, int bestandsMenge, String kategorie) {
		super();
		this.name = name;
		this.einkaufsPreis = einkaufsPreis;
		this.verkaufsPreis = verkaufsPreis;
		this.bestandsMenge = bestandsMenge;
		this.kategorie = kategorie;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getEinkaufsPreis() {
		return einkaufsPreis;
	}

	public void setEinkaufsPreis(double einkaufsPreis) {
		this.einkaufsPreis = einkaufsPreis;
	}

	public double getVerkaufsPreis() {
		return verkaufsPreis;
	}

	public void setVerkaufsPreis(double verkaufsPreis) {
		this.verkaufsPreis = verkaufsPreis;
	}

	public int getBestandsMenge() {
		return bestandsMenge;
	}

	public void setBestandsMenge(int bestandsMenge) {
		this.bestandsMenge = bestandsMenge;
	}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}
	
	

}
