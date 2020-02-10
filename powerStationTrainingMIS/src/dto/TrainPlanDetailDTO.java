package dto;

public class TrainPlanDetailDTO {
	private int detailId;
	private String detailMajorName;
	private String planGoal;
	private String planConcent;
	private String planClassHour;
	private String planTeacher;
	private int planId;

	public TrainPlanDetailDTO() {

	}

	public String toString() {
		String format = "planGoal:%s,planConcent:%s,planClassHour:%s,planTeacher:%s,detailMajorName:%s,detailId:%s";
		String result = String.format(format, this.planGoal, this.planConcent, this.planClassHour, this.planTeacher,
				this.detailMajorName, this.detailId);
		return result;
	}

	public String getPlanGoal() {
		return planGoal;
	}

	public void setPlanGoal(String planGoal) {
		this.planGoal = planGoal;
	}

	public String getPlanConcent() {
		return planConcent;
	}

	public void setPlanConcent(String planConcent) {
		this.planConcent = planConcent;
	}

	public String getPlanClassHour() {
		return planClassHour;
	}

	public void setPlanClassHour(String planClassHour) {
		this.planClassHour = planClassHour;
	}

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public String getDetailMajorName() {
		return detailMajorName;
	}

	public void setDetailMajorName(String detailMajorName) {
		this.detailMajorName = detailMajorName;
	}

	public String getPlanTeacher() {
		return planTeacher;
	}

	public void setPlanTeacher(String planTeacher) {
		this.planTeacher = planTeacher;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}
}
