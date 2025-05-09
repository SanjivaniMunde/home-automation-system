import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        House house = new House();

        while (true) {
        	System.out.println("\n---Home Automation System---");
 
            System.out.println("\nSelect a room to manage:");
            house.listRooms();
            System.out.println("\nEnter the room name (or type 'exit' to quit): ");
            String selectedRoom = scanner.nextLine();

            if (selectedRoom.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program.");
                break;
            }

            Room room = house.getRoom(selectedRoom);
            if (room == null) {
                System.out.println("Invalid room name! Please try again.");
                continue;
            }

            while (true) {
                System.out.println("\nManaging " + room.getType() + ":");
                System.out.println("1. Show all devices");
                System.out.println("2. Add device");
                System.out.println("3. Remove device");
                System.out.println("4. Toggle device ON/OFF");
                System.out.println("5. Show device status");
                System.out.println("6. Go back to room selection");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        room.listDevices();
                        break;
                    case 2:
                        System.out.print("Enter device type (Light/AC/TV/Shower): ");
                        String type = scanner.nextLine();
                        System.out.print("Enter device ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter device name: ");
                        String name = scanner.nextLine();

                        if (type.equalsIgnoreCase("Light")) {
                            System.out.print("Enter intensity: ");
                            int intensity = scanner.nextInt();
                            room.addDevice(new Light(id, name, intensity));
                        } else if (type.equalsIgnoreCase("AC")) {
                            System.out.print("Enter temperature: ");
                            float temp = scanner.nextFloat();
                            scanner.nextLine(); // Consume newline
                            System.out.print("Enter mode: ");
                            String mode = scanner.nextLine();
                            room.addDevice(new AC(id, name, temp, mode));
                        } else if (type.equalsIgnoreCase("TV")) {
                            System.out.print("Enter channel: ");
                            int channel = scanner.nextInt();
                            System.out.print("Enter volume: ");
                            int volume = scanner.nextInt();
                            room.addDevice(new TV(id, name, channel, volume));
                        } else if (type.equalsIgnoreCase("Shower")) {
                            System.out.print("Enter temperature: ");
                            float temp = scanner.nextFloat();
                            room.addDevice(new Shower(id, name, temp));
                        } else {
                            System.out.println("Invalid device type!");
                        }
                        break;
                    case 3:
                        System.out.print("Enter device ID to remove: ");
                        String removeId = scanner.nextLine();
                        room.removeDevice(removeId);
                        break;
                    case 4:
                        System.out.print("Enter device ID to toggle: ");
                        String toggleId = scanner.nextLine();
                        room.toggleDevice(toggleId);
                        break;
                    case 5:
                        room.displayDeviceStatus();
                        break;
                    case 6:
                        System.out.println("Returning to room selection.");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }

                if (choice == 6) break;
            }
        }

        scanner.close();
    }
}
