
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements ActionListener {

	CustomTextPanel textPanel;
	CustomToolbar toolbar;
	FormPanel formPanel;
	JButton button;
	public MainFrame(String title) throws HeadlessException {
		super(title);
		
		textPanel = new CustomTextPanel();
		button = new JButton("click Me!!");
		toolbar = new CustomToolbar();
		formPanel = new FormPanel("Add Person");
		
		setLayout(new BorderLayout());
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		
		add(textPanel, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
		add(toolbar, BorderLayout.NORTH);
		add(formPanel, BorderLayout.WEST);
 
		//*****************************************Clean implementation ************************************
				toolbar.setStringListener(new StringListener() {
					
					@Override
					public void textEmitted(String text) {
						textPanel.appendText(text);
					}
				});
		//****************************************************************************************************
				
		
		button.addActionListener(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		textPanel.convertToUpper();
	}
}
