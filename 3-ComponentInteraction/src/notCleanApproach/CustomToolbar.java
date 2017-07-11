package notCleanApproach;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CustomToolbar extends JPanel implements ActionListener {

	private JButton hello;
	private JButton bye;
	private CustomTextPanel textpanel;

	public CustomToolbar() {
		hello = new JButton("Hello");
		bye = new JButton("Bye");
		setLayout(new FlowLayout());
		add(hello);
		add(bye);
		
		hello.addActionListener(this);
		bye.addActionListener(this);
	}

	public void setTextpanel(CustomTextPanel textPanel) {
		this.textpanel = textPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		if (source == hello) {
			textpanel.appendText("Hello");
		}
		if (source == bye) {
			textpanel.appendText("byee");
		}
	}
}
