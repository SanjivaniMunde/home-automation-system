public class Shower extends Device implements Switchable {
    private float temperature;

    public Shower(String id, String name, float temperature) {
        super(id, name);
        this.temperature = temperature;
    }

    @Override
    public void turnOn() {
        isOn = true;
        updateStateChange();
        System.out.println(name + " is turned ON.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        updateStateChange();
        System.out.println(name + " is turned OFF.");
    }

    public void setTemperature(float newTemp) {
        this.temperature = newTemp;
        System.out.println("Shower temperature set to " + temperature);
    }

    @Override
    public void getStatus() {
        System.out.println("Shower [ID: " + id + "] - Status: " + (isOn ? "ON" : "OFF") + ", Temp: " + temperature);
    }
}
