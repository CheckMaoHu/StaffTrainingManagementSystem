package services.TrainPeopleManager;

import java.util.List;

import dto.TrainPlanDetailDTO;
import dto.TrainPlanManagerDTO;
import persistences.trainPeopleManager.TrainPeopleManagerDAO;

public class TrainPeopleManager {

	public List<TrainPlanDetailDTO> queryDetailByPlanId(int planId) {
		return new TrainPeopleManagerDAO().queryDetailByPlanId(planId);
	}

	public boolean saveTrainPeopleId(TrainPlanManagerDTO trainPeopleDTO) {
		return new TrainPeopleManagerDAO().saveTrainPeopleId(trainPeopleDTO);
	}

	public List<TrainPlanManagerDTO> queryTrainPeopleBydetail(int detailS) {
		return new TrainPeopleManagerDAO().queryTrainPeopleBydetail(detailS);
	}

	public List<TrainPlanManagerDTO> queryPeopleByPlanId(int planId) {
		return new TrainPeopleManagerDAO().queryPeopleByPlanId(planId);
	}

	public boolean savaTrainScoreByTwoId(TrainPlanManagerDTO trainPlanManagerDTO) {
		return new TrainPeopleManagerDAO().savaTrainScoreByTwoId(trainPlanManagerDTO);
	}

	public boolean deleteTrainPeopleId(TrainPlanManagerDTO trainPeopleDTO) {
		return new TrainPeopleManagerDAO().deleteTrainPeopleId(trainPeopleDTO);
	}
}
