import React, {useEffect, useState} from 'react';
import {Link} from "react-router-dom";
import Select from "../../components/UI/select";
import axios from "axios";

const StoreRegister = () => {

    const [shops, setShops] = useState([
        {id: 1, name: "Магазин1"},
        {id: 2, name: "Магазин2"}
    ]);
    const [form, setForm] = useState({name: "", shop: "", codeStore: ""});

    useEffect(() => {
        // axios
        //     .get("https://credit.art3m1y.me/api/shop")
        //     .then(data => {
        //        setShops(data)
        //     });
    }, []);

    const clickHandler = () => {
        axios
            .request({
                method: 'post',
                url: 'https://credit.art3m1y.me/api/shop',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: {
                    name: form.name,
                    shop: form.shop,
                    code: form.codeStore
                }
            })
            .then(data => {
                setForm({name: "", shop: "", codeStore: ""})
                alert("Магазин успешно зарегистрирован.")
            })
            .catch(error => {
                alert("Ошибка регистрации магазина");
                console.log(error);
            });
    }

    return (
        <div className="h-screen w-full flex items-center">
            <div className="lg:w-2/6 md:w-1/2 bg-gray-800 bg-opacity-50 rounded-lg p-8 flex flex-col mx-auto w-full mt-10 md:mt-0 max-h-[400px]">
                <h2 className="text-white text-lg font-medium title-font mb-5">Регистрация торговой точки</h2>
                <div className="relative mb-4">
                    <label htmlFor="name" className="leading-7 text-sm text-gray-400">Название</label>
                    <input value={form.name} onChange={e => setForm({...form, name: e.target.value})} type="text" id="name" name="name"
                           className="w-full bg-gray-600 bg-opacity-20 focus:bg-transparent focus:ring-2 focus:ring-green-900 rounded border border-gray-600 focus:border-green-500 text-base outline-none text-gray-100 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"/>
                </div>
                <div className="relative mb-4">
                    <label htmlFor="code" className="leading-7 text-sm text-gray-400">Магазин</label>
                    {/*<Select label="Магазин" items={}/>*/}
                    <select value={form.shop} onChange={e => setForm({...form, shop: e.target.value})} type="text" id="code" name="code"
                            className="w-full bg-gray-600 bg-opacity-20 focus:bg-transparent focus:ring-2 focus:ring-green-900 rounded border border-gray-600 focus:border-green-500 text-base outline-none text-gray-100 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out">
                        {shops.map((shop) => (
                            <option key={shop.id} className="bg-gray-500" value={shop.id}>
                                {shop.name}
                            </option>
                        ))}
                    </select>
                </div>
                <div className="relative mb-4">
                    <label htmlFor="code" className="leading-7 text-sm text-gray-400">Код торговой точки</label>
                    <input value={form.codeStore} onChange={e => setForm({...form, codeStore: e.target.value})} type="text" id="code" name="code"
                           className="w-full bg-gray-600 bg-opacity-20 focus:bg-transparent focus:ring-2 focus:ring-green-900 rounded border border-gray-600 focus:border-green-500 text-base outline-none text-gray-100 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"/>
                </div>
                <div className="flex justify-between gap-5">
                    <Link to="/stores" className="basis-1/2 text-white bg-green-500 border-0 py-2 px-8 focus:outline-none hover:bg-green-600 rounded text-lg">
                        Назад
                    </Link>
                    <button className="basis-1/2 text-white bg-green-500 border-0 py-2 px-8 focus:outline-none hover:bg-green-600 rounded text-lg"
                    onClick={clickHandler}>
                        Создать Точку
                    </button>
                </div>
                <p className="text-xs mt-3"></p>
            </div>
        </div>
    );
};

export default StoreRegister;