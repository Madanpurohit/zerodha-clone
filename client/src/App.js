
import OrderBook from './components/Trade/OrderBook';
import { Trade } from './components/Trade/Trade';
import { SignIn } from './components/login/SignIn';
import { SignUp } from './components/login/SignUp';
import { Footer } from './components/navbar/Footer';
import {Header} from './components/navbar/Header';

function App() {
  return (
    <>
    <Header/>
    {/* <Ws/> */}
    <Trade/>
    <Footer/>
    </>
  );
}

export default App;
