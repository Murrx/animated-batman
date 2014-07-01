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

import com.gsos.dimiter_robin.backend.ClientBackend;
import com.gsos.dimiter_robin.ibanInterface.Fault_Exception;

public class ClientFrontend extends JFrame{
	
	private ClientBackend backend = new ClientBackend();
	JTabbedPane tabs;
	
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
				backend.setAuth(naamField.getText(), postcodeField.getText(), huisnummerField.getText());
				JButton source = (JButton)e.getSource();
				AuthTab tab = (AuthTab) source.getParent();
				tab.statusLabel.setText("chages saved");
			}
		}
	}
	
	private class ValidateIbanTab extends JPanel{
		private JLabel statusLabel;
		JTextField ibanField;
		
		public ValidateIbanTab(){
			this.setLayout(new GridLayout(4,2));
			
			statusLabel = new JLabel("");
			JLabel ibanLabel = new JLabel("iban");
			statusLabel.setForeground(Color.GREEN);
			ibanField = new JTextField(20);
			JButton validateButton = new JButton("Validate");
			this.add(ibanLabel);
			this.add(ibanField);
			this.add(statusLabel);
			this.add(validateButton);
			this.add(new JLabel(""));
			
			validateButton.addActionListener(new ValidateListener());
		}
		
		private class ValidateListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				try {
					boolean validationResult = backend.validateIban(ibanField.getText());
					statusLabel.setText((validationResult?"IBAN valid!":"Invalid!"));
				} catch (Fault_Exception e1) {
					statusLabel.setText(e1.getMessage());
				}	
			}
		}
	}
	
	private class ToIbanTab extends JPanel{
		JLabel statusLabel;
		JTextField bankcodeField;
		JTextField rekeningnummerField;
		public ToIbanTab(){
			JLabel bankcodeLabel = new JLabel("Bankcode");
			JLabel rekeningNummerLabel = new JLabel("Rekeningnummer");
			bankcodeField = new JTextField(20);
			rekeningnummerField = new JTextField(20);
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
				try {
					String resultIban = backend.toIban(bankcodeField.getText(), rekeningnummerField.getText());
					statusLabel.setText("iban = " + resultIban);
				} catch (Fault_Exception e1) {
					statusLabel.setText(e1.getMessage());
				} catch (IllegalArgumentException e2) {
					statusLabel.setText(e2.getMessage());
				}
			}
			
		}
	}

}
