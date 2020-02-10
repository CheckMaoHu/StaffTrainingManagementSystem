package utils;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class MyComboBoxRenderer extends JComboBox implements TableCellRenderer {

	public MyComboBoxRenderer(String[] items) {
		super(items);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		if (isSelected) {
			super.setBackground(table.getSelectionBackground());
		} else {
			setBackground(table.getBackground());
		}
		setSelectedItem(value);
		return this;
	}
}
