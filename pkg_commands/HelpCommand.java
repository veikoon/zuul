package pkg_commands;
import pkg_game.Player;
import pkg_game.GameEngine;
/**
 * Décrivez votre classe HelpCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class HelpCommand extends Command
{

    /**
     * Constructeur d'objets de classe InventoryCommand
     */
    public HelpCommand()
    {
    }

    @Override
    public void execute(Player pPlayer) {
        GameEngine.aGui.println("Vos commandes sont : "+GameEngine.aParser.showCommands()+"\n");
    }
}
