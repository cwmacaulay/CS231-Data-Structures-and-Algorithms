/*Charles Macaulay
 *October 6, 2014
 *Cell.java
 */

import java.util.*;
import java.awt.Graphics;
import java.awt.Color;

/* the Cell class represents a location on a grid. 
 * It can store its location, its state (alive or not), and carry out
 * the methods found below*/

public abstract class Cell{
  
  double xPos = 0;
  double yPos = 0;
  boolean aliveVar = false;
  int identifier;
  int mortality;

  
  /* constructor initializes position and state of cell*/
  public Cell(double x0, double y0){
    
    this.identifier = 2;
    this.xPos = x0;
    this.yPos = y0;
    this.mortality = 0;

  }
  
  
  public abstract boolean isNeighbor( Cell cell );
  public abstract void updateState( Landscape ls );
  public abstract void draw(Graphics g, int x, int y, int scale );
  
  
  
  
  
  /*getRow returns value of x position (type:int)*/
  public double getX(){
    return xPos;
  }
  
  
  
  /*getRow returns value of y position (type:int)*/
  public int getCol(){
    int Col = (int) this.xPos;
    return Col; 
  }
  
  
  public double getY() {
    return yPos;
  }
  
  public int getRow() {
    int Row = (int) this.yPos;
    return Row;
  }
  
  public abstract String toString();
  
  
  public static void main(String argv[]) {
  }
  
}



