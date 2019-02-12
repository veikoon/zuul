/**
 * Classe permettant de décrire un Item avec une description et un poids
 *
 */
public class Item
{
    private int aPoids;
    private String aDescription;

    /**
     * Constructeur naturel
     * @param pWeight Poids de l'item
     * @param pDescription Description de l'item
     */
    public Item(final String pDescription, final int pPoids)
    {
        this.aPoids = pPoids;
        this.aDescription = pDescription;
    }

    /**
     * getWeight
     * @return Poids de l'item
     */
    public int getWeight(){
        return aPoids;
    }

    /**
     * getDescription
     * @return Description de l'item
     */
    public String getDescription(){
        return aDescription;
    }
}