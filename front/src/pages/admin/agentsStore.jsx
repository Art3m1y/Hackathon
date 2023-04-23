import React, {useState} from 'react';
import MainLayout from "../../components/mainLayout/mainLayout";
import {Link} from "react-router-dom";

const AgentsStore = () => {

    const [data, setData] = useState([
        {id: 1, name: "Иванов ИВан Иванович", login: "q435gere"},
        {id: 2, name: "Горбатов Вадим Владимирович", login: "admin"}
    ]);

    const changeHandlerName = (agentId, newValue) => {
        const newData = data.map(item => {
            if (item.id === agentId) return {...item, name: newValue}
            else return item
        });
        setData(newData);
    }

    const changeHandlerLogin = (agentId, newValue) => {
        const newData = data.map(item => {
            if (item.id === agentId) return {...item, login: newValue}
            else return item
        });
        setData(newData);
    }

    const deleteHandler = (agentId) => {
        setData(prevState => prevState.filter(item => item.id !== agentId))
    }

    return (
        <MainLayout title="Агенты">
            <ul className="flex gap-5">
                <li><Link to="/admin/adminPanel">Главная</Link></li>
                <li><Link to="/admin/newAccess">Добавить доступ</Link></li>
            </ul>
            {
                data.length ? (
                    <ul className="flex flex-col gap-10 mt-10">
                        {data.map((item) => (
                            <li key={item.id} className="flex flex-col gap-5">
                                <div className="relative">
                                    <label htmlFor="name" className="leading-7 text-sm text-gray-400">Название</label>
                                    <input value={item.name} onChange={event => changeHandlerName(item.id, event.target.value)} type="text" id="name" name="name"
                                           className="w-full bg-gray-600 bg-opacity-20 focus:bg-transparent focus:ring-2 focus:ring-green-900 rounded border border-gray-600 focus:border-green-500 text-base outline-none text-gray-100 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"
                                           required/>
                                </div>
                                <div className="relative">
                                    <label htmlFor="code" className="leading-7 text-sm text-gray-400">Код магазина</label>
                                    <input value={item.login} onChange={event => changeHandlerLogin(item.id, event.target.value)} type="text" id="code" name="code"
                                           className="w-full bg-gray-600 bg-opacity-20 focus:bg-transparent focus:ring-2 focus:ring-green-900 rounded border border-gray-600 focus:border-green-500 text-base outline-none text-gray-100 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"
                                           required/>
                                </div>
                                <button className="inline-flex text-white bg-green-500 border-0 py-2 px-6 focus:outline-none hover:bg-green-600 rounded"
                                        onClick={() => deleteHandler(item.id)}>
                                    Закрыть доступ агенту
                                </button>
                            </li>
                        ))}
                    </ul>
                ) : <p className="mt-5 text-3xl">Кредитных агентов нет</p>
            }
        </MainLayout>
    );
};

export default AgentsStore;