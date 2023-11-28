import React from "react"
import Navigation from "../Navigation/Navigation";
import img from "../../assets/logo.png";

export default class EmptyContainer extends React.Component {


    render() {

        const {children, title} = this.props;

        return <div style={{paddingTop:"2em"}}>




            <div className='children' id="myContainer">

                <div className="text-center align-items-center">
                    <img src={img} style={{maxHeight: 150}}/>
                </div>
                <h1 style={{textAlign: "Center", padding: "1em"}}>{title ?? ""}</h1>
                {children}
            </div>
        </div>
    }


}