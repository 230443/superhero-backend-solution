package be.pxl.superhero.api;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class WorklogForm {
	private String superheroName;
	private Long missionId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private String task;

	public String getSuperheroName() {
		return superheroName;
	}

	public void setSuperheroName(String superheroName) {
		this.superheroName = superheroName;
	}

	public Long getMissionId() {
		return missionId;
	}

	public void setMissionId(Long missionId) {
		this.missionId = missionId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "WorklogForm{" +
				"superheroName='" + superheroName + '\'' +
				", mission='" + missionId + '\'' +
				", date=" + date +
				", task='" + task + '\'' +
				'}';
	}
}
