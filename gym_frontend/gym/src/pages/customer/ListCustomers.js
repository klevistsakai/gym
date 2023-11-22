


import React, { useState } from "react";


import DataTable from 'react-data-table-component';
import Service from "../../hook/Service";
import Navigation from "../../components/Navigation/Navigation";
import useAxiosFunction from "../../hook/useAxiosFunction";
export const ListCustomers = () => {

    const [genders, setGenders] = useState([])
    const [user, error, loading, axiosFetch] = useAxiosFunction();

   function retreiveGenders(){
    // if(!genders.length)
    //  setGenders = Service({
    //     method: 'GET',
    //     url: '/api/customers'
    // }
        
    // );
    if(!genders.length)
    axiosFetch({
        method: 'GET',
        url: '/api/customers'
    }
        
    );
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
            name: "gender",
            selector: row => row.gender.name,
            sortable: true,
        }
    ]

    return (<div>
        <Navigation />
        <DataTable
        defaultSortFieldId={1}
        title="Customers"
            columns={columns}
            data={genders}
      
        />

    </div>
    )
}


