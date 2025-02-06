package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modeloa.Aireportua;

public class AireportuaDAO {

	private Connection konexioa;

	public void setConnection(Connection konexioa) {
		this.konexioa = konexioa;
	}

	public List<Aireportua> lortuAireportuGuztiak() {
	    List<Aireportua> aireportuak = new ArrayList<>();
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


}
