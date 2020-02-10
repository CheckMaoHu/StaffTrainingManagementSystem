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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import utils.SetFrameLoaction;

public class updateTrainPlan {

	static JFrame frame;
	private JComboBox comboBox_2, comboBox_1, comboBox_3;
	private JTable table;
	private JXDatePicker datePickerStart, datePickerEnd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// updateTrainPlan window = new updateTrainPlan();

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
//	public updateTrainPlan() {
	// initialize();
	// }
	public updateTrainPlan(TrainPlanDTO trainPlanInfoDTO, List<TrainPlanDetailDTO> trainPlanDetailDTO, final int id) {
		initialize(trainPlanInfoDTO, trainPlanDetailDTO, id);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	private void initialize(TrainPlanDTO trainPlanInfoDTO, List<TrainPlanDetailDTO> trainPlanDetailDTO, final int id) {
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
		label.setFont(new Font("����", Font.PLAIN, 16));
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

		// ʱ��ת������
		SimpleDateFormat dateToString = new SimpleDateFormat("yyyy-MM-dd");

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(312, 0, 99, 40);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel label_2 = new JLabel("\u540D\u79F0");
		label_2.setFont(new Font("����", Font.PLAIN, 16));
		label_2.setBounds(31, 10, 40, 25);
		panel_3.add(label_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(312, 42, 99, 40);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JLabel label_3 = new JLabel("\u7ED3\u675F\u65F6\u95F4");
		label_3.setFont(new Font("����", Font.PLAIN, 16));
		label_3.setBounds(20, 10, 79, 25);
		panel_4.add(label_3);

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("����", Font.PLAIN, 16));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "2015", "2016", "2017", "2018" }));
		comboBox_1.setSelectedItem(trainPlanInfoDTO.getPlanYear());// ���������ʾ
		comboBox_1.setBounds(109, 0, 177, 40);
		panel.add(comboBox_1);

		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("����", Font.PLAIN, 16));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "\u65B0\u5458\u5DE5\u5165\u573A\u57F9\u8BAD",
				"\u4E2D\u5C42\u7BA1\u7406\u4EBA\u5458\u57F9\u8BAD", "\u73ED\u7EC4\u957F\u57F9\u8BAD" }));
		comboBox_2.setSelectedItem(trainPlanInfoDTO.getPlanName());// ��ѵ����ѡ���
		comboBox_2.setBounds(421, 0, 177, 40);
		panel.add(comboBox_2);

		datePickerStart = new JXDatePicker();
		datePickerStart.setBounds(108, 42, 178, 40);
		datePickerStart.setDate(trainPlanInfoDTO.getPlanStartTime());
		panel.add(datePickerStart);

		datePickerEnd = new JXDatePicker();
		datePickerEnd.setBounds(420, 42, 178, 40);
		datePickerEnd.setDate(trainPlanInfoDTO.getPlanEndTime());
		panel.add(datePickerEnd);

		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// ����ڱ༭״̬
				if (updateTrainPlanLegal()) {

					if (!table.isEditing()) {

						boolean updateSuccessful = false;
						// �����������
						TrainPlan updateTrainPlan = new TrainPlan();
						// ���崫������
						TrainPlanDTO trainPlanInfoDTO_1 = new TrainPlanDTO();
						TrainPlanDetailDTO trainPlanDetailDTO_1 = new TrainPlanDetailDTO();
						List<TrainPlanDetailDTO> allTrainDetail = new ArrayList<TrainPlanDetailDTO>();
						trainPlanInfoDTO_1.setPlanName((String) comboBox_2.getSelectedItem());
						trainPlanInfoDTO_1.setPlanYear((String) comboBox_1.getSelectedItem());
						SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
						try {
							trainPlanInfoDTO_1.setPlanStartTime(datePickerStart.getDate());
							trainPlanInfoDTO_1.setPlanEndTime(datePickerEnd.getDate());
							trainPlanInfoDTO_1.setPlanCreateTime(dateformat.parse(dateformat.format(new Date())));
						} catch (ParseException e) {
							e.printStackTrace();

						}
						trainPlanInfoDTO_1.setPlanPerformance("δ��ѵ");
						updateSuccessful = updateTrainPlan.updateTrainPlanById(trainPlanInfoDTO_1, id);
						if (updateSuccessful) {
							List<TrainPlanDetailDTO> detail_ID = new ArrayList<TrainPlanDetailDTO>();
							detail_ID = updateTrainPlan.queryTrainDetailInfo(id);

							int j = 0;
							for (int i = 0; i < table.getRowCount(); i++) {
								trainPlanDetailDTO_1.setDetailMajorName((String) table.getValueAt(i, 0));
								trainPlanDetailDTO_1.setPlanGoal((String) table.getValueAt(i, 1));
								trainPlanDetailDTO_1.setPlanConcent((String) table.getValueAt(i, 2));
								trainPlanDetailDTO_1.setPlanClassHour((String) table.getValueAt(i, 3));
								trainPlanDetailDTO_1.setPlanTeacher((String) table.getValueAt(i, 4));
								updateSuccessful = updateTrainPlan.updateTrainPlanDetail(trainPlanDetailDTO_1, id,
										detail_ID.get(i).getDetailId());
								j = i;
							}
							if (!updateSuccessful)
								JOptionPane.showMessageDialog(null, "�޸�ʧ��");
							if (updateSuccessful && j == table.getRowCount() - 1) {
								JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
							}

						} else
							JOptionPane.showMessageDialog(null, "����ʧ��");

					} else
						JOptionPane.showMessageDialog(null, "���˳��༭״̬");
				}
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 16));
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
		table.setFont(new Font("����", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u4E13\u4E1A",
				"\u57F9\u8BAD\u76EE\u7684", "\u57F9\u8BAD\u5185\u5BB9", "\u8BFE\u65F6", "\u6388\u8BFE\u4EBA" }));
		table.getColumnModel().getColumn(0).setMinWidth(25);
		scrollPane.setViewportView(table);
		String[] values = { "����", "����", "��¯", "��ˮ", "ȼ��" };
		table.setRowHeight(20);
		table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JComboBox(values)));
		table.getColumnModel().getColumn(0).setCellRenderer(new MyComboBoxRenderer(values));
		// ��ʼ�����
		for (int i = 0; i < trainPlanDetailDTO.size(); i++) {
			Vector vector = new Vector();
			vector.addElement(trainPlanDetailDTO.get(i).getDetailMajorName());
			vector.addElement(trainPlanDetailDTO.get(i).getPlanGoal());
			vector.addElement(trainPlanDetailDTO.get(i).getPlanConcent());
			vector.addElement(trainPlanDetailDTO.get(i).getPlanClassHour());
			vector.addElement(trainPlanDetailDTO.get(i).getPlanTeacher());
			((DefaultTableModel) table.getModel()).addRow(vector);
		}

		JButton btnNewButton_1 = new JButton("\u589E\u52A0");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				((DefaultTableModel) table.getModel()).addRow(new Vector());
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 16));
		btnNewButton_1.setBounds(426, 147, 93, 29);
		frame.getContentPane().add(btnNewButton_1);

		JButton button = new JButton("\u5220\u9664");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (!table.isEditing()) {
					// ѡ��
					if (table.getSelectedRowCount() == 1) {
						((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());
					}
				} else
					JOptionPane.showMessageDialog(null, "���˳��༭״̬");
			}
		});
		button.setFont(new Font("����", Font.PLAIN, 16));
		button.setBounds(551, 147, 93, 27);
		frame.getContentPane().add(button);
		frame.setBounds(100, 100, 658, 397);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
	}

	public boolean updateTrainPlanLegal() {
		boolean result = true;
		if (table.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "������Ӱ�ť�������ϸ�ƻ�");
			result = result && false;
		}
		if (table.isEditing()) {
			JOptionPane.showMessageDialog(null, "���˳��༭״̬");
			result = result && false;
		}

		for (int i = 0; i < table.getRowCount(); i++) {
			if ((table.getValueAt(i, 1) == null)) {
				table.setValueAt("��������ѵĿ��", i, 1);
				result = result && false;
			}
			if ((table.getValueAt(i, 2) == null)) {
				table.setValueAt("��������ѵ����", i, 2);
				result = result && false;
			}
			if ((table.getValueAt(i, 3) == null)) {
				table.setValueAt("��������ѵ��ʱ", i, 3);
				result = result && false;
			}
			if ((table.getValueAt(i, 4) == null)) {
				table.setValueAt("��������ѵ��ʦ", i, 4);

				result = result && false;
			}
		}
		for (int i = 0; i < table.getRowCount(); i++) {
			if ((table.getValueAt(i, 1).equals(""))) {
				table.setValueAt("��������ѵĿ��", i, 1);
				result = result && false;
			}
			if ((table.getValueAt(i, 2).equals(""))) {
				table.setValueAt("��������ѵ����", i, 2);
				result = result && false;
			}
			if ((table.getValueAt(i, 3).equals(""))) {
				table.setValueAt("��������ѵ��ʱ", i, 3);
				result = result && false;
			}
			if ((table.getValueAt(i, 4).equals(""))) {
				table.setValueAt("��������ѵ��ʦ", i, 4);

				result = result && false;
			}

		}
		for (int i = 0; i < table.getRowCount(); i++) {
			if ((table.getValueAt(i, 1).equals("��������ѵĿ��"))) {
				result = result && false;
			}
			if ((table.getValueAt(i, 2).equals("��������ѵ����"))) {
				result = result && false;
			}
			if ((table.getValueAt(i, 3).equals("��������ѵ��ʱ"))) {
				result = result && false;
			}
			if ((table.getValueAt(i, 4).equals("��������ѵ��ʦ"))) {

				result = result && false;
			}

		}
		return result;
	}
}
