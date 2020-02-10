package dto;

public class TrainPlanManagerDTO {
	private int plan_manager_id;
	private int detailDepartId;
	private int employeeId;
	private int trainPlanId;
	private int trainScore;
	private String isFinish;
	private int trainTurnOut;
	private int turnOutScore;
	private int examScore;
	private int totalScore;

	public TrainPlanManagerDTO() {

	}

	public void setPlan_manager_id(int plan_manager_id) {
		this.plan_manager_id = plan_manager_id;
	}

	public int getPlan_manager_id() {
		return plan_manager_id;
	}

	public void setDetailDepartId(int detailDepartId) {
		this.detailDepartId = detailDepartId;
	}

	public int getDetailDepartId() {
		return detailDepartId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setTrainPlanId(int trainPlanId) {
		this.trainPlanId = trainPlanId;
	}

	public int getTrainPlanId() {
		return trainPlanId;
	}

	public void setTrainScore(int trainScore) {
		this.trainScore = trainScore;
	}

	public int getTrainScore() {
		return trainScore;
	}

	public void setIsFinish(String isFinish) {
		this.isFinish = isFinish;
	}

	public String getIsFinish() {
		return isFinish;
	}

	public void setTrainTurnOut(int trainTurnOut) {
		this.trainTurnOut = trainTurnOut;
	}

	public int getTrainTurnOut() {
		return trainTurnOut;
	}

	public void setTurnOutScore(int turnOutScore) {
		this.turnOutScore = turnOutScore;
	}

	public int getTurnOutScore() {
		return turnOutScore;
	}

	public void setExamScore(int examScore) {
		this.examScore = examScore;
	}

	public int getExamScore() {
		return examScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getTotalScore() {
		return totalScore;
	}
}
