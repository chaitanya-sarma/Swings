package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;

import controller.Controller;

public class MainFrame extends JFrame implements ActionListener {

	private CustomTextPanel textPanel;
	private CustomToolbar toolbar;
	private FormPanel formPanel;
	private JButton button;
	private JFileChooser fileChooser;
	private Controller controller;
	private PrefDialog pref;
	JSplitPane splitPane;

	public MainFrame(String title) throws HeadlessException {
		super(title);

		textPanel = new CustomTextPanel();
		button = new JButton("click Me!!");
		toolbar = new CustomToolbar();
		formPanel = new FormPanel("Add Person");
		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new PersonFilter());
		controller = new Controller();
		pref = new PrefDialog(this);
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setOneTouchExpandable(true);
		setLayout(new BorderLayout());
		setSize(600, 500);
		setMinimumSize(new Dimension(500, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setJMenuBar(createMenuBar());

		splitPane.add(textPanel);
		splitPane.add(formPanel);

		add(splitPane, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
		add(toolbar, BorderLayout.PAGE_START);

		// *****************************************Clean implementation
		// ************************************
		toolbar.setStringListener(new StringListener() {

			@Override
			public void textEmitted(String text) {
				textPanel.appendText(text);
			}
		});
		// ****************************************************************************************************

		formPanel.setFormListener(new FormListener() {

			@Override
			public void formEventOccured(FormEvent fe) {
				textPanel.appendText("Hello" + fe.getName() + "  " + fe.getOccu() + "   " + fe.getAge() + "\n");
				controller.addPerson(fe);
			}
		});

		button.addActionListener(this);
	}

	private JMenuBar createMenuBar() {
		JMenuBar menu = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem importData = new JMenuItem("Import");
		importData.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					textPanel.appendText("\n" + fileChooser.getSelectedFile());
				}

			}
		});
		JMenuItem exportData = new JMenuItem("Export");
		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(importData);
		fileMenu.add(exportData);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		menu.add(fileMenu);
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(MainFrame.this, "Do you want to exit.", "Confirm Exit",
						JOptionPane.OK_CANCEL_OPTION);
				if (action == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});

		JMenu windowMenu = new JMenu("Window");
		JMenu show = new JMenu("Show");
		JMenuItem prefDialog = new JMenuItem("PrefDialog");
		prefDialog.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pref.setVisible(true);
			}
		});
		JCheckBoxMenuItem personForm = new JCheckBoxMenuItem("Person Form");
		personForm.setSelected(true);
		personForm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				formPanel.setVisible(((JCheckBoxMenuItem) e.getSource()).isSelected());
				if(((JCheckBoxMenuItem) e.getSource()).isSelected()){
					splitPane.setDividerLocation((int)formPanel.getMinimumSize().getWidth());
				}
			}
		});

		windowMenu.add(show);
		show.add(personForm);
		show.add(prefDialog);
		menu.add(windowMenu);
		return menu;
	}

	public void actionPerformed(ActionEvent arg0) {
		textPanel.convertToUpper();
	}
}
