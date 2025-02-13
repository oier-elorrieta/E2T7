package kontroladorea;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import modeloa.Bidaia;
import modeloa.Zerbitzua;

public class Aurrekontua {

	public static void sortuAurrekontua(Bidaia bidaia) {
		try {
			BufferedWriter oBufferedWriter = new BufferedWriter(
					new FileWriter("Aurrekontua_" + bidaia.getIzena() + ".txt"));

			double prezioOsoa = 0;

			String columnHeader = String.format("%-30s %-20s %-15s", "Zerbitzua", "Deskribapena", "Prezioa");
			String separatorLine = new String(new char[columnHeader.length()]).replace("\0", "-");

			oBufferedWriter.write(separatorLine);
			oBufferedWriter.newLine();
			oBufferedWriter.write("  AURKEKONTUA - " + bidaia.getIzena());
			oBufferedWriter.newLine();
			oBufferedWriter.write("Agentzia: " + bidaia.getAgentziaIzena());
			oBufferedWriter.newLine();
			oBufferedWriter.write(separatorLine);
			oBufferedWriter.newLine();

			oBufferedWriter.write(columnHeader);
			oBufferedWriter.newLine();
			oBufferedWriter.write(separatorLine);
			oBufferedWriter.newLine();

			if (bidaia.getZerbitzuak() != null) {
				for (Zerbitzua zerbitzua : bidaia.getZerbitzuak()) {

					if (zerbitzua.getIzenaOstatua() != null) {
						oBufferedWriter.write(String.format("%-30s %-20s %-15.2f", "Ostatua",
								zerbitzua.getIzenaOstatua(), zerbitzua.getPrezioaOstatua()));
						prezioOsoa += zerbitzua.getPrezioaOstatua();
						oBufferedWriter.newLine();
					}

					if (zerbitzua.getPrezioaHegaldia() > 0) {
						oBufferedWriter.write(String.format("%-30s %-20s %-15.2f", "Hegaldiak", "Hegaldi prezioa",
								zerbitzua.getPrezioaHegaldia()));
						prezioOsoa += zerbitzua.getPrezioaHegaldia();
						oBufferedWriter.newLine();
					}

					if (zerbitzua.getPrezioaBesteZerbitzuak() > 0) {
						oBufferedWriter.write(String.format("%-30s %-20s %-15.2f", "Beste Zerbitzuak",
								zerbitzua.getBesteZerbitzuak(), zerbitzua.getPrezioaBesteZerbitzuak()));
						prezioOsoa += zerbitzua.getPrezioaBesteZerbitzuak();
						oBufferedWriter.newLine();
					}

				}
			}

			oBufferedWriter.write(separatorLine);
			oBufferedWriter.newLine();
			oBufferedWriter.write(String.format("%-30s %-20s %-15.2f", "", "Bidaiaren Prezio Osoa", prezioOsoa));
			oBufferedWriter.newLine();
			oBufferedWriter.write(separatorLine);
			oBufferedWriter.newLine();

			JOptionPane.showMessageDialog(null, "Aurrekontua Sortuta");

			oBufferedWriter.close();

		} catch (FileNotFoundException fn) {
			System.out.println("Ez da fitxategia aurkitzen");
		} catch (IOException io) {
			System.out.println("I/O errorea ");
		}
	}

}