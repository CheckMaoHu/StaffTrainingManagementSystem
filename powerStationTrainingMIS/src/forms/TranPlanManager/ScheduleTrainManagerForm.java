package forms.TranPlanManager;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dto.TrainPlanDTO;
import dto.TrainPlanDetailDTO;
import dto.TrainPlanManagerDTO;
import services.TrainPeopleManager.TrainPeopleManager;
import services.user.TrainPlan;
import utils.MyButtonEditor;
import utils.MyButtonRender;
import utils.SetFrameLoaction;

public class ScheduleTrainManagerForm {

	private static JFrame frame;
	private JTable table;
	private List<TrainPlanDetailDTO> planDetailDTO;
	private MyButtonEditor manager;

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
	public ScheduleTrainManagerForm(int accpId) {
		initialize(accpId);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	private void initialize(final int accpId) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 97, 549, 248);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 549, 248);
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				manager.setFlag(2);
				manager.setAccpId(accpId);
				manager.setDetailId(planDetailDTO.get(table.getSelectedRow()).getDetailId());
				System.out.println(planDetailDTO.get(table.getSelectedRow()).getDetailId());
			}
		});

		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "\u4E13\u4E1A", "\u57F9\u8BAD\u76EE\u7684",
						"\u57F9\u8BAD\u5185\u5BB9", "\u8BFE\u65F6", "\u6388\u8BFE\u4EBA", "\u64CD\u4F5C" }));
		table.getColumnModel().getColumn(1).setPreferredWidth(104);
		table.getColumnModel().getColumn(2).setPreferredWidth(106);
		table.getColumnModel().getColumn(3).setPreferredWidth(48);
		// 定义服务层
		TrainPeopleManager peopleManager = new TrainPeopleManager();
		// 定义接受层
		TrainPlanManagerDTO managerDTO = new TrainPlanManagerDTO();
		// 定义接受详细表数据
		planDetailDTO = new ArrayList<TrainPlanDetailDTO>();
		planDetailDTO = peopleManager.queryDetailByPlanId(accpId);
		for (int i = 0; i < planDetailDTO.size(); i++) {
			Vector vector = new Vector();
			vector.addElement(planDetailDTO.get(i).getDetailMajorName());
			vector.addElement(planDetailDTO.get(i).getPlanGoal());
			vector.addElement(planDetailDTO.get(i).getPlanConcent());
			vector.addElement(planDetailDTO.get(i).getPlanClassHour());
			vector.addElement(planDetailDTO.get(i).getPlanTeacher());
			// 定义服务层
			TrainPeopleManager trainPeople = new TrainPeopleManager();
			// 定义接受层
			List<TrainPlanManagerDTO> trainPlanManagrDTO = new ArrayList<TrainPlanManagerDTO>();
			trainPlanManagrDTO = trainPeople.queryTrainPeopleBydetail(planDetailDTO.get(i).getDetailId());
			if (trainPlanManagrDTO.size() > 0) {
				vector.addElement(trainPlanManagrDTO.size());
			} else {
				vector.addElement("未安排");
			}
			((DefaultTableModel) table.getModel()).addRow(vector);
		}
		table.setRowSelectionAllowed(false);
		manager = new MyButtonEditor();
		table.getColumnModel().getColumn(5).setCellEditor(manager);
		table.getColumnModel().getColumn(5).setCellRenderer(new MyButtonRender());

		scrollPane.setViewportView(table);
		// 定义服务层
		TrainPlan trainPlan = new TrainPlan();
		// 定义接受层
		TrainPlanDTO trainPlanDTO = new TrainPlanDTO();
		trainPlanDTO = trainPlan.queryTrainPlanInfoById(accpId);
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 63, 66, 34);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel label = new JLabel("\u5E74\u5EA6");
		label.setBounds(10, 10, 46, 15);
		panel_1.add(label);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(65, 63, 89, 34);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel(trainPlanDTO.getPlanYear());
		lblNewLabel.setBounds(0, 0, 89, 34);
		panel_2.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setLayout(null);
		panel_3.setBounds(151, 63, 66, 34);
		frame.getContentPane().add(panel_3);

		JLabel label_1 = new JLabel("\u540D\u79F0");
		label_1.setBounds(10, 10, 46, 15);
		panel_3.add(label_1);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(214, 63, 118, 34);
		frame.getContentPane().add(panel_4);

		JLabel label_2 = new JLabel(trainPlanDTO.getPlanName());
		label_2.setBounds(0, 0, 118, 34);
		panel_4.add(label_2);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setLayout(null);
		panel_5.setBounds(331, 63, 66, 34);
		frame.getContentPane().add(panel_5);

		JLabel label_3 = new JLabel("\u65F6\u95F4");
		label_3.setBounds(20, 10, 46, 14);
		panel_5.add(label_3);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setLayout(null);
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(397, 63, 152, 34);
		frame.getContentPane().add(panel_6);

		SimpleDateFormat datrToString = new SimpleDateFormat("yyyy-MM-dd");
		JLabel label_4 = new JLabel(datrToString.format(trainPlanDTO.getPlanStartTime()) + "-"
				+ datrToString.format(trainPlanDTO.getPlanEndTime()));
		label_4.setBounds(10, 0, 132, 34);
		panel_6.add(label_4);

		JLabel label_5 = new JLabel(" \u5B89\u6392\u5B66\u5458");
		label_5.setFont(new Font("宋体", Font.PLAIN, 20));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(129, 10, 268, 41);
		frame.getContentPane().add(label_5);
		frame.setBounds(100, 100, 563, 382);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
