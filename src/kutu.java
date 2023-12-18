
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;



public class kutu extends JLabel{
    
    private final int kutuYukselik = 20;
    
    public kutu(){
        
        setBounds(100, 100, kutuYukselik, kutuYukselik);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D yilanBas = new Rectangle2D.Double(2, 2, getWidth()-4, getHeight()-4);
        
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(4));
        
        g2.draw(yilanBas);
        g2.setColor(Color.green);
        g2.fill(yilanBas);
        
    }
    
    
}
