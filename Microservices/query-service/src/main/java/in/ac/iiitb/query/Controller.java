package in.ac.iiitb.query;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController("/")
public class Controller {
    Dao dao = new Dao();

    @GetMapping("getAllNewQueries")
    public List<Query> getAllNewQueries(){
        return dao.getAllNewQueries();
    }

    @GetMapping("getAllPendingQueries")
    public List<Query> getAllPendingQueries(@RequestParam int itemAuthorId){
        return dao.getAllPendingQueries(itemAuthorId);
    }

    @PostMapping("approveQuery")
    public int approveQuery(@RequestBody ApproveQueryParameters params){
        return dao.approveQuery(params.getId(), params.getQueryResponseText());
    }

    @PostMapping("rejectQuery")
    public int rejectQuery(@RequestBody RejectQueryParameters params){
        return dao.rejectQuery(params.getId(), params.getQueryResponseText());
    }

    @PostMapping("insertQuery")
    public int insertQuery(@RequestBody Query q){
        return dao.insertQuery(q);
    }
}
