import React from "react"
import Navigation from "../Navigation/Navigation";

export default class MyContainer extends React.Component {


    render() {

        const { children, title } = this.props;

        return <div style={{  }} >
            <Navigation></Navigation>



            <div className='children' id="myContainer">
                <h1 style={{ textAlign: "Center",padding:"0.1em" }}>{title??""}</h1>
                {children}
            </div>
        </div>
    }



}