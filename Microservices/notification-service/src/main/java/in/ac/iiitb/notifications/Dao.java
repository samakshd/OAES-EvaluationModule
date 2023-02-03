package in.ac.iiitb.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;
import java.sql.*;

public class Dao {
    @Autowired JdbcTemplate jdbcTemplate;
    private Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://sql6.freesqldatabase.com:3306/sql6581232", "sql6581232", "x8Bexbxtxb");
        }
        catch (Exception e) {
            return null;
        }
        
        
    }
    public List<Notification> getStudentNotifications(int studentId){
        try{
        
            Connection connection = this.getConnection();
            System.out.println(connection==null);
            Statement statement  = connection.createStatement();
            
            ResultSet resultSet =  statement.executeQuery("select * from queries where studentId="+studentId);
            
            List<Notification> notifications = new ArrayList<Notification>();
            while(resultSet.next()){
                int questionId = resultSet.getInt("questionId");
                String queryText = resultSet.getString("queryText");
                String queryResponseText = resultSet.getString("queryResponseText");
                String queryState = resultSet.getString("queryState");
                
                notifications.add(new Notification(questionId,queryText,queryState,queryResponseText));
            }
            
            connection.close();
            
            return notifications;
        }
        catch(Exception e){return new ArrayList<Notification>();}
    }

    public List<Notification> getAllNotifications(){
        try{
        
            Connection connection = this.getConnection();
            System.out.println(connection==null);
            Statement statement  = connection.createStatement();
            
            ResultSet resultSet =  statement.executeQuery("select * from queries");
            
            List<Notification> notifications = new ArrayList<Notification>();
            while(resultSet.next()){
                int questionId = resultSet.getInt("questionId");
                String queryText = resultSet.getString("queryText");
                String queryResponseText = resultSet.getString("queryResponseText");
                String queryState = resultSet.getString("queryState");
                
                notifications.add(new Notification(questionId,queryText,queryState,queryResponseText));
            }
            
            connection.close();
            
            return notifications;
        }
        catch(Exception e){return new ArrayList<Notification>();}
    }
}
