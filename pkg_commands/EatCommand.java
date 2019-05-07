package pkg_commands;
import pkg_game.Player;
import pkg_game.GameEngine;
/**
 * Décrivez votre classe EatCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class EatCommand extends Command
{

    /**
     * Constructeur d'objets de classe InventoryCommand
     */
    public EatCommand()
    {
    }

    @Override
    public void execute(Player pPlayer) {
        if(this.hasSecondWord()){
            if(this.getSecondWord().equals("cookie")){
                if(GameEngine.aPlayer.getInventory().containsKey("cookie")){
                    GameEngine.aPlayer.setPoidsMax(10);
                    GameEngine.aGui.println("Vous avez doublé votre inventaire de taille !\n");
                    GameEngine.aPlayer.getInventory().removeItem("cookie");
                }
                else GameEngine.aGui.println("Vous n'avez pas de cookie petit coquin !\n");
            }
            else GameEngine.aGui.println("Eat what ?\n");
        }
        else GameEngine.aGui.println("You have eaten now and you are not hungry any more.\n");
    }
}
