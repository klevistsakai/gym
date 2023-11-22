import { useEffect, useState } from "react";

import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Button from 'react-bootstrap/Button';
import useAxiosFunction from '../../hook/useAxiosFunction';
import Navigation from "../../components/Navigation/Navigation";
import axios from '../../api/gym';
import { useNavigate, Link } from 'react-router-dom';
import Service from "../../hook/Service";
import { ToastContainer, toast } from 'react-toastify';
const CreateCustomer = () => {
    const navigate = useNavigate();
    const [firstname, setFirstname] = useState("")
    const [lastname, setLastname] = useState("")
    const [birthdate, setBirthdate] = useState(new Date());

    const [genderId, setGenderId] = useState(1)

    const [genders] = Service({
        method: 'GET',
        url: '/api/genders',
    });
    useEffect(() => {
        console.log(genders)
      }, []);
   

    const [confirmPasswordHash, setConfirmPasswordHash] = useState("")
    const [validationErrors, setValidationErrors] = useState({});
    const [isSubmitting, setIsSubmitting] = useState(false);
    const [response, error, loading, axiosFetch] = useAxiosFunction();


    const handleSumbit = (e) => {
        e.preventDefault();
        setIsSubmitting(true)
        const payload = {
            firstname: firstname,
            lastname: lastname,
            birthdate: birthdate,
            genderId: genderId
        };



        let promise = axiosFetch({
            axiosInstance: axios,
            method: 'post',
            url: '/api/customers/save',
            data: payload,
            requestConfig: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            callback: function (result, error) {
                if (!error) {
                    console.log(result);
                    toast.success("Customer saved!")
                    navigate('/');

                }
                else {

                    toast.error(error)
                }


            }
        });


    }


    return (<div>
        <Navigation />


        <Form className="w-50 p-3 col-lg-6 offset-lg-3" onSubmit={(e) => handleSumbit(e)} >


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
                        {genders.map((data) => {
                            return <Form.Check
                                type="radio"
                                key={data.id}
                                label={data.name}
                                name="genderId"
                                id={"gender" + data.id}
                                value={data.id}
                            />

                        })}

                    </Col>
                </Form.Group>
            </fieldset>

            <Button variant="primary" type="submit">
                Submit
            </Button>
        </Form>
    </div>


    )


}


export default CreateCustomer;