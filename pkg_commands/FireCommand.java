package pkg_commands;
import pkg_game.GameEngine;
import pkg_game.Player;
/**
 * Décrivez votre classe FireCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class FireCommand extends Command
{

    /**
     * Constructeur d'objets de classe InventoryCommand
     */
    public FireCommand()
    {
    }

    @Override
    public void execute(Player pPlayer) {
        if(pPlayer.getRoomCharged() == null) GameEngine.aGui.println("Votre téléporteur n'est pas chargé !\n");
        else if(!pPlayer.getInventory().containsKey("beamer")) GameEngine.aGui.println("Vous n'avez pas de téléporteur !\n");
        else{
            pPlayer.fire();
            GameEngine.showRoom();
        }
    }
}
