package services.user;

import dto.UserLoginDTO;
import persistences.UserLoginDAO;

public class UserLogin {
	private String userName;
	private String passWord;

	public UserLogin() {

	}

	public UserLogin(String userName, String passWord) {
		this.passWord = passWord;
		this.userName = userName;
	}

	public boolean findUserLogin() {
		boolean result = false;
		result = new UserLoginDAO().findUser(userName, passWord);
		return result;
	}

	public boolean saveUserLogin(UserLoginDTO user) {
		boolean saveSuccessful = false;
		saveSuccessful = new UserLoginDAO().saveUser(user);
		return saveSuccessful;
	}

	public boolean nameExisted(String userName) {
		return (new UserLoginDAO().nameExisted(userName));
	}

	public UserLoginDTO queryPasswordByName(String userName) {
		return new UserLoginDAO().queryPasswordByName(userName);
	}

	public boolean updatePasswordByName(String userName, UserLoginDTO userLoginDTO) {
		return new UserLoginDAO().updatePasswordByName(userName, userLoginDTO);
	}
}
