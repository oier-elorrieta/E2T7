package bista;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import DAO.LogelaMotaDAO;
import DAO.ZerbitzuakDAO;
import modeloa.Bidaia;
import modeloa.LogelaMota;
import modeloa.Zerbitzua;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Choice;

public class Ostatua extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField izenaOField;
	private JTextField hiriaOField;
	private JTextField prezioaOField;

	public Ostatua(int erabiltzailezbk, ArrayList<Bidaia> bidaiak, int IDLerroa) {
		setTitle("OSTATU BERRIA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 607, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		ZerbitzuakDAO ostatuaDAO = new ZerbitzuakDAO();

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel izenaOLabel = new JLabel("Ostatuaren Izena:");
		izenaOLabel.setBounds(41, 47, 117, 14);
		contentPane.add(izenaOLabel);

		JLabel hiriaOLabel = new JLabel("Hiria:");
		hiriaOLabel.setBounds(41, 85, 117, 14);
		contentPane.add(hiriaOLabel);

		JLabel prezioaOLabel = new JLabel("Prezioa:");
		prezioaOLabel.setBounds(41, 169, 117, 14);
		contentPane.add(prezioaOLabel);

		JDateChooser sarreraODateChooser = new JDateChooser();
		sarreraODateChooser.setBounds(243, 212, 200, 20);
		contentPane.add(sarreraODateChooser);

		JDateChooser irteeraODateChooser = new JDateChooser();
		irteeraODateChooser.setBounds(243, 261, 200, 20);
		contentPane.add(irteeraODateChooser);

		JLabel sarreraOLabel = new JLabel("Sarrera Eguna:");
		sarreraOLabel.setBounds(41, 212, 117, 14);
		contentPane.add(sarreraOLabel);

		JLabel irteeraOLabel = new JLabel("Irteera Eguna:");
		irteeraOLabel.setBounds(41, 261, 117, 14);
		contentPane.add(irteeraOLabel);

		JLabel logelaMotaLabel = new JLabel("Logela Mota:");
		logelaMotaLabel.setBounds(41, 126, 117, 14);
		contentPane.add(logelaMotaLabel);

		Choice logelaMotaChoice = new Choice();
		logelaMotaChoice.setBounds(243, 122, 269, 18);
		contentPane.add(logelaMotaChoice);

		izenaOField = new JTextField();
		izenaOField.setBounds(243, 44, 200, 20);
		contentPane.add(izenaOField);
		izenaOField.setColumns(10);

		hiriaOField = new JTextField();
		hiriaOField.setColumns(10);
		hiriaOField.setBounds(243, 82, 200, 20);
		contentPane.add(hiriaOField);

		prezioaOField = new JTextField();
		prezioaOField.setBounds(243, 166, 86, 20);
		contentPane.add(prezioaOField);
		prezioaOField.setColumns(10);

		JLabel euroOLabel = new JLabel("€");
		euroOLabel.setBounds(334, 157, 46, 14);
		contentPane.add(euroOLabel);

		JButton atzeraOButton = new JButton("ATZERA");
		atzeraOButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		atzeraOButton.setBounds(108, 342, 110, 66);
		contentPane.add(atzeraOButton);

		LogelaMotaDAO logelaMotaDAO = new LogelaMotaDAO();
		ArrayList<LogelaMota> logelaMotak = logelaMotaDAO.lortuLogelaMotak();

		for (LogelaMota logelaMota : logelaMotak) {
			logelaMotaChoice.add(logelaMota.getDeskribapenaLogelaMota());
		}

		JButton gordeOButton = new JButton("GORDE");
		gordeOButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double prezioaOstatua = Double.parseDouble(prezioaOField.getText());
				SimpleDateFormat formatoa = new SimpleDateFormat("yyyy-MM-dd");

				Date sarreraODate = sarreraODateChooser.getDate();
				if (sarreraODate == null) {
					JOptionPane.showMessageDialog(null, "Mesedez, hautatu data bat.");
					return;
				}
				String sarreraOData = formatoa.format(sarreraODate);

				Date irteeraODate = irteeraODateChooser.getDate();
				if (irteeraODate == null) {
					JOptionPane.showMessageDialog(null, "Mesedez, hautatu data bat.");
					return;
				}
				String irteeraOData = formatoa.format(irteeraODate);

				String logelaMota = LogelaMotaDAO.lortuID(logelaMotaChoice.getSelectedItem());

				String izenaOstatua = izenaOField.getText();

				String ostatuaHiria = hiriaOField.getText();

				Zerbitzua ostatua = new Zerbitzua(prezioaOstatua, ostatuaHiria, sarreraOData, irteeraOData, logelaMota,
						izenaOstatua, IDLerroa, 2);
				ostatuaDAO.sartuOstatua(ostatua, IDLerroa);
			}
		});
		gordeOButton.setBounds(333, 342, 110, 66);
		contentPane.add(gordeOButton);

	}
}
