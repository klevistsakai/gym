import React, {useState} from "react";


import DataTable, {createTheme} from 'react-data-table-component';
import Service from "../../hook/Service";
import Navigation from "../../components/Navigation/Navigation";
import useAxiosFunction from "../../hook/useAxiosFunction";
import MyContainer from "../../components/UI/MyContainer";
import {Button, Container} from "react-bootstrap";
import {Navigate, redirect, useLocation, useNavigate} from "react-router-dom";
import {ArrowRight, Eye, Pencil, Trash} from "react-bootstrap-icons";
import {toast} from "react-toastify";

export const ViewCustomer = () => {

    const navigate = useNavigate();
    const {state} = useLocation();

    function doesExistUser() {
        toast.error("Customer doesnt exist")
        navigate("/")
    }

    if (!state.id)
        doesExistUser();
    let [customer] = Service({
        method: 'GET',
        url: '/api/customers/' + state.id
    });

    let [histories] = Service({
        method: 'GET',
        url: '/api/histories/customer/' +state.id
    });


    let columns = [
        {
            name: "ID",
            selector: row => row.id,
            sortable: true,
        },
        {
            name: "Customer",
            selector: row => row.customer.firstname + " " + row.customer.lastname,
            sortable: true,
        },
        {
            name: "Date",
            selector: row => row.date,
            sortable: true,

        },
        ];

    return (

        <MyContainer title={"Customer: " + customer.firstname + " " + customer.lastname}>
            <div className="row">
                <div className="">
 <div style={{fontWeight:400,padding:"0.2em",fontSize:"1.4em"}}>Details</div>
                    <table className="display table " style={{width: "100%"}}>
                        <tbody>
                        <tr>
                            <th scope="col">Firstname</th>
                            <td>{customer.firstname}</td>

                        </tr>
                        <tr>
                            <th scope="col">Lastname</th>
                            <td>{customer.lastname}</td>

                        </tr>
                        <tr>
                            <th scope="col">Birthdate</th>
                            <td>{customer.birthdate}</td>

                        </tr>
                        <tr>
                            <th scope="col">Gender</th>
                            <td>{customer?.gender?.name}</td>

                        </tr>

                        <tr>
                            <th scope="col">Subscription Started</th>
                            <td>{customer?.customerSubscription?.startDate}</td>

                        </tr>

                        <tr>
                            <th scope="col">Subscription Ends</th>
                            <td>{customer?.customerSubscription?.startDate}</td>

                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <hr className="pt-4"/>
            <DataTable
                defaultSortFieldId={3}
                theme="light"
                title="Customer join us"
                columns={columns}
                pagination
                data={histories}

            />
        </MyContainer>
    )
}


