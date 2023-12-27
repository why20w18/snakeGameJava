package paket1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

import paket1.yilanVeCerceve;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;



public class ekran extends JFrame{
    
    private final int eGenislik = 600;
    private final int eYukseklik = 600;
    public ekran(){
        
        ekranOrtala(eGenislik, eYukseklik);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        yilanVeCerceve cerceve = new yilanVeCerceve();

        setTitle("Yýlan Oyunu | Sürüm 1 ");
        
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