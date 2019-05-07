package pkg_commands;
import pkg_game.Player;
import pkg_game.GameEngine;
/**
 * Décrivez votre classe LookCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class LookCommand extends Command
{

    /**
     * Constructeur d'objets de classe InventoryCommand
     */
    public LookCommand()
    {
    }

    @Override
    public void execute(Player pPlayer) {
        if(this.hasSecondWord()){
            if(pPlayer.getCurrentRoom().getItemList().containsKey(this.getSecondWord())){
                GameEngine.aGui.println(pPlayer.getCurrentRoom().getItemList().getItem(this.getSecondWord()).getDescription());
            }
            else GameEngine.aGui.println("Look what ?\n");
        }
        else GameEngine.showRoom();
    }
}
