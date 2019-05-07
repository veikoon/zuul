package pkg_room;
import pkg_items.Item;
/**
 * Write a description of class Door here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Door
{
    private boolean aIsLocked;
    private Item aNeededKey;
    private Room aNextRoom;
    
    public Door(final Room pNext){
        this.aIsLocked = false;
        this.aNextRoom = pNext;
    }
    
    public Door(final Room pNext, final Item pKey){
        this.aIsLocked = true;
        this.aNextRoom = pNext;
        this.aNeededKey = pKey;
    }
    
    public boolean isLocked(){
        return this.aIsLocked;
    }
    
    public Item neededKey(){
        return this.aNeededKey;
    }
    
    public Room nextRoom(){
        return this.aNextRoom;
    }
} // Door
