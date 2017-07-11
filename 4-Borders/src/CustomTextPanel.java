
import java.awt.BorderLayout;
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
	
	public void appendText(String text) {
		textArea.append(text);
	}
}
