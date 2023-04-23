import React, {useState} from 'react';
import MainLayout from "../../components/mainLayout/mainLayout";
import {Link} from "react-router-dom";

const ConnectStores = () => {

    const [data, setData] = useState([
        {id: 1, name: "Название торг точки", code: 214213, codeStore: 6575},
        {id: 2, name: "Акаплька", code: 1324421, codeStore: 5435},
        {id: 3, name: "Арараа", code: 99657, codeStore: 3244}
    ]);

    const changeHandlerName = (storeId, newValue) => {
        const newData = data.map(item => {
            if (item.id === storeId) return {...item, name: newValue}
            else return item
        })
        setData(newData)
    }

    const changeHandlerCode = (storeId, newValue) => {
        const newData = data.map(item => {
            if (item.id === storeId) return {...item, code: newValue}
            else return item
        })
        setData(newData)
    }

    const changeHandlerCodeStore = (storeId, newValue) => {
        const newData = data.map(item => {
            if (item.id === storeId) return {...item, codeStore: newValue}
            else return item
        })
        setData(newData)
    }

    const deleteHandler = (storeId) => {
        setData(prevState => prevState.filter(item => item.id !== storeId))
    }

    return (
        <MainLayout title="Подключённые точки агента">
            <p className="text-3xl">admin</p>
            <ul className="flex gap-5 mt-5">
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
                                    <input value={item.code} onChange={event => changeHandlerCode(item.id, event.target.value)} type="text" id="code" name="code"
                                           className="w-full bg-gray-600 bg-opacity-20 focus:bg-transparent focus:ring-2 focus:ring-green-900 rounded border border-gray-600 focus:border-green-500 text-base outline-none text-gray-100 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"
                                           required/>
                                </div>
                                <div className="relative">
                                    <label htmlFor="codeStore" className="leading-7 text-sm text-gray-400">Код торговой точки</label>
                                    <input value={item.codeStore} onChange={event => changeHandlerCodeStore(item.id, event.target.value)} type="text" id="codeStore" name="codeStore"
                                           className="w-full bg-gray-600 bg-opacity-20 focus:bg-transparent focus:ring-2 focus:ring-green-900 rounded border border-gray-600 focus:border-green-500 text-base outline-none text-gray-100 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"
                                           required/>
                                </div>
                                <div className="flex gap-5">
                                    <button className="inline-flex text-white bg-green-500 border-0 py-2 px-6 focus:outline-none hover:bg-green-600 rounded"
                                            onClick={() => deleteHandler(item.id)}>
                                        Закрыть доступ к точке
                                    </button>
                                </div>
                            </li>
                        ))}
                    </ul>
                ) : <p className="mt-5 text-3xl">Торговых точек нет</p>
            }
        </MainLayout>
    );
};

export default ConnectStores;