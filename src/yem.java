
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;



public class yem extends JLabel{
    
    public final int yemHeight = 20;
    public int KYON = YON.SAG; //oto baslangic sag yapmistik
    
    public yem(){
        
        setBounds(100, 100, yemHeight, yemHeight);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D yem = new Ellipse2D.Double(2, 2, getWidth()-4, getHeight()-4);
        
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(4));
        
        g2.draw(yem);
        g2.setColor(Color.red);
        g2.fill(yem);
        
    }
    
    
    
    
    
    
}
