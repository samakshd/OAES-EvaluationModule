package in.ac.iiitb.questions;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class Controller {
    Dao dao = new Dao();

    @GetMapping("getAllQuestions")
    public List<Question> getAllQuestions(){
        return dao.getAllQuestions();
    }

    @PostMapping("modifyQuestionByQuery")
    public boolean modifyQuestionByQuery(@RequestBody ModifyQuestionParameters params){
        return dao.modifyQuestionByQuery(params.getQueryId(), params.getQuestionId(), params.getQuestionText(), params.getSolutionProposed());
    }
}
