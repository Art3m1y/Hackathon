import React, {useEffect, useState} from 'react';
import MainLayout from "../../components/mainLayout/mainLayout";
import {Link} from "react-router-dom";
import {useNavigate} from "react-router";
import axios from "axios";

const Shops = () => {

    const navigate = useNavigate()

    // const [data, setData] = useState([]);

    const [data, setData] = useState([
        {id: 1, name: "Курлык", code: 123},
        {id: 2, name: "Название", code: 999}
    ]);

    // ПОЛУЧЕНИЕ ВСЕХ МАГАЗИНОВ
    const getShops = () => {
    //     axios
    //         .get("https://credit.art3m1y.me/api/shop")
    //         .then(data => {
    //             console.log(data);
    //             return data;
    //         })
    //         .catch(error => {
    //             console.log("Ошибка получения данных.");
    //             console.log(error);
    //             return [];
    //         })
        axios
            .request({
                method: 'get',
                url: 'https://credit.art3m1y.me/api/shop',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': 'Bearer ' + localStorage.getItem("access_token")
                }
            })
            .then(data => {
                console.log(data);
                return data;
            })
            .catch(error => {
                console.log("Ошибка получения данных.");
                console.log(error);
                return [];
            })
    }

    console.log("data: ", data);

    useEffect(() => {
        setData(getShops);
        console.log("Перерисовка")
    }, []);

    // const [data, setData] = useState(shops);

    // ИЗМЕНЕНИЕ ИМЕНИ МАГАЗИНА
    const changeHandlerName = (shopId, newValue) => {
        const editedShop = data.filter(item => item.id === shopId)[0];
        axios
            .request({
                method: 'put',
                url: 'https://credit.art3m1y.me/api/shop',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: {
                    name: editedShop.name,
                    code: editedShop.code
                }
            })
            .then(response => {
                const newData = data.map(item => {
                    if(item.id === shopId) return {...item, name: newValue}
                    else return item
                })
                setData(newData);
            })
            .catch(error => {
                console.log("Ошибка. Данные не изменены.");
                // console.log(error);
            });
    }

    const changeHandlerCode = (shopId, newValue) => {
        const editedShop = data.filter(item => item.id === shopId)[0];
        axios
            .request({
                method: 'put',
                url: 'https://credit.art3m1y.me/api/shop',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: {
                    name: editedShop.name,
                    code: editedShop.code
                }
            })
            .then(data => {
                const newData = data.map(item => {
                    if(item.id === shopId) return {...item, code: newValue}
                    else return item
                })
                setData(newData);
            })
            .catch(error => {
                console.log("Ошибка. Данные не изменены.");
                // console.log(error);
            });
    }

    // УДАЛЕНИЕ МАГАЗИНА
    const deleteHandler = (shopId) => {
        axios
            .delete(`https://localhost/api/shop/${shopId}`)
            .then(data => {
                setData(prevState => prevState.filter(item => item.id !== shopId))
            })
            .catch(error => {
                alert("Ошибка получения данных");
                // console.log(error);
            });
    }

    const checkToken = () => {
        // const token = localStorage.getItem("accessToken");
        // return !(!token || !token.endsWith("ADMIN"));
        return true;
    }

    return (
        <MainLayout title="Магазины">
            {checkToken() ?
                (<div>
                        <ul className="flex gap-5">
                            <li><Link to="/admin">Главная</Link></li>
                            <li><Link to="/shopRegister">Регистрация магазина</Link></li>
                        </ul>
                    {
                        data.length ? (
                            <ul className="flex flex-col gap-10 mt-10">
                                {data.map(item =>
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
                                        <button className="inline-flex text-white bg-green-500 border-0 py-2 px-6 focus:outline-none hover:bg-green-600 rounded"
                                                onClick={() => deleteHandler(item.id)}>
                                            Удалить
                                        </button>
                                    </li>
                                )}
                            </ul>
                        ) : <p className="mt-5 text-3xl">Магазинов нет</p>
                    }
                </div>
                )
                : <h2 className="text-3xl">Нет доступа</h2>}

        </MainLayout>
    );
};

export default Shops;