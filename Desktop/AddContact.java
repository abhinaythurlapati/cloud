package view;
import javax.swing.*;

import controller.AddController;
import controller.ContactCard;

import java.awt.*;
import java.awt.event.*;

public class AddContact extends JPanel implements ActionListener{

		JTextField tfn,tln,tadd,tph1,tph2,tem;
		GridBagConstraints gc; 
		JButton sub;
		
		public AddContact()
		{
			setLayout(new GridBagLayout());
			gc=new GridBagConstraints();
			
			JLabel fn=new JLabel("First Name : ");
			JLabel ln=new JLabel("Last Name : ");
			JLabel add=new JLabel("Address : ");
			JLabel ph1=new JLabel("Phone 1 : ");
			JLabel ph2=new JLabel("Phone 2 : ");
			JLabel em=new JLabel("Email : ");
			
			tfn=new JTextField(10);
			tln=new JTextField(10);
			tadd=new JTextField(10);
			tph1=new JTextField(10);
			tph2=new JTextField(10);
			tem=new JTextField(10);
			sub=new JButton("Submit");
			
			addComp(fn,1,1,1,1);
			addComp(tfn,1,2,1,1);
			addComp(ln,2,1,1,1);
			addComp(tln,2,2,1,1);
			addComp(add,3,1,1,1);
			addComp(tadd,3,2,1,1);
			addComp(ph1,4,1,1,1);
			addComp(tph1,4,2,1,1);
			addComp(ph2,5,1,1,1);
			addComp(tph2,5,2,1,1);
			addComp(em,6,1,1,1);
			addComp(tem,6,2,1,1);
			addComp(sub,7,1,2,1);
			
			sub.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent ae)
		{
			ContactCard cc=new ContactCard();
			if(ae.getSource()==sub)
			{
				cc.setFname(tfn.getText());
				cc.setLname(tln.getText());
				cc.setAddress(tadd.getText());
				cc.setEmail(tem.getText());
				cc.setPhno1(tph1.getText());
				cc.setPhno2(tph2.getText());
				
				new AddController(cc);
			}
		}
		
		public void addComp(Component comp,int r,int c,int w, int h)
		{
			gc.gridx=c;
			gc.gridy=r;
			gc.gridwidth=w;
			gc.gridheight=h;
         //	 gc.fill=gc.BOTH;
			add(comp,gc);
		}
}
