import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel implements ActionListener {

	private JLabel nameLabel, occLabel;
	private JTextField nameField, occField;
	private JButton okBtn;
	private JList ageList;
	
	private FormListener fl;
	
	
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
		okBtn.addActionListener(this);
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

		
		//4th
		ageList = new JList<>();
		DefaultListModel age = new DefaultListModel();
		age.addElement(new AgeCategory(0, "Below 18"));
		age.addElement(new AgeCategory(1, "18 and 65"));
		age.addElement(new AgeCategory(2, "Above 65"));
		ageList.setModel(age);
		
		ageList.setPreferredSize(new Dimension(113, 70));
		ageList.setBorder(BorderFactory.createEtchedBorder());
		ageList.setSelectedIndex(1);
		
		gc.weightx = 1;
		gc.weighty = .1;

		gc.gridx = 1;
		gc.gridy = 2;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(ageList, gc);

		
		// Third Row
		gc.weightx = 1;
		gc.weighty = 2;

		gc.gridx = 1;
		gc.gridy = 3;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okBtn, gc);

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String nam = nameField.getText();
		String occ = occField.getText();
		String age = ((AgeCategory)ageList.getSelectedValue()).getValue();
		FormEvent fe = new FormEvent(nam, occ, age);
		fl.formEventOccured(fe);
	}

	public void setFormListener(FormListener formListener) {
		fl = formListener;
	}

}

class AgeCategory{
	int index;
	String value;
	public AgeCategory(int index, String value) {
		super();
		this.index = index;
		this.value = value;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String toString(){
		return value;
	}
}