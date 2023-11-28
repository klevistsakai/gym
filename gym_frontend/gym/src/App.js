import {Routes, Route} from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';

import './App.css'
import "./index.css"
import {ListCustomers} from './pages/customer/ListCustomers';
import CreateCustomer from './pages/customer/CreateCustomer';
import {ToastContainer} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import {Container} from 'react-bootstrap';

import Login from './pages/users/Login';
import {Register} from './pages/users/Register';
import {ViewCustomer} from "./pages/customer/ViewCustomer";
import {ListSubscriptions} from "./pages/subscriptions/ListSubscriptions";
import {ListHistory} from "./pages/history/ListHistory";
import {Profile} from "./pages/users/Profile";


function App() {
    return (

        <div style={{background: "lightgrey", paddingBottom: "2em"}}>
            <Container>
                <Routes>
                    <Route path='/' element={<ListCustomers/>}/>
                    <Route path='/Register' element={<Register/>}/>
                    <Route path='/Login' element={<Login/>}/>
                    <Route path='/Profile' element={<Profile/>}/>
                    <Route path='/Customers' element={<ListCustomers/>}/>
                    <Route path='/Customer/Insert' element={<CreateCustomer/>}/>
                    <Route path='/Customer/Update' element={<CreateCustomer/>}/>
                    <Route path='/Customer/View' element={<ViewCustomer/>}/>
                    <Route path='/Subscriptions' element={<ListSubscriptions/>}/>
                    <Route path='/History' element={<ListHistory/>}/>
                </Routes>
            </Container>
            <ToastContainer/>
        </div>
    );
}

export default App;
