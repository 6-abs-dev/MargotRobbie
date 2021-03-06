import React, {useState, Fragment} from "react";
import FirstMargoImg from "../1.jpg";
import SecondMargoImg from "../3.jpg";
import Loader from "../loader/loader";

const Input = ({messages, setMessages, sendMessage}) => {

    const [text, setText] = useState("Пиши сюда...")
    const [isThinking, setIsThinking] = useState(false)
    const [image, setImage] = useState(FirstMargoImg)
    const [status, setStatus] = useState('\u{1F634}')

    const loaderComponent = () => {
        return (
            <Fragment>
                <Loader/>
            </Fragment>
        )
    }

    const inputFrame = () => {
        return (
            <Fragment>
                <p>Напиши <strong>мне</strong> прямо сейчас... Я жду.</p>
                <textarea onChange={(event => {
                    setText(event.target.value);
                    console.log(text)
                })} value={text} className="form" name="message" id="message"/>
                <br/>
                <button onClick={() => sendMessage(setIsThinking, text, setMessages, messages, setStatus)}
                        className="button-6"><span>Ляпнуть не подумав...</span>
                </button>
                <span className="bigFont"
                      onClick={() => {
                          fetch("http://localhost:8080/getSexyPhoto")
                              .then(response => response.text())
                              .then(url => {
                                  setMessages([{
                                      name: "Марго",
                                      image: url
                                  }, ...messages])
                              });

                      }}>&#128089;</span>

                <span className="bigFont"
                      onClick={() => {
                          setIsThinking(true)
                          setStatus('\u{1F914}')
                          fetch('http://localhost:8080/getRandomNumber')
                              .then((res) => {
                                  return res.json()

                              })
                              .then((y) => {
                                  console.log(y)
                                  setMessages([{
                                      name: "Марго",
                                      message: `Я загадала ${y}`
                                  }, ...messages])
                                  setIsThinking(false)
                                  setStatus('\u{1F60B}');
                              })
                      }}>&#127920;</span>
                <span className="bigFont"
                      onClick={() => {
                          console.log('Clicked!')
                          fetch('http://localhost:8080/getWeather')
                              .then((res) => {
                                  return res.json()
                              })
                              .then((y) => {
                                  const responseMessage = `Сейчас ${y.fact.temp} градусов и ${y.fact.condition}`
                                  setMessages([{
                                      name: "Марго",
                                      message: responseMessage,
                                  }, ...messages])
                              })
                      }}>&#9748;</span>
                <span className="bigFont"
                      onClick={() => {
                          setIsThinking(true)
                          setStatus('\u{1F914}')
                          fetch('http://localhost:8080/getCurrentDate')
                              .then((res) => {
                                  return res.text()
                              })
                              .then((y) => {
                                  setMessages([{
                                      name: "Марго",
                                      message: `Сейчас ${y}`
                                  }, ...messages])
                                  setIsThinking(false)
                                  setStatus('\u{1F60B}');
                              })
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

            <span id="status">{status}</span>
            {/*&#129300; 	&#128522; &#128519; &#129392; &#128525; &#129322; &#129395;*/}
            <div>
                <h1>Привет красавчик... Я <strong>Марго</strong>.</h1>
                {isThinking ? loaderComponent() : inputFrame()}
            </div>
        </div>
    );
}
export default Input;