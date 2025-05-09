import java.util.ArrayList;

public class Room {
    private String type;
    private ArrayList<Device> devices;

    public Room(String type) 
    {
        this.type = type;
        this.devices = new ArrayList<>();
    }
    public String getType() {
        return type;
    }

    public void addDevice(Device device) {
        devices.add(device);
        System.out.println(device.name + " has been added to the " + type + " room.");
    }

    public void removeDevice(String id) {
        devices.removeIf(device -> device.getId().equals(id));
        System.out.println("Device with ID " + id + " has been removed from the " + type + " room.");
       
    }

    public void listDevices() {
        if (devices.isEmpty()) {
            System.out.println("No devices found in the " + type + " room.");
        } else {
            System.out.println("Devices in the " + type + " room:");
            for (Device device : devices) {
                System.out.println(" - " + device.name + " (ID: " + device.getId() + ")");
            }
        }
    }

    public Device getDeviceById(String id) {
        for (Device device : devices) {
            if (device.getId().equals(id)) {
                return device;
            }
        }
        System.out.println("Device with ID " + id + " not found.");
        return null;
    }

    public void toggleDevice(String id) {
        Device device = getDeviceById(id);
        if (device != null) {
            if (device.isOn()) {
                device.turnOff();
            } else {
                device.turnOn();
            }
        }
    }

    public void displayDeviceStatus() {
        for (Device device : devices) {
            device.getStatus();
        }
    }
}
