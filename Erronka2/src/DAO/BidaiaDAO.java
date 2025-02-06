package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modeloa.Bidaia;

public class BidaiaDAO {

	private static Connection konexioa;

	public void setConnection(Connection konexioa) {
		this.konexioa = konexioa;
	}

	/*public List<Bidaia> lortuBidaiGuztiak() {
		List<Bidaia> bidaiak = new ArrayList<>();
		String sql = "SELECT * FROM Bidaia b JOIN bidaia_mota m ON b.kodBidaiaMota = m.kodBidaiaMota JOIN agentzia a ON b.IDAgentzia = a.IDAgentzia";

		try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String identifikatzailea = rs.getString("IDBidaia");
				String izena = rs.getString("izenaBidaia");
				String dataAmaiera = rs.getString("dataAmaiera");
				String dataIrteera = rs.getString("dataIrteera");
				String deskribapena = rs.getString("deskribapenaBidaia");
				String helmuga = rs.getString("KodHerrialdea");
				String agentzia = rs.getString("izenaAgentzia");
				String bidaiaMota = rs.getString("deskribapenaBidaiMota");

				Bidaia bidaia = new Bidaia(identifikatzailea, izena, dataAmaiera, dataIrteera, deskribapena, helmuga,
						null, agentzia, null, bidaiaMota);
				bidaiak.add(bidaia);
			}
		} catch (SQLException e) {
			System.err.println("Errorea bidaiak kontsultatzerakoan: " + e.getMessage());
		}

		return bidaiak;
	}*/
	
	public static List<Bidaia> lortuBidaiAgentzia(int erabiltzailezbk) {
		List<Bidaia> bidaiak = new ArrayList<>();
		String sql = "SELECT IDBidaia, izenaBidaia, dataAmaiera, dataIrteera, deskribapenaBidaia, b.KodHerrialdea, a.izenaAgentzia, b.IDAgentzia, b.kodBidaiaMota, m.deskribapenaBidaiMota, DATEDIFF(dataAmaiera, dataIrteera) AS iraupena FROM Bidaia b JOIN bidaia_mota m ON b.kodBidaiaMota = m.kodBidaiaMota JOIN agentzia a ON b.IDAgentzia = a.IDAgentzia where a.IDAgentzia =" + erabiltzailezbk;

		try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String identifikatzailea = rs.getString("IDBidaia");
				String izena = rs.getString("izenaBidaia");
				String deskribapena = rs.getString("deskribapenaBidaia");
				String dataIrteera = rs.getString("dataIrteera");
				String dataAmaiera = rs.getString("dataAmaiera");
				int iraupena = rs.getInt("iraupena");
				String helmuga = rs.getString("KodHerrialdea");
				String agentzia = rs.getString("izenaAgentzia");
				String bidaiaMota = rs.getString("deskribapenaBidaiMota");
				
				Bidaia bidaia = new Bidaia(identifikatzailea, izena, deskribapena, bidaiaMota, dataIrteera, dataAmaiera, iraupena, helmuga, null, agentzia);
				bidaiak.add(bidaia);
			}
		} catch (SQLException e) {
			System.err.println("Errorea bidaiak kontsultatzerakoan: " + e.getMessage());
		}

		return bidaiak;

	}
}


