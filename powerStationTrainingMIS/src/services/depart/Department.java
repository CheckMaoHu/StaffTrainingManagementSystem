package services.depart;

import java.util.List;

import dto.DepartDTO;
import dto.HighDepartDTO;
import persistences.depart.DepartmentDAO;

public class Department {

	public boolean savaDepartInfo(DepartDTO departDTO) {
		// TODO Auto-generated method stub
		return new DepartmentDAO().saveDepartInfo(departDTO);
	}

	public List<DepartDTO> queryDepartInfo(DepartDTO departmentInfo) {
		// TODO Auto-generated method stub
		return new DepartmentDAO().queryDepartInfo(departmentInfo);
	}

	public DepartDTO queryAllDepartInfo(int departId) {
		// TODO Auto-generated method stub
		return new DepartmentDAO().queryAllDepartInfo(departId);
	}

	public boolean deleteDepartInfo(int departId) {
		// TODO Auto-generated method stub
		return new DepartmentDAO().deleteDepartInfo(departId);
	}

	public boolean updateAllDepartInfo(DepartDTO departDTO, int id) {
		// TODO Auto-generated method stub
		return new DepartmentDAO().updateAllDepartById(id, departDTO);
	}

	public List<DepartDTO> queryDepartByClass(DepartDTO departDTO) {
		return new DepartmentDAO().queryDepartByClass(departDTO);
	}

	public List<DepartDTO> queryDepartByDepartNumber(DepartDTO departDTO) {
		return new DepartmentDAO().queryDepartByDepartNumber(departDTO);
	}

	public List<HighDepartDTO> queryAllInfoHighByNo() {
		return new DepartmentDAO().queryAllInfoHighByNo();
	}

	public List<DepartDTO> queryAllInfoChildByNo() {
		return new DepartmentDAO().queryAllInfoChildByNo();
	}

	public HighDepartDTO queryHighDepartByName(String highDepartName) {
		return new DepartmentDAO().queryHighDepartByName(highDepartName);
	}

	public List<DepartDTO> queryDepartByName(String DepartName) {
		return new DepartmentDAO().queryDepartByName(DepartName);
	}

	public DepartDTO queryHighDepartByDepartNumber(String departNumber) {
		return new DepartmentDAO().queryHighDepartByDepartNumber(departNumber);
	}

	public DepartDTO queryDepartNameByDepartNumber(String departNumber) {
		return new DepartmentDAO().queryDepartNameByDepartNumber(departNumber);
	}

	public List<DepartDTO> queryDepartByTwoName(DepartDTO departDTO) {
		return new DepartmentDAO().queryDepartByTwoName(departDTO);
	}
}
