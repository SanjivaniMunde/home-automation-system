public class AC extends Device implements Switchable, Control {
    private float temperature;
    private String mode;

    public AC(String id, String name, float temperature, String mode) {
        super(id, name);
        this.temperature = temperature;
        this.mode = mode;
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
        System.out.println("AC temperature set to " + temperature);
    }

    public void setMode(String newMode) {
        this.mode = newMode;
        System.out.println("AC mode set to " + mode);
    }

    @Override
    public void tempUp() {
        temperature++;
        System.out.println("AC temperature increased to " + temperature);
    }

    @Override
    public void tempDown() {
        temperature--;
        System.out.println("AC temperature decreased to " + temperature);
    }

    @Override
    public void speedUp() {}

    @Override
    public void speedDown() {}

    @Override
    public void getStatus() {
        System.out.println("AC [ID: " + id + "] - Status: " + (isOn ? "ON" : "OFF") + ", Temp: " + temperature + ", Mode: " + mode);
    }
}
