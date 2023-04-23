import React from 'react';
import {Link} from "react-router-dom";

const NewAccess = () => {

    const agents = [
        {id: 1, name: "Агент1"},
        {id: 2, name: "Агент2"},
        {id: 3, name: "Агент3"}
    ]

    const stores = [
        {id: 1, name: "Тестовая1"},
        {id: 2, name: "Тестовая2"},
        {id: 3, name: "Тестовая3"}
    ]

    return (
        <div className="lg:w-2/6 md:w-1/2 bg-gray-800 bg-opacity-50 rounded-lg p-8 flex flex-col mx-auto w-full mt-10 md:mt-0">
            <h2 className="text-white text-lg font-medium title-font mb-5">Новый доступ</h2>
            <div className="relative mb-4">
                <label htmlFor="name" className="leading-7 text-sm text-gray-400">Кредитный агент</label>
                <select type="text" id="name" name="name"
                        className="w-full bg-gray-600 bg-opacity-20 focus:bg-transparent focus:ring-2 focus:ring-green-900 rounded border border-gray-600 focus:border-green-500 text-base outline-none text-gray-100 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out">
                    {agents.map((agent) => (
                        <option key={agent.id} value={agent.id}>
                            {agent.name}
                        </option>
                    ))}
                </select>
            </div>
            <div className="relative mb-4">
                <label htmlFor="password" className="leading-7 text-sm text-gray-400">Торговая точка</label>
                <select type="password" id="password" name="password"
                        className="w-full bg-gray-600 bg-opacity-20 focus:bg-transparent focus:ring-2 focus:ring-green-900 rounded border border-gray-600 focus:border-green-500 text-base outline-none text-gray-100 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out">
                    {stores.map((store) => (
                        <option key={store.id} value={store.id}>
                            {store.name}
                        </option>
                    ))}
                </select>
            </div>
            <div className="flex justify-between gap-5">
                <Link to="/admin/adminPanel" className="basis-1/2 text-white bg-green-500 border-0 py-2 px-8 focus:outline-none hover:bg-green-600 rounded text-lg">
                    Главная
                </Link>
                <button className="basis-1/2 text-white bg-green-500 border-0 py-2 px-8 focus:outline-none hover:bg-green-600 rounded text-lg">
                    Выдать доступ
                </button>
            </div>
            <p className="text-xs mt-3"></p>
        </div>
    );
};

export default NewAccess;