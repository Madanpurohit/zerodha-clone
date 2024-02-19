import {Client} from '@stomp/stompjs';
import { useEffect, useState } from 'react';
function Ws(ticker = "BTC/USD"){
    const [message, setmessage] = useState("No Msg");
    // console.log(StompJs);
    // const stompClient = new StompJs.overWS('ws://localhost:9001/zerodha-clone')
    useEffect(() => {
        const client = new Client({
            brokerURL: 'ws://localhost:9001/zerodha',
            onConnect: () => {
              client.subscribe('/topic/greetings', (message) =>{
                console.log(`Received: ${message.body}`)
                console.log(message.body['ticker']);
                if(message.body[0]['ticker'] == ticker)
                    setmessage(message.body);
            });
              client.publish({ destination: '/app/orderList', body: 'ETH/USD' });

              client.subscribe("/topic/Details",msg=>{
                console.log(msg.body)
                setmessage(msg.body);
              })
            },
          });
          
          client.activate();
    
    }, [])
    
    return(
        <>{message}</>
    )
}

export default Ws;