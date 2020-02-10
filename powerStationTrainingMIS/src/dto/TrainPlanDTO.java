package dto;

import java.util.Date;

public class TrainPlanDTO {

	private int planId;
	private String planName;
	private Date planStartTime;
	private Date planEndTime;
	private Date planCreateTime;
	private String planTrainType;
	private String planYear;
	private String planPerformance;

	public TrainPlanDTO() {

	}

	public String toString() {
		String format = "planId:%s,planName:%s,planStartTime:%s,planEndTime:%s,planCreateTime:%s,planTrainType:%s"
				+ "planYear:%s,performance:%s";
		String result = String.format(format, this.planId, this.planName, this.planStartTime, this.planEndTime,
				this.planCreateTime, this.planTrainType, this.planYear, this.planPerformance);
		return result;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Date getPlanStartTime() {
		return planStartTime;
	}

	public void setPlanStartTime(Date planStartTime) {
		this.planStartTime = planStartTime;
	}

	public Date getPlanEndTime() {
		return planEndTime;
	}

	public void setPlanEndTime(Date planEndTime) {
		this.planEndTime = planEndTime;
	}

	public Date getPlanCreateTime() {
		return planCreateTime;
	}

	public void setPlanCreateTime(Date planCreateTime) {
		this.planCreateTime = planCreateTime;
	}

	public String getPlanTrainType() {
		return planTrainType;
	}

	public void setPlanTrainType(String planTrainType) {
		this.planTrainType = planTrainType;
	}

	public String getPlanYear() {
		return planYear;
	}

	public void setPlanYear(String planYear) {
		this.planYear = planYear;
	}

	public String getPlanPerformance() {
		return planPerformance;
	}

	public void setPlanPerformance(String planPerformance) {
		this.planPerformance = planPerformance;
	}

}
