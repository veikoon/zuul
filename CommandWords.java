 import java.util.*;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2013.09.15
 */
public class CommandWords
{
    private HashMap<String, CommandWord> aValidCommands;
    
    /**
     * Constructeur par defaut
     */
    public CommandWords()
    {
        this.aValidCommands = new HashMap<String, CommandWord>();
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) {
                this.aValidCommands.put(command.toString(), command);
            }
        }
    } // CommandWords()
    
    public CommandWord getCommandWord(final String pCommandWord){
        CommandWord command = aValidCommands.get(pCommandWord);
        if(command != null) return command;
        else return CommandWord.UNKNOWN;
    }

    /**
     * Verifie si une String donnee fait partie des commandes valides. 
     * @param pString la String a tester
     * @return true si pString est une comande valide, false sinon
     */
    public boolean isCommand( final String pString ){
        return aValidCommands.containsKey(pString);
    }
    
    public String getCommandList(){
        String vCom = "";
        for(String command : aValidCommands.keySet()){
            vCom += command + " ";
        }
        return vCom;
    }
} // CommandWords
