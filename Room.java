import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Enumeration;

public class Room{
    /**
     * Arguments:
     * aDescription stoque la description de ce lieu
     * aExit stoque l'ensemble des sorties disponnibles depuis ce lieu
     */
    private String aDescription;
    private String aImage;
    HashMap<String, Door> aExits;
    private ItemList aItems;
    
    /**
     * Constructeur a un parametre permet d'initialiser la hashmap pour les sorties et de donner la description au bon argument
     */
    public Room(final String pDes, final String pIm){
        this.aDescription = pDes;
        this.aExits = new HashMap<String, Door>();
        this.aImage = pIm;
        this.aItems = new ItemList();
    }
    
    /**
     * Fonction qui permet de retourner la sortie disponnible a la direction donnee
     * @param pDir : La direction dans laquelle on veut connaitre la sortie
     */
    public Room getExit(final String pDir){
        return this.aExits.get(pDir).nextRoom();
    }
    
    public Door getDoor(final String pDir){
        return this.aExits.get(pDir);
    }
    
    /**
     * Accesseur de l'argument aDescription
     */
    public String getDescription(){
        return this.aDescription;
    }
    
    /**
     * Fonction qui retourn l'ensemble des cles d'une hashmap
     */
    private String getHashMap(final HashMap pMap){
        String vReturn = "";
        Set<String> vKeys = pMap.keySet();
        for(String vObj : vKeys){
            vReturn += " "+vObj;
        }
        return vReturn;
    }
    
    public String getLongDescription(){
        return "Vous etes : " + this.aDescription + "\nLes objets disponnibles sont : " + this.aItems.getItemsString() + "\nLes sorties disponibles sont : " + getHashMap(this.aExits) + "\n";
    }
    
    public String getImage(){
        return this.aImage;
    }
    
    public ItemList getItemList(){
        return this.aItems;
    }
    
    public Item getItem(final String pItem){
        return this.aItems.getItem(pItem);
    }
    
    public void removeItem(final String pName){
        this.aItems.removeItem(pName);
    }
    
        /**
     * Methode qui permet d'ajouter les sorties dans la hashmap
     */
    public void setExits(final String pDir, final Door pNext){
        this.aExits.put(pDir, pNext);
    }
    
    public void setItem(final String pName, final Item pItem){
        this.aItems.setItem(pName,pItem);
    }
    
    public boolean isExit(final Room pRoom){
        boolean vTemp = false;
        Set cles = aExits.keySet();
        Iterator it = cles.iterator();
        while (it.hasNext()){
           Object cle = it.next();
           Door valeur = aExits.get(cle);
           if(valeur.nextRoom()==pRoom) vTemp = true;
        }
        return vTemp;
    }
} // Room
