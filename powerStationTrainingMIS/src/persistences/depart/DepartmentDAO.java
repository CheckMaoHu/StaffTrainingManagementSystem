package persistences.depart;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dto.DepartDTO;
import dto.HighDepartDTO;
import util.DBUtil;

public class DepartmentDAO {

	private Connection conn;
	private DBUtil dbUtil;

	public DepartmentDAO() {
		dbUtil = new DBUtil();
		conn = dbUtil.getConnection();
	}

	// ͨ������Ͳ��ű�Ų�ѯ
	public List<DepartDTO> queryDepartInfo(DepartDTO departDTO) {
		List<DepartDTO> allDepartInfo = new ArrayList<DepartDTO>();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from depart where departName=? and departNumber=?";
		try {
			allDepartInfo = qr.query(conn, sql, new BeanListHandler<DepartDTO>(DepartDTO.class),
					departDTO.getDepartName(), departDTO.getDepartNumber());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allDepartInfo;
	}

	// ͨ�������ѯ��
	public List<DepartDTO> queryDepartByClass(DepartDTO departDTO) {
		List<DepartDTO> allDepartInfo = new ArrayList<DepartDTO>();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from depart where departName=?";
		try {
			allDepartInfo = qr.query(conn, sql, new BeanListHandler<DepartDTO>(DepartDTO.class),
					departDTO.getDepartName());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allDepartInfo;
	}

	// ͨ�����źŲ�ѯ��
	public List<DepartDTO> queryDepartByDepartNumber(DepartDTO departDTO) {
		List<DepartDTO> allDepartInfo = new ArrayList<DepartDTO>();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from depart where departNumber=?";
		try {
			allDepartInfo = qr.query(conn, sql, new BeanListHandler<DepartDTO>(DepartDTO.class),
					departDTO.getDepartNumber());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allDepartInfo;
	}

	// ͨ��id����ɾ��
	public boolean deleteDepartInfo(int departId) {
		boolean deleteSuccessful = false;
		int deleteRows = 0;
		QueryRunner qr = new QueryRunner();
		String sql = "delete from depart where departId=?";
		try {
			deleteRows = qr.update(conn, sql, departId);
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

	// ��ӻ����¼�������Ϣ
	public boolean saveDepartInfo(DepartDTO departDTO) {
		boolean savaSuccessful = false;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();
		String sql = "insert into depart (highDepartName,departName,departNumber,departRemark,highDepartNumber,departTelephone) value (?,?,?,?,?,?)";
		try {
			insertRows = qr.update(conn, sql, departDTO.getHighDepartName(), departDTO.getDepartName(),
					departDTO.getDepartNumber(), departDTO.getDepartRemark(), departDTO.getHighDepartNumber(),
					departDTO.getDepartTelephone());

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

	// ��ѯ����������Ϣ,ͨ��id
	public DepartDTO queryAllDepartInfo(int id) {
		DepartDTO allDepartInfo = new DepartDTO();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from depart where departId=?";
		try {
			allDepartInfo = qr.query(conn, sql, new BeanHandler<DepartDTO>(DepartDTO.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allDepartInfo;
	}

	// ���²�����Ϣid
	public boolean updateAllDepartById(int id, DepartDTO departDTO) {
		boolean updateSuccessful = false;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();
		String sql = "update depart set departName=?,departNumber=?,departRemark=? where departId=?";
		try {
			insertRows = qr.update(conn, sql, departDTO.getDepartName(), departDTO.getDepartNumber(),
					departDTO.getDepartRemark(), id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		updateSuccessful = (insertRows == 1) ? true : false;
		return updateSuccessful;
	}

	// ��ѯ�ϼ����Ų���������Ϣ
	public List<HighDepartDTO> queryAllInfoHighByNo() {
		List<HighDepartDTO> depart = new ArrayList<HighDepartDTO>();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from highdepart";
		try {
			depart = qr.query(conn, sql, new BeanListHandler<HighDepartDTO>(HighDepartDTO.class));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return depart;
	}

	// ��ѯ�Ӳ�����Ϣ
	public List<DepartDTO> queryAllInfoChildByNo() {
		List<DepartDTO> depart = new ArrayList<DepartDTO>();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from depart";
		try {
			depart = qr.query(conn, sql, new BeanListHandler<DepartDTO>(DepartDTO.class));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return depart;
	}

	// ��ѯ�ϼ����ű��ͨ������
	public HighDepartDTO queryHighDepartByName(String highDepartName) {
		HighDepartDTO highDepartDTO = new HighDepartDTO();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from highdepart where highDepartName=?";
		try {
			highDepartDTO = qr.query(conn, sql, new BeanHandler<HighDepartDTO>(HighDepartDTO.class), highDepartName);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return highDepartDTO;
	}

	public List<DepartDTO> queryDepartByName(String DepartName) {
		List<DepartDTO> departDTO = new ArrayList<DepartDTO>();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from depart where highDepartName=?";
		try {
			departDTO = qr.query(conn, sql, new BeanListHandler<DepartDTO>(DepartDTO.class), DepartName);
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

	// ͨ�����źŲ�ѯ�ϼ�����
	public DepartDTO queryHighDepartByDepartNumber(String departNumber) {
		DepartDTO departDTO = new DepartDTO();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from depart where DepartName=?";
		try {
			departDTO = qr.query(conn, sql, new BeanHandler<DepartDTO>(DepartDTO.class), departNumber);
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

	// ͨ�����źŲ�ѯ��������
	public DepartDTO queryDepartNameByDepartNumber(String departNumber) {
		DepartDTO departDTO = new DepartDTO();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from depart where departNumber=?";
		try {
			departDTO = qr.query(conn, sql, new BeanHandler<DepartDTO>(DepartDTO.class), departNumber);
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

	public List<DepartDTO> queryDepartByTwoName(DepartDTO departDTO) {
		List<DepartDTO> allDepartInfo = new ArrayList<DepartDTO>();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from depart where departName=? and highDepartName=?";
		try {
			allDepartInfo = qr.query(conn, sql, new BeanListHandler<DepartDTO>(DepartDTO.class),
					departDTO.getDepartName(), departDTO.getHighDepartName());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allDepartInfo;
	}

}
