import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Starterklasse {

	public static void main(String[] args) {
		Artikel[] alleArtikel = new Artikel[9];
		Scanner scanner = new Scanner(System.in);
		String[] dateiName = new String[9];
		dateiName[0] = "C:\\Users\\Marvin\\Desktop\\Jojo.txt";
		dateiName[1] = "C:\\Users\\Marvin\\Desktop\\Schach.txt";
		dateiName[2] = "C:\\Users\\Marvin\\Desktop\\Bueroklammern.txt";
		dateiName[3] = "C:\\Users\\Marvin\\Desktop\\Druckerpapier.txt";
		dateiName[4] = "C:\\Users\\Marvin\\Desktop\\Tischtennis-Schlaeger.txt";
		dateiName[5] = "C:\\Users\\Marvin\\Desktop\\Tischkalender.txt";
		dateiName[6] = "C:\\Users\\Marvin\\Desktop\\Toaster.txt";
		dateiName[7] = "C:\\Users\\Marvin\\Desktop\\Mikrowelle.txt";
		dateiName[8] = "C:\\Users\\Marvin\\Desktop\\Mixer.txt";
		String[] test = new String [5];
		for (int i = 0; i < dateiName.length; i++) {

			test = ladeDatei(dateiName[i]);
			alleArtikel[i] = new Artikel(test[0], Double.parseDouble(test[1]), Double.parseDouble(test[2]),
					Integer.parseInt(test[3]), test[4]);
		}
		Person tester = new Person(true);
		int i = 0;
		while (i == 0) {
			if (tester.isVerkaeufer()==true) {
				System.out.println("Sie befinden sich im Verkäufer-Modus.");
				System.out.println("Sie haben nun folgende Möglichkeiten:\n1. Die Bestandsmenge eines Artikels verändern. \n"
						+ "2. Den Einkaufspreis eines Artikels ändern. \n3. Den Verkaufspreis einen Artikels ändern. \n4. Sich den gesamt Einkaufspreis aller Artikel geordnet nach Kategorien ausgebenlassen. \n"
						+ "5. Sich den Verkaufspreis aller Artikel geordnet nach Kategorien ausgeben lassen. \n6. Den Artikel mit der höchsten Gewinnspanne ermitteln. \n7. Die Artikel ausgeben lassen, welche für mehr eingekauft werden als sie verkauft werden.");
				System.out.println("Bitte geben sie eine der sieben Zahlen ein, für die Operation welche dahinter aufgelistet ist");
				int operation = scanner.nextInt();
				if(i>7 || i<1) {
					System.err.println("Falsche Eingabe, bitte noch einmal");
					main(args);
				}
				return;
			}
		}

	}

	private static String[] ladeDatei(String dateiName) {
		File file = new File(dateiName);
		String[] test = new String[6];
		if (!file.canRead() || !file.isFile()) {
			System.exit(0);
		}

		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(dateiName));
			String zeile = null;
			int i = 0;
			while ((zeile = in.readLine()) != null) {
				test[i] = zeile;
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
				}
		}
		return test;
	}
}
