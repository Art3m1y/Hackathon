import React, {useState} from 'react';
import {Link} from "react-router-dom";
import axios from "axios";

const AgentRegister = () => {

    const [form, setForm] = useState({name: "", login: ""});

    // РЕГИСТРАЦИЯ АГЕНТА
    const clickHandler = (e) => {
        e.preventDefault()
        console.log(form.name, form.login)
        axios
            .request({
                method: 'post',
                url: 'https://credit.art3m1y.me/api/agent',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: {
                    name: form.name,
                    login: form.login
                }
            })
            .then(data => {
                setForm({name: "", login: ""})
                alert("Агент успешно зарегистрирован.")
            })
            .catch(error => {
                alert("Ошибка регистрации агента");
                console.log(error);
            });
    }

    const changeHandlerName = (newValue) => {
        setForm({...form, name: newValue})
    }

    const changeHandlerLogin = (newValue) => {
        setForm({...form, login: newValue})
    }

    return (
        <div className="w-full h-screen flex items-center">
            <form className="max-w-[500px] md:w-1/2 bg-gray-800 bg-opacity-50 rounded-lg p-8 flex flex-col mx-auto w-full mt-10 md:mt-0 max-h-[350px]">
                <h2 className="text-white text-lg font-medium title-font mb-5">Регистрация агента</h2>
                <div className="relative mb-4">
                    <label htmlFor="name" className="leading-7 text-sm text-gray-400">ФИО</label>
                    <input value={form.name} onChange={event => changeHandlerName(event.target.value)} type="text" id="name" name="name"
                           className="w-full bg-gray-600 bg-opacity-20 focus:bg-transparent focus:ring-2 focus:ring-green-900 rounded border border-gray-600 focus:border-green-500 text-base outline-none text-gray-100 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"/>
                </div>
                <div className="relative mb-4">
                    <label htmlFor="login" className="leading-7 text-sm text-gray-400">Логин</label>
                    <input value={form.login} onChange={event => changeHandlerLogin(event.target.value)} type="text" id="login" name="login"
                           className="w-full bg-gray-600 bg-opacity-20 focus:bg-transparent focus:ring-2 focus:ring-green-900 rounded border border-gray-600 focus:border-green-500 text-base outline-none text-gray-100 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"/>
                </div>
                <div className="flex justify-between gap-5">
                    <Link to="/admin/adminPanel" className="basis-1/2 text-white bg-green-500 border-0 py-2 px-8 focus:outline-none hover:bg-green-600 rounded text-lg">
                        Главная
                    </Link>
                    <button className="basis-1/2 text-white bg-green-500 border-0 py-2 px-8 focus:outline-none hover:bg-green-600 rounded text-lg"
                            onClick={clickHandler}>
                        Добавить
                    </button>
                </div>
                <p className="text-xs mt-3"></p>
            </form>
        </div>
    );
};

export default AgentRegister;