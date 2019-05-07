package pkg_commands;
import pkg_game.Player;
import pkg_game.GameEngine;
/**
 * Décrivez votre classe InventoryCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class InvCommand extends Command
{

    /**
     * Constructeur d'objets de classe InventoryCommand
     */
    public InvCommand()
    {
    }

    @Override
    public void execute(Player pPlayer) {
        GameEngine.aGui.println("Vous portez : " + pPlayer.getInventory().getItemsString() +"\nPoids total : "+ pPlayer.getInventory().getTotalWeight());
    }
}
