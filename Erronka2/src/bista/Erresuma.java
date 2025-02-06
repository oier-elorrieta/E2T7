package bista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import DAO.AgentziaDAO;
import DAO.BidaiaDAO;
import Konexioa.ConnectDB;
import modeloa.Bidaia;

public class Erresuma extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable bidaiaTable;
	private JTable zerbitzuTable;


	/**
	 * Create the frame.
	 */
	public Erresuma(String erabiltzaile) {
		
		ConnectDB konexioa = new ConnectDB(); 
		
		int erabiltzailezbk = AgentziaDAO.lortuID(erabiltzaile);
		

			List<Bidaia> bidaiak = BidaiaDAO.lortuBidaiAgentzia(erabiltzailezbk);
			System.out.println(bidaiak.get(0).getDataAmaiera());
		for (Bidaia bidaia : bidaiak) {
            System.out.println("Bidaia Kodea: " + bidaia.getIdentifikatzailea());
            System.out.println("Bidaia Izena: " + bidaia.getIzena());
            System.out.println("Data Amaiera: " + bidaia.getDataAmaiera());
            System.out.println("Data Irteera: " + bidaia.getDataIrteera());
            System.out.println("Iraupena: " + bidaia.getIraupena());
            System.out.println("Kod Herrialdea: " + bidaia.getHelmuga());
            System.out.println("Izena Agentzia: " + bidaia.getAgentzia());
            System.out.println("-------------");
        }
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1546, 947);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton logoButton = new JButton("LOGO");
		logoButton.setBounds(370, 11, 755, 202);
		contentPane.add(logoButton);
		
		bidaiaTable = new JTable();
		bidaiaTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Izena", "Deskribapena", "Irteera", "Amaiera", "Bidaia Mota"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bidaiaTable.getColumnModel().getColumn(2).setPreferredWidth(93);
		bidaiaTable.setBounds(122, 261, 1115, 177);
		contentPane.add(bidaiaTable);
		
		zerbitzuTable = new JTable();
		zerbitzuTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Beste Zerbitzua", "Data", "Deskribapena BZ", "Prezioa BZ"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		zerbitzuTable.getColumnModel().getColumn(2).setPreferredWidth(103);
		zerbitzuTable.setBounds(122, 495, 1115, 177);
		contentPane.add(zerbitzuTable);
		
		JButton aldatuButton = new JButton("ALDATU");
		aldatuButton.setBounds(1294, 261, 129, 48);
		contentPane.add(aldatuButton);
		
		JButton ezabatuButton = new JButton("EZABATU");
		ezabatuButton.setBounds(1294, 320, 129, 48);
		contentPane.add(ezabatuButton);
		
		JButton aldatuZButton = new JButton("ALDATU");
		aldatuZButton.setBounds(1294, 495, 129, 48);
		contentPane.add(aldatuZButton);
		
		JButton ezabatuZButton = new JButton("EZABATU");
		ezabatuZButton.setBounds(1294, 554, 129, 48);
		contentPane.add(ezabatuZButton);
		
		JButton irtenButton = new JButton("IRTEN");
		irtenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				
				dispose();
			}
		});
		irtenButton.setBounds(563, 759, 182, 106);
		contentPane.add(irtenButton);
		
		JButton gordeButton = new JButton("GORDE");
		gordeButton.setBounds(805, 759, 182, 106);
		contentPane.add(gordeButton);
	}
}

