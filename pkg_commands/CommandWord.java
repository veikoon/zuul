package pkg_commands;
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
    GO("go", new GoCommand()),
    QUIT("quit", new QuitCommand()),
    HELP("help", new HelpCommand()),
    UNKNOWN("?", new UnknownCommand()),
    TAKE("take", new TakeCommand()),
    DROP("drop", new DropCommand()),
    INV("inv", new InvCommand()),
    EAT("eat", new EatCommand()),
    BACK("back", new BackCommand()),
    LOOK("look", new LookCommand()),
    TEST("test", new TestCommand()),
    TIME("time", new TimeCommand()),
    CHARGE("charge", new ChargeCommand()),
    FIRE("fire", new FireCommand());
    private String aCommandString;
    private Command aCommand;
    /**
     * Initialise with the corresponding command word.
     * @param commandWord The command string.
     */
    CommandWord(String pCommandString, Command pCommand)
    {
        this.aCommandString = pCommandString;
        this.aCommand = pCommand;
    }
    
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return this.aCommandString;
    }
    
    /**
     * @return La Command
     */
    public Command getCommand()
    {
       return this.aCommand;
    }
}