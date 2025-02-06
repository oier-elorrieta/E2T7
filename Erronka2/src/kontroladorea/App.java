package kontroladorea;

import java.awt.EventQueue;
import java.util.List;
import modeloa.*;
import DAO.*;
import Konexioa.ConnectDB;
import bista.Ongietorri;

import javax.swing.JFrame;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		ConnectDB konexioa = new ConnectDB(); 
		BidaiaDAO proba = new BidaiaDAO();
		
		konexioa.conectar();
		
		if (konexioa.isConnected()) {
		    System.out.println("Conexión exitosa a la base de datos.");
		} else {
		    System.out.println("La conexión no se pudo establecer.");
		    return;  // Termina el programa si no se pudo conectar
		}
		
		AireportuaDAO aireportuaDAO = new AireportuaDAO();
	    aireportuaDAO.setConnection(konexioa.getConnection());

	    
	    AgentziaDAO agentziaDAO = new AgentziaDAO();
	    agentziaDAO.setConnection(konexioa.getConnection());
	    
	    HerrialdeaDAO herrialdeaDAO = new HerrialdeaDAO();
	    herrialdeaDAO.setConnection(konexioa.getConnection());

	    BidaiaDAO bidaiaDAO = new BidaiaDAO();
	    bidaiaDAO.setConnection(konexioa.getConnection());

	    ZerbitzuakDAO zerbitzuaDAO = new ZerbitzuakDAO();
	    zerbitzuaDAO.setConnection(konexioa.getConnection());
		
		proba.setConnection(konexioa.getConnection());
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ongietorri frame = new Ongietorri();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	

		/*Herrialdea nuevoPais = new Herrialdea("JL", "Julen");

        // Creamos el DAO
        HerrialdeaDAO herrialdeaDAO1 = new HerrialdeaDAO();
        
        // Llamamos al método para guardar el objeto en la base de datos
        herrialdeaDAO1.gordeHerrialdea(nuevoPais);

        System.out.println("Herrialdea insertatu da!");
		
		HerrialdeaDAO herrialdeaDAO = new HerrialdeaDAO();
		
		Zerbitzua berriZerbitzua = new Zerbitzua("7", 25, "12-7-2025", "15-7-2025", "L1", 4, "A27", 5, 25, "A28", "A30", "A40", "A50", 25, "20-3-2025", "12:25:47", "7", "25-3-2025","15:25:20", "5", "A90", "A80"	
				);*/
        
        // Llamar al método que obtiene todos los resultados
       /* List<Herrialdea> herrialdeak = HerrialdeaDAO.lortuHerrialdeGuztiak();
        
        // Imprimir los resultados en consola
        for (Herrialdea herrialdea : herrialdeak) {
            System.out.println("Kodea: " + herrialdea.getKodea());
            System.out.println("Herrialdea: " + herrialdea.getHerrialdea());
            System.out.println("-------------");
        }*/
        

		
		if (konexioa.isConnected()) {
	        System.out.println("Conexión exitosa a la base de datos.");
	    } else {
	        System.out.println("No se pudo establecer la conexión.");
	        return;  // Termina la ejecución si no se pudo conectar
	    }
        
List<Aireportua> aireportuak = aireportuaDAO.lortuAireportuGuztiak();
        
        for (Aireportua aireportua : aireportuak) {
            System.out.println("Aireportu Kodea: " + aireportua.getIdentifikatzailea());
            System.out.println("Hiria: " + aireportua.getIzena());
            System.out.println("-------------");
        }
        
        List<Agentzia> agentziak = agentziaDAO.lortuAgentziaGuztiak();
        
        for (Agentzia agentzia : agentziak) {
            System.out.println("Agentzia Kodea: " + agentzia.getIdentifikatzailea());
            System.out.println("Hiria: " + agentzia.getErabiltzaile());
            System.out.println("Pasahitza: " + agentzia.getPasahitza());
            System.out.println("-------------");
        }
        
        List<Herrialdea> herrialdeak = herrialdeaDAO.lortuHerrialdeGuztiak();

        for (Herrialdea herrialdea : herrialdeak) {
            System.out.println("Herrialdea Kodea: " + herrialdea.getKodea());
            System.out.println("Herrialdea Izena: " + herrialdea.getHerrialdea());
            System.out.println("-------------");
        }

        List<Zerbitzua> zerbitzuak = zerbitzuaDAO.lortuZerbitzuGuztiak();

        for (Zerbitzua zerbitzua : zerbitzuak) {
            System.out.println("Zerbitzua ID Bidaia: " + zerbitzua.getIDZerbitzua());
            System.out.println("Prezioa Ostatua: " + zerbitzua.getPrezioaOstatua());
            System.out.println("Sarrera Eguna: " + zerbitzua.getSarreraEguna());
            System.out.println("Irteera Eguna: " + zerbitzua.getIrteeraEguna());
            System.out.println("-------------");
        }

        List<Bidaia> bidaiak = bidaiaDAO.lortuBidaiGuztiak();

        for (Bidaia bidaia : bidaiak) {
            System.out.println("Bidaia Kodea: " + bidaia.getIdentifikatzailea());
            System.out.println("Bidaia Izena: " + bidaia.getIzena());
            System.out.println("Data Amaiera: " + bidaia.getDataAmaiera());
            System.out.println("Data Irteera: " + bidaia.getDataIrteera());
            System.out.println("-------------");
        }
        
        
      
        
       /* BidaiaDAO bidaiaDAO = new BidaiaDAO();
        
        List<Bidaia> bidaiak = bidaiaDAO.lortuBidaiGuztiak();
        
        for (Bidaia bidaia : bidaiak) {
            System.out.println("ID Bidaia: " + bidaia.getIdentifikatzailea());
            System.out.println("Izena: " + bidaia.getIzena());
            System.out.println("Amaiera: " + bidaia.getDataAmaiera());
            System.out.println("Irteera: " + bidaia.getDataIrteera());
            System.out.println("Deskribapena: " + bidaia.getDeskribapena());
            System.out.println("Agentzia: " + bidaia.getAgentzia());
            System.out.println("Bidaia mota: " + bidaia.getBidaiaMota());
            System.out.println("------------------------------------------------");
        }
	
	
		/*ZerbitzuakDAO zerbitzuaDAO = new ZerbitzuakDAO();
		
		List<Zerbitzua> zerbitzuak = zerbitzuaDAO.lortuZerbitzuGuztiak();
		
		for (Zerbitzua zerbitzua : zerbitzuak) {
			System.out.println("ID Zerbitzua: " + zerbitzua.getIDZerbitzua());
			System.out.println("Prezioa Ostatua: " + zerbitzua.getPrezioaOstatua());
	        System.out.println("Sarrera Eguna: " + zerbitzua.getSarreraEguna());
	        System.out.println("Irteera Eguna: " + zerbitzua.getIrteeraEguna());
	        System.out.println("Logela Mota: " + zerbitzua.getLogelaMota());
	        System.out.println("Ostatua: " + zerbitzua.getOstatua());
	        System.out.println("Hegaldia: " + zerbitzua.getHegaldia());
	        System.out.println("Beste Zerbitzuak: " + zerbitzua.getBesteZerbitzuak());
	        System.out.println("Prezioa Beste Zerbitzuak: " + zerbitzua.getPrezioaBesteZerbitzuak());
	        System.out.println("Joan Etorri: " + zerbitzua.isJoanEtorri());
	        System.out.println("Jatorrizko Aireportua: " + zerbitzua.getJatorrizkoAireportua());
	        System.out.println("Helmugako Aireportua: " + zerbitzua.getHelmugakoAireportua());
	        System.out.println("Hegaldia Kodea: " + zerbitzua.getHegaldiKodea());
	        System.out.println("Aero Linea: " + zerbitzua.getAeroLinea());
	        System.out.println("Prezioa Hegaldia: " + zerbitzua.getPrezioaHegaldia());
	        System.out.println("Irteera Data: " + zerbitzua.getIrteeraData());
	        System.out.println("Irteera Ordutegia: " + zerbitzua.getIrteeraOrdutegia());
	        System.out.println("Bidaiaren Iraupena: " + zerbitzua.getBidaiarenIraupena());
	        System.out.println("Itzulera Data: " + zerbitzua.getItzuleraData());
	        System.out.println("Itzulera Ordua: " + zerbitzua.getItzuleraOrdua());
	        System.out.println("Bidaiaren Iraupena Buelta: " + zerbitzua.getBidaiarenIraupenaBuelta());
	        System.out.println("Hegaldia Kodea Buelta: " + zerbitzua.getHegaldiKodeaBuelta());
	        System.out.println("Aero Linea Buelta: " + zerbitzua.getAeroLineaBuelta());
	        System.out.println("------------------------------------------------------");
	        
	
	    	}
		System.out.println("Número de Zerbitzuak obtenidos: " + zerbitzuak.size());
		if (zerbitzuak.isEmpty()) {
		    System.out.println("La lista está vacía.");
		}*/
		
		
	    }
	
        }
	        



	
	

        
        

        	




