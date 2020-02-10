package forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dto.UserLoginDTO;
import services.user.UserLogin;

public class AddUserForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JLabel lblUserNameTip;
	private JLabel lblPSWTip, label_1;

	private UserLogin userLogin;
	private JTextField txtPassWord;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUserForm frame = new AddUserForm();
					setFrameLoaction(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void setFrameLoaction(JFrame frame) {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		int width = screen.width;
		int height = screen.height;

		int left = (width - frame.getSize().width) / 2;
		int top = (height - frame.getSize().height) / 2;

		frame.setLocation(left, top);

	}

	/**
	 * Create the frame.
	 */
	public AddUserForm() {
		setTitle("\u7528\u6237\u6CE8\u518C");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 519, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 10));

		JPanel body = new JPanel();
		panel.add(body, BorderLayout.CENTER);
		body.setLayout(null);

		// 点击登录按钮事件的处理逻辑
		JButton btnRegister = new JButton("\u786E\u5B9A");
		btnRegister.setFont(new Font("宋体", Font.PLAIN, 16));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validateUser()) {
					// 如果通过语法验证，将用户信息保存到数据库中
					UserLoginDTO userLoginDTO = new UserLoginDTO(txtUserName.getText(), txtPassWord.getText());
					UserLogin userLogin = new UserLogin();

					// 语义验证：输入的用户是否已经存在
					boolean nameExisted = userLogin.nameExisted(txtUserName.getText());
					if (!nameExisted) {
						boolean saveSuccessful = userLogin.saveUserLogin(userLoginDTO);

						if (saveSuccessful) {
							System.out.println("save successful");
							JOptionPane.showMessageDialog(null, "保存成功！");
						} else {
							System.out.println("save failed");
							JOptionPane.showMessageDialog(null, "保存失败！");
						}
					} else {
						JOptionPane.showMessageDialog(null, "该用户已经存在！");

					}

				} else
					System.out.println("The User is not passed!");
			}
		});

		btnRegister.setBounds(152, 236, 93, 32);
		body.add(btnRegister);

		JButton btnCancle = new JButton("\u53D6\u6D88");
		btnCancle.setFont(new Font("宋体", Font.PLAIN, 16));
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancle.setBounds(271, 236, 93, 32);
		body.add(btnCancle);

		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(87, 48, 68, 24);
		body.add(lblNewLabel_1);

		txtUserName = new JTextField();
		txtUserName.setBounds(165, 40, 176, 32);
		body.add(txtUserName);
		txtUserName.setColumns(10);
		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(87, 90, 68, 29);
		body.add(lblNewLabel_2);

		lblUserNameTip = new JLabel("");
		lblUserNameTip.setForeground(new Color(220, 20, 60));
		lblUserNameTip.setBounds(351, 40, 140, 32);
		body.add(lblUserNameTip);

		lblPSWTip = new JLabel("");
		lblPSWTip.setForeground(new Color(220, 20, 60));
		lblPSWTip.setBounds(351, 90, 140, 29);
		body.add(lblPSWTip);

		txtPassWord = new JTextField();
		txtPassWord.setBounds(165, 87, 176, 32);
		body.add(txtPassWord);
		txtPassWord.setColumns(10);

		JLabel label = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(81, 136, 93, 29);
		body.add(label);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(165, 133, 176, 32);
		body.add(textField);

		label_1 = new JLabel("");
		label_1.setForeground(new Color(220, 20, 60));
		label_1.setBounds(351, 136, 140, 29);
		body.add(label_1);
	}

	/*
	 * 对用户登录信息从语法方面进行验证
	 */
	private boolean validateUser() {
		boolean result = true;

		if (txtUserName.getText().isEmpty()) {
			this.lblUserNameTip.setText("请输入用户名！");
			result = result && false;
		}
		if (new String(txtPassWord.getText()).isEmpty()) {
			this.lblPSWTip.setText("请输入密码!");
			result = result && false;
		}
		if (textField.getText().isEmpty()) {
			this.label_1.setText("请输入确认密码！");
			result = result & false;
		}
		if (new String(txtPassWord.getText()).equals(textField.getText()) == false && !textField.getText().isEmpty()) {
			this.label_1.setText("两次密码不一致！");
			result = result & false;
		}

		return result;
	}
}
