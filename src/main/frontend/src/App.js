import './App.css';
import {Routes, Link, Route, useNavigate, Outlet} from "react-router-dom";
import LoginPage from "./component/LoginPage";
import RegisterPage from "./component/RegisterPage";
import MainPage from "./component/MainPage";

function App() {
  return (
    <div className="App">
        <h1 style={ {textAlign : "center"}}>PetStagram</h1>
        <Outlet/>

        <Routes>
            <Route path="/" element={ <LoginPage/> }></Route>
            <Route path="/register" element={ <RegisterPage />}></Route>
            <Route path='/main' element={ <MainPage /> }></Route>
            <Route></Route>
        </Routes>

    </div>
  );
}

export default App;
