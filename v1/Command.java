package v1;

public class Command{
    private String aCommandWord;
    private String aSecondWord;
    
    public Command(final String pCom, final String pCom2){
        this.aCommandWord = pCom;
        this.aSecondWord = pCom2;
    }
    
    public String getCommandWord(){
        return this.aCommandWord;
    }
    
    public String getSecondWord(){
        return this.aSecondWord;
    }
    
    public boolean hasSecondWord(){
        return this.getSecondWord() != null;
    }
    
    public boolean isUnknown(){
        return this.getCommandWord() != null;
    }
} // Command
