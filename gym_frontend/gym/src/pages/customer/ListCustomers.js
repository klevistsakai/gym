import React, { useEffect, useState } from "react";


import DataTable, { createTheme } from 'react-data-table-component';
import Service from "../../hook/Service";
import Navigation from "../../components/Navigation/Navigation";
import useAxiosFunction from "../../hook/useAxiosFunction";
import MyContainer from "../../components/UI/MyContainer";
import { Button } from "react-bootstrap";
import { Navigate, redirect, useNavigate } from "react-router-dom";
import { ArrowRight, CloudDownloadFill, Eye, Pencil, Trash } from "react-bootstrap-icons";
import axios from "../../api/gym";
import { toast } from "react-toastify";
import moment from "moment";
import { confirmAlert } from 'react-confirm-alert'; // Import
import 'react-confirm-alert/src/react-confirm-alert.css'; // Import css



export const ListCustomers = () => {
    const [result, error, loading, axiosFetch] = useAxiosFunction();
    const navigate = useNavigate();
    const [response, error2, loading2, reload] = Service({
        method: 'GET',
        url: '/api/customers',
    });


    const HistoryEvent = (customer) => {

        axiosFetch({
            axiosInstance: axios,
            method: 'POST',
            data: { customerId: customer.id, date: moment(new Date()).format("YYYY-MM-DD HH:mm:ss") },
            url: "/api/histories/save",
        });
        if (!error) {
            toast.success("Customer " + customer.firstname + " " + customer.lastname + " entered the gym!!");
        } else {
            toast.error(error)
        }

    }
    const onDeleteConfirmation = (customer_id) => {
        confirmAlert({
            title: 'Are your sure?',
            message: 'You are going to delete customer permanently!',
            buttons: [
                {
                    label: 'Yes',
                    onClick: () => Delete(customer_id)
                },
                {
                    label: 'No',
                    //onClick: () => alert('Click No')
                }
            ]
        });

    }

    const Delete = (customer_id) => {
        axiosFetch({
            axiosInstance: axios,
            method: 'DELETE',
            url: "/api/customers/" + customer_id,
        })
        if (error) {
            toast.error(error)
        } else {
            reload();
            toast.success("Customer Id:"+ customer_id + ",Deleted!")
           
        }
    }

    let columns = [
        {
            name: "ID",
            selector: row => row.id,
            sortable: true,
        },
        {
            name: "Firstname",
            selector: row => row.firstname,
            sortable: true,
        },
        {
            name: "Lastname",
            selector: row => row.lastname,
            sortable: true,
        },
        {
            name: "Birthday",
            selector: row => row.birthdate,
            sortable: true,
        },
        {
            name: "Gender",
            selector: row => row.gender.name,
            sortable: true,
        },

        {
            name: "Subscription Start",
            selector: row => row?.customerSubscription?.startDate,
            sortable: true,
        },

        {
            name: "Subscription End",
            selector: row => row?.customerSubscription?.endDate,
            sortable: true,
        },

        {
            name: "Action",
            cell: (row) => <div>
                <a className="btn text-primary btn-dark p-2 m-1" onClick={() => {

                    navigate("/customer/view", { state: row })
                }}>
                    <Eye></Eye>
                </a>

                <a className="btn text-warning btn-dark p-2 m-1" onClick={() => {

                    navigate("/customer/update", { state: row })

                }} color='yellow'> <Pencil></Pencil></a>

                <a className="btn text-success btn-dark p-2 m-1" onClick={() => {

                    HistoryEvent(row);

                }} color='yellow'><CloudDownloadFill /> </a>

                <a className="btn btn-dark p-2 m-1" onClick={() => {
                    onDeleteConfirmation(row.id);
                }}><Trash color='red'></Trash></a>
            </div>,

        },

    ]

    return (

        <MyContainer title='Customer List'>
            
            <Button variant="primary" type="button" className="float-end text-end" onClick={() => {


                navigate("/customer/insert")
            }}>
                Create Customer
            </Button>


            <DataTable
                defaultSortFieldId={1}
                theme="light"
                title="Customers"
                columns={columns}
                data={error2 ? toast.error(error2) : response}
                pagination
            />

        </MyContainer>
    )
}


