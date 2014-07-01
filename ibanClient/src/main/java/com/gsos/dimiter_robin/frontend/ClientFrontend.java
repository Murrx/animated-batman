package com.gsos.dimiter_robin.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class ClientFrontend extends JFrame{
	
	JTabbedPane tabs;
	String authNaam;
	String authPostcode;
	String authHuisnummer;
	
	
	public ClientFrontend(){
		tabs = new JTabbedPane();
		
		tabs.addTab("Authenticate", new AuthTab());
		tabs.addTab("Convert To Iban", new ToIbanTab());
		tabs.addTab("Validate Iban", new ValidateIbanTab());
		
		this.add(tabs);
		this.setSize(new Dimension(400,100));
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[]args){
		ClientFrontend client = new ClientFrontend();
	}
	
	private class AuthTab extends JPanel{
		private JTextField postcodeField;
		private JTextField huisnummerField;
		private JTextField naamField;
		protected JLabel statusLabel;
		
		public AuthTab(){
			JLabel naamLabel = new JLabel("Naam");
			JLabel postcodeLabel = new JLabel("postcode");
			JLabel huisnummerLabel = new JLabel("huisnummer");
			statusLabel = new JLabel("");
			statusLabel.setForeground(Color.green);
			postcodeField = new JTextField(20);
			huisnummerField = new JTextField(20);
			naamField = new JTextField(20);
			JButton saveButton = new JButton("Save changes");
			saveButton.addActionListener(new SaveButtonListener());
			this.setLayout(new GridLayout(4,2));
			
			this.add(naamLabel);
			this.add(naamField);
			this.add(postcodeLabel);
			this.add(postcodeField);
			this.add(huisnummerLabel);
			this.add(huisnummerField);
			this.add(statusLabel);
			this.add(saveButton);
			
		}
		
		private class SaveButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				System.out.println("setting auth data");
				authNaam = naamField.getText();
				authPostcode = postcodeField.getText();
				authHuisnummer = huisnummerField.getText();
				System.out.println("huisnummer = " + authHuisnummer);
				System.out.println("postcode = " + authPostcode);
				JButton source = (JButton)e.getSource();
				AuthTab tab = (AuthTab) source.getParent();
				tab.statusLabel.setText("chages saved");
			}
		}
	}
	
	private class ValidateIbanTab extends JPanel{
		public ValidateIbanTab(){
			JLabel ibanLabel = new JLabel("iban");
			this.add(ibanLabel);
		}
	}
	
	private class ToIbanTab extends JPanel{
		JLabel statusLabel;
		public ToIbanTab(){
			JLabel bankcodeLabel = new JLabel("Bankcode");
			JLabel rekeningNummerLabel = new JLabel("Rekeningnummer");
			JTextField bankcodeField = new JTextField(20);
			JTextField rekeningnummerField = new JTextField(20);
			JButton convertBUtton = new JButton("Convert");
			statusLabel = new JLabel("");
			statusLabel.setForeground(Color.GREEN);
			this.setLayout(new GridLayout(4,2));
			
			this.add(bankcodeLabel);
			this.add(bankcodeField);
			this.add(rekeningNummerLabel);
			this.add(rekeningnummerField);
			this.add(statusLabel);
			this.add(convertBUtton);
			
			convertBUtton.addActionListener(new ConvertButtonListener());
		}
		
		private class ConvertButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				//do stuff
				statusLabel.setText("stuff just happend");
			}
			
		}
	}

}
