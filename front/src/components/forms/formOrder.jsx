import React, {useState} from 'react';
import Select from "../UI/select";
import Input from "../UI/input";
import Button from "../UI/button";
import {useNavigate} from "react-router";

const FormOrder = () => {

    const navigate = useNavigate();

    const stores = [
        {id: 1, name: "Точка1"},
        {id: 2, name: "Точка2"},
        {id: 3, name: "Точка3"}
    ];

    const paymentMethods = [
        {id: 1, name: "Картой"},
        {id: 2, name: "Наличкой"}
    ]

    const categoriesGoods = [
        {id: 1, name: "Товар1"},
        {id: 2, name: "Товар2"},
        {id: 3, name: "Товар3"}
    ]

    const [store, setStore] = useState("");
    const [paymentMethod, setPaymentMethod] = useState("");
    const [phone, setPhone] = useState("");
    const [categoryGoods, setCategoryGoods] = useState("");
    const [price, setPrice] = useState("");
    const [link, setLink] = useState("");

    const checkout = (e) => {
        e.preventDefault();
        if (store === "") {
            alert("Выберите торговую точку.");
            return;
        } else if (paymentMethod === "") {
            alert ("Выберите способ оплаты.");
            return;
        } else if (phone === "") {
            alert ("Введите номер телефона.");
            return;
        } else if (categoryGoods === "") {
            alert("Выберите категорию товара.");
            return;
        } else if (price === "") {
            alert("Введите цену ");
            return;
        }
        alert(`Получить заказ:
        Торговая точка: ${stores.filter(item => item.id === Number(store))[0].name}
        Способ оплаты: ${paymentMethods.filter(item => item.id === Number(paymentMethod))[0].name}
        Номер телефона: ${phone}
        Категория товара: ${categoriesGoods.filter(item => item.id === Number(categoryGoods))[0].name}
        Стоимость: ${price}`);
    }

    const getLink = (e) => {
        e.preventDefault();
        alert("Ссылка получена");
        setLink("Ссылка");
    }

    const exit = (e) => {
        e.preventDefault()
        localStorage.removeItem("accessToken");
        navigate("/");
    }

    return (
        <form>
            <Select value={store} onChange={e => setStore(e.target.value)} label="Торговая точка" items={stores} name="store"/>
            <Select value={paymentMethod} onChange={e => setPaymentMethod(e.target.value)} label="Способ оплаты" items={paymentMethods} name="paymentMethod"/>
            <Input value={phone} onChange={event => setPhone(event.target.value)} label="Номер телефона" type="tel"/>
            <Select value={categoryGoods} onChange={e => setCategoryGoods(e.target.value)} label="Категория товара" items={categoriesGoods} name="categoryGoods"/>
            <Input value={price} onChange={event => setPrice(event.target.value)} label="Стоимость" type="text"/>
            <div className="flex gap-5 mt-5">
                <Button onClick={checkout}>Оформить заказ</Button>
                <Button onClick={getLink}>Получить ссылку</Button>
            </div>
            <Input disabled className="mt-5" label="" type="text" value={link} onChange={event => setPrice(event.target.value)}/>
            <Button className="mt-5" onClick={exit}>Выйти из системы</Button>
        </form>
    );
};

export default FormOrder;