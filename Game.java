public class Game{
    /**
     * Arguments:
     * aCurrentRoom est la salle dans laquelle se trouve le joueur en permanance
     * aParser permet de capter la commande entré par le joueur
     */
    private Room aCurrentRoom;
    private Parser aParser;
    
    /**
     * Constructeur par defaut, il permet principalement de creer les salles et leurs sorties
     */
    public Game(){
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
        
        
        this.aCurrentRoom = vManoir;
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
        printLocationInfo();
    }
    
    /**
     * Affichage de bienvenue, est appele dans le constructeur par defaut
     */
    private void printWelcome(){
        System.out.println("Welcome to the World of Zuul!\nWorld of Zuul is a new, incredibly boring adventure game.\nType 'help' if you need help.");
        System.out.println(this.aCurrentRoom.getDescription());
        printLocationInfo();
    }
    
    /**
     * Affichage des informations principales de la salle actuels, est appele a chaque deplacement
     */
    private void printLocationInfo(){
        System.out.println("Vous etes "+ this.aCurrentRoom.getDescription());
        System.out.print("Les sorties :" + this.aCurrentRoom.getExitString());
        System.out.println();
    }
    
    /**
     * Commande qui permet de resumer le but du jeu
     */
    private void printHelp(){
        System.out.println("You are lost. You are alone.\nYou wander around at the university.\nour command words are:\n  go quit help");
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
    
    /**
     * Methode qui permet de lire le texte entre par l'utilisateur, de l'analyser et de le transposer en commande ou non
     */
    private boolean processCommand(final Command pCom){
        if(!pCom.isUnknown()){
            System.out.println("I don't know what you mean...");
            return false;
        }
        else{
            if(pCom.getCommandWord().equals("quit")){
                return quit(pCom);
            }
            if(pCom.getCommandWord().equals("go")){
                goRoom(pCom);
                return false;
            }
            else return false;
        }
    }
} // Game
