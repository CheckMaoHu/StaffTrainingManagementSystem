package persistences.trainPeopleManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dto.TrainPlanDTO;
import dto.TrainPlanDetailDTO;
import dto.TrainPlanManagerDTO;
import util.DBUtil;

public class TrainPeopleManagerDAO {

	private Connection conn;
	private DBUtil dbUtil;

	public TrainPeopleManagerDAO() {
		dbUtil = new DBUtil();
		conn = dbUtil.getConnection();
	}

	// 通过planId 查询详细id 再获得 详细计划
	public List<TrainPlanDetailDTO> queryDetailByPlanId(int planId) {
		List<TrainPlanDetailDTO> trainPlandetailDTO = new ArrayList<TrainPlanDetailDTO>();
		TrainPlanDTO trainPlanDTO = new TrainPlanDTO();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from train_plan_detail_info_t where planId=?";
		try {
			trainPlandetailDTO = qr.query(conn, sql, new BeanListHandler<TrainPlanDetailDTO>(TrainPlanDetailDTO.class),
					planId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return trainPlandetailDTO;
	}

	// 保存主键 员工id+详细计划id
	public boolean saveTrainPeopleId(TrainPlanManagerDTO trainPeopleDTO) {

		boolean result = false;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();
		String sql = "insert into train_plan_manager (detailDepartId,employeeId,trainPlanId) value (?,?,?)";
		try {
			insertRows = qr.update(conn, sql, trainPeopleDTO.getDetailDepartId(), trainPeopleDTO.getEmployeeId(),
					trainPeopleDTO.getTrainPlanId());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		result = (insertRows == 0) ? false : true;
		return result;
	}

//删除主键 员工id+详细计划id
	public boolean deleteTrainPeopleId(TrainPlanManagerDTO trainPeopleDTO) {

		boolean result = false;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();
		String sql = "delete from train_plan_manager where detailDepartId=? and employeeId=?";
		try {
			insertRows = qr.update(conn, sql, trainPeopleDTO.getDetailDepartId(), trainPeopleDTO.getEmployeeId());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		result = (insertRows == 0) ? false : true;
		return result;
	}

	public List<TrainPlanManagerDTO> queryTrainPeopleBydetail(int detailS) {
		List<TrainPlanManagerDTO> trainPeopleManagerDTO = new ArrayList<TrainPlanManagerDTO>();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from train_plan_manager where detailDepartId=? ";
		try {
			trainPeopleManagerDTO = qr.query(conn, sql,
					new BeanListHandler<TrainPlanManagerDTO>(TrainPlanManagerDTO.class), detailS);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return trainPeopleManagerDTO;

	}

	// 通过planId查询人数
	public List<TrainPlanManagerDTO> queryPeopleByPlanId(int planId) {
		List<TrainPlanManagerDTO> trainPeopleDTO = new ArrayList<TrainPlanManagerDTO>();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from train_plan_manager where trainPlanId=?";
		try {
			trainPeopleDTO = qr.query(conn, sql, new BeanListHandler<TrainPlanManagerDTO>(TrainPlanManagerDTO.class),
					planId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return trainPeopleDTO;
	}

	// 通过 详细id和员工id保存成绩
	public boolean savaTrainScoreByTwoId(TrainPlanManagerDTO trainPlanManagerDTO) {
		int insertRows = 0;
		boolean result = false;
		QueryRunner qr = new QueryRunner();
		String sql = "update train_plan_manager set trainTurnOut=?,turnOutScore=?,examScore=?,totalScore=? where detailDepartId=? and employeeId=?";
		try {
			insertRows = qr.update(conn, sql, trainPlanManagerDTO.getTrainTurnOut(),
					trainPlanManagerDTO.getTotalScore(), trainPlanManagerDTO.getExamScore(),
					trainPlanManagerDTO.getTotalScore(), trainPlanManagerDTO.getDetailDepartId(),
					trainPlanManagerDTO.getEmployeeId());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		result = (insertRows == 0) ? false : true;
		return result;
	}
}
