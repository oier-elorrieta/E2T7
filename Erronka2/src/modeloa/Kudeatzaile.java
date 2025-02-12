package modeloa;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.ZerbitzuakDAO;
import modeloa.Bidaia;

public class Kudeatzaile {

	public static ArrayList<Bidaia> ezabatuBidaia(JTable taula, ArrayList<Bidaia> bidaiak) {

		int row = taula.getSelectedRow();
		if (row != -1) {
			String IDLerroa = taula.getValueAt(row, 0).toString();

			for (int i = 0; i < bidaiak.size(); i++) {

				if (bidaiak.get(i).getIdentifikatzailea().equals(IDLerroa)) {

					bidaiak.remove(i);
					break;

				}

			}
		}

		DefaultTableModel modeloa = (DefaultTableModel) taula.getModel();
		modeloa.removeRow(row);
		return bidaiak;

	}
	
	public static void ezabatuZerbitzua(Bidaia bidaia, JTable taula, String IDBidaia, String IDZerbitzua) {
		
		int row = taula.getSelectedRow();
		if (row != -1) {
		String zerbitzuMota = (String) taula.getValueAt(row, 1);
		ArrayList<Zerbitzua> zerbitzuak = bidaia.getZerbitzuak();
			
		for (int i = 0; i<zerbitzuak.size(); i++) {
			Zerbitzua zerbitzua = zerbitzuak.get(i);
				if (zerbitzuMota.equals("Ostatua") && zerbitzua.getMota()==2) {
					zerbitzuak.remove(i);
				} else if (zerbitzuMota.equals("Beste Zerbitzuak") && zerbitzua.getMota()==3) {
					zerbitzuak.remove(i);
				} else if (zerbitzuMota.equals("Hegaldia") && zerbitzua.getMota()==0) {
					zerbitzuak.remove(i);
				} else if (zerbitzuMota.equals("Hegaldia (Buelta)") && zerbitzua.getMota()==1) {
					zerbitzuak.remove(i);
				}
				
			}
		}
		
	}

}
