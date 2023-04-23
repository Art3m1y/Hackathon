import React from 'react';

const MainLayout = ({title, children}) => {
    return (
            <div className="text-gray-400 bg-gray-900 body-font py-10">
                    <div className="container mx-auto flex px-5 flex-col">
                        <div className="lg:flex-grow lg:pr-24 md:pr-16 flex flex-col md:items-start md:text-left mb-16 md:mb-0 items-center text-center">
                            <h1 className="title-font sm:text-4xl text-3xl mb-4 font-medium text-white">
                                {title}
                            </h1>
                        </div>
                        {children}
                    </div>
            </div>
    )
};

export default MainLayout;