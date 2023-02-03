import { useEffect, useState } from "react";
import { ItemAuthorQuery } from "../components/itemAuthorQuery/ItemAuthorQuery";
import { serverUrl } from "../config";

export function ItemAuthor(props){
    const [queries, setQueries] = useState([]);
    useEffect(()=>{
        fetch(`${serverUrl}/getAllPendingQueries?itemAuthorId=${props.id}`)
        .then(res=>res.json())
        .then(json=>setQueries(json))
    },[]);
    return(<>
        {
            queries.map(query=>
                <ItemAuthorQuery key={query.id} query={query} id={props.id}/>
            )
        }
        
    </>)
}