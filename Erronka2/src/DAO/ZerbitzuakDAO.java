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
        String sql = "SELECT * FROM zerbitzua join ostatua o on IDZerbitzua = IDOstatua join hegaldia on IDZerbitzua = IDHegaldia join joanetorri on IDHegaldia = IDJoanEtorri join beste_zerbitzuak on IDZerbitzua = IDBesteZerbitzuak join logela_mota l on o.kodLogelaMota = l.kodLogelaMota";

        try (Statement stmt = konexioa.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Zerbitzua zerbitzua = new Zerbitzua(0, null, null, sql, sql, sql, sql, 0, false, sql, sql, sql, sql, 0, null, sql, sql, null, null, sql, sql, sql);
                zerbitzua.setPrezioaOstatua(rs.getDouble("prezioa"));
                zerbitzua.setSarreraEguna(rs.getString("sarreraEguna"));
                zerbitzua.setIrteeraEguna(rs.getString("irteeraEguna"));
                zerbitzua.setLogelaMota(rs.getString("kodlogelaMota"));
                zerbitzua.setOstatua(rs.getString("IDostatua"));
                zerbitzua.setHegaldia(rs.getString("IDhegaldia"));
                zerbitzua.setBesteZerbitzuak(rs.getString("IDbesteZerbitzuak"));
                zerbitzua.setPrezioaBesteZerbitzuak(rs.getDouble("prezioa"));
                zerbitzua.setJoanEtorri(rs.getBoolean("IDjoanEtorri"));
                zerbitzua.setJatorrizkoAireportua(rs.getString("KodAireIrteera"));
                zerbitzua.setHelmugakoAireportua(rs.getString("KodAireHelmuga"));
                zerbitzua.setHegaldiKodea(rs.getString("hegaldiKodea"));
                zerbitzua.setAeroLinea(rs.getString("KodaireLinea"));
                zerbitzua.setPrezioaHegaldia(rs.getDouble("prezioa"));
                zerbitzua.setIrteeraData(rs.getString("irteeraData"));
                zerbitzua.setIrteeraOrdutegia(rs.getString("irteeraOrdutegia"));
                zerbitzua.setBidaiarenIraupena(rs.getString("bidaiaIraupen"));
                zerbitzua.setItzuleraData(rs.getString("itzuleraData"));
                zerbitzua.setItzuleraOrdua(rs.getString("itzuleraOrdua"));
                zerbitzua.setBidaiarenIraupenaBuelta(rs.getString("bueltakoIraupena"));
                zerbitzua.setHegaldiKodeaBuelta(rs.getString("hegaldiKodeaBuelta"));
                zerbitzua.setAeroLineaBuelta(rs.getString("kodAirelinea"));
                zerbitzuak.add(zerbitzua);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Para ver el detalle del error
            System.out.println("Errorea Zerbitzuak eskuratzen: " + e.getMessage());
        }

        return zerbitzuak;
    }
	

}