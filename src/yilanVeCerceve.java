
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;



public class yilanVeCerceve extends JLabel {
    kutu bas = new kutu();
    
    public yilanVeCerceve(){
        
        addKeyListener(new klavyeKontrol());
        setFocusable(true);
        add(bas);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D) g;
        
        Rectangle2D cerceve = new Rectangle2D.Double(5, 5, getWidth()-10, getHeight()-10);
        
        g2.setStroke(new BasicStroke(10));
        g2.setColor(Color.black);
        
        g2.draw(cerceve);
        
    }
    
    public class klavyeKontrol implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
            if(e.getKeyCode() == KeyEvent.VK_W){
                System.out.println("W basildi !");
                bas.yukari();
            }
            
            if(e.getKeyCode() == KeyEvent.VK_S){
                System.out.println("S basildi !");
                bas.asagi();
            }
            
            if(e.getKeyCode() == KeyEvent.VK_A){
                System.out.println("A basildi !");
                bas.sol();
            }
            
            if(e.getKeyCode() == KeyEvent.VK_D){
                System.out.println("D basildi !");
                bas.sag();
            }
            

        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
        
        
        
        
    }
    
    
}
