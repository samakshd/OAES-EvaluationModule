import { useEffect, useState } from "react";
import { AdminQuery } from "../components/adminQuery/AdminQuery";
import { serverUrl } from "../config";
import { Notification } from "../components/notification/Notification";

export function Admin(){
    const [queries, setQueries] = useState([]);
    const [notifications, setNotifications] = useState([]);

    useEffect(()=>{
        fetch(`${serverUrl}/getAllNewQueries`)
        .then(res=>res.json())
        .then(json=>setQueries(json))
    },[]);

    useEffect(()=>{
        fetch(`${serverUrl}/getAllNotifications`)
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
            <summary>Queries Pending Appoval</summary>
            {
                queries.map(query=>
                    <AdminQuery key={query.id} query={query}/>
                )
            }
        </details>
        
    </>)
}