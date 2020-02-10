package utils;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dto.DepartDTO;
import dto.TrainPlanManagerDTO;
import dto.employeeDTO;
import services.TrainPeopleManager.TrainPeopleManager;
import services.depart.Department;
import services.employee.employee;

public class MyTable extends AbstractTableModel {
	// 将表格初始化
	// 定义服务层
	private employee employer;
	// 定义传输层
	private List<employeeDTO> employerDTO;
	public Object[][] p;
	public String[] name;
	private int colm;
	private int treeFlag;
	private int row;
	private int high;
	private int depart;
	private List<DepartDTO> depaertCompareDTO;

	public MyTable(int flag, int detailS) {
		// 定义安排服务层
		TrainPeopleManager trainPeople = new TrainPeopleManager();
		// 定义安排接受层
		List<TrainPlanManagerDTO> trainPlanManagerDTO = new ArrayList<TrainPlanManagerDTO>();
		trainPlanManagerDTO = trainPeople.queryTrainPeopleBydetail(detailS);

		if (flag == 1) {
			String[] name = { "选择", "员工编号", "姓名", "职务", "入场时间", "岗位" };
			this.name = name;
			employer = new employee();
			employerDTO = new ArrayList<employeeDTO>();
			employerDTO = employer.queryEmployeeInfoByNo();
			Object[][] t1 = new Object[employerDTO.size()][6];
			this.colm = 6;
			this.row = employerDTO.size();
			int j = 0;
			for (int i = 0; i < employerDTO.size(); i++) {
				if (!judgeEmployeeId(trainPlanManagerDTO, employerDTO.get(i).getEmployeeId())) {
					j++;
					continue;
				}
				if (treeFlag == 3) {
					for (int m = 0; m < depaertCompareDTO.size(); m++) {
						if (depaertCompareDTO.get(m).getDepartNumber().equals(employerDTO.get(i).getDepartNumber())) {
							t1[i - j][0] = false;
							t1[i - j][1] = employerDTO.get(i).getEmployeeId();
							t1[i - j][2] = employerDTO.get(i).getEmployeeName();
							t1[i - j][3] = employerDTO.get(i).getEmployeeDuty();
							t1[i - j][4] = employerDTO.get(i).getEmployeeBirthday();
							t1[i - j][5] = employerDTO.get(i).getEmployeePost();
						}
					}
				} else {
					t1[i - j][0] = false;
					t1[i - j][1] = employerDTO.get(i).getEmployeeId();
					t1[i - j][2] = employerDTO.get(i).getEmployeeName();
					t1[i - j][3] = employerDTO.get(i).getEmployeeDuty();
					t1[i - j][4] = employerDTO.get(i).getEmployeeBirthday();
					t1[i - j][5] = employerDTO.get(i).getEmployeePost();
				}

			}
			Object[][] t2 = new Object[employerDTO.size() - j][6];
			for (int m = 0; m < employerDTO.size() - j; m++) {
				for (int n = 0; n < 6; n++) {
					t2[m][n] = t1[m][n];
				}
			}

			this.p = t2;
		}
		if (flag == 2) {
			String[] name = { "选择", "姓名", "部门", "员工id" };
			this.name = name;
			// 定义服务层
			employee employer2 = new employee();
			// 定义接受层
			employeeDTO employee2DTO = new employeeDTO();
			// 定义服务层
			Department depart = new Department();
			// 定义接受层
			DepartDTO departDTO = new DepartDTO();
			this.colm = 4;
			this.row = trainPlanManagerDTO.size();
			Object[][] existT = new Object[trainPlanManagerDTO.size()][4];
			for (int i = 0; i < trainPlanManagerDTO.size(); i++) {
				existT[i][0] = false;
				employee2DTO = employer2.QueryEmployeeALLInfoById(trainPlanManagerDTO.get(i).getEmployeeId());
				existT[i][1] = employee2DTO.getEmployeeName();
				departDTO = depart.queryDepartNameByDepartNumber(employee2DTO.getDepartNumber());
				existT[i][2] = departDTO.getHighDepartName() + " " + departDTO.getDepartName();
				existT[i][3] = trainPlanManagerDTO.get(i).getEmployeeId();
			}
			this.p = existT;

		}

	}

	public boolean judgeEmployeeId(List<TrainPlanManagerDTO> trainPlanManagerDTO, int employeeId) {
		for (int i = 0; i < trainPlanManagerDTO.size(); i++) {
			if (trainPlanManagerDTO.get(i).getEmployeeId() == employeeId)
				return false;
		}

		return true;
	}

	@Override
	public int getRowCount() {
		return p.length;
	}

	@Override
	public int getColumnCount() {
		return name.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return p[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		return name[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		p[rowIndex][columnIndex] = aValue;
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	public Object[][] getP() {
		return p;
	}

	public int getColm() {
		return colm;
	}

	public int getRow() {
		return row;
	}

	public void setDepaertCompareDTO(List<DepartDTO> depaertCompareDTO) {
		this.depaertCompareDTO = depaertCompareDTO;
	}

	public void setTreeFlag(int treeFlag) {
		this.treeFlag = treeFlag;
	}
}
