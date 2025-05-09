public class TV extends Device implements Switchable, Entertainment {
    private int channel;
    private int volume;

    public TV(String id, String name, int channel, int volume) {
        super(id, name);
        this.channel = channel;
        this.volume = volume;
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

    public void changeChannel(int newChannel) {
        this.channel = newChannel;
        System.out.println("TV channel set to " + channel);
    }

    @Override
    public void play() {
        System.out.println("TV is playing.");
    }

    @Override
    public void pause() {
        System.out.println("TV is paused.");
    }

    @Override
    public void volumeUp() {
        volume++;
        System.out.println("TV volume increased to " + volume);
    }

    @Override
    public void volumeDown() {
        volume--;
        System.out.println("TV volume decreased to " + volume);
    }

    @Override
    public void getStatus() {
        System.out.println("TV [ID: " + id + "] - Status: " + (isOn ? "ON" : "OFF") + ", Channel: " + channel + ", Volume: " + volume);
    }
}
