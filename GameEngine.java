import java.util.*;
import java.io.*;

public class GameEngine{
    /**
     * Arguments:
     * aCurrentRoom est la salle dans laquelle se trouve le joueur en permanance
     * aParser permet de capter la commande entré par le joueur
     */
    private Parser aParser;
    private UserInterface aGui;
    private HashMap<String, Room> aRoom;
    private Player aPlayer;
    
    /**
     * Constructeur par defaut, il permet principalement de creer les salles et leurs sorties
     */
    public GameEngine(){
        this.aRoom = new HashMap<String, Room>();
        this.aParser = new Parser();
        createRooms();
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
        
        Item vCle = new Item("Ceci est une clé",1);
        Item vPorte = new Item("Ceci est une porte",100);
        Item vCookie = new Item("Ceci est un cookie magique qui augmente votre poids en inventaire",0);
        
        vManoir.setItem("cle",vCle);
        vManoir.setItem("porte",vPorte);
        vChateau.setItem("cookie",vCookie);
        
        String vPrenom = javax.swing.JOptionPane.showInputDialog( "Quel est ton prenom ?" );
        
        this.aPlayer = new Player(vManoir,vPrenom);
    }
    
    public Room getCurrentRoom(){
        return this.aPlayer.getCurrentRoom();
    }
    
    /**
     * Methode qui permet de lire le texte entre par l'utilisateur, de l'analyser et de le transposer en commande ou non
     */
    public void interpretCommand(final String pCom){
        aGui.println(pCom);
        Command vCom = this.aParser.getCommand(pCom);
        if(vCom.isUnknown()){
            this.aGui.println("I don't know what you mean...\n");
        }

        if(vCom.getCommandWord()== CommandWord.QUIT) quit(vCom);
        else if(vCom.getCommandWord()== CommandWord.GO) goRoom(vCom);
        else if(vCom.getCommandWord()== CommandWord.LOOK) look(vCom);
        else if(vCom.getCommandWord()== CommandWord.EAT) eat(vCom);
        else if(vCom.getCommandWord()== CommandWord.HELP) help();
        else if(vCom.getCommandWord()== CommandWord.BACK) back();
        else if(vCom.getCommandWord()== CommandWord.TAKE) take(vCom);
        else if(vCom.getCommandWord()== CommandWord.TEST) test(vCom);
        else if(vCom.getCommandWord()== CommandWord.INV) inventory();
        else if(vCom.getCommandWord()== CommandWord.DROP) drop(vCom);
    }
    
    /**
     * Affichage de bienvenue, est appele dans le constructeur par defaut
     */
    private void printWelcome(){
        this.aGui.println("Welcome to Tara's Adventure!\nTara's Adventure is a new, incredibly boring adventure game.\nType 'help' if you need help.");
        this.aGui.println(getCurrentRoom().getLongDescription());
        this.aGui.showImage(getCurrentRoom().getImage());
    }
    
    /**
     * Commande principale qui permet de se deplacer a travers le monde
     */
    public void goRoom(final Command pCom){
        if(!pCom.hasSecondWord()) this.aGui.println("go where ?\n");
        else{
            String vDirection = pCom.getSecondWord();
            if(getCurrentRoom().getExit(vDirection) != null) this.aPlayer.walk(pCom);
            else this.aGui.println("there is no door\n");
        }
        this.aGui.println(getCurrentRoom().getLongDescription());
        this.aGui.showImage(getCurrentRoom().getImage());
    }
    
    /**
     * Commande qui permet de resumer le but du jeu
     */
    public void help(){
        this.aGui.println("Vos commandes sont : "+this.aParser.showCommands()+"\n");
    }
    
    
    public void look(final Command pCom){
        if(pCom.hasSecondWord()){
            if(getCurrentRoom().getItemList().containsKey(pCom.getSecondWord())){
                this.aGui.println(getCurrentRoom().getItemList().getItem(pCom.getSecondWord()).getDescription());
            }
            else this.aGui.println("Look what ?\n");
        }
        else this.aGui.println(getCurrentRoom().getLongDescription());
        
    }
    
    public void eat(final Command pCom){
        if(pCom.hasSecondWord()){
            if(pCom.getSecondWord().equals("cookie")){
                if(this.aPlayer.getInventory().containsKey("cookie")){
                    this.aPlayer.setPoidsMax(10);
                    this.aGui.println("Vous avez doublé votre inventaire de taille !\n");
                    this.aPlayer.getInventory().removeItem("cookie");
                }
                else this.aGui.println("Vous n'avez pas de cookie petit coquin !\n");
            }
            else this.aGui.println("Eat what ?\n");
        }
        else this.aGui.println("You have eaten now and you are not hungry any more.\n");
    }
    
    public void inventory(){
        this.aGui.println("Vous portez : " + this.aPlayer.getInventory().getItemsString() +"\nPoids total : "+this.aPlayer.getInventory().getTotalWeight());
    }
    
    public void take(final Command pCom){
        if(!pCom.hasSecondWord()){
            this.aGui.println("Take what ?\n");
        }
        else{
            String vCom = pCom.getSecondWord();
            if(getCurrentRoom().getItemList().containsKey(vCom)) {
                if(this.aPlayer.getInventory().getTotalWeight()+this.aPlayer.getCurrentRoom().getItemList().getItem(vCom).getWeight()<this.aPlayer.getPOIDS()){
                    this.aPlayer.takeItem(vCom);
                    this.aGui.println("Vous avez bien pris : " + vCom + "\n");
                }
                else this.aGui.println("Vous ne pouvez pas prendre "+ vCom +" vous etes trop lourd !\n");
            }
            else this.aGui.println("This Item do not exist !\n");
        }
    }
    
    public void drop(final Command pCom){
        if(!pCom.hasSecondWord()) this.aGui.println("Drop what ?\n");
        else{
            String vCom = pCom.getSecondWord();
            if(this.aPlayer.getInventory().containsKey(vCom)) this.aPlayer.dropItem(vCom);
            else this.aGui.println("This Item do not exist !\n");
        }
    }
    
    public void back(){
        this.aPlayer.oops();
        this.aGui.println(getCurrentRoom().getLongDescription());
        this.aGui.showImage(getCurrentRoom().getImage());
    }
    
    public void lecture( final String pNomFichier )
    {
        Scanner vSc;
        try { // pour "essayer" les instructions suivantes
            vSc = new Scanner( new File( pNomFichier ) );
            while ( vSc.hasNextLine() ) {
                String vLigne = vSc.nextLine();
                //interpretCommand();
            } // while
        } // try
        catch ( final FileNotFoundException pFNFE ) {
            // traitement en cas d'exception
        } // catch
    }
    
    public void test(final Command pCom){
        if(!pCom.hasSecondWord()){
            this.aGui.println("Test what ?\n");
        }
        else{
            String vCom = "test/" + pCom.getSecondWord() + ".txt";
            lecture(vCom);
        }
    }
    
    /**
     * Commande primordiale qui permet de stopper le jeu
     */
    private void quit(final Command pCom){
        if(pCom.hasSecondWord()){
            this.aGui.println("Quit what ?\n");
        }
        else{
            this.aGui.println("Thank you for playing.  Good bye.");
            this.aGui.enable(false);
            System.exit(0);
        }
    }
} // Game
