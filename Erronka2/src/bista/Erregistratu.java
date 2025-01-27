package bista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Choice;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Erregistratu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField agentziaIzenaField;
	private JPasswordField pasahitzaField;
	private JTextField erabiltzaileField;

	
	/**
	 * Create the frame.
	 */
	public Erregistratu() {
		setTitle("Erregistroa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel erregistroLabel = new JLabel("Erregistro berria");
		erregistroLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		erregistroLabel.setHorizontalAlignment(SwingConstants.CENTER);
		erregistroLabel.setBounds(154, 24, 225, 33);
		contentPane.add(erregistroLabel);
		
		JLabel erabiltzaileLabel = new JLabel("Erabiltzailea:");
		erabiltzaileLabel.setBounds(49, 102, 127, 14);
		contentPane.add(erabiltzaileLabel);
		
		JLabel pasahitzaLabel = new JLabel("Pasahitza:");
		pasahitzaLabel.setBounds(49, 142, 127, 14);
		contentPane.add(pasahitzaLabel);
		
		JLabel lblAgentziaIzena = new JLabel("Agentzia izena:");
		lblAgentziaIzena.setBounds(49, 182, 127, 14);
		contentPane.add(lblAgentziaIzena);
		
		JLabel lblKolorea = new JLabel("Kolorea:");
		lblKolorea.setBounds(49, 221, 127, 14);
		contentPane.add(lblKolorea);
		
		JLabel agentziaMotaLabel = new JLabel("Agentzia mota:");
		agentziaMotaLabel.setBounds(49, 308, 127, 14);
		contentPane.add(agentziaMotaLabel);
		
		JLabel lblTamaina = new JLabel("Tamaina");
		lblTamaina.setBounds(49, 261, 127, 14);
		contentPane.add(lblTamaina);
		
		Choice agentziaChoice = new Choice();
		agentziaChoice.setBounds(206, 308, 83, 20);
		contentPane.add(agentziaChoice);
		
		JRadioButton txikiaRadioButton = new JRadioButton("Txikia");
		txikiaRadioButton.setBounds(199, 257, 109, 23);
		contentPane.add(txikiaRadioButton);
		
		JRadioButton ertainaRadioButton_1 = new JRadioButton("Ertaina");
		ertainaRadioButton_1.setBounds(310, 257, 109, 23);
		contentPane.add(ertainaRadioButton_1);
		
		JRadioButton handiaRadioButton = new JRadioButton("Handia");
		handiaRadioButton.setBounds(421, 257, 109, 23);
		contentPane.add(handiaRadioButton);
		
		agentziaIzenaField = new JTextField();
		agentziaIzenaField.setBounds(203, 179, 176, 20);
		contentPane.add(agentziaIzenaField);
		agentziaIzenaField.setColumns(10);
		
		pasahitzaField = new JPasswordField();
		pasahitzaLabel.setLabelFor(pasahitzaField);
		pasahitzaField.setBounds(206, 143, 83, 11);
		contentPane.add(pasahitzaField);
		
		erabiltzaileField = new JTextField();
		erabiltzaileField.setBounds(203, 99, 176, 20);
		contentPane.add(erabiltzaileField);
		erabiltzaileField.setColumns(10);
		
		JButton okButton = new JButton("OK");
		okButton.setBounds(346, 448, 89, 23);
		contentPane.add(okButton);
		
		JButton atzeraButton = new JButton("ATZERA");
		atzeraButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							BistaApp frame = new BistaApp();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
				dispose();
			}
		});
		atzeraButton.setBounds(118, 448, 89, 23);
		contentPane.add(atzeraButton);
	}
}
