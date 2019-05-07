package pkg_commands;
import pkg_game.Player;

public abstract class Command
{
    private CommandWord aCommandWord;
    private String aSecondWord;
    private String aThirdWord;

    /**
         * Constructeur
         */
    public Command()
    {
    }//command natural


    /**
         * getCommandWord () : Renvoi la commande
         * @return Premier mot de commande
         */
    public CommandWord getCommandWord()
    {
        return this.aCommandWord;
    }//getCommandWord

    /**
         * getSecondWord() : Renvoi le second mot de la commande
         * @return Second mot de la commande
         */
    public String getSecondWord()
    {
        return this.aSecondWord;
    }//getSecondWord

    /**
      * setSecondWord : règle aSecondWord
      */
    public void setSecondWord(final String pSecondWord){
      this.aSecondWord = pSecondWord;
    }//setSecondWord

    /**
         * hasSecondWord()
         * @return Renvoi true/false si la commande à un second mot
         */
    public boolean hasSecondWord()
    {
        if(this.aSecondWord == null){
            return false;
        }
        else{
            return true;
        }
    }//hasSecondWord

        /**
         * isUnknown()
         * @return Renvoi true/false si la commande est inconnu
         */
    public boolean isUnknown()
    {
        return (aCommandWord == CommandWord.UNKNOWN);
    }//isUnknown

    /**
     * Exécute la commande. Renvoi un flag d'exécution au jeu
     * @return True, true si le jeu continue, false sinon
     */
    public abstract void execute(Player player);

} // Command
