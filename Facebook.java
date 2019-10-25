// This is the Facebook class
// Dr. Xiaolin Hu
// 03/05/2015
package Facebook;

import java.awt.*;

public class Facebook{

   private String name;
   private String content;
   DrawingPanel panel;
   private Graphics g;

   public Facebook(String nm){
       content = "undefined";
       name = nm;

       // Create the drawing panel
       panel = new DrawingPanel(200, 150);
       g = panel.getGraphics();

       // display name
       g.drawString(name+"'s mood is undefined.", 20, 75);
   }

   public void setContent(String newContent){
 content = newContent;
        if(content.equals("happy")){
            g.setColor(Color.red);
            g.fillRect(0, 0, 200, 150);
            g.setColor(Color.black);
            // display mood
            g.drawString(name+"'s mood is:"+ "happy", 20, 75);
        }
        else{
            g.setColor(Color.white);
            g.fillRect(0, 0, 200, 150);
            g.setColor(Color.black);
            g.drawString(name+"'s mood is:"+ content, 20, 75);
        }
   }

   public String getContent(){
    return content;
   }



}