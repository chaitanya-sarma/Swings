import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CustomToolbar extends JPanel {

	private JButton hello;
	private JButton bye;
	public CustomToolbar() {
		hello =  new JButton("Hello");
		bye = new JButton("Bye");
		setLayout(new FlowLayout());
		add(hello);add(bye);
	}
}
