package utils;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import forms.ScoreManager.AddScoreForm;
import forms.ScoreManager.ScoreCheckForm;
import forms.TranPlanManager.ScheduleTrainManagerForm;
import forms.TranPlanManager.SelectEmployee;

/**
 * 自定义一个往列里边添加按钮的单元格编辑器。最好继承DefaultCellEditor，不然要实现的方法就太多了。
 * 
 */
public class MyButtonEditor extends DefaultCellEditor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6546334664166791132L;

	private JPanel panel;

	private JButton button;
	private int accpId;
	private int detailId;
	// 标志跳转界面
	private int flag;

	public MyButtonEditor() {
		// DefautlCellEditor有此构造器，需要传入一个，但这个不会使用到，直接new一个即可。
		super(new JTextField());

		// 设置点击几次激活编辑。
		this.setClickCountToStart(1);

		this.initButton();

		this.initPanel();

		// 添加按钮。
		this.panel.add(this.button);
	}

	private void initButton() {
		this.button = new JButton();

		// 设置按钮的大小及位置。
		this.button.setBounds(0, 0, 75, 15);

		// 为按钮添加事件。这里只能添加ActionListner事件，Mouse事件无效。
		this.button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 触发取消编辑的事件，不会调用tableModel的setValue方法。
				if (flag == 1) {
					MyButtonEditor.this.fireEditingCanceled();
					ScheduleTrainManagerForm scheduleTrain = new ScheduleTrainManagerForm(accpId);
					scheduleTrain.main(null);
				}
				if (flag == 2) {
					SelectEmployee selectEmployee = new SelectEmployee(accpId, detailId);
					selectEmployee.main(null);
				}
				if (flag == 3) {// 跳转到成绩添加界面
					AddScoreForm addScore = new AddScoreForm(accpId);
					addScore.main(null);
				}
				if (flag == 4) {
					ScoreCheckForm socreCheck = new ScoreCheckForm(accpId);
					socreCheck.main(null);
				}
				// 这里可以做其它操作。
				// 可以将table传入，通过getSelectedRow,getSelectColumn方法获取到当前选择的行和列及其它操作等。
			}
		});

	}

	private void initPanel() {
		this.panel = new JPanel();

		// panel使用绝对定位，这样button就不会充满整个单元格。
		this.panel.setLayout(new BorderLayout(0, 0));
	}

	/**
	 * 这里重写父类的编辑方法，返回一个JPanel对象即可（也可以直接返回一个Button对象，但是那样会填充满整个单元格）
	 */
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// 只为按钮赋值即可。也可以作其它操作。
		this.button.setText(value == null ? "" : String.valueOf(value));

		return this.panel;
	}

	/**
	 * 重写编辑单元格时获取的值。如果不重写，这里可能会为按钮设置错误的值。
	 */
	@Override
	public Object getCellEditorValue() {
		return this.button.getText();
	}

	public void setAccpId(int accpId) {
		this.accpId = accpId;
	}

	public int getAccpId() {
		return accpId;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getFlag() {
		return flag;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

}