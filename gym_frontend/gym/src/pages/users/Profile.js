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
import Service from "../../hook/Service";
import EmptyContainer from "../../components/UI/EmptyContainer";

export const Profile = () => {
    const navigate = useNavigate();

    const {state} = useLocation();



    const [username, setUsername] = useState(state.username)
    const [passwordHash, setPasswordHash] = useState("")
    const [firstname, setFirstname] = useState(state.firstname)
    const [lastname, setLastname] = useState(state.lastname)
    const [genderId, setGenderId] = useState(state.genderId)

    const [confirmPasswordHash, setConfirmPasswordHash] = useState("")
    const [validationErrors, setValidationErrors] = useState({});
    const [isSubmitting, setIsSubmitting] = useState(false);
    const [user, error, loading, axiosFetch] = useAxiosFunction();
    const [genders] = Service({
        method: 'GET',
        url: '/api/genders',
    });

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
            method: 'put',
            url: '/api/users/update/'+state.id,
            data: payload,
            requestConfig: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            callback: function (data, error) {
                console.log(data);
                if (!error) {
                    console.log(data);
                    toast.success("Login")

                    localStorage.setItem('user', JSON.stringify(data));
                    navigate("/");

                } else {

                    toast.error(error)
                }


            }


        });
        setIsSubmitting(false)

    }

    return (
        <MyContainer title="Update">
            <div className="row justify-content-md-center">
                <div className="col-9">
                    <div className="">
                        <div className="">
                            <form onSubmit={(e) => { 
                                e.preventDefault();
                                (confirmPasswordHash == passwordHash)?handleSumbit(e) :  toast.error("Passwords Do Not Match!")}}>
                                <div className="">
                                    <label
                                        htmlFor="username"
                                        className="form-label">Username
                                    </label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        id="username"
                                        username="username"
                                        value={username}
                                        required
                                        onChange={(e) => {
                                            setUsername(e.target.value)
                                        }}
                                    />
                                    {validationErrors.username != undefined &&
                                        <div className="flex flex-col">
                                            <small className="text-danger">
                                                {validationErrors.username[0]}
                                            </small>
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
                                        required
                                        value={passwordHash}
                                        onChange={(e) => setPasswordHash(e.target.value)}
                                    />
                                    {validationErrors.passwordHash != undefined &&
                                        <div className="flex flex-col">
                                            <small className="text-danger">
                                                {validationErrors.passwordHash[0]}
                                            </small>
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
                                        required
                                        username="confirm_password"
                                        value={confirmPasswordHash}
                                        onChange={(e) => setConfirmPasswordHash(e.target.value)}
                                    />
                                </div>
                                <div className="mb-3">
                                    <label
                                        htmlFor="firstname"
                                        className="form-label">Firstname
                                    </label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        id="firstname"
                                        username="firstname"
                                        value={firstname}
                                        onChange={(e) => {
                                            setFirstname(e.target.value)
                                        }}
                                    />
                                    {validationErrors.firstname != undefined &&
                                        <div className="flex flex-col">
                                            <small className="text-danger">
                                                {validationErrors.firstname[0]}
                                            </small>
                                        </div>
                                    }

                                </div>
                                <div className="mb-3">
                                    <label
                                        htmlFor="lastname"
                                        className="form-label">Lastname
                                    </label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        id="lastname"
                                        username="lastname"
                                        value={lastname}
                                        onChange={(e) => {
                                            setLastname(e.target.value)
                                        }}
                                    />
                                    {validationErrors.lastname != undefined &&
                                        <div className="flex flex-col">
                                            <small className="text-danger">
                                                {validationErrors.lastname[0]}
                                            </small>
                                        </div>
                                    }

                                </div>
                                <div className="mb-3">
                                    <label
                                        htmlFor="genderId"
                                        className="form-label">Gender?
                                    </label>
                                    <select type="number"
                                            className="form-control"
                                            id="genderId"
                                            username="genderId"
                                            onChange={(e) => {
                                                console.log(e.target.value)
                                                setGenderId(e.target.value)
                                            }}>
                                        {genders.map((model) => {
                                            return <option  key={model.id} value={model.id}>{model.name}</option>
                                        })}

                                    </select>
                                    {validationErrors.genderId != undefined &&
                                        <div className="flex flex-col">
                                            <small className="text-danger">
                                                {validationErrors.genderId[0]}
                                            </small>
                                        </div>
                                    }

                                </div>
                                <div className="d-grid gap-2">
                                    <button
                                        disabled={isSubmitting}
                                        type="submit"
                                        className="btn btn-primary btn-block">Update
                                    </button>

                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </MyContainer>
    )
}
