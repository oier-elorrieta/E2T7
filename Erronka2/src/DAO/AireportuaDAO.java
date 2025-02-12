package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modeloa.Aireportua;

public class AireportuaDAO {

	private static Connection konexioa;

	public void setConnection(Connection konexioa) {
		this.konexioa = konexioa;
	}

	public ArrayList<Aireportua> lortuAireportuGuztiak() {
	    ArrayList<Aireportua> aireportuak = new ArrayList<>();
	    String kontsulta = "SELECT kodAireportua, hiria FROM aireportua";
	    try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(kontsulta)) {
	        while (rs.next()) {
	            // Crear el objeto Aireportua y añadirlo a la lista
	            String kodAireportua = rs.getString("kodAireportua");
	            String hiria = rs.getString("hiria");
	            Aireportua aireportua = new Aireportua(kodAireportua, hiria);  // Ajusta según el constructor de tu clase Aireportua
	            aireportuak.add(aireportua);
	        }
	    } catch (SQLException e) {
	        System.err.println("Errorea aireportuen kontsulta exekutatzerakoan: " + e.getMessage());
	    }

	    return aireportuak;
	}
	
	public static String lortuID(String aireportua) {
		String sql = "SELECT kodAireportua, hiria FROM aireportua";
		String aireportuKodea = "";
		
		try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				if (aireportua.equals(rs.getString("hiria"))) {
					aireportuKodea =rs.getString("kodAireportua");
				} 
			}
			} catch (SQLException z) {
				System.err.println("Errorea bidai motak berreskuratzen: " + z.getMessage());
			}
		
		return aireportuKodea;
		}

}
