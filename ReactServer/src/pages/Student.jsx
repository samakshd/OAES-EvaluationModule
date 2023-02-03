import { useEffect, useState } from "react";
import { QuestionQuery } from "../components/questionQuery/QuestionQuery";
import {serverUrl} from "../config";
import { Notification } from "../components/notification/Notification";
export function Student(props){
    const [questions, setQuestions] = useState([]);
    const [notifications, setNotifications] = useState([]);

    useEffect(()=>{
        fetch(`${serverUrl}/getAllQuestions`)
        .then(res=>res.json())
        .then(json=>setQuestions(json))
    },[]);

    useEffect(()=>{
        fetch(`${serverUrl}/getStudentNotifications?studentId=${props.id}`)
        .then(res=>res.json())
        .then(json=>setNotifications(json.map((notification,index)=>{
            return {...notification, id:index}
        })))
    },[]);

    return(<>
        <details>
            <summary>Notifications</summary>
            <table>
                <tr>
                    <th>Question Number</th>
                    <th>Query</th>
                    <th>Question Status</th>
                    <th>Comment</th>
                </tr>
            {
                notifications.map((notification)=>
                    <Notification key={notification.id} notification={notification}/>
                )
            }
            </table>
        </details>
        <details>
            <summary>Questions</summary>
        {
            questions.map(question=>
                <QuestionQuery key={question.id} question={question} studentId={props.id}/>
            )
        }
        </details>
        
    </>)
}