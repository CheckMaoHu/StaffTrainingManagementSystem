package forms.Main.MDI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import forms.LoginFormMain;
import forms.UpdatePassword;
import forms.EmployeeManager.EmployeeManagerForm;
import forms.ScoreManager.ScoreManagerForm;
import forms.TrainDepart.TrainDepartform;
import forms.TranPlanManager.AddTrainPlanForm;
import forms.TranPlanManager.TrainPlanManagerForm;
import utils.SetFrameLoaction;

public class HeadForm {

	private static JFrame frame;

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
	public HeadForm(String userName) {
		initialize(userName);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	private void initialize(final String userName) {

		frame = new JFrame();
		frame.setBounds(100, 100, 566, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 552, 39);
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 35, 5));

		JMenuBar menuBar_3 = new JMenuBar();
		panel.add(menuBar_3);
		menuBar_3.setBorderPainted(false);

		JMenu mnNewMenu_3 = new JMenu("\u57F9\u8BAD\u8BA1\u5212\u7BA1\u7406");
		menuBar_3.add(mnNewMenu_3);
		mnNewMenu_3.setForeground(Color.BLACK);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u7BA1\u7406");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				TrainPlanManagerForm trainPlanManagerFrom = new TrainPlanManagerForm();
				trainPlanManagerFrom.main(null);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u5F55\u5165\u8BE6\u7EC6\u4FE1\u606F");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AddTrainPlanForm addTrainManagerForm = new AddTrainPlanForm();
				addTrainManagerForm.main(null);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_6);

		JMenuBar menuBar_4 = new JMenuBar();
		panel.add(menuBar_4);
		menuBar_4.setBorderPainted(false);

		JMenu mnNewMenu_4 = new JMenu("\u57F9\u8BAD\u6210\u7EE9\u7BA1\u7406");
		mnNewMenu_4.setForeground(Color.BLACK);
		menuBar_4.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u7BA1\u7406");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ScoreManagerForm scoreManager = new ScoreManagerForm();
				scoreManager.main(null);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_7);

		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setBorderPainted(false);
		panel.add(menuBar_2);

		JMenu mnNewMenu_2 = new JMenu("\u90E8\u95E8\u7BA1\u7406");
		mnNewMenu_2.setForeground(Color.BLACK);
		menuBar_2.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u7BA1\u7406   ");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				TrainDepartform trainDepartForm = new TrainDepartform();
				trainDepartForm.main(null);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);

		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBorderPainted(false);
		panel.add(menuBar_1);

		JMenu mnNewMenu_1 = new JMenu("\u5458\u5DE5\u7BA1\u7406");
		mnNewMenu_1.setForeground(Color.BLACK);
		mnNewMenu_1.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar_1.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u7BA1\u7406");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				EmployeeManagerForm employeeManagerForm = new EmployeeManagerForm();
				employeeManagerForm.main(null);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setToolTipText("\u7528\u6237\u7BA1\u7406");
		panel.add(menuBar);

		JMenu mnNewMenu = new JMenu("\u7528\u6237\u7BA1\u7406");
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setBackground(Color.LIGHT_GRAY);
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				UpdatePassword updatePassword = new UpdatePassword(userName);
				updatePassword.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u91CD\u65B0\u767B\u5F55");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				LoginFormMain loginFormMain = new LoginFormMain();
				frame.dispose();
				loginFormMain.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u9000\u51FA");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(0, 49, 552, 333);
		frame.getContentPane().add(panel_6);
		panel_6.setLayout(null);

		JLabel label_4 = new JLabel("\u6B22\u8FCE\u8FDB\u5165\u7535\u5382\u804C\u5DE5\u7BA1\u7406\u7CFB\u7EDF");
		label_4.setForeground(Color.BLUE);
		label_4.setFont(new Font("ËÎÌå", Font.PLAIN, 24));
		label_4.setBounds(117, 130, 328, 118);
		panel_6.add(label_4);

		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);// ÍË³ö³ÌÐò
			}
		});
		btnNewButton.setBounds(429, 283, 113, 42);
		panel_6.add(btnNewButton);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
