import React from 'react'
import {Link} from "react-router-dom";
import FormOrder from "../components/forms/formOrder";
import { Link as ScrollLink, animateScroll as scroll } from "react-scroll";
import {useNavigate} from "react-router";
import axios from "axios";

const Main = () => {

    const navigation = useNavigate();

    const clickHandler = () => {
        localStorage.removeItem("accessToken");
        navigation("/");
    }

    const checkToken = () => {
        // axios
        //     .request({
        //         method: 'post',
        //         url: 'api/shop',
        //         headers: {
        //             'Content-Type': 'application/json'
        //         },
                // data: {
                //     name: form.name,
                //     code: form.code
                // }
            // })
            // .then(data => {
            //     setForm({name: "", code: ""})
            //     alert("Магазин успешно зарегистрирован.")
            // })
            // .catch(error => {
            //     alert("Ошибка регистрации магазина");
            //     console.log(error);
            // });
        return localStorage.getItem("accessToken");
    }

    return (
        <div className="pb-48">
            {checkToken() ? (
                <div className="h-full">
                    <header className="sticky top-0 text-gray-400 bg-gray-900 body-font">
                        <div className="container mx-auto flex flex-wrap p-5 flex-col md:flex-row items-center">
                            <button onClick={clickHandler}
                                    className="ml-auto inline-flex items-center bg-gray-800 border-0 py-1 px-3 focus:outline-none hover:bg-gray-700 rounded text-base mt-4 md:mt-0">
                                Выход
                                <svg fill="none" stroke="currentColor" strokeLinecap="round" strokeLinejoin="round"
                                     strokeWidth="2" className="w-4 h-4 ml-1" viewBox="0 0 24 24">
                                    <path d="M5 12h14M12 5l7 7-7 7"></path>
                                </svg>
                            </button>
                        </div>
                    </header>
                    <section className="text-gray-400 bg-gray-900 body-font">
                        <div className="container mx-auto flex px-5 py-24 md:flex-row flex-col items-center">
                            <div
                                className="lg:flex-grow md:w-1/2 lg:pr-24 md:pr-16 flex flex-col md:items-start md:text-left mb-16 md:mb-0 items-center text-center">
                                <h1 className="title-font sm:text-4xl text-3xl mb-4 font-medium text-white">
                                    POS-кредитование для бизнеса
                                </h1>
                                <p className="mb-8 leading-relaxed">Владельцам онлайн- и офлайн-бизнеса
                                    <br className="hidden lg:inline-block"/>
                                    Покупатели смогут приобретать в рассрочку и кредит, даже если нет полной суммы на покупку</p>
                                <div className="flex justify-center">
                                    <ScrollLink to="formOrder"
                                                smooth={true}
                                                duration={500}
                                                className="cursor-pointer inline-flex text-white bg-green-500 border-0 py-2 px-6 focus:outline-none hover:bg-green-600 rounded text-lg">
                                        Оформить
                                    </ScrollLink>
                                </div>
                            </div>
                            <div className="lg:max-w-lg lg:w-full md:w-1/2 w-5/6">
                                <img className="object-cover object-center rounded" alt="hero"
                                     src="https://dummyimage.com/720x600"/>
                            </div>
                        </div>
                    </section>
                    <section className="text-gray-400 body-font bg-gray-900">
                        <div className="container px-5 py-24 mx-auto">
                            <div className="flex flex-wrap w-full mb-10 flex-col items-center text-center">
                                <h1 className="sm:text-3xl text-2xl font-medium title-font mb-2 text-white">
                                    Подходит любому бизнесу
                                </h1>
                                <p className="lg:w-1/2 w-full leading-relaxed text-opacity-80">
                                    POS-кредитование помогает компаниям в онлайн- и офлайн-сферах
                                </p>
                            </div>
                            <div className="flex flex-wrap -m-4 items-stretch justify-center">
                                <div className="xl:w-1/2 md:w-1/2 p-4 max-w-[600px] w-full">
                                    <div className="border border-gray-700 border-opacity-75 p-6 rounded-lg h-full">
                                        <h2 className="text-lg text-white font-medium title-font mb-2">
                                            Онлайн-бизнес
                                        </h2>
                                        <ul className="leading-relaxed text-base">
                                            <li>— Клиенты покупают не выходя из дома</li>
                                            <li>— Оформить кредит или рассрочку можно на сайте, в соцсетях, мессенджерах и даже по телефону</li>
                                        </ul>
                                    </div>
                                </div>
                                <div className="xl:w-1/2 md:w-1/2 p-4 max-w-[600px] w-full">
                                    <div className="border border-gray-700 border-opacity-75 p-6 rounded-lg h-full">
                                        <h2 className="text-lg text-white font-medium title-font mb-2">Офлайн-точки продаж</h2>
                                        <ul className="leading-relaxed text-base">
                                            <li>— Заявку заполняют ваши продавцы или сами клиенты</li>
                                            <li>— А мы платим вознаграждение за продажи в POS-кредит</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div className="flex justify-center mt-10">
                                <ScrollLink to="formOrder"
                                            smooth={true}
                                            duration={500}
                                            className="cursor-pointer inline-flex text-white bg-green-500 border-0 py-2 px-6 focus:outline-none hover:bg-green-600 rounded text-lg">
                                    Оформить
                                </ScrollLink>
                            </div>
                        </div>
                    </section>
                    <section className="text-gray-400 bg-gray-900 body-font mt-10">
                        <div className="flex flex-wrap w-full mb-5 flex-col items-center text-center">
                            <h1 className="sm:text-3xl text-2xl font-medium title-font mb-2 text-white">
                                Результаты для бизнеса
                            </h1>
                            <p className="lg:w-1/2 w-full leading-relaxed text-opacity-80">
                                POS-кредитование это простой способ увеличить оборот и прибыль
                            </p>
                        </div>
                        <div className="container px-5 pt-5 pb-24 mx-auto">
                            <div className="flex flex-wrap -m-4 text-center justify-center">
                                <div className="p-4 sm:w-1/3 w-1/3">
                                    <div
                                        className="w-20 h-20 inline-flex items-center justify-center rounded-full bg-gray-800 text-green-400 mb-5 flex-shrink-0">
                                        <svg fill="none" stroke="currentColor" strokeLinecap="round" strokeLinejoin="round"
                                             strokeWidth="2" className="w-10 h-10" viewBox="0 0 24 24">
                                            <path d="M22 12h-4l-3 9L9 3l-3 9H2"></path>
                                        </svg>
                                    </div>
                                    <h2 className="title-font font-medium sm:text-4xl text-3xl text-white">До 50%</h2>
                                    <p className="leading-relaxed mt-3">увеличиваются продажи</p>
                                </div>
                                <div className="p-4 sm:w-1/3 w-1/3">
                                    <div
                                        className="w-20 h-20 inline-flex items-center justify-center rounded-full bg-gray-800 text-green-400 mb-5 flex-shrink-0">
                                        <svg width="24" height="40" viewBox="0 0 24 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                                            <path d="M12 1.66666V38.3333" stroke="currentColor" strokeWidth="4" strokeLinecap="round" strokeLinejoin="round"/>
                                            <path d="M21.1667 7.16666H7.41667C5.71486 7.16666 4.08276 7.8427 2.8794 9.04606C1.67604 10.2494 1 11.8815 1 13.5833C1 15.2851 1.67604 16.9172 2.8794 18.1206C4.08276 19.3239 5.71486 20 7.41667 20H16.5833C18.2851 20 19.9172 20.676 21.1206 21.8794C22.324 23.0827 23 24.7149 23 26.4167C23 28.1185 22.324 29.7506 21.1206 30.9539C19.9172 32.1573 18.2851 32.8333 16.5833 32.8333H1" stroke="currentColor" strokeWidth="4" strokeLinecap="round" strokeLinejoin="round"/>
                                        </svg>
                                    </div>
                                    <h2 className="title-font font-medium sm:text-4xl text-3xl text-white">До 40%</h2>
                                    <p className="leading-relaxed mt-3">увеличивается средний чек</p>
                                </div>
                            </div>
                        </div>
                    </section>
                    <section className="text-gray-400 bg-gray-900 body-font mt-10">
                        <div className="flex flex-wrap w-full mb-5 flex-col items-center text-center">
                            <h1 className="sm:text-3xl text-2xl font-medium title-font mb-2 text-white">
                                POS-кредиты с высоким процентом одобрения
                            </h1>
                            <p className="lg:w-1/2 w-full leading-relaxed text-opacity-80">
                                Ваши клиенты быстро и легко получат деньги на покупку
                            </p>
                        </div>
                        <div className="container px-5 py-10 mx-auto flex flex-wrap">
                            <div className="lg:w-1/2 w-full mb-10 lg:mb-0 rounded-lg overflow-hidden">
                                <img alt="feature" className="object-cover object-center h-full w-full"
                                     src="https://dummyimage.com/460x500"/>
                            </div>
                            <div className="flex flex-col flex-wrap lg:py-6 -mb-10 lg:w-1/2 lg:pl-12 lg:text-left text-center">
                                <div className="flex flex-col mb-10 lg:items-start items-center">
                                    <div
                                        className="w-12 h-12 inline-flex items-center justify-center rounded-full bg-gray-800 text-green-400 mb-5">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                             fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round"
                                             strokeLinejoin="round" className="lucide lucide-landmark">
                                            <line x1="3" x2="21" y1="22" y2="22"></line>
                                            <line x1="6" x2="6" y1="18" y2="11"></line>
                                            <line x1="10" x2="10" y1="18" y2="11"></line>
                                            <line x1="14" x2="14" y1="18" y2="11"></line>
                                            <line x1="18" x2="18" y1="18" y2="11"></line>
                                            <polygon points="12 2 20 7 4 7"></polygon>
                                        </svg>
                                    </div>
                                    <div className="flex-grow">
                                        <h2 className="text-white text-lg title-font font-medium mb-3">Кредиты от 5 банков</h2>
                                        <p className="leading-relaxed text-base">Для офлайн-кредитования отправляем заявки в 5 банка</p>
                                        <a className="mt-3 text-green-400 inline-flex items-center">Подробнее
                                            <svg fill="none" stroke="currentColor" strokeLinecap="round"
                                                 strokeLinejoin="round" strokeWidth="2" className="w-4 h-4 ml-2"
                                                 viewBox="0 0 24 24">
                                                <path d="M5 12h14M12 5l7 7-7 7"></path>
                                            </svg>
                                        </a>
                                    </div>
                                </div>
                                <div className="flex flex-col mb-10 lg:items-start items-center">
                                    <div
                                        className="w-12 h-12 inline-flex items-center justify-center rounded-full bg-gray-800 text-green-400 mb-5">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                             fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round"
                                             strokeLinejoin="round" className="lucide lucide-mail-check">
                                            <path d="M22 13V6a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2v12c0 1.1.9 2 2 2h8"></path>
                                            <path d="m22 7-8.97 5.7a1.94 1.94 0 0 1-2.06 0L2 7"></path>
                                            <path d="m16 19 2 2 4-4"></path>
                                        </svg>
                                    </div>
                                    <div className="flex-grow">
                                        <h2 className="text-white text-lg title-font font-medium mb-3">Подписание по СМС</h2>
                                        <p className="leading-relaxed text-base">Клиент может подписать договор по СМС без участия продавца или представителя</p>
                                        <a className="mt-3 text-green-400 inline-flex items-center">Подробнее
                                            <svg fill="none" stroke="currentColor" strokeLinecap="round"
                                                 strokeLinejoin="round" strokeWidth="2" className="w-4 h-4 ml-2"
                                                 viewBox="0 0 24 24">
                                                <path d="M5 12h14M12 5l7 7-7 7"></path>
                                            </svg>
                                        </a>
                                    </div>
                                </div>
                                <div className="flex flex-col mb-10 lg:items-start items-center">
                                    <div
                                        className="w-12 h-12 inline-flex items-center justify-center rounded-full bg-gray-800 text-green-400 mb-5">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                             fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round"
                                             strokeLinejoin="round" className="lucide lucide-arrow-left-right">
                                            <polyline points="17 11 21 7 17 3"></polyline>
                                            <line x1="21" x2="9" y1="7" y2="7"></line>
                                            <polyline points="7 21 3 17 7 13"></polyline>
                                            <line x1="15" x2="3" y1="17" y2="17"></line>
                                        </svg>
                                    </div>
                                    <div className="flex-grow">
                                        <h2 className="text-white text-lg title-font font-medium mb-3">Автозаполнение заявки</h2>
                                        <p className="leading-relaxed text-base">Покупатель вносит ФИО и номер телефона — остальное заполняем сами</p>
                                        <a className="mt-3 text-green-400 inline-flex items-center">Подробнее
                                            <svg fill="none" stroke="currentColor" strokeLinecap="round"
                                                 strokeLinejoin="round" strokeWidth="2" className="w-4 h-4 ml-2"
                                                 viewBox="0 0 24 24">
                                                <path d="M5 12h14M12 5l7 7-7 7"></path>
                                            </svg>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                    <section className="text-gray-400 body-font bg-gray-900">
                        <div className="container px-5 py-24 mx-auto">
                            <div className="flex flex-wrap w-full mb-16 flex-col items-center text-center">
                                <h1 className="sm:text-3xl text-2xl font-medium title-font mb-2 text-white">Высокая оборачиваемость средств</h1>
                                <p className="lg:w-1/2 w-full leading-relaxed text-opacity-80">Продавец сразу получает полную сумму кредита</p>
                            </div>
                            <div className="flex flex-wrap -m-4 justify-center items-stretch">
                                <div className="md:w-full max-w-[600px] p-4">
                                    <div className="border border-gray-700 border-opacity-75 p-6 rounded-lg h-full">
                                        <h2 className="text-lg text-white font-medium title-font mb-2">Деньги за покупку — сразу у вас</h2>
                                        <ul className="leading-relaxed text-base">
                                            <li>— Деньги придут в день подписания договора на кредит</li>
                                            <li>— Если в другом банке — на следующий рабочий день</li>
                                        </ul>
                                    </div>
                                </div>
                                <div className="md:w-full max-w-[600px] p-4">
                                    <div className="border border-gray-700 border-opacity-75 p-6 rounded-lg h-full">
                                        <h2 className="text-lg text-white font-medium title-font mb-2">Без комиссии за платежи</h2>
                                        <ul className="leading-relaxed text-base">
                                            <li>— Если клиент расплачивается картой, компания платит за эквайринг</li>
                                            <li>— При POS-кредитовании комиссия за эквайринг не взимается</li>
                                        </ul>
                                    </div>
                                </div>
                                <div className="md:w-full max-w-[600px] p-4">
                                    <div className="border border-gray-700 border-opacity-75 p-6 rounded-lg h-full">
                                        <h2 className="text-lg text-white font-medium title-font mb-2">Вся сумма целиком</h2>
                                        <ul className="leading-relaxed text-base">
                                            <li>— Мы сразу переведем вам полную сумму покупки, и неважно, на какой срок клиент оформляет кредит</li>
                                        </ul>
                                    </div>
                                </div>
                                <div className="md:w-full max-w-[600px] p-4">
                                    <div className="border border-gray-700 border-opacity-75 p-6 rounded-lg h-full">
                                        <h2 className="text-lg text-white font-medium title-font mb-2">Вознаграждение для продавцов</h2>
                                        <ul className="leading-relaxed text-base">
                                            <li>— За каждый выданный POS-кредит мотивируем деньгами</li>
                                            <li>— Переведем на счет компании или продавцам на карту любого банка</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div className="flex justify-center mt-10">
                                <ScrollLink to="formOrder"
                                            smooth={true}
                                            duration={500}
                                            className="cursor-pointer inline-flex text-white bg-green-500 border-0 py-2 px-6 focus:outline-none hover:bg-green-600 rounded text-lg">
                                    Оформить
                                </ScrollLink>
                            </div>
                        </div>
                    </section>
                    <section id="formOrder" className="mt-24 mb-24">
                        <div className="flex flex-wrap w-full mb-5 flex-col items-center text-center">
                            <h1 className="sm:text-3xl text-2xl font-medium title-font mb-2 text-white">
                                Оформление заказа
                            </h1>
                            <p className="lg:w-1/2 w-full leading-relaxed text-opacity-80">
                                Оставьте заявку - мы подключим POS-кредитование
                            </p>
                        </div>
                        <FormOrder/>
                    </section>
                </div>
            ) : <h2 className="text-3xl pt-10">Нет доступа</h2>}
        </div>
    );
};

export default Main;