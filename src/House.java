import java.util.ArrayList;
import java.util.List;

public class House {
    private List<Room> rooms;

    public House() 
    {
        rooms = new ArrayList<>();
        rooms.add(new Room("Kitchen"));
        rooms.add(new Room("Living Area"));
        rooms.add(new Room("Dining Area"));
        rooms.add(new Room("Bedroom"));
        rooms.add(new Room("Washroom"));
        rooms.add(new Room("Corridors"));
    }

    public Room getRoom(String roomName) {
        for (Room room : rooms) {
            if (room.getType().equalsIgnoreCase(roomName)) {
                return room;
            }
        }
        return null; 
    }

    public void listRooms() {
        System.out.println("Rooms available in the house:");
        for (Room room : rooms) {
            System.out.println(" - " + room.getType());
        }
    }
}
