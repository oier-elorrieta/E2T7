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

	public static ArrayList<Zerbitzua> lortuZerbitzuBidaia(String identifikatzailea) {
		ArrayList<Zerbitzua> zerbitzuak = new ArrayList<>();
		
		String sqlHegaldia = "SELECT h.IDHegaldia, h.HegaldiKodea, h.BidaiaIraupen, h.prezioaHegaldia, h.IrteeraData, h.kodAireIrteera, h.kodAireHelmuga, h.kodAirelinea, h.irteeraOrdutegia FROM hegaldia h WHERE h.bidaiaHe = " + identifikatzailea + ";";
		
		String sqlJoanetorri= "SELECT j.IDJoanEtorri, j.ItzuleraOrdua, j.ItzuleraData, j.BueltakoIraupena, j.HegaldiKodeaBuelta, j.kodAireIrteera, j.kodAireHelmuga, j.kodAirelinea, h.IDHegaldia, h.bidaiaHe FROM joanetorri j LEFT JOIN hegaldia h ON h.IDHegaldia = j.IDJoanEtorri WHERE h.bidaiaHe = " + identifikatzailea + ";";
		
		String sqlOstatua= "SELECT o.IDostatua, o.izenaOstatua, o.hiria, o.prezioOstatua, o.sarreraEguna, o.irteeraEguna, o.bidaiaOs, o.kodLogelaMota FROM ostatua o WHERE o.bidaiaOs = " + identifikatzailea + ";";
		
		String sqlBeste= "SELECT bz.IDBesteZerbitzuak, bz.izenaBesteZerbitzuak, bz.data, bz.deskribapenaBesteZerbitzuak, bz.prezioBesteZerbitzua, bz.data, bz.bidaiaBe FROM beste_zerbitzuak bz WHERE bz.bidaiaBe = " + identifikatzailea + ";";
		
		
		try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(sqlHegaldia)) {
			while (rs.next()) {
				if (rs.getInt("h.IDHegaldia")>0) {
					int hegaldia = rs.getInt("h.IDHegaldia");
					String jatorrizkoAireportua = rs.getString("h.KodAireIrteera");
					String helmugakoAireportua = rs.getString("h.KodAireHelmuga");
					String hegaldiKodea = rs.getString("h.HegaldiKodea");
					String aeroLinea = rs.getString("h.KodAirelinea");
					double prezioaHegaldia = rs.getInt("h.prezioaHegaldia");
					String irteeraData = rs.getString("h.IrteeraData");
					String irteeraOrdutegia = rs.getString("h.IrteeraOrdutegia");
					int bidaiarenIraupena = rs.getInt("h.BidaiaIraupen");
	
	
					Zerbitzua zerbitzua = new Zerbitzua(hegaldia, jatorrizkoAireportua, helmugakoAireportua, hegaldiKodea, aeroLinea, prezioaHegaldia, irteeraData, irteeraOrdutegia, bidaiarenIraupena);
	
					zerbitzuak.add(zerbitzua);
				}
			}
		} catch (SQLException e) {
			System.err.println("Errorea hegaldiak kontsultatzerakoan: " + e.getMessage());
		}
		
		try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(sqlJoanetorri)) {
			while (rs.next()) {
				
				if (rs.getInt("j.IDJoanEtorri")>0) {
					String jatorrizkoAireportua = rs.getString("j.KodAireIrteera");
					String helmugakoAireportua = rs.getString("j.KodAireHelmuga");
					int joanEtorri = rs.getInt("IDJoanEtorri");
					String itzuleraData = rs.getString("j.ItzuleraData");
					String itzuleraOrdua = rs.getString("j.ItzuleraOrdua");
					int bidaiarenIraupenaBuelta = rs.getInt("j.BueltakoIraupena");
					String hegaldiKodeaBuelta = rs.getString("j.HegaldiKodeaBuelta");
					String aeroLineaBuelta = rs.getString("j.KodAirelinea");
	
					Zerbitzua zerbitzua = new Zerbitzua(joanEtorri, jatorrizkoAireportua, helmugakoAireportua, itzuleraData,
							itzuleraOrdua, bidaiarenIraupenaBuelta, hegaldiKodeaBuelta, aeroLineaBuelta);
	
					zerbitzuak.add(zerbitzua);
				}
			}
		} catch (SQLException e) {
			System.err.println("Errorea bueltako hegaldiak kontsultatzerakoan: " + e.getMessage());
		}
		
		try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(sqlOstatua)) {
			while (rs.next()) {
				
				if (rs.getInt("o.IDOstatua")>0) {
					int kodeaOstatua = rs.getInt("o.IDOstatua");
					double prezioaOstatua = rs.getInt("o.prezioOstatua");
					String sarreraEguna = rs.getString("o.sarreraEguna");
					String irteeraEguna = rs.getString("o.irteeraEguna");
					String logelaMota = rs.getString("o.kodLogelaMota");
					String ostatua = rs.getString("o.izenaOstatua");
	
					Zerbitzua zerbitzua = new Zerbitzua(kodeaOstatua, prezioaOstatua, sarreraEguna, irteeraEguna,
							logelaMota, ostatua);
	
					zerbitzuak.add(zerbitzua);
				}
			}
		} catch (SQLException e) {
			System.err.println("Errorea ostatuak kontsultatzerakoan: " + e.getMessage());
		}
		
		try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(sqlBeste)) {
			while (rs.next()) {
				
				if (rs.getInt("bz.IDBesteZerbitzuak")>0) {
					int kodeaBesteZerbitzua = rs.getInt("bz.IDBesteZerbitzuak");
					String besteZerbitzuak = rs.getString("bz.izenaBesteZerbitzuak");
					double prezioaBesteZerbitzuak = rs.getInt("bz.prezioBesteZerbitzua");
					String dataBesteZerbitzua = rs.getString("bz.data");
					
	
					Zerbitzua zerbitzua = new Zerbitzua(kodeaBesteZerbitzua, besteZerbitzuak, prezioaBesteZerbitzuak, dataBesteZerbitzua);
	
					zerbitzuak.add(zerbitzua);
				}
			}
		} catch (SQLException e) {
			System.err.println("Errorea beste zerbitzuak kontsultatzerakoan: " + e.getMessage());
		}

		return zerbitzuak;
	}
	
		public static void ezabatuZerbitzua(String IDTaula, String IDLerroaZ) {
		
			String atributoa = "";
			if (IDTaula.equals("Ostatua")) {
				IDTaula="ostatua";
				atributoa = "IDOstatua";
			} else if (IDTaula.equals("Hegaldia")) {
					IDTaula="hegaldia";
				atributoa = "IDHegaldia";
			} else if (IDTaula.equals("Beste Zerbitzuak")) {
				IDTaula = "beste_zerbitzuak";
				atributoa = "IDBesteZerbitzuak";
			} else if (IDTaula.equals("Hegaldia Buelta")) {
				IDTaula = "joanetorri";
				atributoa = "IDJoanEtorri";
			}
			String sql = "DELETE FROM " + IDTaula + " WHERE " + atributoa + " = " + IDLerroaZ + ";";
			
			try (Statement stmt = konexioa.createStatement()) {
				int lerroAldaketa = stmt.executeUpdate(sql);
				
				if (lerroAldaketa > 0) {
					System.out.println(IDTaula + " ezabatuta");
				} else {
					System.out.println("Ez da ezer ezabatu");
				}
			} catch (SQLException e) {
				System.err.println("Errorea konektatzen: " + e.getMessage());
			} catch (Exception w) {
				System.err.println(w.getMessage());
			}
		}
		
		public boolean sartuOstatua(Zerbitzua zerbitzua, int IDBidaia) {
			String sql = "INSERT INTO ostatua (izenaOstatua, hiria, prezioOstatua, sarreraEguna, irteeraEguna, kodLogelaMota, bidaiaOs) "
					 + "VALUES ('" + zerbitzua.getIzenaOstatua() + "', '" 
		        //       + zerbitzua.getHiria() + "', '" 
		               + zerbitzua.getPrezioaOstatua() + "', '"
		    	       + zerbitzua.getSarreraEguna() + "', '"
		               + zerbitzua.getIrteeraEguna() + "', '"
				       + zerbitzua.getLogelaMota() + "', '"	
				       + IDBidaia + "');";
	
			try (Statement stmt = konexioa.createStatement()) {
		        int filasAfectadas = stmt.executeUpdate(sql); // Ejecuta la consulta
	
		        return filasAfectadas > 0; // Devuelve true si la inserción fue exitosa
		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.println("Error al insertar Agentzia: " + e.getMessage());
		        return false;
		    } 
	}
		
		public boolean sartuBesteZerbitzua(Zerbitzua zerbitzua, int IDBidaia) {
			String sql = "INSERT INTO ostatua (izenaOstatua, hiria, prezioOstatua, sarreraEguna, irteeraEguna, kodLogelaMota, bidaiaOs) "
					 + "VALUES ('" + zerbitzua.getBesteZerbitzuak() + "', '" 
		               + zerbitzua.getDataBesteZerbitzua() + "', '"
		    	//       + zerbitzua.getDeskribapena + "', '"
		               + zerbitzua.getPrezioaBesteZerbitzuak() + "', '"
				       + IDBidaia + "');";
	
			try (Statement stmt = konexioa.createStatement()) {
		        int filasAfectadas = stmt.executeUpdate(sql); // Ejecuta la consulta
	
		        return filasAfectadas > 0; // Devuelve true si la inserción fue exitosa
		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.println("Error al insertar Agentzia: " + e.getMessage());
		        return false;
		    } 
	}
		//TODO
		public boolean sartuHegaldia(Zerbitzua zerbitzua, int IDBidaia) {
			String sql = "INSERT INTO ostatua (izenaOstatua, hiria, prezioOstatua, sarreraEguna, irteeraEguna, kodLogelaMota, bidaiaOs) "
					 + "VALUES ('" + zerbitzua.getIzenaOstatua() + "', '" 
		        //       + zerbitzua.getHiria() + "', '" 
		               + zerbitzua.getPrezioaOstatua() + "', '"
		    	       + zerbitzua.getSarreraEguna() + "', '"
		               + zerbitzua.getIrteeraEguna() + "', '"
				       + zerbitzua.getLogelaMota() + "', '"	
				       + IDBidaia + "');";
	
			try (Statement stmt = konexioa.createStatement()) {
		        int filasAfectadas = stmt.executeUpdate(sql); // Ejecuta la consulta
	
		        return filasAfectadas > 0; // Devuelve true si la inserción fue exitosa
		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.println("Error al insertar Agentzia: " + e.getMessage());
		        return false;
		    } 
	}
		//TODO
		public boolean sartuJoanEtorri(Zerbitzua zerbitzua, int IDBidaia) {
			String sql = "INSERT INTO ostatua (izenaOstatua, hiria, prezioOstatua, sarreraEguna, irteeraEguna, kodLogelaMota, bidaiaOs) "
					 + "VALUES ('" + zerbitzua.getIzenaOstatua() + "', '" 
		        //       + zerbitzua.getHiria() + "', '" 
		               + zerbitzua.getPrezioaOstatua() + "', '"
		    	       + zerbitzua.getSarreraEguna() + "', '"
		               + zerbitzua.getIrteeraEguna() + "', '"
				       + zerbitzua.getLogelaMota() + "', '"	
				       + IDBidaia + "');";
	
			try (Statement stmt = konexioa.createStatement()) {
		        int filasAfectadas = stmt.executeUpdate(sql); // Ejecuta la consulta
	
		        return filasAfectadas > 0; // Devuelve true si la inserción fue exitosa
		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.println("Error al insertar Agentzia: " + e.getMessage());
		        return false;
		    } 
	}

}