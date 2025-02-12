package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Konexioa.ConnectDB;
import modeloa.Airelinea;

public class AirelineaDAO {
		
		private static Connection konexioa;
		ConnectDB conexion = new ConnectDB();

		public void setConnection(Connection konexioa) {
			AirelineaDAO.konexioa = konexioa;
		}
		
		public ArrayList<Airelinea> lortuAirelineak() {
			
			ArrayList<Airelinea> airelineak = new ArrayList<Airelinea>();
			
			String kontsulta = "SELECT kodAirelinea, izenaAirelinea, herrialdea from airelinea;";
			try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(kontsulta)) {
				while (rs.next()) {
					String kodAirelinea = rs.getString("kodAirelinea");
					String izenaAirelinea = rs.getString("izenaAirelinea");
					String herrialdea = rs.getString("herrialdea");
					
					Airelinea airelinea = new Airelinea(kodAirelinea, izenaAirelinea, herrialdea);
					airelineak.add(airelinea);
					
				}
			} catch (SQLException e) {
				System.err.println("Errorea agentzien kontsulta exekutatzerakoan: " + e.getMessage());
			}
			return airelineak;
			
			
		}
		
		public static String lortuID(String airelinea) {
			String sql = "SELECT kodAirelinea, izenaAirelinea from airelinea;";
			String airelineaKodea = "";
			
			try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					if (airelinea.equals(rs.getString("izenaAirelinea"))) {
						airelineaKodea =rs.getString("kodAirelinea");
					} 
				}
				} catch (SQLException z) {
					System.err.println("Errorea bidai motak berreskuratzen: " + z.getMessage());
				}
			
			return airelineaKodea;
			}

	}