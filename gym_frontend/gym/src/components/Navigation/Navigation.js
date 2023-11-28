import {useLocation, useNavigate} from "react-router-dom"
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import React, {useState} from "react";
import {useEffect} from "react";
import logo from "../../assets/logo.png";
import {toast} from "react-toastify";

const Navigation = () => {
    const navigate = useNavigate();
    const [user, setUser] = useState({})

    useEffect(() => {
        if (sessionStorage.getItem('user') == null || sessionStorage.getItem('user') == undefined || sessionStorage.getItem('user') == "") {
            navigate("/Login"); //if user doesnt exist return to login page
        } else {
            setUser(JSON.parse(sessionStorage.getItem('user')));
        }
    }, [])


    const logoutAction = () => {
        sessionStorage.clear();
        navigate("/Login");
        toast.success("Logout");
    }
    const location = useLocation()

    const pathname = location.pathname.toLowerCase();

    return (
        <div className="row justify-content-md-center">
            <div className="col-12">
                <Navbar expand="lg" className="bg-body-tertiary" bg="light" data-bs-theme="dark">
                    <Container>
                        <Navbar.Brand href="/">
                            <img
                            alt=""
                            src={logo}
                            height="40"
                            className="d-inline-block align-top"
                        /></Navbar.Brand>
                        <Nav className="me-auto">
                            <Nav.Link className={(pathname.includes("/customer")|| pathname==="/")?"active":""} href="/Customers">
                                Customers

                            </Nav.Link>
                            <Nav.Link className={pathname.includes("/subscription")?"active":""} href="/Subscriptions">
                                Subscriptions

                            </Nav.Link>

                            <Nav.Link className={pathname.includes("/history")?"active":""} href="/History">
                                History

                            </Nav.Link>

                        </Nav>
                        <Nav>
                            <NavDropdown title={"Welcome," + user.username + "!"} id="basic-nav-dropdown">
                                <NavDropdown.Item className={pathname.includes("/profile")?"active":""}
                                                  onClick={()=>{
                                    navigate("/profile", {state: user})
                                }} href="#">Profile</NavDropdown.Item>


                            </NavDropdown>
                            <Nav.Link  className={pathname.includes("/profile")?"active":""} onClick={() => logoutAction()}>
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