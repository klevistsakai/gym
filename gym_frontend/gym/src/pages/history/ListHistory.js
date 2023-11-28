import React, { useEffect, useState } from "react";


import DataTable, { createTheme } from 'react-data-table-component';
import Service from "../../hook/Service";
import Navigation from "../../components/Navigation/Navigation";
import useAxiosFunction from "../../hook/useAxiosFunction";
import MyContainer from "../../components/UI/MyContainer";
import { Button } from "react-bootstrap";
import { Navigate, redirect, useNavigate } from "react-router-dom";
import { ArrowRight, Eye, Pencil, Trash } from "react-bootstrap-icons";
import axios from "../../api/gym";
import { toast } from "react-toastify";
import { confirmAlert } from "react-confirm-alert";

export const ListHistory = () => {


    const [user, error, loading, axiosFetch] = useAxiosFunction();
    const [response, error2, loading2, reload] = Service({
        method: 'GET',
        url: '/api/histories',
    });


    const onDeleteConfirmation = async (customer_id, callback) => {

        confirmAlert({
            title: 'Are your sure?',
            message: 'You are going to delete customer permanently!',
            buttons: [
                {
                    label: 'Yes',
                    onClick: () => axiosFetch({
                        axiosInstance: axios,
                        method: 'DELETE',
                        url: "/api/histories/delete/" + customer_id,

                        callback: function (result, error) {
                            if (!error) {

                                toast.success("history deleted!")
                                callback(result);

                            } else {

                                toast.error(error)
                            }


                        }
                    })

                },
                {
                    label: 'No',
                    // onClick: () => setConfirmation(false)
                }
            ]
        });

    }


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
        {
            name: "Action",
            cell: (row) => <div>


                <a className="btn btn-dark p-2 m-1" onClick={() => {
                    onDeleteConfirmation(row.id, () => {

                        reload()

                    });

                }}><Trash color='red'></Trash></a>
            </div>,

        },

    ]

    return (

        <MyContainer title='History List'>



            <DataTable
                defaultSortFieldId={3}
                theme="light"
                title="Customers Entered Gym"
                columns={columns}
                pagination
                data={!error2 ? response : toast.error(error)}

            />


        </MyContainer>
    )
}


