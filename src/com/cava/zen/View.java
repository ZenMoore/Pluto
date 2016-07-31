package com.cava.zen;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
public class View extends JFrame {
	Container container;
	JPanel  but;//Buttons' Panes
	JTextField pro;//where users input their problem
	JTextField ans;//where it show the answer 
	JButton last;//"Ok.Help me work it out."
	JButton reset;//reset the text field.
	JButton instruction;//exit the system.

	public View() {
		container=this.getContentPane();//general Pane
		container.setLayout(new GridLayout(4,1,20,20));
		

		//set the backumage
		this.setBounds(500, 250,500,400);
		JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                ImageIcon icon = new ImageIcon("./Image/pluto.jpg");
                // 图片随窗体大小而变化
                g.drawImage(icon.getImage(), 5, 5,130,60,this);
            }
		};panel.setOpaque(false);panel.setVisible(false);this.add(panel);
		
		but=new JPanel();
		but.setLayout(new GridLayout(1,3,15,15));
		
		//in&out textfield.
		pro=new JTextField();
		ans=new JTextField();

		//Function button
		last=new JButton();
		reset=new JButton();
		instruction=new JButton();
		
		this.setAll();//set everything.
		
		//add all into the container(General Pane).
		container.add(pro);
		container.add(ans);
		but.add(last);
		but.add(reset);
		but.add(instruction);
		container.add(but);

		//set the window.
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("Pluto by Zen");
		this.setUndecorated(false);
		this.setVisible(true);
		
		try{
			Thread.sleep(500);
			panel.setVisible(true);
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	public void setLast(){
		last.setText("Last");
		last.setBackground(Color.LIGHT_GRAY);
		last.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				View.this.ans.setText(Calculate.last());
			}
		});
	}
	
	public void setReset(){
		reset.setText("Reset");
		reset.setBackground(Color.LIGHT_GRAY);
		reset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				View.this.pro.setText(null);;
				View.this.ans.setText(null);
			}
			
		});
	}

	public void setPro(){
		this.pro.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				pro.setCaretColor(Color.BLACK);
				pro.setBackground(Color.white);
			}
			public void focusLost(FocusEvent e){
				pro.setBackground(Color.lightGray);
				pro.setCaretColor(Color.LIGHT_GRAY);
			}
		});
		this.pro.addKeyListener(new KeyListener() {

			   @Override
			   public void keyPressed(KeyEvent arg0) {
			   }

			   @Override
			   public void keyReleased(KeyEvent arg0) {
			    	View.this.getPro1();
			    	Calculate.play();
			    	View.this.ans.setText(View.this.getAns());
			   }

			   @Override
			   public void keyTyped(KeyEvent arg0) {

			    if (arg0.getKeyChar() == KeyEvent.VK_ENTER) {	
			    }

			   }
			  });
	}
	
	public void setAns(){
		this.ans.setEditable(false);
	}

	public void setInstru(){
		instruction.setText("Instruction");
		instruction.setBackground(Color.LIGHT_GRAY);
		instruction.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("C://WINDOWS//system32//notepad.exe ./Document/Instruction.txt");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(View.this, e1);
				}
			}
		});
	}

	public void setAll(){
		this.setPro();
		this.setLast();
		this.setAns();
		this.setReset();		
		this.setInstru();
	}
	
	public static void main(String[] args){
		new View();
	}

	public void getPro1(){
		Transport.getPro1(this.pro.getText());
	}

	public String getAns(){
		return Transport.getAns2();
	}
	
}