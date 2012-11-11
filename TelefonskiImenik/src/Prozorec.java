import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Prozorec extends JFrame{
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4;
	JButton vnes,pregled,izlez;
	JRadioButton rb1,rb2;
	
	public Prozorec(){
		
		setTitle("Personalen tel.imenik");
		setSize(400,230);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel p=new JPanel();
		p.setLayout(null);
		l1=new JLabel("Ime:");
		l1.setBounds(30, 0, 100, 50);
		p.add(l1);
		l2=new JLabel("Prezime:");
		l2.setBounds(160,0 , 100, 50);
		p.add(l2);
		l5=new JLabel("Pol:");
		l5.setBounds(290,0 , 100, 50);
		p.add(l5);
		rb1=new JRadioButton("maski");
		rb1.setBounds(290,40, 60, 20);
		rb1.setSelected(true);
		p.add(rb1);
		rb2=new JRadioButton("zenski");
		rb2.setBounds(290,60, 70, 20);
		p.add(rb2);
		ButtonGroup group = new ButtonGroup();
		group.add(rb1);
		group.add(rb2);
	    t1=new JTextField(10);
		t1.setBounds(30,40 , 100, 20);
		p.add(t1);
		t2=new JTextField(10);
		t2.setBounds(160,40 , 100, 20);
		p.add(t2);
		l3=new JLabel("Grad:");
		l3.setBounds(30, 50, 100, 50);
		p.add(l3);
		l4=new JLabel("Telefon:");
		l4.setBounds(160,50 , 100, 50);
		p.add(l4);
		t3=new JTextField(10);
		t3.setBounds(30,90 , 100, 20);
		p.add(t3);
	    t4=new JTextField(10);
		t4.setBounds(160,90 , 100, 20);
		p.add(t4);
		vnes=new JButton("Vnesi");
		vnes.setBounds(30,130 , 100, 30);
		p.add(vnes);
		izlez=new JButton("Izlez");
		izlez.setBounds(270,130,100,30);
		p.add(izlez);
		pregled=new JButton("Pregled");
		pregled.setBounds(160,130 , 100, 30);
		pregled.setToolTipText("Pregled i prebaruvanje na vnesenite zapisi vo imenikot");
		p.add(pregled);
		setContentPane(p);
		
		event a= new event();
		vnes.addActionListener(a);
		pregled.addActionListener(a);
		izlez.addActionListener(a);
	}
	
	public class event implements ActionListener{
		public void actionPerformed(ActionEvent a) { int t=0;
			String op=a.getActionCommand();
			JFrame frame = new JFrame("Show Message Dialog");
			
			if(op.equals("Vnesi")){
			try{ t=0;
			
			FileWriter record=new FileWriter("imenik.txt",true);
			BufferedWriter out=new BufferedWriter(record);
			
			if(t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("")) {t=1;
			JOptionPane.showMessageDialog(frame,"Ve molam popolnete gi site polinja!");
			}
			
			if (rb1.isSelected()==true && t==0){
			out.write("Ime: "+t1.getText()+"\r\n"+"Prezime: "+t2.getText()+"\r\nPol: maski \r\nGrad: "+t3.getText()+"\r\nTel: "+t4.getText()+"\r\n");
			out.write("-----------------------------------------------------\r\n");
			out.close();
			JOptionPane.showMessageDialog(frame,"Podatocite se vneseni!");
			t1.setText("");t2.setText("");t3.setText("");t4.setText("");rb1.setSelected(true);
			}
			
			else if(rb2.isSelected()==true && t==0){
				out.write("Ime: "+t1.getText()+"\r\n"+"Prezime: "+t2.getText()+"\r\nPol: zenski \r\nGrad: "+t3.getText()+"\r\nTel: "+t4.getText()+"\r\n");
				out.write("-----------------------------------------------------\r\n");
				out.close();	
				JOptionPane.showMessageDialog(frame,"Podatocite se vneseni!");
				t1.setText("");t2.setText("");t3.setText("");t4.setText("");rb1.setSelected(true);
				}
			}
			catch (IOException e){
				JOptionPane.showMessageDialog(frame,"Podatocite ne se vneseni!");
			}
			
			}
			
			else if(op.equals("Pregled")){
			Pregled nov=new Pregled();
			nov.setVisible(true);	
			setVisible(false);
			}
			else if(op.equals("Izlez")){
				dispose();
		        System.exit(0);
			}
		}
	}
}