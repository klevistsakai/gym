import { useNavigate } from "react-router-dom"
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import { Navigate } from "react-router-dom";
import React, { useState } from "react";
import { useEffect } from "react";

const Navigation = () => {
    const navigate = useNavigate();
    const [user, setUser] = useState({})

    useEffect(() => {
        if (localStorage.getItem('user') == null || localStorage.getItem('user') == undefined || localStorage.getItem('user') == "") {
            navigate("/Login"); //if user doesnt exist return to login page
        } else {
            setUser(JSON.parse(localStorage.getItem('user')));
        }
    }, [])
    // const checkUser = () => {
    //     console.log(localStorage.getItem('user'));
    //     if (localStorage.getItem('user') == null || localStorage.getItem('user') == undefined || localStorage.getItem('user') == "") {
    //         console.log("why3")

    //             return false;
    //     }
    //     console.log("why4")

    //     return true;
    // }
    const logoutAction = () => {
        localStorage.clear();
        navigate("/Login");}
    

    return (
        <div className="row justify-content-md-center">
            <div className="col-12">
                <Navbar expand="lg" className="bg-body-tertiary" bg="light" data-bs-theme="light">
                    <Container>
                        <Navbar.Brand href="/dashboard">Home</Navbar.Brand>
                        <Nav className="me-auto" >
                            <NavDropdown title="Customer" id="basic-nav-dropdown">
                                <NavDropdown.Item href="/customer/insert">Insert</NavDropdown.Item>
                                <NavDropdown.Item href="/customer/get"> GetAll </NavDropdown.Item>
                                <NavDropdown.Item href="/customer/update"> Update </NavDropdown.Item>
                                {/* <NavDropdown.Divider /> */}
                                <NavDropdown.Item href="/customer/delete"> Delete </NavDropdown.Item>
                            </NavDropdown>
                            <NavDropdown title="History" id="basic-nav-dropdown">
                                <NavDropdown.Item href="/history/insert">Insert</NavDropdown.Item>
                                <NavDropdown.Item href="/history/get"> GetAll </NavDropdown.Item>
                                <NavDropdown.Item href="/history/update"> Update </NavDropdown.Item>
                                {/* <NavDropdown.Divider /> */}
                                <NavDropdown.Item href="/history/delete"> Delete </NavDropdown.Item>
                            </NavDropdown>

                            <NavDropdown title="User" id="basic-nav-dropdown">
                                <NavDropdown.Item href="/user/insert">Insert</NavDropdown.Item>
                                <NavDropdown.Item href="/user/get"> GetAll </NavDropdown.Item>
                                <NavDropdown.Item href="/user/update"> Update </NavDropdown.Item>
                                {/* <NavDropdown.Divider /> */}
                                <NavDropdown.Item href="/user/delete"> Delete </NavDropdown.Item>
                            </NavDropdown>
                            <NavDropdown title="Dropdown" id="basic-nav-dropdown">
                                <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
                                <NavDropdown.Item href="#action/3.2">
                                    Another action
                                </NavDropdown.Item>
                                <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
                                <NavDropdown.Divider />
                                <NavDropdown.Item href="#action/3.4">
                                    Separated link
                                </NavDropdown.Item>
                            </NavDropdown>
                        </Nav>
                        <Nav>
                            <NavDropdown title={"Welcome," + user.username + "!"} id="basic-nav-dropdown">
                                <NavDropdown.Item href="#action/3.1">tab1</NavDropdown.Item>
                                <NavDropdown.Item href="#action/3.2">
                                    Another action
                                </NavDropdown.Item>
                                <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
                                <NavDropdown.Divider />
                                <NavDropdown.Item href="#action/3.4">
                                    Separated link
                                </NavDropdown.Item>
                            </NavDropdown>
                            <Nav.Link onClick={ () =>logoutAction()}>
                                Logout
                            </Nav.Link>
                        </Nav>
                    </Container>
                </Navbar>
            </div>
        </div>
    )

}

export default Navigation;