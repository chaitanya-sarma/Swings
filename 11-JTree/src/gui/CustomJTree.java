package gui;

import java.awt.BorderLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeSelectionModel;

public class CustomJTree extends JPanel {

	JTree serverTree;
	TreeNode rootNode;
	JLabel value ;
	private DefaultTreeCellRenderer treeCellRenderer;
	
	public CustomJTree() {
		value = new JLabel("");
		rootNode = createTree(); 
		serverTree = new JTree(rootNode);
		serverTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		setLayout(new BorderLayout());
		add(new JScrollPane(serverTree), BorderLayout.CENTER);
		add(value, BorderLayout.SOUTH); 
		
		treeCellRenderer = new DefaultTreeCellRenderer();
		treeCellRenderer.setOpenIcon(createIcon("/images/open.gif"));
		treeCellRenderer.setClosedIcon(createIcon("/images/close.gif"));
		serverTree.setCellRenderer(treeCellRenderer);
		serverTree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode)serverTree.getLastSelectedPathComponent();
				value.setText((String)node.getUserObject());
			}
		});
	}

	private DefaultMutableTreeNode createTree() {
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Servers");
		DefaultMutableTreeNode branch1 = new DefaultMutableTreeNode("USA");
		DefaultMutableTreeNode leaf1 = new DefaultMutableTreeNode("NY");
		DefaultMutableTreeNode leaf2 = new DefaultMutableTreeNode("WA");
		branch1.add(leaf1);
		branch1.add(leaf2);

		DefaultMutableTreeNode branch2 = new DefaultMutableTreeNode("INDIA");
		DefaultMutableTreeNode leaf3 = new DefaultMutableTreeNode("NDLS");
		DefaultMutableTreeNode leaf4 = new DefaultMutableTreeNode("HYD");
		branch2.add(leaf3);
		branch2.add(leaf4);
		top.add(branch1);
		top.add(branch2);
		return top;
	}
	public TreeNode getRootNode(){
		return rootNode;
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
