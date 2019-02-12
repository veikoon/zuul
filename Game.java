import java.util.*;
public class Game{
    /**
     * Arguments:
     * aCurrentRoom est la salle dans laquelle se trouve le joueur en permanance
     * aParser permet de capter la commande entré par le joueur
     */
    private UserInterface aGui;
    private GameEngine aEngine;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        this.aEngine = new GameEngine();
        this.aGui = new UserInterface(aEngine);
        this.aEngine.setGUI(aGui);
    }
}
