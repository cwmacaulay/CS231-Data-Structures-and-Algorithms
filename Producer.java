/* Producer.java
 * Charles Macaulay
 * October 16, 2014
 */


import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;



class Producer extends Cell {
  
  
  public  double rightedge;
  public  double bottomedge;
  
  Producer(double x, double y) { 
    super( x, y);
    this.xPos = x;
    this.yPos = y;
    this.identifier = 1;
    this.mortality = 1;
    
    
  }
  
  
  public boolean isNeighbor(Cell cell) {
    double x0 = cell.getX();
    double y0 = cell.getY();
    double x_dis = Math.pow((this.xPos - x0),2);
    double y_dis = Math.pow((this.yPos - y0),2);
    double distance = Math.pow((x_dis+ y_dis), 0.5);
    
    if (distance < 50 ){
      
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
    
    double xR = rightedge;
    double y01 = cell.getY();
    double x_disR = Math.pow((this.xPos - xR),2);
    double y_dis1 = Math.pow((this.yPos - y01),2);
    double rdistance = Math.pow((x_disR + y_dis1), 0.5);
    
    double xRb = rightedge;
    double yB = bottomedge;
    double x_disRb = Math.pow((this.xPos - xRb),2);
    double y_disB = Math.pow((this.yPos - yB),2);
    double rBdistance = Math.pow((x_disRb + y_disB), 0.5);
    
    
    if (distance <9 ||rdistance < 9 || rBdistance <9 && cell.mortality > 0 ){
      return true;
    }
    else {return false;}
  }
  
  
  
  
  
  public void updateState( Landscape ls ) {
    
    ArrayList<Cell> neighbors = ls. getNeighbors( this );
    ArrayList<Cell> food_neighbors = ls. foodNeighbors( this );
    Random gen = new Random();
    double xp = this.xPos;
    double yp = this.yPos;
    
    if ( food_neighbors.size() > 0) {
      for( Cell c : food_neighbors){
        if (this.contact(c) == true){
          this.mortality = 0;
          ls.removeAgent( this );
        }
      }
    }
    if (neighbors.size() > 5 && neighbors.size() < 20){
      
      double i = 9.5 ;
      
      if( (gen.nextDouble()* 10.0) > i ){
        double x = this.xPos;
        double y = this.yPos;
        double near_x_pos = (xp + ((gen.nextDouble() - .5)  * 100));
        double near_y_pos = (yp + ((gen.nextDouble() - .5)  * 20));
        ls.addAgent( new Producer( near_x_pos, near_y_pos ));
      }
    }
  }
  
  
  
  
  
  public void draw(Graphics g, int x0, int y0, int scale) {
    int x = x0 + (int)(xPos * scale);
    int y = y0 + (int)(yPos * scale);
    Graphics2D g2 = (Graphics2D) g;
    Image img1 = Toolkit.getDefaultToolkit().getImage("patagonia-logo2.jpg");
    g2.drawImage(img1, x, y, 20*scale, 8*scale, null);
    g2.finalize();
    
    return;
  }
  
  public String toString(){
    return " ð " ;
  }
  
  
}