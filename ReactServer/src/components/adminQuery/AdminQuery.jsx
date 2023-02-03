import { useState } from "react";
import { serverUrl } from "../../config";
export function AdminQuery(props){
    const [acceptString, setAcceptString] = useState('');
    const [rejectString, setRejectString] = useState('');
    
    return(<>
        <div>
            <strong>Query</strong>: {props.query.queryText}
        </div>
        <div>
            <input value={acceptString} onChange={(e)=>{setAcceptString(e.target.value)}}/>
            <button onClick={()=>{
                fetch(`${serverUrl}/approveQuery`,{
                    method: 'POST',
                    headers: {'Content-Type': 'application/json'},
                    body:JSON.stringify({
                        id:props.query.id,
                        queryResponseText:acceptString,
                    })
                }).then((e)=>{window.alert("Query approved");window.location.reload();});
            }}>
                Accept Query
            </button>
        </div>
        <div>
            <input value={rejectString} onChange={(e)=>{setRejectString(e.target.value)}}/>
            <button onClick={()=>{
                fetch(`${serverUrl}/rejectQuery`,{
                    method: 'POST',
                    headers: {'Content-Type': 'application/json'},
                    body:JSON.stringify({
                        id:props.query.id,
                        queryResponseText:rejectString,
                    })
                }).then((e)=>{window.alert("Query rejected");window.location.reload();});
            }}>
                Reject Query
            </button>
        </div>
    </>)
}