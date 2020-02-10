package persistences;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import dto.UserLoginDTO;
import util.CommUtil;
import util.DBUtil;

public class UserDAO {
	private DBUtil dbUtil;
	private Connection conn;

	public UserDAO() {
		dbUtil = new DBUtil();
		conn = dbUtil.getConnection();
	}

	public boolean findUser(String name, String psw) {
		boolean result = false;
		QueryRunner qr = new QueryRunner();
		UserLoginDTO userLoginDTO = null;

		String sql = "select * from p_login_t where userName=? and passWord=?";

		try {
			userLoginDTO = qr.query(conn, sql, new BeanHandler<UserLoginDTO>(UserLoginDTO.class), name, psw);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (userLoginDTO != null) {
			result = true;
			System.out.println(userLoginDTO.getUserName() + "  " + userLoginDTO.getPassWord());
		}

		return result;
	}

	/*
	 * public List<UserDTO> getAllUser() { QueryRunner qr = new QueryRunner();
	 * List<UserDTO> allUsers = null;
	 * 
	 * String sql =
	 * "select user_id,NAME,sex,card_id,birthday,userInfo.unit_id,depart.unit_name,userInfo.telephone,duty,TECDUTY,userInfo.email from t_base_user_info userInfo,t_base_unit_info depart where userInfo.unit_id = depart.unit_id;"
	 * ; try { allUsers = qr.query(conn, sql, new
	 * BeanListHandler<UserDTO>(UserDTO.class)); } catch (SQLException e) {
	 * e.printStackTrace(); } finally { try { DbUtils.close(conn); } catch
	 * (SQLException e) { e.printStackTrace(); } } return allUsers;
	 * 
	 * }
	 */
	public boolean saveUser(UserLoginDTO user) {
		boolean result = false;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();

		String sql = "insert into p_login_t (ID,userName,passWord) values(?,?,?)";
		String userId = CommUtil.getId();

		try {
			insertRows = qr.update(conn, sql, userId, user.getUserName(), user.getPassWord());

			System.out.println("*******" + insertRows);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		result = (insertRows == 1) ? true : false;
		System.out.println("*******" + result);
		return result;
	}

	/*
	 * public boolean saveUserAll(UserDTO user) { boolean result = false; int
	 * insertRows = 0; QueryRunner qr = new QueryRunner();
	 * 
	 * String sql =
	 * "insert into t_base_user_info (user_id,NAME,sex,birthday,card_id,unit_id,telephone,duty,telduty) values(?,?,?,?,?,?,?,?,?)"
	 * ; String userId = CommUtil.getId();
	 * 
	 * try { insertRows = qr.update(conn, sql, userId, user.getName(),
	 * user.getSex(), user.getBirthday(), user.getCard_id(), user.getUnit_id(),
	 * user.getTelphone(), user.getDuty(), user.getTelduty());
	 * 
	 * System.out.println("*******" + insertRows); } catch (SQLException e) {
	 * e.printStackTrace(); } finally { try { DbUtils.close(conn); } catch
	 * (SQLException e) { e.printStackTrace(); } }
	 * 
	 * result = (insertRows == 1) ? true : false; System.out.println("*******" +
	 * result); return result; }
	 */
	public Boolean nameExisted(String userName) {
		boolean existed = false;
		UserLoginDTO userLoginDTO = null;

		QueryRunner qr = new QueryRunner();
		String sql = "select ID,userName,passWord from p_login_t where userName = ?";
		try {
			userLoginDTO = qr.query(conn, sql, new BeanHandler<UserLoginDTO>(UserLoginDTO.class), userName);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (userLoginDTO != null) {
			System.out.println("inputed name:" + userName + "****");
			System.out.println("query name:" + userLoginDTO.getUserName() + "****");
		}
		existed = userLoginDTO == null ? false : true;
		return existed;
	}
}
