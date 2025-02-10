package DAO;

import java.sql.*;
import java.util.ArrayList;

import Konexioa.ConnectDB;
import modeloa.*;

public class HerrialdeaDAO {

	private static Connection konexioa;
	ConnectDB conexion = new ConnectDB();

	public void setConnection(Connection konexioa) {
		HerrialdeaDAO.konexioa = konexioa;
	}

	public ArrayList<Herrialdea> lortuHerrialdeGuztiak() {
		ArrayList<Herrialdea> herrialdeak = new ArrayList<>();
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
	
	public String lortuID(String herrialdea) {
		String sql = "SELECT kodHerrialdea, deskribapena FROM Herrialdea";
		String herrialdeKodea = "";
		
		try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				if (herrialdea.equals(rs.getString("deskribapena"))) {
					herrialdeKodea =rs.getString("kodHerrialdea");
				} 
			}
			} catch (SQLException z) {
				System.err.println("Errorea herrialdea berreskuratzen: " + z.getMessage());
			}
		
		return herrialdeKodea;
		}
	}


