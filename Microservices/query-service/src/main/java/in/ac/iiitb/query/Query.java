package in.ac.iiitb.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Query {
    private int id;
    private int studentId;
    private int questionId;
    private String queryText;
    private String queryResponseText;
    private String queryState;
    private String type;    
}
