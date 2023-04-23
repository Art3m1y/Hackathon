import {BrowserRouter, Route, Routes} from "react-router-dom";
import AdminPanel from "./pages/admin/adminPanel";
import Index from "./pages";
import Shops from "./pages/admin/shops";
import Stores from "./pages/admin/stores";
import Agents from "./pages/admin/agents";
import ShopRegister from "./pages/admin/shopRegister";
import StoreRegister from "./pages/admin/storeRegister";
import NewAccess from "./pages/admin/newAccess";
import AgentsStore from "./pages/admin/agentsStore";
import ConnectStores from "./pages/admin/connectStores";
import AgentRegister from "./pages/admin/agentRegister";
import Main from "./pages/main";

function Test() {
    return null;
}

function App() {

  return (
    <div className="App">
        <section className="min-h-screen text-gray-400 bg-gray-900 body-font">
            <div className="container px-5 mx-auto flex flex-wrap min-h-screen">
                {/*<div className="lg:w-3/5 md:w-1/2 md:pr-16 lg:pr-0 pr-0">*/}
                {/*    <h1 className="title-font font-medium text-3xl text-white">Slow-carb next level shoindxgoitch*/}
                {/*        ethical authentic, poko scenester</h1>*/}
                {/*    <p className="leading-relaxed mt-4">Poke slow-carb mixtape knausgaard, typewriter street art*/}
                {/*        gentrify hammock starladder roathse. Craies vegan tousled etsy austin.</p>*/}
                {/*</div>*/}
                {/*<MainLayout title="Панель администратора"/>*/}
                <BrowserRouter>
                    <Routes>
                        <Route path='/' element={<Index />} />
                        <Route path='/order' element={<Main />} />
                        <Route path='/admin' element={<AdminPanel />} />
                        <Route path='/shops' element={<Shops />} />
                        <Route path='/shopRegister' element={<ShopRegister />} />
                        <Route path='/stores' element={<Stores />} />
                        <Route path='/storeRegister' element={<StoreRegister />} />
                        <Route path='/agents' element={<Agents />} />
                        <Route path='/agentRegister' element={<AgentRegister />} />
                        {/*<Route path='/admin/agentsStore' element={<AgentsStore />} />*/}


                        {/*<Route path='/admin/newAccess' element={<NewAccess />} />*/}
                        {/*<Route path='/admin/connectStores' element={<ConnectStores />} />*/}

                    </Routes>
                </BrowserRouter>
            </div>
        </section>
    </div>
  );
}

export default App;
