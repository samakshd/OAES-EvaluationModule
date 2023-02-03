import { Admin } from "./pages/Admin";
import { ItemAuthor } from "./pages/ItemAuthor";
import { Student } from "./pages/Student";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import {HomePage } from "./pages/Homepage"
function App() {      
  return (
    <BrowserRouter>
      <Routes>
          <Route path="/student1" element={<Student id={1}/>} />
          <Route path="/student2" element={<Student id={2}/>} />
          <Route path="/student3" element={<Student id={3}/>} />
          <Route path="/admin" element={<Admin />} />
          <Route path="/itemAuthor1" element={<ItemAuthor id={1}/>} />
          <Route path="/itemAuthor2" element={<ItemAuthor id={2}/>} />
          <Route path="/itemAuthor3" element={<ItemAuthor id={3}/>} />

          <Route path="/" element={<HomePage/>} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
