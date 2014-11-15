package copromes.client.gUserInterfaceLayer;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import copromes.domainLayer.ChatRoom;
import copromes.domainLayer.User;

public class ChatWindow extends JFrame implements ActionListener {

	private WindowManager windowManager;
	
	private User user;
	private ChatRoom chatRoom;
	
	private JTextArea chatArea;
	private JScrollPane scrollPane;
	private JTextArea usersArea;
	private JTextField messageInput;
	private JButton sendMessageButton;

	public ChatWindow(WindowManager windowManager, User user) {
		this.windowManager = windowManager;
		this.user = user;
		initUI();
	}

	private void initUI() {
		setTitle("CHAT");
		setSize(1337, 1488);
		setBackground(new Color(255, 255, 255));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JPanel panel1 = new JPanel();
		chatArea = new JTextArea(30, 30);
		chatArea.setBorder(BorderFactory.createLineBorder(Color.black));
		scrollPane = new JScrollPane(chatArea);
		chatArea.setWrapStyleWord(true);
		chatArea.setLineWrap(true);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0;
		c.gridwidth = 1;
		chatArea.setEditable(false);
		panel1.add(chatArea);
		panel.add(panel1, c);

		JPanel panel2 = new JPanel();
		usersArea = new JTextArea(30, 15);
		usersArea.setBorder(BorderFactory.createLineBorder(Color.black));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 0;
		c.gridwidth = 1;
		usersArea.setEditable(false);
		panel2.add(usersArea);
		panel.add(panel2, c);

		JPanel panel3 = new JPanel();
		messageInput = new JTextField(30);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0;
		c.gridwidth = 1;
		panel3.add(messageInput);
		panel.add(panel3, c);

		sendMessageButton = new JButton("Send Message");
		sendMessageButton.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		c.weightx = 0;
		c.gridwidth = 1;
		panel.add(sendMessageButton, c);

		add(panel);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object eventSource = e.getSource();
		if (eventSource == sendMessageButton) {
			try {
//				windowManager.messengerManager.sendMessage(messageInput.getText(), chatRoom);
				messageInput.setText(null);
				
			}
			catch (Exception e1)
			{
				
			}
		}

	}
}
