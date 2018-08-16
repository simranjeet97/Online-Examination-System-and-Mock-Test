package conn;
import Conn.connection;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.scripts.JO;
import pogos.employee;

/**
 *
 * @author Itsexceptional
 */
public class Methods {
    
    
    public static  boolean emailvalidation(String email) {
    boolean status;
    String Email_Pattern ="^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$";
   
    Pattern pattern=Pattern.compile(Email_Pattern);
    Matcher matcher=pattern.matcher(email);
    if(matcher.matches())
    {
        status=true;
    }
    else
    {
        status=false;
    }
    return status;
    }
  
    public static void main(String[] args) 
    {
        
        
        String username="Simran";
        String pass="sammy1998";
        Methods um=new Methods();
        try
        {
            int sm=um.checkUserStatus("Simran","1234","verified");
            if(sm==1)
            {
                JOptionPane.showMessageDialog(null,"Valid");
                      
            }
            else if(sm==2)
            {
                JOptionPane.showMessageDialog(null,"Invalid");
            }
            else
            {
            }
        }
            catch(Exception e)
                    {
                    JOptionPane.showMessageDialog(null,"Exception"+e.getMessage());
                    }
        }
    public String getPassword(String name)throws Exception
    {
        String pass=null;
        String Query="select * from employee where emp_name='"+name+"'";
        Connection con=connection.getConnection("bugdb");
        PreparedStatement ps=con.prepareStatement(Query);
        ResultSet rs=ps.executeQuery();
        if(rs!=null)
        {
            while(rs.next())
            {
                pass=rs.getString("pass");
            }
            return pass;
            }
       else
        {
            pass=null;
        }
        return pass;
    }
    public String getStatus(String name)throws Exception
    {
        String status=null;
        String Query="select * from employee where emp_name='"+name+"'";
        Connection con=connection.getConnection("bugdb");
        PreparedStatement ps=con.prepareStatement(Query);
        ResultSet rs=ps.executeQuery();
        if(rs!=null)
        {
            while(rs.next())
            {
               status=rs.getString("status");
            }
            return status;
            }
       else
        {
            status=null;
        }
        return status;
    }
    
     public int checkUserPass(String name,String pass)throws Exception
    {
        Methods usermethods=new Methods();
        String dbpassword=usermethods.getPassword(name);
        
        if(dbpassword!=null)
        {
            System.out.println("valid user"+dbpassword); 
            if(dbpassword.equals(pass))
            {
                return 1; 
            }
            else
            {
                return 2;
            }
        }
        else{
            
            return 0;
        }
    }
    
      public int checkUserStatus(String name,String pass, String status)throws Exception
    {
        Methods usermethods=new Methods();
        String dbpassword=usermethods.getPassword(name);
        String dbstatus=usermethods.getStatus(name);
    
        if(dbpassword!=null && dbstatus!=null)
        {
            System.out.println("valid user"+dbpassword+dbstatus); 
            if(dbpassword.equals(pass) && dbstatus.equals("verified"))
            {
                return 1; 
            }
            else
            {
                return 2;
            }
        }
        else{
            
            return 0;
        }
    }
    
    
    public int checkUser(String username,String email)throws Exception
    {
        Methods usermethods=new Methods();
        String dbemail=usermethods.getPassword(username);
        if(dbemail!=null)
        {
            //System.out.println("valid user"+dbpassword);
            if(dbemail.equals(email))
            {
                return 1;
            }
            else
            {
                return 2;
            }
        }
        else{
            
            return 0;
        }
    }
    ImageIcon format;
    // Fetch Employee Data
public employee getEmployee(String ustatus)throws Exception
    {
    employee p=null;
    ResultSet rs=getResultSetEmp(ustatus);
            if(rs!=null)
            {

            while (rs.next())
            {
                String uname=rs.getString("emp_name");
                String pass=rs.getString("pass");
                String gender=rs.getString("gender");
                String email=rs.getString("email_id");
                String city=rs.getString("emp_city");
                String contact=rs.getString("emp_contact");
                String role=rs.getString("role");
                byte[] imagedata=rs.getBytes(9);
                String status=rs.getString("status");
                format=new ImageIcon(imagedata);
                String result=rs.getString("result");
                
                p=new employee(uname, pass, gender, email, city, contact, role, imagedata, status, result);
            }
         }
    return p;
    }
public ResultSet getResultSetEmp(String ustatus)throws Exception 
    {
    Connection con=connection.getConnection("bugdb");
        PreparedStatement ps=con.prepareStatement("select * from employee where status=?");
        ps.setString(1,ustatus);
        ResultSet rs=ps.executeQuery();
        return rs;
    }

public  ArrayList<employee> getAllEmployee()throws Exception
    {
        
    ArrayList<employee> dd=new ArrayList<>();
    ResultSet rs=getResultSetEmployee();
            if(rs!=null)
            {

            while (rs.next())
            {
                              String uname=rs.getString("emp_name");
                String pass=rs.getString("pass");
                String gender=rs.getString("gender");
                String email=rs.getString("email_id");
                String city=rs.getString("emp_city");
                String contact=rs.getString("emp_contact");
                String role=rs.getString("role");
                byte[] imagedata=rs.getBytes(9);
                String status=rs.getString("status");
                format=new ImageIcon(imagedata);
                String result=rs.getString("result");
                employee p=new employee(uname, pass, gender, email, city, contact, role, imagedata, status, result);
 
                dd.add(p);
            }
            }
    
    return dd;
       
    }
public ResultSet getResultSetEmployee()throws Exception 
    {
    Connection con=connection.getConnection("bugdb");
        PreparedStatement ps=con.prepareStatement("select * from employee");
        ResultSet rs=ps.executeQuery();
        return rs;
    }

 public int update(String username)throws Exception
    {
        Connection con=connection.getConnection("bugdb");
        PreparedStatement pp=con.prepareStatement("update employee set status='verified' where emp_name=?");
        pp.setString(1, username);
        int noros=pp.executeUpdate();
        return noros;
    }
 public int updateResults(String uname,String result)throws Exception
 {
        Connection con=connection.getConnection("bugdb");
        PreparedStatement pp=con.prepareStatement("update employee set result=? where emp_name=?");
        pp.setString(1, result);
        pp.setString(2, uname);
        int noros=pp.executeUpdate();
        return noros;
     
 }
 
 public int updatePass(String uname,String pass)throws Exception
 {
        Connection con=connection.getConnection("bugdb");
        PreparedStatement pp=con.prepareStatement("update employee set pass=? where emp_name=?");
        pp.setString(1, pass);
        pp.setString(2, uname);
        int noros=pp.executeUpdate();
        return noros;
     
 }
   
}