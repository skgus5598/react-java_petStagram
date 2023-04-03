import "./../App.css"
import React, {useState} from "react";
import axios from "axios";
import { useNavigate} from "react-router-dom";

function RegisterPage(){
    let navigate = useNavigate();

    let [id, setId] = useState('');
    let [nickName, setNickName] = useState('');
    let [pwd, setPwd] = useState('');
    let [question, setQuestion] = useState('');
    let [answer, setAnswer] = useState('');

    let onSubmitHandler = (e) => {
        e.preventDefault();

        axios.post('http://localhost:8888/registerUser', {
                userId : id,
                userPwd : pwd,
                userNick : nickName,
                question : question,
                answer  : answer
            }, {
            headers: {"Content-Type": "application/json"}
        })
            .then( (res) => {
                if(res.data == 1 ){
                    alert("회원가입 성공~^^")
                    return navigate('/main')
                }else{
                    alert("이미 존재하는 아이디 입니다 ㅜ ")
                }
            })
    }


    return(
        <div className="login-page">
            <div className="login-form">
                <h1 className="login-header">SIGN IN</h1>
                <form onSubmit={onSubmitHandler}>
                    <input className="input-field" placeholder='Id' type='text' onChange={(e)=>{setId(e.target.value)}} /><br/><br/>
                    <input className="input-field" placeholder='NickName' type='text' onChange={(e)=>{setNickName(e.target.value)}}/><br/><br/>
                    <input className="input-field" type='text' placeholder='Password' onChange={(e)=>{setPwd(e.target.value)}} /><br/><br/>
                    <select className="input-field" onChange={(e)=>{setQuestion(e.target.value)}}>
                        <option value=''> (필수)</option>
                        <option value='1'>제일 좋아하는 동물 뭐야?</option>
                        <option value='2'>뭐 싫어해? </option>
                        <option value='3'>뭐 좋아해?</option>
                    </select><br/><br/>
                    <input className="input-field" type='text' placeholder='Answer' onChange={(e)=>{setAnswer(e.target.value)}} /><br/><br/>
                    <button className="login-button" type="submit" >Sign In</button>
                </form>
                <hr />
                <div className="create-account">
                    <a href="#" onClick={ () => { navigate('/')}}>Already have an account? Log In</a>
                </div>
            </div>


        </div>
    );
};
export default RegisterPage;