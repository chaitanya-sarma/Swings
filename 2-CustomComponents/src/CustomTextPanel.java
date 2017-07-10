import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CustomTextPanel extends JPanel{

	private JTextArea textArea;

	public CustomTextPanel() {
		textArea = new JTextArea();
		
		setLayout(new BorderLayout());
		setSize(600, 500);
		setVisible(true);
		
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	public void convertToUpper() {
		textArea.setText(textArea.getText().toUpperCase());
	}
}
