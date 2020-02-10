package forms;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class ITestForm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ITestForm frame = new ITestForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ITestForm() {
		setBounds(100, 100, 640, 469);

	}

}
