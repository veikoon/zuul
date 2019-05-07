package pkg_commands;
import pkg_game.Player;
import pkg_game.GameEngine;
/**
 * Décrivez votre classe TakeCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TakeCommand extends Command
{

    /**
     * Constructeur d'objets de classe InventoryCommand
     */
    public TakeCommand()
    {
    }

    @Override
    public void execute(Player pPlayer) {
        if(!this.hasSecondWord()){
            GameEngine.aGui.println("Take what ?\n");
        }
        else{
            String vCom = this.getSecondWord();
            if(pPlayer.getCurrentRoom().getItemList().containsKey(vCom)) {
                if(GameEngine.aPlayer.getInventory().getTotalWeight()+GameEngine.aPlayer.getCurrentRoom().getItemList().getItem(vCom).getWeight()<GameEngine.aPlayer.getPOIDS()){
                    GameEngine.aPlayer.takeItem(vCom);
                    GameEngine.aGui.println("Vous avez bien pris : " + vCom + "\n");
                }
                else GameEngine.aGui.println("Vous ne pouvez pas prendre "+ vCom +" vous etes trop lourd !\n");
            }
            else GameEngine.aGui.println("GameEngine Item do not exist !\n");
        }
    }
}
