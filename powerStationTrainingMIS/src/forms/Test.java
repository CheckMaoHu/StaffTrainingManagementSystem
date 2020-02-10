package forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class Test {

	private JFrame frame;
	private JTree tree, tree1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 630, 469);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 98, 185, 334);
		frame.getContentPane().add(panel_1);
		TreeSimple treeLode = new TreeSimple(panel_1);

		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFrame frame1 = new JFrame();
				frame1.getContentPane().setBackground(Color.LIGHT_GRAY);
				frame1.setBounds(0, 0, 100, 100);

				frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame1.getContentPane().setLayout(null);
			}
		});
		textField.setBounds(249, 131, 197, 54);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		tree = treeLode.getTree();
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(tree.getSelectionModel().getLeadSelectionPath().getLastPathComponent().toString());
			}
		});
	}

}
