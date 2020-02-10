package forms.ScoreManager;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dto.DepartDTO;
import dto.TrainPlanDTO;
import dto.TrainPlanDetailDTO;
import dto.TrainPlanManagerDTO;
import dto.employeeDTO;
import services.TrainPeopleManager.TrainPeopleManager;
import services.depart.Department;
import services.employee.employee;
import services.user.TrainPlan;
import utils.SetFrameLoaction;

public class AddScoreForm {

	private static JFrame frame;
	private JTable table;
	private List<TrainPlanManagerDTO> trainPlanManagerDTO;

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
	public AddScoreForm(int planId) {
		initialize(planId);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	private void initialize(final int planId) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 558, 332);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 76, 544, 219);
		frame.getContentPane().add(panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 34, 544, 192);
		panel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u59D3\u540D", "\u90E8\u95E8", "\u4E13\u4E1A", "\u5458\u5DE5id",
						"\u51FA\u52E4\u6B21\u6570", "\u51FA\u52E4\u6210\u7EE9", "\u8003\u8BD5\u6210\u7EE9",
						"\u603B\u6210\u7EE9" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, true, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(58);
		table.getColumnModel().getColumn(1).setPreferredWidth(129);
		table.getColumnModel().getColumn(2).setPreferredWidth(56);
		table.getColumnModel().getColumn(3).setPreferredWidth(61);
		table.getColumnModel().getColumn(4).setPreferredWidth(56);
		table.getColumnModel().getColumn(5).setPreferredWidth(57);
		table.getColumnModel().getColumn(6).setPreferredWidth(56);
		table.getColumnModel().getColumn(7).setPreferredWidth(57);
		// table.setRowSelectionAllowed(false);
		// 定义服务层
		TrainPeopleManager trainPeopleManager = new TrainPeopleManager();
		// 定义传输层
		trainPlanManagerDTO = new ArrayList<TrainPlanManagerDTO>();
		trainPlanManagerDTO = trainPeopleManager.queryPeopleByPlanId(planId);
		int j = table.getRowCount();
		for (int i = 0; i < j; i++) {
			((DefaultTableModel) table.getModel()).removeRow(0);
		}
		for (int i = 0; i < trainPlanManagerDTO.size(); i++) {
			Vector vector = new Vector();
			employee employer2 = new employee();
			// 定义接受层
			employeeDTO employee2DTO = new employeeDTO();
			// 定义服务层
			Department depart = new Department();
			// 定义接受层
			DepartDTO departDTO = new DepartDTO();
			employee2DTO = employer2.QueryEmployeeALLInfoById(trainPlanManagerDTO.get(i).getEmployeeId());
			vector.addElement(employee2DTO.getEmployeeName());
			departDTO = depart.queryDepartNameByDepartNumber(employee2DTO.getDepartNumber());
			vector.addElement(departDTO.getHighDepartName() + " " + departDTO.getDepartName());
			// 查询专业用的服务层
			TrainPlan trainPlan = new TrainPlan();
			// 查询专业用的数据传输层
			TrainPlanDetailDTO trainPlanDetailDTO = new TrainPlanDetailDTO();
			// 查询得到专业的结果
			trainPlanDetailDTO = trainPlan.queryDetailBydetailId(trainPlanManagerDTO.get(i).getDetailDepartId());
			vector.addElement(trainPlanDetailDTO.getDetailMajorName());
			vector.addElement(trainPlanManagerDTO.get(i).getEmployeeId());
			((DefaultTableModel) table.getModel()).addRow(vector);
		}
		// 年度 名称 时间
		// 定义服务层
		TrainPlan trainPlan_1 = new TrainPlan();
		// 定义接受层
		TrainPlanDTO trainPlanDTO = new TrainPlanDTO();
		trainPlanDTO = trainPlan_1.queryTrainPlanInfoById(planId);

		scrollPane.setViewportView(table);

		JButton button = new JButton("\u4FDD\u5B58");
		button.addActionListener(new ActionListener() {
			// 定义接受层
			TrainPlanManagerDTO trainPeopleScoreDTO = new TrainPlanManagerDTO();
			// 定义服务层
			TrainPeopleManager trainPeopleScore = new TrainPeopleManager();

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				boolean savaSuccessful = true;
				for (int i = 0; i < trainPlanManagerDTO.size(); i++) {
					trainPeopleScoreDTO.setEmployeeId(trainPlanManagerDTO.get(i).getEmployeeId());
					trainPeopleScoreDTO.setPlan_manager_id(trainPlanManagerDTO.get(i).getPlan_manager_id());
					trainPeopleScoreDTO.setDetailDepartId(trainPlanManagerDTO.get(i).getDetailDepartId());
					trainPeopleScoreDTO.setTrainPlanId(trainPlanManagerDTO.get(i).getTrainPlanId());
					trainPeopleScoreDTO.setTrainTurnOut(Integer.parseInt((String) table.getValueAt(i, 4)));
					trainPeopleScoreDTO.setTurnOutScore(Integer.parseInt((String) table.getValueAt(i, 5)));
					trainPeopleScoreDTO.setExamScore(Integer.parseInt((String) table.getValueAt(i, 6)));
					trainPeopleScoreDTO.setTotalScore(Integer.parseInt((String) table.getValueAt(i, 5))
							+ Integer.parseInt((String) table.getValueAt(i, 6)));

					if (trainPeopleScore.savaTrainScoreByTwoId(trainPeopleScoreDTO)) {
						savaSuccessful = savaSuccessful && true;
					} else
						savaSuccessful = savaSuccessful && false;
				}
				if (savaSuccessful) {
					JOptionPane.showMessageDialog(null, "保存成功");
					// 定义计划服务层
					TrainPlan trainPlanP = new TrainPlan();
					// 定义传输层
					TrainPlanDTO trainPlanPerDTO = new TrainPlanDTO();
					trainPlanPerDTO.setPlanPerformance("已培训");
					trainPlanPerDTO.setPlanId(planId);
					trainPlanP.updateTrainPlanPerformance(trainPlanPerDTO);
				} else
					JOptionPane.showMessageDialog(null, "保存失败");
			}
		});
		button.setBounds(378, 10, 75, 23);
		panel.add(button);

		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.setBounds(469, 10, 75, 23);
		panel.add(button_1);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 41, 66, 34);
		frame.getContentPane().add(panel_1);

		JLabel label = new JLabel("\u5E74\u5EA6");
		label.setBounds(10, 10, 46, 15);
		panel_1.add(label);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(65, 41, 89, 34);
		frame.getContentPane().add(panel_2);

		JLabel label_1 = new JLabel(trainPlanDTO.getPlanYear());
		label_1.setBounds(0, 0, 89, 34);
		panel_2.add(label_1);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(151, 41, 66, 34);
		frame.getContentPane().add(panel_3);

		JLabel label_2 = new JLabel("\u540D\u79F0");
		label_2.setBounds(10, 10, 46, 15);
		panel_3.add(label_2);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(214, 41, 118, 34);
		frame.getContentPane().add(panel_4);

		JLabel label_3 = new JLabel(trainPlanDTO.getPlanName());
		label_3.setBounds(0, 0, 118, 34);
		panel_4.add(label_3);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(331, 41, 66, 34);
		frame.getContentPane().add(panel_5);

		JLabel label_4 = new JLabel("\u65F6\u95F4");
		label_4.setBounds(20, 10, 46, 14);
		panel_5.add(label_4);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(397, 41, 152, 34);
		frame.getContentPane().add(panel_6);
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

		JLabel label_5 = new JLabel(dateformat.format(trainPlanDTO.getPlanStartTime()) + "-"
				+ dateformat.format(trainPlanDTO.getPlanEndTime()));
		label_5.setBounds(10, 0, 132, 34);
		panel_6.add(label_5);

		JLabel label_6 = new JLabel("\u5206\u6570\u6DFB\u52A0");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("宋体", Font.PLAIN, 20));
		label_6.setBounds(144, 0, 253, 40);
		frame.getContentPane().add(label_6);
	}

}
