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
        aValidCommands = new HashMap<String, CommandWord>();
        aValidCommands.put("go", CommandWord.GO);
        aValidCommands.put("help", CommandWord.HELP);
        aValidCommands.put("quit", CommandWord.QUIT);
        aValidCommands.put("look", CommandWord.LOOK);
        aValidCommands.put("eat", CommandWord.EAT);
        aValidCommands.put("inventory", CommandWord.INV);
        aValidCommands.put("take", CommandWord.TAKE);
        aValidCommands.put("back", CommandWord.BACK);
        aValidCommands.put("test", CommandWord.TEST);
        aValidCommands.put("drop", CommandWord.DROP);
    } // CommandWords()
    
    public CommandWord getCommandWord(final String pCommandWord){
        CommandWord command = aValidCommands.get(pCommandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
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
