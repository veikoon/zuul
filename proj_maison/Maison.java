/**
 * Cette classe represente un simple dessin. Vous pouvez l'afficher en appelant
 * la methode dessine(). Mais il y a mieux : comme c'est un dessin electronique,
 * vous pouvez facilement le modifier. Par exemple, le passer en noir et blanc,
 * puis le remettre en couleurs (seulement apres l'avoir dessine, bien sur).
 *
 * (ecrite pour servir d'exemple au debut de l'apprentissage de Java avec BlueJ)
 * 
 * @author  Michael Kolling and David J. Barnes
 * @author  mod.by Denis BUREAU
 * @version 2006.03.30/2012.02.06
 */
public class Maison
{
    private Carre    aMur;
    private Carre    aFenetre;
    private Triangle aToit;
    private Cercle   aSoleil;
    private Cercle   aSoleil2;
    private boolean  aDejaPlace;

    /**
     * Constructor for objects of class Picture
     */
    public Maison()
    {
        this.aDejaPlace= false; // place() is needed
        
        this.aMur= new Carre();
        this.aMur.changeTaille( 100 );
        
        this.aFenetre= new Carre();
        this.aFenetre.changeCouleur( "black" );

        this.aToit= new Triangle();  
        this.aToit.changeTaille( 140, 50 );

        this.aSoleil= new Cercle();
        this.aSoleil.changeCouleur( "yellow" );
        this.aSoleil.changeTaille( 60 );
        
        this.aSoleil2= this.aSoleil;
        this.aSoleil2.changeCouleur("red");
        
        dessine();
        place();
    } // Picture()

    /**
     * Draw this picture.
     */
    public void dessine()
    {
        this.aMur.rendVisible();
        this.aFenetre.rendVisible();
        this.aToit.rendVisible();
        this.aSoleil.rendVisible();
    } // dessine()

    /**
     * Slowly move the elements to their place.
     */
    public void place()
    {
        if ( ! aDejaPlace ) {
            this.aMur.depLentVertical(80);
            this.aFenetre.depLentHorizontal(20);
            this.aFenetre.depLentVertical(100);
            this.aToit.depLentHorizontal(60);
            this.aToit.depLentVertical(70);
            this.aSoleil.depLentHorizontal(180);
            this.aSoleil.depLentVertical(-10);
            this.aDejaPlace= true;
        }
    } // place()

    /**
     * Erase the house from this picture.
     */
    public void effaceMaison()
    {
        this.aMur.rendInvisible();
        this.aFenetre.rendInvisible();
        this.aToit.rendInvisible();
    } // effaceMaison()

    /**
     * Change this picture to black/white display
     */
    public void metNoirEtBlanc()
    {
        if (this.aMur != null) { // only if it's painted already...
            this.aMur.changeCouleur(  "black");
            this.aFenetre.changeCouleur("white");
            this.aToit.changeCouleur(  "black");
            this.aSoleil.changeCouleur(   "black");
            this.aSoleil2.changeCouleur(   "black");
        } // if
        else {}
    } // metNoirEtBlanc()

    /**
     * Change this picture to use color display
     */
    public void metCouleurs()
    {
        if (this.aMur != null) { // only if it's painted already...
            this.aMur.changeCouleur(  "red"   );
            this.aFenetre.changeCouleur("black" );
            this.aToit.changeCouleur(  "green" );
            this.aSoleil.changeCouleur(   "yellow");
            this.aSoleil2.changeCouleur(   "red");
        } // if
        else {}
    } // metCouleurs()
    
    /**
     * Retourne la position d'un soleil
     */
    public String getPositionSoleil(Cercle pCercle, String pNom){
        return pNom+" : "+"x="+(this.aSoleil.getPosition()-this.aSoleil.getPosition()%1000)/1000+", y="+this.aSoleil.getPosition()%1000;
    }
    
    /**
     * Retourne la position des deux soleils
     */
    public String getPositionsDeuxSoleils(){
        return getPositionSoleil(this.aSoleil, "Soleil 1")+" | "+getPositionSoleil(this.aSoleil2, "Soleil 2");
    }
} // Maison
