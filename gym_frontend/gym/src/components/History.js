
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


export const InsertHistory = () => {
    const navigate = useNavigate();
  const [date, setdate] = useState(new Date());
  const [username, setUsername] = useState("")
 

  const [confirmPasswordHash, setConfirmPasswordHash] = useState("")
  const [validationErrors, setValidationErrors] = useState({});
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [user, error, loading, axiosFetch] = useAxiosFunction();


  const handleSumbit = (e) => {
      e.preventDefault();
      setIsSubmitting(true)
      const payload = {
          username: username,
date:date
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


  
            <Form.Group as={Col} controlId="formGridusername">
                <Form.Label>username</Form.Label>
                <Form.Control type="text" placeholder="Enter username" value={username}
                    onChange={(e) => { setUsername(e.target.value) }} />
            </Form.Group>

        


        <Form.Group controlId="formGridLastname">
            <Form.Label>date</Form.Label>
            <Form.Control type="date" placeholder="date"
                onChange={(e) => {
                    setdate(e.target.value)
                }} />
        </Form.Group>


        <Button variant="primary" type="submit">
            Submit
        </Button>
    </Form>



    )

}

export const GetAllHistory = () => {
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
                            <td>username</td>
                    
                            <td>date</td>
                    
                        </tr>
                    </thead>
                    <tbody>
                        {
                            user.map(
                                user =>
                                    <tr key={user.id}>
                                        <td>{user.id}</td>
                                        <td> {user.username}</td>
                                        <td> {user.date}</td>
                                      
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


