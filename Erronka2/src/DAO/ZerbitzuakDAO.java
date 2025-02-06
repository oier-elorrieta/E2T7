package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modeloa.*;

public class ZerbitzuakDAO {

	private Connection konexioa;

	public void setConnection(Connection konexioa) {
		this.konexioa = konexioa;
	}

	public List<Zerbitzua> lortuZerbitzuGuztiak() {
		List<Zerbitzua> zerbitzuak = new ArrayList<>();
		String sql = "SELECT * FROM bidaia b JOIN ostatua o ON b.IDBidaia = o.IDOstatua JOIN hegaldia h ON b.IDBidaia = h.IDHegaldia JOIN joanetorri j ON h.IDHegaldia = j.IDJoanEtorri JOIN beste_zerbitzuak bz ON b.IDBidaia = bz.IDBesteZerbitzuak";

		try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String prezioaOstatua = rs.getString("prezioOstatua");
				String sarreraEguna = rs.getString("sarreraEguna");
				String irteeraEguna = rs.getString("irteeraEguna");
				String logelaMota = rs.getString("kodLogelaMota");
				String ostatua = rs.getString("izenaOstatua");
				String hegaldia = rs.getString("IDHegaldia");
				String besteZerbitzuak = rs.getString("izenaBesteZerbitzuak");
				String prezioaBesteZerbitzuak = rs.getString("prezioBesteZerbitzua");
				String joanEtorri = rs.getString("IDJoanEtorri");
				String jatorrizkoAireportua = rs.getString("KodAireIrteera");
				String helmugakoAireportua = rs.getString("KodAireHelmuga");
				String hegaldiKodea = rs.getString("HegaldiKodea");
				String aeroLinea = rs.getString("KodAirelinea");
				String prezioaHegaldia = rs.getString("prezioaHegaldia");
				String irteeraData = rs.getString("IrteeraData");
				String irteeraOrdutegia = rs.getString("IrteeraOrdutegia");
				String bidaiarenIraupena = rs.getString("BidaiaIraupen");
				String itzuleraData = rs.getString("ItzuleraData");
				String itzuleraOrdua = rs.getString("ItzuleraOrdua");
				String bidaiarenIraupenaBuelta = rs.getString("BueltakoIraupena");
				String hegaldiKodeaBuelta = rs.getString("HegaldiKodeaBuelta");
				String aeroLineaBuelta = rs.getString("KodAirelinea");

				Zerbitzua zerbitzua = new Zerbitzua(prezioaOstatua, sarreraEguna, irteeraEguna, logelaMota, ostatua,
						hegaldia, besteZerbitzuak, prezioaBesteZerbitzuak, joanEtorri, jatorrizkoAireportua,
						helmugakoAireportua, hegaldiKodea, aeroLinea, prezioaHegaldia, irteeraData, irteeraOrdutegia,
						bidaiarenIraupena, itzuleraData, itzuleraOrdua, bidaiarenIraupenaBuelta, hegaldiKodeaBuelta,
						aeroLineaBuelta);

				zerbitzuak.add(zerbitzua);
			}
		} catch (SQLException e) {
			System.err.println("Errorea zerbitzuak kontsultatzerakoan: " + e.getMessage());
		}

		return zerbitzuak;
	}

	public void gordeZerbitzua(Zerbitzua zerbitzua) {
		String sql = "INSERT INTO zerbitzua (IDBidaia, prezioa, sarreraEguna, irteeraEguna, kodLogelaMota, IDostatua, IDhegaldia, IDbesteZerbitzuak, prezioa, IDjoanEtorri, KodAireIrteera, KodAireHelmuga, hegaldiKodea, KodaireLinea, prezioaHegaldia, irteeraData, irteeraOrdutegia, bidaiaIraupen, itzuleraData, itzuleraOrdua, bueltakoIraupena, hegaldiKodeaBuelta, kodAirelinea) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement stmt = konexioa.prepareStatement(sql)) {
			stmt.setDouble(1, zerbitzua.getPrezioaOstatua());
			stmt.setString(2, zerbitzua.getSarreraEguna());
			stmt.setString(3, zerbitzua.getIrteeraEguna());
			stmt.setString(4, zerbitzua.getLogelaMota());
			stmt.setString(5, zerbitzua.getOstatua());
			stmt.setString(6, zerbitzua.getHegaldia());
			stmt.setString(7, zerbitzua.getBesteZerbitzuak());
			stmt.setDouble(8, zerbitzua.getPrezioaBesteZerbitzuak());
			stmt.setBoolean(9, zerbitzua.isJoanEtorri());
			stmt.setString(10, zerbitzua.getJatorrizkoAireportua());
			stmt.setString(11, zerbitzua.getHelmugakoAireportua());
			stmt.setString(12, zerbitzua.getHegaldiKodea());
			stmt.setString(13, zerbitzua.getAeroLinea());
			stmt.setDouble(14, zerbitzua.getPrezioaHegaldia());
			stmt.setString(15, zerbitzua.getIrteeraData());
			stmt.setString(16, zerbitzua.getIrteeraOrdutegia());
			stmt.setString(17, zerbitzua.getBidaiarenIraupena());
			stmt.setString(18, zerbitzua.getItzuleraData());
			stmt.setString(19, zerbitzua.getItzuleraOrdua());
			stmt.setString(20, zerbitzua.getBidaiarenIraupenaBuelta());
			stmt.setString(21, zerbitzua.getHegaldiKodeaBuelta());
			stmt.setString(22, zerbitzua.getAeroLineaBuelta());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errorea Zerbitzua gordetzen: " + e.getMessage());
		}
	}

}