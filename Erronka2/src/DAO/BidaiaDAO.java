package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modeloa.Agentzia;
import modeloa.Bidaia;
import modeloa.Zerbitzua;
import DAO.ZerbitzuakDAO;

public class BidaiaDAO {

	private static Connection konexioa;

	public void setConnection(Connection konexioa) {
		this.konexioa = konexioa;
	}
	
	 ZerbitzuakDAO zerbitzuaDAO = new ZerbitzuakDAO();
	
	public static ArrayList<Bidaia> lortuBidaiAgentzia(int erabiltzailezbk) {
		ArrayList<Bidaia> bidaiak = new ArrayList<>();
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

				ArrayList<Zerbitzua> zerbitzuak = ZerbitzuakDAO.lortuZerbitzuBidaia(identifikatzailea);
				
				
				Bidaia bidaia = new Bidaia(identifikatzailea, izena, deskribapena, bidaiaMota, dataIrteera, dataAmaiera, iraupena, helmuga, zerbitzuak, agentzia);
				bidaiak.add(bidaia);
				
				bidaia.setZerbitzuak(zerbitzuak);
			}
		} catch (SQLException e) {
			System.err.println("Errorea bidaiak kontsultatzerakoan: " + e.getMessage());
		}

		return bidaiak;

	}
	
	public static void ezabatuBidaiDB(String IDBidaia) {
		
		String sql = "DELETE FROM bidaia WHERE IDbidaia =" + IDBidaia +";";
		
		try (Statement stmt = konexioa.createStatement()) {
			int lerroAldaketa = stmt.executeUpdate(sql);
			
			if (lerroAldaketa > 0) {
				System.out.println("Bidaia ezabatuta");
			} else {
				
			}
		} catch (SQLException e) {
			System.err.println("Errorea konektatzen: " + e.getMessage());
		}
	}
	
	public static boolean sartuBidaia(Bidaia bidaia) {
		String sql = "INSERT INTO Bidaia (izenaBidaia, deskribapenaBidaia, dataIrteera, dataAmaiera, IDAgentzia, kodBidaiaMota, kodHerrialdea) "
				 + "VALUES ('" + bidaia.getIzena() + "', '" 
	               + bidaia.getDeskribapena() + "', '" 
	               + bidaia.getDataIrteera() + "', '"
	    	       + bidaia.getDataAmaiera() + "', '"
	               + bidaia.getAgentzia() + "', '"
			       + bidaia.getBidaiaMota() + "', '"	
			       + bidaia.getHelmuga() + "');";

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


