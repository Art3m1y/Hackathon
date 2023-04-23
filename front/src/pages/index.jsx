import React, {useState} from 'react';
import {useNavigate} from "react-router";
import axios from "axios";

const Index = () => {

    const navigate = useNavigate();

    const [login, setLogin] = useState("");
    const [password, setPassword] = useState("");
    const handleSubmit = (e) => {
        e.preventDefault();
        axios
            .request({
                method: 'post',
                url: 'https://credit.art3m1y.me/api/auth/login',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: {
                    username: login,
                    password: password
                }
            })
            .then(response => {
                console.log(response.data);
                localStorage.setItem("accessToken", response.data.access_token);
                navigate("/admin")
            })
            .catch(error => {
                alert("Ошибка.");
                console.log(error);
            });
    };

    return (
        <div className="w-full flex justify-center items-center">
            <form className="lg:w-2/6 md:w-1/2 bg-gray-800 bg-opacity-50 rounded-lg p-8 flex flex-col w-full mt-10 md:mt-0 max-h-[350px]">
                <h2 className="text-white text-lg font-medium title-font mb-5">Вход в систему</h2>
                <div className="relative mb-4">
                    <label htmlFor="login" className="leading-7 text-sm text-gray-400">Логин</label>
                    <input value={login} onChange={event => setLogin(event.target.value)} type="text" id="login" name="login"
                           className="w-full bg-gray-600 bg-opacity-20 focus:bg-transparent focus:ring-2 focus:ring-green-900 rounded border border-gray-600 focus:border-green-500 text-base outline-none text-gray-100 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"
                    required/>
                </div>
                <div className="relative mb-4">
                    <label htmlFor="password" className="leading-7 text-sm text-gray-400">Пароль</label>
                    <input value={password} onChange={event => setPassword(event.target.value)} type="password" id="password" name="password"
                           className="w-full bg-gray-600 bg-opacity-20 focus:bg-transparent focus:ring-2 focus:ring-green-900 rounded border border-gray-600 focus:border-green-500 text-base outline-none text-gray-100 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"
                    required/>
                </div>
                <button className="text-white bg-green-500 border-0 py-2 px-8 focus:outline-none hover:bg-green-600 rounded text-lg"
                    onClick={handleSubmit}>
                    Войти
                </button>
                <p className="text-xs mt-3"></p>
            </form>
        </div>
    );
};

export default Index;