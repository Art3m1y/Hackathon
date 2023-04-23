import React, {useEffect, useState} from 'react';
import MainLayout from "../../components/mainLayout/mainLayout";
import {Link} from "react-router-dom";
import axios from "axios";

const Agents = () => {

    const [data, setData] = useState([
        {id: 1, name: "Горбатов Вадим Владимирович", login: "admin"},
        {id: 2, name: "Имя", login: "q7394325"}
    ]);

    // ПОЛУЧЕНИЕ ВСЕХ АГЕНТОВ
    useEffect(() => {
        axios
            .get("https://credit.art3m1y.me/api/agent")
            .then(response => {
                console.log(response)
                setData(response);
            })
            .catch(error => {
                console.log("Ошибка получения данных.");
                console.log(error);
                return [];
            })
    }, []);


    // ИЗМЕНЕНИЕ ИМЕНИ АГЕНТА
    const changeHandlerName = (agentId, newValue) => {
        const editedAgent = data.filter(item => item.id === agentId)[0];
        axios
            .request({
                method: 'put',
                url: 'https://credit.art3m1y.me/api/agent',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: {
                    name: editedAgent.name,
                    login: editedAgent.login
                }
            })
            .then(response => {
                const newData = data.map(item => {
                    if (item.id === agentId) return {...item, name: newValue}
                    return item
                })
                setData(newData)
            })
            .catch(error => {
                console.log("Ошибка. Данные не изменены.");
                // console.log(error);
            });
    }

    // ИЗМЕНЕНИЕ ЛОГИНА АГЕНТА
    const changeHandlerLogin = (agentId, newValue) => {
        const editedAgent = data.filter(item => item.id === agentId)[0];
        axios
            .request({
                method: 'put',
                url: 'https://credit.art3m1y.me/api/agent',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: {
                    name: editedAgent.name,
                    login: editedAgent.login
                }
            })
            .then(response => {
                const newData = data.map(item => {
                    if (item.id === agentId) return {...item, login: newValue}
                    return item
                })
                setData(newData)
            })
            .catch(error => {
                console.log("Ошибка. Данные не изменены.");
                // console.log(error);
            });
    }

    // УДАЛЕНИЕ АГЕНТА
    const deleteHandler = (agentId) => {
        axios
            .delete(`https://localhost/api/agent/${agentId}`)
            .then(data => {
                setData(prevState => prevState.filter(item => item.id !== agentId))
            })
            .catch(error => {
                alert("Ошибка получения данных");
                console.log(error);
            });
    }

    return (
        <MainLayout title="Кредитные агенты">
            <ul className="flex gap-5">
                <li><Link to="/admin">Главная</Link></li>
                <li><Link to="/agentRegister">Регистрация агента</Link></li>
            </ul>
            {data.length ? (
                <ul className="flex flex-col gap-10 mt-10">
                    {data.map((item) => (
                        <li key={item.id} className="flex flex-col gap-5">
                            <div className="relative">
                                <label htmlFor="name" className="leading-7 text-sm text-gray-400">ФИО</label>
                                <input value={item.name} onChange={event => changeHandlerName(item.id, event.target.value)} type="text" id="name" name="name"
                                       className="w-full bg-gray-600 bg-opacity-20 focus:bg-transparent focus:ring-2 focus:ring-green-900 rounded border border-gray-600 focus:border-green-500 text-base outline-none text-gray-100 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"
                                       required/>
                            </div>
                            <div className="relative">
                                <label htmlFor="code" className="leading-7 text-sm text-gray-400">Логин</label>
                                <input value={item.login} onChange={event => changeHandlerLogin(item.id, event.target.value)} type="text" id="code" name="code"
                                       className="w-full bg-gray-600 bg-opacity-20 focus:bg-transparent focus:ring-2 focus:ring-green-900 rounded border border-gray-600 focus:border-green-500 text-base outline-none text-gray-100 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"
                                       required/>
                            </div>
                            <div className="flex gap-5">
                                <button className="inline-flex text-white bg-green-500 border-0 py-2 px-6 focus:outline-none hover:bg-green-600 rounded"
                                        onClick={() => deleteHandler(item.id)}>
                                    Удалить
                                </button>
                                <Link to="/admin/connectStores" className="inline-flex text-white bg-green-500 border-0 py-2 px-6 focus:outline-none hover:bg-green-600 rounded">
                                    Подключённый точки
                                </Link>
                            </div>
                        </li>
                    ))}
                </ul>
            ) : <p className="mt-5 text-3xl">Агентов нет</p>}
        </MainLayout>
    );
};

export default Agents;