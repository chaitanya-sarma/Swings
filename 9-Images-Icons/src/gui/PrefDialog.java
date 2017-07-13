package gui;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;

public class PrefDialog extends JDialog {
	JSpinner spinner;
	SpinnerNumberModel model;
	JButton ok, cancel;

	public PrefDialog(Frame parent) {
		super(parent, "Preferences", false);
		setSize(400, 300);
		setLocationRelativeTo(parent);
		model = new SpinnerNumberModel(10, 0, 100, 1);
		spinner = new JSpinner(model);
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();

		// First Row
		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(spinner, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 5);
		add(ok, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);
		add(cancel, gc);

		
		
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
			}
		});
	}
}
