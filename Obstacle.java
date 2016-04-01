/* Obstacle.java
 * Charles Macaulay
 * October 16, 2014
 */


import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;



class Obstacle extends Cell {
  
  
  Obstacle(double x, double y) { 
    super( x, y);
    this.xPos = x;
    this.yPos = y;
    this.identifier = 3;
    this.mortality = 1;

  }
  
  
  public boolean isNeighbor(Cell cell) {
    double x0 = cell.getX();
    double y0 = cell.getY();
    double x_dis = Math.pow((this.xPos - x0),2);
    double y_dis = Math.pow((this.yPos - y0),2);
    double distance = Math.pow((x_dis+ y_dis), 0.5);
    
    if (distance < 50 && cell.mortality > 0 ){
      
      return true;
    }
    else {return false;}
  }
  
  
  public boolean contact( Cell cell) {
    double x0 = cell.getX();
    double y0 = cell.getY();
    double x_dis = Math.pow((this.xPos - x0),2);
    double y_dis = Math.pow((this.yPos - y0),2);
    double distance = Math.pow((x_dis+ y_dis), 0.5);
    
    if (distance < 5 && cell.mortality > 0 ){
      return true;
    }
    else {return false;}
  }
  
  public void updateState( Landscape ls ) {
;
  }
      
      public void draw(Graphics g, int x0, int y0, int scale) {
        int x = x0 + (int)(xPos * scale);
        int y = y0 + (int)(yPos * scale);
        
        g.setColor( new Color(0.8f, 0.6f, 0.3f));
        
        g.fillRect(x, y, scale, scale);
        
        
      }
    

  
  public String toString(){
    return " ð " ;
  }
  
  
}