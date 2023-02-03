package in.ac.iiitb.notifications;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController("/")
public class Controller {
    Dao dao = new Dao();

    @GetMapping("getAllNotifications")
    public List<Notification> getAllNotifications(){
        return dao.getAllNotifications();
    }
    
    @GetMapping("getStudentNotifications")
    public List<Notification> getStudentNotifications(@RequestParam int studentId){
        return dao.getStudentNotifications(studentId);
    }
}
