import useAxiosFunction from '../hook/useAxiosFunction';
import useAxios from '../hook/useAxios';

import axios from '../api/gym';
import { useNavigate, Link } from 'react-router-dom';
import { useState } from 'react';
import React from "react";
import Navigation from "../components/Navigation/Navigation";
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Button from 'react-bootstrap/Button';


export const InsertCustomer = () => {
    const navigate = useNavigate();
  const [firstname, setFirstname] = useState("")
  const [lastname, setLastname] = useState("")
  const [birthdate, setBirthdate] = useState(new Date());

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
          lastname: lastname,
          birthdate:birthdate,
          genderId: genderId
      };
      // payload = JSON.stringify(payload);
      console.log(payload)
      axiosFetch({
          axiosInstance: axios,
          method: 'post',
          url: '/api/customers/save',
          data: payload,
          requestConfig: {
              'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
          },


      });
      setIsSubmitting(false)
      navigate('/');
      
  }



    return (<Form className="w-50 p-3 col-lg-6 offset-lg-3" onSubmit={(e) => handleSumbit(e)} >


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


        <Form.Group controlId="formGridLastname">
            <Form.Label>birthdate</Form.Label>
            <Form.Control type="date" placeholder="birthdate"
                onChange={(e) => {
                    setBirthdate(e.target.value)
                }} />
        </Form.Group>

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

export const GetAllCustomers = () => {
    const [user, error, loading, refetch] = useAxios({
        axiosInstance: axios,
        method: 'GET',
        url: '/api/customers',
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
                            <td>firstname</td>
                            <td>lastname</td>
                            <td>birthdate</td>
                            <td>gender</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            user.map(
                                user =>
                                    <tr key={user.id}>
                                        <td>{user.id}</td>
                                        <td> {user.firstname}</td>
                                        <td> {user.lastname}</td>
                                        <td> {user.birthdate}</td>
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


