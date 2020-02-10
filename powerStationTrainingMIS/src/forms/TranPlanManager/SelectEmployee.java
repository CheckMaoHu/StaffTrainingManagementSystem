package forms.TranPlanManager;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import dto.DepartDTO;
import dto.TrainPlanManagerDTO;
import forms.TreeSimple;
import services.TrainPeopleManager.TrainPeopleManager;
import services.depart.Department;
import utils.MyTable;
import utils.SetFrameLoaction;

public class SelectEmployee {

	private static JFrame frame;
	private JTree tree;
	private Object getp[][];
	private int colm;
	private int row;
	private Object getp_2[][];
	private int colm_2;
	private int row_2;
	private MyTable mt2;
	private MyTable mt;
	private JScrollPane scrollPane;

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
	public SelectEmployee(int planId, int detailIdS) {
		initialize(planId, detailIdS);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	private void initialize(final int planId, final int detailIdS) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		mt = new MyTable(1, detailIdS);
		JTable t = new JTable(mt);
		getp = mt.getP();
		colm = mt.getColm();
		row = mt.getRow();
		JCheckBox jc1 = new JCheckBox();
		t.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(jc1));

		scrollPane = new JScrollPane(t);
		scrollPane.setBounds(185, 81, 356, 164);
		frame.getContentPane().add(scrollPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 50, 185, 334);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		TreeSimple treeLode = new TreeSimple(panel);
		tree = treeLode.getTree();
		// 这个节点动态存在问题
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent arg0) {
				// TODO Auto-generated method stub
				String high = tree.getSelectionModel().getLeadSelectionPath().getPathComponent(1).toString();
				String depart = tree.getSelectionModel().getLeadSelectionPath().getLastPathComponent().toString();
				Department departTree = new Department();
				// 定义传输层
				// 定义传入层
				DepartDTO departDTO = new DepartDTO();

				List<DepartDTO> departTreeDTO = new ArrayList<DepartDTO>();
				if (high.equals(depart)) {
					List<DepartDTO> depaertCompareDTO = new ArrayList<DepartDTO>();
					mt = new MyTable(1, detailIdS);
					depaertCompareDTO = departTree.queryDepartByName(high);
					mt.setDepaertCompareDTO(depaertCompareDTO);
					mt.setTreeFlag(3);
					JTable t = new JTable(mt);
					getp = mt.getP();
					colm = mt.getColm();
					row = mt.getRow();
					JCheckBox jc1 = new JCheckBox();
					t.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(jc1));
					scrollPane = new JScrollPane(t);

				} else {

				}

			}
		});

		JLabel lblNewLabel = new JLabel("\u90E8\u95E8\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(185, 50, 62, 30);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5B66\u5458\u5B89\u6392");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(142, 10, 226, 30);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(231, 50, 122, 30);
		frame.getContentPane().add(lblNewLabel_2);

		JButton button = new JButton("\u4FDD\u5B58");
		button.addActionListener(new ActionListener() {
			// 定义服务层
			// 定义传输层
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				boolean savaSuccessful = true;
				for (int i = 0; i < row; i++) {
					if ((boolean) getp[i][0]) {
						// 定义服务层
						TrainPeopleManager trainPeople = new TrainPeopleManager();
						// 定义传输层
						TrainPlanManagerDTO trainManagerDTO = new TrainPlanManagerDTO();
						trainManagerDTO.setDetailDepartId(detailIdS);
						trainManagerDTO.setTrainPlanId(planId);
						trainManagerDTO.setEmployeeId((int) getp[i][1]);

						if (trainPeople.saveTrainPeopleId(trainManagerDTO)) {
							savaSuccessful = savaSuccessful && true;

						} else {
							savaSuccessful = savaSuccessful && false;
						}
					}

				}
				if (savaSuccessful)
					JOptionPane.showMessageDialog(null, "保存成功");
				else
					JOptionPane.showMessageDialog(null, "保存失败");
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.setBounds(445, 248, 86, 30);
		frame.getContentPane().add(button);
		mt2 = new MyTable(2, detailIdS);
		JTable t2 = new JTable(mt2);
		JCheckBox jc2 = new JCheckBox();
		t2.getColumnModel().getColumn(0).setPreferredWidth(50);
		t2.getColumnModel().getColumn(1).setPreferredWidth(50);
		t2.getColumnModel().getColumn(2).setPreferredWidth(120);
		t2.getColumnModel().getColumn(3).setPreferredWidth(50);
		t2.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(jc2));

		JScrollPane scrollPane_1 = new JScrollPane(t2);
		scrollPane_1.setBounds(183, 282, 358, 102);
		frame.getContentPane().add(scrollPane_1);

		JLabel label = new JLabel("\u5DF2\u5B89\u6392\u4EBA\u5458");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(185, 257, 86, 15);
		frame.getContentPane().add(label);

		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				boolean deteleSuccessful = true;
				getp_2 = mt2.getP();
				colm_2 = mt2.getColm();
				row_2 = mt2.getRow();
				for (int i = 0; i < row_2; i++) {
					if ((boolean) getp_2[i][0]) {
						// 定义服务层
						TrainPeopleManager trainPeople = new TrainPeopleManager();
						// 定义传输层
						TrainPlanManagerDTO trainManagerDTO = new TrainPlanManagerDTO();
						trainManagerDTO.setDetailDepartId(detailIdS);
						trainManagerDTO.setTrainPlanId(planId);
						trainManagerDTO.setEmployeeId((int) getp_2[i][3]);

						if (trainPeople.deleteTrainPeopleId(trainManagerDTO)) {
							deteleSuccessful = deteleSuccessful && true;

						} else {
							deteleSuccessful = deteleSuccessful && false;

						}
					}

				}
				if (deteleSuccessful)
					JOptionPane.showMessageDialog(null, "删除成功");
				else
					JOptionPane.showMessageDialog(null, "删除失败");
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 16));
		button_1.setBounds(445, 385, 86, 30);
		frame.getContentPane().add(button_1);
		frame.setBounds(100, 100, 555, 473);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
