package forms;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import dto.DepartDTO;
import services.depart.Department;

public class ComboxSimple {

	private JComboBox combox;

	public ComboxSimple(JComboBox combox, String name) {
		init(combox, name);
	}

	public ComboxSimple(String departName, JComboBox combox) {
		init1(departName, combox);
	}

	public void init(JComboBox combox, String name) {

		Department depart = new Department();
		// 定义接受层对象
		List<DepartDTO> departDTO = new ArrayList<DepartDTO>();
		departDTO = depart.queryDepartByName(name);
		String[] value = new String[departDTO.size()];
		for (int i = 0; i < departDTO.size(); i++) {
			value[i] = departDTO.get(i).getDepartName();
		}
		combox.setModel(new DefaultComboBoxModel(value));
		this.combox = combox;
	}

	public void init1(String departName, JComboBox combox) {
		// 定义服务层对象
		Department depart = new Department();
		// 定义接受层对象
		List<DepartDTO> departDTO = new ArrayList<DepartDTO>();
		List<DepartDTO> departDNmaeDTO = new ArrayList<DepartDTO>();
		DepartDTO departDTO1 = new DepartDTO();
		departDTO1.setDepartNumber(departName);
		departDTO = depart.queryDepartByDepartNumber(departDTO1);
		departDNmaeDTO = depart.queryDepartByName(departDTO.get(0).getHighDepartName());
		String[] value = new String[departDNmaeDTO.size()];
		for (int i = 0; i < departDNmaeDTO.size(); i++) {
			value[i] = departDNmaeDTO.get(i).getDepartName();
		}

		combox.setModel(new DefaultComboBoxModel(value));
		this.combox = combox;
	}

	public JComboBox getCombox() {
		return combox;
	}
}
