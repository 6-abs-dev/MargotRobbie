import React, {Fragment, useState} from 'react';
import Input from "./input";
import Message from "./message";
import Service from "../services/service";

const App = () => {
    const [messages, setMessages] = useState([])
    const service = new Service();

    return (
        <Fragment>
            <Input
                messages={messages}
                setMessages={(...message) => setMessages(...message)}
                sendMessage={service.sendMessage}/>
            <br/>
            {messages.map(({name, message, image}) => {
                return (<Message key={Math.random()} name={name} message={message} image={image}/>)
            })}
        </Fragment>)
}

export default App