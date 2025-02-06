package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modeloa.Bidaia;

public class BidaiaDAO {

	private Connection konexioa;

	public void setConnection(Connection konexioa) {
		this.konexioa = konexioa;
	}

	public List<Bidaia> lortuBidaiGuztiak() {
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
	}

}


