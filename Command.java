public class Command{
    private CommandWord aCommandWord;
    private String aSecondWord;
    
    public Command(final CommandWord pCom, final String pCom2){
        this.aCommandWord = pCom;
        this.aSecondWord = pCom2;
    }
    
    public CommandWord getCommandWord(){
        return this.aCommandWord;
    }
    
    public String getSecondWord(){
        return this.aSecondWord;
    }
    
    public boolean hasSecondWord(){
        return this.getSecondWord() != null;
    }
    
    public boolean isUnknown(){
        return (aCommandWord == CommandWord.UNKNOWN);
    }
} // Command
