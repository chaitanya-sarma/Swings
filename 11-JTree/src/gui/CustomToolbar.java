package gui;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class CustomToolbar extends JToolBar implements ActionListener {

	private StringListener stringListener;
	private JButton hello;
	private JButton bye;

	public CustomToolbar() {
		hello = new JButton("Hello");
		hello.setIcon(createIcon("/images/webview.gif"));
		hello.setToolTipText("Hello");
		bye = new JButton("Bye");
		add(hello);
		addSeparator();
		add(bye);

		hello.addActionListener(this);
		bye.addActionListener(this);
	//	setBorder(BorderFactory.createEtchedBorder());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if (source == hello) {
			if (stringListener != null) {
				stringListener.textEmitted("Hello");
			}
		}
		if (source == bye) {
			if (stringListener != null) {
				stringListener.textEmitted("byee");
			}
		}
	}

	public void setStringListener(StringListener listener) {
		stringListener = listener;
	}
	
	private ImageIcon createIcon(String path){
		URL url = System.class .getResource(path);
		if(url == null){
			// Set something
		}
		ImageIcon icon =new ImageIcon( new ImageIcon(url).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		return icon;
	}
}
