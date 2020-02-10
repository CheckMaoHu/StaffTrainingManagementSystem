package forms.TrainDepart;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import dto.DepartDTO;
import dto.HighDepartDTO;
import services.depart.Department;

public class TrainDepartform {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTree tree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainDepartform window = new TrainDepartform();
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
	public TrainDepartform() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 655, 446);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\u73ED\u7EC4\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(23, 30, 64, 27);
		frame.getContentPane().add(lblNewLabel);

		final JComboBox comboBox = new JComboBox();
		// 定义服务层对象
		Department depart = new Department();
		// 定义接受层对象
		List<DepartDTO> departDTO = new ArrayList<DepartDTO>();
		departDTO = depart.queryAllInfoChildByNo();
		String[] value = new String[departDTO.size()];
		for (int i = 0; i < departDTO.size(); i++) {
			value[i] = departDTO.get(i).getDepartName();
		}

		comboBox.setModel(new DefaultComboBoxModel(value));
		comboBox.setFont(new Font("宋体", Font.PLAIN, 16));
		comboBox.setForeground(Color.GRAY);
		comboBox.setBounds(76, 32, 99, 23);
		frame.getContentPane().add(comboBox);

		JLabel label = new JLabel("\u90E8\u95E8\u7F16\u53F7\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(221, 30, 80, 27);
		frame.getContentPane().add(label);

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 16));
		textField.setBounds(296, 31, 119, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// 定义服务层对象
				Department department = new Department();
				// 定义数据接受对象，数组
				List<DepartDTO> allDepartInfo = new ArrayList<DepartDTO>();
				// 定义数据传输对象
				DepartDTO departmentInfo = new DepartDTO();
				departmentInfo.setDepartName((String) comboBox.getSelectedItem());
				departmentInfo.setDepartNumber(textField.getText());
				if (textField.getText().equals("")) {
					allDepartInfo = department.queryDepartByClass(departmentInfo);
				}

				else {
					allDepartInfo = department.queryDepartInfo(departmentInfo);
				}
				if (allDepartInfo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "数据库查询结果为空");
				}
				int j = table.getRowCount();
				for (int i = 0; i < j; i++) {
					((DefaultTableModel) table.getModel()).removeRow(0);
				}
				for (int i = 0; i < allDepartInfo.size(); i++) {
					Vector vector = new Vector();
					vector.addElement(allDepartInfo.get(i).getDepartId());
					vector.addElement(allDepartInfo.get(i).getDepartName());
					vector.addElement(allDepartInfo.get(i).getDepartNumber());
					vector.addElement(allDepartInfo.get(i).getDepartTelephone());
					vector.addElement(allDepartInfo.get(i).getDepartRemark());
					((DefaultTableModel) table.getModel()).addRow(vector);
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.setBounds(507, 30, 93, 27);
		frame.getContentPane().add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 75, 185, 334);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

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
				String high = tree.getSelectionModel().getLeadSelectionPath().getPathComponent(1).toString();
				String depart = tree.getSelectionModel().getLeadSelectionPath().getLastPathComponent().toString();
				// 定义服务层
				Department departTree = new Department();
				// 定义传输层
				// 定义传入层
				DepartDTO departDTO = new DepartDTO();
				List<DepartDTO> departTreeDTO = new ArrayList<DepartDTO>();
				if (high.equals(depart)) {
					departTreeDTO = departTree.queryDepartByName(high);
				} else {
					departDTO.setDepartName(depart);
					departDTO.setHighDepartName(high);
					departTreeDTO = departTree.queryDepartByTwoName(departDTO);
				}
				int j = table.getRowCount();
				for (int i = 0; i < j; i++) {
					((DefaultTableModel) table.getModel()).removeRow(0);
				}
				for (int i = 0; i < departTreeDTO.size(); i++) {
					Vector vector = new Vector();
					vector.addElement(departTreeDTO.get(i).getDepartId());
					vector.addElement(departTreeDTO.get(i).getDepartName());
					vector.addElement(departTreeDTO.get(i).getDepartNumber());
					vector.addElement(departTreeDTO.get(i).getDepartTelephone());
					vector.addElement(departTreeDTO.get(i).getDepartRemark());
					((DefaultTableModel) table.getModel()).addRow(vector);
				}
				System.out.print(tree.getSelectionModel().getLeadSelectionPath().getPathComponent(1).toString());
				System.out.println(tree.getSelectionModel().getLeadSelectionPath().getLastPathComponent().toString());

			}
		});
		panel.add(tree);

		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tree.getSelectionModel().getLeadSelectionPath() == null) {
					JOptionPane.showMessageDialog(null, "请选择左侧上级部门");
				} else {
					AddTrainDepartform addTrainDepartFrom = new AddTrainDepartform(
							tree.getSelectionModel().getLeadSelectionPath().getLastPathComponent().toString());
					addTrainDepartFrom.main(null);
				}

			}
		});
		btnNewButton_1.setBounds(205, 75, 80, 27);
		frame.getContentPane().add(btnNewButton_1);

		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int departId = (int) table.getValueAt(table.getSelectedRow(), 0);
				// 定义服务层对象
				Department department = new Department();
				// 定义传输层对象
				DepartDTO departDTO = new DepartDTO();
				departDTO = department.queryAllDepartInfo(departId);
				UpdateDepartForm updateDepartForm = new UpdateDepartForm(departDTO, departId);
				updateDepartForm.main(null);

			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.setBounds(306, 75, 80, 27);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int res = JOptionPane.showConfirmDialog(null, "是否确定删除", "是否", JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION) {
					// TODO Auto-generated method stub
					// 定义服务层对象
					Department department = new Department();
					// 获得id删除id
					int departId = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
					boolean deleteSuccessful = false;
					deleteSuccessful = department.deleteDepartInfo(departId);
					if (deleteSuccessful) {
						JOptionPane.showMessageDialog(null, "删除成功");
						((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());
					} else {
						JOptionPane.showMessageDialog(null, "删除失败");
					}
				}

			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 16));
		button_1.setBounds(411, 75, 80, 27);
		frame.getContentPane().add(button_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(186, 134, 455, 275);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 455, 275);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u5E8F\u53F7",
				"\u90E8\u95E8\u540D\u79F0", "\u90E8\u95E8\u7F16\u53F7", "\u8054\u7CFB\u65B9\u5F0F", "\u5907\u6CE8" }));
		// 查询所有部门信息展示
		// 定义服务层
		Department departmentShow = new Department();
		// 定义传输层
		List<DepartDTO> departShowDTO = new ArrayList<DepartDTO>();
		departShowDTO = departmentShow.queryAllInfoChildByNo();
		int j = table.getRowCount();
		for (int i = 0; i < j; i++) {
			((DefaultTableModel) table.getModel()).removeRow(0);
		}
		for (int i = 0; i < departShowDTO.size(); i++) {
			Vector vector = new Vector();
			vector.addElement(departShowDTO.get(i).getDepartId());
			vector.addElement(departShowDTO.get(i).getDepartName());
			vector.addElement(departShowDTO.get(i).getDepartNumber());
			vector.addElement(departShowDTO.get(i).getDepartTelephone());
			vector.addElement(departShowDTO.get(i).getDepartRemark());
			((DefaultTableModel) table.getModel()).addRow(vector);
		}
		scrollPane.setViewportView(table);
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
}
