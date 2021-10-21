import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;



public class Frame extends JFrame implements ActionListener{
	
public static void main(String[] args) {
		
		new Frame();
		
	
	}
	JButton button;
	String liczba;
	JTextField textField;
	JTextPane textPane;
	JPanel panelw;
	JPanel panele;
	JPanel panels;
	
	
	
	Frame(){
		
		
		this.setTitle("TrojkatPascala");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(true);
		
		panelw=new JPanel(new GridLayout(1,2));
		panels= new JPanel();
		
		
		button = new JButton();
		button.setBounds(200,100,200,200);
		button.addActionListener(this);
		button.setText("START");
		button.setFocusable(false);
		button.setFont(new Font("Comic Sans",Font.BOLD,25));
		
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Comic Sans",Font.BOLD,25));
		textPane.setBackground(null);
		textPane.setEditable(false);
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(250,40));
		textField.setFont(new Font("Comic Sans",Font.BOLD,25));
		
		//this.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		this.add(button);
		this.add(panelw,BorderLayout.WEST);
		this.add(panels,BorderLayout.SOUTH);
		
		panels.add(textPane);
		panelw.add(button,textField);
	
		this.add(textField);
		this.getContentPane().setBackground(Color.gray);
		this.pack();
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== button) {
			String str=" ";
			String linijka="";
			
			
			
			//System.out.println(1);
			try {
				double x = Integer.parseInt(textField.getText());
				if(x>-1) {
					for(int j=0; j<x+1; j++) {
					
						WierszTrojkataPascala row = new WierszTrojkataPascala(j);
					
						for (int i=0; i<j+1; i++) {
							linijka=linijka+" "+Long.toString(row.wspolczynnik(i));
						}
					
						str = str+"\n"+linijka;
						linijka="";
					
					}
					textPane.setText(str);
					StyledDocument doc = textPane.getStyledDocument();
					SimpleAttributeSet center = new SimpleAttributeSet();
					StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
					doc.setParagraphAttributes(0, doc.getLength(), center, false);
					pack();
				}
				else {
					textPane.setText("liczba musi byc wieksza od 0");
				}
			}
			catch(Exception a) {
				textPane.setText("zła dana");
			}
		}
	}
	
	}


