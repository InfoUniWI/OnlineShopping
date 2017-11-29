import java.util.ArrayList;

public class Person {
	// Verkäufer ist true wenn im Verkäufer-Modus sonst false
	private boolean verkaeufer;
	private int kauferNummer;
	private int geheimNummer;

	public Person(boolean verkaeufer) {
		this.verkaeufer = verkaeufer;
	}
	

	public boolean isVerkaeufer() {
		return verkaeufer;
	}


	public void setVerkaeufer(boolean verkaeufer) {
		this.verkaeufer = verkaeufer;
	}


	public int getKauferNummer() {
		return kauferNummer;
	}


	public void setKauferNummer(int kauferNummer) {
		this.kauferNummer = kauferNummer;
	}


	public int getGeheimNummer() {
		return geheimNummer;
	}


	public void setGeheimNummer(int geheimNummer) {
		this.geheimNummer = geheimNummer;
	}


	public void einkaufsPreisAendern(Artikel artikel, double einkaufsPreis) {
		if (verkaeufer) {
			artikel.setEinkaufsPreis(einkaufsPreis);
		} else {
			System.err.println("Sie haben nicht das Recht, den Einkaufspreis zu ändern");
		}
	}

	public void verkaufsPreisAendern(Artikel artikel, double verkaufsPreis) {
		if (verkaeufer) {
			artikel.setVerkaufsPreis(verkaufsPreis);
		} else {
			System.err.println("Sie haben nicht das Recht, den Einkaufspreis zu ändern");
		}
	}

	public void bestandsMengeAender(Artikel artikel, int bestandsMenge) {
		if (verkaeufer) {
			artikel.setBestandsMenge(bestandsMenge);
		} else {
			System.err.println("Sie haben nicht das Recht, den Einkaufspreis zu ändern");
		}
	}

	public void berechneEinkaufsPreis(Artikel[] alleArtikel) {// Freizeit Büro und Küche
		int gesamtFreizeit = 0;
		int gesamtBuero = 0;
		int gesamtKueche = 0;
		for (int i = 0; i < alleArtikel.length; i++) {
			if (alleArtikel[i].getKategorie().equals("Freizeit")) {
				gesamtFreizeit += alleArtikel[i].getEinkaufsPreis();
			} else if (alleArtikel[i].getKategorie().equals("Buero")) {
				gesamtBuero += alleArtikel[i].getEinkaufsPreis();
			} else {
				gesamtKueche += alleArtikel[i].getEinkaufsPreis();
			}
		}
		System.out.println("Der Gesamteinkaufspreis der Freizeitartikel beträgt " + gesamtFreizeit
				+ "€. \n Der Gesamteinkaufspreis der Büroartikel beträgt " + gesamtBuero + "€."
				+ "\n Der Gesamteinkaufspreis der Küchenartikel beträgt " + gesamtKueche
				+ "€. \n Der Einkaufsreis für alle Artikel beträgt " + (gesamtBuero + gesamtFreizeit + gesamtKueche));

	}

	public void berechneVerkaufsPreis(Artikel[] alleArtikel) {
		int gesamtFreizeit = 0;
		int gesamtBuero = 0;
		int gesamtKueche = 0;
		for (int i = 0; i < alleArtikel.length; i++) {
			if (alleArtikel[i].getKategorie().equals("Freizeit")) {
				gesamtFreizeit += alleArtikel[i].getVerkaufsPreis();
			} else if (alleArtikel[i].getKategorie().equals("Buero")) {
				gesamtBuero += alleArtikel[i].getVerkaufsPreis();
			} else {
				gesamtKueche += alleArtikel[i].getVerkaufsPreis();
			}
		}
		System.out.println("Der Gesamtverkaufspreis der Freizeitartikel beträgt " + gesamtFreizeit
				+ "€. \n Der Gesamtverkaufspreis der Büroartikel beträgt " + gesamtBuero + "€."
				+ "\n Der Gesamtverkaufspreis der Küchenartikel beträgt " + gesamtKueche
				+ "€. \n Der Verkaufsreis für alle Artikel beträgt " + (gesamtBuero + gesamtFreizeit + gesamtKueche));

	}

	public void berechneGewinnspanne(Artikel[] alleArtikel) {
		double groeßteGewinnspanne = 0;
		double temp = 0;
		Artikel besterArtikel = alleArtikel[0];
		for (int i = 0; i < alleArtikel.length; i++) {
			temp = (alleArtikel[i].getVerkaufsPreis()) - (alleArtikel[i].getEinkaufsPreis());
			if (temp > groeßteGewinnspanne) {
				groeßteGewinnspanne = temp;
				besterArtikel = alleArtikel[i];
			}
		}
		System.out.println("Der Artikel " + besterArtikel.getName() + " hat die höchste Gewinnspanne mit "
				+ groeßteGewinnspanne + "€.");

	}

	public void nichtGuterArtikel(Artikel[] alleArtikel) {
		ArrayList<Artikel> schlechteArtikel = new ArrayList<Artikel>();
		double temp = 0;
		for (int i = 0; i < alleArtikel.length; i++) {
			temp = alleArtikel[i].getVerkaufsPreis() - alleArtikel[i].getEinkaufsPreis();

			if (temp < 0) {
				schlechteArtikel.add(alleArtikel[i]);
			}
		}
		for (int i = 0; i < schlechteArtikel.size(); i++) {
			System.out.println("Der Artikel " + schlechteArtikel.get(i).getName()
					+ " hat einen höheren Einkaufspreis als Verkaufspreis");
		}
	}

	public double berechneWarenkorb(Einkauf[] alleEinkaeufe) {
		double gesamtPreis = 0;
		for (int i = 0; i < alleEinkaeufe.length; i++) {
			gesamtPreis += alleEinkaeufe[i].getArtikel().getVerkaufsPreis();
		}

		return gesamtPreis;
	}

	public void einkaufen(Einkauf[] alleEinkaeufe) {
		for (int i = 0; i < alleEinkaeufe.length; i++) {
			alleEinkaeufe[i].getArtikel()
					.setBestandsMenge(alleEinkaeufe[i].getArtikel().getBestandsMenge() - alleEinkaeufe[i].getMenge());
		}
	}

}