package bista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import com.toedter.calendar.JDateChooser;

import DAO.AirelineaDAO;
import DAO.AireportuaDAO;
import DAO.BidaiaDAO;
import DAO.HerrialdeaDAO;
import DAO.ZerbitzuakDAO;
import modeloa.Airelinea;
import modeloa.Aireportua;
import modeloa.Bidaia;
import modeloa.Herrialdea;
import modeloa.Zerbitzua;

import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import java.awt.Choice;
import javax.swing.JButton;

public class Hegaldia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField kodeaJField;
	private JTextField kodeaHField;
	private int IDHegaldia;
	private JTextField prezioaJField;
	private JTextField prezioaHField;
	private JTextField irteeraJField;
	private JTextField helmugaJField;

	public Hegaldia(int erabiltzailezbk, ArrayList<Bidaia> bidaiak, int IDLerroa) {
		setTitle("HEGALDI BERRIA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		AireportuaDAO aireportuaDAO = new AireportuaDAO();
		AirelineaDAO airelineaDAO = new AirelineaDAO();
		ZerbitzuakDAO zerbitzuakDAO = new ZerbitzuakDAO();

		SimpleDateFormat formatoa = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat orduak = new SimpleDateFormat("HH:mm:ss");
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel etorriPanel = new JPanel();
		etorriPanel.setBounds(511, 94, 381, 329);
		contentPane.add(etorriPanel);
		etorriPanel.setLayout(null);
		
        etorriPanel.setVisible(false);
		
		JCheckBox etorriCheckBox = new JCheckBox("Etorri");
		etorriCheckBox.setBounds(511, 45, 97, 23);
		contentPane.add(etorriCheckBox);
		
		etorriCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mostrar o ocultar el JPanel según el estado del JCheckBox
                etorriPanel.setVisible(etorriCheckBox.isSelected());
            }
        });
		
		JLabel irteeraJLabel = new JLabel("Irteera Data:");
		irteeraJLabel.setBounds(10, 25, 97, 14);
		etorriPanel.add(irteeraJLabel);
		
		JLabel orduaJLabel = new JLabel("Irteera Ordua:");
		orduaJLabel.setBounds(10, 65, 97, 14);
		etorriPanel.add(orduaJLabel);
		
		JLabel kodeaJLabel = new JLabel("Kodea:");
		kodeaJLabel.setBounds(10, 104, 97, 14);
		etorriPanel.add(kodeaJLabel);
		
		JLabel irteAireportuaJLabel = new JLabel("Irteera Aireportua:");
		irteAireportuaJLabel.setBounds(10, 147, 97, 14);
		etorriPanel.add(irteAireportuaJLabel);
		
		JLabel helmugaJLabel = new JLabel("Helmuga:");
		helmugaJLabel.setBounds(10, 192, 97, 14);
		etorriPanel.add(helmugaJLabel);
		
		JLabel airelineaJLabel = new JLabel("Airelinea");
		airelineaJLabel.setBounds(10, 237, 97, 14);
		etorriPanel.add(airelineaJLabel);
		
		kodeaJField = new JTextField();
		kodeaJField.setBounds(166, 101, 86, 20);
		etorriPanel.add(kodeaJField);
		kodeaJField.setColumns(10);
		
		JDateChooser irteeraDateChooser_1 = new JDateChooser();
		irteeraDateChooser_1.setBounds(166, 19, 200, 20);
		etorriPanel.add(irteeraDateChooser_1);

		
		JLabel irteeraHLabel = new JLabel("Irteera Data:");
		irteeraHLabel.setBounds(22, 49, 97, 14);
		contentPane.add(irteeraHLabel);
		
		JLabel orduaHLabel = new JLabel("Irteera Ordua:");
		orduaHLabel.setBounds(22, 96, 97, 14);
		contentPane.add(orduaHLabel);
		
		JLabel kodeaHLabel = new JLabel("Kodea:");
		kodeaHLabel.setBounds(22, 133, 97, 14);
		contentPane.add(kodeaHLabel);
		
		JLabel irteAireportuaHLabel = new JLabel("Irteera Aireportua:");
		irteAireportuaHLabel.setBounds(22, 209, 97, 14);
		contentPane.add(irteAireportuaHLabel);
		
		JLabel helmugaHLabel = new JLabel("Helmuga:");
		helmugaHLabel.setBounds(22, 260, 97, 14);
		contentPane.add(helmugaHLabel);
		
		JLabel airelineaHLabel = new JLabel("Airelinea:");
		airelineaHLabel.setBounds(22, 316, 97, 14);
		contentPane.add(airelineaHLabel);
		
		kodeaHField = new JTextField();
		kodeaHField.setColumns(10);
		kodeaHField.setBounds(153, 130, 86, 20);
		contentPane.add(kodeaHField);
		
		JDateChooser irteeraDateChooser = new JDateChooser();
		irteeraDateChooser.setBounds(153, 43, 200, 20);
		contentPane.add(irteeraDateChooser);
		

        // Crear un modelo de fecha para el JSpinner (establecer hora, minutos y segundos)
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12); // Establecer una hora inicial
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date initialDate = calendar.getTime();

        SpinnerDateModel model = new SpinnerDateModel(initialDate, null, null, Calendar.HOUR_OF_DAY);
        JSpinner timeSpinner = new JSpinner(model);

        // Establecer formato de hora y minuto
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
        timeSpinner.setEditor(timeEditor);

        // Ajustar posición y tamaño del JSpinner
        timeSpinner.setBounds(153, 88, 80, 30);
        contentPane.add(timeSpinner);

        // Mostrar la hora seleccionada cuando el usuario presione un botón (ejemplo)
        timeSpinner.addChangeListener(e -> {
            Date selectedTime = (Date) timeSpinner.getValue();
            System.out.println("Hora seleccionada: " + selectedTime.toString());
        });
    
        // Crear un modelo de fecha para el JSpinner (establecer hora, minutos y segundos)
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.HOUR_OF_DAY, 12); // Establecer una hora inicial
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);


        SpinnerDateModel model1 = new SpinnerDateModel(initialDate, null, null, Calendar.HOUR_OF_DAY);
        
		JSpinner timeSpinner1 = new JSpinner(model1);
		timeSpinner1.setBounds(172, 57, 80, 30);
		etorriPanel.add(timeSpinner1);
        JLabel prezioaHLabel = new JLabel("Prezioa:");
        prezioaHLabel.setBounds(22, 170, 97, 14);
        contentPane.add(prezioaHLabel);
        
        prezioaHField = new JTextField();
        prezioaHField.setColumns(10);
        prezioaHField.setBounds(153, 167, 86, 20);
        contentPane.add(prezioaHField);
        Date selectedTime1 = (Date) timeSpinner1.getValue();
        
        // Mostrar la hora seleccionada cuando el usuario presione un botón (ejemplo)
        timeSpinner1.addChangeListener(e -> {
            Date selectedTime = (Date) timeSpinner1.getValue();
            System.out.println("Hora seleccionada: " + selectedTime.toString());
        });

		
		        // Establecer formato de hora y minuto
		        JSpinner.DateEditor timeEditor1 = new JSpinner.DateEditor(timeSpinner1, "HH:mm");
		        timeSpinner1.setEditor(timeEditor1);
		        
		        Choice airelineaJChoice = new Choice();
		        airelineaJChoice.setBounds(166, 231, 200, 20);
		        etorriPanel.add(airelineaJChoice);
		        
		        JLabel prezioaJLabel = new JLabel("Prezioa:");
		        prezioaJLabel.setBounds(10, 281, 97, 14);
		        etorriPanel.add(prezioaJLabel);
		         
		        Choice irteeraHChoice = new Choice();
		        irteeraHChoice.setBounds(153, 209, 200, 20);
		        contentPane.add(irteeraHChoice);
		        
		        Choice helmugaHChoice = new Choice();
		        helmugaHChoice.setBounds(153, 260, 200, 20);
		        contentPane.add(helmugaHChoice);
		        
		        Choice airelineaHChoice = new Choice();
		        airelineaHChoice.setBounds(153, 310, 200, 20);
		        contentPane.add(airelineaHChoice);
		        
		        JButton atzeraHButton = new JButton("ATZERA");
		        atzeraHButton.setBounds(99, 357, 110, 66);
		        contentPane.add(atzeraHButton);
		        
		        prezioaJField = new JTextField();
		        prezioaJField.setColumns(10);
		        prezioaJField.setBounds(166, 278, 86, 20);
		        etorriPanel.add(prezioaJField);
		        
		        irteeraJField = new JTextField();
		        irteeraJField.setBounds(166, 145, 178, 17);
		        etorriPanel.add(irteeraJField);
		        irteeraJField.setColumns(10);
		        
		        helmugaJField = new JTextField();
		        helmugaJField.setColumns(10);
		        helmugaJField.setBounds(166, 189, 178, 17);
		        etorriPanel.add(helmugaJField);
		        

			    ArrayList<Airelinea> airelineak = airelineaDAO.lortuAirelineak();
			    
			    for (Airelinea airelinea : airelineak) {
			    	airelineaHChoice.add(airelinea.getIzenaAirelinea());
			    	airelineaJChoice.add(airelinea.getIzenaAirelinea());
			    }
			    
			    ArrayList<Aireportua> aireportuak = aireportuaDAO.lortuAireportuGuztiak();
			    
			    for (Aireportua aireportua : aireportuak) {
			    	irteeraHChoice.add(aireportua.getIzena());
			    	helmugaHChoice.add(aireportua.getIzena());
			    }
		        
		        JButton gordeHButton = new JButton("GORDE");
		        gordeHButton.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		
		        		Date irteeraHDate = irteeraDateChooser.getDate();
		        			if(irteeraHDate == null) {
		        				JOptionPane.showMessageDialog(null, "Mesedez, hautatu bueltatzeko data bat.");
		        				return;
		        			}
		        		String irteeraHData = formatoa.format(irteeraHDate);
		        				
		        		Date orduaAukeratutaH = (Date) timeSpinner.getValue();
		        		String orduaIrteeraH = orduak.format(orduaAukeratutaH);
		        		String kodeaH = kodeaHField.getText();
		        		double prezioHegaldiaH = Double.parseDouble(prezioaHField.getText());
		        		String aireportuHIrteera = aireportuaDAO.lortuID(irteeraHChoice.getSelectedItem());
		        		String aireportuHHelmuga = aireportuaDAO.lortuID(helmugaHChoice.getSelectedItem());
		        		String airelineaH = airelineaDAO.lortuID(airelineaHChoice.getSelectedItem());
		        		int iraupenaH = 3;
		        		
		        		Zerbitzua hegaldia = new Zerbitzua (aireportuHIrteera, aireportuHHelmuga, kodeaH,
		        				airelineaH, prezioHegaldiaH, irteeraHData, orduaIrteeraH,
		        				iraupenaH, IDLerroa);
		        		
		        		zerbitzuakDAO.sartuHegaldia(hegaldia, IDLerroa);
		        				
			        		if (etorriCheckBox.isSelected()) {
			        			etorriPanel.setVisible(true);
			        			
			        			int IDHegaldia = ZerbitzuakDAO.lortuIDHegaldia(kodeaH);
			        			
			        			//Date String-era pasatzeko
			        			
			    				Date irteeraJDate = irteeraDateChooser_1.getDate();
				    				if (irteeraJDate == null) {
				    				    JOptionPane.showMessageDialog(null, "Mesedez, hautatu data bat.");
				    				    return;
				    				}
			    				String irteeraJData = formatoa.format(irteeraJDate);
			    				
			    				String kodeaJ = kodeaJField.getText();
			    				String aireportuJIrteera = aireportuaDAO.lortuID(helmugaHChoice.getSelectedItem());
			    				String aireportuJHelmuga = aireportuaDAO.lortuID(irteeraHChoice.getSelectedItem());
			    				String airelineaJ = airelineaDAO.lortuID(airelineaJChoice.getSelectedItem());
			    				Date orduaAukeratutaJ = (Date) timeSpinner1.getValue();
			    				String orduaIrteeraJ = orduak.format(orduaAukeratutaJ);
			    				int iraupenaJ = 3;
			    				double prezioHegaldiaJ = Double.parseDouble(prezioaJField.getText());
			    				System.out.println(kodeaJ);
			    				System.out.println(aireportuJIrteera);
			    				System.out.println(aireportuJHelmuga);
			    				System.out.println(airelineaJ);
			    				System.out.println(orduaIrteeraJ);
			    				System.out.println(iraupenaJ);
			    				System.out.println(prezioHegaldiaJ);
	
			    				
			    				Zerbitzua etorriHegaldia = new Zerbitzua (IDHegaldia, aireportuJIrteera, aireportuJHelmuga,
			    						irteeraJData, orduaIrteeraJ, iraupenaJ, kodeaJ, airelineaJ);

				        		
			    				 boolean exito = zerbitzuakDAO.sartuJoanEtorri(etorriHegaldia, IDHegaldia);

			    	 		        if (exito) {
			    	 		            System.out.println("Joanetorria gordeta");
			    	 		        } else {
			    	 		            System.out.println("Errorea joanetorria erregistratzen");
			    	 		        }
			        		}
		        		
		        	}
		        });
		        gordeHButton.setBounds(304, 357, 110, 66);
		        contentPane.add(gordeHButton);

    }
}

