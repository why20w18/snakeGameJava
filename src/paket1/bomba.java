package paket1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;



public class bomba extends JLabel{
    
    public final int bombaUzunluk = 20;
    
    public bomba(){
        
        setBounds(400, 200, bombaUzunluk, bombaUzunluk);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D yem = new Rectangle2D.Double(2, 2, getWidth()-4, getHeight()-4);
        
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(4));
        
        g2.draw(yem);
        g2.setColor(Color.red);
        g2.fill(yem);
        
    }
    
    
    
    
    
    
}
