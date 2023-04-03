import React, { useState, useEffect } from "react";
import "./../App.css"
import axios from "axios";
import { useNavigate } from "react-router-dom";
import MainPage from "./MainPage";

function LoginPage(){
    let navigate = useNavigate();

    const [loginId, setLoginId] = useState("");
    const [password, setPassword] = useState("");

    const getLoginId = (e) => {
        setLoginId(e.target.value)
    }
    const getPassword = (e) => {
        setPassword(e.target.value)
    }



    const onSubmitHandler = (e) => {
        e.preventDefault(); // 페이지 리프레시 방지

        axios.post('http://localhost:8888/loginUser', {
            userId : loginId,
            userPwd : password
        }, {
            headers : {
                "Content-Type" : "application/json"
            }
        })
            .then( (res) => {
                console.log("result : " + res.data)
                if(res.data == 1){
                   return navigate('/main');
                }else if(res.data == 0){
                    alert("비밀번호가 틀렸습니다");
                }else{
                    alert("등록되지 않은 유저입니다.")
                }
            })
            .catch()
    };



    return(
        <div className="login-page">
            <div className="login-form">
                <h1 className="login-header">LOG IN</h1>
                <form onSubmit={onSubmitHandler} >
                    <input className="input-field" placeholder='Email or Phone' type='text' name={loginId} value={loginId} onChange={getLoginId}/><br/><br/>
                    <input className="input-field" type='text' placeholder='Password' name={password} value={password} onChange={getPassword}/><br/><br/>
                    <button className="login-button" type="submit"  >login</button>
                </form>
                <hr />
                <div className="create-account">
                    <a href="#" onClick={ () => { navigate('/register')}}>Create New Account</a>
                </div>
            </div>


        </div>
    )
}
export default LoginPage;
