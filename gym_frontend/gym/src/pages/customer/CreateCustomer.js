import {useEffect, useState} from "react";

import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Button from 'react-bootstrap/Button';
import useAxiosFunction from '../../hook/useAxiosFunction';
import Navigation from "../../components/Navigation/Navigation";
import axios from '../../api/gym';
import {useLocation, useNavigate} from "react-router-dom";
import Service from "../../hook/Service";
import {ToastContainer, toast} from 'react-toastify';
import MyContainer from "../../components/UI/MyContainer";
import moment from "moment";
import SubscriptionCustomer from "../../components/UI/SubscriptionCustomer";

const CreateCustomer = () => {
    const navigate = useNavigate();

    let title = "Create Customer";

    let method = "create";
    const {state} = useLocation();
    let customer = null;
    if (state?.id) {
        method = "update";
        title = "Update Customer: " + state.firstname + " " + state.lastname;

        customer = state;
    }

    let temp_date = state?.birthdate ? moment(state.birthdate).format("YYYY-MM-DD") : moment(new Date()).format("YYYY-MM-DD");


    const [firstname, setFirstname] = useState(state?.firstname ?? "")
    const [lastname, setLastname] = useState(state?.lastname ?? "")
    const [birthdate, setBirthdate] = useState(temp_date);
    const [subscription, setSubscription] = useState(1);
    const [genderId, setGenderId] = useState(state?.genderId ? state?.genderId : 1)


    const [genders] = Service({
        method: 'GET',
        url: '/api/genders',
    });

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
            genderId: genderId,
            subscriptionId: subscription,
        };


        axiosFetch({
            axiosInstance: axios,
            method: 'post',
            url: (method == "create" ? '/api/customers/save' : '/api/customers/update/' + state.id) + "?subscriptionId=" + subscription,
            data: payload,
            requestConfig: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            callback: function (result, error) {
                if (!error) {
                    console.log(result);
                    toast.success("Customer saved!")
                    navigate('/customers');

                } else {

                    toast.error(error)
                }


            }
        });


    }

    return (
        <MyContainer title={title}>
            <div className="card">
                <div className="card-body">
                    <Form className="" onSubmit={(e) => handleSumbit(e)}>


                        <Row className="mb-3">
                            <Form.Group as={Col} controlId="formGridFirstname">
                                <Form.Label>Firstname</Form.Label>
                                <Form.Control type="text" placeholder="Enter firstname" value={firstname}
                                              onChange={(e) => {
                                                  setFirstname(e.target.value)
                                              }}/>
                            </Form.Group>

                            <Form.Group as={Col} controlId="formGridLastname">
                                <Form.Label>Lastname</Form.Label>
                                <Form.Control type="text" placeholder="Enter Lastname" value={lastname}
                                              onChange={(e) => {
                                                  setLastname(e.target.value)
                                              }}/>
                            </Form.Group>
                        </Row>


                        <Form.Group controlId="formGridLastname">
                            <Form.Label>Birthdate</Form.Label>
                            <Form.Control type="date" placeholder="birthdate"
                                          value={birthdate}
                                          onChange={(e) => {
                                              setBirthdate(e.target.value)
                                          }}/>
                        </Form.Group>

                        <fieldset>
                            <Form.Group as={Col} className="mb-3" value={genderId}
                                        onChange={(e) => {
                                            setGenderId(e.target.value)
                                        }}>
                                <Form.Label as="legend" column sm={2}>
                                    Gender
                                </Form.Label>
                                <Col sm={10}>
                                    {genders.map((data) => {

                                        return <Form.Check
                                            type="radio"
                                            key={data.id}
                                            defaultChecked={genderId == data.id}
                                            label={data.name}
                                            name="genderId"
                                            className="d-inline-block pe-3"
                                            id={"gender" + data.id}
                                            value={data.id}
                                        />

                                    })}

                                </Col>
                            </Form.Group>
                        </fieldset>

                        <SubscriptionCustomer customerSubscription={customer?.customerSubscription} customer={customer}
                                              onChange={(data) => setSubscription(data)}/>

                        <Button variant="primary" type="submit" className="w-25">
                            Submit
                        </Button>
                    </Form>
                </div>
            </div>
        </MyContainer>


    )


}


export default CreateCustomer;