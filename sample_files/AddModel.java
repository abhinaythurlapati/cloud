package model;

import controller.ContactCard;
import java.sql.*;

import javax.swing.JOptionPane;

public class AddModel {

	public AddModel(ContactCard cc)
	{
		try{
			
			Statement st1=DataCon.con.createStatement();
			ResultSet rs=st1.executeQuery("select max(id) from cms.contact");
			if(rs.next())
				cc.setId(rs.getInt(1));
			PreparedStatement st=DataCon.con.prepareStatement("insert into contact values(?,?,?,?,?,?,?)");
			st.setInt(1,cc.getId()+1);
			st.setString(2,cc.getFname());
			st.setString(3,cc.getLname());
			st.setString(4,cc.getPhno1());
			st.setString(5, cc.getAddress());
			st.setString(6, cc.getEmail());
			st.setString(7, cc.getPhno2());
			st.execute();
			JOptionPane.showMessageDialog(null, "Data Entered Successfully", "Success",JOptionPane.CANCEL_OPTION);
		}
		catch(SQLException se)
		{
			JOptionPane.showMessageDialog(null, "Error occured while entering data into database", "Error in AddModel",JOptionPane.OK_OPTION);
			se.printStackTrace();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Error, Contact Admin", "Error in AddModel",JOptionPane.OK_OPTION);
			e.printStackTrace();
		}
		
	}
}
