import java.util.ArrayList;

public class Person {
	// Verk�ufer ist true wenn im Verk�ufer-Modus sonst false
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
			System.err.println("Sie haben nicht das Recht, den Einkaufspreis zu �ndern");
		}
	}

	public void verkaufsPreisAendern(Artikel artikel, double verkaufsPreis) {
		if (verkaeufer) {
			artikel.setVerkaufsPreis(verkaufsPreis);
		} else {
			System.err.println("Sie haben nicht das Recht, den Einkaufspreis zu �ndern");
		}
	}

	public void bestandsMengeAender(Artikel artikel, int bestandsMenge) {
		if (verkaeufer) {
			artikel.setBestandsMenge(bestandsMenge);
		} else {
			System.err.println("Sie haben nicht das Recht, den Einkaufspreis zu �ndern");
		}
	}

	public void berechneEinkaufsPreis(Artikel[] alleArtikel) {// Freizeit B�ro und K�che
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
		System.out.println("Der Gesamteinkaufspreis der Freizeitartikel betr�gt " + gesamtFreizeit
				+ "�. \n Der Gesamteinkaufspreis der B�roartikel betr�gt " + gesamtBuero + "�."
				+ "\n Der Gesamteinkaufspreis der K�chenartikel betr�gt " + gesamtKueche
				+ "�. \n Der Einkaufsreis f�r alle Artikel betr�gt " + (gesamtBuero + gesamtFreizeit + gesamtKueche));

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
		System.out.println("Der Gesamtverkaufspreis der Freizeitartikel betr�gt " + gesamtFreizeit
				+ "�. \n Der Gesamtverkaufspreis der B�roartikel betr�gt " + gesamtBuero + "�."
				+ "\n Der Gesamtverkaufspreis der K�chenartikel betr�gt " + gesamtKueche
				+ "�. \n Der Verkaufsreis f�r alle Artikel betr�gt " + (gesamtBuero + gesamtFreizeit + gesamtKueche));

	}

	public void berechneGewinnspanne(Artikel[] alleArtikel) {
		double groe�teGewinnspanne = 0;
		double temp = 0;
		Artikel besterArtikel = alleArtikel[0];
		for (int i = 0; i < alleArtikel.length; i++) {
			temp = (alleArtikel[i].getVerkaufsPreis()) - (alleArtikel[i].getEinkaufsPreis());
			if (temp > groe�teGewinnspanne) {
				groe�teGewinnspanne = temp;
				besterArtikel = alleArtikel[i];
			}
		}
		System.out.println("Der Artikel " + besterArtikel.getName() + " hat die h�chste Gewinnspanne mit "
				+ groe�teGewinnspanne + "�.");

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
					+ " hat einen h�heren Einkaufspreis als Verkaufspreis");
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