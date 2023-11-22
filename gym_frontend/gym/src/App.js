import { Routes , Route} from 'react-router-dom';
import UsersLogin ,{ Dashboard ,GetAllUsers , Register , InsertUser} from './components/Users';

import 'bootstrap/dist/css/bootstrap.min.css';
import { GetAllCustomers, InsertCustomer } from './components/Customer';
import { GetAllHistory, InsertHistory } from './components/History';
import { ListCustomers } from './pages/customer/ListCustomers';
import CreateCustomer from './pages/customer/CreateCustomer';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { Container } from 'react-bootstrap';


function App() {
  return (

    <div >
      <Container>
    <Routes>
      <Route path='/' element={<Dashboard/>} />
      <Route path='/Register' element={<Register/>} />
      <Route path='/Login' element={<UsersLogin/>} />
      <Route path='/User/Get' element={<GetAllUsers/>} />
      <Route path='/User/Insert' element={<InsertUser/>} />
      {/* <Route path='/Customer/Get' element={<GetAllCustomers/>} /> */}
      {/* <Route path='/Customer/Insert' element={<InsertCustomer/>} /> */}
      <Route path='/History/Get' element={<GetAllHistory/>} />
      <Route path='/History/Insert' element={<InsertHistory/>} />
      <Route path='/Customer/Get' element={<ListCustomers/>} />
      <Route path='/Customer/Insert' element={<CreateCustomer/>} />




    </Routes>
    </Container>
    <ToastContainer />
    </div>
  );
}

export default App;
