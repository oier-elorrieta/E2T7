package bista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import DAO.AgentziaDAO;
import DAO.BidaiaDAO;
import DAO.ZerbitzuakDAO;
import Konexioa.ConnectDB;
import kontroladorea.Aurrekontua;
import modeloa.Bidaia;
import modeloa.Zerbitzua;
import modeloa.Kudeatzaile;

public class Erresuma extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable bidaiaTable;
	private JTable zerbitzuTable;
	private String IDLerroaZ = "";
	private String IDtaula = "";
	private String IDLerroa = "";
	private Bidaia selectedBidaia;
	@SuppressWarnings("unused")
	private String url;
	ArrayList<Bidaia> bidaiak;
	ZerbitzuakDAO zerbitzuakDAO = new ZerbitzuakDAO();

	@SuppressWarnings("serial")
	public Erresuma(String erabiltzaile) {
		setTitle("Erresuma");

		@SuppressWarnings("unused")
		ConnectDB konexioa = new ConnectDB();

		int erabiltzailezbk = AgentziaDAO.lortuID(erabiltzaile);
		url = AgentziaDAO.lortuLogoa(erabiltzailezbk);
		BidaiaDAO bidaiaDAO = new BidaiaDAO();
		bidaiak = bidaiaDAO.lortuBidaiAgentzia(erabiltzailezbk);
		
		

		for (Bidaia bidaia : bidaiak) {

			bidaia.setZerbitzuak(ZerbitzuakDAO.lortuZerbitzuBidaia(bidaia.getIdentifikatzailea()));

		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1546, 947);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton logoButton = new JButton("");
		logoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		logoButton.setBounds(370, 11, 755, 202);
		contentPane.add(logoButton);

		String url = AgentziaDAO.lortuLogoa(erabiltzailezbk);
		if (url == null) {
			logoButton.setText(erabiltzaile);
			logoButton.setFont(new Font("Arial", Font.BOLD, 50));
		} else {
			if (!url.startsWith("http://") && !url.startsWith("https://")) {
				url = "https://" + url;
			}

			try {

				@SuppressWarnings("deprecation")
				URL imageURL = new URL(url);

				InputStream inputStream = imageURL.openStream();
				Image image = ImageIO.read(inputStream);

				ImageIcon icon = new ImageIcon(image);

				logoButton.setIcon(icon);

				logoButton.setBounds(370, 11, 755, 202);

				contentPane.add(logoButton);

				inputStream.close();

				logoButton.setBounds(370, 11, 755, 202);
				contentPane.add(logoButton);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(contentPane, "Irudia ezin da kargatu: " + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, // No se pasan filas aquí
				new String[] { "ID", "Izena", "Deskribapena", "Irteera", "Amaiera", "Bidaia Mota", "Iraupena",
						"Herrialdea" }) {
			boolean[] columnEditables = new boolean[] { false, true, true, true, true, true, false, false };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};

		bidaiaTable = new JTable(model);

		JTableHeader header = bidaiaTable.getTableHeader();
		header.setBackground(Color.LIGHT_GRAY);
		header.setForeground(Color.BLACK);

		bidaiaTable.getColumnModel().getColumn(2).setPreferredWidth(93);
		bidaiaTable.setBounds(122, 261, 1115, 177);

		JScrollPane scrollPane = new JScrollPane(bidaiaTable);
		scrollPane.setBounds(122, 261, 1115, 177);
		contentPane.add(scrollPane);

		for (Bidaia bidaia : bidaiak) {
			String[] row = { String.valueOf(bidaia.getIdentifikatzailea()), bidaia.getIzena(), bidaia.getDeskribapena(),
					bidaia.getDataIrteera(), bidaia.getDataAmaiera(), bidaia.getBidaiaMota(),
					String.valueOf(bidaia.getIraupena()), bidaia.getHelmuga()

			};

			model.addRow(row);
		}

		bidaiaTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = bidaiaTable.getSelectedRow();
				if (row != -1) {
					IDLerroa = (String) bidaiaTable.getValueAt(row, 0);

					selectedBidaia = null;
					for (Bidaia bidaia : bidaiak) {
						if (bidaia.getIdentifikatzailea().equals(IDLerroa)) {
							selectedBidaia = bidaia;
							break;
						}
					}

					if (selectedBidaia != null) {
						updateZerbitzuTable(selectedBidaia.getZerbitzuak());
					}
				}

			}

		});

		zerbitzuTable = new JTable();
		zerbitzuTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID Zerbitzual", "Zerbitzu Mota", "Izena", "Prezioa", "Data" }));
		zerbitzuTable.getColumnModel().getColumn(1).setPreferredWidth(91);
		zerbitzuTable.setBounds(122, 495, 1115, 177);
		contentPane.add(zerbitzuTable);

		JTableHeader zerbitzuHeader = zerbitzuTable.getTableHeader();
		zerbitzuHeader.setBackground(Color.LIGHT_GRAY);
		zerbitzuHeader.setForeground(Color.BLACK);

		zerbitzuTable.getColumnModel().getColumn(1).setPreferredWidth(91);
		zerbitzuTable.setBounds(122, 495, 1115, 177);
		contentPane.add(zerbitzuTable);

		JScrollPane scrollPaneZerbitzu = new JScrollPane(zerbitzuTable);
		scrollPaneZerbitzu.setBounds(122, 495, 1115, 177);
		contentPane.add(scrollPaneZerbitzu);

		JButton ezabatuBButton = new JButton("EZABATU");
		ezabatuBButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bidaiaDAO.ezabatuBidaiDB(bidaiak.get(bidaiaTable.getSelectedRow()).getIdentifikatzailea());
				} catch (Exception q) {
					JOptionPane.showMessageDialog(ezabatuBButton, "Aukeratu Bidai bat, mesedez.");
				}
				bidaiak = Kudeatzaile.ezabatuBidaia(bidaiaTable, bidaiak);

				bidaiaTable.repaint();
			}
		});
		ezabatuBButton.setBounds(1294, 320, 129, 48);
		contentPane.add(ezabatuBButton);

		zerbitzuTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = zerbitzuTable.getSelectedRow();
				if (row != -1) {
					IDLerroaZ = (String) zerbitzuTable.getValueAt(row, 0);
					IDtaula = (String) zerbitzuTable.getValueAt(row, 1);

				}

			}

		});

		JButton ezabatuZButton = new JButton("EZABATU");
		ezabatuZButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					zerbitzuakDAO.ezabatuZerbitzua(IDtaula, IDLerroaZ);
				} catch (Exception q) {
					JOptionPane.showMessageDialog(ezabatuBButton, "Aukeratu Bidai bat, mesedez.");
				}
				Kudeatzaile.ezabatuZerbitzua(selectedBidaia, zerbitzuTable, IDLerroa, IDLerroaZ);

				zerbitzuTable.repaint();
			}

		});
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
		gordeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bidaiaTable.repaint();
				zerbitzuTable.repaint();
			}
		});
		gordeButton.setBounds(805, 759, 182, 106);
		contentPane.add(gordeButton);

		JButton gehituBButton = new JButton("GEHITU");
		gehituBButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							BidaiBerria frame = new BidaiBerria(erabiltzailezbk, bidaiak);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}
		});
		gehituBButton.setBounds(1294, 379, 129, 48);
		contentPane.add(gehituBButton);

		JButton gehituZButton = new JButton("GEHITU");
		gehituZButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ZerbitzuBerria frame = new ZerbitzuBerria(erabiltzailezbk, bidaiak, IDLerroa);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}
		});
		gehituZButton.setBounds(1294, 613, 129, 48);
		contentPane.add(gehituZButton);

		JButton aurrekontuaButton = new JButton("AURREKONTUA");
		aurrekontuaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bidaiaTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						int row = bidaiaTable.getSelectedRow();
						if (row != -1) {
							IDLerroa = (String) bidaiaTable.getValueAt(row, 0);

							Bidaia selectedBidaia = Kudeatzaile.selectedBidaia(bidaiak, IDLerroa);

							if (selectedBidaia != null) {
								updateZerbitzuTable(selectedBidaia.getZerbitzuak());
							}
						}

					}

				});

				Aurrekontua.sortuAurrekontua(Kudeatzaile.selectedBidaia(bidaiak, IDLerroa));
			}
		});
		aurrekontuaButton.setBounds(1294, 264, 129, 48);
		contentPane.add(aurrekontuaButton);

	}

	private void updateZerbitzuTable(ArrayList<Zerbitzua> zerbitzuak) {

		DefaultTableModel zerbitzuModel = (DefaultTableModel) zerbitzuTable.getModel();

		zerbitzuModel.setRowCount(0);

		for (Zerbitzua zerbitzua : zerbitzuak) {

			if (zerbitzua.getOstatuKodea() > 0) {
				String[] row = { String.valueOf(zerbitzua.getOstatuKodea()), "Ostatua", zerbitzua.getIzenaOstatua(),
						String.valueOf(zerbitzua.getPrezioaOstatua()), zerbitzua.getSarreraEguna(), };
				zerbitzuModel.addRow(row);
			} else if (zerbitzua.getIDJoanEtorri() > 0) {
				String[] row = { String.valueOf(zerbitzua.getIDJoanEtorri()), "Hegaldia (Buelta)",
						zerbitzua.getHegaldiKodeaBuelta(), zerbitzua.getIrteeraData(), };
				zerbitzuModel.addRow(row);

			} else if (zerbitzua.getHegaldia() > 0) {
				String[] row = { String.valueOf(zerbitzua.getHegaldia()), "Hegaldia", zerbitzua.getHegaldiKodea(),
						String.valueOf(zerbitzua.getPrezioaHegaldia()), zerbitzua.getIrteeraData(), };
				zerbitzuModel.addRow(row);

			} else if (zerbitzua.getBesteKodea() > 0) {
				String[] row = { String.valueOf(zerbitzua.getBesteKodea()), "Beste Zerbitzuak",
						zerbitzua.getBesteZerbitzuak(), String.valueOf(zerbitzua.getPrezioaBesteZerbitzuak()),
						zerbitzua.getDataBesteZerbitzua(), };
				zerbitzuModel.addRow(row);
			}
		}
	}

}
