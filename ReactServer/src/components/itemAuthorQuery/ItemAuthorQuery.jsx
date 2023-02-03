import { useState } from "react";
import { serverUrl } from "../../config";
export function ItemAuthorQuery(props){
    const [proposedQuestion, setProposedQuestion] = useState('');
    const [proposedSolution, setProposedSolution] = useState('');
    const [rejectString, setRejectString] = useState('');
    
    return(<>
        <div>
            <strong>Query</strong>: {props.query.queryText}
        </div>
        <div>
            <input placeholder="Proposed Question" value={proposedQuestion} onChange={(e)=>{setProposedQuestion(e.target.value)}}/>
            <input placeholder="Proposed Solution" value={proposedSolution} onChange={(e)=>{setProposedSolution(e.target.value)}}/>
            <button onClick={()=>{
                fetch(`${serverUrl}/modifyQuestionByQuery`,{
                    method: 'POST',
                    headers: {'Content-Type': 'application/json'},
                    body:JSON.stringify({
                        queryId:props.query.id,
                        questionId:props.query.questionId,
                        questionText:proposedQuestion,
                        solutionProposed:proposedSolution

                    })
                }).then((e)=>{window.alert("Query modified");window.location.reload();});
            }}>
                Modify Question
            </button>
        </div>
        <div>
            <input placeholder="Reason for Rejection" value={rejectString} onChange={(e)=>{setRejectString(e.target.value)}}/>
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