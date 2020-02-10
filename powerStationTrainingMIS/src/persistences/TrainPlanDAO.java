package persistences;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dto.TrainPlanDTO;
import dto.TrainPlanDetailDTO;
import util.DBUtil;

public class TrainPlanDAO {

	private Connection conn;
	private DBUtil dBUtil;

	public TrainPlanDAO() {
		dBUtil = new DBUtil();
		conn = dBUtil.getConnection();
	}

	// 保存培训计划基本信息表
	public boolean saveTrainPlanInfo(TrainPlanDTO trainPlanInfoDTO) {
		boolean result;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();
		String sql = "insert into train_plan_basic_info_t (planYear,planName,planStartTime,planEndTime,planCreateTime,planPerformance)"
				+ "value(?,?,?,?,?,?)";
		try {
			insertRows = qr.update(conn, sql, trainPlanInfoDTO.getPlanYear(), trainPlanInfoDTO.getPlanName(),
					trainPlanInfoDTO.getPlanStartTime(), trainPlanInfoDTO.getPlanEndTime(),
					trainPlanInfoDTO.getPlanCreateTime(), trainPlanInfoDTO.getPlanPerformance());

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
		return result;
	}

	// 查询满足条件的计划Id
	public int queryId(TrainPlanDTO trainPlanInfoDTO) {
		TrainPlanDTO tplDTO = null;
		QueryRunner qr = new QueryRunner();
		SimpleDateFormat dateToString = new SimpleDateFormat("yyyy-MM-dd");

		String planStartTime = dateToString.format(trainPlanInfoDTO.getPlanStartTime());
		String planEndTime = dateToString.format(trainPlanInfoDTO.getPlanEndTime());
		String sql = "select * from train_plan_basic_info_t where planYear=? and planName=? and planStartTime=? and planEndTime=? ";
		try {
			tplDTO = qr.query(conn, sql, new BeanHandler<TrainPlanDTO>(TrainPlanDTO.class),
					trainPlanInfoDTO.getPlanYear(), trainPlanInfoDTO.getPlanName(), planStartTime, planEndTime);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (tplDTO != null) {
			return tplDTO.getPlanId();
		} else
			return 0;
	}

//通过基本信息查询全部信息
	public List<TrainPlanDTO> queryAll(TrainPlanDTO trainPlanInfoDTO, String majorName) {
		List<TrainPlanDTO> allTrainPlans = new ArrayList<TrainPlanDTO>();
		QueryRunner qr = new QueryRunner();
		String sql = "select  train_plan_basic_info_t.planId,planName,planStartTime,planEndTime,planCreateTime,planYear,planPerformance "
				+ "from train_plan_basic_info_t,train_plan_detail_info_t where train_plan_basic_info_t.planId=train_plan_detail_info_t.planId and planName=? and planYear=? and planPerformance=? and detailMajorName=?";
		try {
			allTrainPlans = qr.query(conn, sql, new BeanListHandler<TrainPlanDTO>(TrainPlanDTO.class),
					trainPlanInfoDTO.getPlanName(), trainPlanInfoDTO.getPlanYear(),
					trainPlanInfoDTO.getPlanPerformance(), majorName);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allTrainPlans;
	}

	// 通过计划id查询详细信息
	public List<TrainPlanDetailDTO> queryTrainPlanDetailById(int id) {
		List<TrainPlanDetailDTO> allTrainPlanDetail = new ArrayList<TrainPlanDetailDTO>();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from train_plan_detail_info_t where planId=? order by detailMajorName";
		try {
			allTrainPlanDetail = qr.query(conn, sql, new BeanListHandler<TrainPlanDetailDTO>(TrainPlanDetailDTO.class),
					id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allTrainPlanDetail;
	}

	// 保存详细信息通过dto
	public boolean saveTrainPlanDetail(TrainPlanDetailDTO trainPlanDetailDTO) {
		boolean result;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();
		String sql = "insert into train_plan_detail_info_t (planId,detailMajorName,planGoal,planConcent,planClassHour,planTeacher) "
				+ "values(?,?,?,?,?,?)";
		try {
			insertRows = qr.update(conn, sql, trainPlanDetailDTO.getPlanId(), trainPlanDetailDTO.getDetailMajorName(),
					trainPlanDetailDTO.getPlanGoal(), trainPlanDetailDTO.getPlanConcent(),
					trainPlanDetailDTO.getPlanClassHour(), trainPlanDetailDTO.getPlanTeacher());
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
		return result;
	}

	public boolean deleteTrainPlanById(int id) {
		boolean result;
		int deleteRows = 0;
		QueryRunner qr = new QueryRunner();
		String sql = "delete from train_plan_basic_info_t where planId=?";
		String sqlDetail = "delete from train_plan_detail_info_t where planId=?";
		try {
			deleteRows = qr.update(conn, sql, id);
			deleteRows = qr.update(conn, sqlDetail, id) + deleteRows;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		result = (deleteRows == 0) ? false : true;
		return result;
	}

	// 修改基本信息通过id
	public boolean updateTrainInfoById(TrainPlanDTO trainPlanInfoDTO, int id) {
		boolean result;
		int updateRows = 0;
		QueryRunner qr = new QueryRunner();
		String sql = "update train_plan_basic_info_t set planName=?,planYear=?,planStartTime=?,planEndTime=?,planCreateTime=? where planId=?";
		try {
			updateRows = qr.update(conn, sql, trainPlanInfoDTO.getPlanName(), trainPlanInfoDTO.getPlanYear(),
					trainPlanInfoDTO.getPlanStartTime(), trainPlanInfoDTO.getPlanEndTime(),
					trainPlanInfoDTO.getPlanCreateTime(), id);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		result = (updateRows == 0) ? false : true;
		return result;
	}

	// 修改详细信息通过详细id
	public boolean updateTrainPlanDetail(TrainPlanDetailDTO trainPlanDetailDTO, int id, int detail_Id) {
		boolean result;
		int updateRows = 0;
		QueryRunner qr = new QueryRunner();
		String sql = "update train_plan_detail_info_t set detailMajorName=?,planGoal=?,planConcent=?,planClassHour=?,planTeacher=? where planId=? and detailId=? ";
		try {
			updateRows = qr.update(conn, sql, trainPlanDetailDTO.getDetailMajorName(), trainPlanDetailDTO.getPlanGoal(),
					trainPlanDetailDTO.getPlanConcent(), trainPlanDetailDTO.getPlanClassHour(),
					trainPlanDetailDTO.getPlanTeacher(), id, detail_Id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		result = (updateRows == 0) ? false : true;
		return result;
	}

//id查询详细信息id
	public List<TrainPlanDetailDTO> queryTrainPlanDetailInfo(int id) {
		List<TrainPlanDetailDTO> allDetailPlanId = new ArrayList<TrainPlanDetailDTO>();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from train_plan_detail_info_t where planId=?";
		try {
			allDetailPlanId = qr.query(conn, sql, new BeanListHandler<TrainPlanDetailDTO>(TrainPlanDetailDTO.class),
					id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allDetailPlanId;
	}

	// 通过id查询培训基本信息 传输对象
	public TrainPlanDTO queryTrainPlanById(int id) {
		TrainPlanDTO trainPlanInfoDTO = new TrainPlanDTO();
		QueryRunner qr = new QueryRunner();
		String sql = "select planName,planStartTime,planEndTime,planCreateTime,planYear,planPerformance from train_plan_basic_info_t where planId=?";
		try {
			trainPlanInfoDTO = qr.query(conn, sql, new BeanHandler<TrainPlanDTO>(TrainPlanDTO.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return trainPlanInfoDTO;
	}

	// 通过详细id查询详细计划信息
	public TrainPlanDetailDTO queryDetailBydetailId(int detailId) {
		TrainPlanDetailDTO trainPlanDetailDTO = new TrainPlanDetailDTO();
		QueryRunner qr = new QueryRunner();

		String sql = "select * from train_plan_detail_info_t where detailId=?";
		try {
			trainPlanDetailDTO = qr.query(conn, sql, new BeanHandler<TrainPlanDetailDTO>(TrainPlanDetailDTO.class),
					detailId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return trainPlanDetailDTO;
	}

	public List<TrainPlanDTO> queryAllTrainByNo() {
		List<TrainPlanDTO> trainPlanDTO = new ArrayList<TrainPlanDTO>();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from train_plan_basic_info_t";
		try {
			trainPlanDTO = qr.query(conn, sql, new BeanListHandler<TrainPlanDTO>(TrainPlanDTO.class));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return trainPlanDTO;
	}

	public void updateTrainPlanPerformance(TrainPlanDTO trainPlanDTO) {
		QueryRunner qr = new QueryRunner();
		String sql = "update train_plan_basic_info_t set planPerformance=? where planId=?";
		try {
			qr.update(conn, sql, trainPlanDTO.getPlanPerformance(), trainPlanDTO.getPlanId());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
