package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modeloa.*;

public class ZerbitzuakDAO {

	private static Connection konexioa;

	public void setConnection(Connection konexioa) {
		ZerbitzuakDAO.konexioa = konexioa;
	}

	public static ArrayList<Zerbitzua> lortuZerbitzuBidaia(int IDBidaia) {
		ArrayList<Zerbitzua> zerbitzuak = new ArrayList<>();
		String sql = "SELECT b.IDBidaia, b.izenaBidaia, b.deskribapenaBidaia, h.IDHegaldia, h.HegaldiKodea, h.BidaiaIraupen, h.prezioaHegaldia, h.IrteeraData, h.IrteeraOrdutegia, j.IDJoanEtorri, j.ItzuleraOrdua, j.ItzuleraData, j.BueltakoIraupena, j.HegaldiKodeaBuelta, o.IDostatua, o.izenaOstatua, o.hiria, o.prezioOstatua, o.sarreraEguna, o.irteeraEguna, o.kodLogelaMota, h.kodAireIrteera, h.kodAireHelmuga, h.kodAirelinea, j.kodAireIrteera, j.kodAireHelmuga, j.kodAirelinea, bz.IDBesteZerbitzuak, bz.izenaBesteZerbitzuak, bz.data, bz.deskribapenaBesteZerbitzuak, bz.prezioBesteZerbitzua FROM bidaia b LEFT JOIN hegaldia h ON b.IDBidaia = h.bidaiaHe LEFT JOIN joanetorri j ON h.IDHegaldia = j.IDJoanEtorri LEFT JOIN ostatua o ON b.IDBidaia = o.bidaiaOs LEFT JOIN beste_zerbitzuak bz ON b.IDBidaia = bz.bidaiaBe "
				+ "WHERE b.IDBidaia =" + IDBidaia +";";

		try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				double prezioaOstatua = rs.getInt("prezioOstatua");
				String sarreraEguna = rs.getString("sarreraEguna");
				String irteeraEguna = rs.getString("irteeraEguna");
				String logelaMota = rs.getString("kodLogelaMota");
				String ostatua = rs.getString("izenaOstatua");
				int hegaldia = rs.getInt("IDHegaldia");
				String besteZerbitzuak = rs.getString("izenaBesteZerbitzuak");
				double prezioaBesteZerbitzuak = rs.getInt("prezioBesteZerbitzua");
				int joanEtorri = rs.getInt("IDJoanEtorri");
				String jatorrizkoAireportua = rs.getString("h.KodAireIrteera");
				String helmugakoAireportua = rs.getString("h.KodAireHelmuga");
				String hegaldiKodea = rs.getString("HegaldiKodea");
				String aeroLinea = rs.getString("h.KodAirelinea");
				double prezioaHegaldia = rs.getInt("prezioaHegaldia");
				String irteeraData = rs.getString("IrteeraData");
				String irteeraOrdutegia = rs.getString("IrteeraOrdutegia");
				int bidaiarenIraupena = rs.getInt("BidaiaIraupen");
				String itzuleraData = rs.getString("ItzuleraData");
				String itzuleraOrdua = rs.getString("ItzuleraOrdua");
				int bidaiarenIraupenaBuelta = rs.getInt("BueltakoIraupena");
				String hegaldiKodeaBuelta = rs.getString("HegaldiKodeaBuelta");
				String aeroLineaBuelta = rs.getString("j.KodAirelinea");

				Zerbitzua zerbitzua = new Zerbitzua(prezioaOstatua, sarreraEguna, irteeraEguna, logelaMota, ostatua,
						hegaldia, besteZerbitzuak, prezioaBesteZerbitzuak, joanEtorri, jatorrizkoAireportua,
						helmugakoAireportua, hegaldiKodea, aeroLinea, prezioaHegaldia, irteeraData, irteeraOrdutegia,
						bidaiarenIraupena, itzuleraData, itzuleraOrdua, bidaiarenIraupenaBuelta, hegaldiKodeaBuelta,
						aeroLineaBuelta, aeroLineaBuelta);

				zerbitzuak.add(zerbitzua);
			}
		} catch (SQLException e) {
			System.err.println("Errorea zerbitzuak kontsultatzerakoan: " + e.getMessage());
		}

		return zerbitzuak;
	}

	/*public void gordeZerbitzua(Zerbitzua zerbitzua) {
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
	}*/

}