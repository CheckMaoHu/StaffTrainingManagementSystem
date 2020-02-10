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
 * �Զ���һ�����������Ӱ�ť�ĵ�Ԫ��༭������ü̳�DefaultCellEditor����ȻҪʵ�ֵķ�����̫���ˡ�
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
	// ��־��ת����
	private int flag;

	public MyButtonEditor() {
		// DefautlCellEditor�д˹���������Ҫ����һ�������������ʹ�õ���ֱ��newһ�����ɡ�
		super(new JTextField());

		// ���õ�����μ���༭��
		this.setClickCountToStart(1);

		this.initButton();

		this.initPanel();

		// ��Ӱ�ť��
		this.panel.add(this.button);
	}

	private void initButton() {
		this.button = new JButton();

		// ���ð�ť�Ĵ�С��λ�á�
		this.button.setBounds(0, 0, 75, 15);

		// Ϊ��ť����¼�������ֻ�����ActionListner�¼���Mouse�¼���Ч��
		this.button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ����ȡ���༭���¼����������tableModel��setValue������
				if (flag == 1) {
					MyButtonEditor.this.fireEditingCanceled();
					ScheduleTrainManagerForm scheduleTrain = new ScheduleTrainManagerForm(accpId);
					scheduleTrain.main(null);
				}
				if (flag == 2) {
					SelectEmployee selectEmployee = new SelectEmployee(accpId, detailId);
					selectEmployee.main(null);
				}
				if (flag == 3) {// ��ת���ɼ���ӽ���
					AddScoreForm addScore = new AddScoreForm(accpId);
					addScore.main(null);
				}
				if (flag == 4) {
					ScoreCheckForm socreCheck = new ScoreCheckForm(accpId);
					socreCheck.main(null);
				}
				// �������������������
				// ���Խ�table���룬ͨ��getSelectedRow,getSelectColumn������ȡ����ǰѡ����к��м����������ȡ�
			}
		});

	}

	private void initPanel() {
		this.panel = new JPanel();

		// panelʹ�þ��Զ�λ������button�Ͳ������������Ԫ��
		this.panel.setLayout(new BorderLayout(0, 0));
	}

	/**
	 * ������д����ı༭����������һ��JPanel���󼴿ɣ�Ҳ����ֱ�ӷ���һ��Button���󣬵��������������������Ԫ��
	 */
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// ֻΪ��ť��ֵ���ɡ�Ҳ����������������
		this.button.setText(value == null ? "" : String.valueOf(value));

		return this.panel;
	}

	/**
	 * ��д�༭��Ԫ��ʱ��ȡ��ֵ���������д��������ܻ�Ϊ��ť���ô����ֵ��
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