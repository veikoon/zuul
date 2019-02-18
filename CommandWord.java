/**
 * Representations for all the valid command words for the game.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public enum CommandWord
{
    // A value for each command word, plus one for unrecognised
    // commands.
    GO("go"),
    QUIT("quit"),
    HELP("help"),
    UNKNOWN("?"),
    TAKE("take"),
    DROP("drop"),
    INV("inv"),
    EAT("eat"),
    BACK("back"),
    LOOK("look"),
    TEST("test"),
    TIME("time");
    private String aCommandString;
    
    /**
     * Initialise with the corresponding command word.
     * @param commandWord The command string.
     */
    CommandWord(String pCommandString)
    {
        this.aCommandString = pCommandString;
    }
    
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return this.aCommandString;
    }
}