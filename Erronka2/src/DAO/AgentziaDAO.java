package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modeloa.Agentzia;

public class AgentziaDAO {

	private static Connection konexioa;

	public void setConnection(Connection konexioa) {
		AgentziaDAO.konexioa = konexioa;
	}

	public ArrayList<Agentzia> lortuAgentziaGuztiak() {
		ArrayList<Agentzia> agentziak = new ArrayList<>();
		String kontsulta = "SELECT IDAgentzia, izenaAgentzia, logoa, kolorea, Erabiltzaile, Pasahitza, kodAgMota, kodLangKop FROM agentzia";
		try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(kontsulta)) {
			while (rs.next()) {
				// Crear el objeto Agentzia y añadirlo a la lista
				int idAgentzia = rs.getInt("IDAgentzia");
				String izenaAgentzia = rs.getString("izenaAgentzia");
				String logoAgentzia = rs.getString("logoa");
				String koloreAgentzia = rs.getString("kolorea");
				String erabiltzailea = rs.getString("Erabiltzaile");
				String pasahitza = rs.getString("Pasahitza");
				String kodAgentzia = rs.getString("kodAgMota");
				String kodLangKop = rs.getString("kodLangKop");
				Agentzia agentzia = new Agentzia(idAgentzia, izenaAgentzia, logoAgentzia, koloreAgentzia, erabiltzailea,
						pasahitza, kodAgentzia, kodLangKop, null); // Ajusta según el constructor de tu clase Aireportua
				agentziak.add(agentzia);
			}
		} catch (SQLException e) {
			System.err.println("Errorea agentzien kontsulta exekutatzerakoan: " + e.getMessage());
		}

		return agentziak;
	}

	public static String lortuErabiltzailea(String erabiltzailea) {

		String sql = "SELECT Erabiltzaile FROM agentzia WHERE Erabiltzaile = ?";

		// Usamos try-with-resources para asegurarnos de que los recursos se cierren
		// correctamente
		try (PreparedStatement ps = konexioa.prepareStatement(sql)) {
			// Establecemos el valor del parámetro en el PreparedStatement
			ps.setString(1, erabiltzailea);

			// Ejecutamos la consulta
			ResultSet rs = ps.executeQuery();

			// Si encontramos el Erabiltzaile, devolvemos el valor
			if (rs.next()) {
				return rs.getString("Erabiltzaile"); // Retorna el valor de la columna Erabiltzaile
			} else {
				return null; // Si no lo encuentra, devolvemos null
			}

		} catch (SQLException e) {
			System.err.println("Error al consultar la base de datos: " + e.getMessage());
			return null; // Si ocurre algún error, retornamos null
		}
	}

	public static String lortuPasahitza(String erabiltzailea) {

		String sql = "SELECT Erabiltzaile, Pasahitza FROM agentzia WHERE Erabiltzaile = ?";

		// Usamos try-with-resources para asegurarnos de que los recursos se cierren
		// correctamente
		try (PreparedStatement ps = konexioa.prepareStatement(sql)) {
			// Establecemos el valor del parámetro en el PreparedStatement
			ps.setString(1, erabiltzailea);

			// Ejecutamos la consulta
			ResultSet rs = ps.executeQuery();

			// Si encontramos el Erabiltzaile, devolvemos el valor
			if (rs.next()) {
				return rs.getString("Pasahitza"); // Retorna el valor de la columna Erabiltzaile
			} else {
				return null; // Si no lo encuentra, devolvemos null
			}

		} catch (SQLException e) {
			System.err.println("Error al consultar la base de datos: " + e.getMessage());
			return null; // Si ocurre algún error, retornamos null
		}
	}

	public static int lortuID(String erabiltzailea) {

		String sql = "SELECT IDAgentzia FROM agentzia WHERE Erabiltzaile = ?";

		// Usamos try-with-resources para asegurarnos de que los recursos se cierren
		// correctamente
		try (PreparedStatement ps = konexioa.prepareStatement(sql)) {
			// Establecemos el valor del parámetro en el PreparedStatement
			ps.setString(1, erabiltzailea);

			// Ejecutamos la consulta
			ResultSet rs = ps.executeQuery();

			// Si encontramos el Erabiltzaile, devolvemos el valor
			if (rs.next()) {
				return rs.getInt("IDAgentzia"); // Retorna el valor de la columna Erabiltzaile
			} else {
				return -1; // Si no lo encuentra, devolvemos null
			}

		} catch (SQLException e) {
			System.err.println("Error al consultar la base de datos: " + e.getMessage());
			return -1; // Si ocurre algún error, retornamos null
		}
	}

	public boolean sartuAgentzia(Agentzia agentzia) {
		String sql = "INSERT INTO Agentzia (izenaAgentzia, logoa, kolorea, Pasahitza, Erabiltzaile, kodAgMota, kodLangKop) "
				+ "VALUES ('" + agentzia.getIzena() + "', '" + agentzia.getLogoa() + "', '" + agentzia.getMarkaKolorea()
				+ "', '" + agentzia.getPasahitza() + "', '" + agentzia.getErabiltzaile() + "', '"
				+ agentzia.getAgentziaMota() + "', '" + agentzia.getLangileKopurua() + "');";

		try (Statement stmt = konexioa.createStatement()) {
			int filasAfectadas = stmt.executeUpdate(sql); // Ejecuta la consulta

			return filasAfectadas > 0; // Devuelve true si la inserción fue exitosa
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al insertar Agentzia: " + e.getMessage());
			return false;
		} catch (Exception w) {
			System.out.println(w.getMessage());
			return false;
		}

	}
}
