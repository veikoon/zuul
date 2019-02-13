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
    
    public void setCurrentRoom(final Room pRoom){
        this.aCurrentRoom = pRoom;
    }
    
    public void setPoidsMax(final int pInt){
        this.aPoidsMax = pInt;
    }
    
    public ItemList getInventory(){
        return this.aInventory;
    }
    
    public String walk(final Command pCom){
        if(!pCom.hasSecondWord()) return "go where ?\n";
        else{
            String vDirection = pCom.getSecondWord();
            if(getCurrentRoom().getExit(vDirection) != null){
                Room vNextRoom = getCurrentRoom().getExit(vDirection);
                this.aBack.push(getCurrentRoom());
                this.setCurrentRoom(vNextRoom);
                return "";
            }else return "there is no door\n";
        }
    }
    
    public void oops(){
        this.setCurrentRoom(this.aBack.pop());
    }
    
    public void takeItem(final String pItem){
        this.aInventory.setItem(pItem,this.aCurrentRoom.getItem(pItem));
        this.aCurrentRoom.removeItem(pItem); 
    }
    
    public void dropItem(final String pItem){
        this.aCurrentRoom.setItem(pItem,this.aInventory.getItem(pItem));
        this.aInventory.removeItem(pItem);
    }
}
