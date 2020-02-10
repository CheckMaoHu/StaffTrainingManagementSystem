package services.employee;

import java.util.List;

import dto.DepartDTO;
import dto.employeeDTO;
import persistences.employee.employeeDAO;

public class employee {

	public DepartDTO QueryDepartNumber(String highDepartNumber, String departName) {
		return new employeeDAO().QueryDepartNumber(highDepartNumber, departName);
	}

	public boolean insertEmployeeInfo(employeeDTO employerDTO) {
		return new employeeDAO().insertEmployeeInfo(employerDTO);
	}

	public List<employeeDTO> queryAllEmployeeInfo(employeeDTO employerDTO) {
		return new employeeDAO().queryAllEmployeeInfo(employerDTO);
	}

	public DepartDTO queryDepartName(String employerDTO) {
		return new employeeDAO().queryDepartName(employerDTO);
	}

	public boolean deleteEmployeeInfo(int employeeId) {
		return new employeeDAO().deleteEmployeeInfo(employeeId);
	}

	public employeeDTO QueryEmployeeALLInfoById(int employeeId) {
		return new employeeDAO().QueryEmployeeALLInfoById(employeeId);
	}

	public boolean updateEmployeeinfo(int employeeId, employeeDTO employerDTO) {
		return new employeeDAO().updateEmployeeinfo(employeeId, employerDTO);
	}

	public employeeDTO queryEmployeeNumberIsExist(String employeeNumber) {
		return new employeeDAO().queryEmployeeNumberIsExist(employeeNumber);
	}

	public employeeDTO queryCardIdIsExist(String employeeCardId) {
		return new employeeDAO().queryCardIdIsExist(employeeCardId);
	}

	public List<employeeDTO> queryAllEmployeeByName(employeeDTO employerDTO) {
		return new employeeDAO().queryAllEmployeeByName(employerDTO);
	}

	public List<employeeDTO> queryAllEmployeeByEmployeeNumber(employeeDTO employerDTO) {
		return new employeeDAO().queryAllEmployeeByEmployeeNumber(employerDTO);
	}

	public DepartDTO queryDepartNumberWhere(String departNumber, String departName) {
		return new employeeDAO().queryDepartNumberWhere(departNumber, departName);
	}

	public List<employeeDTO> queryEmployeeInfoByNo() {
		return new employeeDAO().queryEmployeeInfoByNo();
	}
}
