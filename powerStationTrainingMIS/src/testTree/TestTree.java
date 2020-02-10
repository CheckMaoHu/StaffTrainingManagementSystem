package testTree;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import dto.DepartDTO;
import dto.HighDepartDTO;
import services.depart.Department;

public class TestTree {

	private JFrame frame;
	private JTree tree;
	private String highDepartName;
	private String departName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestTree window = new TestTree();
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
	public TestTree() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(200, 200, 202, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 188, 268);
		frame.getContentPane().add(panel);
		tree = new JTree();
		tree.setModel(
				new DefaultTreeModel(new DefaultMutableTreeNode("\u592A\u539F\u7B2C\u4E8C\u70ED\u7535\u5382\t\t") {
					{
						DefaultMutableTreeNode node;
						// 定义服务层
						Department depart = new Department();
						// 定义接受层
						List<HighDepartDTO> departAllDTO = new ArrayList<HighDepartDTO>();
						departAllDTO = depart.queryAllInfoHighByNo();
						for (int i = 0; i < departAllDTO.size(); i++) {
							if (departAllDTO.get(i).getHighDepartNumber() != null) {

								node = new DefaultMutableTreeNode(departAllDTO.get(i).getHighDepartName());

								findChildUnit(departAllDTO.get(i).getHighDepartNumber(), node);
								add(node);
							}
						}
					}
				}));
		tree.setBounds(0, 0, 185, 334);
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.print(tree.getSelectionModel().getLeadSelectionPath().getPathComponent(1).toString());
				System.out.println(tree.getSelectionModel().getLeadSelectionPath().getLastPathComponent().toString());

			}
		});
		panel.add(tree);
		panel.setLayout(new BorderLayout(0, 0));
	}

	public void findChildUnit(String highDepartNumber, DefaultMutableTreeNode node) {
		// 定义服务层
		Department childDepartInfo = new Department();
		// 定义传输层
		List<DepartDTO> departDTO = new ArrayList<DepartDTO>();
		departDTO = childDepartInfo.queryAllInfoChildByNo();
		for (int i = 0; i < departDTO.size(); i++) {
			if (departDTO.get(i).getHighDepartNumber().equals(highDepartNumber)) {
				node.add(new DefaultMutableTreeNode(departDTO.get(i).getDepartName()));
			}
		}
	}

	public JTree getTree() {
		return tree;
	}

	public String getHighDepartName() {
		return highDepartName;
	}

	public String getDepartName() {
		return departName;
	}
}
