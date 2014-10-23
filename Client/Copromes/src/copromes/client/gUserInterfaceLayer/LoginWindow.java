package copromes.client.gUserInterfaceLayer;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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

		JPanel backgroundPanel = new JPanel(new GridBagLayout());
		backgroundPanel.setBackground(new Color(255, 255, 255));
		backgroundPanel.setBorder(new EmptyBorder(new Insets(topPadding,
				leftPadding, bottomPadding, rightPadding)));

		JLabel titleLabel = new JLabel("AUTHORIZATION");
		backgroundPanel.add(titleLabel);

		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(getBackground());
		JLabel loginLabel = new JLabel("LOGIN");
		loginLabel.setBorder(new EmptyBorder(0, 0, 0, 10));
		JTextField loginInput = new JTextField(10);
		loginInput.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		loginPanel.add(loginLabel);
		loginPanel.add(loginInput);
		backgroundPanel.add(loginPanel);

		JPanel passwordPanel = new JPanel();
		passwordPanel.setBackground(getBackground());
		JLabel passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setBorder(new EmptyBorder(0, 0, 0, 10));
		JPasswordField passwordInput = new JPasswordField(10);
		passwordInput.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordInput);
		backgroundPanel.add(passwordPanel);
		
		JButton loginButton = new JButton("DO LOGIN");
		//loginButton.setPreferredSize(new Dimension(100, 20));
		backgroundPanel.add(loginButton);
		
		JButton registerButton = new JButton("FREE REGISTRATION");
		//registerButton.setPreferredSize(new Dimension(25, 20));
		backgroundPanel.add(registerButton);
		
		JButton exitButton = new JButton("EXIT");
		//exitButton.setPreferredSize(new Dimension(50, 20));
		backgroundPanel.add(exitButton);
		
		add(backgroundPanel);
		pack();
		setVisible(true);
	}

}
