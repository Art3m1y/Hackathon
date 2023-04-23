import React from 'react';

const Select = ({label, items, name, value, onChange}) => {
    return (
        <div className="relative mb-4">
            <label htmlFor={name} className="leading-7 text-sm text-gray-400">{label}</label>
            <select onChange={onChange} type="text" id={name} name={name} value={value === "" ? label : value}
                    className="w-full bg-gray-600 bg-opacity-20 focus:bg-transparent focus:ring-2 focus:ring-green-900 rounded border border-gray-600 focus:border-green-500 text-base outline-none text-gray-100 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out">
                <option className="bg-gray-600 text-gray-400" disabled>{label}</option>
                {items.map((item) => (
                    <option className="bg-gray-600" key={item.id} value={item.id}>
                        {item.name}
                    </option>
                ))}
            </select>
        </div>
    );
};

export default Select;