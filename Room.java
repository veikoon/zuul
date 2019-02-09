import java.util.HashMap;

public class Room{
    /**
     * Arguments:
     * aDescription stoque la description de ce lieu
     * aExit stoque l'ensemble des sorties disponnibles depuis ce lieu
     */
    private String aDescription;
    HashMap<String, Room> aExits;
    
    /**
     * Constructeur a un parametre permet d'initialiser la hashmap pour les sorties et de donner la description au bon argument
     */
    public Room(final String pDes){
        this.aDescription = pDes;
        this.aExits = new HashMap<String, Room>();
    }
    
    /**
     * Fonction qui permet de retourner la sortie disponnible a la direction donnee
     * @param pDir : La direction dans laquelle on veut connaitre la sortie
     */
    public Room getExit(String pDir){
        return this.aExits.get(pDir);
    }
    
    /**
     * Accesseur de l'argument aDescription
     */
    public String getDescription(){
        return this.aDescription;
    }
    
    /**
     * Methode qui permet d'ajouter les sorties dans la hashmap
     */
    public void setExits(String pDir, Room pNext){
        this.aExits.put(pDir, pNext);
    }
        
    /**
     * Fonction qui retourn l'ensemble des directions dans lesquels il y a une sortie
     */
    public String getExitString(){
        String vExit = ""; 
        if(this.getExit("north")!=null) vExit += " north";
        if(this.getExit("south")!=null) vExit += " south";
        if(this.getExit("east")!=null) vExit += " east";
        if(this.getExit("west")!=null) vExit += " west";
        if(this.getExit("haut")!=null) vExit += " haut";
        if(this.getExit("bas")!=null) vExit += " bas";
        return vExit;
    }
} // Room
