import React from "react";
import { Link } from "react-router-dom";
import MainLayout from "../../components/mainLayout/mainLayout";
import {useNavigate} from "react-router";
import axios from "axios";

const AdminPanel = () => {

    const navigate = useNavigate();
    const clickHandler = () => {
        localStorage.removeItem("accessToken");
        navigate("/");
    }

    const checkToken = () => {
        // axios
        //     .request({
        //         method: 'post',
        //         url: 'https://credit.art3m1y.me/api/admin',
        //         headers: {
        //             'Content-Type': 'application/json'
        //         }
        //     })
        //     .then(data => {
        //         setForm({name: "", code: ""})
        //         alert("Магазин успешно зарегистрирован.")
        //     })
        //     .catch(error => {
        //         alert("Ошибка регистрации магазина");
        //         console.log(error);
        //     });
        // const token = localStorage.getItem("accessToken");
        // return !(!token || !token.endsWith("ADMIN"));
        return true;
    }

    return (
        <MainLayout title="Панель администратора">
            {checkToken() ? (
                <ul>
                    <li>
                        <button onClick={clickHandler}>Выход</button>
                    </li>
                    <li>
                        <Link to="/shops">Магазины</Link>
                    </li>
                    <li>
                        <Link to="/stores">Торговые точки</Link>
                    </li>
                    <li>
                        <Link to="/agents">Кредитные агенты</Link>
                    </li>
                    <li>
                        <Link to="/formOrder">Оформление заказа</Link>
                    </li>
                </ul>
            ) : <h2 className="text-3xl">Нет доступа</h2>}

        </MainLayout>
    );
};

export default AdminPanel;