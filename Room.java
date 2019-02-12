import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

public class Room{
    /**
     * Arguments:
     * aDescription stoque la description de ce lieu
     * aExit stoque l'ensemble des sorties disponnibles depuis ce lieu
     */
    private String aDescription;
    private String aImage;
    HashMap<String, Room> aExits;
    private ItemList aItems;
    
    /**
     * Constructeur a un parametre permet d'initialiser la hashmap pour les sorties et de donner la description au bon argument
     */
    public Room(final String pDes, final String pIm){
        this.aDescription = pDes;
        this.aExits = new HashMap<String, Room>();
        this.aImage = pIm;
        this.aItems = new ItemList();
    }
    
    /**
     * Fonction qui permet de retourner la sortie disponnible a la direction donnee
     * @param pDir : La direction dans laquelle on veut connaitre la sortie
     */
    public Room getExit(final String pDir){
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
    public String getHashMap(final HashMap pMap){
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
    
        /**
     * Methode qui permet d'ajouter les sorties dans la hashmap
     */
    public void setExits(final String pDir, final Room pNext){
        this.aExits.put(pDir, pNext);
    }
    
    public void setItem(final String pName, final Item pItem){
        this.aItems.setItem(pName,pItem);
    }
} // Room
