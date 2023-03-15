import React, { useState, useEffect } from "react";
import axios from "axios";

function LoginPage(){
    const [loginId, setLoginId] = useState("");
    const [password, setPassword] = useState("");

    const getLoginId = (e) => {
        setLoginId(e.target.value)
        console.log("id :: " + e.target.value);
    }
    const getPassword = (e) => {
        setPassword(e.target.value)
        console.log("pwd :: " + e.target.value);
    }



    const login = () => {
        axios.post('http://localhost:8888/loginUser', {
            userId : loginId,
            userPwd : password
        }, {
            headers : {
                "Content-Type" : "application/json"
            }
        })
            .then(res => console.log("결과값 :: " + JSON.stringify(res.data)))
            .catch()
    };



    return(
        <div>
            <form>
                <h2>여기는 로그인 페이지 </h2>
                <input type='text' name={loginId} value={loginId} onChange={getLoginId}/><br/><br/>
                <input type='text' name={password} value={password} onChange={getPassword}/><br/><br/>
                <button type='button' onClick={login}>로그인</button>
            </form>
        </div>
    )
}
export default LoginPage;
