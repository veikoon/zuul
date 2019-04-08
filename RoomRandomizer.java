import java.util.HashMap;
import java.util.Random;
/**
 * Décrivez votre classe RoomRandomizer ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class RoomRandomizer
{
    private GameEngine aGui;
    private HashMap<String, Room> aRoom;
    
    public RoomRandomizer(final GameEngine pGui){
        this.aGui = pGui;
        this.aRoom = aGui.getRoomList();
    }
    
    public Room findRandomRoom(){
        Random generator = new Random();
        Object[] values = this.aRoom.values().toArray();
        Object randomValue = values[generator.nextInt(values.length)];
        return (Room) randomValue;
    }
}
