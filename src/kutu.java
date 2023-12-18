
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;



public class kutu extends JLabel{
    
    private final int kutuYukselik = 20;
    public int KYON = YON.SAG; //oto baslangic sag yapmistik
    
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
    
    public void yukari(){
                int posX = getX(); //bulundugu konumu aliyorum
                int posY = getY();
                //w yukari gidecek yani - olacak
                posY = posY - getWidth();
                setBounds(posX, posY, getWidth(), getWidth());
    }
    public void asagi(){
                int posX = getX(); //bulundugu konumu aliyorum
                int posY = getY();
                
                posY = posY + getWidth();
                setBounds(posX, posY, getWidth(), getWidth());
    }
    
    public void sag(){
             int posX = getX(); //bulundugu konumu aliyorum
                int posY = getY();
                
                posX = posX + getWidth();
                setBounds(posX, posY, getWidth(), getWidth());
    }
    
    public void sol(){
                int posX = getX(); //bulundugu konumu aliyorum
                int posY = getY();
                
                posX = posX - getWidth();
                setBounds(posX, posY, getWidth(), getWidth());
    }
    
    
    public void YoneGoreHareket(){
        
        if(KYON == YON.SAG){
            sag();
        }
        if(KYON == YON.SOL){
            sol();
        }
        if(KYON == YON.ASAGI){
            asagi();
        }
        if(KYON == YON.YUKARI){
            yukari();
        }   
    }
    public kutu kutuOlustur(){
        
        //buradaki algoritmik soru : kutuyu nereye olusturacagiz ?
        //cevap: yilanBas'in arkasina olusmali , o zaman yilanBas nerede ?
        kutu yeniKutu = new kutu();
        
        int posX = getX();
        int posY = getY();
        
        yeniKutu.setBounds(posX, posY, getWidth(), getWidth());
        
        yeniKutu.KYON = -KYON;
        yeniKutu.YoneGoreHareket();
        yeniKutu.KYON = KYON;
        
        
        
        return yeniKutu; //yilanýn her parcasini arraylistte tutacagim artip azalabilsin o yuzden donus tipi var
    }
    
}
