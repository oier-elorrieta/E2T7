package bista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import bd_Konexioa.BD_Konexioa;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;

public class BistaApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pasahitzaField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */

	public BistaApp() {
		setTitle("Bidaiatu!");
		BD_Konexioa dbConnection = new BD_Konexioa();
		dbConnection.connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pasahitzaField = new JTextField();
		pasahitzaField.setBounds(231, 123, 86, 20);
		contentPane.add(pasahitzaField);
		pasahitzaField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(231, 175, 86, 20);
		contentPane.add(passwordField);
			
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\in1dm3-d\\Downloads\\Screenshot 2025-01-24 at 09-29-22 como-sera-el-avion-del-futuro.jpg (Imagen JPEG 1344 × 896 píxeles).png"));
		btnNewButton.setBounds(0, 0, 546, 87);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\in1dm3-d\\Downloads\\Screenshot 2025-01-24 at 09-29-41 como-sera-el-avion-del-futuro.jpg (Imagen JPEG 1344 × 896 píxeles).png"));
		btnNewButton_1.setBounds(0, 259, 546, 87);
		contentPane.add(btnNewButton_1);
		
		JLabel erabiltzaileLabel = new JLabel("Erabiltzaile");
		erabiltzaileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		erabiltzaileLabel.setBounds(231, 98, 86, 14);
		contentPane.add(erabiltzaileLabel);
		
		JLabel pasahitzaLabel = new JLabel("Pasahitza");
		pasahitzaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pasahitzaLabel.setBounds(231, 154, 86, 14);
		contentPane.add(pasahitzaLabel);
		
		//Sartu botoia
		
			JButton sartuButton = new JButton("SARTU");
			sartuButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			sartuButton.setBounds(142, 226, 123, 23);
			contentPane.add(sartuButton);
		
		//Erregistratu botoia
			
			JButton erregistratuButton = new JButton("ERREGISTRATU");
			erregistratuButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Erregistratu frame = new Erregistratu();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					
					dispose();
				}
			});
			erregistratuButton.setBounds(287, 226, 123, 23);
			contentPane.add(erregistratuButton);
	}
}
