package gui;

import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		System.out.print("Hello");
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				MainFrame mainFrame = new MainFrame("Hello Frame");
			}
		});
		
	}

}
 