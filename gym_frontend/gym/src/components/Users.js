import useAxios from '../hook/useAxios';
import useAxiosFunction from '../hook/useAxiosFunction';
import axios from '../api/gym';
import { useNavigate, Link } from 'react-router-dom';
import { useState } from 'react';
import React from "react";
import Navigation from "../components/Navigation/Navigation";
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Button from 'react-bootstrap/Button';


export const InsertUser = () => {
    const navigate = useNavigate();
  const [firstname, setFirstname] = useState("")
  const [lastname, setLastname] = useState("")
//   const [birthdate, setBirthdate] = useState(new Date());

  const [genderId, setGenderId] = useState(1)
  const [username, setUsername] = useState("")
  const [passwordHash, setPasswordHash] = useState("")
 

  const [confirmPasswordHash, setConfirmPasswordHash] = useState("")
  const [validationErrors, setValidationErrors] = useState({});
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [user, error, loading, axiosFetch] = useAxiosFunction();


  const handleSumbit = (e) => {
      e.preventDefault();
      setIsSubmitting(true)
      const payload = {
          firstname: firstname,
          username: username,
          passwordHash: passwordHash,
          // password_confirmation: confirmPasswordHash,

          lastname: lastname,
          genderId: genderId
      };
      // payload = JSON.stringify(payload);
      console.log(payload)
      axiosFetch({
          axiosInstance: axios,
          method: 'post',
          url: '/api/users/save',
          data: payload,
          requestConfig: {
              'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
          },


      });
      setIsSubmitting(false)
      navigate('/');
      
  }



    return (<Form className="w-50 p-3 col-lg-6 offset-lg-3" onSubmit={(e) => handleSumbit(e)} >

       
            <Form.Group controlId="formGridUsername">
                <Form.Label>username</Form.Label>
                <Form.Control type="text" placeholder="Enter username" value={username}
                    onChange={(e) => { setUsername(e.target.value) }} />
            </Form.Group>

            <Form.Group controlId="formGridLastname">
                <Form.Label>password</Form.Label>
                <Form.Control type="password" placeholder="Enter password" value={passwordHash}
                    onChange={(e) => { setPasswordHash(e.target.value) }} />
            </Form.Group>
     

        
        <Form.Group  controlId="formGridLastname">
                <Form.Label>lastname</Form.Label>
                <Form.Control type="password" placeholder="Enter password again" value={confirmPasswordHash}
                    onChange={(e) => { setConfirmPasswordHash(e.target.value) }} />
            </Form.Group>


        <Row className="mb-3">
            <Form.Group as={Col} controlId="formGridFirstname">
                <Form.Label>firstname</Form.Label>
                <Form.Control type="text" placeholder="Enter firstname" value={firstname}
                    onChange={(e) => { setFirstname(e.target.value) }} />
            </Form.Group>

            <Form.Group as={Col} controlId="formGridLastname">
                <Form.Label>lastname</Form.Label>
                <Form.Control type="text" placeholder="Enter Lastname" value={lastname}
                    onChange={(e) => { setLastname(e.target.value) }} />
            </Form.Group>
        </Row>



        {/* <Form.Group controlId="formGridLastname">
            <Form.Label>birthdate</Form.Label>
            <Form.Control type="date" placeholder="birthdate"
                onChange={(e) => {
                    setBirthdate(e.target.value)
                }} />
        </Form.Group> */}

        <fieldset>
            <Form.Group as={Col} className="mb-3" value={genderId}
                onChange={(e) => {
                    setGenderId(e.target.value)
                }}>
                <Form.Label as="legend" column sm={2}>
                    Radios
                </Form.Label>
                <Col sm={10}>
                    <Form.Check
                        type="radio"
                        label="Male"
                        name="genderId"
                        id="genderId"
                        value={1}
                    />
                    <Form.Check
                        type="radio"
                        label="female"
                        name="genderId"
                        id="genderId"
                        value={2}
                    />
                    <Form.Check
                        type="radio"
                        label="unknown"
                        name="genderId"
                        id="genderId"
                        value={3}
                    />
                </Col>
            </Form.Group>
        </fieldset>

        <Button variant="primary" type="submit">
            Submit
        </Button>
    </Form>



    )

}

export const GetAllUsers = () => {
    const [user, error, loading, refetch] = useAxios({
        axiosInstance: axios,
        method: 'GET',
        url: '/api/users',
        requestConfig: {
            headers: {
                'Content-Language': 'en-US',
                //'Accept': 'text/html'
            }
        }
    });

    return (<>
        <Navigation />
        <form>
            < div >
                <h1 className="text-center"> customer List</h1>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <td>id</td>
                            <td>username</td>
                            <td>password</td>
                            <td>firstname</td>
                            <td>lastname</td>
                            <td>gender</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            user.map(
                                user =>
                                    <tr key={user.id}>
                                        <td>{user.id}</td>
                                        <td>{user.username}</td>
                                        <td> {user.passwordHash}</td>
                                        <td> {user.firstname}</td>
                                        <td> {user.lastname}</td>
                                        <td> {user.genderId === 1 ? "male" : (user.genderId === 2 ? "female" : "unknown")} </td>
                                    </tr>
                            )
                        }
                    </tbody>
                </table>

            </div>
        </form>
    </>
    )
}



export const Register = () => {
    // const navigate = useNavigate();
    const [username, setUsername] = useState("")
    const [passwordHash, setPasswordHash] = useState("")
    const [firstname, setFirstname] = useState("")
    const [lastname, setLastname] = useState("")
    const [genderId, setGenderId] = useState(1)

    const [confirmPasswordHash, setConfirmPasswordHash] = useState("")
    const [validationErrors, setValidationErrors] = useState({});
    const [isSubmitting, setIsSubmitting] = useState(false);
    const [user, error, loading, axiosFetch] = useAxiosFunction();


    const handleSumbit = (e) => {
        e.preventDefault();
        setIsSubmitting(true)
        const payload = {
            firstname: firstname,
            username: username,
            passwordHash: passwordHash,
            // password_confirmation: confirmPasswordHash,

            lastname: lastname,
            genderId: genderId
        };
        // payload = JSON.stringify(payload);
        console.log(payload)
        axiosFetch({
            axiosInstance: axios,
            method: 'post',
            url: '/api/users/save',
            data: payload,
            requestConfig: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },


        });
        setIsSubmitting(false)
        
    }

    return (
        <div className="row justify-content-md-center mt-5">
            <div className="col-4">
                <div className="card">
                    <div className="card-body">
                        <h5 className="card-title mb-4">Register</h5>
                        <form onSubmit={(e) => handleSumbit(e)}>
                            <div className="mb-3">
                                <label
                                    htmlFor="username"
                                    className="form-label">Name
                                </label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="username"
                                    username="username"
                                    value={username}
                                    onChange={(e) => { setUsername(e.target.value) }}
                                />
                                {validationErrors.username != undefined &&
                                    <div className="flex flex-col">
                                        <small className="text-danger">
                                            {validationErrors.username[0]}
                                        </small >
                                    </div>
                                }

                            </div>
                            <div className="mb-3">
                                <label
                                    htmlFor="passwordHash"
                                    className="form-label">password
                                </label>
                                <input
                                    type="password"
                                    className="form-control"
                                    id="passwordHash"
                                    username="passwordHash"
                                    value={passwordHash}
                                    onChange={(e) => setPasswordHash(e.target.value)}
                                />
                                {validationErrors.passwordHash != undefined &&
                                    <div className="flex flex-col">
                                        <small className="text-danger">
                                            {validationErrors.passwordHash[0]}
                                        </small >
                                    </div>
                                }
                            </div>
                            <div className="mb-3">
                                <label
                                    htmlFor="confirm_password"
                                    className="form-label">password confirmation
                                </label>
                                <input
                                    type="password"
                                    className="form-control"
                                    id="confirm_password"
                                    username="confirm_password"
                                    value={confirmPasswordHash}
                                    onChange={(e) => setConfirmPasswordHash(e.target.value)}
                                />
                            </div>
                            <div className="mb-3">
                                <label
                                    htmlFor="firstname"
                                    className="form-label">firstname address
                                </label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="firstname"
                                    username="firstname"
                                    value={firstname}
                                    onChange={(e) => { setFirstname(e.target.value) }}
                                />
                                {validationErrors.firstname != undefined &&
                                    <div className="flex flex-col">
                                        <small className="text-danger">
                                            {validationErrors.firstname[0]}
                                        </small >
                                    </div>
                                }

                            </div>
                            <div className="mb-3">
                                <label
                                    htmlFor="lastname"
                                    className="form-label">lastname address
                                </label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="lastname"
                                    username="lastname"
                                    value={lastname}
                                    onChange={(e) => { setLastname(e.target.value) }}
                                />
                                {validationErrors.lastname != undefined &&
                                    <div className="flex flex-col">
                                        <small className="text-danger">
                                            {validationErrors.lastname[0]}
                                        </small >
                                    </div>
                                }

                            </div>
                            <div className="mb-3">
                                <label
                                    htmlFor="genderId"
                                    className="form-label">Gender?
                                </label>
                                {/* <input
                                        type="genderId"
                                        className="form-control"
                                        id="genderId"
                                        username="genderId"
                                        value={genderId}
                                        onChange={(e) => { setGenderIdId(e.target.value) }}
                                    /> */}
                                <select type="number"
                                    className="form-control"
                                    id="genderId"
                                    username="genderId"
                                    value={genderId}
                                    onChange={(e) => {
                                        setGenderId(e.target.value)
                                    }}>
                                    <option value='1'>male</option>
                                    <option value='2'>female</option>
                                    <option value='3'>unknown</option>
                                </select>
                                {validationErrors.genderId != undefined &&
                                    <div className="flex flex-col">
                                        <small className="text-danger">
                                            {validationErrors.genderId[0]}
                                        </small >
                                    </div>
                                }

                            </div>
                            <div className="d-grid gap-2">
                                <button
                                    disabled={isSubmitting}
                                    type="submit"
                                    className="btn btn-primary btn-block">Register Now
                                </button>
                                <p
                                    className="text-center">Have already an account <Link to="/">Login here</Link>
                                </p>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}

export const Dashboard = () => {

    return (
        <>
            <Navigation />
        </>

    );
};


const UsersLogin = () => {
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")
    const [validationErrors, setValidationErrors] = useState(false);
    const [isSubmitting, setIsSubmitting] = useState(false);
    const navigate = useNavigate();
    const [user, error, loading, refetch] = useAxios({
        axiosInstance: axios,
        method: 'GET',
        url: '/api/users',
        requestConfig: {
            headers: {
                'Content-Language': 'en-US',
                //'Accept': 'text/html'
            }
        }
    });

    const loginAction = (e) => {
        e.preventDefault();
        setIsSubmitting(true);
        for (let data of user) {
            if (data.username == username) {
                console.log("he did it?");
                localStorage.setItem('user', JSON.stringify(data));
                navigate("/");
            }
        }
        setValidationErrors(true);
        setIsSubmitting(false);

    }


    return (
        // <article>

        //     <h2>Random Dad Joke</h2>

        //     {loading && <p>Loading...</p>}



        //     {!loading  && user && <p>{ console.log(user)}</p>}

        //     {!loading && !error && !user && <p>No dad joke to display</p>}

        //     <button onClick={() => refetch()}>Get user</button>
        // </article>
        <article>
            {/* {!loading && error && <p className="errMsg">{console.log(error)}</p>}  */}
            {!loading && user && <div className="row justify-content-md-center mt-5">
                <div className="col-4">
                    <div className="card">
                        <div className="card-body">
                            <h5 className="card-title mb-4">Sign In</h5>
                            <form onSubmit={(e) => { loginAction(e) }}>
                                {validationErrors != 0 &&
                                    <p className='text-center '><small className='text-danger'>Incorrect username or Password</small></p>
                                }

                                <div className="mb-3">
                                    <label
                                        htmlFor="username"
                                        className="form-label">
                                        username address
                                    </label>
                                    <input
                                        type="username"
                                        className="form-control"
                                        id="username"
                                        name="username"
                                        value={username}
                                        onChange={(e) => { setUsername(e.target.value) }}
                                    />
                                </div>
                                <div className="mb-3">
                                    <label
                                        htmlFor="password"
                                        className="form-label">Password
                                    </label>
                                    <input
                                        type="password"
                                        className="form-control"
                                        id="password"
                                        name="password"
                                        value={password}
                                        onChange={(e) => { setPassword(e.target.value) }}
                                    />
                                </div>
                                <div className="d-grid gap-2">
                                    <button
                                        disabled={isSubmitting}
                                        type="submit"
                                        className="btn btn-primary btn-block">Login</button>
                                    <p className="text-center">Don't have account? <Link to="/register">Register here</Link></p>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>}
        </article>
    );
}

export default UsersLogin;