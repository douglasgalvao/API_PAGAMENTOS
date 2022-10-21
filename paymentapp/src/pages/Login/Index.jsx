import { ButtonLogin } from "../../components/ButtonLogin/Index";
import { Input } from "../../components/Input/Index";
import { Label } from "../../components/Label/Index";
import { ForgetPassword } from "../../components/ForgetPassword/Index";
import { Title } from "../../components/Title/Index";
import { ButtonCreateUser } from "../../components/ButtonCreateUser/Index";
import "./style.css";
import { Link } from "react-router-dom";
export const Login = () => {
  return (
    <div className="page">
      <div className="contentLogin">
        <Title text="$ Payment API $" />

        <div className="login">
          <Label htmlFor="login" text="Login:" />
          <Input type="text" id="login" />
        </div>

        <div className="password">
          <Label htmlFor="password" text="Password:" />
          <Input type="password" id="password" />
        </div>

        <ForgetPassword text="Forget your password?" type="button" />
        <ButtonLogin text="Sign In" type="button" />
        <Link to="/register">
          <ButtonCreateUser text="Register" type="button" />
        </Link>
      </div>
    </div>
  );
};
