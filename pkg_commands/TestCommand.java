package pkg_commands;
import java.util.*;
import java.io.*;
import pkg_game.Player;
import pkg_game.GameEngine;
/**
 * Décrivez votre classe TestCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TestCommand extends Command
{

    /**
     * Constructeur d'objets de classe InventoryCommand
     */
    public TestCommand()
    {
    }

    public void lecture( final String pNomFichier )
    {
        Scanner vSc;
        try { // pour "essayer" les instructions suivantes
            vSc = new Scanner( new File( pNomFichier ) );
            while ( vSc.hasNextLine() ) {
                String vLigne = vSc.nextLine();
                //interpretCommand();
            } // while
        } // try
        catch ( final FileNotFoundException pFNFE ) {
            // traitement en cas d'exception
        } // catch
    }
    
    @Override
    public void execute(Player pPlayer) {
        
        if(!this.hasSecondWord()){
            GameEngine.aGui.println("Test what ?\n");
        }
        else{
            String vCom = "test/" + this.getSecondWord() + ".txt";
            lecture(vCom);
        }
    }
}
