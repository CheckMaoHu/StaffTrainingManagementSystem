package forms.ScoreManager;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dto.TrainPlanDTO;
import dto.TrainPlanDetailDTO;
import dto.TrainPlanManagerDTO;
import services.TrainPeopleManager.TrainPeopleManager;
import services.user.TrainPlan;
import utils.MyButtonEditor;
import utils.MyButtonRender;

public class ScoreManagerForm {

	private JFrame frame;
	private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
	private JTable table;
	public List<TrainPlanDTO> allTrainPlans;
	private MyButtonEditor manager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreManagerForm window = new ScoreManagerForm();
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
	public ScoreManagerForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 714, 489);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(Color.GREEN);
		panel.setBounds(0, 51, 704, 104);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\u57F9\u8BAD\u8BA1\u5212\u5E74\u5EA6\uFF1A");
		lblNewLabel_1.setBounds(10, 35, 129, 21);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);

		JLabel label = new JLabel("\u57F9\u8BAD\u8BA1\u5212\u7C7B\u578B\uFF1A");
		label.setBounds(10, 73, 129, 21);
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);

		JLabel label_1 = new JLabel("\u57F9\u8BAD\u4E13\u4E1A\uFF1A");
		label_1.setBounds(322, 35, 90, 21);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		panel.add(label_1);
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 16));
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "2015", "2016", "2017", "2018" }));
		comboBox.setBounds(137, 31, 168, 33);
		panel.add(comboBox);

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "\u65B0\u5458\u5DE5\u5165\u573A\u57F9\u8BAD",
				"\u4E2D\u5C42\u7BA1\u7406\u4EBA\u5458\u57F9\u8BAD", "\u73ED\u7EC4\u957F\u57F9\u8BAD" }));
		comboBox_1.setFont(new Font("宋体", Font.PLAIN, 16));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(137, 66, 168, 33);
		panel.add(comboBox_1);

		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(
				new String[] { "\u7535\u6C14", "\u6C7D\u673A", "\u9505\u7089", "\u5316\u6C34", "\u71C3\u8FD0" }));
		comboBox_2.setFont(new Font("宋体", Font.PLAIN, 16));
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(410, 31, 168, 33);
		panel.add(comboBox_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(0, 152, 700, 300);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 10, 700, 287);
		panel_1.add(scrollPane);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				manager = new MyButtonEditor();
				manager.setAccpId(allTrainPlans.get(table.getSelectedRow()).getPlanId());
				System.out.println(allTrainPlans.get(table.getSelectedRow()).getPlanId());
				if (table.getValueAt(table.getSelectedRow(), 6).equals("查看成绩")) {
					manager.setFlag(4);
				} else {
					manager.setFlag(3);
				}
				table.getColumnModel().getColumn(6).setCellEditor(manager);
				table.getColumnModel().getColumn(6).setCellRenderer(new MyButtonRender());

			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u5E8F\u53F7", "\u5E74\u5EA6", "\u57F9\u8BAD\u8BA1\u5212\u540D\u79F0",
						"\u57F9\u8BAD\u4E13\u4E1A", "\u57F9\u8BAD\u65F6\u95F4", "\u5B8C\u6210\u60C5\u51B5",
						"\u64CD\u4F5C" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.setRowHeight(20);
		// 在此添加一个table展示
		TrainPlan trainPlan = new TrainPlan();
		// 接受查询结果
		allTrainPlans = new ArrayList<TrainPlanDTO>();
		// 定义传输对象
		int jt = table.getRowCount();
		for (int i = 0; i < jt; i++) {
			((DefaultTableModel) table.getModel()).removeRow(0);
		}
		allTrainPlans = trainPlan.queryAllTrainByNo();
		// 显示查询结果
		for (int i = 0; i < allTrainPlans.size(); i++) {
			Vector vector = new Vector();
			vector.addElement(allTrainPlans.get(i).getPlanId());
			vector.addElement(allTrainPlans.get(i).getPlanYear());
			vector.addElement(allTrainPlans.get(i).getPlanName());
			List<TrainPlanDetailDTO> allTrainPlanDetail = trainPlan
					.queryAllPlanDetail(allTrainPlans.get(i).getPlanId());
			String mjName = "";
			for (int k = 0; k < allTrainPlanDetail.size(); k++) {
				mjName = mjName + allTrainPlanDetail.get(k).getDetailMajorName() + " ";
			}
			vector.addElement(mjName);
			vector.addElement(allTrainPlans.get(i).getPlanStartTime() + "-" + allTrainPlans.get(i).getPlanEndTime());
			vector.addElement(allTrainPlans.get(i).getPlanPerformance());
			/*
			 * // 定义服务层 TrainPeopleManager trainPeople = new TrainPeopleManager(); // 定义接受层
			 * List<TrainPlanManagerDTO> trainPlanManagrDTO = new
			 * ArrayList<TrainPlanManagerDTO>(); trainPlanManagrDTO =
			 * trainPeople.queryPeopleByPlanId(allTrainPlans.get(i).getPlanId()); if
			 * (trainPlanManagrDTO.size() > 0) {
			 * vector.addElement(trainPlanManagrDTO.size()); } else {
			 * vector.addElement("未安排"); }
			 */
			// 定义服务层
			TrainPeopleManager trainScoreManager = new TrainPeopleManager();
			// 定义传输层
			List<TrainPlanManagerDTO> trainScoreDTO = new ArrayList<TrainPlanManagerDTO>();
			trainScoreDTO = trainScoreManager.queryPeopleByPlanId(allTrainPlans.get(i).getPlanId());
			if (trainScoreDTO.isEmpty()) {
				continue;
			} else {
				if (trainScoreDTO.get(0).getExamScore() != 0) {
					vector.addElement("查看成绩");
				} else {
					vector.addElement("录入成绩");
				}

			}
			((DefaultTableModel) table.getModel()).addRow(vector);
		}

		scrollPane.setViewportView(table);
		table.setRowSelectionAllowed(false);
		manager = new MyButtonEditor();
		table.getColumnModel().getColumn(6).setCellEditor(manager);
		table.getColumnModel().getColumn(6).setCellRenderer(new MyButtonRender());
		String[] values = { "电气", "汽机", "锅炉", "化水", "燃运" };
		table.setRowHeight(20);

		final JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(
				new String[] { "\u672A\u57F9\u8BAD", "\u5DF2\u57F9\u8BAD", "\u57F9\u8BAD\u4E2D" }));
		comboBox_3.setFont(new Font("宋体", Font.PLAIN, 16));
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(410, 66, 168, 33);
		panel.add(comboBox_3);
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// 定义服务层对象
				TrainPlan trainPlan = new TrainPlan();
				// 接受查询结果
				allTrainPlans = new ArrayList<TrainPlanDTO>();
				// 定义传输对象
				TrainPlanDTO trainPlanInfoDTO = new TrainPlanDTO();
				trainPlanInfoDTO.setPlanYear((String) comboBox.getSelectedItem());
				trainPlanInfoDTO.setPlanName((String) comboBox_1.getSelectedItem());
				trainPlanInfoDTO.setPlanPerformance((String) comboBox_3.getSelectedItem());
				String majorName = (String) comboBox_2.getSelectedItem();

				allTrainPlans = trainPlan.queryAll(trainPlanInfoDTO, majorName);
				if (allTrainPlans.isEmpty()) {
					JOptionPane.showMessageDialog(null, "数据库查询结果为空");
				}
				int j = table.getRowCount();
				for (int i = 0; i < j; i++) {
					((DefaultTableModel) table.getModel()).removeRow(0);
				}
				// 显示查询结果
				for (int i = 0; i < allTrainPlans.size(); i++) {
					Vector vector = new Vector();
					vector.addElement(allTrainPlans.get(i).getPlanId());
					vector.addElement(allTrainPlans.get(i).getPlanYear());
					vector.addElement(allTrainPlans.get(i).getPlanName());
					List<TrainPlanDetailDTO> allTrainPlanDetail = trainPlan
							.queryAllPlanDetail(allTrainPlans.get(i).getPlanId());
					String mjName = "";
					for (int k = 0; k < allTrainPlanDetail.size(); k++) {
						mjName = mjName + allTrainPlanDetail.get(k).getDetailMajorName() + " ";
					}
					vector.addElement(mjName);
					vector.addElement(
							allTrainPlans.get(i).getPlanStartTime() + "-" + allTrainPlans.get(i).getPlanEndTime());
					vector.addElement(allTrainPlans.get(i).getPlanPerformance());
					/*
					 * // 定义服务层 TrainPeopleManager trainPeople = new TrainPeopleManager(); // 定义接受层
					 * List<TrainPlanManagerDTO> trainPlanManagrDTO = new
					 * ArrayList<TrainPlanManagerDTO>(); trainPlanManagrDTO =
					 * trainPeople.queryPeopleByPlanId(allTrainPlans.get(i).getPlanId()); if
					 * (trainPlanManagrDTO.size() > 0) {
					 * vector.addElement(trainPlanManagrDTO.size()); } else {
					 * vector.addElement("未安排"); }
					 */
					// 定义服务层
					TrainPeopleManager trainScoreManager = new TrainPeopleManager();
					// 定义传输层
					List<TrainPlanManagerDTO> trainScoreDTO = new ArrayList<TrainPlanManagerDTO>();
					trainScoreDTO = trainScoreManager.queryPeopleByPlanId(allTrainPlans.get(i).getPlanId());
					if (trainScoreDTO.get(i).getExamScore() != 0) {
						vector.addElement("查看成绩");
					} else
						vector.addElement("录入成绩");
					((DefaultTableModel) table.getModel()).addRow(vector);
				}

			}
		});
		table.setRowSelectionAllowed(false);
		manager = new MyButtonEditor();
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.setBounds(601, 54, 93, 29);
		panel.add(button);

		JLabel label_2 = new JLabel("\u5B8C\u6210\u60C5\u51B5\uFF1A");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(322, 73, 90, 21);
		panel.add(label_2);

		JLabel label_3 = new JLabel("\u6210\u7EE9\u7BA1\u7406");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(207, 10, 260, 31);
		frame.getContentPane().add(label_3);
	}
}
