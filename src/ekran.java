
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;



public class ekran extends JFrame{
    
    private final int eGenislik = 600;
    private final int eYukseklik = 600;
    
    public ekran(){
        setTitle("Y�lan Oyunu | S�r�m 1");
        ekranOrtala(eGenislik, eYukseklik);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
        yilanVeCerceve cerceve = new yilanVeCerceve();
        add(cerceve);
        
        setVisible(true);
    }
    
    public void ekranOrtala(int eGenislik , int eYukseklik){
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        int posX = (dim.width-eGenislik)/2;
        int posY = (dim.height-eYukseklik)/2;
        
        setBounds(posX, posY, eGenislik, eYukseklik);
    }
}