package in.ac.iiitb.questions;

public class Question{
    private int id;
    private String type;
    private String questionText;
    private String solutionProposed;
    private int itemAuthorId;
    
    public Question(int id, String type, String questionText, String solutionProposed, int itemAuthorId){
        this.id = id;
        this.type = type;
        this.questionText = questionText;
        this.solutionProposed = solutionProposed;
        this.itemAuthorId = itemAuthorId;
    }
    
    public int getId(){return this.id;}
    
    public String getType(){return this.type;}
    
    public String getQuestionText(){return this.questionText;}
    
    public String getSolutionProposed(){return this.solutionProposed;}
    
    public int getItemAuthorId(){return this.itemAuthorId;}
}