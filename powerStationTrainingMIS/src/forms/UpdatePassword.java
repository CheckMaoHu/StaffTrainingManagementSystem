package forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import dto.UserLoginDTO;
import services.user.UserLogin;
import utils.SetFrameLoaction;

public class UpdatePassword {

	private static JFrame frame;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JLabel lblNewLabel_1, label_2, label_3;

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
	public UpdatePassword(String userName) {
		initialize(userName);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	private void initialize(final String userName) {
		frame = new JFrame();
		frame.setBounds(100, 100, 611, 418);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setBounds(229, 110, 196, 36);
		frame.getContentPane().add(passwordField);

		JLabel lblNewLabel = new JLabel("\u539F\u5BC6\u7801\uFF1A");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 16));
		lblNewLabel.setBounds(143, 110, 101, 36);
		frame.getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("\u73B0\u5BC6\u7801\uFF1A");
		label.setFont(new Font("����", Font.PLAIN, 16));
		label.setBounds(143, 174, 101, 36);
		frame.getContentPane().add(label);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(229, 174, 196, 36);
		frame.getContentPane().add(passwordField_1);

		JLabel label_1 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("����", Font.PLAIN, 16));
		label_1.setBounds(143, 237, 101, 36);
		frame.getContentPane().add(label_1);

		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(229, 237, 196, 36);
		frame.getContentPane().add(passwordField_2);

		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// ��������
				UserLogin userLogin = new UserLogin();
				// ������ܲ�
				UserLoginDTO userLoginAcceptDTO = new UserLoginDTO();
				// ���崫���
				UserLoginDTO userLoginOldDTO = new UserLoginDTO();
				// ���ܽ�������
				userLoginOldDTO.setPassWord(new String(passwordField.getPassword()));
				// ��������������dto
				UserLoginDTO userLoginNewDTO = new UserLoginDTO();
				userLoginNewDTO.setPassWord(new String(passwordField_1.getPassword()));
				userLoginAcceptDTO = userLogin.queryPasswordByName(userName);
				if (fromLegal()) {
					if (userLoginAcceptDTO.getPassWord().equals(userLoginOldDTO.getPassWord())) {
						boolean updateSuccessful = false;
						updateSuccessful = userLogin.updatePasswordByName(userName, userLoginNewDTO);
						if (updateSuccessful) {
							JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
						} else {
							JOptionPane.showMessageDialog(null, "�޸�ʧ��");
						}

					} else {
						JOptionPane.showMessageDialog(null, "ԭ�������");
					}

				}
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 16));
		btnNewButton.setBounds(356, 335, 101, 36);
		frame.getContentPane().add(btnNewButton);

		JButton button = new JButton("\u53D6\u6D88");
		button.setFont(new Font("����", Font.PLAIN, 16));
		button.setBounds(486, 335, 101, 36);
		frame.getContentPane().add(button);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(447, 110, 140, 36);
		frame.getContentPane().add(lblNewLabel_1);

		label_2 = new JLabel("");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("����", Font.PLAIN, 16));
		label_2.setBounds(447, 174, 140, 36);
		frame.getContentPane().add(label_2);

		label_3 = new JLabel("");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("����", Font.PLAIN, 16));
		label_3.setBounds(447, 237, 140, 36);
		frame.getContentPane().add(label_3);
	}

	public boolean fromLegal() {
		boolean result = true;
		if (new String(passwordField.getPassword()).isEmpty()) {
			lblNewLabel_1.setText("������ԭ����");
			result = result && false;
		}
		if (new String(passwordField_1.getPassword()).isEmpty()) {
			label_2.setText("������������");
			result = result && false;
		}
		if (new String(passwordField_2.getPassword()).isEmpty()) {
			label_3.setText("������ȷ������");
			result = result && false;
		}
		if (result) {
			if (new String(passwordField.getPassword()).equals(new String(passwordField_1.getPassword()))) {
				JOptionPane.showMessageDialog(null, "ԭ������������һ��");
				result = result && false;
			} else {
				if (new String(passwordField_1.getPassword())
						.equals(new String(passwordField_2.getPassword())) == false) {
					JOptionPane.showMessageDialog(null, "�޸ĵ��������벻һ��");
					result = result && false;
				}

			}
		}
		return result;
	}
}
