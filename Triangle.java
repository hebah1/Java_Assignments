
package NervousShapes;

import java.awt.*;
import java.awt.geom.Line2D;

public class Triangle extends Shape{
  private int sideLength; 

  public Triangle(int x, int y, Color color, int sideLength){
  super(x, y, color);
  this.sideLength = sideLength;
  } 
  public void draw(Graphics g){
    g.drawLine(getX(), getY(), getX()+sideLength/2, getY()-sideLength);
    g.drawLine(getX(), getY(), getX()+sideLength, getY()); 
    g.drawLine(getX()+sideLength/2, getY()-sideLength, getX()+sideLength, getY());
  }
    public int getHeight() {
    return sideLength;
  }

  public int getWidth() {
    return sideLength;
  }
  
}