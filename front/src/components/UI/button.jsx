import React from 'react';

const Button = ({onClick, children, className, ...attr}) => {
    return (
        <button {...attr} className={
            "inline-flex text-white bg-green-500 border-0 py-2 px-6 focus:outline-none hover:bg-green-600 rounded" + (
                className !== "" ? " " + className : ""
            )
        }
                onClick={onClick}>
            {children}
        </button>
    );
};

export default Button;