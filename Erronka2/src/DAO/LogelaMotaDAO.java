package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Konexioa.ConnectDB;
import modeloa.LogelaMota;

public class LogelaMotaDAO {
	
	private static Connection konexioa;
	ConnectDB conexion = new ConnectDB();

	public void setConnection(Connection konexioa) {
		LogelaMotaDAO.konexioa = konexioa;
	}
	
	public ArrayList<LogelaMota> lortuLogelaMotak() {
		
		ArrayList<LogelaMota> logelaMotak = new ArrayList<LogelaMota>();
		
		String kontsulta = "SELECT kodLogelaMota, deskribapenaLogelaMota from logela_mota;";
		try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(kontsulta)) {
			while (rs.next()) {
				String kodLogelaMota = rs.getString("kodLogelaMota");
				String deskribapenaLogelaMota = rs.getString("deskribapenaLogelaMota");
				LogelaMota logelaMota = new LogelaMota(kodLogelaMota, deskribapenaLogelaMota);
				logelaMotak.add(logelaMota);
				
			}
		} catch (SQLException e) {
			System.err.println("Errorea agentzien kontsulta exekutatzerakoan: " + e.getMessage());
		}
		return logelaMotak;
		
		
	}
	
	public static String lortuID(String logelaMota) {
		String sql = "SELECT kodLogelaMota, deskribapenaLogelaMota FROM logela_mota";
		String motaKodea = "";
		
		try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				if (logelaMota.equals(rs.getString("deskribapenaLogelaMota"))) {
					motaKodea =rs.getString("kodLogelaMota");
				} 
			}
			} catch (SQLException z) {
				System.err.println("Errorea bidai motak berreskuratzen: " + z.getMessage());
			}
		
		return motaKodea;
		}

}



