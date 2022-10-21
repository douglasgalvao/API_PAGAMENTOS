import { Button } from "../../components/Button/Index";
import "./style.css";
export const Login = () => {
  return (
    <div className="page">
      <div className="quadrado">
        <h3 className="fraseLogin">Payment API</h3>
        <div className="login">
          <h3>Login</h3>
          <label htmlFor="login"></label>
          <input type="text" id="login" />
        </div>

        <div className="password">
          <h3>Password</h3>
          <label htmlFor="password"></label>
          <input type="password" id="password" />
        </div>

        <Button text="Login"/>

      </div>
    </div>
  );
};
