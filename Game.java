import java.util.*;
public class Game{
    /**
     * Arguments:
     * aCurrentRoom est la salle dans laquelle se trouve le joueur en permanance
     * aParser permet de capter la commande entré par le joueur
     */
    private Room aCurrentRoom;
    private Parser aParser;
    private HashMap<String, Room> aRoom;
    
    /**
     * Constructeur par defaut, il permet principalement de creer les salles et leurs sorties
     */
    public Game(){
        this.aRoom = new HashMap<String, Room>();
        createRooms();
        this.aParser = new Parser();
        play();
    }
    
    /**
     * Methode principale du jeu elle permet d'initialiser le début du jeu
     */
    public void play(){
        printWelcome();
        boolean vFinished = false;
        while(!vFinished){
            Command vCom = this.aParser.getCommand();
            vFinished = processCommand(vCom);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
    
    /**
     * Methode qui permet de creer toutes les salles et leurs sorties (est appele dans le constructeur par defaut)
     */
    private void createRooms(){
        
        Room vManoir = new Room("au manoir des Duncan");
        Room vJardin = new Room("dans les jardins du manoir" );
        Room vChateau = new Room("dans le chateau des XXTantation" );
        Room vPalais = new Room("dans le Palais" );
        Room vCours = new Room("dans la cours du palais");
        Room vCouloir = new Room("dans le couloir principal");
        Room vBureau = new Room("dans le bureau de Maitre Chem");
        Room vCave = new Room("dans la cave personnel de Maitre Chem");
        Room vDortoir = new Room("dans les dortoirs");

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
    private boolean processCommand(final Command pCom){
        boolean vWantToQuit = false;
        if(!pCom.isUnknown()){
            System.out.println("I don't know what you mean...");
            return false;
        }
        else{
            if(pCom.getCommandWord().equals("quit")) return quit(pCom);
            else if(pCom.getCommandWord().equals("go")) goRoom(pCom);
            else if(pCom.getCommandWord().equals("look")) look();
            else if(pCom.getCommandWord().equals("eat")) eat();
            else if(pCom.getCommandWord().equals("help")) printHelp();
            return vWantToQuit;
        }
    }
    
    /**
     * Affichage de bienvenue, est appele dans le constructeur par defaut
     */
    private void printWelcome(){
        System.out.println("Welcome to Tara's Adventure!\nTara's Adventure is a new, incredibly boring adventure game.\nType 'help' if you need help.");
        System.out.println(this.aCurrentRoom.getLongDescription());
    }
    
    /**
     * Commande qui permet de resumer le but du jeu
     */
    private void printHelp(){
        System.out.println("Vos commandes sont :");
        this.aParser.showCommands();
    }
    
    /**
     * Commande principale qui permet de se deplacer a travers le monde
     */
    public void goRoom(final Command pCom){
        if(!pCom.hasSecondWord()){
            System.out.println("go where ?");
            return;
        }else{
            String vDirection = pCom.getSecondWord();
            if(this.aCurrentRoom.getExit(vDirection) != null){
                Room vNextRoom = this.aCurrentRoom.getExit(vDirection);
                this.aCurrentRoom = vNextRoom;
            }
            else System.out.println("there is no door");
        }
        System.out.println(this.aCurrentRoom.getLongDescription());
    }
    
    public void look(){
        System.out.println(this.aCurrentRoom.getLongDescription());
    }
    
    public void eat(){
        System.out.println("You have eaten now and you are not hungry any more.");
    }
    
    /**
     * Commande primordiale qui permet de stopper le jeu
     */
    private boolean quit(final Command pCom){
        if(pCom.hasSecondWord()){
            System.out.println("Quit what ?");
            return false;
        }
        else return true;
    }
    
    
} // Game
