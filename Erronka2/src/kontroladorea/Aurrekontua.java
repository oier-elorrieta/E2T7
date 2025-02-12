package kontroladorea;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import modeloa.Bidaia;
import modeloa.Zerbitzua;

public class Aurrekontua {

	public static void sortuAurrekontua(Bidaia bidaia) {
		try {
			BufferedWriter oBufferedWriter = new BufferedWriter(new FileWriter("Aurrekontua" + bidaia.getIzena() + ".txt"));

			double prezioOsoa = 0;

			oBufferedWriter.write("Agentzia: " + bidaia.getAgentziaIzena());
			oBufferedWriter.newLine();
			oBufferedWriter.write("Aurrekontua: ");
			oBufferedWriter.newLine();

			if (bidaia.getZerbitzuak() != null) {
				oBufferedWriter.newLine();
				for (Zerbitzua zerbitzua : bidaia.getZerbitzuak()) {
					// TODO Controlar la salida de los servicios
					if (zerbitzua.getIzenaOstatua() != null) {
						oBufferedWriter.write(
								"Ostatua: " + zerbitzua.getIzenaOstatua() + "\t" + zerbitzua.getPrezioaOstatua());
						prezioOsoa += zerbitzua.getPrezioaOstatua();
						oBufferedWriter.newLine();
					}

					if (zerbitzua.getPrezioaHegaldia() > 0) {
						oBufferedWriter.write("Hegaldiak: " + "\t" + zerbitzua.getPrezioaHegaldia());
						prezioOsoa += zerbitzua.getPrezioaHegaldia();
						oBufferedWriter.newLine();
					}

					if (zerbitzua.getPrezioaBesteZerbitzuak() > 0) {
						oBufferedWriter.write("Beste Zerbitzuak: " + zerbitzua.getBesteZerbitzuak() + "\t"
								+ zerbitzua.getPrezioaBesteZerbitzuak());
						prezioOsoa += zerbitzua.getPrezioaBesteZerbitzuak();
						oBufferedWriter.newLine();
					}
				}
				oBufferedWriter.newLine();
				oBufferedWriter.write("Bidaiaren prezio osoa: " + prezioOsoa);
			}

			oBufferedWriter.close();
		} catch (FileNotFoundException fn) {
			System.out.println("Ez da fitxategia aurkitzen");
		} catch (IOException io) {
			System.out.println("I/O errorea ");
		}

	}

}
