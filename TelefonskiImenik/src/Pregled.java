import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Pregled extends JFrame {
	JPanel p1,p2;
	JLabel l1;
	JTextArea lista;
	JTextField vnes;
	
	public Pregled(){
		setTitle("Pregled na imenikot");
        setSize(400,230);
        setResizable(false);  
		setLocationRelativeTo(null);
	
		p2=new JPanel();
		p1=new JPanel();
		
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel ime=new JLabel("Ime:");
		p1.add(ime);
		vnes=new JTextField(10);
		p1.add(vnes);
		JButton baraj=new JButton("Baraj");
		p1.add(baraj);
		
		p2=new JPanel();
		
		lista=new JTextArea();
		lista.setBounds(20,60 , 350, 100);
		lista.setLineWrap(true);
		JScrollPane sbrText = new JScrollPane(lista);
		getContentPane().add(sbrText,BorderLayout.CENTER);
		sbrText.setBounds(lista.getBounds());
		sbrText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		JButton nazad=new JButton("Nazad");
		p2.add(nazad);
		p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(p2,BorderLayout.SOUTH);
		getContentPane().add(p1,BorderLayout.NORTH);
		
		event a= new event();
		baraj.addActionListener(a);
		nazad.addActionListener(a);
		
	}
	
	public class event implements ActionListener{
		public void actionPerformed(ActionEvent a) {
			String op=a.getActionCommand();
			JFrame frame = new JFrame("Show Message Dialog");
			
			if(op.equals("Baraj")){
				try{
				String s; int index,uslov = 0;
				lista.setText(null);
				
				FileReader record=new FileReader("imenik.txt");
				BufferedReader in=new BufferedReader(record);
				
				while((s=in.readLine())!=null){
	            if(vnes.getText().equals("")) {
	            JOptionPane.showMessageDialog(frame,"Ve molime vnesete podatok za baranje!");uslov=1;break;}
				index = s.indexOf(vnes.getText());
				if(index!=-1 && index==5)
				{  			uslov=1;
					        lista.setText(lista.getText()+s+"\n");
							for(int i=0;i<5;i++)
							{lista.setText(lista.getText()+in.readLine()+"\n");}	
				}
}
				if(uslov==0){
		        		JOptionPane.showMessageDialog(frame,"Ne se pronajdeni podatoci!");	
						}
					in.close();
				    }
					catch (IOException e){
						JOptionPane.showMessageDialog(frame,"Podatocite ne se procitani!");
					}
			}
			else if(op.equals("Nazad")){
			setVisible(false);
			Prozorec nov=new Prozorec();
			nov.setVisible(true);
			}
		}
	}
}
