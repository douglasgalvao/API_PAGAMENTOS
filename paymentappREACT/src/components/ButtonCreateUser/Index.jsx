import "./style.css";
export const ButtonCreateUser = (props) => {
  return (
    <button className="btnCreateUser" type={props.type} style={props.style}>
      <h4>{props.text}</h4>
    </button>
  );
};
