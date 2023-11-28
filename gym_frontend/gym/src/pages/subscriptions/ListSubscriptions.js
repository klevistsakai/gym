


import React, { useState } from "react";


import DataTable, { createTheme } from 'react-data-table-component';
import Service from "../../hook/Service";
import Navigation from "../../components/Navigation/Navigation";
import useAxiosFunction from "../../hook/useAxiosFunction";
import MyContainer from "../../components/UI/MyContainer";
import { Button } from "react-bootstrap";
import { Navigate, redirect, useNavigate } from "react-router-dom";
import { ArrowRight, Eye, Pencil, Trash } from "react-bootstrap-icons";
export const ListSubscriptions = () => {

    const navigate = useNavigate();

    let [data] = Service({
        method: 'GET',
        url: '/api/subscriptions'
    });




    let columns = [
        {
            name: "ID",
            selector: row => row.id,
            sortable: true,
        },
        {
            name: "Name",
            selector: row => row.planName,
            sortable: true,
        },
        {
            name: "Duration (months)",
            selector: row => row.duration,
            sortable: true,
        },
        {
            name: "Cost",
            selector: row => row.cost+"€",
            sortable: true,
        },
        {
            name: "Action",
            cell: (row) => <div>


                {/* <a className="btn text-warning btn-dark p-2 m-1" onClick={() => {

                    navigate("/customer/update", { state:row})

                }} color='yellow' >   <Pencil></Pencil></a> */}

                <a className="btn btn-dark p-2 m-1" onClick={() => {
                    console.log(this.props.navigation)
                    navigate("/customer/delete", { state:row})

                }}><Trash color='red' ></Trash></a>
            </div>,

        },

    ]

    return (

        <MyContainer title='Subscriptions List'>
            <Button variant="primary" type="button" className="float-end text-end" onClick={() => {


                navigate("/subscription/insert")
            }}>
                Create Subscription
            </Button>


            <DataTable
                defaultSortFieldId={1}
                theme="light"
                title="Subscriptions"
                columns={columns}
                data={data}

            />

        </MyContainer>
    )
}


