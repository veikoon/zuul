package pkg_commands;
import pkg_game.Player;
import pkg_game.GameEngine;
/**
 * Décrivez votre classe BackCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class BackCommand extends Command
{

    /**
     * Constructeur d'objets de classe InventoryCommand
     */
    public BackCommand()
    {
    }

    @Override
    public void execute(Player pPlayer) {
        if(!pPlayer.oops()) GameEngine.aGui.println("Vous ne pouvez pas revenir en arriere !");
        GameEngine.showRoom();
    }
}
