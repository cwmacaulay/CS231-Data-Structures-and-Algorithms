/*Charles Macaulay
 *October 6, 2014
 *Landscape.java
 */


import java.util.*;

public class Landscape {
  
  
  LinkedList scape;

  double width = 0;
  double height = 0;
  double obs_width;
  double obs_height;
  
  /* constructor Landscape() sets up a Lanscape object with given parameters*/
  public Landscape( double rows, double cols ){
    
    scape = new LinkedList<Cell>();
    this.width = rows;
    this.height = cols;
    this.obs_width = 30;
    this.obs_height = 30;
      
      }
  
  
  
  
  /* reset() clears all cells in a Landscape to not alive state*/
  public void reset(){
    
    Landscape ls = new Landscape( this.width, this.height );
  }
  
  
  /* returns the # of rows in a Landscape object*/
  public int getRows(){
    double d  = this.height;
    int i = (int) d;
    return i;
  }
  
  
  /*returns the # of columns in Landscape object*/
  public int getCols(){
    double d  = this.width;
    int i = (int) d;
    return i;
  }
  
  
  
  public double getHeight() {
    return this.height;
  }
  
  public double getWidth() {
    return this.width;
  }
  
  
  
  public void removeAgent( Cell a ) {
    scape.remove( a ); 
  }
  
  

  public void addAgent( Cell a ){
    scape.add ( a );
  }
  
  
  public ArrayList<Cell> getAgents() {
    ArrayList<Cell> acl =  this.scape.toArrayList();
    return acl;
  }
  
  
  
  public String toString() {
    
    ArrayList<Cell> agents = this.getAgents();
    String [][] strObj = new  String [this.getCols()][this.getRows()];
    String str = "";
    for(int c= 0; c < this.width; c++){
      for(int r = 0; r < this.height; r++){
        strObj[c][r] =" ";
      }
    }
    int xdex= 0;
    int ydex= 0;
    for( int i = 0; i < agents.size(); i ++){
      Cell c = agents.get(i);
      xdex = c.getCol();
      ydex = c.getRow();
      if (  xdex < this.getCols() && xdex > 0 && ydex > 0 && ydex < this.getRows() ){
        strObj[xdex][ydex] = c.toString();

      }else{continue;}
    }
      for(int c= 0; c < this.getRows(); c++){
      for(int r = 0; r < this.getCols(); r++){
        str += strObj[r][c];
      }
      str += " \n ";
    }
      return str;
  }
  
  
  
  
  public ArrayList<Cell> getNeighbors( Cell qcell ){
    
    ArrayList<Cell> neighbors = new ArrayList<Cell>();
    ArrayList<Cell> cells = this.getAgents();
    for( Cell a : cells ) {
      if (a.isNeighbor(qcell) == true && a.equals(qcell) != true && a.identifier == qcell.identifier ){
        neighbors.add( a );
      } else { continue; }
    }
    return neighbors;
  }
  
  
  
  public ArrayList<Cell> foodNeighbors( Cell qcell ){
    ArrayList<Cell> fneighbors = new ArrayList<Cell>();
    ArrayList<Cell> cells = this.getAgents();
    for( Cell a : cells ) {
      if (a.isNeighbor(qcell) == true && a.equals(qcell) != true  && a.identifier !=qcell.identifier && a.identifier < 3){
        fneighbors.add( a );
      } else { continue; }
    }
    return fneighbors;
  }
  
  
  
    public ArrayList<Cell> oNeighbors( Cell qcell ){

    ArrayList<Cell> oneighbors = new ArrayList<Cell>();
    ArrayList<Cell> cells = this.getAgents();
    for( Cell a : cells ) {
      if (a.isNeighbor(qcell) == true && a.equals(qcell) != true  && a.identifier == 3){
        oneighbors.add( a );
      } else { continue; }
    }
    return oneighbors;
  }
  
  
  public void advance(){
    
    ArrayList<Cell> shuf_list = scape.toShuffledList();
    Random gen = new Random();
    for( Cell c: shuf_list){
      c.updateState( this );
    }
  }
  

  
  public static void main(String argv[]) {
    
}
}
    
    
      
    
      