package in.ac.iiitb.questions;

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
    public List<Question> getAllQuestions(){
        try{
        
            Connection connection = this.getConnection();
            System.out.println(connection==null);
            Statement statement  = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from questions");
            
            List<Question> questions = new ArrayList<Question>();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String questionText = resultSet.getString("questionText");
                String solutionProposed = resultSet.getString("solutionProposed");
                int itemAuthorId = resultSet.getInt("itemAuthorId");
                questions.add(new Question(id,type,questionText, solutionProposed, itemAuthorId));
            }
            
            connection.close();
            return questions;
        }
        catch(Exception e){
            return new ArrayList<Question>();
        }
    }

    public boolean modifyQuestionByQuery(int queryId, int questionId, String questionText, String solutionProposed){
        try{
        
            Connection connection = this.getConnection();
            System.out.println(connection==null);
            Statement statement  = connection.createStatement();
            
            int recordsUpdated =  statement.executeUpdate("update questions set questionText='"+questionText+"', solutionProposed='"+solutionProposed+"' where id="+questionId);
            recordsUpdated +=  statement.executeUpdate("update queries set queryResponseText='Query considered by item author', queryState='Approved' where id="+queryId);
            connection.close();
            
            return recordsUpdated==2;
            
        }
        catch(Exception e){return false;}
    }
}
