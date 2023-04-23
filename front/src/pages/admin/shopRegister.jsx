import React, {useState} from 'react';
import {Link} from "react-router-dom";
import axios from "axios";

const ShopRegister = () => {

    const [form, setForm] = useState({
        name: "", code: ""
    });

    const changeHandlerName = (newValue) => {
        setForm({...form, name: newValue})
    }

    const changeHandlerCode = (newValue) => {
        setForm({...form, code: newValue})
    }

    // РЕГИСТРАЦИЯ НОВОГО МАГАЗИНА
    const clickHandler = () => {
        if (form.name === "") {
            alert("Заполните имя магазина.")
            return;
        } else if (form.code === "") {
            alert("Заполните код магазина.")
            return;
        }
        axios
            .request({
                method: 'post',
                url: 'https://credit.art3m1y.me/api/shop',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: {
                    name: form.name,
                    code: form.code
                }
            })
            .then(data => {
                setForm({name: "", code: ""})
                alert("Магазин успешно зарегистрирован.")
            })
            .catch(error => {
                alert("Ошибка регистрации магазина");
                console.log(error);
            });
    }

    const checkToken = () => {
        const token = localStorage.getItem("accessToken");
        return !(!token || !token.endsWith("ADMIN"));
    }

    return (
        <div className="w-full flex justify-center items-center h-screen">
            {checkToken() ?
                (
                    <div className="lg:w-2/6 md:w-1/2 bg-gray-800 bg-opacity-50 rounded-lg p-8 flex flex-col mx-auto w-full mt-10 md:mt-0">
                        <h2 className="text-white text-lg font-medium title-font mb-5">Регистрация магазина</h2>
                        <div className="relative mb-4">
                            <label htmlFor="name" className="leading-7 text-sm text-gray-400">Название</label>
                            <input value={form.name} onChange={(e) => changeHandlerName(e.target.value)} type="text" id="name" name="name"
                                   className="w-full bg-gray-600 bg-opacity-20 focus:bg-transparent focus:ring-2 focus:ring-green-900 rounded border border-gray-600 focus:border-green-500 text-base outline-none text-gray-100 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"/>
                        </div>
                        <div className="relative mb-4">
                            <label htmlFor="code" className="leading-7 text-sm text-gray-400">Код магазина</label>
                            <input value={form.code} onChange={(e) => changeHandlerCode(e.target.value)} type="text" id="code" name="code"
                                   className="w-full bg-gray-600 bg-opacity-20 focus:bg-transparent focus:ring-2 focus:ring-green-900 rounded border border-gray-600 focus:border-green-500 text-base outline-none text-gray-100 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"/>
                        </div>
                        <div className="flex justify-between gap-5">
                            <Link to="/shops" className="basis-1/2 text-white bg-green-500 border-0 py-2 px-8 focus:outline-none hover:bg-green-600 rounded text-lg">
                                Назад
                            </Link>
                            <button className="basis-1/2 text-white bg-green-500 border-0 py-2 px-8 focus:outline-none hover:bg-green-600 rounded text-lg"
                                    onClick={clickHandler}>
                                Создать магазин
                            </button>
                        </div>
                        <p className="text-xs mt-3"></p>
                    </div>
                ) : <h2 className="text-3xl mt-10">Нет доступа</h2>
            }
        </div>
    );
};

export default ShopRegister;