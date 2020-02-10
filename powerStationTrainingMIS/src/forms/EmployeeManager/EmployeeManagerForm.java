package forms.EmployeeManager;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
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

import dto.DepartDTO;
import dto.employeeDTO;
import forms.TreeSimple;
import services.depart.Department;
import services.employee.employee;

public class EmployeeManagerForm {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JPanel panel;
	private JTree tree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeManagerForm window = new EmployeeManagerForm();
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
	public EmployeeManagerForm() {
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

		JLabel label = new JLabel("\u5458\u5DE5\u59D3\u540D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(39, 30, 80, 27);
		frame.getContentPane().add(label);

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 16));
		textField.setBounds(115, 30, 99, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// 定义服务层对象
				employee employerInfo = new employee();
				// 定义数据接受对象，数组
				List<employeeDTO> allEmployeeInfo = new ArrayList<employeeDTO>();
				// 定义数据传输对象
				employeeDTO employerDTO = new employeeDTO();
				employerDTO.setEmployeeName(textField.getText());
				employerDTO.setEmployeeSex(textField_1.getText());// 性别
				// allDepartInfo = department.queryDepartInfo(departmentInfo);
				if (textField.getText().equals("") == false) {
					allEmployeeInfo = employerInfo.queryAllEmployeeByName(employerDTO);
				}
				if (textField_1.getText().equals("") == false) {
					allEmployeeInfo = employerInfo.queryAllEmployeeByEmployeeNumber(employerDTO);
				}
				if ((textField.getText().equals("") == false) && (textField_1.getText().equals("") == false)) {
					allEmployeeInfo = employerInfo.queryAllEmployeeInfo(employerDTO);
				}
				if (allEmployeeInfo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "数据库查询结果为空");
				}
				// 部门dto查询结果，通过部门id
				DepartDTO departDTO = new DepartDTO();

				int j = table.getRowCount();
				for (int i = 0; i < j; i++) {
					((DefaultTableModel) table.getModel()).removeRow(0);
				}
				for (int i = 0; i < allEmployeeInfo.size(); i++) {
					Vector vector = new Vector();
					vector.addElement(allEmployeeInfo.get(i).getEmployeeId());
					vector.addElement(allEmployeeInfo.get(i).getEmployeeName());
					vector.addElement(allEmployeeInfo.get(i).getEmployeeNumber());
					vector.addElement(allEmployeeInfo.get(i).getEmployeeSex());
					vector.addElement(allEmployeeInfo.get(i).getEmployeeBirthday());
					departDTO = employerInfo.queryDepartName(allEmployeeInfo.get(i).getDepartNumber());
					vector.addElement(departDTO.getHighDepartName() + " " + departDTO.getDepartName());
					vector.addElement(allEmployeeInfo.get(i).getEmployeeDuty());
					((DefaultTableModel) table.getModel()).addRow(vector);
				}

			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.setBounds(538, 30, 93, 27);
		frame.getContentPane().add(btnNewButton);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 75, 185, 334);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		TreeSimple treeLode = new TreeSimple(panel);
		tree = treeLode.getTree();
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent arg0) {
				// 删除表
				// TODO Auto-generated method stub
				String high = tree.getSelectionModel().getLeadSelectionPath().getPathComponent(1).toString();
				String depart = tree.getSelectionModel().getLeadSelectionPath().getLastPathComponent().toString();
				// 定义服务层
				Department departTree = new Department();
				// 定义传输层
				// 定义传入层
				DepartDTO departDTO = new DepartDTO();

				List<DepartDTO> departTreeDTO = new ArrayList<DepartDTO>();
				// 表的数据再次查询一下，去核对
				// 定义员工服务层
				employee employerShow = new employee();
				// 定义员工接受层----------------
				List<employeeDTO> employerShowDTO = new ArrayList<employeeDTO>();
				employerShowDTO = employerShow.queryEmployeeInfoByNo();
				DepartDTO departShowDTO = new DepartDTO();

				// -------------------
				if (high.equals(depart)) {
					// 先删除表
					int jt = table.getRowCount();
					for (int i = 0; i < jt; i++) {
						((DefaultTableModel) table.getModel()).removeRow(0);
					}
					// 首先接受一个上级部门的名字查询number
					// 定义接受层数组
					List<DepartDTO> depaertCompareDTO = new ArrayList<DepartDTO>();
					depaertCompareDTO = departTree.queryDepartByName(high);
					for (int i = 0; i < employerShowDTO.size(); i++) {
						for (int j = 0; j < depaertCompareDTO.size(); j++) {
							if (employerShowDTO.get(i).getDepartNumber()
									.equals(depaertCompareDTO.get(j).getDepartNumber())) {
								Vector vector = new Vector();
								vector.addElement(employerShowDTO.get(i).getEmployeeId());
								System.out.println(employerShowDTO.get(i).getEmployeeId());
								vector.addElement(employerShowDTO.get(i).getEmployeeName());
								vector.addElement(employerShowDTO.get(i).getEmployeeNumber());
								vector.addElement(employerShowDTO.get(i).getEmployeeSex());
								vector.addElement(employerShowDTO.get(i).getEmployeeBirthday());
								departShowDTO = employerShow.queryDepartName(employerShowDTO.get(i).getDepartNumber());
								vector.addElement(
										departShowDTO.getHighDepartName() + " " + departShowDTO.getDepartName());
								vector.addElement(employerShowDTO.get(i).getEmployeeDuty());
								((DefaultTableModel) table.getModel()).addRow(vector);
							}
						}

					}

				} else {
					// 先删除表
					int jt = table.getRowCount();
					for (int i = 0; i < jt; i++) {
						((DefaultTableModel) table.getModel()).removeRow(0);
					}
					List<DepartDTO> depaertCompareDTO = new ArrayList<DepartDTO>();
					DepartDTO departShowDTO1 = new DepartDTO();
					departShowDTO1.setDepartName(depart);
					departShowDTO1.setHighDepartName(high);
					depaertCompareDTO = departTree.queryDepartByTwoName(departShowDTO1);
					for (int i = 0; i < employerShowDTO.size(); i++) {
						for (int j = 0; j < depaertCompareDTO.size(); j++) {
							if (employerShowDTO.get(i).getDepartNumber()
									.equals(depaertCompareDTO.get(j).getDepartNumber())) {
								Vector vector = new Vector();
								vector.addElement(employerShowDTO.get(i).getEmployeeId());
								vector.addElement(employerShowDTO.get(i).getEmployeeName());
								vector.addElement(employerShowDTO.get(i).getEmployeeNumber());
								vector.addElement(employerShowDTO.get(i).getEmployeeSex());
								vector.addElement(employerShowDTO.get(i).getEmployeeBirthday());
								departShowDTO = employerShow.queryDepartName(employerShowDTO.get(i).getDepartNumber());
								vector.addElement(
										departShowDTO.getHighDepartName() + " " + departShowDTO.getDepartName());
								vector.addElement(employerShowDTO.get(i).getEmployeeDuty());
								((DefaultTableModel) table.getModel()).addRow(vector);
							}
						}

					}

				}

			}
		});
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tree.getSelectionModel().getLeadSelectionPath() == null) {
					JOptionPane.showMessageDialog(null, "请选择左侧部门");
				} else {
					AddEmployeeInfo addEmployeeInfo = new AddEmployeeInfo(
							tree.getSelectionModel().getLeadSelectionPath().getLastPathComponent().toString());
					addEmployeeInfo.main(null);
				}

			}
		});
		btnNewButton_1.setBounds(205, 75, 80, 27);
		frame.getContentPane().add(btnNewButton_1);

		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int employeeId = (int) table.getValueAt(table.getSelectedRow(), 0);
				// 定义服务层对象
				employee employeeInfo = new employee();
				// 定义传输层对象
				employeeDTO employerDTO = new employeeDTO();
				employerDTO = employeeInfo.QueryEmployeeALLInfoById(employeeId);
				UpdateEmployeeInfoForm updateEmployeeINfoForm = new UpdateEmployeeInfoForm(employerDTO);
				updateEmployeeINfoForm.main(null);

			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.setBounds(306, 75, 80, 27);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int res = JOptionPane.showConfirmDialog(null, "确定删除", "是否", JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION) {
					// TODO Auto-generated method stub
					// 定义服务层对象
					employee employerInfo = new employee();
					// 获得id删除id
					int employeeId = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
					boolean deleteSuccessful = false;
					deleteSuccessful = employerInfo.deleteEmployeeInfo(employeeId);
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
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u5E8F\u53F7", "\u59D3\u540D", "\u5458\u5DE5\u7F16\u53F7", "\u6027\u522B",
						"\u51FA\u751F\u5E74\u6708", "\u90E8\u95E8", "\u5C97\u4F4D" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(54);
		table.getColumnModel().getColumn(3).setPreferredWidth(45);
		table.getColumnModel().getColumn(5).setPreferredWidth(115);
		// 定义员工服务层
		employee employerShow = new employee();
		// 定义员工接受层
		List<employeeDTO> employerShowDTO = new ArrayList<employeeDTO>();
		employerShowDTO = employerShow.queryEmployeeInfoByNo();
		DepartDTO departShowDTO = new DepartDTO();
		int j = table.getRowCount();
		for (int i = 0; i < j; i++) {
			((DefaultTableModel) table.getModel()).removeRow(0);
		}
		for (int i = 0; i < employerShowDTO.size(); i++) {
			Vector vector = new Vector();
			vector.addElement(employerShowDTO.get(i).getEmployeeId());
			vector.addElement(employerShowDTO.get(i).getEmployeeName());
			vector.addElement(employerShowDTO.get(i).getEmployeeNumber());
			vector.addElement(employerShowDTO.get(i).getEmployeeSex());
			vector.addElement(employerShowDTO.get(i).getEmployeeBirthday());
			departShowDTO = employerShow.queryDepartName(employerShowDTO.get(i).getDepartNumber());
			vector.addElement(departShowDTO.getHighDepartName() + " " + departShowDTO.getDepartName());
			vector.addElement(employerShowDTO.get(i).getEmployeeDuty());
			((DefaultTableModel) table.getModel()).addRow(vector);
		}
		scrollPane.setViewportView(table);

		JLabel label_6 = new JLabel("\u5458\u5DE5\u6027\u522B\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 16));
		label_6.setBounds(272, 30, 80, 27);
		frame.getContentPane().add(label_6);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(345, 30, 99, 27);
		frame.getContentPane().add(textField_1);
	}
}
