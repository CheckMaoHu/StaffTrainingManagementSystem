package persistences.employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dto.DepartDTO;
import dto.employeeDTO;
import util.DBUtil;

public class employeeDAO {

	private Connection conn;
	private DBUtil dbUtil;

	public employeeDAO() {
		dbUtil = new DBUtil();
		conn = dbUtil.getConnection();
	}

	// �ϼ����ű�ź��¼����Ž��в�ѯ��ʵ�ʲ��ű��
	public DepartDTO QueryDepartNumber(String highDepartNumber, String departName) {
		QueryRunner qr = new QueryRunner();
		DepartDTO departDTO = new DepartDTO();
		String sql = "select departNumber from depart where highDepartName=? and departName=?";
		try {
			departDTO = qr.query(conn, sql, new BeanHandler<DepartDTO>(DepartDTO.class), highDepartNumber, departName);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return departDTO;
	}

	// ��������
	public boolean insertEmployeeInfo(employeeDTO employerDTO) {
		boolean savaSuccessful = false;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();
		String sql = "insert into employee_t(employeeName,employeeCardId,employeeBirthday,departNumber,employeeDuty,employeePost,employeeNativePlace,employeeTelephone,employeeNumber,employeeSex) value (?,?,?,?,?,?,?,?,?,?)";
		try {
			insertRows = qr.update(conn, sql, employerDTO.getEmployeeName(), employerDTO.getEmployeeCardId(),
					employerDTO.getEmployeeBirthday(), employerDTO.getDepartNumber(), employerDTO.getEmployeeDuty(),
					employerDTO.getEmployeePost(), employerDTO.getEmployeeNativePlace(),
					employerDTO.getEmployeeTelephone(), employerDTO.getEmployeeNumber(), employerDTO.getEmployeeSex());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		savaSuccessful = (insertRows == 1) ? true : false;
		return savaSuccessful;
	}

	// ͨ��������Ա����Ų�ѯ
	public List<employeeDTO> queryAllEmployeeInfo(employeeDTO employerDTO) {
		List<employeeDTO> allEmployeeInfo = new ArrayList<employeeDTO>();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from employee_t where employeeName=? and employeeSex=?";
		try {
			allEmployeeInfo = qr.query(conn, sql, new BeanListHandler<employeeDTO>(employeeDTO.class),
					employerDTO.getEmployeeName(), employerDTO.getEmployeeSex());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allEmployeeInfo;
	}

	// ͨ��������ѯ
	public List<employeeDTO> queryAllEmployeeByName(employeeDTO employerDTO) {
		List<employeeDTO> allEmployeeInfo = new ArrayList<employeeDTO>();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from employee_t where employeeName=?";
		try {
			allEmployeeInfo = qr.query(conn, sql, new BeanListHandler<employeeDTO>(employeeDTO.class),
					employerDTO.getEmployeeName());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allEmployeeInfo;
	}

	// ͨ��Ա����Ų�ѯ
	public List<employeeDTO> queryAllEmployeeByEmployeeNumber(employeeDTO employerDTO) {
		List<employeeDTO> allEmployeeInfo = new ArrayList<employeeDTO>();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from employee_t where employeeSex=?";
		try {
			allEmployeeInfo = qr.query(conn, sql, new BeanListHandler<employeeDTO>(employeeDTO.class),
					employerDTO.getEmployeeSex());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allEmployeeInfo;
	}

	// ͨ�����ű�Ų�ѯ���
	public DepartDTO queryDepartName(String employerDTO) {
		DepartDTO departDTO = new DepartDTO();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from depart where departNumber=?";
		try {
			departDTO = qr.query(conn, sql, new BeanHandler<DepartDTO>(DepartDTO.class), employerDTO);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return departDTO;
	}

//ͨ��idɾ����Ϣ
	public boolean deleteEmployeeInfo(int employeeId) {
		boolean deleteSuccessful = false;
		int deleteRows = 0;
		QueryRunner qr = new QueryRunner();
		String sql = "delete from employee_t where employeeId=?";
		try {
			deleteRows = qr.update(conn, sql, employeeId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		deleteSuccessful = (deleteRows == 0) ? false : true;
		return deleteSuccessful;
	}

//ͨ��id,��ѯ������Ϣ
	public employeeDTO QueryEmployeeALLInfoById(int employeeId) {
		employeeDTO employerDTO = new employeeDTO();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from employee_t where employeeId=?";
		try {
			employerDTO = qr.query(conn, sql, new BeanHandler<employeeDTO>(employeeDTO.class), employeeId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employerDTO;
	}

	// ����Ա����Ϣͨ��id
	public boolean updateEmployeeinfo(int employeeId, employeeDTO employerDTO) {
		boolean updateSuccessful = false;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();
		String sql = "update employee_t set employeeName=?,employeeCardId=?,employeeBirthday=?,departNumber=?,employeeDuty=?,"
				+ "employeePost=?,employeeNativePlace=?,employeeTelephone=?,employeeNumber=?,employeeSex=? where employeeId=?";
		try {
			insertRows = qr.update(conn, sql, employerDTO.getEmployeeName(), employerDTO.getEmployeeCardId(),
					employerDTO.getEmployeeBirthday(), employerDTO.getDepartNumber(), employerDTO.getEmployeeDuty(),
					employerDTO.getEmployeePost(), employerDTO.getEmployeeNativePlace(),
					employerDTO.getEmployeeTelephone(), employerDTO.getEmployeeNumber(), employerDTO.getEmployeeSex(),
					employeeId);
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

	// �ж�Ա�������Ƿ����
	public employeeDTO queryEmployeeNumberIsExist(String employeeNumber) {
		boolean queryIsExist = false;
		employeeDTO employerDTO = new employeeDTO();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from employee_t where employeeNumber=?";
		try {
			employerDTO = qr.query(conn, sql, new BeanHandler<employeeDTO>(employeeDTO.class), employeeNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employerDTO;
	}

	// �ж�Ա�����֤���Ƿ񱻱��˰󶨹�
	public employeeDTO queryCardIdIsExist(String employeeCardId) {
		boolean queryCardIdIsExist = false;
		employeeDTO employerDTO = new employeeDTO();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from employee_t where employeeCardId=?";
		try {
			employerDTO = qr.query(conn, sql, new BeanHandler<employeeDTO>(employeeDTO.class), employeeCardId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employerDTO;
	}

	// ��ѯ���ű��Ƕ�ײ�ѯ
	public DepartDTO queryDepartNumberWhere(String departNumber, String departName) {
		DepartDTO departDTO = new DepartDTO();
		DepartDTO departDTO_1 = new DepartDTO();
		QueryRunner qr = new QueryRunner();
		String sql = "select highDepartNumber from depart where departNumber=?";
		try {
			departDTO = qr.query(conn, sql, new BeanHandler<DepartDTO>(DepartDTO.class), departNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql_1 = "select departNumber from depart where departName=? and highDepartNumber=?";
		try {
			departDTO_1 = qr.query(conn, sql_1, new BeanHandler<DepartDTO>(DepartDTO.class), departName,
					departDTO.getHighDepartNumber());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return departDTO_1;
	}

	public List<employeeDTO> queryEmployeeInfoByNo() {
		List<employeeDTO> employerDTO = new ArrayList<employeeDTO>();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from employee_t ";
		try {
			employerDTO = qr.query(conn, sql, new BeanListHandler<employeeDTO>(employeeDTO.class));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employerDTO;
	}

}
