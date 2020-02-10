package persistences;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import dto.UserLoginDTO;
import util.CommUtil;
import util.DBUtil;

public class UserLoginDAO {
	private DBUtil dbUtil;
	private Connection conn;

	public UserLoginDAO() {
		dbUtil = new DBUtil();
		conn = dbUtil.getConnection();
	}

	// 用户表数据访问
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

	// 保存用户的用户名，密码
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

	// 查看是否存在用户
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

	// 通过用户名查询 密码，用来判断密码与原密码否一致
	public UserLoginDTO queryPasswordByName(String userName) {
		UserLoginDTO userLoginDTO = new UserLoginDTO();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from p_login_t where userName=?";
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
		return userLoginDTO;
	}

	// 通过用户名修改密码
	public boolean updatePasswordByName(String userName, UserLoginDTO userLoginDTO) {
		boolean updateSuccessful = false;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();
		String sql = "update  p_login_t set passWord=? where userName=?";
		try {
			insertRows = qr.update(conn, sql, userLoginDTO.getPassWord(), userName);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		updateSuccessful = (insertRows == 0) ? false : true;
		return updateSuccessful;
	}
}