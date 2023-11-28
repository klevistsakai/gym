import {useEffect, useState} from "react";

import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Button from 'react-bootstrap/Button';
import useAxiosFunction from '../../hook/useAxiosFunction';
import Navigation from "../../components/Navigation/Navigation";
import axios from '../../api/gym';
import {useLocation, useNavigate, Link} from "react-router-dom";

import {ToastContainer, toast} from 'react-toastify';
import MyContainer from "../../components/UI/MyContainer";
import EmptyContainer from "../../components/UI/EmptyContainer";

const Login = () => {
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")
    const [validationErrors, setValidationErrors] = useState(false);
    const [isSubmitting, setIsSubmitting] = useState(false);
    const navigate = useNavigate();

    const [response, error, loading, axiosFetch] = useAxiosFunction();

    const handleSumbit = (e) => {
        e.preventDefault();
        // setIsSubmitting(true)
        const payload = {
            username: username,
            passwordHash: password,
        };


        axiosFetch({
            axiosInstance: axios,
            method: 'post',
            url: "api/users/login",
            data: payload,
            requestConfig: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            callback: function (result, error) {
                console.log(error);
                if (!error) {
                    console.log(result);
                    toast.success("Login")


                    sessionStorage.setItem('user', JSON.stringify(result));
                    navigate("/");

                    setValidationErrors(true);
                    setIsSubmitting(false);

                } else {

                    toast.error(error)
                }


            }
        });


    }


    return (

        <EmptyContainer title="Login">
        <article>
            {/* {!loading && error && <p className="errMsg">{console.log(error)}</p>}  */}
            {!loading && <div className="row justify-content-md-center mt-5">
                <div className="col-8">
                    <div className="">
                        <div className="card-body">

                            <Form onSubmit={(e) => {
                                handleSumbit(e)
                            }}>
                                {validationErrors != 0 &&
                                    <p className='text-center '><small className='text-danger'>Incorrect username or
                                        Password</small></p>
                                }

                                <div className="mb-3">
                                    <label
                                        htmlFor="username"
                                        className="form-label">
                                        Username
                                    </label>
                                    <input
                                        type="username"
                                        className="form-control"
                                        id="username"
                                        name="username"
                                        value={username}
                                        onChange={(e) => {
                                            setUsername(e.target.value)
                                        }}
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
                                        onChange={(e) => {
                                            setPassword(e.target.value)
                                        }}
                                    />
                                </div>
                                <div className="d-grid gap-2">
                                    <button
                                        disabled={isSubmitting}
                                        type="submit"
                                        className="btn btn-primary btn-block">Login
                                    </button>
                                    <p className="text-center">Don't have account? <Link to="/register">Register
                                        here</Link></p>
                                </div>
                            </Form>
                        </div>
                    </div>
                </div>
            </div>}
        </article>
        </EmptyContainer>
    );
}

export default Login;