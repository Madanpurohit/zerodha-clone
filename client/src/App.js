
import OrderBook from './components/Trade/OrderBook';
import { SignIn } from './components/login/SignIn';
import { SignUp } from './components/login/SignUp';
import { Footer } from './components/navbar/Footer';
import {Header} from './components/navbar/Header';
import Ws from './components/orderbook/Ws';

function App() {
  return (
    <>
    <Header/>
    {/* <Ws/> */}
    <OrderBook/>
    <Footer/>
    </>
  );
}

export default App;
