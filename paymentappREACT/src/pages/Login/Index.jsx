import { ButtonLogin } from "../../components/ButtonLogin/Index";
import { Input } from "../../components/Input/Index";
import { useState } from "react";
import { Label } from "../../components/Label/Index";
import axios from "axios";
import { ForgetPassword } from "../../components/ForgetPassword/Index";
import { Title } from "../../components/Title/Index";
import { ButtonCreateUser } from "../../components/ButtonCreateUser/Index";
import "./style.css";
import { Link } from "react-router-dom";
export const Login = () => {
  const [{ username, password }, setUserAndPassword] = useState({
    username: "",
    password: "",
  });

  const handleForm = (e) => {
    const name = e.target.name;
    const value = e.target.value;
    setUserAndPassword((state) => ({ ...state, [name]: value }));
  };


  async function loginIn() {
    const jwt = await axios.post(
      "https://paymentapiapp.herokuapp.com/payment-api/login",
      {
        login:username,
        password,
      }
    );
    

      console.log(jwt.data);
    
  }

  return (
    <div className="page">
      <div className="contentLogin">
        <Title text="$ Payment API $" />

        <div className="login">
          <Label htmlFor="login" text="Login:" />
          <Input
            type="text"
            id="login"
            name="username"
            value={username}
            onChange={handleForm}
          />
        </div>

        <div className="password">
          <Label htmlFor="password" text="Password:" />
          <Input
            type="password"
            id="password"
            name="password"
            value={password}
            onChange={handleForm}
          />
        </div>

        <ForgetPassword text="Forget your password?" type="button" />

        <ButtonLogin text="Sign In" type="button" onClick={loginIn} />

        <Link to="/register">
          <ButtonCreateUser text="Register" type="button" />
        </Link>
      </div>
    </div>
  );
};
