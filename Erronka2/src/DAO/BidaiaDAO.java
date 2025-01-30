package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Konexioa.ConnectDB;
import modeloa.Bidaia;

public class BidaiaDAO {
	
	private Connection konexioa;

	// Constructor
    public BidaiaDAO() {
        this.konexioa = ConnectDB.conectar();  // Usamos la clase ConnectDB para obtener la conexión
    }
	
    public List<Bidaia> lortuBidaiGuztiak() {
        List<Bidaia> bidaiak = new ArrayList<>();
        String sql = "SELECT * FROM Bidaia b join bidaia_mota m using (KodBidaiaMota) join agentzia a using (IDAgentzia)";

        try (Statement stmt = konexioa.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Bidaia bidaia = new Bidaia(sql, sql, sql, sql, sql, sql, sql, sql, null, sql);
                bidaia.setIdentifikatzailea(rs.getString("IDBidaia"));
                bidaia.setIzena(rs.getString("izena"));
                bidaia.setDataAmaiera(rs.getString("dataAmaiera"));
                bidaia.setDataIrteera(rs.getString("dataIrteera"));
                bidaia.setDeskribapena(rs.getString("deskribapena"));
                bidaia.setHelmuga(rs.getString("KodHerrialdea"));
                bidaia.setZerbitzuak(null);
                bidaia.setAgentzia(rs.getString("a.izena"));
                bidaia.setBidaiaMota(rs.getString("m.deskribapena"));
                bidaiak.add(bidaia);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Para ver el detalle del error
            System.out.println("Errorea Herrialdeak eskuratzen: " + e.getMessage());
        }

        return bidaiak;
    }
	

}


