import React from 'react';

const Input = ({label, type, value, onChange, className, ...attr}) => {
    return (
        <div className={"relative" + (className ? " " + className : "")}>
            <label htmlFor="name" className="leading-7 text-sm text-gray-400">{label}</label>
            <input {...attr} value={value} onChange={onChange} type={type} id="name" name="name"
                   className="w-full bg-gray-600 bg-opacity-20 focus:bg-transparent focus:ring-2 focus:ring-green-900 rounded border border-gray-600 focus:border-green-500 text-base outline-none text-gray-100 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"
                   required/>
        </div>
    );
};

export default Input;