public class Light extends Device implements Switchable {
    private int intensity;

    public Light(String id, String name, int intensity) {
        super(id, name);
        this.intensity = intensity;
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

    public void adjustIntensity(int newIntensity) {
        this.intensity = newIntensity;
        System.out.println("Light intensity set to " + intensity);
    }

    @Override
    public void getStatus() {
        System.out.println("Light [ID: " + id + "] - Status: " + (isOn ? "ON" : "OFF") + ", Intensity: " + intensity);
    }
}
