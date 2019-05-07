package pkg_commands;
import pkg_game.Player;
import pkg_game.GameEngine;
/**
 * Décrivez votre classe Drothismand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class DropCommand extends Command
{

    /**
     * Constructeur d'objets de classe InventoryCommand
     */
    public DropCommand()
    {
    }

    @Override
    public void execute(Player pPlayer) {
        if(!this.hasSecondWord()) GameEngine.aGui.println("Drop what ?\n");
        else{
            String vCom = this.getSecondWord();
            if(GameEngine.aPlayer.getInventory().containsKey(vCom)) GameEngine.aPlayer.dropItem(vCom);
            else GameEngine.aGui.println("GameEngine Item do not exist !\n");
        }
    }
}