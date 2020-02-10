package forms.TrainDepart;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dto.DepartDTO;
import services.depart.Department;
import utils.SetFrameLoaction;

public class UpdateDepartForm {

	private static JFrame frame;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_2, label_6;

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

	public UpdateDepartForm(DepartDTO departDTO, int id) {
		initialize(departDTO, id);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	private void initialize(DepartDTO departDTO, final int id) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 547, 394);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("\u4FEE\u6539\u90E8\u95E8\u4FE1\u606F");
		label.setBounds(120, 10, 250, 38);
		label.setForeground(Color.BLUE);
		label.setFont(new Font("����", Font.PLAIN, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(label);

		JPanel panel = new JPanel();
		panel.setBounds(0, 64, 100, 43);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u4E0A\u7EA7\u90E8\u95E8");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 10, 79, 23);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(99, 64, 339, 43);
		panel_1.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		final JLabel lblNewLabel_1 = new JLabel(departDTO.getHighDepartName());
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 16));

		lblNewLabel_1.setBounds(41, 10, 247, 23);
		panel_1.add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 107, 100, 43);
		panel_2.setLayout(null);
		frame.getContentPane().add(panel_2);

		JLabel label_1 = new JLabel("\u4E0A\u7EA7\u90E8\u95E8\u7F16\u53F7");
		label_1.setFont(new Font("����", Font.PLAIN, 16));
		label_1.setBounds(0, 10, 100, 23);
		panel_2.add(label_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(99, 107, 339, 43);
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_3);

		final JLabel label_5 = new JLabel(departDTO.getDepartNumber());
		label_5.setForeground(Color.BLUE);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("����", Font.PLAIN, 16));
		label_5.setText(departDTO.getHighDepartNumber());
		label_5.setBounds(40, 10, 247, 23);
		panel_3.add(label_5);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 149, 100, 43);
		panel_4.setLayout(null);
		frame.getContentPane().add(panel_4);

		JLabel label_2 = new JLabel("\u90E8\u95E8\u540D\u79F0");
		label_2.setFont(new Font("����", Font.PLAIN, 16));
		label_2.setBounds(10, 10, 79, 23);
		panel_4.add(label_2);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(99, 149, 339, 43);
		panel_5.setLayout(null);
		panel_5.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_5);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("����", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setText(departDTO.getDepartName());
		textField_2.setBounds(10, 10, 304, 23);
		panel_5.add(textField_2);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 191, 100, 43);
		panel_6.setLayout(null);
		frame.getContentPane().add(panel_6);

		JLabel label_3 = new JLabel("\u90E8\u95E8\u7F16\u53F7");
		label_3.setFont(new Font("����", Font.PLAIN, 16));
		label_3.setBounds(10, 10, 79, 23);
		panel_6.add(label_3);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(99, 191, 339, 43);
		panel_7.setLayout(null);
		panel_7.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_7);

		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("����", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setText(departDTO.getDepartNumber());
		textField_3.setBounds(10, 10, 304, 23);
		panel_7.add(textField_3);

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(0, 233, 100, 67);
		panel_8.setLayout(null);
		frame.getContentPane().add(panel_8);

		JLabel label_4 = new JLabel("\u5907\u6CE8");
		label_4.setFont(new Font("����", Font.PLAIN, 16));
		label_4.setBounds(10, 21, 79, 23);
		panel_8.add(label_4);

		JPanel panel_9 = new JPanel();
		panel_9.setBounds(99, 233, 339, 67);
		panel_9.setLayout(null);
		panel_9.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_9);

		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("����", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setText(departDTO.getDepartRemark());
		textField_4.setBounds(10, 10, 304, 47);
		panel_9.add(textField_4);
		JButton button = new JButton("\u4FDD\u5B58");
		button.setBounds(328, 316, 93, 31);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (addTrainDepartLegal()) {

					// �����������
					Department department = new Department();
					// ������洫�����
					DepartDTO departDTO = new DepartDTO();
					// �����־����
					boolean savaSuccessful = false;
					departDTO.setHighDepartName(lblNewLabel_1.getText());
					departDTO.setDepartNumber(textField_3.getText());
					departDTO.setDepartName(textField_2.getText());
					departDTO.setDepartRemark(textField_4.getText());
					departDTO.setHighDepartNumber(label_5.getText());
					savaSuccessful = department.updateAllDepartInfo(departDTO, id);
					if (savaSuccessful) {
						JOptionPane.showMessageDialog(null, "����ɹ�");
					} else {
						JOptionPane.showMessageDialog(null, "����ʧ��");
					}
				}
			}
		});
		button.setFont(new Font("����", Font.PLAIN, 16));
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		button_1.setBounds(440, 316, 93, 31);
		button_1.setFont(new Font("����", Font.PLAIN, 16));
		frame.getContentPane().add(button_1);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(440, 151, 93, 41);
		frame.getContentPane().add(lblNewLabel_2);

		label_6 = new JLabel("");
		label_6.setForeground(Color.RED);
		label_6.setBounds(440, 193, 93, 41);
		frame.getContentPane().add(label_6);
	}

	public boolean addTrainDepartLegal() {
		boolean result = true;
		if (textField_2.getText().isEmpty()) {
			lblNewLabel_2.setText("�����벿������");
			result = result && false;
		}
		if (textField_3.getText().isEmpty()) {
			label_6.setText("�����벿������");
			result = result && false;
		}

		return result;
	}
}
