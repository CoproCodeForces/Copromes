package copromes.client.gUserInterfaceLayer;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class LoginWindow extends JFrame {

	private final int rowsNumber = 6;
	private final int columnsNumber = 1;
	private final int horizontalGap = 10;
	private final int verticalGap = 5;

	private final int topPadding = 15;
	private final int leftPadding = 40;
	private final int bottomPadding = 15;
	private final int rightPadding = 40;

	public LoginWindow() {
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
		c.insets = new Insets(10, 80, 0, 10);
		JLabel titleLabel = new JLabel("AUTHORIZATION");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0;
		c.gridwidth = 2;
//		titleLabel.setBorder(new EmptyBorder(0, 30, 0, 0));
		panel.add(titleLabel, c);

		c.insets = new Insets(10, 10, 0, 10);
		
		JLabel loginLabel = new JLabel("LOGIN");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0;
		c.gridwidth = 1;
		loginLabel.setBorder(new EmptyBorder(0, 0, 0, 10));
		panel.add(loginLabel, c);

		JTextField loginInput = new JTextField(10);
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

		JPasswordField passwordInput = new JPasswordField(10);
		passwordInput.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		c.weightx = 0;
		c.gridwidth = 1;
		panel.add(passwordInput, c);

		JButton loginButton = new JButton("DO LOGIN");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		c.weightx = 0;
		c.gridwidth = 1;
		panel.add(loginButton, c);

		JButton registerButton = new JButton("FREE REGISTRATION");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		c.weightx = 0;
		c.gridwidth = 2;
		panel.add(registerButton, c);

		JButton exitButton = new JButton("EXIT");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		c.weightx = 0;
		c.gridwidth = 2;
		panel.add(exitButton, c);

		add(panel);
		pack();
		setVisible(true);
	}

}
