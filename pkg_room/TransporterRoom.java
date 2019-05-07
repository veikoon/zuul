package pkg_room;
import pkg_game.GameEngine;

/**
 * Décrivez votre classe TransporterRoom ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TransporterRoom extends Room
{
    private RoomRandomizer aRandom;
    public TransporterRoom(final String pDes, final String pIm, final GameEngine pGui){
        super(pDes, pIm);
        aRandom = new RoomRandomizer(pGui);
    }
    public Room getExit(final String pNull){
        return aRandom.findRandomRoom();
    }
}
