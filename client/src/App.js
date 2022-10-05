import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Nav from "./components/Nav";
import Main from "./pages/Main";
import Shopping from "./pages/Shopping/Shopping";
import Community from "./pages/Community/Community";
import Info from "./pages/Community/Info";
import Hospital from "./pages/Community/Hospital";
import Protect from "./pages/Community/Protect";
import Lost from "./pages/Community/Lost";
import Notice from "./pages/Notice";
import FAQ from "./pages/FAQ";
import Meal from "./pages/Shopping/Category/Meal";
import Cookie from "./pages/Shopping/Category/Cookie";
import Vita from "./pages/Shopping/Category/Vita";
import AllVita from "./pages/Shopping/Category/AllVita";
import Pad from "./pages/Shopping/Category/Pad";
import Toy from "./pages/Shopping/Category/Toy";
import Posting from "./pages/Community/detail/Posting";
import Post from "./pages/Community/detail/Post";
import Mypage from "./pages/MyPage/Mypage";
import SignUp from "./pages/MyPage/Category/SignUp";
import SignIn from "./pages/MyPage/Category/SignIn";
import Items from "./pages/Shopping/Items";
import AddProduct from "./pages/Shopping/AddProduct";
import Cart from "./pages/MyPage/Category/Cart/Cart";
import CartBody from "./pages/MyPage/Category/Cart/CartBody";
import Wish from "./pages/MyPage/Category/Wish";
import Order from "./pages/MyPage/Category/Order";
import SuccessLogin from "./components/SuccessLogin";
import Addproduct from "./pages/Shopping/AddProduct";
import { useState } from 'react';
// import FAQPost from "./pages/FAQPost";
import FAQPost from "./pages/FAQ/FAQPost";
import FAQPage from "./pages/FAQ/FAQPage";
import NoticePost from "./pages/Notice/NoticePost";
import NoticePage from "./pages/Notice/NoticePage";


function App() {

    const [products, setProducts] = useState([]);
    const [cart, setCart] = useState([]);
  
    const convertPrice = (price) => {
      return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    };

  return (
    <div className="App">
      
      <Router>
          {sessionStorage.getItem('accessToken') ? <SuccessLogin /> : <Nav />}
            <Routes>
                <Route path="/" element={<Main />} />
                <Route path="/shopping" element={<Shopping />} />
                <Route path="/community" element={<Community />} />
                <Route path="/notice" element={<Notice />} />
                <Route path="/FAQ" element={<FAQ />} />

                <Route path="/FAQ/FAQPost" element={<FAQPost />} />
                <Route path="/FAQ/FAQPage/:boardId" element={<FAQPage/>} />
                
                <Route path="/notice/noticePost" element={<NoticePost/>} />
                <Route path="/notice/noticePage/:boardId" element={<NoticePage/>} />
                
                <Route path="/mypage" element={sessionStorage.getItem('accessToken') ? <Mypage /> : <SignIn />} />
                <Route path="/login" element={<SignIn />} />
                <Route path="/signup" element={<SignUp/>} />
                <Route path="/mypage/cart" element={<Cart cart={cart} setCart={setCart} convertPrice={convertPrice}/>} />
                <Route path="/mypage/cart" element={<CartBody cart={cart} setCart={setCart} convertPrice={convertPrice}/>} />
                <Route path="/mypage/wish" element={<Wish convertPrice={convertPrice} />} />
                <Route path="/mypage/order" element={<Order/>} />

                <Route path="/community/walk" element={<Community />} />
                <Route path="/community/info" element={<Info />} />
                <Route path="/community/hospital" element={<Hospital />} />
                <Route path="/community/protect" element={<Protect />} />
                <Route path="/community/lost" element={<Lost />} />
                <Route path="/community/posting" element={<Posting />}/>
                <Route path="/community/post/:boardId" element={<Post/>}/>

                <Route path="/shopping/add" element={<Addproduct />} />
                <Route path="/shopping/meal" element={<Meal convertPrice={convertPrice} />} />
                <Route path="/shopping/cookie" element={<Cookie convertPrice={convertPrice} />} />
                <Route path="/shopping/vita" element={<Vita />} />
                <Route path="/shopping/allVita" element={<AllVita />} />
                <Route path="/shopping/pad" element={<Pad />} />
                <Route path="/shopping/toy" element={<Toy />} />
                <Route path="/shopping/add" element={<AddProduct />} />
                <Route path="/shopping/item/:itemId" element={<Items 
                convertPrice={convertPrice}
                cart={cart}
                setCart={setCart}/>} />
            </Routes>
      </Router>

    </div>
  );
}

export default App;