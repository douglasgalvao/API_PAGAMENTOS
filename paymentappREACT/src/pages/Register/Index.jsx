import "./style.css";
import { ButtonCreateUser } from "../../components/ButtonCreateUser/Index";
import { Title } from "../../components/Title/Index";
import { Input } from "../../components/Input/Index";
import { Label } from "../../components/Label/Index";
export const Register = () => {
  return (
    <div className="page">
      <div className="createUserContent">
        <Title text="Payment API" />
        <ButtonCreateUser text="Create User" type="button" />
      </div>
      <div className="inputsUserContent">
        <div className="LoginInput">
          <Label htmlFor="login" text="Login:" />
          <Input type="text" id="login" style={{width:"30vw",padding:"5px"}}/>
        </div>

        <div className="EmailInput">
          <Label htmlFor="email" text="Email:" />
          <Input type="text" id="email" style={{width:"30vw",padding:"5px"}}/>
        </div>

        <div className="PasswordInput">
          <Label htmlFor="password" text="Password:" />
          <Input type="password" id="passwordInput" style={{width:"30vw",padding:"5px"}}/>
        </div>

        <div className="PhoneNumberInput">
          <Label htmlFor="phone" text="PhoneNumber:" />
          <Input type="text" id="phoneInput" style={{width:"30vw",padding:"5px"}}/>
        </div>

        <div className="CPF">
          <Label htmlFor="email" text="CPF:" style={{color:"white"}} />
          <Input type="text" id="email" style={{width:"30vw",padding:"5px"}}/>
        </div>
      </div>
    </div>
  );
};
