import { useState } from "react";
import { serverUrl } from "../../config";

export function QuestionQuery(props){
    const [query, setQuery] = useState('');
    return(<>
        <div>
            <strong>Question</strong>: {props.question.questionText}
        </div>
        <div>
            <input value={query} onChange={(e)=>{setQuery(e.target.value)}}/>
            <button onClick={()=>{
                fetch(`${serverUrl}/insertQuery`,{
                    method: 'POST',
                    headers: {'Content-Type': 'application/json'},
                    body:JSON.stringify({
                        studentId:props.studentId,
                        questionId: props.question.id,
                        queryText: query,
                        queryResponseText:'',
                        queryState: 'Question Created',
                        type: 'Question Query'
                    })
                }).then((e)=>{window.alert("Query raised");window.location.reload();});
        
            }}>
                Raise Question Query
            </button>
        </div>
    </>)
}