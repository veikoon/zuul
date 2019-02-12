
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    private ItemList aInventory;
    private Room aCurrentRoom;
    
    public Player(final Room pRoom){
        this.aInventory = new ItemList();
        this.aCurrentRoom = pRoom;
    }
    
    public Room getCurrentRoom(){
        return this.aCurrentRoom;
    }
    
    public void setCurrentRoom(final Room pRoom){
        this.aCurrentRoom = pRoom;
    }
    
    public ItemList getInventory(){
        return this.aInventory;
    }
    
    public void takeItem(final Item pItem){
        
    }
    
}
