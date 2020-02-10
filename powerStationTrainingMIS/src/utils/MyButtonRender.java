package utils;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class MyButtonRender implements TableCellRenderer {
	private JPanel panel;

	private JButton button;

	public MyButtonRender() {
		this.initButton();

		this.initPanel();

		// ��Ӱ�ť��
		this.panel.add(this.button);
	}

	private void initButton() {
		this.button = new JButton();

		// ���ð�ť�Ĵ�С��λ�á�
		// this.button.setBounds(0, 0, 50, 15);

		// ����Ⱦ�������Ӱ�ť���¼��ǲ��ᴥ����
		// this.button.addActionListener(new ActionListener()
		// {
		//
		// public void actionPerformed(ActionEvent e)
		// {
		// // TODO Auto-generated method stub
		// }
		// });

	}

	private void initPanel() {
		this.panel = new JPanel();

		// panelʹ�þ��Զ�λ������button�Ͳ������������Ԫ��
		this.panel.setLayout(new BorderLayout(0, 0));
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// ֻΪ��ť��ֵ���ɡ�Ҳ������������������汳���ȡ�
		this.button.setText(value == null ? "" : String.valueOf(value));

		return this.panel;
	}

}