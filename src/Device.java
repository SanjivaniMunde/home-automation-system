import java.time.LocalDateTime;

public abstract class Device {
    protected String id;
    protected String name;
    protected boolean isOn;
    protected LocalDateTime lastStateChange;

    public Device(String id, String name) {
        this.id = id;
        this.name = name;
        this.isOn = false;
        this.lastStateChange = LocalDateTime.now();
    }

    public abstract void getStatus();

    public void updateStateChange() {
        this.lastStateChange = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public boolean isOn() {
        return isOn;
    }

	public void turnOff() {
		
	}

	public void turnOn() {
		
		
	}
}
