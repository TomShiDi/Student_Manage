package entity;

public class ClassInfo {

	private String id;
	
	private String name;
	
	private String monitorId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMonitorId() {
		return monitorId;
	}

	public void setMonitorId(String monitorId) {
		this.monitorId = monitorId;
	}

	@Override
	public String toString() {
		return "ClassInfo [id=" + id + ", name=" + name + ", monitorId=" + monitorId + "]";
	}
	
	
}
