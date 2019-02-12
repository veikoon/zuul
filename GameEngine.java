import java.util.*;
public class GameEngine{
    /**
     * Arguments:
     * aCurrentRoom est la salle dans laquelle se trouve le joueur en permanance
     * aParser permet de capter la commande entré par le joueur
     */
    private Room aCurrentRoom;
    private Parser aParser;
    private UserInterface aGui;
    private HashMap<String, Room> aRoom;
    
    /**
     * Constructeur par defaut, il permet principalement de creer les salles et leurs sorties
     */
    public GameEngine(){
        this.aRoom = new HashMap<String, Room>();
        createRooms();
        this.aParser = new Parser();
    }
    
    public void setGUI(UserInterface pUserInt){
        this.aGui = pUserInt;
        printWelcome();
    }
    
    /**
     * Methode qui permet de creer toutes les salles et leurs sorties (est appele dans le constructeur par defaut)
     */
    private void createRooms(){
        
        Room vManoir = new Room("au manoir des Duncan","images/manoir.jpg");
        Room vJardin = new Room("dans les jardins du manoir","images/jardin.jpg" );
        Room vChateau = new Room("dans le chateau des XXTantation","images/chateau.jpg" );
        Room vPalais = new Room("dans le Palais","images/palais.jpg" );
        Room vCours = new Room("dans la cours du palais","images/cours.jpg");
        Room vCouloir = new Room("dans le couloir principal","images/couloir.jpg");
        Room vBureau = new Room("dans le bureau de Maitre Chem","images/bureau.jpg");
        Room vCave = new Room("dans la cave personnel de Maitre Chem","images/cave.jpg");
        Room vDortoir = new Room("dans les dortoirs","images/dortoir.jpg");

        vManoir.setExits("south",vJardin);
        vJardin.setExits("east",vChateau);
        vJardin.setExits("north",vManoir);
        vChateau.setExits("south",vPalais);
        vChateau.setExits("west",vJardin);
        vPalais.setExits("south",vCouloir);
        vPalais.setExits("west",vCours);
        vPalais.setExits("north",vChateau);
        vCouloir.setExits("south",vDortoir);
        vCouloir.setExits("north",vPalais);
        vCouloir.setExits("west",vBureau);
        vDortoir.setExits("north",vCouloir);
        vBureau.setExits("east",vCouloir);
        vBureau.setExits("bas",vCave);
        vCave.setExits("haut",vBureau);
        
        this.aRoom.put("Manoir",vManoir);
        this.aRoom.put("Jardin",vJardin);
        this.aRoom.put("Chateau",vChateau);
        this.aRoom.put("Palais",vPalais);
        this.aRoom.put("Cours",vCours);
        this.aRoom.put("Couloir",vCouloir);
        this.aRoom.put("Bureau",vBureau);
        this.aRoom.put("Cave",vCave);
        this.aRoom.put("Dortoir",vDortoir);
        
        this.aCurrentRoom = vManoir;
    }
    
    /**
     * Methode qui permet de lire le texte entre par l'utilisateur, de l'analyser et de le transposer en commande ou non
     */
    public boolean interpretCommand(final String pCom){
        aGui.println(pCom);
        Command vCom = this.aParser.getCommand(pCom);
        boolean vWantToQuit = false;
        if(!vCom.isUnknown()){
            this.aGui.println("I don't know what you mean...");
            return false;
        }

        if(vCom.getCommandWord().equals("quit")) return quit(vCom);
        else if(vCom.getCommandWord().equals("go")) goRoom(vCom);
        else if(vCom.getCommandWord().equals("look")) look();
        else if(vCom.getCommandWord().equals("eat")) eat();
        else if(vCom.getCommandWord().equals("help")) printHelp();
        return vWantToQuit;
    }
    
    /**
     * Affichage de bienvenue, est appele dans le constructeur par defaut
     */
    private void printWelcome(){
        this.aGui.println("Welcome to Tara's Adventure!\nTara's Adventure is a new, incredibly boring adventure game.\nType 'help' if you need help.");
        this.aGui.println(this.aCurrentRoom.getLongDescription());
        this.aGui.showImage(this.aCurrentRoom.getImage());
    }
    
    /**
     * Commande qui permet de resumer le but du jeu
     */
    private void printHelp(){
        this.aGui.println("Vos commandes sont :");
        this.aParser.showCommands();
    }
    
    /**
     * Commande principale qui permet de se deplacer a travers le monde
     */
    public void goRoom(final Command pCom){
        if(!pCom.hasSecondWord()){
            this.aGui.println("go where ?");
            return;
        }else{
            String vDirection = pCom.getSecondWord();
            if(this.aCurrentRoom.getExit(vDirection) != null){
                Room vNextRoom = this.aCurrentRoom.getExit(vDirection);
                this.aCurrentRoom = vNextRoom;
            }
            else this.aGui.println("there is no door");
        }
        this.aGui.println(this.aCurrentRoom.getLongDescription());
        this.aGui.showImage(this.aCurrentRoom.getImage());
    }
    
    public void look(){
        this.aGui.println(this.aCurrentRoom.getLongDescription());
    }
    
    public void eat(){
        this.aGui.println("You have eaten now and you are not hungry any more.\n");
    }
    
    /**
     * Commande primordiale qui permet de stopper le jeu
     */
    private boolean quit(final Command pCom){
        if(pCom.hasSecondWord()){
            this.aGui.println("Quit what ?");
            return false;
        }
        else return true;
    }
} // Game
