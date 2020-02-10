package dto;

public class DepartDTO {
	private int departId;
	private String departName;
	private String departNumber;
	private String departRemark;// ±¸×¢
	private String highDepartName;
	private String departTelephone;
	private String highDepartNumber;

	public int getDepartId() {
		return departId;
	}

	public void setDepartId(int departId) {
		this.departId = departId;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getDepartRemark() {
		return departRemark;
	}

	public void setDepartRemark(String departRemark) {
		this.departRemark = departRemark;
	}

	public String getHighDepartName() {
		return highDepartName;
	}

	public void setHighDepartName(String highDepartName) {
		this.highDepartName = highDepartName;
	}

	public String getDepartTelephone() {
		return departTelephone;
	}

	public void setDepartTelephone(String departTelephone) {
		this.departTelephone = departTelephone;
	}

	public String getDepartNumber() {
		return departNumber;
	}

	public void setDepartNumber(String departNumber) {
		this.departNumber = departNumber;
	}

	public String getHighDepartNumber() {
		return highDepartNumber;
	}

	public void setHighDepartNumber(String highDepartNumber) {
		this.highDepartNumber = highDepartNumber;
	}
}
