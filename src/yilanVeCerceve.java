
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;
import javax.swing.Timer;



public class yilanVeCerceve extends JLabel {
    kutu bas = new kutu();
    Timer timer4 = null;
    
    public yilanVeCerceve(){
        
        addKeyListener(new klavyeKontrol());
        
        setFocusable(true);
        timer4 = new Timer(100,new surekliHareketKontrol());
        timer4.start();
        
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
              // bas.yukari();
              if(bas.KYON != YON.ASAGI){
                  bas.KYON = YON.YUKARI;
              }
           }
           if(e.getKeyCode() == KeyEvent.VK_S){
              // bas.asagi();
              
              if(bas.KYON != YON.YUKARI){
                  bas.KYON = YON.ASAGI;
              }
           
           }
           if(e.getKeyCode() == KeyEvent.VK_D){
               //bas.sag();
               
               if(bas.KYON != YON.SOL){
                   bas.KYON = YON.SAG;
               }
           
           }
           if(e.getKeyCode() == KeyEvent.VK_A){
               //bas.sol();
               
               if(bas.KYON != YON.SAG){
                   bas.KYON = YON.SOL;
               }
               
           }
            

        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
    
    public boolean carpismaVarMi(){
        
        if(bas.getX() <= 10){
            return true;
        }
        else if(bas.getX() >= 560){
            return true;
        }
        else if(bas.getY() <= 10){
            return true;
        }
        else if(bas.getY() >= 540){
            return true;
        }
        
        
        return false;
    }
    
    public class surekliHareketKontrol implements ActionListener{

        @Override //hep saga gidiyor bunu engellemek icin yon tayini yapacagiz
        public void actionPerformed(ActionEvent e) {
        //bas.sag();
        
        bas.YoneGoreHareket();
        if(carpismaVarMi()){
            System.out.println("carpisma oldu !");
            timer4.stop();
        }
        
        }
        
    }
    
}
