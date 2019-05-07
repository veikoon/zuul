package pkg_game;

import pkg_commands.Parser;
import pkg_room.Room;
import pkg_room.Door;
import pkg_room.TransporterRoom;
import pkg_items.Item;
import pkg_commands.Command;

import java.util.*;
import java.io.*;
import java.time.*;
public class GameEngine{
    /**
     * Arguments:
     * aCurrentRoom est la salle dans laquelle se trouve le joueur en permanance
     * aParser permet de capter la commande entré par le joueur
     */
    public static Parser aParser;
    public static UserInterface aGui;
    public static Player aPlayer;
    public static double aTime;
    public HashMap<String, Room> aRoom;
    
    /**
     * Constructeur par defaut, il permet principalement de creer les salles et leurs sorties
     */
    public GameEngine(){
        this.aRoom = new HashMap<String, Room>();
        this.aParser = new Parser();
        createRooms();
        this.aTime = System.nanoTime();
    }
    
    public void setGUI(UserInterface pUserInt){
        this.aGui = pUserInt;
        printWelcome();
    }
    
    public HashMap<String, Room> getRoomList(){
        return this.aRoom;
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
        Room vTeleporteur = new TransporterRoom("Salles des teleportations","images/cave.jpg", this);
        
        this.aRoom.put("Manoir",vManoir);
        this.aRoom.put("Jardin",vJardin);
        this.aRoom.put("Chateau",vChateau);
        this.aRoom.put("Palais",vPalais);
        this.aRoom.put("Cours",vCours);
        this.aRoom.put("Couloir",vCouloir);
        this.aRoom.put("Bureau",vBureau);
        this.aRoom.put("Cave",vCave);
        this.aRoom.put("Dortoir",vDortoir);

        Item vCleChateau = new Item("Ceci est la clé du chateau",1);
        Item vPorte = new Item("Ceci est une porte",100);
        Item vCookie = new Item("Ceci est un cookie magique qui augmente votre poids en inventaire",0);
        Item vBeamer = new Item("Ceci est un téléporteur",5);
     
        vManoir.setItem("cle",vCleChateau);
        vManoir.setItem("porte",vPorte);
        vChateau.setItem("cookie",vCookie);
        vBureau.setItem("beamer",vBeamer);
        
        vManoir.setExits("south",new Door(vJardin));
        vJardin.setExits("east",new Door(vChateau));
        vJardin.setExits("north",new Door(vManoir));
        vChateau.setExits("south",new Door(vPalais,vCleChateau));
        vChateau.setExits("west",new Door(vJardin,vCleChateau));
        vChateau.setExits("north", new Door(vTeleporteur));
        vPalais.setExits("south",new Door(vCouloir));
        vPalais.setExits("west",new Door(vCours));
        vPalais.setExits("north",new Door(vChateau));
        vCouloir.setExits("south",new Door(vDortoir));
        vCouloir.setExits("north",new Door(vPalais));
        vCouloir.setExits("west",new Door(vBureau));
        vDortoir.setExits("north",new Door(vCouloir));
        vBureau.setExits("east",new Door(vCouloir));
        vBureau.setExits("bas",new Door(vCave));
        vTeleporteur.setExits("tp", new Door(vTeleporteur.getExit("")));
        
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
        if ((System.nanoTime() - this.aTime) * Math.pow(10,-9)/60 >=5){
            lose();
            return;
        }
        aGui.println(pCom);
        Command vCom = this.aParser.getCommand(pCom);
        vCom.execute(aPlayer);
    }
    
    public static void showRoom(){
        GameEngine.aGui.println(GameEngine.aPlayer.getCurrentRoom().getLongDescription());
        GameEngine.aGui.showImage(GameEngine.aPlayer.getCurrentRoom().getImage());
    }
    
    /**
     * Affichage de bienvenue, est appele dans le constructeur par defaut
     */
    private void printWelcome(){
        this.aGui.println("Welcome to Tara's Adventure!\nTara's Adventure is a new, incredibly boring adventure game.\nType 'help' if you need help.");
        showRoom();
    }

    public void time(){

    }
    
    public void lose(){
        this.aGui.println("Vous avez perdu, le temps imparti est ecoule !");
        this.aGui.enable(false);
    }
} // Game
