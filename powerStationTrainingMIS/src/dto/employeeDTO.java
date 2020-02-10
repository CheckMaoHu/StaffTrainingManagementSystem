package dto;

import java.util.Date;

public class employeeDTO {

	private int employeeId;
	private String employeeName;
	private String employeeNumber;// 员工工号
	private String employeeSex;
	private String employeeCardId;// 身份证
	private Date employeeBirthday;
	private String departNumber;// 部门编号
	private String employeeDuty;
	private String employeePost;// 员工职务
	private String employeeNativePlace;// 籍贯
	private String employeeTelephone;

	public employeeDTO() {

	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeSex() {
		return employeeSex;
	}

	public void setEmployeeSex(String employeeSex) {
		this.employeeSex = employeeSex;
	}

	public String getEmployeeCardId() {
		return employeeCardId;
	}

	public void setEmployeeCardId(String employeeCardId) {
		this.employeeCardId = employeeCardId;
	}

	public Date getEmployeeBirthday() {
		return employeeBirthday;
	}

	public void setEmployeeBirthday(Date employeeBirthday) {
		this.employeeBirthday = employeeBirthday;
	}

	public String getDepartNumber() {
		return departNumber;
	}

	public void setDepartNumber(String departNamber) {
		this.departNumber = departNamber;
	}

	public String getEmployeeDuty() {
		return employeeDuty;
	}

	public void setEmployeeDuty(String employeeDuty) {
		this.employeeDuty = employeeDuty;
	}

	public String getEmployeePost() {
		return employeePost;
	}

	public void setEmployeePost(String employeePost) {
		this.employeePost = employeePost;
	}

	public String getEmployeeNativePlace() {
		return employeeNativePlace;
	}

	public void setEmployeeNativePlace(String employeeNativePlace) {
		this.employeeNativePlace = employeeNativePlace;
	}

	public String getEmployeeTelephone() {
		return employeeTelephone;
	}

	public void setEmployeeTelephone(String employeeTelephone) {
		this.employeeTelephone = employeeTelephone;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
}
