export default class Service {

    sendMessage = (setLoading, text, setMessages, messages) => {
        setLoading(true)
        const myMessage = {name: "Красавчик", message: text}
        setMessages([myMessage, ...messages])
        fetch(`http://localhost:8080/newMessage?message=${text}`)
            .then((res) => {
                return res.json()
            })
            .then((y) => {
                setMessages([y, myMessage, ...messages])
                setLoading(false)
            })
    }
}