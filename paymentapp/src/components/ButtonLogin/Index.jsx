import "./style.css";
export const ButtonLogin = (props) => {
  return (
    <button className="btnL" type={props.type} style={props.style}>
      <h4>{props.text}</h4>
    </button>
  );
};
