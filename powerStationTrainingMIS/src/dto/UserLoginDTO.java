package dto;

import java.util.Calendar;
import java.util.Date;

public class UserLoginDTO {
	private String ID;
	private String userName;
	private String passWord;

	public UserLoginDTO() {

	}

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Date d = cal.getTime();
		String format = "%tF";
		System.out.println(d);
		System.out.println(String.format(format, d));

	}

	public String toString() {
		String format = "UserName:%s,ID:%s,passWord:%s";
		String result = String.format(format, this.userName, this.ID, this.passWord);
		return result;
	}

	public UserLoginDTO(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getID() {
		return ID;
	}
}
