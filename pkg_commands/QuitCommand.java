package pkg_commands;
import pkg_game.Player;
import pkg_game.GameEngine;
/**
 * Décrivez votre classe QuitCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class QuitCommand extends Command
{

    /**
     * Constructeur d'objets de classe InventoryCommand
     */
    public QuitCommand()
    {
    }

    @Override
    public void execute(Player pPlayer) {
        if(this.hasSecondWord()){
            GameEngine.aGui.println("Quit what ?\n");
        }
        else{
            GameEngine.aGui.println("Thank you for playing.  Good bye.");
            GameEngine.aGui.enable(false);
            System.exit(0);
        }
    }
}
