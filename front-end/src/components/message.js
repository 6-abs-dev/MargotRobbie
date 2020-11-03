import React from "react";
import BolinaImg from "../1.jpg";
import KisaImg from "../2.jpg";

const Message = ({name, message, image}) => {
    const avatar = name.toLowerCase() === "болина" ? BolinaImg : KisaImg;

    return (<div className="message">
            <div>
                <img className="message-avatar" src={avatar} alt=""/>
            </div>
            <div>
                <h3>{name}</h3>
                <p>{message}</p>
                <img src={image} alt=""/>
            </div>
        </div>
    );
}

export default Message;