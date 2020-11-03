import React, {useState, Fragment} from "react";
import FirstMargoImg from "../1.jpg";
import SecondMargoImg from "../3.jpg";
import Loader from "../loader/loader";

const Input = ({messages, setMessages, sendMessage}) => {

    const [text, setText] = useState("Пиши сюда...")
    const [isThinking, setIsThinking] = useState(false)
    const [image, setImage] = useState(FirstMargoImg)

    const loaderComponent = () => {
        return (
            <Fragment>
                <Loader/>
                <p>Рита <strong>думает</strong> над ответом...<span className="bigFont">&#129300;</span> </p>

            </Fragment>
    )
    }

    const inputFrame = () => {
        return(
        <Fragment>
        <p>Напиши <strong>мне</strong> прямо сейчас... Я жду.</p>
        <textarea onChange={(event => {
            setText(event.target.value);
            console.log(text)
        })} value={text} className="form" name="message" id="message"/>
        <br/>
        <button
        onClick={() => {
            sendMessage(setIsThinking, text, setMessages, messages)
        }}
        className="button" type="submit" value="Ляпнуть не подумав...">
        Ляпнуть не подумав...
        </button>

        <span className="bigFont"
        onClick={() => {
            fetch("http://localhost:8080/image");
            //TODO Fix showing images.
            setMessages([{
                name: "Болина",
                image: "http://localhost:8080/image"
            }, ...messages])
        }}>&#128089;</span>

        <span className="bigFont"
        onClick={() => {
            setMessages([{
                name: "Болина",
                message: `Я загадала ${Math.floor(Math.random() * 1000)}`

            }, ...messages])
        }}>&#127920;</span>
        <span className="bigFont"
        onClick={() => {
            console.log('Clicked!')
            fetch('http://localhost:8080/getWeather')
                .then((res) => {
                    return res.json()
                })
                .then((y) => {
                    console.log(y.fact.temp)
                    console.log(y.fact.condition)
                    const responseMessage = `Сейчас ${y.fact.temp} градусов и ${y.fact.condition}`
                    setMessages([{
                        name: "Болина",
                        message: responseMessage,
                    }, ...messages])
                })
        }}>&#9748;</span>
        <span className="bigFont"
        onClick={() => {
            setMessages([{
                name: "Болина",
                message: `Сейчас ${new Date().toLocaleString("ru-RU")}`
            }, ...messages])
        }}>&#128197;</span>
        </Fragment>
        )
    }

    return (
        <div className="intro">
            <img className="rounded-circle" src={image} alt=""
                 onClick={() => {
                     console.log('clicked!');
                     if (image === FirstMargoImg) {
                         setImage(SecondMargoImg);
                     } else {
                         setImage(FirstMargoImg);
                     }
                 }}/>
            <div>
                <h1>Привет красавчик... Я <strong>Рита</strong>.</h1>
                {isThinking ? loaderComponent() : inputFrame()}
            </div>
        </div>
    );
    }
    export default Input;