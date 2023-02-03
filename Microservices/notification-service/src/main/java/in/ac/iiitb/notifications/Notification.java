package in.ac.iiitb.notifications;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    private int questionId;
    private String queryText;
    private String queryState;
    private String queryResponseText;
}
