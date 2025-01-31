package kontroladorea;

import java.util.List;
//import bista.BistaApp;
import modeloa.*;
import DAO.*;
import javax.swing.JFrame;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BistaApp frame = new BistaApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}
}*/
		
		HerrialdeaDAO herrialdeaDAO = new HerrialdeaDAO();
        
        // Llamar al método que obtiene todos los resultados
        List<Herrialdea> herrialdeak = herrialdeaDAO.lortuHerrialdeGuztiak();
        
        // Imprimir los resultados en consola
        for (Herrialdea herrialdea : herrialdeak) {
            System.out.println("Kodea: " + herrialdea.getKodea());
            System.out.println("Herrialdea: " + herrialdea.getHerrialdea());
            System.out.println("-------------");
        }
        
		AireportuaDAO aireportuaDAO = new AireportuaDAO();
        
        // Llamar al método que obtiene todos los resultados
        List<Aireportua> aireportuak = aireportuaDAO.lortuAireportuGuztiak();
        
        // Imprimir los resultados en consola
        for (Aireportua aireportua : aireportuak) {
            System.out.println("Aireportu Kodea: " + aireportua.getIdentifikatzailea());
            System.out.println("Hiria: " + aireportua.getIzena());
            System.out.println("-------------");
        }
        
        AgentziaDAO agentziaDAO = new AgentziaDAO();
        
        // Obtener la lista de todas las agencias
        List<Agentzia> agentziak = agentziaDAO.lortuAgentziaGuztiak();
        
        // Mostrar los resultados en consola
        for (Agentzia agentzia : agentziak) {
            System.out.println("ID Agencia: " + agentzia.getIdentifikatzailea());
            System.out.println("Nombre: " + agentzia.getIzena());
            System.out.println("Logo: " + agentzia.getLogoa());
            System.out.println("Color de Marca: " + agentzia.getMarkaKolorea());
            System.out.println("Usuario: " + agentzia.getErabiltzaile());
            System.out.println("Tipo de Agencia: " + agentzia.getAgentziaMota());
            System.out.println("Cantidad de Empleados: " + agentzia.getLangileKopurua());
            System.out.println("------------------------------------------------");
        }
        
        BidaiaDAO bidaiaDAO = new BidaiaDAO();
        
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
	
	
		ZerbitzuakDAO zerbitzuaDAO = new ZerbitzuakDAO();
		
		List<Zerbitzua> zerbitzuak = zerbitzuaDAO.lortuZerbitzuGuztiak();
		
		for (Zerbitzua zerbitzua : zerbitzuak) {
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
		}
	}
}
	        



	
	

        
        

        	




