package copromes.client.gUserInterfaceLayer;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import copromes.client.authorizationLayer.AuthorizationManager;
import copromes.commonInterfaces.InvalidLoginException;

public class LoginWindow extends JFrame implements ActionListener {

	private WindowManager windowManager;

	private JLabel titleLabel;
	private JButton loginButton;
	private JButton registerButton;
	private JTextField loginInput;
	private JPasswordField passwordInput;

	public LoginWindow(WindowManager windowManager) {
		this.windowManager = windowManager;
		initUI();
	}

	private void initUI() {
		setTitle("Copromes v0.13.3.7");
		setSize(300, 450);
		setBackground(new Color(255, 255, 255));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 0, 10);

		titleLabel = new JLabel("AUTHORIZATION");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 0;
		c.gridwidth = 1;
		// titleLabel.setBorder(new EmptyBorder(0, 30, 0, 0));
		panel.add(titleLabel, c);

		JLabel loginLabel = new JLabel("LOGIN");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0;
		c.gridwidth = 1;
		loginLabel.setBorder(new EmptyBorder(0, 0, 0, 10));
		panel.add(loginLabel, c);

		loginInput = new JTextField(15);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 0;
		c.gridwidth = 1;
		loginInput.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(loginInput, c);

		JLabel passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setBorder(new EmptyBorder(0, 0, 0, 10));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		c.weightx = 0;
		c.gridwidth = 1;
		panel.add(passwordLabel, c);

		passwordInput = new JPasswordField(15);
		passwordInput.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		c.weightx = 0;
		c.gridwidth = 1;
		panel.add(passwordInput, c);

		loginButton = new JButton("DO LOGIN");
		loginButton.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 100, 0, -100);
		c.gridx = 0;
		c.gridy = 3;
		c.weightx = 0.5;
		c.gridwidth = 1;
		panel.add(loginButton, c);

		registerButton = new JButton("FREE REGISTRATION");
		registerButton.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, -40, 0, 50);
		c.gridx = 1;
		c.gridy = 4;
		c.weightx = 0;
		c.gridwidth = 0;
		panel.add(registerButton, c);

		JButton exitButton = new JButton("EXIT");
		exitButton.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 100, 0, -100);
		c.gridx = 0;
		c.gridy = 5;
		c.weightx = 0;
		c.gridwidth = 1;
		panel.add(exitButton, c);

		add(panel);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object eventSource = e.getSource();
		if (eventSource == loginButton) {
			try {
				windowManager.authManager.doLogin(loginInput.getText(),
						passwordInput.getPassword());				
				ChatWindow chatWindow = new ChatWindow(windowManager);
				dispose();
			} catch (RemoteException e1) {
				JOptionPane.showMessageDialog(null, e1, "Connection problem", 0);
			} catch (InvalidLoginException e1) {
				JOptionPane.showMessageDialog(null, e1, "Invalid login", 0);
			}
		} else if (eventSource == registerButton) {
			RegistrationWindow registrationWindow = new RegistrationWindow(windowManager);
			dispose();
		} else {
			System.exit(0);
		}
	}
}
