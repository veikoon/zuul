package pkg_game;
import pkg_room.Room;
import pkg_items.ItemList;
import java.util.*;
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
    private String aPrenom;
    private Stack<Room> aBack;
    private int aPoidsMax = 5;
    private Room aRoomCharged;
    
    public Player(final Room pRoom, final String pRenom){
        this.aInventory = new ItemList();
        this.aCurrentRoom = pRoom;
        this.aPrenom = pRenom;
        this.aBack = new Stack<>();
        this.aBack.push(pRoom);
    }
    
    public Room getCurrentRoom(){
        return this.aCurrentRoom;
    }
    
    public int getPOIDS(){
        return this.aPoidsMax;
    }
    
    public ItemList getInventory(){
        return this.aInventory;
    }
    
    public Room getRoomCharged(){
        return this.aRoomCharged;
    }
    
    public void setCurrentRoom(final Room pRoom){
        this.aCurrentRoom = pRoom;
    }
    
    public void setPoidsMax(final int pInt){
        this.aPoidsMax = pInt;
    }
    
    public void setRoomCharged(final Room pRoom){
        this.aRoomCharged = pRoom;
    }
    
    public void walk(final String pCom){
        Room vNextRoom = getCurrentRoom().getExit(pCom);
        this.aBack.push(getCurrentRoom());
        this.setCurrentRoom(vNextRoom);
    }
    
    public boolean oops(){
        if(this.aCurrentRoom.isExit(this.aBack.peek())){
            this.setCurrentRoom(this.aBack.pop());
            return true;
        }
        else return false;
    }
    
    public void takeItem(final String pItem){
        this.aInventory.setItem(pItem,this.aCurrentRoom.getItem(pItem));
        this.aCurrentRoom.removeItem(pItem); 
    }
    
    public void dropItem(final String pItem){
        this.aCurrentRoom.setItem(pItem,this.aInventory.getItem(pItem));
        this.aInventory.removeItem(pItem);
    }
    
    public void charge(){
        this.aRoomCharged = this.aCurrentRoom;
    }
    
    public void fire(){
        this.aCurrentRoom = this.aRoomCharged;
        this.aRoomCharged = null;
    }
}
