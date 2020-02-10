package services.user;

import java.util.List;

import dto.TrainPlanDTO;
import dto.TrainPlanDetailDTO;
import persistences.TrainPlanDAO;

public class TrainPlan {
	public TrainPlan() {

	}

	// 保存培训计划基本信息
	public boolean saveTrainPlanInfo(TrainPlanDTO trainPlanInfoDTO) {
		return new TrainPlanDAO().saveTrainPlanInfo(trainPlanInfoDTO);
	}

	// 查询id
	public int queryId(TrainPlanDTO trainPlanInfoDTO) {
		return new TrainPlanDAO().queryId(trainPlanInfoDTO);
	}

	public List<TrainPlanDTO> queryAll(TrainPlanDTO trainPlanInfoDTO, String majorName) {
		return new TrainPlanDAO().queryAll(trainPlanInfoDTO, majorName);
	}

	public List<TrainPlanDetailDTO> queryAllPlanDetail(int id) {
		return new TrainPlanDAO().queryTrainPlanDetailById(id);
	}

	public boolean saveTrainPlanDetail(TrainPlanDetailDTO trainPlanDetailDTO) {
		return new TrainPlanDAO().saveTrainPlanDetail(trainPlanDetailDTO);
	}

	public boolean deleteTrainPlanById(int id) {
		return new TrainPlanDAO().deleteTrainPlanById(id);
	}

	// 更新基本信息
	public boolean updateTrainPlanById(TrainPlanDTO trainPlanInfoDTO, int id) {
		return new TrainPlanDAO().updateTrainInfoById(trainPlanInfoDTO, id);
	}

	// 查询详细信息id
	public List<TrainPlanDetailDTO> queryTrainDetailInfo(int id) {
		return new TrainPlanDAO().queryTrainPlanDetailInfo(id);
	}

	// 修改详细信息同过详细id
	public boolean updateTrainPlanDetail(TrainPlanDetailDTO trainPlanDetailDTO, int id, int detail_Id) {
		return new TrainPlanDAO().updateTrainPlanDetail(trainPlanDetailDTO, id, detail_Id);
	}

	// 通过id查询基本信息
	public TrainPlanDTO queryTrainPlanInfoById(int id) {
		return new TrainPlanDAO().queryTrainPlanById(id);
	}

	public TrainPlanDetailDTO queryDetailBydetailId(int detailId) {
		return new TrainPlanDAO().queryDetailBydetailId(detailId);
	}

	public List<TrainPlanDTO> queryAllTrainByNo() {
		return new TrainPlanDAO().queryAllTrainByNo();
	}

	public void updateTrainPlanPerformance(TrainPlanDTO trainPlanDTO) {
		new TrainPlanDAO().updateTrainPlanPerformance(trainPlanDTO);
	}
}
