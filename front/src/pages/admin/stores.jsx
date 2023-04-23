import React, {useEffect, useState} from 'react';
import MainLayout from "../../components/mainLayout/mainLayout";
import {Link} from "react-router-dom";
import axios from "axios";

const Stores = () => {

    const [data, setData] = useState([
        {id: 1, name: "Название торг точки", code: 214213, codeStore: 6575},
        {id: 2, name: "Акаплька", code: 1324421, codeStore: 5435},
        {id: 3, name: "Арараа", code: 99657, codeStore: 3244}
    ]);

    // ПОЛУЧЕНИЕ ВСЕХ ТОРГОВЫХ ТОЧЕК
    useEffect(() => {
        axios
            .get("https://credit.art3m1y.me/api/point")
            .then(response => {
                setData(response);
            })
            .catch(error => {
                alert("Ошибка получения данных.")
                console.log(error);
            })
    }, []);
    // const [data, setData] = useState(getStores);

    const changeHandlerName = (storeId, newValue) => {
        const editedStore = data.filter(item => item.id === storeId)[0];
        axios
            .request({
                method: 'put',
                url: 'https://credit.art3m1y.me/api/point',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: {
                    name: editedStore.name,
                    code: editedStore.code,
                    codeStore: editedStore.codeStore
                }
            })
            .then(response => {
                const newData = data.map(item => {
                    if(item.id === storeId) return {...item, name: newValue}
                    else return item
                })
                setData(newData);
            })
            .catch(error => {
                console.log("Ошибка. Данные не изменены.");
                // console.log(error);
            });
    }

    // const changeHandlerCode = (storeId, newValue) => {
    //     const editedStore = data.filter(item => item.id === storeId)[0];
    //     axios
    //         .request({
    //             method: 'put',
    //             url: 'https://credit.art3m1y.me/api/point',
    //             headers: {
    //                 'Content-Type': 'application/json'
    //             },
    //             data: {
    //                 name: editedStore.name,
    //                 code: editedStore.code,
    //                 codeStore: editedStore.codeStore
    //             }
    //         })
    //         .then(response => {
    //             const newData = data.map(item => {
    //                 if(item.id === storeId) return {...item, code: newValue}
    //                 else return item
    //             })
    //             setData(newData);
    //         })
    //         .catch(error => {
    //             console.log("Ошибка. Данные не изменены.");
    //             // console.log(error);
    //         });
    // }

    // ИЗМЕНЕНИЕ КОДА ТОЧКИ
    const changeHandlerCodeStore = (storeId, newValue) => {
        const editedStore = data.filter(item => item.id === storeId)[0];
        axios
            .request({
                method: 'put',
                url: 'https://credit.art3m1y.me/api/point',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: {
                    name: editedStore.name,
                    code: editedStore.code,
                    codeStore: editedStore.codeStore
                }
            })
            .then(response => {
                const newData = data.map(item => {
                    if (item.id === storeId) return {...item, codeStore: newValue}
                    else return item
                })
                setData(newData)
            })
            .catch(error => {
                console.log("Ошибка. Данные не изменены.");
                // console.log(error);
            });
    }

    // УДАЛЕНИЕ ТОРГОВОЙ ТОЧКИ
    const deleteHandler = (storeId) => {
        axios
            .delete(`https://localhost/api/point/${storeId}`)
            .then(data => {
                setData(prevState => prevState.filter(item => item.id !== storeId))
            })
            .catch(error => {
                alert("Ошибка получения данных");
                console.log(error);
            });
    }

    return (
        <MainLayout title="Торговые точки">
            <ul className="flex gap-5">
                <li><Link to="/admin">Главная</Link></li>
                <li><Link to="/storeRegister">Регистрация точки</Link></li>
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
                                    <input value={item.code} disabled type="text" id="code" name="code"
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
                                        Удалить
                                    </button>
                                    <Link to={"/admin/agentsStore?store=" + item.id} className="inline-flex text-white bg-green-500 border-0 py-2 px-6 focus:outline-none hover:bg-green-600 rounded">
                                        Подключённые агенты
                                    </Link>
                                </div>
                            </li>
                        ))}
                    </ul>
                ) : <p className="mt-5 text-3xl">Торговых точек нет</p>
            }
        </MainLayout>
    );
};

export default Stores;