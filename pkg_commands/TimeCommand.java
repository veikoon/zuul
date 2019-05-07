package pkg_commands;
import pkg_game.GameEngine;
import pkg_game.Player;
/**
 * Décrivez votre classe TimeCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TimeCommand extends Command
{

    /**
     * Constructeur d'objets de classe InventoryCommand
     */
    public TimeCommand()
    {
    }

    @Override
    public void execute(Player pPlayer) {
        double vMin = (System.nanoTime() - GameEngine.aTime) * Math.pow(10,-9)/60;
        double vSec = (System.nanoTime() - GameEngine.aTime) * Math.pow(10,-9)%60;
        GameEngine.aGui.println((int) vMin+":"+(int) vSec);
    }
}
