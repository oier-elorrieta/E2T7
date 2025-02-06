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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.Font;
import java.awt.event.ActionListener;
import Konexioa.ConnectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Erregistratu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField agentziaIzenaField;
	private JPasswordField pasahitzaField;
	private JTextField erabiltzaileField;
	private JTextField colorHexField;
	private ConnectDB conexion;

	
	/**
	 * Create the frame.
	 */
	public Erregistratu() {
		setTitle("Erregistroa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setBackground(new Color(225, 225, 225));

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
		agentziaChoice.setBounds(206, 302, 153, 20);
		contentPane.add(agentziaChoice);
		
		ButtonGroup grupoRadioButtons = new ButtonGroup();
		
		JRadioButton txikiaRadioButton = new JRadioButton("Txikia (1-5)");
		txikiaRadioButton.setBounds(199, 257, 109, 23);
		contentPane.add(txikiaRadioButton);
		
		JRadioButton ertainaRadioButton = new JRadioButton("Ertaina (5-10)");
		ertainaRadioButton.setBounds(310, 257, 109, 23);
		contentPane.add(ertainaRadioButton);
		
		JRadioButton handiaRadioButton = new JRadioButton("Handia (+10)");
		handiaRadioButton.setBounds(421, 257, 109, 23);
		contentPane.add(handiaRadioButton);
		
		grupoRadioButtons.add(txikiaRadioButton);
		grupoRadioButtons.add(ertainaRadioButton);
		grupoRadioButtons.add(handiaRadioButton);
		
		agentziaIzenaField = new JTextField();
		agentziaIzenaField.setBounds(203, 179, 327, 20);
		contentPane.add(agentziaIzenaField);
		agentziaIzenaField.setColumns(10);
		
		pasahitzaField = new JPasswordField();
		pasahitzaLabel.setLabelFor(pasahitzaField);
		pasahitzaField.setBounds(206, 139, 324, 19);
		contentPane.add(pasahitzaField);
		
		erabiltzaileField = new JTextField();
		erabiltzaileField.setBounds(203, 99, 327, 20);
		contentPane.add(erabiltzaileField);
		erabiltzaileField.setColumns(10);
		
		// Textfield 
        colorHexField = new JTextField();
        colorHexField.setEditable(false);
        colorHexField.setBounds(377, 218, 153, 20);
        contentPane.add(colorHexField);
        colorHexField.setColumns(10);

        // Kolorea aukeratzeko botoia
        JButton colorButton = new JButton("Seleccionar color");
        colorButton.setBounds(206, 217, 161, 23);
        contentPane.add(colorButton);

        colorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Kolore aukeratzeko dialogoa sabaltzeko (JColorChooser)
                Color color = JColorChooser.showDialog(null, "Selecciona un color", Color.BLACK);
                if (color != null) {
                    // Hexadezimala lortzeko
                    String hexColor = String.format("#%02X%02X%02X", color.getRed(), color.getGreen(), color.getBlue());
                    // Seteatu hexadezimala textfield-ean
                    colorHexField.setText(hexColor);
                }
            }
        });
		
		JButton okButton = new JButton("OK");
		okButton.setBounds(346, 448, 89, 23);
		contentPane.add(okButton);
		
		JButton atzeraButton = new JButton("ATZERA");
		atzeraButton.addActionListener(new ActionListener() {
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
		atzeraButton.setBounds(118, 448, 89, 23);
		contentPane.add(atzeraButton);
	}
}

