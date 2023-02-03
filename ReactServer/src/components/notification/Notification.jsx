export function Notification(props){
    return(<tr>
        <td>
            {props.notification.questionId}
        </td>
        <td>
            {props.notification.queryText}
        </td>
        <td>
            {props.notification.queryState}
        </td>
        <td>
            {props.notification.queryResponseText}
        </td>
    </tr>)
}