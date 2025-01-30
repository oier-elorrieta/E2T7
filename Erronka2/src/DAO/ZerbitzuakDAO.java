package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Konexioa.ConnectDB;
import modeloa.*;


public class ZerbitzuakDAO {

	private Connection konexioa;

	// Constructor
    public ZerbitzuakDAO() {
        this.konexioa = ConnectDB.conectar();  // Usamos la clase ConnectDB para obtener la conexión
    }
	
    public List<Zerbitzua> lortuZerbitzuGuztiak() {
        List<Zerbitzua> zerbitzuak = new ArrayList<>();
        String sql = "SELECT * FROM zerbitzua join ostatua on IDZerbitzua = IDOstatua join hegaldia on IDZerbitzua = IDHegaldia join joanetorri on IDHegaldia = IDJoanEtorri join beste_zerbitzuak on IDZerbitzua = IDBesteZerbitzuak";

        try (Statement stmt = konexioa.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Zerbitzua zerbitzua = new Zerbitzua(0, null, null, sql, sql, sql, sql, 0, false, sql, sql, sql, sql, 0, null, sql, sql, null, null, sql, sql, sql);
                zerbitzua.setPrezioaOstatua(rs.getDouble("prezioOstatua"));
                zerbitzua.setSarreraEguna(rs.getString("sarreraEguna"));
                zerbitzua.setIrteeraEguna(rs.getString("irteeraEguna"));
                zerbitzua.setLogelaMota(rs.getString("logelaMota"));
                zerbitzua.setOstatua(rs.getString("ostatua"));
                zerbitzua.setHegaldia(rs.getString("hegaldia"));
                zerbitzua.setBesteZerbitzuak(rs.getString("besteZerbitzuak"));
                zerbitzua.setPrezioaBesteZerbitzuak(rs.getDouble("prezioaBesteZerbitzuak"));
                zerbitzua.setJoanEtorri(rs.getBoolean("joanEtorri"));
                zerbitzua.setJatorrizkoAireportua(rs.getString("jatorrizkoAireportua"));
                zerbitzua.setHelmugakoAireportua(rs.getString("helmugakoAireportua"));
                zerbitzua.setHegaldiKodea(rs.getString("hegaldiKodea"));
                zerbitzua.setAeroLinea(rs.getString("aeroLinea"));
                zerbitzua.setPrezioaHegaldia(rs.getDouble("prezioaHegaldia"));
                zerbitzua.setIrteeraData(rs.getString("irteeraData"));
                zerbitzua.setIrteeraOrdutegia(rs.getString("irteeraOrdutegia"));
                zerbitzua.setBidaiarenIraupena(rs.getString("bidaiarenIraupena"));
                zerbitzua.setItzuleraData(rs.getString("itzuleraData"));
                zerbitzua.setItzuleraOrdua(rs.getString("itzuleraOrdua"));
                zerbitzua.setBidaiarenIraupenaBuelta(rs.getString("bidaiarenIraupenaBuelta"));
                zerbitzua.setHegaldiKodeaBuelta(rs.getString("hegaldiKodeaBuelta"));
                zerbitzua.setAeroLineaBuelta(rs.getString("aeroLineaBuelta"));
                zerbitzuak.add(zerbitzua);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Para ver el detalle del error
            System.out.println("Errorea Zerbitzuak eskuratzen: " + e.getMessage());
        }

        return zerbitzuak;
    }
	

}