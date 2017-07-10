import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame implements ActionListener {

	JTextArea textArea;
	JButton button;
	public MainFrame(String title) throws HeadlessException {
		super(title);
		
		textArea = new JTextArea();
		button = new JButton("click Me!!");
		
		setLayout(new BorderLayout());
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		
		add(textArea, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
		
		button.addActionListener(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		textArea.setText(textArea.getText().toUpperCase());
	}
}
