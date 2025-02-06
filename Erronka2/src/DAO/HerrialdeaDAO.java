package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modeloa.*;

public class HerrialdeaDAO {

	private Connection konexioa;

	public void setConnection(Connection konexioa) {
		this.konexioa = konexioa;
	}

	public List<Herrialdea> lortuHerrialdeGuztiak() {
		List<Herrialdea> herrialdeak = new ArrayList<>();
		String sql = "SELECT kodHerrialdea, deskribapena FROM Herrialdea";

		try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String kodea = rs.getString("kodHerrialdea");
				String deskribapena = rs.getString("deskribapena");
				Herrialdea herrialdea = new Herrialdea(kodea, deskribapena);
				herrialdeak.add(herrialdea);
			}
		} catch (SQLException e) {
			System.err.println("Errorea herrialdeak kontsultatzerakoan: " + e.getMessage());
		}
		return herrialdeak;
	}

	public void gordeHerrialdea(Herrialdea herrialdea) {
		String sql = "INSERT INTO Herrialdea (kodHerrialdea, deskribapena) VALUES (?, ?)";

		try (PreparedStatement stmt = konexioa.prepareStatement(sql)) {
			stmt.setString(1, herrialdea.getKodea());
			stmt.setString(2, herrialdea.getHerrialdea());

			stmt.executeUpdate();
			System.out.println("Herrialdea insertatu da!");
		} catch (SQLException e) {
			System.err.println("Errorea herrialdea gordetzean: " + e.getMessage());
		}
	}

}
