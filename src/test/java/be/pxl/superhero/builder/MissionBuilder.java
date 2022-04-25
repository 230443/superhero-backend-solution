package be.pxl.superhero.builder;

import be.pxl.superhero.domain.Mission;

public final class MissionBuilder {

	public static final Long ID = 17L;
	public static final String MISSION_NAME = "Secret mission";

	private String name = MISSION_NAME;
	private boolean completed;
	private boolean deleted;

	private MissionBuilder() {
	}

	public static MissionBuilder aMission() {
		return new MissionBuilder();
	}

	public MissionBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public MissionBuilder withCompleted(boolean completed) {
		this.completed = completed;
		return this;
	}

	public MissionBuilder withDeleted(boolean deleted) {
		this.deleted = deleted;
		return this;
	}

	public Mission build() {
		Mission mission = new Mission();
		mission.setId(ID);
		mission.setName(name);
		mission.setCompleted(completed);
		mission.setDeleted(deleted);
		return mission;
	}
}
