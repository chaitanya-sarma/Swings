import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {

	private JLabel nameLabel, occLabel;
	private JTextField nameField, occField;
	private JButton okBtn;

	public FormPanel(String title) {

		nameLabel = new JLabel("Name:");
		occLabel = new JLabel("Occupation:");
		nameField = new JTextField(10);
		occField = new JTextField(10);
		okBtn = new JButton("OK");

		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		Border inner = BorderFactory.createTitledBorder(title);
		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outer, inner));

		addComponents();
	}

	private void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		// First Row
		gc.weightx = 1;
		gc.weighty = .1;

		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(nameField, gc);

		// Second Row
		gc.weightx = 1;
		gc.weighty = .1;

		gc.gridx = 0;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(occLabel, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(occField, gc);

		// Third Row
		gc.weightx = 1;
		gc.weighty = 2;

		gc.gridx = 1;
		gc.gridy = 2;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okBtn, gc);

	}

}