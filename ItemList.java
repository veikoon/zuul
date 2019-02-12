import java.util.HashMap;
import java.util.Set;

/**
 * ItemList : décrit les listes Item/String
 *
 */
public class ItemList
{
    private HashMap<String, Item> aItems;

    public ItemList(){
        this.aItems = new HashMap<String, Item>();
    }

    /**
     * getItem permet de récuperer un item de la HashMap
     * @param pName Nom auquel est associé l'item
     * @return Item correspondant à pName
     */
    public Item getItem(final String pName){
        return this.aItems.get(pName);
    }//getPlayerItem

     /**
     * getItemsString()
     * @return Renvoi les items présents formatées
     */
    public String getItemsString(){
        String vList = "";
        Set<String> keys = this.aItems.keySet();
        for(String vItem : keys){
            vList += vItem+" ";
        }
        return vList;
    }//getItemsString

    /**
     * setItem() permet d'ajouter un item dans la HashMap
     * @param pName Nom de l'item (cle de la HashMap)
     * @param pItem Item correspondant (valeur de la HashMap)
     */
    public void setItem(final String pName, final Item pItem){
        this.aItems.put(pName, pItem);
    }//setPlayerItem

     /**
     * removeItem()
     */
    public void removeItem(final String pName){
        this.aItems.remove(pName);
    }//removeItem

    /**
     * getTotalWeight() : Permet de connaitre la valeure du poids que porte le joueur
     * @return Poids total des Items portes
     */
    public int getTotalWeight(){
        int vWeight = 0;
        Set<String> keys = this.aItems.keySet();
        for(String item : keys){
            vWeight = vWeight+aItems.get(item).getWeight();
        }
        return vWeight;
    }//getTotalWeight

    /**
     * containsKey() : Permet de savoir si un item existe
     * @param pName Nom auquel est associé l'item
     * @return boolean true si l'item est dans la liste
     */
    public boolean containsKey(final String pName){
        return this.aItems.containsKey(pName);
    }

    /**
      * isEmpty() : Test si la liste est Vide
      * @return true or false if empty or not
      */
    public boolean isEmpty(){
      return this.aItems.isEmpty();
    }

    /**
     * getItemList() : Permet de recuperer la liste complete
     * @return aItems : Liste complète
     */
    public HashMap<String, Item> getItemList(){
        return this.aItems;
    }//getItemList

}

