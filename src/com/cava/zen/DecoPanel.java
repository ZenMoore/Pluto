package com.cava.zen;
import javax.swing.*;
import java.awt.*;
public class DecoPanel extends JPanel{
	JFrame main;
	public DecoPanel(JFrame main){
       this.main=main;
	}
	
	public void set(Graphics pic){
		 ImageIcon icon = new ImageIcon("./Image/background2.jpeg");
	        // 图片随窗体大小而变化
	        pic.drawImage(icon.getImage(), 0, 0,                  
	        main.getSize().width,
	        60,
	        main);
	}
}
