package copromes.client.gUserInterfaceLayer;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RegistrationWindow extends JFrame implements ActionListener {

	private WindowManager windowManager;
	
	private JLabel titleLabel;

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
		c.insets = new Insets(10, 10, 0, 10);
		
		titleLabel = new JLabel("REGISTRATION");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
