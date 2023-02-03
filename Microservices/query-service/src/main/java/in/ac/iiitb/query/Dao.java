package in.ac.iiitb.query;

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

    public int insertQuery(Query q){
        try{
        
            Connection connection = this.getConnection();
            System.out.println(connection==null);
            Statement statement  = connection.createStatement();
            
            int recordsInserted =  statement.executeUpdate("insert into queries(questionId, queryText, queryResponseText, queryState, type, studentId) values("
                +q.getQuestionId()+",'"+q.getQueryText()+"','"+q.getQueryResponseText()+"','Query Raised','"+q.getType()+"',"+q.getStudentId()
            +")");
            connection.close();
            return recordsInserted;
            
          
        }
        catch(Exception e){return 0;}
    }
    
    public List<Query> getAllNewQueries(){
        try{
        
            Connection connection = this.getConnection();
            System.out.println(connection==null?"No COnnection":"");
            Statement statement  = connection.createStatement();
            
            ResultSet resultSet =  statement.executeQuery("select * from queries where queryState='Query Raised'");
            
            List<Query> queries = new ArrayList<Query>();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                int questionId = resultSet.getInt("questionId");
                String queryText = resultSet.getString("queryText");
                String queryResponseText = resultSet.getString("queryResponseText");
                String queryState = resultSet.getString("queryState");
                String type = resultSet.getString("type");
                int studentId = resultSet.getInt("studentId");
                
                
                queries.add(new Query(id, studentId, questionId, queryText, queryResponseText, queryState,  type));
            }
            
            connection.close();
            
            return queries;
        }
        catch(Exception e){return new ArrayList<Query>();}
    }
    
    public List<Query> getAllPendingQueries(int itemAuthorId){
        try{
        
            Connection connection = this.getConnection();
            System.out.println(connection==null);
            Statement statement  = connection.createStatement();
            
            ResultSet resultSet =  statement.executeQuery("select * from queries where queries.questionId in ( select id from questions where itemAuthorId = "+itemAuthorId+") and  queryState='Pending Review'");
            
            List<Query> queries = new ArrayList<Query>();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                int questionId = resultSet.getInt("questionId");
                String queryText = resultSet.getString("queryText");
                String queryResponseText = resultSet.getString("queryResponseText");
                String queryState = resultSet.getString("queryState");
                String type = resultSet.getString("type");
                int studentId = resultSet.getInt("studentId");
                
                
                queries.add(new Query(id, studentId, questionId, queryText, queryResponseText, queryState,  type));
            }
            
            connection.close();
            
            return queries;
        }
        catch(Exception e){return new ArrayList<Query>();}
    }
    
    public int approveQuery(int id, String queryResponseText){
        try{
        
            Connection connection = this.getConnection();
            System.out.println(connection==null);
            Statement statement  = connection.createStatement();
            
            int recordsInserted =  statement.executeUpdate("update queries set queryResponseText='"+queryResponseText+"', queryState='Pending Review' where id="+id);
            connection.close();
            return recordsInserted;
            
          
        }
        catch(Exception e){return 0;}
    }
    
    public int rejectQuery(int id, String queryResponseText){
        try{
        
            Connection connection = this.getConnection();
            System.out.println(connection==null);
            Statement statement  = connection.createStatement();
            
            int recordsInserted =  statement.executeUpdate("update queries set queryResponseText='"+queryResponseText+"', queryState='Rejected' where id="+id);
            connection.close();
            return recordsInserted;
            
          
        }
        catch(Exception e){return 0;}
    }
}
