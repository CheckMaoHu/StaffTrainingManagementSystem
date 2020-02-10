package forms.EmployeeManager;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.jdesktop.swingx.JXDatePicker;

import dto.DepartDTO;
import dto.employeeDTO;
import forms.ComboxSimple;
import services.employee.employee;
import utils.SetFrameLoaction;

public class AddEmployeeInfo {

	private static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;
	private JLabel lblNewLabel, label_10, label_11;
	private JLabel label_12, label_13, label_14;
	private JLabel label_15, label_16, label_18;
	private JXDatePicker datePickerBirthday;
	private ButtonGroup sex;
	private JComboBox comboBox;
	private JTree tree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new SetFrameLoaction(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddEmployeeInfo(String highDepartNmuber) {
		initialize(highDepartNmuber);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	private void initialize(final String highDepartName) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 641, 506);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 56, 430, 361);
		panel.setBackground(Color.WHITE);
		panel.setBorder(null);
		panel.setForeground(Color.RED);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 100, 324);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 0, 100, 36);
		panel_6.setBorder(new LineBorder(Color.LIGHT_GRAY));
		FlowLayout flowLayout = (FlowLayout) panel_6.getLayout();
		flowLayout.setHgap(29);
		panel_3.add(panel_6);

		JLabel label = new JLabel("\u59D3\u540D");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(label);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(0, 36, 100, 36);
		FlowLayout flowLayout_1 = (FlowLayout) panel_7.getLayout();
		flowLayout_1.setHgap(29);
		panel_7.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_3.add(panel_7);

		JLabel label_1 = new JLabel("\u5DE5\u53F7");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_7.add(label_1);

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(-20, 72, 140, 36);
		FlowLayout flowLayout_2 = (FlowLayout) panel_8.getLayout();
		flowLayout_2.setHgap(29);
		panel_8.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_3.add(panel_8);

		JLabel label_2 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_8.add(label_2);

		JPanel panel_9 = new JPanel();
		panel_9.setBounds(-20, 108, 140, 36);
		FlowLayout flowLayout_3 = (FlowLayout) panel_9.getLayout();
		flowLayout_3.setHgap(29);
		panel_9.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_3.add(panel_9);

		JLabel label_3 = new JLabel("\u51FA\u751F\u5E74\u6708");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_9.add(label_3);

		JPanel panel_10 = new JPanel();
		panel_10.setBounds(0, 144, 100, 36);
		FlowLayout flowLayout_4 = (FlowLayout) panel_10.getLayout();
		flowLayout_4.setHgap(29);
		panel_10.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_3.add(panel_10);

		JLabel label_4 = new JLabel("\u7C4D\u8D2F");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_10.add(label_4);

		JPanel panel_11 = new JPanel();
		panel_11.setBounds(0, 180, 100, 36);
		FlowLayout flowLayout_5 = (FlowLayout) panel_11.getLayout();
		flowLayout_5.setHgap(29);
		panel_11.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_3.add(panel_11);

		JLabel label_5 = new JLabel("\u5C97\u4F4D");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_11.add(label_5);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 216, 100, 36);
		FlowLayout flowLayout_6 = (FlowLayout) panel_1.getLayout();
		flowLayout_6.setHgap(29);
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_3.add(panel_1);

		JLabel label_6 = new JLabel("\u804C\u79F0");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(label_6);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 252, 100, 36);
		FlowLayout flowLayout_7 = (FlowLayout) panel_2.getLayout();
		flowLayout_7.setHgap(29);
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_3.add(panel_2);

		JLabel label_7 = new JLabel("\u90E8\u95E8");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_2.add(label_7);

		JPanel panel_12 = new JPanel();
		panel_12.setBounds(0, 287, 100, 36);
		panel_12.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_3.add(panel_12);
		panel_12.setLayout(null);

		JLabel label_9 = new JLabel("\u8054\u7CFB\u7535\u8BDD");
		label_9.setBounds(10, 6, 80, 24);
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_12.add(label_9);

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBounds(321, 20, 0, 0);
		panel.add(verticalBox_1);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(99, 0, 304, 324);
		panel_4.setBackground(Color.WHITE);
		panel.add(panel_4);
		panel_4.setLayout(null);

		textField = new JTextField();
		textField.setBounds(0, 0, 266, 36);
		textField.setFont(new Font("宋体", Font.PLAIN, 16));
		panel_4.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(0, 36, 266, 36);
		textField_1.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_1.setColumns(10);
		panel_4.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setBounds(0, 72, 266, 36);
		textField_2.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_2.setColumns(10);
		panel_4.add(textField_2);

		textField_4 = new JTextField();
		textField_4.setBounds(0, 144, 266, 36);
		textField_4.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_4.setColumns(10);
		panel_4.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setBounds(0, 180, 266, 36);
		textField_5.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_5.setColumns(10);
		panel_4.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setBounds(0, 216, 266, 36);
		textField_6.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_6.setColumns(10);
		panel_4.add(textField_6);

		textField_8 = new JTextField();
		textField_8.setBounds(0, 288, 266, 36);
		textField_8.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_8.setColumns(10);
		panel_4.add(textField_8);

		comboBox = new JComboBox();
		comboBox.setBounds(0, 249, 266, 42);
		comboBox.setFont(new Font("宋体", Font.PLAIN, 16));
		ComboxSimple c = new ComboxSimple(comboBox, highDepartName);
		comboBox = c.getCombox();
		panel_4.add(comboBox);

		datePickerBirthday = new JXDatePicker();
		datePickerBirthday.setBounds(0, 106, 266, 40);
		panel_4.add(datePickerBirthday);

		final JCheckBox chckbxNewCheckBox = new JCheckBox("\u7537");
		chckbxNewCheckBox.setFont(new Font("宋体", Font.PLAIN, 16));
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setBounds(120, 324, 54, 37);
		panel.add(chckbxNewCheckBox);

		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_13.setBounds(0, 324, 100, 37);
		panel.add(panel_13);

		JLabel label_17 = new JLabel("\u6027\u522B");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setFont(new Font("宋体", Font.PLAIN, 20));
		label_17.setBounds(10, 6, 80, 24);
		panel_13.add(label_17);

		JCheckBox checkBox = new JCheckBox("\u5973");
		checkBox.setFont(new Font("宋体", Font.PLAIN, 16));
		checkBox.setBackground(Color.WHITE);
		checkBox.setBounds(185, 324, 54, 37);
		panel.add(checkBox);

		sex = new ButtonGroup();
		sex.add(chckbxNewCheckBox);
		sex.add(checkBox);
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.setBounds(351, 427, 93, 32);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// 定义服务层对象
				// 界面初始验证
				if (AddEmployeeLegal()) {
					clearWarn();
					employee employerInfo = new employee();
					// 定义传输层对象 员工
					employeeDTO employerDTO = new employeeDTO();
					// 定义接受层对象 部门
					DepartDTO departDTO = new DepartDTO();
					// 定义部门编号
					departDTO = employerInfo.QueryDepartNumber(highDepartName, (String) comboBox.getSelectedItem());
					if (departDTO == null) {
						JOptionPane.showMessageDialog(null, "添加的部门系统没有");
					} else {

						String departNumber = employerInfo
								.QueryDepartNumber(highDepartName, (String) comboBox.getSelectedItem())
								.getDepartNumber();
						employerDTO.setDepartNumber(departNumber);
						employerDTO.setEmployeeName(textField.getText());
						employerDTO.setEmployeeNumber(textField_1.getText());
						employerDTO.setEmployeeCardId(textField_2.getText());
						employerDTO.setEmployeeSex(sex.getSelection() == chckbxNewCheckBox.getModel() ? "男" : "女");
						// SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
						employerDTO.setEmployeeBirthday(datePickerBirthday.getDate());

						employerDTO.setEmployeeNativePlace(textField_4.getText());
						employerDTO.setEmployeeDuty(textField_5.getText());
						employerDTO.setEmployeePost(textField_5.getText());
						employerDTO.setEmployeeTelephone(textField_8.getText());
						boolean savaFlag = true;
						if (employerInfo.queryEmployeeNumberIsExist(textField_1.getText()) != null) {
							if (textField_1.getText().equals(employerInfo
									.queryEmployeeNumberIsExist(textField_1.getText()).getEmployeeNumber())) {
								JOptionPane.showMessageDialog(null, "该工号已经使用过了");
								savaFlag = savaFlag && false;
							}
						}
						if (employerInfo.queryCardIdIsExist(textField_2.getText()) != null) {
							if (textField_2.getText().equals(
									employerInfo.queryCardIdIsExist(textField_2.getText()).getEmployeeCardId())) {
								JOptionPane.showMessageDialog(null, "该身份证号已经使用过了");
								savaFlag = savaFlag && false;
							}
						}
						if (savaFlag) {
							boolean savaSuccessful = false;
							savaSuccessful = employerInfo.insertEmployeeInfo(employerDTO);
							if (savaSuccessful) {
								JOptionPane.showMessageDialog(null, "保存成功");
							} else {
								JOptionPane.showMessageDialog(null, "保存失败");
							}
						}

					}
				}

			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 25));
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(499, 427, 93, 32);
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 25));
		frame.getContentPane().add(btnNewButton_1);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 627, 56);
		panel_5.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);

		JLabel label_8 = new JLabel("\u6DFB\u52A0\u5458\u5DE5\u4FE1\u606F");
		label_8.setBounds(223, 5, 180, 35);
		label_8.setForeground(Color.BLUE);
		label_8.setFont(new Font("宋体", Font.PLAIN, 30));
		panel_5.add(label_8);

		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(430, 56, 139, 38);
		frame.getContentPane().add(lblNewLabel);

		label_10 = new JLabel("");
		label_10.setForeground(Color.RED);
		label_10.setHorizontalAlignment(SwingConstants.LEFT);
		label_10.setBounds(430, 93, 139, 38);
		frame.getContentPane().add(label_10);

		label_11 = new JLabel("");
		label_11.setForeground(Color.RED);
		label_11.setHorizontalAlignment(SwingConstants.LEFT);
		label_11.setBounds(430, 131, 139, 32);
		frame.getContentPane().add(label_11);

		label_12 = new JLabel("");
		label_12.setForeground(Color.RED);
		label_12.setHorizontalAlignment(SwingConstants.LEFT);
		label_12.setBounds(430, 162, 139, 38);
		frame.getContentPane().add(label_12);

		label_13 = new JLabel("");
		label_13.setForeground(Color.RED);
		label_13.setHorizontalAlignment(SwingConstants.LEFT);
		label_13.setBounds(430, 199, 139, 38);
		frame.getContentPane().add(label_13);

		label_14 = new JLabel("");
		label_14.setForeground(Color.RED);
		label_14.setHorizontalAlignment(SwingConstants.LEFT);
		label_14.setBounds(430, 237, 139, 38);
		frame.getContentPane().add(label_14);

		label_15 = new JLabel("");
		label_15.setForeground(Color.RED);
		label_15.setHorizontalAlignment(SwingConstants.LEFT);
		label_15.setBounds(430, 274, 139, 38);
		frame.getContentPane().add(label_15);

		label_16 = new JLabel("");
		label_16.setHorizontalAlignment(SwingConstants.LEFT);
		label_16.setForeground(Color.RED);
		label_16.setBounds(430, 342, 139, 38);
		frame.getContentPane().add(label_16);

		label_18 = new JLabel("");
		label_18.setHorizontalAlignment(SwingConstants.LEFT);
		label_18.setForeground(Color.RED);
		label_18.setBounds(430, 379, 139, 38);
		frame.getContentPane().add(label_18);
	}

	public boolean AddEmployeeLegal() {
		clearWarn();
		boolean result = true;
		GregorianCalendar britherDay = new GregorianCalendar();

		if (textField.getText().isEmpty()) {

			lblNewLabel.setText("请输入姓名");
			result = result && false;
		}
		if (textField_1.getText().isEmpty()) {

			label_10.setText("请输入工号");
			result = result && false;
		}
		if (textField_2.getText().isEmpty()) {

			label_11.setText("请输入身份证号");
			result = result && false;
		} else {
			if (textField_2.getText().length() != 18) {
				label_11.setText("");
				label_11.setText("请输入正确的身份证号");
				result = result && false;
			}
		}

		/*
		 * if (textField_3.getText().isEmpty()) {
		 * 
		 * label_12.setText("请输入出生年月"); result = result && false; }
		 */
		if (datePickerBirthday.getDate() == null) {
			label_12.setText("请输入出生年月");
			result = result && false;
		} else {
			britherDay.setTime(datePickerBirthday.getDate());
			britherDay.add(1, 1);
			Calendar calender = Calendar.getInstance();
			SimpleDateFormat nowTime = new SimpleDateFormat("yyyy-MM-dd");
			nowTime.format(calender.getTime());
			if (britherDay.getTime().after(calender.getTime())) {
				label_12.setText("未满18岁，禁止");
				result = result && false;
			}
		}
		if (textField_4.getText().isEmpty()) {

			label_13.setText("请输入籍贯");
			result = result && false;
		}
		if (textField_5.getText().isEmpty()) {

			label_14.setText("请输入岗位");
			result = result && false;
		}
		if (textField_6.getText().isEmpty()) {

			label_15.setText("请输入职称");
			result = result && false;
		}
		if (textField_8.getText().isEmpty()) {

			label_16.setText("请输入联系电话");
			result = result && false;
		}
		if (sex.getSelection() == null) {
			label_18.setText("请选择性别");
			result = result && false;
		}
		return result;
	}

	void clearWarn() {

		lblNewLabel.setText("");

		label_10.setText("");

		label_11.setText("");

		label_12.setText("");

		label_13.setText("");

		label_14.setText("");

		label_15.setText("");

		label_16.setText("");

		label_18.setText("");

	}
}
