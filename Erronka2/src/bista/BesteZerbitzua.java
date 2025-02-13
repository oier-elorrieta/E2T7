package bista;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import DAO.ZerbitzuakDAO;
import modeloa.Bidaia;
import modeloa.Zerbitzua;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class BesteZerbitzua extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField izenaBField;
	private JTextField prezioaBField;
	private JTextField deskribapenaBesteField;

	public BesteZerbitzua(int erabiltzailezbk, ArrayList<Bidaia> bidaiak, int IDLerroa) {
		setTitle("BESTE ZERBITZUA ERREGISTRATU");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 559, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		ZerbitzuakDAO besteZerbitzuakDAO = new ZerbitzuakDAO();

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton atzeraBButton = new JButton("ATZERA");
		atzeraBButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		atzeraBButton.setBounds(99, 283, 110, 66);
		contentPane.add(atzeraBButton);

		JButton gordeBButton = new JButton("GORDE");

		gordeBButton.setBounds(327, 283, 110, 66);
		contentPane.add(gordeBButton);

		JLabel izenaBLabel = new JLabel("Izena:");
		izenaBLabel.setBounds(43, 58, 110, 14);
		contentPane.add(izenaBLabel);

		JLabel dataBLabel = new JLabel("Data:");
		dataBLabel.setBounds(43, 99, 110, 14);
		contentPane.add(dataBLabel);

		JLabel prezioaBLabel = new JLabel("Prezioa:");
		prezioaBLabel.setBounds(43, 145, 110, 14);
		contentPane.add(prezioaBLabel);

		JLabel deskribapenaBLabel = new JLabel("Deskribapena:");
		deskribapenaBLabel.setBounds(43, 191, 110, 14);
		contentPane.add(deskribapenaBLabel);

		JDateChooser irteeraBDateChooser = new JDateChooser();
		irteeraBDateChooser.setBounds(223, 99, 200, 20);
		contentPane.add(irteeraBDateChooser);

		izenaBField = new JTextField();
		izenaBField.setBounds(223, 55, 200, 20);
		contentPane.add(izenaBField);
		izenaBField.setColumns(10);

		prezioaBField = new JTextField();
		prezioaBField.setColumns(10);
		prezioaBField.setBounds(223, 142, 101, 20);
		contentPane.add(prezioaBField);

		JLabel euroOLabel = new JLabel("€");
		euroOLabel.setBounds(331, 145, 46, 14);
		contentPane.add(euroOLabel);

		deskribapenaBesteField = new JTextField();
		deskribapenaBesteField.setColumns(10);
		deskribapenaBesteField.setBounds(223, 188, 200, 20);
		contentPane.add(deskribapenaBesteField);

		// Beste Zerbitzua gordetzeko botoia
		gordeBButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SimpleDateFormat formatoa = new SimpleDateFormat("yyyy-MM-dd");

				String izenaBesteZerbitzua = izenaBField.getText();
				Date dataBDate = irteeraBDateChooser.getDate();
				if (dataBDate == null) {
					JOptionPane.showMessageDialog(null, "Mesedez, hautatu data bat.");
					return;
				}
				String dataB = formatoa.format(dataBDate);
				double prezioaB = Double.parseDouble(prezioaBField.getText());
				String deskribapenaB = deskribapenaBesteField.getText();

				Zerbitzua besteZerbitzua = new Zerbitzua(izenaBesteZerbitzua, prezioaB, dataB, deskribapenaB, IDLerroa,
						3);
				besteZerbitzuakDAO.sartuBesteZerbitzua(besteZerbitzua, IDLerroa);

			}
		});
	}
}
