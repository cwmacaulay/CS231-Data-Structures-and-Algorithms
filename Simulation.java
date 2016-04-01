/*Charles Macaulay
 *October 16, 2014
 *Simulation.java
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class Simulation {
  
  
  public Simulation() throws InterruptedException {
    Landscape scape = new Landscape(225, 400);
    Random gen = new Random();



    
    for( int i=0;i<20;i++) {
      scape.addAgent( new Producer( gen.nextDouble()*scape.getWidth(), 
                                               gen.nextDouble()*scape.getHeight() )); 
      scape.addAgent( new Producer( gen.nextDouble()*scape.getWidth(), 
                                               gen.nextDouble()*scape.getHeight() ));
     
      scape.addAgent( new Consumer( gen.nextDouble()*scape.getWidth(), 
                                               gen.nextDouble()*scape.getHeight()));
   }

    double randX = gen.nextDouble()*scape.getWidth()/2;
    double randY = gen.nextDouble()*scape.getHeight()/2;
    for (int i = 0; i <scape.obs_width; i ++){
      double xdraw = randX + i;
      scape.addAgent( new Obstacle( xdraw, 
                                   randY ));
      for (int j = 0; j <scape.obs_height; j ++){
        scape.addAgent( new Obstacle( xdraw, 
                                     randY  + j));
      }
      }
    
    
    double randX1 = gen.nextDouble()*scape.getWidth()/2;
    double randY1 = gen.nextDouble()*scape.getHeight()/2;
    for (int i = 0; i <scape.obs_width; i ++){
      double xdraw = randX1 + i;
      scape.addAgent( new Obstacle( xdraw, 
                                   randY1 ));
      for (int j = 0; j <scape.obs_height; j ++){
        scape.addAgent( new Obstacle( xdraw, 
                                     randY1  + j));
      }
      }
    

    
    LandscapeDisplay display = new LandscapeDisplay(scape, 2);
    for(int j=0;j<1000;j++) {
      scape.advance();
      display.update();

      Thread.sleep( 100 );
      int count = (10 + j);
      display.saveImage( "proj5" + count + ".png" );
    }
  }

  
  public static void main (String[] args) throws InterruptedException {
    
    Simulation s = new Simulation();
    
}
}
  