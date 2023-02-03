package in.ac.iiitb.questions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModifyQuestionParameters {
    private int queryId; 
    private int questionId;
    private String questionText;
    private String solutionProposed;
}
