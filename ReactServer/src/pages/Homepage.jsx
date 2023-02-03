import { Link } from "react-router-dom";
export function HomePage(){
    return(<>
        <ul>
            <li><Link to="/student1">Student 1</Link></li>
            <li><Link to="/student2">Student 2</Link></li>
            <li><Link to="/student3">Student 3</Link></li>
            <li><Link to="/admin">Admin</Link></li>
            <li><Link to="/itemAuthor1">Item Author 1</Link></li>
            <li><Link to="/itemAuthor2">Item Author 2</Link></li>
            <li><Link to="/itemAuthor3">Item Author 3</Link></li>
        </ul>
        
    </>)
}