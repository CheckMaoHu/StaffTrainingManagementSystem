package services.user;

import dto.UserLoginDTO;
import persistences.UserDAO;

public class User {
	private String user_name;
	private String password;

	public User(String name, String psw) {
		this.user_name = name;
		this.password = psw;
	}

	public User() {

	}

	public boolean findUser() {
		boolean result = false;

		result = new UserDAO().findUser(user_name, password);

		return result;
	}

	/*
	 * public Vector<Vector<Object>> getAllUsers() { List<UserDTO> allUsers = null;
	 * 
	 * allUsers = new UserDAO().getAllUser();
	 * 
	 * return list2vector(allUsers); }
	 * 
	 * private Vector<Vector<Object>> list2vector(List<UserDTO> allUser) {
	 * 
	 * Vector<Vector<Object>> result = new Vector<Vector<Object>>();
	 * 
	 * for (UserDTO u : allUser) { Vector<Object> v = new Vector<Object>();
	 * v.add(u.getUnit_name()); v.add(new KeyValue<String, String>(u.getName(),
	 * u.getUser_id())); v.add(u.getBirthday()); v.add(u.getCard_id());
	 * 
	 * v.add(Duty.getName(u.getDuty())); v.add(u.getEmail()); result.add(v); }
	 * 
	 * return result; }
	 */
	public boolean saveUser(UserLoginDTO user) {
		boolean saveSuccessful = false;

		saveSuccessful = new UserDAO().saveUser(user);
		return saveSuccessful;

	}

	public boolean nameExisted(String userName) {

		return (new UserDAO().nameExisted(userName));

	}

	/*
	 * public boolean saveUserAll(UserDTO user) { boolean saveSuccessful = false;
	 * saveSuccessful = new UserDAO().saveUserAll(user); return saveSuccessful; }
	 */
}
