package copromes.client.gUserInterfaceLayer;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import copromes.commonInterfaces.InvalidRegistrationException;
import copromes.domainLayer.User;

public class RegistrationWindow extends JFrame implements ActionListener {

	private WindowManager windowManager;

	private JTextField loginInput;
	private JTextField nameInput;
	private JTextField bioInput;
	private JPasswordField passwordInput;
	private JPasswordField passwordConfirmInput;
	private JButton loginButton;
	private JButton registerButton;

	public RegistrationWindow(WindowManager windowManager) {
		this.windowManager = windowManager;
		initUI();
	}

	private void initUI() {
		setTitle("FREE REGISTRATION( NO SMS)");
		setSize(400, 450);
		setBackground(new Color(255, 255, 255));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, -30, 0, 10);

		JLabel titleLabel = new JLabel("REGISTRATION");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 0;
		c.gridwidth = 1;
		panel.add(titleLabel, c);

		JLabel loginLabel = new JLabel("LOGIN");
		c.insets = new Insets(10, 10, 0, 10);
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

		JLabel passwordConfirmLabel = new JLabel("PASSWORD CONFIRM");
		passwordConfirmLabel.setBorder(new EmptyBorder(0, 0, 0, 10));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		c.weightx = 0;
		c.gridwidth = 1;
		panel.add(passwordConfirmLabel, c);

		passwordConfirmInput = new JPasswordField(15);
		passwordConfirmInput.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		c.weightx = 0;
		c.gridwidth = 1;
		panel.add(passwordConfirmInput, c);

		JLabel nameLabel = new JLabel("NAME");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		c.weightx = 0;
		c.gridwidth = 1;
		nameLabel.setBorder(new EmptyBorder(0, 0, 0, 10));
		panel.add(nameLabel, c);

		nameInput = new JTextField(15);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		c.weightx = 0;
		c.gridwidth = 1;
		nameInput.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(nameInput, c);

		JLabel bioLabel = new JLabel("BIO");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		c.weightx = 0;
		c.gridwidth = 1;
		bioLabel.setBorder(new EmptyBorder(0, 0, 0, 10));
		panel.add(bioLabel, c);

		bioInput = new JTextField(15);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 5;
		c.weightx = 0;
		c.gridwidth = 1;
		bioInput.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(bioInput, c);

		registerButton = new JButton("FREE REGISTRATION");
		registerButton.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 95, 0, -95);
		c.gridx = 0;
		c.gridy = 6;
		c.weightx = 0;
		c.gridwidth = 1;
		panel.add(registerButton, c);

		JButton cancelButton = new JButton("CANCEL");
		cancelButton.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 95, 0, -95);
		c.gridx = 0;
		c.gridy = 7;
		c.weightx = 0;
		c.gridwidth = 1;
		panel.add(cancelButton, c);

		add(panel);
		pack();
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object eventSource = e.getSource();
		if (eventSource == registerButton) {
			try {
				User user = windowManager.authManager.registerUser(
						loginInput.getText(), passwordInput.getPassword(),
						passwordConfirmInput.getPassword(),
						nameInput.getText(), bioInput.getText());
				ChatWindow chatWindow = new ChatWindow(windowManager, user);
				dispose();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			} catch (InvalidRegistrationException e1) {
				
			}
		}
		else {
			dispose();
			LoginWindow loginWindow = new LoginWindow(windowManager);
		}

	}
}
