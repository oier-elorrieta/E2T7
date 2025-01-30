package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Konexioa.ConnectDB;
import modeloa.Aireportua;

public class AireportuaDAO {
	
	private Connection konexioa;

	// Constructor
    public AireportuaDAO() {
        this.konexioa = ConnectDB.conectar();  // Usamos la clase ConnectDB para obtener la conexión
    }
	
    public List<Aireportua> lortuAireportuGuztiak() {
        List<Aireportua> aireportuak = new ArrayList<>();
        String sql = "SELECT * FROM Aireportua";

        try (Statement stmt = konexioa.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Aireportua aireportua = new Aireportua(sql, sql);
                aireportua.setIdentifikatzailea(rs.getString("kodAireportua"));
                aireportua.setIzena(rs.getString("hiria"));
                aireportuak.add(aireportua);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Para ver el detalle del error
            System.out.println("Errorea Herrialdeak eskuratzen: " + e.getMessage());
        }

        return aireportuak;
    }
	

}
