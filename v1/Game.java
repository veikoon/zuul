package v1;

public class Game{
    private Room aCurrentRoom;
    private Parser aParser;
    public Game(){
        createRooms();
        this.aParser = new Parser();
    }
    
    public void play(){
        printWelcome();
        boolean vFinished = false;
        while(!vFinished){
            Command vCom = this.aParser.getCommand();
            vFinished = processCommand(vCom);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
    
    private void createRooms(){
        Room vOutside = new Room("outside the main entrance of the university");
        Room vTheatre = new Room("in a lecture theatre" );
        Room vPub = new Room("in the campus pub" );
        Room vLab = new Room("in a computing lab" );
        Room vOffice = new Room("in the computing admin office");
        Room vMain = new Room("main entrance");
        
        vMain.setExits(vOutside,vLab,vTheatre,vPub);
        vOutside.setExits(null,vMain,null,null);
        vTheatre.setExits(null,null,null,vMain);
        vPub.setExits(null,null,vMain,null);
        vLab.setExits(vMain,null,vOffice,null);
        vOffice.setExits(null,null,null,vLab);
        
        this.aCurrentRoom = vOutside;
    }

    public void goRoom(final Command pCom){
        if(!pCom.hasSecondWord()){
            System.out.println("go where ?");
            return;
        }else{
            Room vNextRoom = null;
            String vDirection = pCom.getSecondWord();
            if(this.aCurrentRoom.getExit(vDirection) != null){
                vNextRoom = this.aCurrentRoom.getExit(vDirection);
                this.aCurrentRoom = vNextRoom;
            }
            else System.out.println("there is no door");
            System.out.println("Vous etes : " + this.aCurrentRoom.getDescription());
            System.out.println("Les sorties : ");
            if(this.aCurrentRoom.getExit("north")!=null) System.out.println("north");
            if(this.aCurrentRoom.getExit("south")!=null) System.out.println("south");
            if(this.aCurrentRoom.getExit("east")!=null) System.out.println("east");
            if(this.aCurrentRoom.getExit("west")!=null) System.out.println("west");
        }
    }
    
    private void printWelcome(){
        System.out.println("Welcome to the World of Zuul!\nWorld of Zuul is a new, incredibly boring adventure game.\nType 'help' if you need help.");
        System.out.println(this.aCurrentRoom.getDescription());
        System.out.println("Exits: south");
    }
    
    private void printHelp(){
        System.out.println("You are lost. You are alone.\nYou wander around at the university.\nour command words are:\n  go quit help");
    }
    
    private boolean quit(final Command pCom){
        if(pCom.hasSecondWord()){
            System.out.println("Quit what ?");
            return false;
        }
        else return true;
    }
    
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
