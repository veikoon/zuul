package v1;

public class Room{
    private String aDescription;
    public Room aNorthExit;
    public Room aSouthExit;
    public Room aEastExit;
    public Room aWestExit;
    
    public Room(final String pDes){
        this.aDescription = pDes;
    }
    
    public Room getExit(String pDir){
        if(pDir.equals("nord")){
            return aNorthExit;
        }
        if(pDir.equals("south")){
            return aSouthExit;
        }
        if(pDir.equals("east")){
            return aEastExit;
        }
        if(pDir.equals("west")){
            return aWestExit;
        }     
        return null;
    }
    public String getDescription(){
        return this.aDescription;
    }
    
    public void setExits(final Room pN, final Room pS, final Room pE, final Room pW){
        this.aNorthExit = pN;
        this.aSouthExit = pS;
        this.aEastExit = pE;
        this.aWestExit = pW;
    }
        

} // Room
