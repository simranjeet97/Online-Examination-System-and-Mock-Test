/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Itsexceptional
 */
public class Methods2 {
    public int addCourse(String course)throws Exception
    {
        Connection cm=connection2.getConnection("bug2db");
        PreparedStatement one = cm.prepareStatement("insert into courses(course_name) values ('"+course+"')");
        if(one.executeUpdate()==1){ 
            PreparedStatement ps=cm.prepareStatement("create table "+course+" ( id int primary key auto_increment, questions varchar(200), answer_one varchar(200), answer_two varchar(200), answer_three varchar(200), answer_four varchar(200), correct_ans varchar(200),ques_id varchar(200));");        
            int ros=ps.executeUpdate();
            return ros;
        }
        else
        {
            return 1;
        }
        
    }
    
    public int deleteCourse(String course)throws Exception
    {
        Connection cm=connection2.getConnection("bug2db");
        PreparedStatement one = cm.prepareStatement("delete from courses where course_name='"+course+"'");
        if(one.executeUpdate()==1){ 
            PreparedStatement ps=cm.prepareStatement("drop table "+course+"" );
            int ros=ps.executeUpdate();
            return ros;
        }
        else
        {
            return 1;
        }
        
    }
    
     public int AddQues(String course,String questions,String answer_one,String answer_two,String answer_three,String answer_four,String correct_answer, String ques_id)throws Exception
    {
        Connection cm=connection2.getConnection("bug2db");
        PreparedStatement ps=cm.prepareStatement("insert into "+course+" (questions,answer_one,answer_two,answer_three,answer_four,correct_ans,ques_id) values('"+questions+"','"+answer_one+"','"+answer_two+"','"+answer_three+"','"+answer_four+"','"+correct_answer+"','"+ques_id+"')");
        int ros=ps.executeUpdate();
        return ros;
    }
     
     public int UpdateQues(String quesid,String course,String questions,String ans_one,String ans_two,String ans_three,String ans_four,String cor_ans)throws Exception
    {
        Connection con=connection.getConnection("bug2db");
        PreparedStatement pp=con.prepareStatement("update "+course+" set questions=?,answer_one=?,answer_two=?,answer_three=?,answer_four=?,correct_ans=? where ques_id=?");
        pp.setString(1,questions);
        pp.setString(2, ans_one);
        pp.setString(3, ans_two);
        pp.setString(4, ans_three);
        pp.setString(5, ans_four);
        pp.setString(6, cor_ans);
        pp.setString(7, quesid);
        int noros=pp.executeUpdate();
        return noros;
    }
     
      public int DeleteQues(String course,String questions,String answer_one,String answer_two,String answer_three,String answer_four,String correct_answer, String ques_id)throws Exception
    {
        Connection cm=connection2.getConnection("bug2db");
        PreparedStatement ps=cm.prepareStatement("delete from "+course+" where ques_id='"+ques_id+"'");
        int ros=ps.executeUpdate();
        return ros;
    }
    
}
