package pkg_commands;
import pkg_game.Player;
import pkg_game.GameEngine;
/**
 * Implementation of the 'go' user command.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2011.07.31
 */
public class GoCommand extends Command
{
    /**
     * Constructor for objects of class GoCommand
     */
    public GoCommand()
    {
    }

    /**
     * Commande principale qui permet de se deplacer a travers le monde
     */
    @Override
    public void execute(Player pPlayer) {
        String vDirection = this.getSecondWord();
        if(vDirection == null)
            GameEngine.aGui.println("go where ?\n");
        else{
            if(GameEngine.aPlayer.getCurrentRoom().getExit(vDirection) != null){
                if(!GameEngine.aPlayer.getCurrentRoom().getDoor(vDirection).isLocked() || (GameEngine.aPlayer.getCurrentRoom().getDoor(vDirection).isLocked() && GameEngine.aPlayer.getInventory().containsValue(GameEngine.aPlayer.getCurrentRoom().getDoor(vDirection).neededKey()))){
                    GameEngine.aPlayer.walk(vDirection);
                }
                else GameEngine.aGui.println("Vous n'avez pas la clé !");
            }
            else GameEngine.aGui.println("there is no door\n");
        }
        GameEngine.showRoom();
    }
}