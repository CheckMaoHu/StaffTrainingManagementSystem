package forms.TranPlanManager;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.JXDatePicker;

import dto.TrainPlanDTO;
import dto.TrainPlanDetailDTO;
import services.user.TrainPlan;
import utils.MyComboBoxRenderer;

public class AddTrainPlanForm {

	JFrame frame;
	private JComboBox comboBox_2, comboBox_1, comboBox_3;
	private JTable table;
	private JXDatePicker datePickerStart;
	private JXDatePicker datePickerEnd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTrainPlanForm window = new AddTrainPlanForm();
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
	public AddTrainPlanForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 49, 644, 82);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 0, 99, 40);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel label = new JLabel("\u5E74\u5EA6");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(30, 10, 40, 25);
		panel_1.add(label);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 42, 99, 40);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel label_1 = new JLabel("\u5F00\u59CB\u65F6\u95F4");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_1.setBounds(20, 10, 79, 25);
		panel_2.add(label_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(312, 0, 99, 40);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel label_2 = new JLabel("\u540D\u79F0");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(31, 10, 40, 25);
		panel_3.add(label_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(312, 42, 99, 40);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JLabel label_3 = new JLabel("\u7ED3\u675F\u65F6\u95F4");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(20, 10, 79, 25);
		panel_4.add(label_3);

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("宋体", Font.PLAIN, 16));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "2015", "2016", "2017", "2018" }));
		comboBox_1.setBounds(109, 0, 177, 40);
		panel.add(comboBox_1);

		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("宋体", Font.PLAIN, 16));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "\u65B0\u5458\u5DE5\u5165\u573A\u57F9\u8BAD",
				"\u4E2D\u5C42\u7BA1\u7406\u4EBA\u5458\u57F9\u8BAD", "\u73ED\u7EC4\u957F\u57F9\u8BAD" }));
		comboBox_2.setBounds(421, 0, 177, 40);
		panel.add(comboBox_2);

		datePickerStart = new JXDatePicker();
		datePickerStart.setBounds(109, 42, 178, 40);
		panel.add(datePickerStart);

		datePickerEnd = new JXDatePicker();
		datePickerEnd.setBounds(421, 42, 178, 40);
		panel.add(datePickerEnd);

		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (addTrainPlanLegal()) {

					int planId;// 接受保存后的计划ID
					boolean saveSuccessful;
					// 定义服务层对象
					TrainPlan trainPlan = new TrainPlan();
					// 定义基本数据传输对象并初始化
					TrainPlanDTO trainPlanInfoDTO = new TrainPlanDTO();
					trainPlanInfoDTO.setPlanName((String) comboBox_2.getSelectedItem());
					trainPlanInfoDTO.setPlanYear((String) comboBox_1.getSelectedItem());
					SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
					try {
						// trainPlanInfoDTO.setPlanStartTime(dateformat.parse(textField_1.getText()));
						trainPlanInfoDTO.setPlanStartTime(datePickerStart.getDate());
						trainPlanInfoDTO.setPlanEndTime(datePickerEnd.getDate());
						// trainPlanInfoDTO.setPlanEndTime(dateformat.parse(textField_3.getText()));
						trainPlanInfoDTO.setPlanCreateTime(dateformat.parse(dateformat.format(new Date())));
					} catch (ParseException e) {
						e.printStackTrace();

					}
					trainPlanInfoDTO.setPlanPerformance("未培训");
					saveSuccessful = trainPlan.saveTrainPlanInfo(trainPlanInfoDTO);
					if (saveSuccessful) {
						planId = trainPlan.queryId(trainPlanInfoDTO);
						if (planId != 0) {
							TrainPlanDetailDTO trainPlanDetailDTO = new TrainPlanDetailDTO();
							int j = 0;
							for (int i = 0; i < table.getRowCount(); i++) {
								trainPlanDetailDTO.setPlanId(planId);
								trainPlanDetailDTO.setDetailMajorName((String) table.getValueAt(i, 0));
								trainPlanDetailDTO.setPlanGoal((String) table.getValueAt(i, 1));
								trainPlanDetailDTO.setPlanConcent((String) table.getValueAt(i, 2));
								trainPlanDetailDTO.setPlanClassHour((String) table.getValueAt(i, 3));
								trainPlanDetailDTO.setPlanTeacher((String) table.getValueAt(i, 4));
								saveSuccessful = trainPlan.saveTrainPlanDetail(trainPlanDetailDTO);
								j = i;
							}
							if (!saveSuccessful)
								JOptionPane.showMessageDialog(null, "保存失败");
							if (saveSuccessful && j == table.getRowCount() - 1) {
								JOptionPane.showMessageDialog(null, "保存成功");
							}
						} else
							JOptionPane.showMessageDialog(null, "查询基本计划id失败");

					} else
						JOptionPane.showMessageDialog(null, "保存失败");
				}
			}

		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.setBounds(516, 10, 93, 29);
		frame.getContentPane().add(btnNewButton);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 184, 644, 176);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 644, 176);
		panel_5.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("宋体", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u4E13\u4E1A",
				"\u57F9\u8BAD\u76EE\u7684", "\u57F9\u8BAD\u5185\u5BB9", "\u8BFE\u65F6", "\u6388\u8BFE\u4EBA" }));
		table.getColumnModel().getColumn(0).setMinWidth(25);
		scrollPane.setViewportView(table);
		String[] values = { "电气", "汽机", "锅炉", "化水", "燃运" };
		table.setRowHeight(20);
		table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JComboBox(values)));
		table.getColumnModel().getColumn(0).setCellRenderer(new MyComboBoxRenderer(values));
		JButton btnNewButton_1 = new JButton("\u589E\u52A0");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				((DefaultTableModel) table.getModel()).addRow(new Vector());
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton_1.setBounds(426, 147, 93, 29);
		frame.getContentPane().add(btnNewButton_1);

		JButton button = new JButton("\u5220\u9664");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (!table.isEditing()) {
					// 选中
					if (table.getSelectedRowCount() == 1) {
						((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());
					}
				} else
					JOptionPane.showMessageDialog(null, "请退出编辑状态");
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.setBounds(551, 147, 93, 27);
		frame.getContentPane().add(button);
		frame.setBounds(100, 100, 658, 397);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
	}

	public boolean addTrainPlanLegal() {
		boolean result = true;
		if (table.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "点击增加按钮，添加详细计划");
			result = result && false;
		}
		if (table.isEditing()) {
			JOptionPane.showMessageDialog(null, "请退出编辑状态");
			result = result && false;
		}
		for (int i = 0; i < table.getRowCount(); i++) {
			if ((table.getValueAt(i, 1) == null)) {
				table.setValueAt("请输入培训目的", i, 1);
				result = result && false;
			}
			if ((table.getValueAt(i, 2) == null)) {
				table.setValueAt("请输入培训内容", i, 2);
				result = result && false;
			}
			if ((table.getValueAt(i, 3) == null)) {
				table.setValueAt("请输入培训课时", i, 3);
				result = result && false;
			}
			if ((table.getValueAt(i, 4) == null)) {
				table.setValueAt("请输入培训教师", i, 4);

				result = result && false;
			}
		}
		for (int i = 0; i < table.getRowCount(); i++) {
			if ((table.getValueAt(i, 1).equals(""))) {
				table.setValueAt("请输入培训目的", i, 1);
				result = result && false;
			}
			if ((table.getValueAt(i, 2).equals(""))) {
				table.setValueAt("请输入培训内容", i, 2);
				result = result && false;
			}
			if ((table.getValueAt(i, 3).equals(""))) {
				table.setValueAt("请输入培训课时", i, 3);
				result = result && false;
			}
			if ((table.getValueAt(i, 4).equals(""))) {
				table.setValueAt("请输入培训教师", i, 4);

				result = result && false;
			}

		}
		for (int i = 0; i < table.getRowCount(); i++) {
			if ((table.getValueAt(i, 1).equals("请输入培训目的"))) {
				result = result && false;
			}
			if ((table.getValueAt(i, 2).equals("请输入培训内容"))) {
				result = result && false;
			}
			if ((table.getValueAt(i, 3).equals("请输入培训课时"))) {
				result = result && false;
			}
			if ((table.getValueAt(i, 4).equals("请输入培训教师"))) {

				result = result && false;
			}

		}
		return result;
	}
}
