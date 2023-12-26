package paket1;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.Timer;
import paket1.YON;
import paket1.kutu;
import paket1.yem;



public class yilanVeCerceve extends JLabel {
    kutu bas = new kutu();
    yem yem = new yem();
    
    Timer timer4 = null;
    ArrayList<kutu> yilanParcalari = new ArrayList<kutu>();
    
    Random rand = new Random();

    
    public yilanVeCerceve(){
        
        addKeyListener(new klavyeKontrol());
        
        setFocusable(true);
        timer4 = new Timer(100,new surekliHareketKontrol());
        timer4.start();
        
        
        //ilk atilacak parca yilanin basi
        //arraylistin sonuna gidip kutu olusturulabilir
        //yeni olusan kutu hem yilanParcalari arraylistine eklenmeli hemde komponent olarak eklenmeli ki biz
        //ekranda gorelim
        yilanParcalari.add(bas);
        
        for(int i = 0 ; i < 5 ; i++){
                                            
            kuyrukOlustur();
        }
        
        add(yem);
        add(bas);
    }
    
    public void kuyrukOlustur(){
        
        kutu yeniKutu = yilanParcalari.get(yilanParcalari.size()-1).kutuOlustur();
        yilanParcalari.add(yeniKutu);
        add(yeniKutu);
        
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
        
    int basX = bas.getX();
    int basY = bas.getY();

    for (int i = 1; i < yilanParcalari.size(); i++) {
        kutu parca = yilanParcalari.get(i);
        if (basX == parca.getX() && basY == parca.getY()) {
            return true; 
        }
    }

    if (basX <= 10 || basX >= 560 || basY <= 10 || basY >= 540) {
        return true; // Duvarlara çarpma
    }

    if (yem.getX() == basX && yem.getY() == basY) {
        kuyrukOlustur();
        yemEkle();
    }

    return false;
}

    
    public void yemEkle(){
        
        int width = getWidth()-40-yem.yemHeight;
        int height = getHeight()-40-yem.yemHeight;
        
        int posX = Math.abs(rand.nextInt()) % width; 
        int posY = Math.abs(rand.nextInt()) % height;
        
        posX = posX - posX%20;
        posY = posY - posY%20;
        
        yem.setBounds(posX+20, posY+20, 20, 20);
            
    }
    
    public void hepsiniYurut(){
       for(int i =  yilanParcalari.size() -1 ; i > 0 ;i--){
            
            kutu prev = yilanParcalari.get(i-1);
            kutu next = yilanParcalari.get(i);
            
//            next.kyon = prev.kyon;
            
            
            yilanParcalari.get(i).YoneGoreHareket();
            next.KYON = prev.KYON;

        }
        //i = 1 oldugundan en bastaki hareket etmez
        //donguyu ters ceviririz
        bas.YoneGoreHareket();
    }
    
    public class surekliHareketKontrol implements ActionListener{

        @Override //hep saga gidiyor bunu engellemek icin yon tayini yapacagiz
        public void actionPerformed(ActionEvent e) {
        //bas.sag();
        
        //bas.YoneGoreHareket();
        hepsiniYurut();
        if(carpismaVarMi()){
            System.out.println("carpisma oldu !");
            timer4.stop();
        }
        
        }
        
    }
    
}