package forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import forms.Main.MDI.HeadForm;
import services.user.UserLogin;

public class LoginFormMain {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private UserLogin userLogin;
	private JLabel label_3, label_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFormMain window = new LoginFormMain();
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
	public LoginFormMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 596, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 235));
		panel_1.setBounds(0, 0, 582, 76);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel label = new JLabel("\u7535\u5382\u804C\u5DE5\u57F9\u8BAD\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		label.setBounds(148, 27, 304, 26);
		label.setForeground(new Color(0, 128, 0));
		label.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		panel_1.add(label);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 75, 582, 315);
		frame.getContentPane().add(panel);

		final JLabel label_3 = new JLabel("");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setForeground(new Color(220, 20, 60));
		label_3.setBounds(351, 40, 140, 32);
		panel.add(label_3);

		final JLabel label_4 = new JLabel("");
		label_4.setFont(new Font("宋体", Font.PLAIN, 16));
		label_4.setForeground(new Color(220, 20, 60));
		label_4.setBounds(351, 115, 140, 32);
		panel.add(label_4);
		// 验证放在前面

		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (validateUser(label_3, label_4)) {
					// 如果通过语法验证，则进行判断用户是否为合法用户
					userLogin = new UserLogin(textField.getText(), new String(passwordField.getPassword()));
					if (userLogin.findUserLogin()) {

						HeadForm headForm = new HeadForm(textField.getText());
						frame.dispose();
						headForm.main(null);

						System.out.println("logon successful");
					} else
						System.out.println("logon failed");

				} else
					System.out.println("The User is not passed!");
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.setBounds(133, 207, 93, 32);
		panel.add(button);

		JButton button_1 = new JButton("\u6CE8\u518C");
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AddUserForm addUserForm = new AddUserForm();
				addUserForm.main(null);
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 16));
		button_1.setBounds(286, 207, 93, 32);
		panel.add(button_1);

		JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(81, 43, 74, 23);
		panel.add(label_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(165, 40, 176, 32);
		panel.add(textField);

		JLabel label_2 = new JLabel("\u5BC6   \u7801\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(81, 118, 74, 23);
		panel.add(label_2);

		passwordField = new JPasswordField();
		passwordField.setBounds(165, 115, 176, 32);
		panel.add(passwordField);
	}

	private boolean validateUser(JLabel label_N, JLabel label_P) {
		boolean result = true;

		if (textField.getText().isEmpty()) {
			label_N.setText("用户名不能为空！");
			result = result && false;
		}
		if (new String(passwordField.getPassword()).isEmpty()) {
			label_P.setText("密码不能为空！");
			result = result && false;
		}
		return result;
	}

}
