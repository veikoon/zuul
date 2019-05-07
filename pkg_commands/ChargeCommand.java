package pkg_commands;
import pkg_game.Player;
import pkg_game.GameEngine;
/**
 * Décrivez votre classe ChargeCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class ChargeCommand extends Command
{

    /**
     * Constructeur d'objets de classe InventoryCommand
     */
    public ChargeCommand()
    {
    }

    @Override
    public void execute(Player pPlayer) {
        if(pPlayer.getRoomCharged() != null) GameEngine.aGui.println("Votre téléporteur est déjà chargé !\n");
        else if(!GameEngine.aPlayer.getInventory().containsKey("beamer")) GameEngine.aGui.println("Vous n'avez pas de téléporteur !\n");
        else{
            pPlayer.charge();
            GameEngine.aGui.println("Vous avez chargé votre téléporteur !\n");
        }
    }
}
