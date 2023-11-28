import React, {useState} from "react"
import Navigation from "../Navigation/Navigation";
import Service from "../../hook/Service";
import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";


const SubscriptionCustomer = (props) => {

    const {customer, customerSubscription, onChange} = props;

    const [subscription, setSubscription] = useState(customerSubscription?.subscriptionId ? customerSubscription?.subscriptionId : 1)

    let [subscriptions] = Service({
        method: 'GET',
        url: '/api/subscriptions'
    });

    return <div style={{paddingTop: "1em"}}>

        {!customerSubscription ? <></> : (<div>
            <div className="w-100" style={{border: "1px dashed black"}}>
                CurrentStatus: Start Date: <span className="fw-bold">{customerSubscription.startDate}</span> - End
                Date: <span className="fw-bold">{customerSubscription.endDate}</span>
            </div>

        </div>)}
        <fieldset>
            <Form.Group as={Col} className="mb-3" value={subscription}
                        onChange={(e) => {
                            setSubscription(e.target.value);
                            onChange(e.target.value);
                        }}>
                <Form.Label as="legend" column sm={2}>
                    Subscription Plan
                </Form.Label>
                <Col sm={10}>
                    {subscriptions.map((data) => {
                        console.log(subscription,customerSubscription?.subscriptionId)
                        return <Form.Check
                            type="radio"
                            key={data.id}
                            defaultChecked={subscription == data.id}
                            label={data.planName + " (" + data.cost + "€)"}
                            name="subscriptionId"
                            className="d-inline-block pe-3"
                            id={"subscription" + data.id}
                            value={data.id}
                        />

                    })}

                </Col>
            </Form.Group>
        </fieldset>
    </div>


}

export default SubscriptionCustomer;